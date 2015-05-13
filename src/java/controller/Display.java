/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import domain.Customer;
import domain.DisplayRestaurant;
import domain.Reservation;
import java.io.IOException;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.DummyMgr;
import model.IDummyAble;
import model.IPersistenceMgr;
import model.PersistenceMgr;

/**
 *
 * @author Mirko Manessi
 */
public class Display extends HttpServlet {
    
    
    // <editor-fold defaultstate="collapsed" desc="PROPERTIES">
    private IPersistenceMgr persistenceMgr;
    private IDummyAble dummyMgr;
    // </editor-fold>
    
    
    // <editor-fold defaultstate="collapsed" desc="CONSTRUCTOR">
    public void init() throws ServletException {
        this.persistenceMgr = new PersistenceMgr();
        this.dummyMgr = new DummyMgr();
    }
    // </editor-fold>
    
    
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
            throws ServletException, IOException {
        try {
            if (request.getParameter("action") != null && request.getParameter("action").equals("newReservation"))
            {
                HttpSession session = request.getSession();
                DisplayRestaurant restaurant = new DisplayRestaurant();
                
                if (session.getAttribute("restaurant") != null)
                {
                    Object resto = session.getAttribute("restaurant");
                    restaurant = ((DisplayRestaurant)resto);
                }
                else
                {
                    restaurant = this.dummyMgr.getRdmRestaurant();
                }
                
                //Customer customer = new Customer(1,"mirko.manessi@gmail.com","(+32)485/84.27.66", "Mirko Manessi");
                //Reservation reservation = new Reservation(1, 1, 1, new SimpleDateFormat("dd/MM/yyyy").parse("23/06/2015"), "19:00", 5,"We are a party of 5, but could be joined by 3 more ladies, so please be advised to book a table for 8. We'll be staying late, as we celebrate a new contract. Advise your staff to stay after midnight.");
                Customer customer = new Customer(1,"","", "");
                Reservation reservation = new Reservation(0, 0, 0, new Date(), "", 2, "");
                
                request.setAttribute("restaurant", restaurant);
                request.setAttribute("customer", customer);
                request.setAttribute("reservation", reservation);
                
                session.setAttribute("restaurant", restaurant);
                session.setAttribute("customer", customer);
                session.setAttribute("reservation", reservation);
                
                RequestDispatcher view = request.getRequestDispatcher("displayNewReservation.jsp");
                view.forward(request, response);
            }
        } 
        catch (ServletException | IOException e) 
        {
            
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
