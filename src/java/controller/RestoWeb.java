package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import domain.*;
import javax.servlet.RequestDispatcher;
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
            if (request.getParameter("action") != null && request.getParameter("action").equals("displayResto")) {
                
                IDummyAble dummy = new DummyMgr();
                Restaurant resto = null;
                
                if(request.getParameter("id") != null){
                    resto = dummy.getRestaurant(Integer.parseInt(request.getParameter("id")));
                }else{
                    resto = dummy.getRdmRestaurant();
                }
                
                request.setAttribute("restaurant", resto);   
                
                RequestDispatcher view = request.getRequestDispatcher("display.jsp");
                view.forward(request, response);
        
            }else if (request.getParameter("action") != null && request.getParameter("action").equals("searchResto")) {
                
                IDummyAble dummy = new DummyMgr();
                Restaurant[] restaurants = null;
                
                restaurants = dummy.getAllRestaurant();
                
                request.setAttribute("restaurants", restaurants); 
                
                RequestDispatcher view = request.getRequestDispatcher("searchResults.jsp");
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
