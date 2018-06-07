/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import MetaDataBase.getMetaData;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author carlos
 */
@WebServlet(name = "ExecuteQuery", urlPatterns = {"/ExecuteQuery"})
public class ExecuteQuery extends HttpServlet {

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
            /////////////////////////////////////////////////////////////////////////////////////////////////////////////
            //Arreglo que contiene el nombde de las tablas.
            String[] tableNames = {""};                     
            if(request.getParameterValues("tableNames")!=null){
                tableNames = request.getParameterValues("tableNames");     
            }            
            
            /////////////////////////////////////////////////////////////////////////////////////////////////////////////
            //Arreglo que contiene la cantidad de campos que tiene una tabla
            String[] numColumnsTable = {""};
            if(request.getParameterValues("numColumnsTable")!=null){
               numColumnsTable = request.getParameterValues("numColumnsTable");
            }
            
            /////////////////////////////////////////////////////////////////////////////////////////////////////////////
            //Arreglo que tiene los valores de los campos seleccionados en los checkbox
            String[] campoCheckSel = {""};
            if(request.getParameterValues("campoCheckSel")!=null){
                campoCheckSel = request.getParameterValues("campoCheckSel");
            }
            
            /////////////////////////////////////////////////////////////////////////////////////////////////////////////
            //Arreglo que contiene los datos de los campos que estan dentro de las tablas 
            //Junto con los checkbox
            String[] campoid = {""};
            if(request.getParameterValues("campoid")!=null){
                campoid = request.getParameterValues("campoid");
            }
            
            //Arreglo oculto que viene con los campos que tienen  datos
            String[] campoidAL = {""};
            if(request.getParameterValues("campoidAL")!=null){
                campoidAL = request.getParameterValues("campoidAL");
            }
            
            /////////////////////////////////////////////////////////////////////////////////////////////////////////////
            //Parametros que se utilizan para establecer la conexion de la base de datos.
            String user = request.getParameter("user");
            String pass = request.getParameter("pass");
            String db = request.getParameter("db");
            
            /////////////////////////////////////////////////////////////////////////////////////////////////////////////
            //Se toma la conexion para ejectar consultas
            getMetaData meta = new getMetaData(user,pass,db); 
            
            /////////////////////////////////////////////////////////////////////////////////////////////////////////////
            //Si el arreglo de checkbox no contiene nada se procede a esta parte
            if(campoCheckSel[0].equals("")){
                //Contador que sirve para contar que tabla se esta procesando
                int j = 0;
                
                //For que ejecuta el select * por tabla
                for(String table : tableNames){
                    //Obtenemos la cantidad de campos de la tabla para poder procesar la consulta
                    int cont = Integer.parseInt(numColumnsTable[j]);
                    
                    //Se crea la tabla 
                    out.println("<table class=\"table table-hover table-bordered\">");
                    out.println("<tr>");
                        out.println("<th colspan='"+cont+"'>");
                            out.println("Tabla: " + table);
                        out.println("</th>");
                    out.println("</tr>");
                    
                    //Resultset que se crea por tabla
                    ResultSet rs = meta.readTable(table);

                    //Se ejecutan las consultas de la tabla
                    while(rs.next()){                         
                        
                        //Se insertan los datos que tienen los campos de la tabla
                        out.println("<tr>");
                            for(int i=1 ; i < cont ; i++){
                                out.println("<td>");
                                    out.println(rs.getString(i));
                                out.println("</td>"); 
                            }
                        out.println("</tr>");
                    }
                    out.println("</table>");

                    j++;
                }
                /////////////////////////////////////////////////////////////////////////////////////////////////////////////
            
            }else if(!campoCheckSel[0].equals("")){ // Si el arreglo de checkbox tiene algo se procede a esta parte
                
                /////////////////////////////////////////////////////////////////////////////////////////////////////////////
                //revisar que campos tienen algo y en que posicion estan
                int auxCampos = 0;

                //que se solicita y selecciona             
                for (String campoid1 : campoid) {
                    if (!campoid1.equals("")) {
                        auxCampos++;
                    }
                }
                
                //Si no hay nada en los campos se ejecuta la consulta con los campos
                //seleccionados en el checkbox sin condiciones
                if( auxCampos == 0 ){
                    //Variable que sirve para armar la consulta en el select
                    String selectCampos = "";
                    
                    //Contador para el for siguiente
                    int i = 0;
                    
                    //Para tener conocimento de cuantos campos tiene la tabla seleccionados
                    int contCampos = campoCheckSel.length; 
                    
                    //Si hay mas de 1 campo seleccionado se arma la consulta con comas ,
                    if(contCampos>1){
                        for(i=0; i<(campoCheckSel.length - 1); i++){
                            selectCampos += campoCheckSel[i] + ",";
                        }
                    }
                    
                    //Se inserta el ultimo campo o el unico que quede
                    selectCampos += campoCheckSel[i];                                
                    
                    //Se ejecuta la consulta armada
                    ResultSet rs = meta.readTableCampos(selectCampos, tableNames[0]);
                    
                    //Obtenemos la cantidad de campos que tiene la tabla
                    int cont = Integer.parseInt(numColumnsTable[0]);
                    
                    //Se arma la tabla con los campos resultantes
                    out.println("<table class=\"table table-hover table-bordered\">");

                        out.println("<tr>");
                            out.println("<th colspan='"+cont+"'>");
                                out.println("Tabla: " + tableNames[0]);
                            out.println("</th>");
                        out.println("</tr>");

                    while(rs.next()){
                        out.println("<tr>");
                        for(int y = 1; y<contCampos+1 ; y++){
                            out.println("<td>"+rs.getString(y)+"</td>");
                        }
                        out.println("</tr>");
                    }             

                    out.println("</table>");
                    
                    /////////////////////////////////////////////////////////////////////////////////////////////////////////////
                }
                
                //De lo contrario si los campos de texto si tienen algo 
                //analizar los campos de texto y ejecutar las consultas que tengan
                if( auxCampos > 0 ){
                    //Variable que sirve para armar la consulta en el select
                    String selectCampos = "";
                    
                    //Contador para el for siguiente
                    int i = 0;
                    
                    //Para tener conocimento de cuantos campos tiene la tabla seleccionados
                    int contCampos = campoCheckSel.length; 
                    
                    //Si hay mas de 1 campo seleccionado se arma la consulta con comas ,
                    if(contCampos>1){
                        for(i=0; i<(campoCheckSel.length - 1); i++){
                            selectCampos += campoCheckSel[i] + ",";
                        }
                    }
                    
                    //Se inserta el ultimo campo o el unico que quede
                    selectCampos += campoCheckSel[i];  
                    
                    
                    /////////////////////////////////////////////////////////////////////////////////////////////////////////////
                    
                    //Parte que se ocupa para armar los where
                    
                    //Variable que sirve para elaborar la consulta con where
                    String whereCampos = "";              
                                                         
                    //Mapeo de las condiciones a sus campos
                    ArrayList<String> campoCondicion = new ArrayList<>();

                    for(int o = 0 ; o < campoidAL.length ; o++){
                        if(!campoid[o].equals("")){
                            if(campoid[o].contains("..")){ 
                                if(campoid[o].endsWith("..") && campoid[o].startsWith("..")){
                                    String value = campoid[o].substring(2,campoid[o].length()-2);
                                    
                                    campoCondicion.add(campoidAL[o] + " LIKE " + "'%" + value + "%'");
                                }else if(campoid[o].endsWith("..")){
                                    String value = campoid[o].substring(0,campoid[o].length()-2);
                                    
                                    campoCondicion.add(campoidAL[o] + " LIKE " + "'" + value + "%'");
                                }else if(campoid[o].startsWith("..")){
                                                                                                          
                                    String value = campoid[o].substring(2, campoid[o].length());
                                    
                                    campoCondicion.add(campoidAL[o] + " LIKE " + "'%" + value + "'");
                                }                                                         
                            }else{
                                campoCondicion.add(campoidAL[o] + campoid[o]);
                            }
                        }
                    }                    
                    
                    //Se arma la consulta del where    
                    int j = 0;                                        
                     
                    for(j=0 ; j<campoCondicion.size()-1  ; j++){
                        whereCampos += campoCondicion.get(j) + " AND ";                                                                                 
                    }                                       
                    whereCampos += campoCondicion.get(j);
                                        
                    //out.println("<b>SELECT</b> " + selectCampos + " <b>FROM</b> " + tableNames[0] + " <b>WHERE</b> " + whereCampos);
                    
                    //Se ejecuta la consulta y se guarda en un resultSet
                    ResultSet rs = meta.readTableCamposWConditions(selectCampos, whereCampos, tableNames[0]);                                        
                    
                    //Comprobamos que haya algo en la consulta si no devolvemos las cosas vacias
                    if(rs.next()){
                        //Si si hay algo en la consulta devolvemos el cursor al inicio
                        rs.previous();
                        
                        //Tabla con resultados vacios
                        out.println("<table class=\"table table-hover table-bordered\">");

                        out.println("<tr>");
                            out.println("<th colspan='"+campoid.length+"'>");
                                out.println("Tabla: " + tableNames[0]);
                            out.println("</th>");
                        out.println("</tr>");
                        
                        //Se crea la tabla con los resultados
                        while(rs.next()){
                            out.println("<tr>");
                            for(int y = 1; y < contCampos+1 ; y++){                                
                                out.println("<td>"+rs.getString(y)+"</td>");                                    
                            }

                        }
                                                
                    }else{
                        //Tabla con resultados vacios
                        out.println("<table class=\"table table-hover table-bordered\">");

                        out.println("<tr>");
                            out.println("<th colspan='"+campoid.length+"'>");
                                out.println("Tabla: " + tableNames[0]);
                            out.println("</th>");
                        out.println("</tr>");

                        out.println("<tr>");
                            out.println("<td>No se encontraron coincidencias</td>");
                        out.println("</tr>");         

                        out.println("</table>");
                    }
                    
                }                                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ExecuteQuery.class.getName()).log(Level.SEVERE, null, ex);
        }    }

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
