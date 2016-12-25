/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mypackage.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.Cookie;

/**
 *
 * @author admin
 */
public class DbControler {
    
    
   Connection conn = null;
   private String CookieName = "ACliger";

    public DbControler()
    {
       try {
           conn = DataSource.getInstance().getConnection();
                
           
       } catch (SQLException ex) {
           Logger.getLogger(DbControler.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
    
    
    
    
    public Cookie getNewCookie()
    {
        ResultSet resultSet = null;
        
       try {
           Statement statement = conn.createStatement();
             resultSet = statement.executeQuery("select count from cookie");
           
       } catch (SQLException ex) {
           Logger.getLogger(DbControler.class.getName()).log(Level.SEVERE, null, ex);
       }
        
        Cookie cookie = new Cookie(CookieName, CookieName);
        
        return cookie;
    }
            
    
    
}
