package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.{}
 */

/**
 *
 * @author VANESSA
 */
public class mdlConexion {
    
    private final String User="root";
    private final  String pass="";
        private final  String BD="agenda";
private final String puerto="3306";
private final String url="localhost";
private final String driver="jdbc:mysql://"+url+":"+puerto+"/"+BD;
private Connection con = null;
    
    public Connection getConexion() throws ClassNotFoundException{
    try{
    Class.forName("com.mysql.jdbc.Driver");
    con=DriverManager.getConnection(this.driver,this.User,this.pass);
    
    }catch(SQLException e){
        System.out.print(e);
   
   
     }catch(ClassNotFoundException ex){
       
    Logger.getLogger(mdlConexion.class.getName()).log(Level.SEVERE,null,ex);
    }
        return con;
        
  

}

}