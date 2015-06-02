/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import domain.ErrorView;
import domain.Reservation;
import domain.Restaurant;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.ws.WebServiceException;
import model.IPersistenceMgr;
import model.IValidationMgr;
import model.PersistenceMgr;
import model.ValidationMgr;

/**
 *
 * @author Mirko Manessi
 */
public class RestaurantReservations extends HttpServlet
{

    // <editor-fold defaultstate="collapsed" desc="PROPERTIES">
    private final IPersistenceMgr persistenceMgr;
    private final IValidationMgr validationMgr;
    private final ErrorView errors;
    //</editor-fold>


    // <editor-fold defaultstate="collapsed" desc="CONSTRUCTOR">
    public RestaurantReservations()
    {
        this.persistenceMgr = new PersistenceMgr();
        this.validationMgr = new ValidationMgr();
        this.errors = new ErrorView();
    }
    //</editor-fold>


    // <editor-fold defaultstate="collapsed" desc="PUBLIC METHODS">
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, java.lang.NullPointerException {
        response.setContentType("text/html;charset=UTF-8");
        
        HttpSession session = request.getSession();
        request.setAttribute("changes", "");
        String action = request.getParameter("action");
        int loginInt = 0;
        
        try {
        if (request.getParameter("login") != null)
        {
            String login = request.getParameter("login");
            String pwd = request.getParameter("password");
            if (login == ""){
                ControllerException error = new ControllerException("nameResto", "No login input.");
                request.setAttribute("error", error);
                RequestDispatcher view = request.getRequestDispatcher("errors.jsp");
                view.forward(request, response);
            }
            else loginInt = Integer.parseInt(login);
        }
        else if (session.getAttribute("loggedIn")!= null && session.getAttribute("loggedInRestaurantId") != null)
        {
            String login = session.getAttribute("loggedInRestaurantId").toString();
            loginInt = Integer.parseInt(login);
        }
        // TODO : once the loggin has been implemented, change this so that the restaurantId gets correctly set.
        int restaurantId = loginInt;
        
        // If the user is logged in and comes from the login form OR
        // If the user has already logged in and comes back to the reservation management page.
        if ((action != null && action.equals("myReservations")) /*&& loginInt > 0 && loginInt < 15)*/ || 
                (action != null && action.equals("myReservations") && session.getAttribute("loggedIn") != null && (boolean)session.getAttribute("loggedIn")))
        {
            // If this is the first time the user comes to the page (and isn't logged in yet),
            // create the session "loggedIn" variable.
            if (session.getAttribute("loggedIn") == null || (boolean)session.getAttribute("loggedIn"))
            {
                session.setAttribute("loggedIn", true);
                session.setAttribute("loggedInRestaurantId", loginInt);
            }
            ArrayList<Reservation> reservations = this.persistenceMgr.GetReservationsByRestaurantId(loginInt);
            Restaurant restaurant = this.persistenceMgr.getFullRestaurant(loginInt);

            // Set the reservations in session (for further use when saving changes)
            session.setAttribute("reservations", reservations);
            request.setAttribute("restaurant", restaurant);
            
            RequestDispatcher view = request.getRequestDispatcher("restaurantReservations.jsp");
            view.forward(request, response);
        }
        // If the user is logged in and submitted the changes for his reservation
        else if(session.getAttribute("loggedIn") != null && (boolean)session.getAttribute("loggedIn") 
                && action != null && action.equals("saveChanges"))
        {
            ArrayList<Reservation> initialReservations = (ArrayList<Reservation>) session.getAttribute("reservations");
            ArrayList<Reservation> reservationsToModify = new ArrayList<>();
            
            // Check for every initial reservation if the user has either confirmed or rejected the reservation.
            for (Reservation ir : initialReservations)
            {
                String confReq = "restaurantConfirmed" + ir.getId();
                String rejReq = "restaurantRejected" + ir.getId();
                if (request.getParameter(confReq) != null || request.getParameter(rejReq) != null)
                {
                    String restaurantConfirmed = request.getParameter(confReq) == null ? ir.getRestoConfirmationChecked() : request.getParameter(confReq);
                    String restaurantRejected = request.getParameter(rejReq) == null ? ir.getRestoRejectedChecked() : request.getParameter(rejReq);
                    
                    //restaurantConfirmed.compareToIgnoreCase(ir.getRestoConfirmationChecked())
                    
                    if (restaurantConfirmed.compareToIgnoreCase(ir.getRestoConfirmationChecked()) != 0 || restaurantRejected != ir.getRestoRejectedChecked())
                    {
                        Reservation r = new Reservation();
                        r.setId(ir.getId());
                        r.setCustomerId(ir.getCustomerId());
                        r.setCustomerMail(ir.getCustomerMail());
                        r.setCustomerPhone(ir.getCustomerPhone());
                        r.setPlaceQuantity(ir.getPlaceQuantity());
                        r.setReservationComments(ir.getReservationComments());
                        r.setReservationDate(ir.getReservationDate());
                        r.setRestoComments(ir.getRestoComments());
                        r.setService(ir.getService());
                        r.setServiceId(ir.getServiceId());
                        
                        
                        r.setRestoConfirmation(restaurantConfirmed.equals("checked"));
                        if (restaurantConfirmed.equals("checked") && !ir.getRestoConfirmation())
                        {
                            r.setRestoConfirmationDate(new Date());
                            r.setIsEnable(true);
                        }
                        if (!restaurantConfirmed.equals("checked") && restaurantRejected.equals("checked"))
                        {
                            r.setRestoRejected(true);
                            r.setRestoConfirmationDate(new Date());
                            r.setIsEnable(false);
                            //LocalDate l = LocalDate.MIN;
                        }
                        
                        reservationsToModify.add(r);
                    }
                }
            }
            boolean successful = false;
            
            if (reservationsToModify.size() > 0)
            {
                try
                {
                    // Call the persistencemanager and send the modification to the restobook webservice.
                    successful = this.persistenceMgr.ModifyReservations(reservationsToModify);
                }
                catch (DatatypeConfigurationException ex)
                {
                    Logger.getLogger(RestaurantReservations.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            ArrayList<Reservation> reservations = this.persistenceMgr.GetReservationsByRestaurantId(loginInt);
            Restaurant restaurant = this.persistenceMgr.getFullRestaurant(loginInt);
            
            // Set the reservations in session (for further use when saving changes)
            if (successful)
            {
                request.setAttribute("changes", "Your changes have been committed.");
            }
            else if(reservationsToModify.size() == 0)
            {
                request.setAttribute("changes", "No changes requested. Reservations that have been confirmed cannot be undone.");
            }
            else
            {
                ErrorView errors = new ErrorView();
                errors.setError("Something went wrong during the change request, please verify your previous work.");
                request.setAttribute("errors", this);
            }
            session.setAttribute("reservations", reservations);
            request.setAttribute("restaurant", restaurant);
            
            RequestDispatcher view = request.getRequestDispatcher("restaurantReservations.jsp");
            view.forward(request, response);
        }
        // If the user isn't logged in
        else
        {
            this.errors.setError("Sorry, you're not allowed to view this page!");
            request.setAttribute("errors", errors);
            RequestDispatcher view = request.getRequestDispatcher("home.jsp");
            view.forward(request, response);
        }
        }
        
        catch (java.lang.NullPointerException e){
            ControllerException error = new ControllerException("exception", "NullPointerException. Please contact RestoBook hotline.");
           request.setAttribute("error", error);
           RequestDispatcher view = request.getRequestDispatcher("errors.jsp");
           view.forward(request, response); 
        }
        
        catch (WebServiceException e)
        {
            ControllerException error = new ControllerException("exception", "WebServiceException. Web Service not available. Please contact RestoBook hotline.");
                    request.setAttribute("error", error);
                    RequestDispatcher view = request.getRequestDispatcher("errors.jsp");
                    view.forward(request, response);
        }
        catch (Exception e)
        {
           ControllerException error = new ControllerException("exception", "Please try later or contact RestoBook hotline");
           request.setAttribute("error", error);
           RequestDispatcher view = request.getRequestDispatcher("errors.jsp");
           view.forward(request, response);     
        }
    }
    // </editor-fold>

    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
