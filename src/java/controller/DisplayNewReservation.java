/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.microsoft.schemas._2003._10.serialization.arrays.ObjectFactory;
import domain.Customer;
import domain.DisplayRestaurant;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.tomcat.util.codec.binary.StringUtils;
import org.datacontract.schemas._2004._07.restobook_common_model.Reservation;

/**
 *
 * @author Mirko Manessi
 */
public class DisplayNewReservation extends HttpServlet
{
    // <editor-fold defaultstate="collapsed" desc="PROPERTIES">
    
    //</editor-fold>


    // <editor-fold defaultstate="collapsed" desc="CONSTRUCTOR">
    
    //</editor-fold>


    // <editor-fold defaultstate="collapsed" desc="PUBLIC METHODS">
    
    //</editor-fold>


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
                HttpSession session = request.getSession();
                if (request.getParameter("customerName") != null
                        && request.getParameter("customerEmail") != null
                        && request.getParameter("reservationPlaceQuantity") != null
                        //&& request.getParameter("reservationPlaceQuantity").matches("\\d")
                        && request.getParameter("reservationDate") != null
                        && request.getParameter("reservationService") != null)
                {
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
                    
                    
                    
                    String userName = request.getParameter("customerName");
                    String userMail = request.getParameter("customerEmail");
                    String userPhone = request.getParameter("customerPhone");
                    int reservationPlaceQuantity = Integer.parseInt(request.getParameter("reservationPlaceQuantity"));
                    String reservationDateString = request.getParameter("reservationDate");
                    String reservationService = request.getParameter("reservationService");
                    String reservationComments = request.getParameter("reservationComments");
                    
                    request.setAttribute("restaurant", restaurant);
                    request.setAttribute("customer", customer);
                    request.setAttribute("reservation", reservation);

                    session.setAttribute("restaurant", restaurant);
                    session.setAttribute("customer", customer);
                    session.setAttribute("reservation", reservation);
                    
                    // check if reservationdate is a valid date
                    try
                    {
                        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                        Date tempDate = df.parse(reservationDateString);
                        tempDate.setHours(Integer.parseInt(reservationService.substring(0, reservationService.indexOf(":"))));
                        tempDate.setMinutes(Integer.parseInt(reservationService.substring(reservationService.indexOf(":") + 1 ,reservationService.length())));
                        reservation.setReservationDate(tempDate);
                    } 
                    catch (Exception e)
                    {
                        RequestDispatcher view = request.getRequestDispatcher("displayNewReservation.jsp");
                        view.forward(request, response);
                    }
                    
                    
                    // Create a valid reservation object
                    
                    // Call the reservationManager
                    
                    // Return to the page in cas of problem
                    
                    // Go to the successful page in case of creation
                }

                if (session.getAttribute("customer") != null)
                {
                    //Customer customer = (Customer)session.getAttribute("customer");
                }
            }
        } catch (Exception e)
        {

        }
    }

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
