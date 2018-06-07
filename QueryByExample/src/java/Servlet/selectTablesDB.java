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
import MetaDataBase.getMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author carlos
 */
public class selectTablesDB extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String[] checbox = request.getParameterValues("tabla");
            String user = request.getParameter("user");
            String pass = request.getParameter("pass");
            String db = request.getParameter("db");                        
            
            getMetaData meta = new getMetaData(user,pass,db);
                        
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet selectTablesDB</title>");            
            out.println("</head>");
            out.println("<body>");                       
            
            int j = 1;
            for (int i = 0; i<checbox.length ; i++) { 
                    //arraylist que guarda los nombres de los campos para cuando se crea la tabla y los campos de texto
                    ArrayList<String> campoidAL = new ArrayList<>();
                            
                    out.println("<table  class=\"table table-hover table-bordered\">");
                        out.println("<tr>");
                            out.println("<th rowspan='2' >");
                                out.println("Tabla: " + checbox[i]);
                                out.println("<input type='hidden' name='tableNames' value='"+checbox[i]+"'>");
                            out.println("</th>");
                            ResultSet rsArray = meta.getColumnNames(checbox,i);

                            while (rsArray.next()) {
                                out.println("<th>");
                                    out.println("<label class='checkbox'>");
                                        out.println("<input type='checkbox' name='campoCheckSel' value='"+checbox[i]+"."+rsArray.getString("Field")+"'>");
                                        out.println("<b>"+ rsArray.getString("Field") +"</b>");   
                                        campoidAL.add(checbox[i]+"."+rsArray.getString("Field"));
                                    out.println("</label>");
                                out.println("</th>");          
                                j++;
                            }            
                            out.println("<input type='hidden' name='numColumnsTable' value='"+j+"'>");
                        out.println("</tr>"); 
                        
                        out.println("<tr>");
                        for(int k=1; k<j; k++){
                            out.println("<td>");
                                out.println("<input type='text' name='campoid' placeholder='operacion'>");
                                out.println("<input type='hidden' name='campoidAL' value='"+campoidAL.get(k-1)+"' placeholder='operacion'>");
                            out.println("</td>");
                        }
                        j=1;
                        out.println("</tr>");
                    out.println("<table>");                
                out.println("<br>");
            }
         } catch (SQLException ex) {
            Logger.getLogger(selectTablesDB.class.getName()).log(Level.SEVERE, null, ex);
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
