/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MetaDataBase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DatabaseMetaData;
import javax.swing.JOptionPane;
import DB.conMetaBD;
import java.util.ArrayList;

/**
 *
 * @author carlos
 */
public class getMetaData {
    private conMetaBD conexion = new conMetaBD();
    private Connection con;
    private Statement st;
    private ResultSet rs;
    
    //Metodo que se usa para obtener la conexion con la base de datos
    public getMetaData(String user, String pass, String db) {
        try{
            conexion.setUsuario(user);
            conexion.setPass(pass);
            conexion.setBD(db);
            if((con = conexion.getConexionMYSQL())==null){
                JOptionPane.showMessageDialog(null,"Error con la conexion a la BD");
                return;
            }            
            st = con.createStatement();
        }catch(Exception e){
            e.printStackTrace();
        }
    }    
    
    //Metodo que se usa para extraer los metadatos de las tablas 
    //Es decir obtener los nombres de las tablas.
    public ResultSet getTables(){
        try{
            DatabaseMetaData metadatos = con.getMetaData();
            rs = metadatos.getTables(null, null, "%", null);
            return rs;
        }catch(Exception e){
            return null;
        }
    }
    
    //Metodo que permite extraer todos los nombres de los campos 
    public ResultSet getColumnNames(String[] tables, int i){
        try{
            String query = "SHOW COLUMNS FROM " + tables[i];
            rs = st.executeQuery(query);
            return rs;
        }catch(Exception e){
            return null;
        }
    }
    
    //Ejecutar una consulta de todos los campos en cualqueir tabla
    public ResultSet readTable(String table){
        try{
            String query = "SELECT * FROM " + table;
            rs = st.executeQuery(query);
            return rs;
        }catch(Exception e){
            return null;
        }        
    }
    
    //Ejecutar una consulta con los campos especificos de cualquier tabla
    public ResultSet readTableCampos(String campos, String table){
        try{
            String query = "select "+campos+" from "+table;
            rs = st.executeQuery(query);
            return rs;                        
        }catch(Exception e){
            return null;
        }
    }
    
    //Ejecutar una consulta con los campos específicos y con las condiciones correspondientes
    public ResultSet readTableCamposWConditions(String campos, String condiciones, String table){
        try{
            String query = "select " + campos + " from " + table + " where " + condiciones;
            rs = st.executeQuery(query);
            return rs;
        }catch(Exception e){
            return null;
        }
    }
    
}
