/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class conexxionMetaData {
    //Configuracion de los datos de la BD
    private String usuario = "";
    private String pass = "";
    private String host = "localhost";
    private String nombre_BD = "information_schema";
    
    private Connection con = null;
    
    public void set_user(String user){
        this.usuario = user;
    }
    
    public void set_pass(String pass){
        this.pass = pass;
    }
    
    public ResultSet getDBs(){
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance( );
            String servidor = "jdbc:mysql://"+host+"/"+nombre_BD;
            con = DriverManager.getConnection(servidor,this.usuario,this.pass);                        
            Statement st = con.createStatement();
            String query = "SELECT SCHEMA_NAME FROM SCHEMATA";
            ResultSet rs = st.executeQuery(query);
            return rs;              
        }catch(SQLException sql){
            return null;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
}

