/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mypackage.database;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import org.apache.commons.dbcp.BasicDataSource;





/**
 *
 * @author admin
 */
public class DataSource {
    
    private static DataSource datasource = null;
    private BasicDataSource ds;
    
    private DataSource(){
        
        try {
            
        ds = new BasicDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUsername("root");
        ds.setPassword("hzi9963");
        ds.setUrl("jdbc:mysql://localhost:3306/mydatabase");
        } catch (Exception e)
        {
            String s = e.toString();
            
        }
        
    }
    
    public static DataSource getInstance()
    {
         if (datasource == null) {
            datasource = new DataSource();
            return datasource;
        } else {
            return datasource;
        }
    }
    
    
    public Connection getConnection() throws SQLException {
        return this.ds.getConnection();
    }
}
    
    
    
