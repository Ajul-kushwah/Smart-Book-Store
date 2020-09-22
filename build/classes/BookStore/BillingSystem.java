/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BookStore;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author hp
 */
public class BillingSystem {
    static String cidd;
    static Connection con=null;
    static PreparedStatement pst=null;
    static ResultSet rs=null;
    static Homepage h=new Homepage();
    
    
    public  static void customerSearch(String cidd){
//    
//        //cidd=h.cid;
//        con=DatabaseConnection.ConnectDB();
//        //String cid= h..customerID.getText();
//        String sql="select cname,mobile_no,address from customers where customerid='"+cidd+"'";
//      try{
//         //String cid= h.customerID.getText();
//         pst =con.prepareStatement(sql);
//         //pst.setString(1,cid);
//         rs=pst.executeQuery();
//         
//         if(rs.next()){
//           h.customerName.setText(rs.getString("cname"));
//           h.CusMobile.setText(rs.getString("mobile_no"));
//           h.cusAddress.setText(rs.getString("address"));
//         }
//         else{
//                JOptionPane.showMessageDialog(null,"record not found " );
//            }
//           con.close();
//      }
//      catch(Exception e){
//          JOptionPane.showMessageDialog(null,e);
//      }
//     
//        System.out.println("    dfgdfgdf g "+cidd);
}
    
    
}
