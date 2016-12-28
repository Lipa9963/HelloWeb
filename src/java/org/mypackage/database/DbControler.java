/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mypackage.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
        int value = 0;
        Cookie cookie=null;
        ResultSet resultSet =null;
        Statement statement = null; 
       try {
           
           statement = conn.createStatement();
           resultSet = statement.executeQuery("SELECT COUNT(*) AS total FROM cookie");
        
           while (resultSet.next()) {
                value = resultSet.getInt(1);
           }
            
           value=value+1;
           String newValue = Integer.toString(value);
           cookie = new Cookie("Qliger", newValue);
           cookie.setMaxAge(Integer.MAX_VALUE);
           
           PreparedStatement pstmt = conn.prepareStatement("INSERT INTO cookie(value,visit) VALUE(?,?)");
           pstmt.setInt(1, value);
           pstmt.setInt(2,1);
           pstmt.executeUpdate();          
             
           
       } catch (SQLException ex)
       {
           Logger.getLogger(DbControler.class.getName()).log(Level.SEVERE, null, ex);
       } finally {
           
            try
            {
                if (resultSet != null)resultSet.close();
                if (statement != null)statement.close();
                //if (conn != null)conn.close();
            }catch(SQLException e)
            {
                Logger.getLogger(DbControler.class.getName()).log(Level.SEVERE, null, e);
            }
                   
           
        }
       
               
          return cookie;
        
    }
    
    
    public void addUserVisit(Cookie cookie)
    {
        ResultSet resultSet =null;
        Statement statement = null; 
        
        int numOfvisit = 0;
        try
        {
          
           statement = conn.createStatement();
           resultSet = statement.executeQuery("SELECT visit FROM cookie WHERE value="+cookie.getValue()+"");
            while (resultSet.next()) {
                numOfvisit = resultSet.getInt(1);
           }   
            
           
           PreparedStatement pstmt = conn.prepareStatement("UPDATE cookie SET visit = ?  WHERE value="+cookie.getValue()+"");
           pstmt.setInt(1, numOfvisit+1);
           pstmt.executeUpdate();           
            
        }catch(SQLException e)
        {
            Logger.getLogger(DbControler.class.getName()).log(Level.SEVERE, null, e);
        }finally {
           
            try
            {
                if (resultSet != null)resultSet.close();
                if (statement != null)statement.close();
                //if (conn != null)conn.close();
            }catch(SQLException e)
            {
                Logger.getLogger(DbControler.class.getName()).log(Level.SEVERE, null, e);
            }
                   
           
        }
        
        
    }
            
    
    
}
