package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import domain.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import model.*;

/**
 *
 * @author Thibaut
 */
public class RestoWeb extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {

            /**
            *displayResto action == "I feel lucky" in navbar
            */
            if (request.getParameter("action") != null && request.getParameter("action").equals("displayResto")){
                DummyMgr mgr = new DummyMgr();
                
                DisplayRestaurant restaurant = new DisplayRestaurant();
                
                if (request.getParameterMap().containsKey("id"))
                {
                    restaurant = mgr.getRestaurant(Integer.parseInt(request.getParameter("id")));
                }else{
                    restaurant = mgr.getRdmRestaurant();
                }

                HttpSession session = request.getSession();
                session.setAttribute("restaurant", restaurant);
                request.setAttribute("restaurant", restaurant); 

                RequestDispatcher view = request.getRequestDispatcher("display.jsp");
                view.forward(request, response);
            }
            
            /**
             * display one Restaurant search by his name in navBar
             */
            else if (request.getParameter("action") != null && request.getParameter("action").equals("searchResto")){
                
                List<LightRestaurant> restaurants = new ArrayList<LightRestaurant>();
                DummyMgr mgr = new DummyMgr();
                
                String name = request.getParameter("name");
                restaurants = mgr.getRestaurantByName(name);
                    
                if (restaurants.isEmpty()){
                    ControllerException error = new ControllerException("nameResto", "No results found.");
                    request.setAttribute("error", error);
                    RequestDispatcher view = request.getRequestDispatcher("errors.jsp");
                    view.forward(request, response);
                }else{
                    HttpSession session = request.getSession();
                    session.setAttribute("restaurants", restaurants);
                    request.setAttribute("restaurants", restaurants); 

                    RequestDispatcher view = request.getRequestDispatcher("searchResults.jsp");
                    view.forward(request, response);
                }
            }
            /**
             * display data for a reservation
             */
            else if (request.getParameter("action") != null && request.getParameter("action").equals("advancedSearch")){
                
                
                List<LightRestaurant> restaurants = new ArrayList<LightRestaurant>();
                DummyMgr mgr = new DummyMgr();
                
                String name = request.getParameter("name");
                String type = request.getParameter("type");
                String city = request.getParameter("city");
                
                restaurants = mgr.getRestaurantAdvanced(name,type,city);
                    
                if (restaurants.isEmpty()){
                    ControllerException error = new ControllerException("nameResto", "No results found.");
                    request.setAttribute("error", error);
                    RequestDispatcher view = request.getRequestDispatcher("errors.jsp");
                    view.forward(request, response);
                }else{
                    HttpSession session = request.getSession();
                    session.setAttribute("restaurants", restaurants);
                    request.setAttribute("restaurants", restaurants); 

                    RequestDispatcher view = request.getRequestDispatcher("searchResults.jsp");
                    view.forward(request, response);
                }
                
            }
            else if (request.getParameter("action") != null && request.getParameter("action").equals("sendReservation")){
                
                Customer customer = new Customer();
                Reservation reservation = new Reservation();
                HttpSession session = request.getSession();
                
                //datas coming from form in page "displayResults"
                customer.setMail(request.getParameterValues("customermail")[0]);
                customer.setPhone(request.getParameterValues("customerphone")[0]);
                reservation.setPlaceQuantity(Integer.parseInt(request.getParameterValues("placequantity")[0]));
                //reservation.setReservationDate((Date)request.getParameterValues("reservationdate")[0]);
                reservation.setService(request.getParameterValues("service")[0]);

                //request.setAttribute("customer", customer);
                session.setAttribute("customer", customer);
                //request.setAttribute("reservation", reservation);
                session.setAttribute("reservation", reservation);
                
                RequestDispatcher view = request.getRequestDispatcher("displayReservation.jsp");
                view.forward(request, response);
                
            }
           /**
            * must be update to send datas to DB
            */
           else if (request.getParameter("action") != null && request.getParameter("action").equals("confirmReservation")){              
   
                RequestDispatcher view = request.getRequestDispatcher("displayConfirmation.jsp");
                view.forward(request, response);
           }
            
           /**
            * Must be implemented with webservice
            */
            else if (request.getParameter("action") != null && request.getParameter("action").equals("advancedsearchResto")){  
                RequestDispatcher view = request.getRequestDispatcher("displayResults.jsp");
                view.forward(request, response);  
            }
                    
        } finally {            
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
