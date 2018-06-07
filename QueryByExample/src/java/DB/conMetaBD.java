/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author carlos
 */
public class conMetaBD {
   //Configuracion de los datos de la BD
    private String usuario = "";
    private String pass = "";
    private String host = "localhost";
    private String nombre_BD = "";
    
    private Connection con = null;
    
    public void setUsuario(String user){
        this.usuario = user;
    }
    
    public void setPass(String pass){
        this.pass = pass;
    }
    
    public void setBD(String bd){
        this.nombre_BD = bd;
    }

    //Metodo que se devuelve la conexion o null si hubo un error
    public Connection getConexionMYSQL(){
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance( );
            String servidor = "jdbc:mysql://"+host+"/"+nombre_BD;
            con = DriverManager.getConnection(servidor,usuario,pass);
            return con;
        }catch(Exception e){
            e.printStackTrace();
            return con;
        }
    }
}
