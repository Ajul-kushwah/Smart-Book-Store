/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BookStore;
import java.sql.*;
import javax.swing.*;

/**
 *
 * @author hp
 */
public class DatabaseConnection {
    
    public static Connection ConnectDB(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/bookstore","root","mysqlinstaller8.0.17");
            //JOptionPane.showMessageDialog(null, "connected to database");
            return conn;
        }
        catch(SQLException | ClassNotFoundException e){
        JOptionPane.showMessageDialog(null,e);
        return null;
         }
    }
    public static void setColor(JPanel panel)
   {
     panel.setBackground(new java.awt.Color(197, 197, 197));
   }
 
   public static void resetColor(JPanel panel)
   {
     panel.setBackground(new java.awt.Color(240,240,240));
     
     
   }
   public static void billgenerator(){
       Billgenerates b=new Billgenerates();
      
      String s=b.jTextField11.getText();
      JOptionPane.showMessageDialog(null,s);
   }
    
    public static void main(String [] args)
    {
      ConnectDB();  
      
     
    }

}  
    
    

