<%-- 
    Document   : index
    Created on : 07-may-2018, 22:47:25
    Author     : carlos
--%>
<%@page import="java.sql.ResultSet"%>
<%@page import="javax.servlet.http.HttpSession"%>
<%@page import="DB.conexxionMetaData"%>

<%
    conexxionMetaData metaData = new conexxionMetaData();
    
     HttpSession sesion = request.getSession();
     
     String user = (String) sesion.getAttribute("user");
     String pass = (String) sesion.getAttribute("pass");
     
     metaData.set_user(user);
     metaData.set_pass(pass);
     
     ResultSet rs = metaData.getDBs();
  
%>

    <%@page contentType="text/html" pageEncoding="UTF-8"%>
        <!DOCTYPE html>
        <html>

        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>QBE</title>
            <link rel="stylesheet" type="text/css" href="../css/bootstrap.css">
            <link rel="stylesheet" type="text/css" href="../css/bootstrap-responsive.css">
            <script src="../js/code.jquery.com_jquery-3.1.1.min.js"></script>
            <script src="../js/bootstrap.js" ></script>       
        </head>

        <body>
            
            <div class="container-fluid">
                <center>
                    <h1>
                        Query By Example
                        <i class="icon-edit"></i>
                    </h1>
                </center>  
                <br><br>
                <div class="row">
                    <div class="span5 offset4">
                        <div class="alert alert-info">
                            <center><h3>Seleccione una base de datos</h3></center>                            
                        </div> 
                    </div>
                </div>
                <br>
                <%
                    while(rs.next()){
                        out.println("<div class='row'>");
                            out.println("<form class='form-inline' method='POST' action='./tables/index.jsp'>");                                
                                out.println("<div class='span2 offset5'");
                                    out.println("<label>");
                                        out.println(rs.getString("SCHEMA_NAME"));
                                        out.println("<input type='hidden' name='hdb' value='"+rs.getString("SCHEMA_NAME")+"'>");
                                    out.println("</label>");
                                out.println("</div>");
                                out.print("<button class='btn btn-info' type='submit'>"); 
                                    out.print("Seleccionar");
                                out.print("</button>");    
                                out.println("</form>");
                        out.println("</div>");
                    }
                %>            

            </div>                
        </body>

        </html>