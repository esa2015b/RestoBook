/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import domain.Customer;
import domain.DisplayRestaurant;
import domain.ErrorView;
import domain.Service;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.ValidationMgr;
import model.IValidationMgr;
import model.IPersistenceMgr;
import model.PersistenceMgr;

/**
 *
 * @author Mirko Manessi
 */
public class DisplayNewReservation extends HttpServlet
{
    // <editor-fold defaultstate="collapsed" desc="PROPERTIES">
    private IPersistenceMgr persistenceMgr;
    private IValidationMgr validationMgr;
    //</editor-fold>


    // <editor-fold defaultstate="collapsed" desc="CONSTRUCTOR">
    public DisplayNewReservation()
    {
        this.persistenceMgr = new PersistenceMgr();
        this.validationMgr = new ValidationMgr();
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
            throws ServletException, IOException
    {
        response.setContentType("text/html;charset=UTF-8");
        try
        {
            if (request.getParameter("action") != null && request.getParameter("action").equals("confirmReservation"))
            {
                ErrorView errors = new ErrorView();
                
                HttpSession session = request.getSession();
                if (request.getParameter("customerName") != null
                        && request.getParameter("customerEmail") != null
                        && request.getParameter("reservationPlaceQuantity") != null
                        //&& request.getParameter("reservationPlaceQuantity").matches("\\d")
                        && request.getParameter("reservationDate") != null
                        && request.getParameter("reservationService") != null)
                {
                    
                    // TODO : create a "required variables" verification, and return an errorlist if needed to the view.
                    
                    // Fetch the information from the session
                    domain.Reservation reservation = new domain.Reservation(0,
                                                                            0,
                                                                            0,
                                                                            null,
                                                                            request.getParameter("customerService"),
                                                                            Integer.parseInt(request.getParameter("reservationPlaceQuantity")),
                                                                            request.getParameter("reservationComments"));
                    domain.DisplayRestaurant restaurant = (DisplayRestaurant)session.getAttribute("restaurant");
                    domain.Customer customer = new Customer(0, 
                                                            request.getParameter("customerEmail"),
                                                            request.getParameter("customerPhone"),
                                                            request.getParameter("customerName"));
                    
                    // Fetch all the required variables from the request and fill the right objects.
                    customer.setName(request.getParameter("customerName"));
                    customer.setMail(request.getParameter("customerEmail"));
                    customer.setPhone(request.getParameter("customerPhone"));
                    
                    reservation.setPlaceQuantity(Integer.parseInt(request.getParameter("reservationPlaceQuantity")));
                    String reservationDateString = request.getParameter("reservationDate");
                    reservation.setService(request.getParameter("reservationService"));
                    reservation.setReservationComments(request.getParameter("reservationComments"));
                    
                    // Set the request/session variables (in case there's an error)
                    request.setAttribute("restaurant", restaurant);
                    request.setAttribute("customer", customer);
                    request.setAttribute("reservation", reservation);

                    session.setAttribute("restaurant", restaurant);
                    session.setAttribute("customer", customer);
                    session.setAttribute("reservation", reservation);
                    
                    // Check if service is a valid service format (hh:mm)
                    if (validationMgr.ValidateTime(reservation.getService()))
                    {
                        // check if reservationdate is a valid date
                        try
                        {
                            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                            Date tempDate = df.parse(reservationDateString);
                            tempDate.setHours(Integer.parseInt(reservation.getService().substring(0, reservation.getService().indexOf(":"))));
                            tempDate.setMinutes(Integer.parseInt(reservation.getService().substring(reservation.getService().indexOf(":") + 1 ,reservation.getService().length())));
                            reservation.setReservationDate(tempDate);
                            request.setAttribute("reservation", reservation);
                            session.setAttribute("reservation", reservation);
                            
                            boolean hasValidReservationDayAndShift = false;
                            
                            String resaDateStr = new SimpleDateFormat("EEEE", Locale.FRENCH).format(reservation.getReservationDate());
                            boolean foundService = false;
                            
                            for (Service service : restaurant.getServices())
                            {
                                String serviceDateStr = new SimpleDateFormat("EEEE", Locale.FRENCH).format(service.getServiceDate());
                                
                                if(resaDateStr.compareToIgnoreCase(serviceDateStr) == 0 && !foundService)
                                {
                                    int placeSeparator = reservation.getService().indexOf(":");
                                    int hours = Integer.parseInt(reservation.getService().substring(0, placeSeparator));
                                    //int minutes = Integer.getInteger(reservation.getService().substring(placeSeparator,reservation.getService().length()-1));
                                    if (hours >= service.getBeginShift() && hours <= service.getEndShift())
                                    {
                                        hasValidReservationDayAndShift = true;
                                        reservation.setServiceId(service.getId());
                                        foundService = true;
                                    }
                                }
                            }
                            if (!hasValidReservationDayAndShift)
                            {
                                errors.setError("No service shift on the requested date.");
                            }
                            if (errors.getErrors().isEmpty())
                            {
                                // Call the reservationManager
                                if(!this.persistenceMgr.CreateReservation(reservation, customer))
                                {
                                    errors.setError("An error occurred during the creation of your reservation.\r\nPlease try again, or contact the site administrator.");
                                }
                            }
                        } 
                        catch (Exception e)
                        {
                            errors.setError("The reservation date is invalid. Please enter in following format : dd/MM/yyy (e.g. : 21/06/2015)");
                        }
                    }
                    else
                    {
                        reservation.setReservationDate(new Date());
                        errors.setError("The service time has to be in format hh:mm (e.g. : 13:45)");
                    }
                    
                    // Set the request/session variables (in case there's an error)
                    request.setAttribute("restaurant", restaurant);
                    request.setAttribute("customer", customer);
                    request.setAttribute("reservation", reservation);

                    session.setAttribute("restaurant", restaurant);
                    session.setAttribute("customer", customer);
                    session.setAttribute("reservation", reservation);
                    
                    if (errors.getErrors().size() > 0)
                    {
                        // Return to the page with the errors in case of problem
                        request.setAttribute("errors", errors);
                        RequestDispatcher view = request.getRequestDispatcher("displayNewReservation.jsp");
                        view.forward(request, response);
                    }
                    else
                    {
                        // Go to the successful page in case of creation
                        RequestDispatcher view = request.getRequestDispatcher("displayConfirmation.jsp");
                        view.forward(request, response);
                    }
                    
                }
            }
        }
        catch (NumberFormatException | ServletException | IOException e)
        {

        }
    }
    //</editor-fold>
    
    
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
