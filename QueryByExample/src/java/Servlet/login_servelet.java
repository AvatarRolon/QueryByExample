/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import DB.conexxionMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author carlos
 */
public class login_servelet extends HttpServlet {

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
         try (PrintWriter out = response.getWriter()){
            //Parámetro de usuario
            String user = request.getParameter("user");
            String pass = request.getParameter("pass");
            
            //objeto de conexion
            conexxionMetaData meta = new conexxionMetaData();
            meta.set_user(user);
            meta.set_pass(pass);
            
            //Creación de la sesion
            HttpSession sesion = request.getSession();
                
            //Iniciar parámetros de la sesion
            sesion.setAttribute("user", user);
            
            //Iniciar parámetros de la sesion
            sesion.setAttribute("pass", pass);
            
            //comprobacion de el usuario y el password
            ResultSet rs = null;
                        
            
            rs = meta.getDBs();
            
            if(rs.next()){
                //Redireccionamos al inicio                 
                response.sendRedirect("jsp/inicio.jsp");
            }else{
                out.println("<p>KappaPride</p>");
                response.sendRedirect("index.jsp");
            }                         
        }catch(Exception e){            
            System.out.println("<p>Fallaste we</p>");            
        }
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
