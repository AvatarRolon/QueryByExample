<%-- 
    Document   : index
    Created on : 07-may-2018, 22:47:25
    Author     : carlos
--%>

    <%@page contentType="text/html" pageEncoding="UTF-8"%>
        <!DOCTYPE html>
        <html>

        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>QBE</title>
            <link rel="stylesheet" type="text/css" href="./css/bootstrap.css">
            <link rel="stylesheet" type="text/css" href="./css/bootstrap-responsive.css">
            <script src="./js/code.jquery.com_jquery-3.1.1.min.js" integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8=" crossorigin="anonymous"></script>
            <script src="./js/bootstrap.js" ></script>
            
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
                            <center><h3>Conéctate a <b>Mysql</b> </h3></center>                            
                        </div> 
                    </div>
                </div>
                <br><br>
                <div class="row">
                    <div class="span5 offset4">
                        <form class="form-horizontal" method="POST" action="login_servelet">
                            <div class="control-group">
                                <label class="control-label" for="user">Usuario:</label>
                                <div class="controls">
                                    <input type="text" placeholder="Usuario" id="user" name="user" autocomplete="off" required>
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label" for="pass">Password:</label>  
                                <div class="controls">
                                    <input type="password" placeholder="Password" name="pass" id="pass" autocomplete="off" required>
                                </div>                                
                            </div>
                            <div class="control-group">
                                <div class="controls">
                                  <button class="btn btn-primary" type="submit">
                                    Entrar &nbsp;&nbsp;&nbsp;
                                    <i class="icon-arrow-right icon-white"></i>
                                </button>  
                                </div>    
                            </div>                            
                        </form>
                    </div>
                </div>
            </div>            
        </body>

        </html>