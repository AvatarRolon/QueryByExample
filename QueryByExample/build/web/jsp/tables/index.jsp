<%@page import="java.sql.ResultSet"%>
<%@page import="MetaDataBase.getMetaData"%>

<%

String bd = request.getParameter("hdb");

//Tomar las variables de sesion el usuario y el pass
HttpSession sesion = request.getSession();
String user = (String) sesion.getAttribute("user");
String pass = (String) sesion.getAttribute("pass");
            
getMetaData metadata = new getMetaData(user, pass, bd);
            
ResultSet rs = metadata.getTables();        

//Recibimiento de los checkbox
if(request.getParameterValues("tabla") !=null){
    String check[] = request.getParameterValues("tabla");
   
    for(int i = 0; i<check.length ; i++){
        System.out.println(check[i]);
    }
}

%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>QBE</title>
        <link rel="stylesheet" type="text/css" href="../../css/bootstrap.css">
        <link rel="stylesheet" type="text/css" href="../../css/bootstrap-responsive.css">
        <link rel="stylesheet" type="text/css" href="../../css/resultTables.css">
        <script src="../../js/code.jquery.com_jquery-3.1.1.min.js" integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8=" crossorigin="anonymous"></script>
        <script src="../../js/bootstrap.js" ></script>      
        <script src="../../js/index.js" ></script>      
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
                    <form id="formExec">
                        <% 
                            out.println("<input type='hidden' name='user' value='"+user+"'>");
                            out.println("<input type='hidden' name='pass' value='"+pass+"'>");
                            out.println("<input type='hidden' name='db' value='"+bd+"'>");
                        %>
                        <div class="row">  

                            <center>
                                <div class="btn-group">

                                    <button type="button" class="btn btn-info" id="execute">                            
                                        <i class="icon-ok icon-white"></i>
                                        Ejecutar
                                    </button>
                                    <!--a class="btn btn-info">
                                        <i class="icon-eye-open icon-white"></i>
                                        Mostrar/ocultar SQL
                                    </a-->  
                                    <a href="#myModal" role="button" data-toggle="modal" class="btn btn-inverse">
                                        <i class="icon-plus icon-white"></i>
                                        Añadir/Quitar tabla
                                    </a> 

                                </div>  
                            </center>
                        </div>
                        <div class="row" id="resultTables">

                        </div>
                    </form>
                <br>                
        </div>                              
                
        <div id="myModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                <h3 id="myModalLabel">Agregar/Quitar tablas</h3>
            </div>
            <div class="modal-body"> 
                <form id="formTables">
                    <%
                        out.println("<input type='hidden' name='user' value='"+user+"'>");
                        out.println("<input type='hidden' name='pass' value='"+pass+"'>");
                        out.println("<input type='hidden' name='db' value='"+bd+"'>");
                        while(rs.next()){  
                            out.println("<label class='checkbox'>");
                                out.println("<input type='checkbox' name='tabla' value='"+rs.getString(3)+"'>"+rs.getString(3));
                            out.println("</label>");                            
                        }
                        
                        out.println("<input type='hidden' name='hdb' value='"+bd+"'>");
                    %>                                    
            </div>
            <div class="modal-footer">
                    <button class="btn btn-danger" data-dismiss="modal" aria-hidden="true" type="button">Cancelar</button>                
                    <button class="btn btn-primary" type="button" id="btnTables">Seleccionar tablas</button>
                </form>
            </div>
        </div>
            
        <div id="myModalExec" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                <h3 id="myModalLabel">Resultados</h3>
            </div>
            <div class="modal-body" id="resultExec"> 
                                                   
            </div>
            <div class="modal-footer">
                    <button class="btn btn-danger" data-dismiss="modal" aria-hidden="true" type="button">Cerrar</button>                
            </div>
        </div>
    </body>
</html>
