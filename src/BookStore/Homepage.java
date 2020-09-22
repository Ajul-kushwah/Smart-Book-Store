/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BookStore;

import com.sun.glass.events.KeyEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import javax.swing.*;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author hp
 */
public class Homepage extends javax.swing.JFrame {

    Connection conn=null;
    PreparedStatement pst=null;
    ResultSet rs=null;
    //public String cid;
    DefaultTableModel model1;
    private int qn,av,totqty,totqnt;
    double to=0;
    public Homepage() {
        initComponents();
        model1 =(DefaultTableModel) jTable1.getModel();
        
        // for home page
        homePanel.setVisible(true);
        booksPanel.setVisible(false);
        customersPanel.setVisible(false);
        employeesPanel.setVisible(false);
        
        
        
        //Employee panel
        allemployeesPanel.setVisible(true);
        addemployeePanel.setVisible(false);
        updatedeletePanel.setVisible(false);
        searchemployeePanel.setVisible(false);
        
        //Customer panel
        allcustomersPanel.setVisible(true);
        addcustomerPanel.setVisible(false);
        updatedeleteCustomerPanel.setVisible(false);
        searchcustomerPanel.setVisible(false);
        
        //Books panel
        allbooksPanel.setVisible(true);
        addbookPanel.setVisible(false);
        updatedeletebooksPanel.setVisible(false);
        searchbooksPanel.setVisible(false);
        
        //Supplier panel
        allsuppliersPanel.setVisible(true);
        addsupplierPanel.setVisible(false);
        updatedeletesupplierPanel.setVisible(false);
        searchsuppliersPanel.setVisible(false);
        
        
        //for tables
        
        bookstabledesign();
        customerstabledesign();
        employeestabledesign();
        supplierstabledesign();
    }
    private void bookstabledesign(){
        allbooksTable.getTableHeader().setFont(new Font("",Font.BOLD,14));
        allbooksTable.getTableHeader().setOpaque(false);
        allbooksTable.getTableHeader().setBackground(new Color(10,40,109));
        allbooksTable.getTableHeader().setForeground(new Color(255,255,255));
        // update books tables
        updatebooksTable.getTableHeader().setFont(new Font("",Font.BOLD,14));
        updatebooksTable.getTableHeader().setOpaque(false);
        updatebooksTable.getTableHeader().setBackground(new Color(10,40,109));
        updatebooksTable.getTableHeader().setForeground(new Color(255,255,255));
        
        // search books tables
        
        searchbooksTable.getTableHeader().setFont(new Font("",Font.BOLD,14));
        searchbooksTable.getTableHeader().setOpaque(false);
        searchbooksTable.getTableHeader().setBackground(new Color(10,40,109));
        searchbooksTable.getTableHeader().setForeground(new Color(255,255,255));
        
    }
    private void customerstabledesign(){
        allcustomersTable.getTableHeader().setFont(new Font("",Font.BOLD,14));
        allcustomersTable.getTableHeader().setOpaque(false);
        allcustomersTable.getTableHeader().setBackground(new Color(10,40,109));
        allcustomersTable.getTableHeader().setForeground(new Color(255,255,255));
        
        updatecustomersTable.getTableHeader().setFont(new Font("",Font.BOLD,14));
        updatecustomersTable.getTableHeader().setOpaque(false);
        updatecustomersTable.getTableHeader().setBackground(new Color(10,40,109));
        updatecustomersTable.getTableHeader().setForeground(new Color(255,255,255));
        
    }
    private void employeestabledesign(){
        allemployeesTable.getTableHeader().setFont(new Font("",Font.BOLD,14));
        allemployeesTable.getTableHeader().setOpaque(false);
        allemployeesTable.getTableHeader().setBackground(new Color(10,40,109));
        allemployeesTable.getTableHeader().setForeground(new Color(255,255,255));
        
        updateemployeesTable.getTableHeader().setFont(new Font("",Font.BOLD,14));
        updateemployeesTable.getTableHeader().setOpaque(false);
        updateemployeesTable.getTableHeader().setBackground(new Color(10,40,109));
        updateemployeesTable.getTableHeader().setForeground(new Color(255,255,255));
        
    }
    private void supplierstabledesign(){
        allsuppliersTable.getTableHeader().setFont(new Font("",Font.BOLD,14));
        allsuppliersTable.getTableHeader().setOpaque(false);
        allsuppliersTable.getTableHeader().setBackground(new Color(10,40,109));
        allsuppliersTable.getTableHeader().setForeground(new Color(255,255,255));
        
        updatesuppliersTable.getTableHeader().setFont(new Font("",Font.BOLD,14));
        updatesuppliersTable.getTableHeader().setOpaque(false);
        updatesuppliersTable.getTableHeader().setBackground(new Color(10,40,109));
        updatesuppliersTable.getTableHeader().setForeground(new Color(255,255,255));
        
    }
    
    private void updatebooks(){
    
        try{
        conn=DatabaseConnection.ConnectDB();
        String sql="select bookid as 'Book ID',bname as 'Book Name',bpublisher as 'Publication',bauthor as 'Author',publishing_dates as 'Date',bstock as 'Quantites',bprice as 'Price' from addbooks ";
        PreparedStatement pstmt=conn.prepareStatement(sql);
        ResultSet rs=pstmt.executeQuery();
        
        allbooksTable.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    }
    private void updatecustomers(){
        try{
        conn=DatabaseConnection.ConnectDB();
        String sqll="select customerid as 'Customer ID',cname as 'Name',mobile_no as 'Mobile No.',type as 'Type',dates as 'Dates',address as 'Address' from customers ";
        PreparedStatement pstmt=conn.prepareStatement(sqll);
        ResultSet rss=pstmt.executeQuery();
        
        allcustomersTable.setModel(DbUtils.resultSetToTableModel(rss));
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    }
    private void updateemployees(){
        try{
        conn=DatabaseConnection.ConnectDB();
        String sqll="select employeeid as 'Employee ID',ename as 'Name',edesignation as 'Designation',mobile_no as 'Mobile No.',starting_date as 'Starting Date',salary as 'Salary',status as 'Status',address as 'Address' from employees ";
        PreparedStatement pstmt=conn.prepareStatement(sqll);
        ResultSet rss=pstmt.executeQuery();
        
        allemployeesTable.setModel(DbUtils.resultSetToTableModel(rss));
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    }
    private void updatesuppliers()
    {
    try{
        conn=DatabaseConnection.ConnectDB();
        String sqll="select supplierid as 'Supplier ID',sname as 'Name',agency as 'Agency',mobile_no as 'Mobile No.',startingdate as 'Starting Date',s_email as 'Email Add',saddress as 'Address' from suppliers ";
        PreparedStatement pstmt=conn.prepareStatement(sqll);
        ResultSet rss=pstmt.executeQuery();
        
        allsuppliersTable.setModel(DbUtils.resultSetToTableModel(rss));
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        } 
    }
     public void doexit()
    {
        int confirm = JOptionPane.showConfirmDialog(null, 
                "do you want to Exit ?", " ",
                JOptionPane.YES_NO_OPTION);    
        
        if (confirm == JOptionPane.YES_OPTION){
        System.exit(0);
    }
    
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BgPanel = new javax.swing.JPanel();
        sidePanel = new javax.swing.JPanel();
        homePanel1 = new javax.swing.JPanel();
        home = new javax.swing.JLabel();
        homeicon = new javax.swing.JLabel();
        booksPanel2 = new javax.swing.JPanel();
        books = new javax.swing.JLabel();
        booksicon = new javax.swing.JLabel();
        custmersPanel3 = new javax.swing.JPanel();
        customers = new javax.swing.JLabel();
        customersicon = new javax.swing.JLabel();
        employeesPanel4 = new javax.swing.JPanel();
        employees = new javax.swing.JLabel();
        employeesicon = new javax.swing.JLabel();
        suppliersPanel5 = new javax.swing.JPanel();
        suppliers = new javax.swing.JLabel();
        suppliersicon = new javax.swing.JLabel();
        paymentsPanel6 = new javax.swing.JPanel();
        payments = new javax.swing.JLabel();
        paymentsicon = new javax.swing.JLabel();
        logoutPanel7 = new javax.swing.JPanel();
        settings = new javax.swing.JLabel();
        settingsicon = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel42 = new javax.swing.JLabel();
        jLabel123 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanelSlider4 = new diu.swe.habib.JPanelSlider.JPanelSlider();
        homePanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        Home = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel119 = new javax.swing.JLabel();
        jLabel120 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel121 = new javax.swing.JLabel();
        jLabel122 = new javax.swing.JLabel();
        Bill = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        bookID = new javax.swing.JTextField();
        jLabel127 = new javax.swing.JLabel();
        bookName = new javax.swing.JTextField();
        jLabel134 = new javax.swing.JLabel();
        bookQnt = new javax.swing.JTextField();
        jLabel135 = new javax.swing.JLabel();
        bookPrice = new javax.swing.JTextField();
        jTextField52 = new javax.swing.JTextField();
        jButton8 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        customerID = new javax.swing.JTextField();
        jLabel124 = new javax.swing.JLabel();
        customerName = new javax.swing.JTextField();
        CusMobile = new javax.swing.JTextField();
        jLabel125 = new javax.swing.JLabel();
        jLabel126 = new javax.swing.JLabel();
        cusAddress = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        jScrollPane17 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel144 = new javax.swing.JLabel();
        quantity = new javax.swing.JTextField();
        jLabel145 = new javax.swing.JLabel();
        totalam = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        Purchase = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        booksPanel = new javax.swing.JPanel();
        allbooksbutton = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        addbooksbutton = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        updatebutton = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        searchbutton = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jPanelSlider3 = new diu.swe.habib.JPanelSlider.JPanelSlider();
        allbooksPanel = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        allbooksTable = new javax.swing.JTable();
        jTextField6 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        addbookPanel = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        jTextField25 = new javax.swing.JTextField();
        jLabel89 = new javax.swing.JLabel();
        jTextField26 = new javax.swing.JTextField();
        exit = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        clear = new javax.swing.JPanel();
        jLabel51 = new javax.swing.JLabel();
        savebooks = new javax.swing.JPanel();
        jLabel52 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        updatedeletebooksPanel = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        updatebooksTable = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        jTextField19 = new javax.swing.JTextField();
        jLabel82 = new javax.swing.JLabel();
        jTextField20 = new javax.swing.JTextField();
        jLabel83 = new javax.swing.JLabel();
        jTextField21 = new javax.swing.JTextField();
        jLabel84 = new javax.swing.JLabel();
        jTextField22 = new javax.swing.JTextField();
        jLabel85 = new javax.swing.JLabel();
        jDateChooser5 = new com.toedter.calendar.JDateChooser();
        jLabel86 = new javax.swing.JLabel();
        jTextField23 = new javax.swing.JTextField();
        jLabel87 = new javax.swing.JLabel();
        jTextField24 = new javax.swing.JTextField();
        updatebooks = new javax.swing.JPanel();
        jLabel90 = new javax.swing.JLabel();
        clear1 = new javax.swing.JPanel();
        jLabel96 = new javax.swing.JLabel();
        clear2 = new javax.swing.JPanel();
        jLabel99 = new javax.swing.JLabel();
        searchbooksPanel = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        searchbooksTable = new javax.swing.JTable();
        jLabel24 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jComboBox2 = new javax.swing.JComboBox();
        jLabel33 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        customersPanel = new javax.swing.JPanel();
        allcustomersbutton = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        addcustomerbutton = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        updateDeletebutton1 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        searchcustomerbutton = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jPanelSlider2 = new diu.swe.habib.JPanelSlider.JPanelSlider();
        allcustomersPanel = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        allcustomersTable = new javax.swing.JTable();
        jTextField27 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        addcustomerPanel = new javax.swing.JPanel();
        jLabel53 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel54 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jLabel55 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jLabel56 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jLabel57 = new javax.swing.JLabel();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        exit3 = new javax.swing.JPanel();
        jLabel60 = new javax.swing.JLabel();
        exit4 = new javax.swing.JPanel();
        jLabel61 = new javax.swing.JLabel();
        exit5 = new javax.swing.JPanel();
        jLabel62 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel77 = new javax.swing.JLabel();
        updatedeleteCustomerPanel = new javax.swing.JPanel();
        jLabel91 = new javax.swing.JLabel();
        jTextField28 = new javax.swing.JTextField();
        jLabel92 = new javax.swing.JLabel();
        jTextField29 = new javax.swing.JTextField();
        jLabel93 = new javax.swing.JLabel();
        jTextField30 = new javax.swing.JTextField();
        jLabel94 = new javax.swing.JLabel();
        jTextField31 = new javax.swing.JTextField();
        jLabel95 = new javax.swing.JLabel();
        jDateChooser6 = new com.toedter.calendar.JDateChooser();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTextArea4 = new javax.swing.JTextArea();
        jLabel97 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        updatecustomersTable = new javax.swing.JTable();
        updatecustomers = new javax.swing.JPanel();
        jLabel98 = new javax.swing.JLabel();
        deletecustomer = new javax.swing.JPanel();
        jLabel128 = new javax.swing.JLabel();
        clear3 = new javax.swing.JPanel();
        jLabel129 = new javax.swing.JLabel();
        searchcustomerPanel = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        updatebooksTable2 = new javax.swing.JTable();
        employeesPanel = new javax.swing.JPanel();
        allemployeesbutton = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        updatedeletebutton = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        searchemployeebutton = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();
        jPanelSlider1 = new diu.swe.habib.JPanelSlider.JPanelSlider();
        allemployeesPanel = new javax.swing.JPanel();
        jTextField43 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane16 = new javax.swing.JScrollPane();
        allemployeesTable = new javax.swing.JTable();
        addemployeePanel = new javax.swing.JPanel();
        jLabel59 = new javax.swing.JLabel();
        jTextField11 = new javax.swing.JTextField();
        jLabel63 = new javax.swing.JLabel();
        jTextField12 = new javax.swing.JTextField();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jTextField14 = new javax.swing.JTextField();
        jLabel66 = new javax.swing.JLabel();
        jDateChooser3 = new com.toedter.calendar.JDateChooser();
        jLabel67 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        exit6 = new javax.swing.JPanel();
        jLabel68 = new javax.swing.JLabel();
        exit7 = new javax.swing.JPanel();
        jLabel69 = new javax.swing.JLabel();
        exit8 = new javax.swing.JPanel();
        jLabel70 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel71 = new javax.swing.JLabel();
        jTextField13 = new javax.swing.JTextField();
        jLabel100 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox();
        updatedeletePanel = new javax.swing.JPanel();
        jScrollPane11 = new javax.swing.JScrollPane();
        updateemployeesTable = new javax.swing.JTable();
        jLabel101 = new javax.swing.JLabel();
        jTextField32 = new javax.swing.JTextField();
        jLabel102 = new javax.swing.JLabel();
        jTextField33 = new javax.swing.JTextField();
        jLabel103 = new javax.swing.JLabel();
        jTextField34 = new javax.swing.JTextField();
        jLabel104 = new javax.swing.JLabel();
        jTextField35 = new javax.swing.JTextField();
        jLabel105 = new javax.swing.JLabel();
        jDateChooser7 = new com.toedter.calendar.JDateChooser();
        jLabel106 = new javax.swing.JLabel();
        jScrollPane12 = new javax.swing.JScrollPane();
        jTextArea5 = new javax.swing.JTextArea();
        updateemployees = new javax.swing.JPanel();
        jLabel107 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox();
        jLabel108 = new javax.swing.JLabel();
        jLabel109 = new javax.swing.JLabel();
        jComboBox5 = new javax.swing.JComboBox();
        clear4 = new javax.swing.JPanel();
        jLabel130 = new javax.swing.JLabel();
        deleteemployee = new javax.swing.JPanel();
        jLabel131 = new javax.swing.JLabel();
        searchemployeePanel = new javax.swing.JPanel();
        addemployeebutton = new javax.swing.JPanel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        suppliersPanel = new javax.swing.JPanel();
        allsuppliersbutton = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        addsupplierbutton = new javax.swing.JPanel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        updatedeletesupplierbutton = new javax.swing.JPanel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        searchsupplierbutton = new javax.swing.JPanel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jPanelSlider5 = new diu.swe.habib.JPanelSlider.JPanelSlider();
        allsuppliersPanel = new javax.swing.JPanel();
        jTextField42 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane15 = new javax.swing.JScrollPane();
        allsuppliersTable = new javax.swing.JTable();
        addsupplierPanel = new javax.swing.JPanel();
        jLabel72 = new javax.swing.JLabel();
        jTextField15 = new javax.swing.JTextField();
        jLabel73 = new javax.swing.JLabel();
        jTextField16 = new javax.swing.JTextField();
        jLabel74 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        jTextField17 = new javax.swing.JTextField();
        jLabel76 = new javax.swing.JLabel();
        jDateChooser4 = new com.toedter.calendar.JDateChooser();
        jLabel78 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        exit9 = new javax.swing.JPanel();
        jLabel79 = new javax.swing.JLabel();
        exit10 = new javax.swing.JPanel();
        jLabel80 = new javax.swing.JLabel();
        exit11 = new javax.swing.JPanel();
        jLabel81 = new javax.swing.JLabel();
        jTextField18 = new javax.swing.JTextField();
        jLabel110 = new javax.swing.JLabel();
        jTextField36 = new javax.swing.JTextField();
        updatedeletesupplierPanel = new javax.swing.JPanel();
        jScrollPane13 = new javax.swing.JScrollPane();
        updatesuppliersTable = new javax.swing.JTable();
        jLabel111 = new javax.swing.JLabel();
        jTextField37 = new javax.swing.JTextField();
        jLabel112 = new javax.swing.JLabel();
        jTextField38 = new javax.swing.JTextField();
        jLabel113 = new javax.swing.JLabel();
        jTextField39 = new javax.swing.JTextField();
        jLabel114 = new javax.swing.JLabel();
        jTextField40 = new javax.swing.JTextField();
        jLabel115 = new javax.swing.JLabel();
        jDateChooser8 = new com.toedter.calendar.JDateChooser();
        jLabel116 = new javax.swing.JLabel();
        jScrollPane14 = new javax.swing.JScrollPane();
        jTextArea6 = new javax.swing.JTextArea();
        updatesuppliers = new javax.swing.JPanel();
        jLabel117 = new javax.swing.JLabel();
        jLabel118 = new javax.swing.JLabel();
        jTextField41 = new javax.swing.JTextField();
        clear5 = new javax.swing.JPanel();
        jLabel132 = new javax.swing.JLabel();
        deleteemployee1 = new javax.swing.JPanel();
        jLabel133 = new javax.swing.JLabel();
        searchsuppliersPanel = new javax.swing.JPanel();
        paymentsPanel = new javax.swing.JPanel();
        minimize = new javax.swing.JLabel();
        close = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        BgPanel.setBackground(new java.awt.Color(255, 255, 255));
        BgPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 255)));

        sidePanel.setBackground(new java.awt.Color(4, 103, 246));
        sidePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        homePanel1.setBackground(new java.awt.Color(4, 103, 246));
        homePanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                homePanel1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                homePanel1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                homePanel1MouseExited(evt);
            }
        });

        home.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        home.setForeground(new java.awt.Color(255, 255, 255));
        home.setText("Home");

        homeicon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/home_26px.png"))); // NOI18N

        javax.swing.GroupLayout homePanel1Layout = new javax.swing.GroupLayout(homePanel1);
        homePanel1.setLayout(homePanel1Layout);
        homePanel1Layout.setHorizontalGroup(
            homePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, homePanel1Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(homeicon)
                .addGap(10, 10, 10)
                .addComponent(home, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76))
        );
        homePanel1Layout.setVerticalGroup(
            homePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, homePanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(homePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(homePanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(homeicon))
                    .addComponent(home, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE))
                .addContainerGap())
        );

        sidePanel.add(homePanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, -1, -1));

        booksPanel2.setBackground(new java.awt.Color(4, 103, 246));
        booksPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                booksPanel2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                booksPanel2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                booksPanel2MouseExited(evt);
            }
        });

        books.setBackground(new java.awt.Color(255, 255, 255));
        books.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        books.setForeground(new java.awt.Color(255, 255, 255));
        books.setText("Books");

        booksicon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/books_26px.png"))); // NOI18N

        javax.swing.GroupLayout booksPanel2Layout = new javax.swing.GroupLayout(booksPanel2);
        booksPanel2.setLayout(booksPanel2Layout);
        booksPanel2Layout.setHorizontalGroup(
            booksPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, booksPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(books, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
            .addGroup(booksPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(booksPanel2Layout.createSequentialGroup()
                    .addGap(25, 25, 25)
                    .addComponent(booksicon)
                    .addContainerGap(98, Short.MAX_VALUE)))
        );
        booksPanel2Layout.setVerticalGroup(
            booksPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(booksPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(books, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(booksPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(booksPanel2Layout.createSequentialGroup()
                    .addGap(12, 12, 12)
                    .addComponent(booksicon)
                    .addContainerGap(13, Short.MAX_VALUE)))
        );

        sidePanel.add(booksPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 204, 222, -1));

        custmersPanel3.setBackground(new java.awt.Color(4, 103, 246));
        custmersPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                custmersPanel3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                custmersPanel3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                custmersPanel3MouseExited(evt);
            }
        });

        customers.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        customers.setForeground(new java.awt.Color(255, 255, 255));
        customers.setText("Customers");

        customersicon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/customer_24px.png"))); // NOI18N

        javax.swing.GroupLayout custmersPanel3Layout = new javax.swing.GroupLayout(custmersPanel3);
        custmersPanel3.setLayout(custmersPanel3Layout);
        custmersPanel3Layout.setHorizontalGroup(
            custmersPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(custmersPanel3Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(customers)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(custmersPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(custmersPanel3Layout.createSequentialGroup()
                    .addGap(25, 25, 25)
                    .addComponent(customersicon)
                    .addContainerGap(98, Short.MAX_VALUE)))
        );
        custmersPanel3Layout.setVerticalGroup(
            custmersPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(custmersPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(customers, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(custmersPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(custmersPanel3Layout.createSequentialGroup()
                    .addGap(12, 12, 12)
                    .addComponent(customersicon)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        sidePanel.add(custmersPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 255, 222, -1));

        employeesPanel4.setBackground(new java.awt.Color(4, 103, 246));
        employeesPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                employeesPanel4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                employeesPanel4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                employeesPanel4MouseExited(evt);
            }
        });

        employees.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        employees.setForeground(new java.awt.Color(255, 255, 255));
        employees.setText("Employees");

        employeesicon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/emploees_30px.png"))); // NOI18N

        javax.swing.GroupLayout employeesPanel4Layout = new javax.swing.GroupLayout(employeesPanel4);
        employeesPanel4.setLayout(employeesPanel4Layout);
        employeesPanel4Layout.setHorizontalGroup(
            employeesPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(employeesPanel4Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(employees)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(employeesPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(employeesPanel4Layout.createSequentialGroup()
                    .addGap(25, 25, 25)
                    .addComponent(employeesicon)
                    .addContainerGap(98, Short.MAX_VALUE)))
        );
        employeesPanel4Layout.setVerticalGroup(
            employeesPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(employeesPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(employees, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(employeesPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(employeesPanel4Layout.createSequentialGroup()
                    .addGap(12, 12, 12)
                    .addComponent(employeesicon)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        sidePanel.add(employeesPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 306, 222, -1));

        suppliersPanel5.setBackground(new java.awt.Color(4, 103, 246));
        suppliersPanel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                suppliersPanel5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                suppliersPanel5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                suppliersPanel5MouseExited(evt);
            }
        });

        suppliers.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        suppliers.setForeground(new java.awt.Color(255, 255, 255));
        suppliers.setText("Suppilers");

        suppliersicon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/supplier_24px.png"))); // NOI18N

        javax.swing.GroupLayout suppliersPanel5Layout = new javax.swing.GroupLayout(suppliersPanel5);
        suppliersPanel5.setLayout(suppliersPanel5Layout);
        suppliersPanel5Layout.setHorizontalGroup(
            suppliersPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(suppliersPanel5Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(suppliers)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(suppliersPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(suppliersPanel5Layout.createSequentialGroup()
                    .addGap(25, 25, 25)
                    .addComponent(suppliersicon)
                    .addContainerGap(98, Short.MAX_VALUE)))
        );
        suppliersPanel5Layout.setVerticalGroup(
            suppliersPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(suppliersPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(suppliers, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(suppliersPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(suppliersPanel5Layout.createSequentialGroup()
                    .addGap(12, 12, 12)
                    .addComponent(suppliersicon)
                    .addContainerGap(13, Short.MAX_VALUE)))
        );

        sidePanel.add(suppliersPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 359, 222, -1));

        paymentsPanel6.setBackground(new java.awt.Color(4, 103, 246));
        paymentsPanel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                paymentsPanel6MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                paymentsPanel6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                paymentsPanel6MouseExited(evt);
            }
        });

        payments.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        payments.setForeground(new java.awt.Color(255, 255, 255));
        payments.setText("Payments");

        paymentsicon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/rupee_24px.png"))); // NOI18N

        javax.swing.GroupLayout paymentsPanel6Layout = new javax.swing.GroupLayout(paymentsPanel6);
        paymentsPanel6.setLayout(paymentsPanel6Layout);
        paymentsPanel6Layout.setHorizontalGroup(
            paymentsPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paymentsPanel6Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(payments)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(paymentsPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(paymentsPanel6Layout.createSequentialGroup()
                    .addGap(25, 25, 25)
                    .addComponent(paymentsicon)
                    .addContainerGap(98, Short.MAX_VALUE)))
        );
        paymentsPanel6Layout.setVerticalGroup(
            paymentsPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paymentsPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(payments, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(paymentsPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(paymentsPanel6Layout.createSequentialGroup()
                    .addGap(12, 12, 12)
                    .addComponent(paymentsicon)
                    .addContainerGap(13, Short.MAX_VALUE)))
        );

        sidePanel.add(paymentsPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 455, 222, -1));

        logoutPanel7.setBackground(new java.awt.Color(4, 103, 246));
        logoutPanel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutPanel7MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                logoutPanel7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                logoutPanel7MouseExited(evt);
            }
        });

        settings.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        settings.setForeground(new java.awt.Color(255, 255, 255));
        settings.setText("Logout");

        settingsicon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logout_32px.png"))); // NOI18N

        javax.swing.GroupLayout logoutPanel7Layout = new javax.swing.GroupLayout(logoutPanel7);
        logoutPanel7.setLayout(logoutPanel7Layout);
        logoutPanel7Layout.setHorizontalGroup(
            logoutPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(logoutPanel7Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(settings)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(logoutPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(logoutPanel7Layout.createSequentialGroup()
                    .addGap(25, 25, 25)
                    .addComponent(settingsicon)
                    .addContainerGap(98, Short.MAX_VALUE)))
        );
        logoutPanel7Layout.setVerticalGroup(
            logoutPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(logoutPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(settings, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(logoutPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(logoutPanel7Layout.createSequentialGroup()
                    .addGap(12, 12, 12)
                    .addComponent(settingsicon)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        sidePanel.add(logoutPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 512, 222, -1));
        sidePanel.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 428, 155, 10));

        jLabel42.setFont(new java.awt.Font("Viner Hand ITC", 1, 30)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(255, 255, 255));
        jLabel42.setText("SmartBooks");
        sidePanel.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 210, -1));

        jLabel123.setFont(new java.awt.Font("Viner Hand ITC", 1, 36)); // NOI18N
        jLabel123.setForeground(new java.awt.Color(255, 255, 255));
        jLabel123.setText("Store");
        sidePanel.add(jLabel123, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 160, -1));

        jPanel1.setBackground(new java.awt.Color(0, 51, 255));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Home");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(579, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanelSlider4.setBorder(null);

        homePanel.setBackground(new java.awt.Color(255, 255, 255));
        homePanel.setPreferredSize(new java.awt.Dimension(826, 41));

        jPanel2.setLayout(new java.awt.CardLayout());

        Home.setBackground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(java.awt.SystemColor.controlHighlight);
        jPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel4MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel4MousePressed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(45, 118, 232));
        jLabel6.setText("Purchase Book");

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/purchase_order_64px.png"))); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(23, 23, 23)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jPanel6.setBackground(java.awt.SystemColor.controlHighlight);
        jPanel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel6MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel6MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel6MousePressed(evt);
            }
        });

        jLabel119.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel119.setForeground(new java.awt.Color(45, 118, 232));
        jLabel119.setText("Sale Books");

        jLabel120.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/group_52px.png"))); // NOI18N

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel119)
                    .addComponent(jLabel120))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel120)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel119)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setBackground(java.awt.SystemColor.controlHighlight);
        jPanel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel7MouseExited(evt);
            }
        });

        jLabel121.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel121.setForeground(new java.awt.Color(45, 118, 232));
        jLabel121.setText("About us");

        jLabel122.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/about_48px.png"))); // NOI18N

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel121)
                    .addComponent(jLabel122))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel122)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel121)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout HomeLayout = new javax.swing.GroupLayout(Home);
        Home.setLayout(HomeLayout);
        HomeLayout.setHorizontalGroup(
            HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HomeLayout.createSequentialGroup()
                .addGap(170, 170, 170)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(143, Short.MAX_VALUE))
        );
        HomeLayout.setVerticalGroup(
            HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HomeLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(231, Short.MAX_VALUE))
        );

        jPanel2.add(Home, "card2");

        Bill.setBackground(new java.awt.Color(255, 255, 255));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 255)), "Books Details :", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 51, 255))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel1.setText("Book ID :");

        jLabel127.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel127.setText("Book Name :");

        bookName.setEditable(false);

        jLabel134.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel134.setText("Available :");

        bookQnt.setEditable(false);

        jLabel135.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel135.setText("Price :");

        bookPrice.setEditable(false);

        jButton8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton8.setText("Search");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(32, 32, 32)
                        .addComponent(bookID))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel127)
                        .addGap(11, 11, 11)
                        .addComponent(bookName, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel134)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bookQnt, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel135)
                        .addGap(10, 10, 10)
                        .addComponent(bookPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField52, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(bookID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8))
                .addGap(7, 7, 7)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel127)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bookName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel134)
                        .addComponent(bookPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bookQnt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel135)
                        .addComponent(jTextField52, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 11, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 204)), "Customer Details :", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 1, 14), new java.awt.Color(0, 0, 255))); // NOI18N

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel10.setText("Customer ID :");

        customerID.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        customerID.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                customerIDMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                customerIDMouseReleased(evt);
            }
        });
        customerID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerIDActionPerformed(evt);
            }
        });

        jLabel124.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel124.setText("Name :");

        customerName.setEditable(false);
        customerName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        CusMobile.setEditable(false);
        CusMobile.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel125.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel125.setText("Mobile No. :");

        jLabel126.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel126.setText("Address :");

        cusAddress.setEditable(false);
        cusAddress.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jButton7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton7.setText("Search");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel124)
                        .addGap(60, 60, 60)
                        .addComponent(customerName, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(customerID)))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel125)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CusMobile, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel126)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cusAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(customerID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7))
                .addGap(7, 7, 7)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel124)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(customerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel125)
                        .addComponent(CusMobile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel126)
                        .addComponent(cusAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 9, Short.MAX_VALUE))
        );

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Book ID", "Book Name", "Quantity", " Per Price", "Total price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                true, true, true, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setGridColor(new java.awt.Color(51, 51, 255));
        jScrollPane17.setViewportView(jTable1);

        jLabel144.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel144.setText("Quantity :");

        jLabel145.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel145.setText("Total :");

        totalam.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        totalam.setText("0");

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton4.setText("+ Add");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton5.setText("- Delete");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton6.setText("Save & Print");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout BillLayout = new javax.swing.GroupLayout(Bill);
        Bill.setLayout(BillLayout);
        BillLayout.setHorizontalGroup(
            BillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BillLayout.createSequentialGroup()
                .addGap(250, 250, 250)
                .addComponent(jLabel144)
                .addGap(18, 18, 18)
                .addComponent(quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(BillLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(BillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BillLayout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel145, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(totalam, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton6)
                        .addGap(24, 24, 24))
                    .addGroup(BillLayout.createSequentialGroup()
                        .addGroup(BillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(BillLayout.createSequentialGroup()
                                .addGroup(BillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane17, javax.swing.GroupLayout.PREFERRED_SIZE, 639, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 4, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        BillLayout.setVerticalGroup(
            BillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BillLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(BillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel144)
                    .addGroup(BillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(quantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton4)
                        .addComponent(jButton5)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane17, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(BillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(totalam, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel145, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton2))
                    .addComponent(jButton6, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.add(Bill, "card3");

        jButton3.setText("Back");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PurchaseLayout = new javax.swing.GroupLayout(Purchase);
        Purchase.setLayout(PurchaseLayout);
        PurchaseLayout.setHorizontalGroup(
            PurchaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PurchaseLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton3)
                .addContainerGap(733, Short.MAX_VALUE))
        );
        PurchaseLayout.setVerticalGroup(
            PurchaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PurchaseLayout.createSequentialGroup()
                .addContainerGap(371, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addContainerGap())
        );

        jPanel2.add(Purchase, "card4");

        javax.swing.GroupLayout homePanelLayout = new javax.swing.GroupLayout(homePanel);
        homePanel.setLayout(homePanelLayout);
        homePanelLayout.setHorizontalGroup(
            homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homePanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        homePanelLayout.setVerticalGroup(
            homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanelSlider4.add(homePanel, "card2");

        booksPanel.setBackground(new java.awt.Color(255, 255, 255));
        booksPanel.setPreferredSize(new java.awt.Dimension(826, 401));

        allbooksbutton.setPreferredSize(new java.awt.Dimension(152, 43));
        allbooksbutton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                allbooksbuttonMouseClicked(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel15.setText("All books");

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/books_32px.png"))); // NOI18N

        javax.swing.GroupLayout allbooksbuttonLayout = new javax.swing.GroupLayout(allbooksbutton);
        allbooksbutton.setLayout(allbooksbuttonLayout);
        allbooksbuttonLayout.setHorizontalGroup(
            allbooksbuttonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(allbooksbuttonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16)
                .addGap(7, 7, 7)
                .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                .addContainerGap())
        );
        allbooksbuttonLayout.setVerticalGroup(
            allbooksbuttonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(allbooksbuttonLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(allbooksbuttonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        addbooksbutton.setPreferredSize(new java.awt.Dimension(152, 43));
        addbooksbutton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addbooksbuttonMouseClicked(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel17.setText("Add books");

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add_book_30px.png"))); // NOI18N

        javax.swing.GroupLayout addbooksbuttonLayout = new javax.swing.GroupLayout(addbooksbutton);
        addbooksbutton.setLayout(addbooksbuttonLayout);
        addbooksbuttonLayout.setHorizontalGroup(
            addbooksbuttonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addbooksbuttonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel18)
                .addGap(7, 7, 7)
                .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                .addContainerGap())
        );
        addbooksbuttonLayout.setVerticalGroup(
            addbooksbuttonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addbooksbuttonLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(addbooksbuttonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addbooksbuttonLayout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addGap(0, 2, Short.MAX_VALUE))
                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        updatebutton.setPreferredSize(new java.awt.Dimension(152, 43));
        updatebutton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updatebuttonMouseClicked(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel19.setText("Update/delete");

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/update_24px.png"))); // NOI18N

        javax.swing.GroupLayout updatebuttonLayout = new javax.swing.GroupLayout(updatebutton);
        updatebutton.setLayout(updatebuttonLayout);
        updatebuttonLayout.setHorizontalGroup(
            updatebuttonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(updatebuttonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20)
                .addGap(7, 7, 7)
                .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                .addGap(1, 1, 1))
        );
        updatebuttonLayout.setVerticalGroup(
            updatebuttonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(updatebuttonLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(updatebuttonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(updatebuttonLayout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addGap(0, 8, Short.MAX_VALUE))
                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        searchbutton.setPreferredSize(new java.awt.Dimension(152, 43));
        searchbutton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchbuttonMouseClicked(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel21.setText("Search");

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search_books_32px.png"))); // NOI18N

        javax.swing.GroupLayout searchbuttonLayout = new javax.swing.GroupLayout(searchbutton);
        searchbutton.setLayout(searchbuttonLayout);
        searchbuttonLayout.setHorizontalGroup(
            searchbuttonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchbuttonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel22)
                .addGap(7, 7, 7)
                .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                .addContainerGap())
        );
        searchbuttonLayout.setVerticalGroup(
            searchbuttonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchbuttonLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(searchbuttonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(searchbuttonLayout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        allbooksPanel.setBackground(new java.awt.Color(255, 255, 255));

        allbooksTable.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        allbooksTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        allbooksTable.setFocusable(false);
        allbooksTable.setGridColor(new java.awt.Color(0, 0, 153));
        allbooksTable.setIntercellSpacing(new java.awt.Dimension(0, 0));
        allbooksTable.setRowHeight(25);
        allbooksTable.setSelectionBackground(new java.awt.Color(170, 228, 255));
        allbooksTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(allbooksTable);

        jTextField6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 153), 1, true));
        jTextField6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField6KeyReleased(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\hp\\Documents\\NetBeansProjects\\BookStoreManagementSystem\\src\\images\\search_filter_16px.png")); // NOI18N

        javax.swing.GroupLayout allbooksPanelLayout = new javax.swing.GroupLayout(allbooksPanel);
        allbooksPanel.setLayout(allbooksPanelLayout);
        allbooksPanelLayout.setHorizontalGroup(
            allbooksPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(allbooksPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 753, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(allbooksPanelLayout.createSequentialGroup()
                .addGap(258, 258, 258)
                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        allbooksPanelLayout.setVerticalGroup(
            allbooksPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, allbooksPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(allbooksPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField6)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanelSlider3.add(allbooksPanel, "card3");

        addbookPanel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel8.setText("Book ID :");

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 204)));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel11.setText("Name/Title :");

        jTextField2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 204)));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel12.setText("Publication :");

        jTextField3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 204)));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel13.setText("Author :");

        jTextField4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 204)));

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel23.setText("Date :");

        jLabel88.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel88.setText("Stock :");

        jTextField25.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField25.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 204)));
        jTextField25.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField25KeyTyped(evt);
            }
        });

        jLabel89.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel89.setText("Price :");

        jTextField26.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField26.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 204)));
        jTextField26.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField26KeyTyped(evt);
            }
        });

        exit.setBackground(new java.awt.Color(255, 255, 255));
        exit.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 79, 197), 1, true));
        exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exitMouseExited(evt);
            }
        });
        exit.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel34.setBackground(new java.awt.Color(255, 255, 255));
        jLabel34.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(0, 51, 255));
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel34.setText("Cancel");
        jLabel34.setOpaque(true);
        exit.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 90, 30));

        clear.setBackground(new java.awt.Color(255, 255, 255));
        clear.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 79, 197), 1, true));
        clear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clearMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                clearMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                clearMouseExited(evt);
            }
        });
        clear.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel51.setBackground(new java.awt.Color(255, 255, 255));
        jLabel51.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(0, 51, 255));
        jLabel51.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel51.setText("Clear");
        jLabel51.setOpaque(true);
        clear.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 90, 30));

        savebooks.setBackground(new java.awt.Color(255, 255, 255));
        savebooks.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 79, 197), 1, true));
        savebooks.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                savebooksMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                savebooksMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                savebooksMouseExited(evt);
            }
        });
        savebooks.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel52.setBackground(new java.awt.Color(255, 255, 255));
        jLabel52.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(0, 51, 255));
        jLabel52.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel52.setText("Save");
        jLabel52.setOpaque(true);
        savebooks.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 90, 30));

        jDateChooser1.setDateFormatString("yyyy-MM-dd");

        javax.swing.GroupLayout addbookPanelLayout = new javax.swing.GroupLayout(addbookPanel);
        addbookPanel.setLayout(addbookPanelLayout);
        addbookPanelLayout.setHorizontalGroup(
            addbookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addbookPanelLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(addbookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(addbookPanelLayout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(addbookPanelLayout.createSequentialGroup()
                        .addGroup(addbookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(addbookPanelLayout.createSequentialGroup()
                                .addGroup(addbookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(addbookPanelLayout.createSequentialGroup()
                                        .addGroup(addbookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(29, 29, 29)
                                        .addGroup(addbookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextField4)
                                            .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(addbookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(addbookPanelLayout.createSequentialGroup()
                                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(addbookPanelLayout.createSequentialGroup()
                                            .addComponent(jLabel11)
                                            .addGap(25, 25, 25)
                                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(211, 211, 211))
                            .addGroup(addbookPanelLayout.createSequentialGroup()
                                .addGroup(addbookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel88, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel89, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(29, 29, 29)
                                .addGroup(addbookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jTextField26, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField25, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(addbookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(exit, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(clear, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(savebooks, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(88, 88, 88))))
        );
        addbookPanelLayout.setVerticalGroup(
            addbookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addbookPanelLayout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(addbookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(addbookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(addbookPanelLayout.createSequentialGroup()
                        .addGroup(addbookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(addbookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(savebooks, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(addbookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addbookPanelLayout.createSequentialGroup()
                        .addGroup(addbookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(addbookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel23)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addbookPanelLayout.createSequentialGroup()
                        .addComponent(clear, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)))
                .addGroup(addbookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(exit, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(addbookPanelLayout.createSequentialGroup()
                        .addGroup(addbookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel88)
                            .addComponent(jTextField25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(addbookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(addbookPanelLayout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jLabel89))
                            .addComponent(jTextField26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        jPanelSlider3.add(addbookPanel, "card2");

        updatedeletebooksPanel.setBackground(new java.awt.Color(255, 255, 255));
        updatedeletebooksPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updatedeletebooksPanelMouseClicked(evt);
            }
        });

        updatebooksTable.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        updatebooksTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        updatebooksTable.setFocusable(false);
        updatebooksTable.setGridColor(new java.awt.Color(0, 0, 153));
        updatebooksTable.setIntercellSpacing(new java.awt.Dimension(0, 0));
        updatebooksTable.setRowHeight(25);
        updatebooksTable.setSelectionBackground(new java.awt.Color(170, 228, 255));
        updatebooksTable.getTableHeader().setReorderingAllowed(false);
        updatebooksTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updatebooksTableMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(updatebooksTable);

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel14.setText("Book ID :");

        jTextField19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField19.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 204)));

        jLabel82.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel82.setText("Name/Title :");

        jTextField20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField20.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 204)));

        jLabel83.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel83.setText("Publication :");

        jTextField21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField21.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 204)));

        jLabel84.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel84.setText("Author :");

        jTextField22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField22.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 204)));

        jLabel85.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel85.setText("Date :");

        jDateChooser5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 153)));
        jDateChooser5.setDateFormatString("yyyy-MM-dd");
        jDateChooser5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel86.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel86.setText("Stock :");

        jTextField23.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField23.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 204)));

        jLabel87.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel87.setText("Price :");

        jTextField24.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField24.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 204)));

        updatebooks.setBackground(new java.awt.Color(255, 255, 255));
        updatebooks.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 79, 197), 1, true));
        updatebooks.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updatebooksMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                updatebooksMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                updatebooksMouseExited(evt);
            }
        });
        updatebooks.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel90.setBackground(new java.awt.Color(255, 255, 255));
        jLabel90.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel90.setForeground(new java.awt.Color(0, 51, 255));
        jLabel90.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel90.setText("Update");
        jLabel90.setOpaque(true);
        updatebooks.add(jLabel90, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 90, 30));

        clear1.setBackground(new java.awt.Color(255, 255, 255));
        clear1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 79, 197), 1, true));
        clear1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clear1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                clear1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                clear1MouseExited(evt);
            }
        });
        clear1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel96.setBackground(new java.awt.Color(255, 255, 255));
        jLabel96.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel96.setForeground(new java.awt.Color(0, 51, 255));
        jLabel96.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel96.setText("Clear");
        jLabel96.setOpaque(true);
        clear1.add(jLabel96, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 90, 30));

        clear2.setBackground(new java.awt.Color(255, 255, 255));
        clear2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 79, 197), 1, true));
        clear2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clear2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                clear2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                clear2MouseExited(evt);
            }
        });
        clear2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel99.setBackground(new java.awt.Color(255, 255, 255));
        jLabel99.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel99.setForeground(new java.awt.Color(0, 51, 255));
        jLabel99.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel99.setText("Delete");
        jLabel99.setOpaque(true);
        clear2.add(jLabel99, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 50, 30));

        javax.swing.GroupLayout updatedeletebooksPanelLayout = new javax.swing.GroupLayout(updatedeletebooksPanel);
        updatedeletebooksPanel.setLayout(updatedeletebooksPanelLayout);
        updatedeletebooksPanelLayout.setHorizontalGroup(
            updatedeletebooksPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(updatedeletebooksPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(updatedeletebooksPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(updatedeletebooksPanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 753, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(updatedeletebooksPanelLayout.createSequentialGroup()
                        .addGroup(updatedeletebooksPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(updatedeletebooksPanelLayout.createSequentialGroup()
                                .addComponent(jLabel84, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(jTextField22))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, updatedeletebooksPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(updatedeletebooksPanelLayout.createSequentialGroup()
                                    .addComponent(jLabel83, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jTextField21, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(updatedeletebooksPanelLayout.createSequentialGroup()
                                    .addComponent(jLabel82)
                                    .addGap(25, 25, 25)
                                    .addComponent(jTextField20, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(updatedeletebooksPanelLayout.createSequentialGroup()
                                .addComponent(jLabel85, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(jDateChooser5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(updatedeletebooksPanelLayout.createSequentialGroup()
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(jTextField19, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(updatedeletebooksPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel86, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel87, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(updatedeletebooksPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jTextField24, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField23, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(clear2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(updatedeletebooksPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(clear1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(updatebooks, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(57, 57, 57))))
        );
        updatedeletebooksPanelLayout.setVerticalGroup(
            updatedeletebooksPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, updatedeletebooksPanelLayout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(updatedeletebooksPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(updatedeletebooksPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel14)
                        .addComponent(jTextField19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel86)
                    .addComponent(jTextField23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(updatedeletebooksPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(updatedeletebooksPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(updatedeletebooksPanelLayout.createSequentialGroup()
                            .addGroup(updatedeletebooksPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel82)
                                .addComponent(jTextField20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(updatedeletebooksPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel83)
                                .addComponent(jTextField21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(updatedeletebooksPanelLayout.createSequentialGroup()
                            .addGap(1, 1, 1)
                            .addComponent(jLabel87))
                        .addComponent(jTextField24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(clear1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(updatedeletebooksPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(updatedeletebooksPanelLayout.createSequentialGroup()
                        .addGroup(updatedeletebooksPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel84)
                            .addComponent(jTextField22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(updatedeletebooksPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel85)
                            .addComponent(jDateChooser5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(updatebooks, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clear2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31))
        );

        jPanelSlider3.add(updatedeletebooksPanel, "card4");

        searchbooksPanel.setBackground(new java.awt.Color(255, 255, 255));

        searchbooksTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        searchbooksTable.setFocusable(false);
        searchbooksTable.setGridColor(new java.awt.Color(0, 0, 153));
        searchbooksTable.setIntercellSpacing(new java.awt.Dimension(0, 0));
        searchbooksTable.setRowHeight(25);
        searchbooksTable.setSelectionBackground(new java.awt.Color(170, 228, 255));
        searchbooksTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane6.setViewportView(searchbooksTable);

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel24.setText("Search By :");

        jTextField5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 204)));

        jComboBox2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Book ID", "Book Name/Title", "Author", "Publisher" }));
        jComboBox2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(10, 40, 103)));

        jLabel33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search_24px.png"))); // NOI18N

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 102));
        jButton1.setText("Search");

        jCheckBox1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jCheckBox1.setForeground(new java.awt.Color(153, 153, 255));
        jCheckBox1.setText("Only Available ");

        javax.swing.GroupLayout searchbooksPanelLayout = new javax.swing.GroupLayout(searchbooksPanel);
        searchbooksPanel.setLayout(searchbooksPanelLayout);
        searchbooksPanelLayout.setHorizontalGroup(
            searchbooksPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchbooksPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(searchbooksPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(searchbooksPanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane6)
                        .addContainerGap())
                    .addGroup(searchbooksPanelLayout.createSequentialGroup()
                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel33)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jCheckBox1)
                        .addGap(0, 88, Short.MAX_VALUE))))
        );
        searchbooksPanelLayout.setVerticalGroup(
            searchbooksPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchbooksPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(searchbooksPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(searchbooksPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel24)
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel33)
                    .addGroup(searchbooksPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1)
                        .addComponent(jCheckBox1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );

        jPanelSlider3.add(searchbooksPanel, "card5");

        javax.swing.GroupLayout booksPanelLayout = new javax.swing.GroupLayout(booksPanel);
        booksPanel.setLayout(booksPanelLayout);
        booksPanelLayout.setHorizontalGroup(
            booksPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(booksPanelLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(booksPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelSlider3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(booksPanelLayout.createSequentialGroup()
                        .addComponent(allbooksbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addbooksbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(updatebutton, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        booksPanelLayout.setVerticalGroup(
            booksPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(booksPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(booksPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(allbooksbutton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addbooksbutton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updatebutton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchbutton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(jPanelSlider3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanelSlider4.add(booksPanel, "card3");

        customersPanel.setBackground(new java.awt.Color(255, 255, 255));
        customersPanel.setPreferredSize(new java.awt.Dimension(816, 86));

        allcustomersbutton.setPreferredSize(new java.awt.Dimension(152, 43));
        allcustomersbutton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                allcustomersbuttonMouseClicked(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel25.setText("All customers");

        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/all_customers_30px.png"))); // NOI18N

        javax.swing.GroupLayout allcustomersbuttonLayout = new javax.swing.GroupLayout(allcustomersbutton);
        allcustomersbutton.setLayout(allcustomersbuttonLayout);
        allcustomersbuttonLayout.setHorizontalGroup(
            allcustomersbuttonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(allcustomersbuttonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel26)
                .addGap(7, 7, 7)
                .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                .addContainerGap())
        );
        allcustomersbuttonLayout.setVerticalGroup(
            allcustomersbuttonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(allcustomersbuttonLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(allcustomersbuttonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel26)
                    .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)))
        );

        addcustomerbutton.setPreferredSize(new java.awt.Dimension(152, 43));
        addcustomerbutton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addcustomerbuttonMouseClicked(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel27.setText("Add customer");

        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add_customer_30px.png"))); // NOI18N

        javax.swing.GroupLayout addcustomerbuttonLayout = new javax.swing.GroupLayout(addcustomerbutton);
        addcustomerbutton.setLayout(addcustomerbuttonLayout);
        addcustomerbuttonLayout.setHorizontalGroup(
            addcustomerbuttonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addcustomerbuttonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel28)
                .addGap(7, 7, 7)
                .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                .addContainerGap())
        );
        addcustomerbuttonLayout.setVerticalGroup(
            addcustomerbuttonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addcustomerbuttonLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(addcustomerbuttonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addcustomerbuttonLayout.createSequentialGroup()
                        .addComponent(jLabel28)
                        .addGap(0, 2, Short.MAX_VALUE))
                    .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        updateDeletebutton1.setPreferredSize(new java.awt.Dimension(152, 43));
        updateDeletebutton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updateDeletebutton1MouseClicked(evt);
            }
        });

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel29.setText("Update/Delete");

        jLabel30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/update_customer_32px.png"))); // NOI18N

        javax.swing.GroupLayout updateDeletebutton1Layout = new javax.swing.GroupLayout(updateDeletebutton1);
        updateDeletebutton1.setLayout(updateDeletebutton1Layout);
        updateDeletebutton1Layout.setHorizontalGroup(
            updateDeletebutton1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(updateDeletebutton1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel30)
                .addGap(7, 7, 7)
                .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        updateDeletebutton1Layout.setVerticalGroup(
            updateDeletebutton1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(updateDeletebutton1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(updateDeletebutton1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(updateDeletebutton1Layout.createSequentialGroup()
                        .addComponent(jLabel30)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        searchcustomerbutton.setPreferredSize(new java.awt.Dimension(152, 43));
        searchcustomerbutton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchcustomerbuttonMouseClicked(evt);
            }
        });

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel31.setText("Sales record");

        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search_customer_24px.png"))); // NOI18N

        javax.swing.GroupLayout searchcustomerbuttonLayout = new javax.swing.GroupLayout(searchcustomerbutton);
        searchcustomerbutton.setLayout(searchcustomerbuttonLayout);
        searchcustomerbuttonLayout.setHorizontalGroup(
            searchcustomerbuttonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchcustomerbuttonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel32)
                .addGap(7, 7, 7)
                .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        searchcustomerbuttonLayout.setVerticalGroup(
            searchcustomerbuttonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchcustomerbuttonLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(searchcustomerbuttonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(searchcustomerbuttonLayout.createSequentialGroup()
                        .addComponent(jLabel32)
                        .addGap(0, 8, Short.MAX_VALUE))
                    .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jPanelSlider2.setPreferredSize(new java.awt.Dimension(777, 370));

        allcustomersPanel.setBackground(new java.awt.Color(255, 255, 255));

        allcustomersTable.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        allcustomersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        allcustomersTable.setFocusable(false);
        allcustomersTable.setGridColor(new java.awt.Color(0, 0, 153));
        allcustomersTable.setIntercellSpacing(new java.awt.Dimension(0, 0));
        allcustomersTable.setRowHeight(25);
        allcustomersTable.setSelectionBackground(new java.awt.Color(170, 228, 255));
        allcustomersTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane7.setViewportView(allcustomersTable);

        jTextField27.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField27.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(4, 103, 246), 1, true));
        jTextField27.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField27KeyReleased(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\hp\\Documents\\NetBeansProjects\\BookStoreManagementSystem\\src\\images\\search_filter_16px.png")); // NOI18N

        javax.swing.GroupLayout allcustomersPanelLayout = new javax.swing.GroupLayout(allcustomersPanel);
        allcustomersPanel.setLayout(allcustomersPanelLayout);
        allcustomersPanelLayout.setHorizontalGroup(
            allcustomersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(allcustomersPanelLayout.createSequentialGroup()
                .addGap(245, 245, 245)
                .addComponent(jTextField27, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, allcustomersPanelLayout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 751, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        allcustomersPanelLayout.setVerticalGroup(
            allcustomersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, allcustomersPanelLayout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(allcustomersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField27, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        jPanelSlider2.add(allcustomersPanel, "card6");

        addcustomerPanel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel53.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel53.setText("Customer ID :");

        jTextField7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 204)));

        jLabel54.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel54.setText("Name :");

        jTextField8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 204)));

        jLabel55.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel55.setText("Mobile No. :");

        jTextField9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 204)));
        jTextField9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField9KeyTyped(evt);
            }
        });

        jLabel56.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel56.setText("Type :");

        jTextField10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 204)));

        jLabel57.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel57.setText("Date :");

        jDateChooser2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 153)));
        jDateChooser2.setDateFormatString("yyyy-MM-dd");
        jDateChooser2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        exit3.setBackground(new java.awt.Color(255, 255, 255));
        exit3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 79, 197), 1, true));
        exit3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exit3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exit3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exit3MouseExited(evt);
            }
        });
        exit3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel60.setBackground(new java.awt.Color(255, 255, 255));
        jLabel60.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel60.setForeground(new java.awt.Color(0, 51, 255));
        jLabel60.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel60.setText("Save");
        jLabel60.setOpaque(true);
        exit3.add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 90, 30));

        exit4.setBackground(new java.awt.Color(255, 255, 255));
        exit4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 79, 197), 1, true));
        exit4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exit4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exit4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exit4MouseExited(evt);
            }
        });
        exit4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel61.setBackground(new java.awt.Color(255, 255, 255));
        jLabel61.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel61.setForeground(new java.awt.Color(0, 51, 255));
        jLabel61.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel61.setText("Clear");
        jLabel61.setOpaque(true);
        exit4.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 90, 30));

        exit5.setBackground(new java.awt.Color(255, 255, 255));
        exit5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 79, 197), 1, true));
        exit5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exit5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exit5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exit5MouseExited(evt);
            }
        });
        exit5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel62.setBackground(new java.awt.Color(255, 255, 255));
        jLabel62.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel62.setForeground(new java.awt.Color(0, 51, 255));
        jLabel62.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel62.setText("Cancel");
        jLabel62.setOpaque(true);
        exit5.add(jLabel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 90, 30));

        jLabel58.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel58.setText("Address :");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 204)));
        jScrollPane1.setViewportView(jTextArea1);

        jLabel77.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel77.setForeground(new java.awt.Color(255, 255, 255));
        jLabel77.setText("Gender :");

        javax.swing.GroupLayout addcustomerPanelLayout = new javax.swing.GroupLayout(addcustomerPanel);
        addcustomerPanel.setLayout(addcustomerPanelLayout);
        addcustomerPanelLayout.setHorizontalGroup(
            addcustomerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addcustomerPanelLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(addcustomerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(addcustomerPanelLayout.createSequentialGroup()
                        .addGroup(addcustomerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addcustomerPanelLayout.createSequentialGroup()
                                .addGroup(addcustomerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(addcustomerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextField10)
                                    .addComponent(jDateChooser2, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)))
                            .addGroup(addcustomerPanelLayout.createSequentialGroup()
                                .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)))
                        .addGap(0, 2, Short.MAX_VALUE)
                        .addComponent(jLabel77, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                        .addGap(25, 25, 25)
                        .addGroup(addcustomerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(exit5, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(exit4, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(exit3, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(88, 88, 88))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, addcustomerPanelLayout.createSequentialGroup()
                        .addGroup(addcustomerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(addcustomerPanelLayout.createSequentialGroup()
                                .addComponent(jLabel53)
                                .addGap(13, 13, 13))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addcustomerPanelLayout.createSequentialGroup()
                                .addGroup(addcustomerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)))
                        .addGroup(addcustomerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(addcustomerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        addcustomerPanelLayout.setVerticalGroup(
            addcustomerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addcustomerPanelLayout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(addcustomerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel53)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(addcustomerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addcustomerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(addcustomerPanelLayout.createSequentialGroup()
                            .addGroup(addcustomerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel54)
                                .addComponent(jLabel77))
                            .addGap(18, 18, 18)
                            .addComponent(jLabel55))
                        .addComponent(exit3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(addcustomerPanelLayout.createSequentialGroup()
                        .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(addcustomerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addcustomerPanelLayout.createSequentialGroup()
                        .addGroup(addcustomerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel56)
                            .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(addcustomerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel57)
                            .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addcustomerPanelLayout.createSequentialGroup()
                        .addComponent(exit4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)))
                .addGroup(addcustomerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(exit5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel58)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        jPanelSlider2.add(addcustomerPanel, "card5");

        updatedeleteCustomerPanel.setBackground(new java.awt.Color(255, 255, 255));
        updatedeleteCustomerPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updatedeleteCustomerPanelMouseClicked(evt);
            }
        });

        jLabel91.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel91.setText("Customer ID :");

        jTextField28.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField28.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 204)));

        jLabel92.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel92.setText("Name :");

        jTextField29.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField29.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 204)));

        jLabel93.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel93.setText("Mobile No. :");

        jTextField30.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField30.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 204)));

        jLabel94.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel94.setText("Type :");

        jTextField31.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField31.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 204)));

        jLabel95.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel95.setText("Date :");

        jDateChooser6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 153)));
        jDateChooser6.setDateFormatString("yyyy-MM-dd");
        jDateChooser6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jTextArea4.setColumns(20);
        jTextArea4.setRows(5);
        jTextArea4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 204)));
        jScrollPane9.setViewportView(jTextArea4);

        jLabel97.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel97.setText("Address :");

        updatecustomersTable.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        updatecustomersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        updatecustomersTable.setFocusable(false);
        updatecustomersTable.setGridColor(new java.awt.Color(0, 0, 153));
        updatecustomersTable.setIntercellSpacing(new java.awt.Dimension(0, 0));
        updatecustomersTable.setRowHeight(25);
        updatecustomersTable.setSelectionBackground(new java.awt.Color(170, 228, 255));
        updatecustomersTable.getTableHeader().setReorderingAllowed(false);
        updatecustomersTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updatecustomersTableMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(updatecustomersTable);

        updatecustomers.setBackground(new java.awt.Color(255, 255, 255));
        updatecustomers.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 79, 197), 1, true));
        updatecustomers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updatecustomersMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                updatecustomersMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                updatecustomersMouseExited(evt);
            }
        });
        updatecustomers.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel98.setBackground(new java.awt.Color(255, 255, 255));
        jLabel98.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel98.setForeground(new java.awt.Color(0, 51, 255));
        jLabel98.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel98.setText("Update");
        jLabel98.setOpaque(true);
        updatecustomers.add(jLabel98, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 90, 30));

        deletecustomer.setBackground(new java.awt.Color(255, 255, 255));
        deletecustomer.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 79, 197), 1, true));
        deletecustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deletecustomerMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                deletecustomerMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                deletecustomerMouseExited(evt);
            }
        });
        deletecustomer.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel128.setBackground(new java.awt.Color(255, 255, 255));
        jLabel128.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel128.setForeground(new java.awt.Color(0, 51, 255));
        jLabel128.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel128.setText("Delete");
        jLabel128.setOpaque(true);
        deletecustomer.add(jLabel128, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 50, 30));

        clear3.setBackground(new java.awt.Color(255, 255, 255));
        clear3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 79, 197), 1, true));
        clear3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clear3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                clear3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                clear3MouseExited(evt);
            }
        });
        clear3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel129.setBackground(new java.awt.Color(255, 255, 255));
        jLabel129.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel129.setForeground(new java.awt.Color(0, 51, 255));
        jLabel129.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel129.setText("Clear");
        jLabel129.setOpaque(true);
        clear3.add(jLabel129, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 90, 30));

        javax.swing.GroupLayout updatedeleteCustomerPanelLayout = new javax.swing.GroupLayout(updatedeleteCustomerPanel);
        updatedeleteCustomerPanel.setLayout(updatedeleteCustomerPanelLayout);
        updatedeleteCustomerPanelLayout.setHorizontalGroup(
            updatedeleteCustomerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(updatedeleteCustomerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(updatedeleteCustomerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(updatedeleteCustomerPanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 753, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(updatedeleteCustomerPanelLayout.createSequentialGroup()
                        .addGroup(updatedeleteCustomerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(updatedeleteCustomerPanelLayout.createSequentialGroup()
                                .addGroup(updatedeleteCustomerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel94)
                                    .addComponent(jLabel95, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel97, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(29, 29, 29)
                                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(183, 183, 183)
                                .addComponent(deletecustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(updatedeleteCustomerPanelLayout.createSequentialGroup()
                                .addGroup(updatedeleteCustomerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel91, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel92))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(updatedeleteCustomerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField28, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(updatedeleteCustomerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jTextField29, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(updatedeleteCustomerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jTextField31)
                                            .addComponent(jTextField30)
                                            .addComponent(jDateChooser6, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addComponent(jLabel93))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(updatedeleteCustomerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(updatedeleteCustomerPanelLayout.createSequentialGroup()
                                .addComponent(clear3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(2, 2, 2))
                            .addComponent(updatecustomers, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(34, 34, 34))))
        );
        updatedeleteCustomerPanelLayout.setVerticalGroup(
            updatedeleteCustomerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(updatedeleteCustomerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(updatedeleteCustomerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel91)
                    .addComponent(jTextField28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(updatedeleteCustomerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(updatedeleteCustomerPanelLayout.createSequentialGroup()
                        .addComponent(jLabel92)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel93)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel94)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel95))
                    .addGroup(updatedeleteCustomerPanelLayout.createSequentialGroup()
                        .addComponent(jTextField29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateChooser6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(clear3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(updatedeleteCustomerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel97)
                    .addComponent(updatecustomers, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deletecustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanelSlider2.add(updatedeleteCustomerPanel, "card4");

        searchcustomerPanel.setBackground(new java.awt.Color(255, 255, 255));

        updatebooksTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        updatebooksTable2.setFocusable(false);
        updatebooksTable2.setGridColor(new java.awt.Color(0, 0, 153));
        updatebooksTable2.setIntercellSpacing(new java.awt.Dimension(0, 0));
        updatebooksTable2.setRowHeight(25);
        updatebooksTable2.setSelectionBackground(new java.awt.Color(170, 228, 255));
        updatebooksTable2.getTableHeader().setReorderingAllowed(false);
        jScrollPane10.setViewportView(updatebooksTable2);

        javax.swing.GroupLayout searchcustomerPanelLayout = new javax.swing.GroupLayout(searchcustomerPanel);
        searchcustomerPanel.setLayout(searchcustomerPanelLayout);
        searchcustomerPanelLayout.setHorizontalGroup(
            searchcustomerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchcustomerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 755, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        searchcustomerPanelLayout.setVerticalGroup(
            searchcustomerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchcustomerPanelLayout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jPanelSlider2.add(searchcustomerPanel, "card3");

        javax.swing.GroupLayout customersPanelLayout = new javax.swing.GroupLayout(customersPanel);
        customersPanel.setLayout(customersPanelLayout);
        customersPanelLayout.setHorizontalGroup(
            customersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customersPanelLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(customersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelSlider2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(customersPanelLayout.createSequentialGroup()
                        .addComponent(allcustomersbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addcustomerbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(updateDeletebutton1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchcustomerbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        customersPanelLayout.setVerticalGroup(
            customersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customersPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(customersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(allcustomersbutton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addcustomerbutton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updateDeletebutton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchcustomerbutton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(jPanelSlider2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanelSlider4.add(customersPanel, "card4");

        employeesPanel.setBackground(new java.awt.Color(255, 255, 255));
        employeesPanel.setPreferredSize(new java.awt.Dimension(816, 457));

        allemployeesbutton.setPreferredSize(new java.awt.Dimension(152, 43));
        allemployeesbutton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                allemployeesbuttonMouseClicked(evt);
            }
        });

        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel35.setText("All Employees");

        jLabel36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/all_customers_30px.png"))); // NOI18N

        javax.swing.GroupLayout allemployeesbuttonLayout = new javax.swing.GroupLayout(allemployeesbutton);
        allemployeesbutton.setLayout(allemployeesbuttonLayout);
        allemployeesbuttonLayout.setHorizontalGroup(
            allemployeesbuttonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(allemployeesbuttonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel36)
                .addGap(7, 7, 7)
                .addComponent(jLabel35, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                .addContainerGap())
        );
        allemployeesbuttonLayout.setVerticalGroup(
            allemployeesbuttonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(allemployeesbuttonLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(allemployeesbuttonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel36)
                    .addComponent(jLabel35, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)))
        );

        updatedeletebutton.setPreferredSize(new java.awt.Dimension(152, 43));
        updatedeletebutton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updatedeletebuttonMouseClicked(evt);
            }
        });

        jLabel39.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel39.setText("Update/Delete");

        jLabel40.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/update_24px.png"))); // NOI18N

        javax.swing.GroupLayout updatedeletebuttonLayout = new javax.swing.GroupLayout(updatedeletebutton);
        updatedeletebutton.setLayout(updatedeletebuttonLayout);
        updatedeletebuttonLayout.setHorizontalGroup(
            updatedeletebuttonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(updatedeletebuttonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel40)
                .addGap(7, 7, 7)
                .addComponent(jLabel39, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                .addGap(4, 4, 4))
        );
        updatedeletebuttonLayout.setVerticalGroup(
            updatedeletebuttonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(updatedeletebuttonLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(updatedeletebuttonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(updatedeletebuttonLayout.createSequentialGroup()
                        .addComponent(jLabel40)
                        .addGap(0, 8, Short.MAX_VALUE))
                    .addComponent(jLabel39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        searchemployeebutton.setBackground(new java.awt.Color(255, 255, 255));
        searchemployeebutton.setPreferredSize(new java.awt.Dimension(152, 43));
        searchemployeebutton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchemployeebuttonMouseClicked(evt);
            }
        });

        jLabel41.setBackground(new java.awt.Color(255, 255, 255));
        jLabel41.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(255, 255, 255));
        jLabel41.setText("Search");

        javax.swing.GroupLayout searchemployeebuttonLayout = new javax.swing.GroupLayout(searchemployeebutton);
        searchemployeebutton.setLayout(searchemployeebuttonLayout);
        searchemployeebuttonLayout.setHorizontalGroup(
            searchemployeebuttonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchemployeebuttonLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel41, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                .addContainerGap())
        );
        searchemployeebuttonLayout.setVerticalGroup(
            searchemployeebuttonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchemployeebuttonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel41, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE))
        );

        allemployeesPanel.setBackground(new java.awt.Color(255, 255, 255));

        jTextField43.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField43.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(4, 103, 246), 1, true));
        jTextField43.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField43KeyReleased(evt);
            }
        });

        jLabel5.setIcon(new javax.swing.ImageIcon("C:\\Users\\hp\\Documents\\NetBeansProjects\\BookStoreManagementSystem\\src\\images\\search_filter_16px.png")); // NOI18N

        allemployeesTable.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        allemployeesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        allemployeesTable.setFocusable(false);
        allemployeesTable.setGridColor(new java.awt.Color(0, 0, 153));
        allemployeesTable.setIntercellSpacing(new java.awt.Dimension(0, 0));
        allemployeesTable.setRowHeight(25);
        allemployeesTable.setSelectionBackground(new java.awt.Color(170, 228, 255));
        allemployeesTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane16.setViewportView(allemployeesTable);

        javax.swing.GroupLayout allemployeesPanelLayout = new javax.swing.GroupLayout(allemployeesPanel);
        allemployeesPanel.setLayout(allemployeesPanelLayout);
        allemployeesPanelLayout.setHorizontalGroup(
            allemployeesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(allemployeesPanelLayout.createSequentialGroup()
                .addGap(245, 245, 245)
                .addComponent(jTextField43, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, allemployeesPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 727, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );
        allemployeesPanelLayout.setVerticalGroup(
            allemployeesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, allemployeesPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(allemployeesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField43, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        jPanelSlider1.add(allemployeesPanel, "card3");

        addemployeePanel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel59.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel59.setText("Employee ID :");

        jTextField11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 204)));

        jLabel63.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel63.setText("Name :");

        jTextField12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 204)));

        jLabel64.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel64.setText("Designation :");

        jLabel65.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel65.setText("Mobile No. :");

        jTextField14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 204)));
        jTextField14.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField14KeyTyped(evt);
            }
        });

        jLabel66.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel66.setText("Starting Date :");

        jDateChooser3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 153)));
        jDateChooser3.setDateFormatString("yyyy-MM-dd");
        jDateChooser3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel67.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel67.setText("Address :");

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jTextArea2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 204)));
        jScrollPane2.setViewportView(jTextArea2);

        exit6.setBackground(new java.awt.Color(255, 255, 255));
        exit6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 79, 197), 1, true));
        exit6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exit6MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exit6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exit6MouseExited(evt);
            }
        });
        exit6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel68.setBackground(new java.awt.Color(255, 255, 255));
        jLabel68.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel68.setForeground(new java.awt.Color(0, 51, 255));
        jLabel68.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel68.setText("Save");
        jLabel68.setOpaque(true);
        exit6.add(jLabel68, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 90, 30));

        exit7.setBackground(new java.awt.Color(255, 255, 255));
        exit7.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 79, 197), 1, true));
        exit7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exit7MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exit7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exit7MouseExited(evt);
            }
        });
        exit7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel69.setBackground(new java.awt.Color(255, 255, 255));
        jLabel69.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel69.setForeground(new java.awt.Color(0, 51, 255));
        jLabel69.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel69.setText("Clear");
        jLabel69.setOpaque(true);
        exit7.add(jLabel69, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 90, 30));

        exit8.setBackground(new java.awt.Color(255, 255, 255));
        exit8.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 79, 197), 1, true));
        exit8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exit8MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exit8MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exit8MouseExited(evt);
            }
        });
        exit8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel70.setBackground(new java.awt.Color(255, 255, 255));
        jLabel70.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel70.setForeground(new java.awt.Color(0, 51, 255));
        jLabel70.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel70.setText("Cancel");
        jLabel70.setOpaque(true);
        exit8.add(jLabel70, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 90, 30));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "supervisor", "helper", "cleaner", " " }));
        jComboBox1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 204)));

        jLabel71.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel71.setText("Salary :");

        jTextField13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 204)));
        jTextField13.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField13KeyTyped(evt);
            }
        });

        jLabel100.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel100.setText("Status :");

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Active", "Not Active" }));

        javax.swing.GroupLayout addemployeePanelLayout = new javax.swing.GroupLayout(addemployeePanel);
        addemployeePanel.setLayout(addemployeePanelLayout);
        addemployeePanelLayout.setHorizontalGroup(
            addemployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addemployeePanelLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(addemployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addemployeePanelLayout.createSequentialGroup()
                        .addGroup(addemployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel63, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel59))
                        .addGroup(addemployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(addemployeePanelLayout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(addemployeePanelLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(addemployeePanelLayout.createSequentialGroup()
                        .addGroup(addemployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel65, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel71)
                            .addComponent(jLabel66)
                            .addComponent(jLabel64, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel67, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(addemployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addComponent(jTextField14)
                            .addComponent(jDateChooser3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(addemployeePanelLayout.createSequentialGroup()
                                .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel100)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(194, 194, 194)
                .addGroup(addemployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(exit8, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(exit7, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(exit6, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(88, 88, 88))
        );
        addemployeePanelLayout.setVerticalGroup(
            addemployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addemployeePanelLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(addemployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(exit6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addemployeePanelLayout.createSequentialGroup()
                        .addGroup(addemployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(addemployeePanelLayout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addGroup(addemployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel63)
                                    .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(addemployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel59)))
                        .addGap(18, 18, 18)
                        .addGroup(addemployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel64)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(addemployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addemployeePanelLayout.createSequentialGroup()
                        .addGroup(addemployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel65)
                            .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(addemployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel66)
                            .addComponent(jDateChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(addemployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel71)
                            .addGroup(addemployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel100)
                                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addemployeePanelLayout.createSequentialGroup()
                        .addComponent(exit7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)))
                .addGroup(addemployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addemployeePanelLayout.createSequentialGroup()
                        .addGroup(addemployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(addemployeePanelLayout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(exit8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel67, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addemployeePanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanelSlider1.add(addemployeePanel, "card4");

        updatedeletePanel.setBackground(new java.awt.Color(255, 255, 255));
        updatedeletePanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updatedeletePanelMouseClicked(evt);
            }
        });

        updateemployeesTable.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        updateemployeesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        updateemployeesTable.setFocusable(false);
        updateemployeesTable.setGridColor(new java.awt.Color(0, 0, 153));
        updateemployeesTable.setIntercellSpacing(new java.awt.Dimension(0, 0));
        updateemployeesTable.setRowHeight(25);
        updateemployeesTable.setSelectionBackground(new java.awt.Color(170, 228, 255));
        updateemployeesTable.getTableHeader().setReorderingAllowed(false);
        updateemployeesTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updateemployeesTableMouseClicked(evt);
            }
        });
        jScrollPane11.setViewportView(updateemployeesTable);

        jLabel101.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel101.setText("Employee ID :");

        jTextField32.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField32.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 204)));

        jLabel102.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel102.setText("Name :");

        jTextField33.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField33.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 204)));

        jLabel103.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel103.setText("Designation :");

        jTextField34.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField34.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 204)));

        jLabel104.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel104.setText("Mobile No. :");

        jTextField35.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField35.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 204)));

        jLabel105.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel105.setText("Starting Date :");

        jDateChooser7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 153)));
        jDateChooser7.setDateFormatString("yyyy-MM-dd");
        jDateChooser7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel106.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel106.setText("Address :");

        jTextArea5.setColumns(20);
        jTextArea5.setRows(5);
        jTextArea5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 204)));
        jScrollPane12.setViewportView(jTextArea5);

        updateemployees.setBackground(new java.awt.Color(255, 255, 255));
        updateemployees.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 79, 197), 1, true));
        updateemployees.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updateemployeesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                updateemployeesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                updateemployeesMouseExited(evt);
            }
        });
        updateemployees.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel107.setBackground(new java.awt.Color(255, 255, 255));
        jLabel107.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel107.setForeground(new java.awt.Color(0, 51, 255));
        jLabel107.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel107.setText("Update");
        jLabel107.setOpaque(true);
        updateemployees.add(jLabel107, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 80, 30));

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "supervisor", "helper", "cleaner" }));
        jComboBox4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 204)));

        jLabel108.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel108.setText("Salary :");

        jLabel109.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel109.setText("Status :");

        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "active", "not active" }));
        jComboBox5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 204)));

        clear4.setBackground(new java.awt.Color(255, 255, 255));
        clear4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 79, 197), 1, true));
        clear4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clear4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                clear4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                clear4MouseExited(evt);
            }
        });
        clear4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel130.setBackground(new java.awt.Color(255, 255, 255));
        jLabel130.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel130.setForeground(new java.awt.Color(0, 51, 255));
        jLabel130.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel130.setText("Clear");
        jLabel130.setOpaque(true);
        clear4.add(jLabel130, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 60, 30));

        deleteemployee.setBackground(new java.awt.Color(255, 255, 255));
        deleteemployee.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 79, 197), 1, true));
        deleteemployee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteemployeeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                deleteemployeeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                deleteemployeeMouseExited(evt);
            }
        });
        deleteemployee.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel131.setBackground(new java.awt.Color(255, 255, 255));
        jLabel131.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel131.setForeground(new java.awt.Color(0, 51, 255));
        jLabel131.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel131.setText("Delete");
        jLabel131.setOpaque(true);
        deleteemployee.add(jLabel131, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 50, 30));

        javax.swing.GroupLayout updatedeletePanelLayout = new javax.swing.GroupLayout(updatedeletePanel);
        updatedeletePanel.setLayout(updatedeletePanelLayout);
        updatedeletePanelLayout.setHorizontalGroup(
            updatedeletePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(updatedeletePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(updatedeletePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(updatedeletePanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane11)
                        .addContainerGap())
                    .addGroup(updatedeletePanelLayout.createSequentialGroup()
                        .addGroup(updatedeletePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(updatedeletePanelLayout.createSequentialGroup()
                                .addGroup(updatedeletePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel101, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel102))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField32, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel103)
                            .addComponent(jLabel105)
                            .addGroup(updatedeletePanelLayout.createSequentialGroup()
                                .addGroup(updatedeletePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel104)
                                    .addComponent(jLabel106, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27)
                                .addGroup(updatedeletePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane12)
                                    .addComponent(jTextField33, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
                                    .addComponent(jTextField35)
                                    .addComponent(jDateChooser7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
                                    .addComponent(jComboBox4, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGroup(updatedeletePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(updatedeletePanelLayout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(updatedeletePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(updatedeletePanelLayout.createSequentialGroup()
                                        .addComponent(jLabel109)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(updatedeletePanelLayout.createSequentialGroup()
                                        .addComponent(jLabel108)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextField34, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, updatedeletePanelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(deleteemployee, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(updatedeletePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(updateemployees, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                            .addComponent(clear4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(23, 23, 23))))
        );
        updatedeletePanelLayout.setVerticalGroup(
            updatedeletePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(updatedeletePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(updatedeletePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel101)
                    .addComponent(jTextField32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel108)
                    .addComponent(jTextField34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(updatedeletePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(updatedeletePanelLayout.createSequentialGroup()
                        .addComponent(jLabel102)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(updatedeletePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel103)
                            .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel104)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel105))
                    .addGroup(updatedeletePanelLayout.createSequentialGroup()
                        .addGroup(updatedeletePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel109)
                            .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addComponent(jTextField35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateChooser7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(clear4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(updatedeletePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel106)
                    .addComponent(updateemployees, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteemployee, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanelSlider1.add(updatedeletePanel, "card5");

        searchemployeePanel.setBackground(new java.awt.Color(204, 204, 255));

        javax.swing.GroupLayout searchemployeePanelLayout = new javax.swing.GroupLayout(searchemployeePanel);
        searchemployeePanel.setLayout(searchemployeePanelLayout);
        searchemployeePanelLayout.setHorizontalGroup(
            searchemployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 754, Short.MAX_VALUE)
        );
        searchemployeePanelLayout.setVerticalGroup(
            searchemployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 357, Short.MAX_VALUE)
        );

        jPanelSlider1.add(searchemployeePanel, "card2");

        addemployeebutton.setPreferredSize(new java.awt.Dimension(152, 43));
        addemployeebutton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addemployeebuttonMouseClicked(evt);
            }
        });

        jLabel43.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel43.setText("Add Employee");

        jLabel44.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add_employees_30px.png"))); // NOI18N

        javax.swing.GroupLayout addemployeebuttonLayout = new javax.swing.GroupLayout(addemployeebutton);
        addemployeebutton.setLayout(addemployeebuttonLayout);
        addemployeebuttonLayout.setHorizontalGroup(
            addemployeebuttonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addemployeebuttonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel44)
                .addGap(7, 7, 7)
                .addComponent(jLabel43, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        addemployeebuttonLayout.setVerticalGroup(
            addemployeebuttonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addemployeebuttonLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(addemployeebuttonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel44)
                    .addComponent(jLabel43, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout employeesPanelLayout = new javax.swing.GroupLayout(employeesPanel);
        employeesPanel.setLayout(employeesPanelLayout);
        employeesPanelLayout.setHorizontalGroup(
            employeesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, employeesPanelLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(employeesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, 758, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(employeesPanelLayout.createSequentialGroup()
                        .addComponent(allemployeesbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addemployeebutton, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(updatedeletebutton, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchemployeebutton, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25))
        );
        employeesPanelLayout.setVerticalGroup(
            employeesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(employeesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(employeesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(allemployeesbutton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updatedeletebutton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchemployeebutton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addemployeebutton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(jPanelSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelSlider4.add(employeesPanel, "card5");

        suppliersPanel.setBackground(new java.awt.Color(255, 255, 255));

        allsuppliersbutton.setPreferredSize(new java.awt.Dimension(152, 43));
        allsuppliersbutton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                allsuppliersbuttonMouseClicked(evt);
            }
        });

        jLabel37.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel37.setText("All Suppliers");

        jLabel38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/all_customers_30px.png"))); // NOI18N

        javax.swing.GroupLayout allsuppliersbuttonLayout = new javax.swing.GroupLayout(allsuppliersbutton);
        allsuppliersbutton.setLayout(allsuppliersbuttonLayout);
        allsuppliersbuttonLayout.setHorizontalGroup(
            allsuppliersbuttonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(allsuppliersbuttonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel38)
                .addGap(7, 7, 7)
                .addComponent(jLabel37, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                .addContainerGap())
        );
        allsuppliersbuttonLayout.setVerticalGroup(
            allsuppliersbuttonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(allsuppliersbuttonLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(allsuppliersbuttonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel38)
                    .addComponent(jLabel37, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)))
        );

        addsupplierbutton.setPreferredSize(new java.awt.Dimension(152, 43));
        addsupplierbutton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addsupplierbuttonMouseClicked(evt);
            }
        });

        jLabel45.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel45.setText("Add Supplier");

        jLabel46.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add_employees_30px.png"))); // NOI18N

        javax.swing.GroupLayout addsupplierbuttonLayout = new javax.swing.GroupLayout(addsupplierbutton);
        addsupplierbutton.setLayout(addsupplierbuttonLayout);
        addsupplierbuttonLayout.setHorizontalGroup(
            addsupplierbuttonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addsupplierbuttonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel46)
                .addGap(7, 7, 7)
                .addComponent(jLabel45, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                .addContainerGap())
        );
        addsupplierbuttonLayout.setVerticalGroup(
            addsupplierbuttonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addsupplierbuttonLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(addsupplierbuttonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel46)
                    .addComponent(jLabel45, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)))
        );

        updatedeletesupplierbutton.setPreferredSize(new java.awt.Dimension(152, 43));
        updatedeletesupplierbutton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updatedeletesupplierbuttonMouseClicked(evt);
            }
        });

        jLabel47.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel47.setText("Update/Delete");

        jLabel48.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/renew_subscription_32px.png"))); // NOI18N

        javax.swing.GroupLayout updatedeletesupplierbuttonLayout = new javax.swing.GroupLayout(updatedeletesupplierbutton);
        updatedeletesupplierbutton.setLayout(updatedeletesupplierbuttonLayout);
        updatedeletesupplierbuttonLayout.setHorizontalGroup(
            updatedeletesupplierbuttonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(updatedeletesupplierbuttonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel48)
                .addGap(7, 7, 7)
                .addComponent(jLabel47, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(4, 4, 4))
        );
        updatedeletesupplierbuttonLayout.setVerticalGroup(
            updatedeletesupplierbuttonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(updatedeletesupplierbuttonLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(updatedeletesupplierbuttonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(updatedeletesupplierbuttonLayout.createSequentialGroup()
                        .addComponent(jLabel48)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel47, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        searchsupplierbutton.setPreferredSize(new java.awt.Dimension(152, 43));
        searchsupplierbutton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchsupplierbuttonMouseClicked(evt);
            }
        });

        jLabel49.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel49.setText("Purchase re..");

        jLabel50.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search_customer_24px.png"))); // NOI18N

        javax.swing.GroupLayout searchsupplierbuttonLayout = new javax.swing.GroupLayout(searchsupplierbutton);
        searchsupplierbutton.setLayout(searchsupplierbuttonLayout);
        searchsupplierbuttonLayout.setHorizontalGroup(
            searchsupplierbuttonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchsupplierbuttonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel50)
                .addGap(7, 7, 7)
                .addComponent(jLabel49, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        searchsupplierbuttonLayout.setVerticalGroup(
            searchsupplierbuttonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchsupplierbuttonLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(searchsupplierbuttonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(searchsupplierbuttonLayout.createSequentialGroup()
                        .addComponent(jLabel50)
                        .addGap(0, 8, Short.MAX_VALUE))
                    .addComponent(jLabel49, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        allsuppliersPanel.setBackground(new java.awt.Color(255, 255, 255));

        jTextField42.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField42.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(4, 103, 246), 1, true));
        jTextField42.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField42KeyReleased(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Users\\hp\\Documents\\NetBeansProjects\\BookStoreManagementSystem\\src\\images\\search_filter_16px.png")); // NOI18N

        allsuppliersTable.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        allsuppliersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        allsuppliersTable.setFocusable(false);
        allsuppliersTable.setGridColor(new java.awt.Color(0, 0, 153));
        allsuppliersTable.setIntercellSpacing(new java.awt.Dimension(0, 0));
        allsuppliersTable.setRowHeight(25);
        allsuppliersTable.setSelectionBackground(new java.awt.Color(170, 228, 255));
        allsuppliersTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane15.setViewportView(allsuppliersTable);

        javax.swing.GroupLayout allsuppliersPanelLayout = new javax.swing.GroupLayout(allsuppliersPanel);
        allsuppliersPanel.setLayout(allsuppliersPanelLayout);
        allsuppliersPanelLayout.setHorizontalGroup(
            allsuppliersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(allsuppliersPanelLayout.createSequentialGroup()
                .addGap(245, 245, 245)
                .addComponent(jTextField42, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, allsuppliersPanelLayout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 751, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        allsuppliersPanelLayout.setVerticalGroup(
            allsuppliersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, allsuppliersPanelLayout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(allsuppliersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField42, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        jPanelSlider5.add(allsuppliersPanel, "card3");

        addsupplierPanel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel72.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel72.setText("Supplier ID :");

        jTextField15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 204)));

        jLabel73.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel73.setText("Name :");

        jTextField16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 204)));

        jLabel74.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel74.setText("Agency :");

        jLabel75.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel75.setText("Mobile No. :");

        jTextField17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 204)));
        jTextField17.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField17KeyTyped(evt);
            }
        });

        jLabel76.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel76.setText("Starting Date :");

        jDateChooser4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 153)));
        jDateChooser4.setDateFormatString("yyyy-MM-dd");
        jDateChooser4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel78.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel78.setText("Address :");

        jTextArea3.setColumns(20);
        jTextArea3.setRows(5);
        jTextArea3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 204)));
        jScrollPane3.setViewportView(jTextArea3);

        exit9.setBackground(new java.awt.Color(255, 255, 255));
        exit9.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 79, 197), 1, true));
        exit9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exit9MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exit9MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exit9MouseExited(evt);
            }
        });
        exit9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel79.setBackground(new java.awt.Color(255, 255, 255));
        jLabel79.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel79.setForeground(new java.awt.Color(0, 51, 255));
        jLabel79.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel79.setText("Save");
        jLabel79.setOpaque(true);
        exit9.add(jLabel79, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 90, 30));

        exit10.setBackground(new java.awt.Color(255, 255, 255));
        exit10.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 79, 197), 1, true));
        exit10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exit10MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exit10MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exit10MouseExited(evt);
            }
        });
        exit10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel80.setBackground(new java.awt.Color(255, 255, 255));
        jLabel80.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel80.setForeground(new java.awt.Color(0, 51, 255));
        jLabel80.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel80.setText("Clear");
        jLabel80.setOpaque(true);
        exit10.add(jLabel80, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 90, 30));

        exit11.setBackground(new java.awt.Color(255, 255, 255));
        exit11.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 79, 197), 1, true));
        exit11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exit11MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exit11MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exit11MouseExited(evt);
            }
        });
        exit11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel81.setBackground(new java.awt.Color(255, 255, 255));
        jLabel81.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel81.setForeground(new java.awt.Color(0, 51, 255));
        jLabel81.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel81.setText("Cancel");
        jLabel81.setOpaque(true);
        exit11.add(jLabel81, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 90, 30));

        jTextField18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 204)));

        jLabel110.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel110.setText("Email Add. :");

        jTextField36.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField36.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 204)));

        javax.swing.GroupLayout addsupplierPanelLayout = new javax.swing.GroupLayout(addsupplierPanel);
        addsupplierPanel.setLayout(addsupplierPanelLayout);
        addsupplierPanelLayout.setHorizontalGroup(
            addsupplierPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addsupplierPanelLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(addsupplierPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addsupplierPanelLayout.createSequentialGroup()
                        .addGroup(addsupplierPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel75, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel76)
                            .addComponent(jLabel110, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel78, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(addsupplierPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane3)
                            .addComponent(jTextField36, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField17, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDateChooser4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE))
                        .addGap(194, 194, 194))
                    .addGroup(addsupplierPanelLayout.createSequentialGroup()
                        .addGroup(addsupplierPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel74, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(addsupplierPanelLayout.createSequentialGroup()
                                .addGroup(addsupplierPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel72)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addsupplierPanelLayout.createSequentialGroup()
                                        .addComponent(jLabel73, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(24, 24, 24)))
                                .addGroup(addsupplierPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(addsupplierPanelLayout.createSequentialGroup()
                                .addGap(121, 121, 121)
                                .addComponent(jTextField18, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(addsupplierPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(exit11, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(exit10, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(exit9, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(95, 95, 95))
        );
        addsupplierPanelLayout.setVerticalGroup(
            addsupplierPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addsupplierPanelLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(addsupplierPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(exit9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addsupplierPanelLayout.createSequentialGroup()
                        .addGroup(addsupplierPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(addsupplierPanelLayout.createSequentialGroup()
                                .addGroup(addsupplierPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel72)
                                    .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel73))
                            .addGroup(addsupplierPanelLayout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(addsupplierPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel74)
                            .addComponent(jTextField18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(addsupplierPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addsupplierPanelLayout.createSequentialGroup()
                        .addGroup(addsupplierPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel75)
                            .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(addsupplierPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel76)
                            .addComponent(jDateChooser4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addsupplierPanelLayout.createSequentialGroup()
                        .addComponent(exit10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)))
                .addGroup(addsupplierPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addsupplierPanelLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(exit11, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addsupplierPanelLayout.createSequentialGroup()
                        .addGroup(addsupplierPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel110)
                            .addComponent(jTextField36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(addsupplierPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel78)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19))))
        );

        jPanelSlider5.add(addsupplierPanel, "card4");

        updatedeletesupplierPanel.setBackground(new java.awt.Color(255, 255, 255));
        updatedeletesupplierPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updatedeletesupplierPanelMouseClicked(evt);
            }
        });

        updatesuppliersTable.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        updatesuppliersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        updatesuppliersTable.setFocusable(false);
        updatesuppliersTable.setGridColor(new java.awt.Color(0, 0, 153));
        updatesuppliersTable.setIntercellSpacing(new java.awt.Dimension(0, 0));
        updatesuppliersTable.setRowHeight(25);
        updatesuppliersTable.setSelectionBackground(new java.awt.Color(170, 228, 255));
        updatesuppliersTable.getTableHeader().setReorderingAllowed(false);
        updatesuppliersTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updatesuppliersTableMouseClicked(evt);
            }
        });
        jScrollPane13.setViewportView(updatesuppliersTable);

        jLabel111.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel111.setText("Supplier ID :");

        jTextField37.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField37.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 204)));

        jLabel112.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel112.setText("Name :");

        jTextField38.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField38.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 204)));

        jLabel113.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel113.setText("Agency :");

        jTextField39.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField39.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 204)));

        jLabel114.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel114.setText("Mobile No. :");

        jTextField40.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField40.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 204)));

        jLabel115.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel115.setText("Starting Date :");

        jDateChooser8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 153)));
        jDateChooser8.setDateFormatString("yyyy-MM-dd");
        jDateChooser8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel116.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel116.setText("Address :");

        jTextArea6.setColumns(20);
        jTextArea6.setRows(5);
        jTextArea6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 204)));
        jScrollPane14.setViewportView(jTextArea6);

        updatesuppliers.setBackground(new java.awt.Color(255, 255, 255));
        updatesuppliers.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 79, 197), 1, true));
        updatesuppliers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updatesuppliersMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                updatesuppliersMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                updatesuppliersMouseExited(evt);
            }
        });
        updatesuppliers.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel117.setBackground(new java.awt.Color(255, 255, 255));
        jLabel117.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel117.setForeground(new java.awt.Color(0, 51, 255));
        jLabel117.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel117.setText("Update");
        jLabel117.setOpaque(true);
        updatesuppliers.add(jLabel117, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 90, 30));

        jLabel118.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel118.setText("Email Add. :");

        jTextField41.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField41.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 204)));

        clear5.setBackground(new java.awt.Color(255, 255, 255));
        clear5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 79, 197), 1, true));
        clear5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clear5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                clear5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                clear5MouseExited(evt);
            }
        });
        clear5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel132.setBackground(new java.awt.Color(255, 255, 255));
        jLabel132.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel132.setForeground(new java.awt.Color(0, 51, 255));
        jLabel132.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel132.setText("Clear");
        jLabel132.setOpaque(true);
        clear5.add(jLabel132, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 60, 30));

        deleteemployee1.setBackground(new java.awt.Color(255, 255, 255));
        deleteemployee1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 79, 197), 1, true));
        deleteemployee1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteemployee1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                deleteemployee1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                deleteemployee1MouseExited(evt);
            }
        });
        deleteemployee1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel133.setBackground(new java.awt.Color(255, 255, 255));
        jLabel133.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel133.setForeground(new java.awt.Color(0, 51, 255));
        jLabel133.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel133.setText("Delete");
        jLabel133.setOpaque(true);
        deleteemployee1.add(jLabel133, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 50, 30));

        javax.swing.GroupLayout updatedeletesupplierPanelLayout = new javax.swing.GroupLayout(updatedeletesupplierPanel);
        updatedeletesupplierPanel.setLayout(updatedeletesupplierPanelLayout);
        updatedeletesupplierPanelLayout.setHorizontalGroup(
            updatedeletesupplierPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(updatedeletesupplierPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(updatedeletesupplierPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(updatedeletesupplierPanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane13)
                        .addContainerGap())
                    .addGroup(updatedeletesupplierPanelLayout.createSequentialGroup()
                        .addGroup(updatedeletesupplierPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(updatedeletesupplierPanelLayout.createSequentialGroup()
                                .addGroup(updatedeletesupplierPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel114)
                                    .addComponent(jLabel116, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(29, 29, 29)
                                .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(187, 187, 187)
                                .addComponent(deleteemployee1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(updatesuppliers, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE))
                            .addGroup(updatedeletesupplierPanelLayout.createSequentialGroup()
                                .addGroup(updatedeletesupplierPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel111, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel112))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(updatedeletesupplierPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(updatedeletesupplierPanelLayout.createSequentialGroup()
                                        .addComponent(jTextField37, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(97, 97, 97)
                                        .addComponent(jLabel118)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jTextField41, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(44, 44, 44))
                                    .addGroup(updatedeletesupplierPanelLayout.createSequentialGroup()
                                        .addGroup(updatedeletesupplierPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jTextField38, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(updatedeletesupplierPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jTextField40)
                                                .addComponent(jTextField39)
                                                .addComponent(jDateChooser8, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(297, 297, 297)
                                        .addComponent(clear5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addComponent(jLabel113)
                            .addComponent(jLabel115))
                        .addGap(34, 34, 34))))
        );
        updatedeletesupplierPanelLayout.setVerticalGroup(
            updatedeletesupplierPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(updatedeletesupplierPanelLayout.createSequentialGroup()
                .addGroup(updatedeletesupplierPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(updatedeletesupplierPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(updatedeletesupplierPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(updatedeletesupplierPanelLayout.createSequentialGroup()
                                .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(updatedeletesupplierPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel111)
                                    .addComponent(jTextField37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(updatedeletesupplierPanelLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel118))))
                    .addGroup(updatedeletesupplierPanelLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextField41, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(updatedeletesupplierPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(updatedeletesupplierPanelLayout.createSequentialGroup()
                        .addComponent(jLabel112)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel113)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel114)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel115))
                    .addGroup(updatedeletesupplierPanelLayout.createSequentialGroup()
                        .addComponent(jTextField38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField40, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateChooser8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(clear5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(updatedeletesupplierPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel116)
                    .addComponent(updatesuppliers, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteemployee1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanelSlider5.add(updatedeletesupplierPanel, "card5");

        searchsuppliersPanel.setBackground(new java.awt.Color(204, 204, 255));

        javax.swing.GroupLayout searchsuppliersPanelLayout = new javax.swing.GroupLayout(searchsuppliersPanel);
        searchsuppliersPanel.setLayout(searchsuppliersPanelLayout);
        searchsuppliersPanelLayout.setHorizontalGroup(
            searchsuppliersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 775, Short.MAX_VALUE)
        );
        searchsuppliersPanelLayout.setVerticalGroup(
            searchsuppliersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 367, Short.MAX_VALUE)
        );

        jPanelSlider5.add(searchsuppliersPanel, "card2");

        javax.swing.GroupLayout suppliersPanelLayout = new javax.swing.GroupLayout(suppliersPanel);
        suppliersPanel.setLayout(suppliersPanelLayout);
        suppliersPanelLayout.setHorizontalGroup(
            suppliersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(suppliersPanelLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(suppliersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelSlider5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(suppliersPanelLayout.createSequentialGroup()
                        .addComponent(allsuppliersbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addsupplierbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(updatedeletesupplierbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchsupplierbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        suppliersPanelLayout.setVerticalGroup(
            suppliersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(suppliersPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(suppliersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(allsuppliersbutton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updatedeletesupplierbutton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchsupplierbutton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addsupplierbutton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(jPanelSlider5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanelSlider4.add(suppliersPanel, "card6");

        javax.swing.GroupLayout paymentsPanelLayout = new javax.swing.GroupLayout(paymentsPanel);
        paymentsPanel.setLayout(paymentsPanelLayout);
        paymentsPanelLayout.setHorizontalGroup(
            paymentsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 828, Short.MAX_VALUE)
        );
        paymentsPanelLayout.setVerticalGroup(
            paymentsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 424, Short.MAX_VALUE)
        );

        jPanelSlider4.add(paymentsPanel, "card7");

        minimize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/minimize_window_32px.png"))); // NOI18N
        minimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minimizeMouseClicked(evt);
            }
        });

        close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/close_windows_32px.png"))); // NOI18N
        close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                closeMouseEntered(evt);
            }
        });

        javax.swing.GroupLayout BgPanelLayout = new javax.swing.GroupLayout(BgPanel);
        BgPanel.setLayout(BgPanelLayout);
        BgPanelLayout.setHorizontalGroup(
            BgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BgPanelLayout.createSequentialGroup()
                .addComponent(sidePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(BgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BgPanelLayout.createSequentialGroup()
                        .addGap(0, 773, Short.MAX_VALUE)
                        .addComponent(minimize)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(close))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(BgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BgPanelLayout.createSequentialGroup()
                    .addContainerGap(228, Short.MAX_VALUE)
                    .addComponent(jPanelSlider4, javax.swing.GroupLayout.PREFERRED_SIZE, 828, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );
        BgPanelLayout.setVerticalGroup(
            BgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sidePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 608, Short.MAX_VALUE)
            .addGroup(BgPanelLayout.createSequentialGroup()
                .addGroup(BgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(minimize)
                    .addComponent(close))
                .addGap(48, 48, 48)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(BgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BgPanelLayout.createSequentialGroup()
                    .addContainerGap(173, Short.MAX_VALUE)
                    .addComponent(jPanelSlider4, javax.swing.GroupLayout.PREFERRED_SIZE, 424, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BgPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BgPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void booksPanel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_booksPanel2MouseEntered
        // TODO add your handling code here:
        booksPanel2.setBackground(new Color(0,51,255));
    }//GEN-LAST:event_booksPanel2MouseEntered

    private void homePanel1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homePanel1MouseExited
        // TODO add your handling code here:
        homePanel1.setBackground(new Color(4,103,246));
    }//GEN-LAST:event_homePanel1MouseExited

    private void homePanel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homePanel1MouseEntered
        // TODO add your handling code here:
        homePanel1.setBackground(new Color(0,51,255));
    
    }//GEN-LAST:event_homePanel1MouseEntered

    private void booksPanel2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_booksPanel2MouseExited
        // TODO add your handling code here:
        booksPanel2.setBackground(new Color(4,103,246));
    }//GEN-LAST:event_booksPanel2MouseExited

    private void custmersPanel3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_custmersPanel3MouseEntered
        // TODO add your handling code here:
        custmersPanel3.setBackground(new Color(0,51,255));
    }//GEN-LAST:event_custmersPanel3MouseEntered

    private void custmersPanel3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_custmersPanel3MouseExited
        // TODO add your handling code here:
        custmersPanel3.setBackground(new Color(4,103,246));
    }//GEN-LAST:event_custmersPanel3MouseExited

    private void employeesPanel4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_employeesPanel4MouseEntered
        // TODO add your handling code here:
        employeesPanel4.setBackground(new Color(0,51,255));
    }//GEN-LAST:event_employeesPanel4MouseEntered

    private void employeesPanel4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_employeesPanel4MouseExited
        // TODO add your handling code here:
        employeesPanel4.setBackground(new Color(4,103,246));
    }//GEN-LAST:event_employeesPanel4MouseExited

    private void booksPanel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_booksPanel2MouseClicked
        // TODO add your handling code here:
        jLabel9.setText("Books");
        booksPanel.setVisible(true);
        homePanel.setVisible(false);
        customersPanel.setVisible(false);
        employeesPanel.setVisible(false);
        updatebooks();
    }//GEN-LAST:event_booksPanel2MouseClicked

    private void homePanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homePanel1MouseClicked
        // TODO add your handling code here:
        jLabel9.setText("Home");
        homePanel.setVisible(true);
        booksPanel.setVisible(false);
        customersPanel.setVisible(false);
        employeesPanel.setVisible(false);
        
    }//GEN-LAST:event_homePanel1MouseClicked

    private void suppliersPanel5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_suppliersPanel5MouseEntered
        // TODO add your handling code here:
        suppliersPanel5.setBackground(new Color(0,51,255));
    }//GEN-LAST:event_suppliersPanel5MouseEntered

    private void suppliersPanel5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_suppliersPanel5MouseExited
        // TODO add your handling code here:
        suppliersPanel5.setBackground(new Color(4,103,246));
    }//GEN-LAST:event_suppliersPanel5MouseExited

    private void paymentsPanel6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paymentsPanel6MouseEntered
        // TODO add your handling code here:
        paymentsPanel6.setBackground(new Color(0,51,255));
    }//GEN-LAST:event_paymentsPanel6MouseEntered

    private void paymentsPanel6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paymentsPanel6MouseExited
        // TODO add your handling code here:
        paymentsPanel6.setBackground(new Color(4,103,246));
    }//GEN-LAST:event_paymentsPanel6MouseExited

    private void custmersPanel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_custmersPanel3MouseClicked
        // TODO add your handling code here:
        jLabel9.setText("Customers");
        customersPanel.setVisible(true);
        homePanel.setVisible(false);
        booksPanel.setVisible(false);
        employeesPanel.setVisible(false);
        
       updatecustomers();
    }//GEN-LAST:event_custmersPanel3MouseClicked

    private void employeesPanel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_employeesPanel4MouseClicked
        // TODO add your handling code here:
        jLabel9.setText("Employees");
        employeesPanel.setVisible(true);
        homePanel.setVisible(false);
        booksPanel.setVisible(false);
        customersPanel.setVisible(false);
        updateemployees();
    
    }//GEN-LAST:event_employeesPanel4MouseClicked

    private void allbooksbuttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_allbooksbuttonMouseClicked
        // TODO add your handling code here:
        allbooksPanel.setVisible(true);
        addbookPanel.setVisible(false);
        updatedeletebooksPanel.setVisible(false);
        searchbooksPanel.setVisible(false);
        allbooksbutton.setBackground(new Color(255,255,255));
        //allbooksbutton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51,51,255)));
        
        updatebooks();
    }//GEN-LAST:event_allbooksbuttonMouseClicked

    private void addbooksbuttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addbooksbuttonMouseClicked
        // TODO add your handling code here:
        addbookPanel.setVisible(true);
        allbooksPanel.setVisible(false);
        updatedeletebooksPanel.setVisible(false);
        searchbooksPanel.setVisible(false);
        
        addbooksbutton.setBackground(new Color(255,255,255));
        //addbooksbutton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51,51,255)));
        
        //[765, 390]
        
        
        
    }//GEN-LAST:event_addbooksbuttonMouseClicked

    private void allcustomersbuttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_allcustomersbuttonMouseClicked
        // TODO add your handling code here:
        allcustomersPanel.setVisible(true);
        addcustomerPanel.setVisible(false);
        updatedeleteCustomerPanel.setVisible(false);
        searchcustomerPanel.setVisible(false); 
        
        updatecustomers();
        
    }//GEN-LAST:event_allcustomersbuttonMouseClicked

    private void addcustomerbuttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addcustomerbuttonMouseClicked
        // TODO add your handling code here:
        allcustomersPanel.setVisible(false);
        addcustomerPanel.setVisible(true);
        updatedeleteCustomerPanel.setVisible(false);
        searchcustomerPanel.setVisible(false);
    }//GEN-LAST:event_addcustomerbuttonMouseClicked

    private void minimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeMouseClicked
        // TODO add your handling code here:
        this.setState(this.ICONIFIED);
    }//GEN-LAST:event_minimizeMouseClicked

    private void allemployeesbuttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_allemployeesbuttonMouseClicked
        // TODO add your handling code here:
        allemployeesPanel.setVisible(true);
        addemployeePanel.setVisible(false);
        updatedeletePanel.setVisible(false);
        searchemployeePanel.setVisible(false);
        try{
        conn=DatabaseConnection.ConnectDB();
        String sqll="select employeeid as 'Employee ID',ename as 'Name',edesignation as 'Designation',mobile_no as 'Mobile No.',starting_date as 'Starting Date',salary as 'Salary',status as 'Status',address as 'Address' from employees ";
        PreparedStatement pstmt=conn.prepareStatement(sqll);
        ResultSet rss=pstmt.executeQuery();
        
        allemployeesTable.setModel(DbUtils.resultSetToTableModel(rss));
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    }//GEN-LAST:event_allemployeesbuttonMouseClicked

    private void addemployeebuttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addemployeebuttonMouseClicked
        // TODO add your handling code here:
        allemployeesPanel.setVisible(false);
        addemployeePanel.setVisible(true);
        updatedeletePanel.setVisible(false);
        searchemployeePanel.setVisible(false);
    }//GEN-LAST:event_addemployeebuttonMouseClicked

    private void updatedeletebuttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updatedeletebuttonMouseClicked
        // TODO add your handling code here:
        allemployeesPanel.setVisible(false);
        addemployeePanel.setVisible(false);
        updatedeletePanel.setVisible(true);
        searchemployeePanel.setVisible(false);
        
        try{
        conn=DatabaseConnection.ConnectDB();
        String sqll="select employeeid as 'Employee ID',ename as 'Name',edesignation as 'Designation',mobile_no as 'Mobile No.',starting_date as 'Starting Date',salary as 'Salary',status as 'Status',address as 'Address' from employees ";
        PreparedStatement pstmt=conn.prepareStatement(sqll);
        ResultSet rss=pstmt.executeQuery();
        
        updateemployeesTable.setModel(DbUtils.resultSetToTableModel(rss));
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    }//GEN-LAST:event_updatedeletebuttonMouseClicked

    private void searchemployeebuttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchemployeebuttonMouseClicked
       /* 
        allemployeesPanel.setVisible(false);
        addemployeePanel.setVisible(false);
        updatedeletePanel.setVisible(false);
        searchemployeePanel.setVisible(true);*/
    }//GEN-LAST:event_searchemployeebuttonMouseClicked

    private void updateDeletebutton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateDeletebutton1MouseClicked
        
        allcustomersPanel.setVisible(false);
        addcustomerPanel.setVisible(false);
        updatedeleteCustomerPanel.setVisible(true);
        searchcustomerPanel.setVisible(false);
        
        try{
        conn=DatabaseConnection.ConnectDB();
        String sqll="select customerid as 'Customer ID',cname as 'Name',mobile_no as 'Mobile No.',type as 'Type',dates as 'Dates',address as 'Address' from customers ";
        PreparedStatement pstmt=conn.prepareStatement(sqll);
        ResultSet rss=pstmt.executeQuery();
        
        updatecustomersTable.setModel(DbUtils.resultSetToTableModel(rss));
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    }//GEN-LAST:event_updateDeletebutton1MouseClicked

    private void searchcustomerbuttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchcustomerbuttonMouseClicked
        // TODO add your handling code here:
        allcustomersPanel.setVisible(false);
        addcustomerPanel.setVisible(false);
        updatedeleteCustomerPanel.setVisible(false);
        searchcustomerPanel.setVisible(true);
    }//GEN-LAST:event_searchcustomerbuttonMouseClicked

    private void updatebuttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updatebuttonMouseClicked
        // TODO add your handling code here:
        updatedeletebooksPanel.setVisible(true);
        addbookPanel.setVisible(false);
        allbooksPanel.setVisible(false);
        searchbooksPanel.setVisible(false);
        
        try{
        conn=DatabaseConnection.ConnectDB();
        String sql="select bookid as 'Book ID',bname as 'Book Name',bpublisher as 'Publication',bauthor as 'Author',publishing_dates as 'Date',bstock as 'Quantites',bprice as 'Price' from addbooks ";
        PreparedStatement pstmt=conn.prepareStatement(sql);
        ResultSet rs=pstmt.executeQuery();
        
        updatebooksTable.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    }//GEN-LAST:event_updatebuttonMouseClicked

    private void searchbuttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchbuttonMouseClicked
        // TODO add your handling code here:
        searchbooksPanel.setVisible(true);
        updatedeletebooksPanel.setVisible(false);
        addbookPanel.setVisible(false);
        allbooksPanel.setVisible(false);
        
    }//GEN-LAST:event_searchbuttonMouseClicked

    private void allsuppliersbuttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_allsuppliersbuttonMouseClicked
        // TODO add your handling code here:
        allsuppliersPanel.setVisible(true);
        addsupplierPanel.setVisible(false);
        updatedeletesupplierPanel.setVisible(false);
        searchsuppliersPanel.setVisible(false);
        
        try{
        conn=DatabaseConnection.ConnectDB();
        String sqll="select supplierid as 'Supplier ID',sname as 'Name',agency as 'Agency',mobile_no as 'Mobile No.',startingdate as 'Starting Date',s_email as 'Email Add',saddress as 'Address' from suppliers ";
        PreparedStatement pstmt=conn.prepareStatement(sqll);
        ResultSet rss=pstmt.executeQuery();
        
        allsuppliersTable.setModel(DbUtils.resultSetToTableModel(rss));
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    }//GEN-LAST:event_allsuppliersbuttonMouseClicked

    private void addsupplierbuttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addsupplierbuttonMouseClicked
        // TODO add your handling code here:
        allsuppliersPanel.setVisible(false);
        addsupplierPanel.setVisible(true);
        updatedeletesupplierPanel.setVisible(false);
        searchsuppliersPanel.setVisible(false);
    }//GEN-LAST:event_addsupplierbuttonMouseClicked

    private void updatedeletesupplierbuttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updatedeletesupplierbuttonMouseClicked
        // TODO add your handling code here:
        allsuppliersPanel.setVisible(false);
        addsupplierPanel.setVisible(false);
        updatedeletesupplierPanel.setVisible(true);
        searchsuppliersPanel.setVisible(false);
        
        try{
        conn=DatabaseConnection.ConnectDB();
        String sqll="select supplierid as 'Supplier ID',sname as 'Name',agency as 'Agency',mobile_no as 'Mobile No.',startingdate as 'Starting Date',s_email as 'Email Add',saddress as 'Address' from suppliers ";
        PreparedStatement pstmt=conn.prepareStatement(sqll);
        ResultSet rss=pstmt.executeQuery();
        
        updatesuppliersTable.setModel(DbUtils.resultSetToTableModel(rss));
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    }//GEN-LAST:event_updatedeletesupplierbuttonMouseClicked

    private void searchsupplierbuttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchsupplierbuttonMouseClicked
        // TODO add your handling code here:
        allsuppliersPanel.setVisible(false);
        addsupplierPanel.setVisible(false);
        updatedeletesupplierPanel.setVisible(false);
        searchsuppliersPanel.setVisible(true);
    }//GEN-LAST:event_searchsupplierbuttonMouseClicked

    private void suppliersPanel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_suppliersPanel5MouseClicked
        // TODO add your handling code here:
        jLabel9.setText("Suppliers");
        suppliersPanel.setVisible(true);
        employeesPanel.setVisible(false);
        homePanel.setVisible(false);
        booksPanel.setVisible(false);
        customersPanel.setVisible(false);
        updatesuppliers();
    }//GEN-LAST:event_suppliersPanel5MouseClicked

    private void exitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMouseClicked
        // TODO add your handling code here:
        homePanel.setVisible(true);
    }//GEN-LAST:event_exitMouseClicked

    private void exitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMouseEntered
        // TODO add your handling code here:
        //setBorder(exit);
        //setColorP(exit);
    }//GEN-LAST:event_exitMouseEntered

    private void exitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMouseExited
        // TODO add your handling code here:
        // resetBorder(exit);
        //resetColorP(exit);
    }//GEN-LAST:event_exitMouseExited

    private void clearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearMouseClicked
        // TODO add your handling code here:
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
        // jDateChooser1.setDate();
        jTextField25.setText("");
        jTextField26.setText("");
        
    }//GEN-LAST:event_clearMouseClicked

    private void clearMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearMouseEntered
        // TODO add your handling code here:
        //setBorder(exit);
        //setColorP(exit);
    }//GEN-LAST:event_clearMouseEntered

    private void clearMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearMouseExited
        // TODO add your handling code here:
        // resetBorder(exit);
        //resetColorP(exit);
    }//GEN-LAST:event_clearMouseExited

    private void savebooksMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_savebooksMouseClicked
        // TODO add your handling code here:
        conn=DatabaseConnection.ConnectDB();
       String sql="insert into addbooks values(?,?,?,?,?,?,?)";
       try{
           pst=conn.prepareStatement(sql);
           pst.setInt(1,Integer.parseInt(jTextField1.getText()));
           pst.setString(2,jTextField2.getText());
           pst.setString(3,jTextField3.getText());
           pst.setString(4,jTextField4.getText());
           pst.setString(5,((JTextField)jDateChooser1.getDateEditor().getUiComponent()).getText());
           pst.setInt(6,Integer.parseInt(jTextField25.getText()));
           pst.setInt(7,Integer.parseInt(jTextField26.getText()));
           
           pst.executeUpdate();
           JOptionPane.showMessageDialog(null, "save successfully");
           conn.close();
       }
       catch(Exception e){
           JOptionPane.showMessageDialog(null, e);
       }
       
        
    }//GEN-LAST:event_savebooksMouseClicked

    private void savebooksMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_savebooksMouseEntered
        // TODO add your handling code here:
        //setBorder(exit);
        //setColorP(exit);
    }//GEN-LAST:event_savebooksMouseEntered

    private void savebooksMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_savebooksMouseExited
        // TODO add your handling code here:
        // resetBorder(exit);
        //resetColorP(exit);
    }//GEN-LAST:event_savebooksMouseExited

    private void exit3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exit3MouseClicked
       
         conn=DatabaseConnection.ConnectDB();
       String sql="insert into customers values(?,?,?,?,?,?)";
       try{
           pst=conn.prepareStatement(sql);
           pst.setInt(1,Integer.parseInt(jTextField7.getText()));
           pst.setString(2,jTextField8.getText());
           pst.setInt(3,Integer.parseInt(jTextField9.getText()));
           pst.setString(4,jTextField10.getText());
           //DateFormat sdf=new SimpleDateFormat("dd MM, yyyy");
           //String date=sdf.format(jDateChooser2.getDate());
           
           pst.setString(5,((JTextField)jDateChooser2.getDateEditor().getUiComponent()).getText());
           pst.setString(6,jTextArea1.getText());
           //pst.setInt(7,Integer.parseInt(jTextField26.getText()));
           
           pst.executeUpdate();
           JOptionPane.showMessageDialog(null, "save successfully");
           conn.close();
       }
       catch(Exception e){
           JOptionPane.showMessageDialog(null, e);
       }
        
    }//GEN-LAST:event_exit3MouseClicked

    private void exit3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exit3MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_exit3MouseEntered

    private void exit3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exit3MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_exit3MouseExited

    private void exit4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exit4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_exit4MouseClicked

    private void exit4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exit4MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_exit4MouseEntered

    private void exit4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exit4MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_exit4MouseExited

    private void exit5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exit5MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_exit5MouseClicked

    private void exit5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exit5MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_exit5MouseEntered

    private void exit5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exit5MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_exit5MouseExited

    private void exit6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exit6MouseClicked
        conn=DatabaseConnection.ConnectDB();
        String sqll="insert into employees values(?,?,?,?,?,?,?,?)";
        try{
           pst=conn.prepareStatement(sqll);
           pst.setInt(1,Integer.parseInt(jTextField11.getText()));
           pst.setString(2,jTextField12.getText());
           pst.setString(3,jComboBox1.getSelectedItem().toString());
           pst.setInt(4,Integer.parseInt(jTextField14.getText()));
           pst.setString(5,((JTextField)jDateChooser3.getDateEditor().getUiComponent()).getText());
           pst.setInt(6,Integer.parseInt(jTextField13.getText()));
           pst.setString(7,jComboBox3.getSelectedItem().toString());
           pst.setString(8,jTextArea2.getText());
           
           
           pst.executeUpdate();
           JOptionPane.showMessageDialog(null, "save successfully");
           conn.close();
       }
       catch(Exception e){
           JOptionPane.showMessageDialog(null, e);
       }
    }//GEN-LAST:event_exit6MouseClicked

    private void exit6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exit6MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_exit6MouseEntered

    private void exit6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exit6MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_exit6MouseExited

    private void exit7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exit7MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_exit7MouseClicked

    private void exit7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exit7MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_exit7MouseEntered

    private void exit7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exit7MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_exit7MouseExited

    private void exit8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exit8MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_exit8MouseClicked

    private void exit8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exit8MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_exit8MouseEntered

    private void exit8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exit8MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_exit8MouseExited

    private void exit9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exit9MouseClicked
        conn=DatabaseConnection.ConnectDB();
        String sqlll="insert into suppliers values(?,?,?,?,?,?,?)";
        try{
           pst=conn.prepareStatement(sqlll);
           pst.setInt(1,Integer.parseInt(jTextField15.getText()));
           pst.setString(2,jTextField16.getText());
           pst.setString(3,jTextField18.getText());
           pst.setInt(4,Integer.parseInt(jTextField17.getText()));
           
           pst.setString(5,((JTextField)jDateChooser4.getDateEditor().getUiComponent()).getText());
           pst.setString(6,jTextField36.getText());
           pst.setString(7,jTextArea3.getText());    
           
           pst.executeUpdate();
           JOptionPane.showMessageDialog(null, "save successfully");
           conn.close();
       }
       catch(Exception e){
           JOptionPane.showMessageDialog(null, e);
       }
        
    }//GEN-LAST:event_exit9MouseClicked

    private void exit9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exit9MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_exit9MouseEntered

    private void exit9MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exit9MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_exit9MouseExited

    private void exit10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exit10MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_exit10MouseClicked

    private void exit10MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exit10MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_exit10MouseEntered

    private void exit10MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exit10MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_exit10MouseExited

    private void exit11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exit11MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_exit11MouseClicked

    private void exit11MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exit11MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_exit11MouseEntered

    private void exit11MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exit11MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_exit11MouseExited

    private void closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseClicked
        // TODO add your handling code here:
        doexit();
        //System.exit(0);
    }//GEN-LAST:event_closeMouseClicked

    private void updatebooksMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updatebooksMouseClicked
        // TODO add your handling code here:
        conn=DatabaseConnection.ConnectDB();
        try {
            
           String s1=jTextField19.getText();
           String s2=jTextField20.getText();
           String s3=jTextField21.getText();
           String s4=jTextField22.getText();
           String s7=jTextField23.getText();
           String s8=jTextField24.getText();
         
            String sql="UPDATE addbooks SET bname='"+s2+"',"
                    + "bpublisher='"+s3+"',bauthor='"+s4+"',"
                    + "publishing_dates='"+((JTextField)jDateChooser5.getDateEditor().getUiComponent()).getText()+"',"
                    + "bstock='"+s7+"',bprice='"+s8+"' WHERE bookid='"+s1+"'";
            pst =conn.prepareStatement(sql);
           
           
           
           pst.executeUpdate();
           JOptionPane.showMessageDialog(null,"Record Updated successfully  ");
           
           jTextField19.setText("");
           jTextField20.setText("");
           jTextField21.setText("");
           jTextField22.setText("");
        
           jTextField23.setText("");
           jTextField24.setText("");
           
           updatebooks();
           
           conn.close();
            
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
       // String sql="update addbooks set ";
    }//GEN-LAST:event_updatebooksMouseClicked

    private void updatebooksMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updatebooksMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_updatebooksMouseEntered

    private void updatebooksMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updatebooksMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_updatebooksMouseExited

    private void logoutPanel7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutPanel7MouseEntered
        // TODO add your handling code here:
        logoutPanel7.setBackground(new Color(0,51,255));
    }//GEN-LAST:event_logoutPanel7MouseEntered

    private void logoutPanel7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutPanel7MouseExited
        // TODO add your handling code here:
        logoutPanel7.setBackground(new Color(4,103,246));
    }//GEN-LAST:event_logoutPanel7MouseExited

    private void updatebooksTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updatebooksTableMouseClicked
        
        DefaultTableModel model=(DefaultTableModel) updatebooksTable.getModel();
        int selectedRowindex= updatebooksTable.getSelectedRow();
        
        jTextField19.setText(model.getValueAt(selectedRowindex,0).toString());
        jTextField20.setText(model.getValueAt(selectedRowindex,1).toString());
        jTextField21.setText(model.getValueAt(selectedRowindex,2).toString());
        jTextField22.setText(model.getValueAt(selectedRowindex,3).toString());
        //jDateChooser5.setDate(model.getValueAt(selectedRowindex,4).toString());
        jTextField23.setText(model.getValueAt(selectedRowindex,5).toString());
        jTextField24.setText(model.getValueAt(selectedRowindex,6).toString());
    }//GEN-LAST:event_updatebooksTableMouseClicked

    private void closeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_closeMouseEntered

    private void clear1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clear1MouseClicked
        // TODO add your handling code here:
        jTextField19.setText("");
        jTextField20.setText("");
        jTextField21.setText("");
        jTextField22.setText("");
        jTextField23.setText("");
        jTextField24.setText("");
        
    }//GEN-LAST:event_clear1MouseClicked

    private void clear1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clear1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_clear1MouseEntered

    private void clear1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clear1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_clear1MouseExited

    private void updatecustomersTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updatecustomersTableMouseClicked
        // TODO add your handling code here:
        DefaultTableModel model=(DefaultTableModel) updatecustomersTable.getModel();
        int selectedRowindex= updatecustomersTable.getSelectedRow();
        
        jTextField28.setText(model.getValueAt(selectedRowindex,0).toString());
        jTextField29.setText(model.getValueAt(selectedRowindex,1).toString());
        jTextField30.setText(model.getValueAt(selectedRowindex,2).toString());
        jTextField31.setText(model.getValueAt(selectedRowindex,3).toString());
        
        jTextArea4.setText(model.getValueAt(selectedRowindex,5).toString());
    
    }//GEN-LAST:event_updatecustomersTableMouseClicked

    private void updatecustomersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updatecustomersMouseClicked
        // TODO add your handling code here:
        conn=DatabaseConnection.ConnectDB();
        try {
            
           String s1=jTextField28.getText();
           String s2=jTextField29.getText();
           String s3=jTextField30.getText();
           String s4=jTextField31.getText();
           String s5=jTextArea4.getText();
           
         
            String sql="UPDATE customers SET cname='"+s2+"',"
                    + "mobile_no='"+s3+"',type='"+s4+"',"
                    + "dates='"+((JTextField)jDateChooser6.getDateEditor().getUiComponent()).getText()+"',"
                    + "address='"+s5+"' WHERE customerid='"+s1+"'";
            pst =conn.prepareStatement(sql);
           
           
           
           pst.executeUpdate();
           JOptionPane.showMessageDialog(null,"Record Updated successfully  ");
           
           jTextField19.setText("");
           jTextField20.setText("");
           jTextField21.setText("");
           jTextField22.setText("");
           jTextField23.setText("");
           jTextField24.setText("");
           
           updatebooks();
           
           conn.close();
            
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_updatecustomersMouseClicked

    private void updatecustomersMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updatecustomersMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_updatecustomersMouseEntered

    private void updatecustomersMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updatecustomersMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_updatecustomersMouseExited

    private void clear2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clear2MouseClicked
        // TODO add your handling code here:
        if(updatebooksTable.getSelectedRow()==-1){
            JOptionPane.showMessageDialog(Homepage.this,"select any row from table ");
            return;    
        }
        
        //Connection conn=null;
        PreparedStatement pstmt=null;
        conn=DatabaseConnection.ConnectDB();
        try {
            int row=updatebooksTable.getSelectedRow();
            String value=(updatebooksTable.getModel().getValueAt(row,0).toString());
            
            String sql="delete from addbooks WHERE bookid='"+value+"'";
            
            int confirm = JOptionPane.showConfirmDialog(null, 
                "do you want to delete this ?", " ",
                JOptionPane.YES_NO_OPTION);    
               
            if(confirm==JOptionPane.YES_OPTION){
                pstmt =conn.prepareStatement(sql);
                pstmt.executeUpdate();
                JOptionPane.showMessageDialog(null,"Delete successfully....");
                conn.close();
            }
            else{JOptionPane.showMessageDialog(null,"Delete Unsuccessful....");}
            //DefaultTableModel dt=(DefaultTableModel) updatebooksTable.getModel();
            //dt.setRowCount(0);
            
            
            
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
        
    }//GEN-LAST:event_clear2MouseClicked

    private void clear2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clear2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_clear2MouseEntered

    private void clear2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clear2MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_clear2MouseExited

    private void paymentsPanel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paymentsPanel6MouseClicked
        // TODO add your handling code here:
        jLabel9.setText("Payments");
        suppliersPanel.setVisible(false);
        employeesPanel.setVisible(false);
        homePanel.setVisible(false);
        booksPanel.setVisible(false);
        customersPanel.setVisible(false);
        paymentsPanel.setVisible(true);
        
    }//GEN-LAST:event_paymentsPanel6MouseClicked

    private void jTextField6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField6KeyReleased
        
        DefaultTableModel table = (DefaultTableModel) allbooksTable.getModel();
        String search=jTextField6.getText().toLowerCase();
        TableRowSorter<DefaultTableModel> tr=new TableRowSorter<DefaultTableModel>(table);
        allbooksTable.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(search));
    }//GEN-LAST:event_jTextField6KeyReleased

    private void jTextField9KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField9KeyTyped
        char c=evt.getKeyChar();
        if(!(Character.isDigit(c) || (c==KeyEvent.VK_BACKSPACE ) || c==KeyEvent.VK_DELETE )){
        getToolkit().beep();
        evt.consume();
        }
    }//GEN-LAST:event_jTextField9KeyTyped

    private void updatedeletebooksPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updatedeletebooksPanelMouseClicked
        updatebooksTable.clearSelection();
    }//GEN-LAST:event_updatedeletebooksPanelMouseClicked

    private void updatedeleteCustomerPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updatedeleteCustomerPanelMouseClicked
        updatecustomersTable.clearSelection();
    }//GEN-LAST:event_updatedeleteCustomerPanelMouseClicked

    private void jTextField27KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField27KeyReleased
        DefaultTableModel tableofcus = (DefaultTableModel) allcustomersTable.getModel();
        String searchcus=jTextField27.getText().toLowerCase();
        TableRowSorter<DefaultTableModel> trr=new TableRowSorter<DefaultTableModel>(tableofcus);
        allcustomersTable.setRowSorter(trr);
        trr.setRowFilter(RowFilter.regexFilter(searchcus));
    }//GEN-LAST:event_jTextField27KeyReleased

    private void updateemployeesTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateemployeesTableMouseClicked
        DefaultTableModel model=(DefaultTableModel) updateemployeesTable.getModel();
        int selectedRowindex= updateemployeesTable.getSelectedRow();
        
        jTextField32.setText(model.getValueAt(selectedRowindex,0).toString());
        jTextField33.setText(model.getValueAt(selectedRowindex,1).toString());
        //jTextField30.setText(model.getValueAt(selectedRowindex,2).toString());
        jTextField35.setText(model.getValueAt(selectedRowindex,3).toString());
        jTextField34.setText(model.getValueAt(selectedRowindex,5).toString());
        
        jTextArea5.setText(model.getValueAt(selectedRowindex,7).toString());
    
    }//GEN-LAST:event_updateemployeesTableMouseClicked

    private void updateemployeesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateemployeesMouseClicked
        conn=DatabaseConnection.ConnectDB();
        try {
            
           String s1=jTextField32.getText();
           String s2=jTextField33.getText();
           String s3=(String) jComboBox4.getSelectedItem();
           String s4=jTextField35.getText();
           String s7=jTextField34.getText();
           String s8=(String) jComboBox5.getSelectedItem();
           String s9=jTextArea5.getText();
         
            String sql="UPDATE employees SET ename='"+s2+"',"
                    + "edesignation='"+s3+"',mobile_no='"+s4+"',"
                    + "starting_date='"+((JTextField)jDateChooser7.getDateEditor().getUiComponent()).getText()+"',"
                    + "salary='"+s7+"',status='"+s8+"',address='"+s9+"' WHERE employeeid='"+s1+"'";
            pst =conn.prepareStatement(sql);
           
           
           
           pst.executeUpdate();
           JOptionPane.showMessageDialog(null,"Record Updated successfully  ");
           
           jTextField32.setText("");
           jTextField33.setText("");
           jTextField34.setText("");
           jTextField35.setText("");
           
           updateemployees();
           
           conn.close();
            
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_updateemployeesMouseClicked

    private void updateemployeesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateemployeesMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_updateemployeesMouseEntered

    private void updateemployeesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateemployeesMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_updateemployeesMouseExited

    private void updatesuppliersTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updatesuppliersTableMouseClicked
        DefaultTableModel modell=(DefaultTableModel) updatesuppliersTable.getModel();
        int selectedrowindex=updatesuppliersTable.getSelectedRow();
        
        jTextField37.setText(modell.getValueAt(selectedrowindex,0).toString());
        jTextField38.setText(modell.getValueAt(selectedrowindex,1).toString());
        jTextField39.setText(modell.getValueAt(selectedrowindex,2).toString());
        jTextField40.setText(modell.getValueAt(selectedrowindex,3).toString());
        jTextField41.setText(modell.getValueAt(selectedrowindex,5).toString());
        jTextArea6.setText(modell.getValueAt(selectedrowindex,6).toString());
        
                
    }//GEN-LAST:event_updatesuppliersTableMouseClicked

    private void updatesuppliersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updatesuppliersMouseClicked
        conn=DatabaseConnection.ConnectDB();
        try {
            
           String ss1=jTextField37.getText();
           String ss2=jTextField38.getText();
           String ss3=jTextField39.getText();
           String ss4=jTextField40.getText();
           String ss5=jTextField41.getText();
           String ss6=jTextArea6.getText();
         
            String sql="UPDATE suppliers SET sname='"+ss2+"',"
                    + "agency='"+ss3+"',mobile_no='"+ss4+"',"
                    + "startingdate='"+((JTextField)jDateChooser8.getDateEditor().getUiComponent()).getText()+"',"
                    + "s_email='"+ss5+"',saddress='"+ss6+"' WHERE supplierid='"+ss1+"'";
            pst =conn.prepareStatement(sql);
            
           pst.executeUpdate();
           JOptionPane.showMessageDialog(null,"Record Updated successfully  ");
           
           jTextField37.setText("");
           jTextField38.setText("");
           jTextField39.setText("");
           jTextField40.setText("");
           jTextField41.setText("");
           jTextArea6.setText("");
           updatesuppliers();
           
           conn.close();
            
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_updatesuppliersMouseClicked

    private void updatesuppliersMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updatesuppliersMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_updatesuppliersMouseEntered

    private void updatesuppliersMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updatesuppliersMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_updatesuppliersMouseExited

    private void jTextField42KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField42KeyReleased
        DefaultTableModel table=(DefaultTableModel) allsuppliersTable.getModel();
        String searchsup=jTextField42.getText().toLowerCase();
        TableRowSorter<DefaultTableModel> trs=new TableRowSorter<DefaultTableModel>(table);
        allsuppliersTable.setRowSorter(trs);
        trs.setRowFilter(RowFilter.regexFilter(searchsup));
    }//GEN-LAST:event_jTextField42KeyReleased

    private void jTextField43KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField43KeyReleased
        DefaultTableModel tables = (DefaultTableModel) allemployeesTable.getModel();
        String search=jTextField43.getText();//.toLowerCase();
        TableRowSorter<DefaultTableModel> tr=new TableRowSorter<DefaultTableModel>(tables);
        allemployeesTable.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(search));
    }//GEN-LAST:event_jTextField43KeyReleased

    private void updatedeletesupplierPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updatedeletesupplierPanelMouseClicked
        updatesuppliersTable.clearSelection();
    }//GEN-LAST:event_updatedeletesupplierPanelMouseClicked

    private void updatedeletePanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updatedeletePanelMouseClicked
        updateemployeesTable.clearSelection();
    }//GEN-LAST:event_updatedeletePanelMouseClicked

    private void jTextField14KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField14KeyTyped
         char c=evt.getKeyChar();
        if(!(Character.isDigit(c) || (c==KeyEvent.VK_BACKSPACE ) || c==KeyEvent.VK_DELETE )){
        getToolkit().beep();
        evt.consume();
        }
    }//GEN-LAST:event_jTextField14KeyTyped

    private void jTextField13KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField13KeyTyped
         char c=evt.getKeyChar();
        if(!(Character.isDigit(c) || (c==KeyEvent.VK_BACKSPACE ) || c==KeyEvent.VK_DELETE )){
        getToolkit().beep();
        evt.consume();
        }
    }//GEN-LAST:event_jTextField13KeyTyped

    private void jTextField17KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField17KeyTyped
         char c=evt.getKeyChar();
        if(!(Character.isDigit(c) || (c==KeyEvent.VK_BACKSPACE ) || c==KeyEvent.VK_DELETE )){
        getToolkit().beep();
        evt.consume();
        }
    }//GEN-LAST:event_jTextField17KeyTyped

    private void deletecustomerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deletecustomerMouseClicked
        if(updatecustomersTable.getSelectedRow()==-1){
            JOptionPane.showMessageDialog(Homepage.this,"select any row from table ");
            return;    
        }
        PreparedStatement pstmt=null;
        conn=DatabaseConnection.ConnectDB();
        try {
            int row=updatecustomersTable.getSelectedRow();
            String value1=(updatecustomersTable.getModel().getValueAt(row,0).toString());
            
            String sql="delete from customers WHERE customerid='"+value1+"'";
            
            int confirm = JOptionPane.showConfirmDialog(null, 
                "do you want to delete this ?", " ",
                JOptionPane.YES_NO_OPTION);
            if(confirm==JOptionPane.YES_OPTION){
                 pstmt =conn.prepareStatement(sql);
                 pstmt.executeUpdate();
                 //DefaultTableModel dt=(DefaultTableModel) updatebooksTable.getModel();
                 //dt.setRowCount(0);
                 JOptionPane.showMessageDialog(null,"Delete successfully....");
                 conn.close();
            }
            else{
            JOptionPane.showMessageDialog(null,"Delete Unsuccessful....");
            }
            
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_deletecustomerMouseClicked

    private void deletecustomerMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deletecustomerMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_deletecustomerMouseEntered

    private void deletecustomerMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deletecustomerMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_deletecustomerMouseExited

    private void clear3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clear3MouseClicked
        jTextField28.setText("");
        jTextField29.setText("");
        jTextField30.setText("");
        jTextField31.setText("");
        jTextArea4.setText("");
        
    }//GEN-LAST:event_clear3MouseClicked

    private void clear3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clear3MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_clear3MouseEntered

    private void clear3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clear3MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_clear3MouseExited

    private void clear4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clear4MouseClicked
        jTextField32.setText("");
        jTextField33.setText("");
        jTextField34.setText("");
        jTextField35.setText("");
        jTextArea5.setText("");
    }//GEN-LAST:event_clear4MouseClicked

    private void clear4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clear4MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_clear4MouseEntered

    private void clear4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clear4MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_clear4MouseExited

    private void deleteemployeeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteemployeeMouseClicked
        if(updateemployeesTable.getSelectedRow()==-1){
            JOptionPane.showMessageDialog(Homepage.this,"select any row from table ");
            return;    
        }
        
        PreparedStatement pstmt=null;
        conn=DatabaseConnection.ConnectDB();
        try {
            int roww=updateemployeesTable.getSelectedRow();
            String value2=(updateemployeesTable.getModel().getValueAt(roww,0).toString());
            
            String sql="delete from employees WHERE employeeid='"+value2+"'";
            
            int confirm = JOptionPane.showConfirmDialog(null, 
                "do you want to delete this ?", " ",
                JOptionPane.YES_NO_OPTION);
            if(confirm==JOptionPane.YES_OPTION){
                 pstmt =conn.prepareStatement(sql);
                 pstmt.executeUpdate();
                 JOptionPane.showMessageDialog(null,"Delete successfully....");
                 conn.close();
            }
            else{
            JOptionPane.showMessageDialog(null,"Delete Unsuccessful....");
            }
            
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
    }//GEN-LAST:event_deleteemployeeMouseClicked

    private void deleteemployeeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteemployeeMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteemployeeMouseEntered

    private void deleteemployeeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteemployeeMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteemployeeMouseExited

    private void clear5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clear5MouseClicked
       jTextField37.setText("");
       jTextField38.setText("");
       jTextField39.setText("");
       jTextField40.setText("");
       jTextField41.setText("");
       jTextArea6.setText("");
    }//GEN-LAST:event_clear5MouseClicked

    private void clear5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clear5MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_clear5MouseEntered

    private void clear5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clear5MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_clear5MouseExited

    private void deleteemployee1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteemployee1MouseClicked
        if(updatesuppliersTable.getSelectedRow()==-1){
            JOptionPane.showMessageDialog(Homepage.this,"select any row from table ");
            return;    
        }
        
        PreparedStatement pstmt=null;
        conn=DatabaseConnection.ConnectDB();
        try {
            int rowww=updatesuppliersTable.getSelectedRow();
            String value3=(updatesuppliersTable.getModel().getValueAt(rowww,0).toString());
            
            String sql="delete from suppliers WHERE supplierid='"+value3+"'";
            
            int confirm = JOptionPane.showConfirmDialog(null, 
                "do you want to delete this ?", " ",
                JOptionPane.YES_NO_OPTION);
            if(confirm==JOptionPane.YES_OPTION){
                 pstmt =conn.prepareStatement(sql);
                 pstmt.executeUpdate();
                 JOptionPane.showMessageDialog(null,"Delete successfully....");
                 conn.close();
            }
            else{
            JOptionPane.showMessageDialog(null,"Delete Unsuccessful....");
            }
            
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_deleteemployee1MouseClicked

    private void deleteemployee1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteemployee1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteemployee1MouseEntered

    private void deleteemployee1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteemployee1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteemployee1MouseExited

    private void logoutPanel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutPanel7MouseClicked
        this.dispose();
        new RegisterAndLogin().setVisible(true);
    }//GEN-LAST:event_logoutPanel7MouseClicked

    private void jTextField25KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField25KeyTyped
        char c=evt.getKeyChar();
        if(!(Character.isDigit(c) || (c==KeyEvent.VK_BACKSPACE ) || c==KeyEvent.VK_DELETE )){
        getToolkit().beep();
        evt.consume();
        }
    }//GEN-LAST:event_jTextField25KeyTyped

    private void jTextField26KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField26KeyTyped
        char c=evt.getKeyChar();
        if(!(Character.isDigit(c) || (c==KeyEvent.VK_BACKSPACE ) || c==KeyEvent.VK_DELETE )){
        getToolkit().beep();
        evt.consume();
        }
    }//GEN-LAST:event_jTextField26KeyTyped

    private void jPanel4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseEntered
        // TODO add your handling code here:
        DatabaseConnection.setColor(jPanel4);
    }//GEN-LAST:event_jPanel4MouseEntered

    private void jPanel4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseExited
        // TODO add your handling code here:
        DatabaseConnection.resetColor(jPanel4);
    }//GEN-LAST:event_jPanel4MouseExited

    private void jPanel4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MousePressed
        // TODO add your handling code here:
        //new Home_Data().show();
    }//GEN-LAST:event_jPanel4MousePressed

    private void jPanel6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseEntered
        DatabaseConnection.setColor(jPanel6);
    }//GEN-LAST:event_jPanel6MouseEntered

    private void jPanel6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseExited
        DatabaseConnection.resetColor(jPanel6);
    }//GEN-LAST:event_jPanel6MouseExited

    private void jPanel6MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MousePressed
        //new Billgenerates().setVisible(true);
    }//GEN-LAST:event_jPanel6MousePressed

    private void jPanel7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MouseEntered

        DatabaseConnection.setColor(jPanel7);
    }//GEN-LAST:event_jPanel7MouseEntered

    private void jPanel7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MouseExited

        DatabaseConnection.resetColor(jPanel7);
    }//GEN-LAST:event_jPanel7MouseExited

    private void customerIDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_customerIDMouseClicked
        jTextField5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(4,103,246)));
    }//GEN-LAST:event_customerIDMouseClicked

    private void customerIDMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_customerIDMouseReleased

    }//GEN-LAST:event_customerIDMouseReleased

    private void customerIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_customerIDActionPerformed

    private void jPanel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseClicked
        Purchase.setVisible(true);
        Home.setVisible(false);
        Bill.setVisible(false);
    }//GEN-LAST:event_jPanel4MouseClicked

    private void jPanel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseClicked
        Purchase.setVisible(false);
        Home.setVisible(false);
        Bill.setVisible(true);
    }//GEN-LAST:event_jPanel6MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Purchase.setVisible(false);
        Home.setVisible(true);
        Bill.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Purchase.setVisible(false);
        Home.setVisible(true);
        Bill.setVisible(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
      conn=DatabaseConnection.ConnectDB(); 
      String sql="select cname,mobile_no,address from customers where customerid=?";
      try{
         String cid=customerID.getText();
         pst =conn.prepareStatement(sql);
         pst.setString(1,cid);
         rs=pst.executeQuery();
         if(rs.next()){
           customerName.setText(rs.getString("cname"));
           CusMobile.setText(rs.getString("mobile_no"));
           cusAddress.setText(rs.getString("address"));
         }
         else{
                JOptionPane.showMessageDialog(null,"record not found " );
            }
           conn.close();
      }
      catch(Exception e){
          JOptionPane.showMessageDialog(null,e);
      }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        conn=DatabaseConnection.ConnectDB();
        
      String sql="select bname,bstock,bprice from addbooks where bookid=?";
      try{
         String bid=bookID.getText();
         pst =conn.prepareStatement(sql);
         pst.setString(1,bid);
         rs=pst.executeQuery();
         if(rs.next()){
           bookName.setText(rs.getString("bname"));
           bookQnt.setText(rs.getString("bstock"));
           bookPrice.setText(rs.getString("bprice"));  
         }
         else{
                JOptionPane.showMessageDialog(null,"record not found " );
            } 
         conn.close();
      }
      catch(Exception e){
          JOptionPane.showMessageDialog(null,e);
      }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if(quantity.getText().isEmpty()){
        JOptionPane.showMessageDialog(null,"please insert quantity ");}
        else{
        int qut=Integer.parseInt(quantity.getText());
        int perPrice=Integer.parseInt(bookPrice.getText());
        int total=qut*perPrice;
        String t=String.valueOf(total);
        jTextField52.setText(t);
        
        model1.insertRow(jTable1.getRowCount(), new Object[] {
                bookID.getText(),
                bookName.getText(),
                quantity.getText(),
                bookPrice.getText(),
                jTextField52.getText(),
            });
            //resetFields();
            qn=Integer.parseInt(quantity.getText());
            av=Integer.parseInt(bookQnt.getText());
            totqty=(av-qn);
           
            
            for(int i=0;i<jTable1.getRowCount();i++){
                int am=Integer.parseInt((String)jTable1.getValueAt(i,4));
                to+=am;
            }
            totalam.setText(String.valueOf(to));    
            updateQuantity();
        }
         
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
         if(jTable1.getSelectedRow()==-1){
            JOptionPane.showMessageDialog(Homepage.this,"select any row from table ");
            return;    
        }
        updateAfterdelete();
       model1.removeRow(jTable1.getSelectedRow());
        
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        NewJFrame nf =new NewJFrame();
     int rowcount;   
    DefaultTableModel model = new DefaultTableModel();
    model=(DefaultTableModel) jTable1.getModel();
    nf.jTextArea1.setText(nf.jTextArea1.getText()+"                  Smart Book Store"
            +"\n ABCD Stationary \n 01 xyz road pqr \n pro. abcd xyz    9876543210 \n\n"
            +"\n---------------------------------------------------------------"
            + "\n Book Name        quantity         per price         total"
            + "\n---------------------------------------------------------------\n\n" );
    
    rowcount=jTable1.getRowCount();
    for(int i=0;i<rowcount;i++){
        String bookname=(String) jTable1.getValueAt(i,1);
        int quantity=Integer.parseInt((String) jTable1.getValueAt(i,2));
        int perprice=Integer.parseInt((String) jTable1.getValueAt(i,3));
        int totalrate=Integer.parseInt((String) jTable1.getValueAt(i,4));
        
    nf.jTextArea1.setText(nf.jTextArea1.getText()+"     "+bookname+"      "+quantity+"             "+perprice+"            "+totalrate+"\n\n" );
    //System.out.println("      "+bookname+"     "+quantity+"    "+perprice+"      "+totalrate );
        
    }
    nf.jTextArea1.setText(nf.jTextArea1.getText()+"\n----------------------------------------------------------------"+"\n\n                                 Total : "+totalam.getText()+"\n");
    nf.setVisible(true);
    }//GEN-LAST:event_jButton6ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Homepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Homepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Homepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Homepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Homepage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BgPanel;
    private javax.swing.JPanel Bill;
    private javax.swing.JTextField CusMobile;
    private javax.swing.JPanel Home;
    private javax.swing.JPanel Purchase;
    private javax.swing.JPanel addbookPanel;
    private javax.swing.JPanel addbooksbutton;
    private javax.swing.JPanel addcustomerPanel;
    private javax.swing.JPanel addcustomerbutton;
    private javax.swing.JPanel addemployeePanel;
    private javax.swing.JPanel addemployeebutton;
    private javax.swing.JPanel addsupplierPanel;
    private javax.swing.JPanel addsupplierbutton;
    private javax.swing.JPanel allbooksPanel;
    private javax.swing.JTable allbooksTable;
    private javax.swing.JPanel allbooksbutton;
    private javax.swing.JPanel allcustomersPanel;
    private javax.swing.JTable allcustomersTable;
    private javax.swing.JPanel allcustomersbutton;
    private javax.swing.JPanel allemployeesPanel;
    private javax.swing.JTable allemployeesTable;
    private javax.swing.JPanel allemployeesbutton;
    private javax.swing.JPanel allsuppliersPanel;
    private javax.swing.JTable allsuppliersTable;
    private javax.swing.JPanel allsuppliersbutton;
    private javax.swing.JTextField bookID;
    private javax.swing.JTextField bookName;
    private javax.swing.JTextField bookPrice;
    private javax.swing.JTextField bookQnt;
    private javax.swing.JLabel books;
    private javax.swing.JPanel booksPanel;
    private javax.swing.JPanel booksPanel2;
    private javax.swing.JLabel booksicon;
    private javax.swing.JPanel clear;
    private javax.swing.JPanel clear1;
    private javax.swing.JPanel clear2;
    private javax.swing.JPanel clear3;
    private javax.swing.JPanel clear4;
    private javax.swing.JPanel clear5;
    private javax.swing.JLabel close;
    private javax.swing.JTextField cusAddress;
    private javax.swing.JPanel custmersPanel3;
    private javax.swing.JTextField customerID;
    private javax.swing.JTextField customerName;
    private javax.swing.JLabel customers;
    private javax.swing.JPanel customersPanel;
    private javax.swing.JLabel customersicon;
    private javax.swing.JPanel deletecustomer;
    private javax.swing.JPanel deleteemployee;
    private javax.swing.JPanel deleteemployee1;
    private javax.swing.JLabel employees;
    private javax.swing.JPanel employeesPanel;
    private javax.swing.JPanel employeesPanel4;
    private javax.swing.JLabel employeesicon;
    private javax.swing.JPanel exit;
    private javax.swing.JPanel exit10;
    private javax.swing.JPanel exit11;
    private javax.swing.JPanel exit3;
    private javax.swing.JPanel exit4;
    private javax.swing.JPanel exit5;
    private javax.swing.JPanel exit6;
    private javax.swing.JPanel exit7;
    private javax.swing.JPanel exit8;
    private javax.swing.JPanel exit9;
    private javax.swing.JLabel home;
    private javax.swing.JPanel homePanel;
    private javax.swing.JPanel homePanel1;
    private javax.swing.JLabel homeicon;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JComboBox jComboBox4;
    private javax.swing.JComboBox jComboBox5;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private com.toedter.calendar.JDateChooser jDateChooser3;
    private com.toedter.calendar.JDateChooser jDateChooser4;
    private com.toedter.calendar.JDateChooser jDateChooser5;
    private com.toedter.calendar.JDateChooser jDateChooser6;
    private com.toedter.calendar.JDateChooser jDateChooser7;
    private com.toedter.calendar.JDateChooser jDateChooser8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel114;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel116;
    private javax.swing.JLabel jLabel117;
    private javax.swing.JLabel jLabel118;
    private javax.swing.JLabel jLabel119;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel120;
    private javax.swing.JLabel jLabel121;
    private javax.swing.JLabel jLabel122;
    private javax.swing.JLabel jLabel123;
    private javax.swing.JLabel jLabel124;
    private javax.swing.JLabel jLabel125;
    private javax.swing.JLabel jLabel126;
    private javax.swing.JLabel jLabel127;
    private javax.swing.JLabel jLabel128;
    private javax.swing.JLabel jLabel129;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel130;
    private javax.swing.JLabel jLabel131;
    private javax.swing.JLabel jLabel132;
    private javax.swing.JLabel jLabel133;
    private javax.swing.JLabel jLabel134;
    private javax.swing.JLabel jLabel135;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel144;
    private javax.swing.JLabel jLabel145;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private diu.swe.habib.JPanelSlider.JPanelSlider jPanelSlider1;
    private diu.swe.habib.JPanelSlider.JPanelSlider jPanelSlider2;
    private diu.swe.habib.JPanelSlider.JPanelSlider jPanelSlider3;
    private diu.swe.habib.JPanelSlider.JPanelSlider jPanelSlider4;
    private diu.swe.habib.JPanelSlider.JPanelSlider jPanelSlider5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextArea jTextArea4;
    private javax.swing.JTextArea jTextArea5;
    private javax.swing.JTextArea jTextArea6;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField18;
    private javax.swing.JTextField jTextField19;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField20;
    private javax.swing.JTextField jTextField21;
    private javax.swing.JTextField jTextField22;
    private javax.swing.JTextField jTextField23;
    private javax.swing.JTextField jTextField24;
    private javax.swing.JTextField jTextField25;
    private javax.swing.JTextField jTextField26;
    private javax.swing.JTextField jTextField27;
    private javax.swing.JTextField jTextField28;
    private javax.swing.JTextField jTextField29;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField30;
    private javax.swing.JTextField jTextField31;
    private javax.swing.JTextField jTextField32;
    private javax.swing.JTextField jTextField33;
    private javax.swing.JTextField jTextField34;
    private javax.swing.JTextField jTextField35;
    private javax.swing.JTextField jTextField36;
    private javax.swing.JTextField jTextField37;
    private javax.swing.JTextField jTextField38;
    private javax.swing.JTextField jTextField39;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField40;
    private javax.swing.JTextField jTextField41;
    private javax.swing.JTextField jTextField42;
    private javax.swing.JTextField jTextField43;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField52;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JPanel logoutPanel7;
    private javax.swing.JLabel minimize;
    private javax.swing.JLabel payments;
    private javax.swing.JPanel paymentsPanel;
    private javax.swing.JPanel paymentsPanel6;
    private javax.swing.JLabel paymentsicon;
    private javax.swing.JTextField quantity;
    private javax.swing.JPanel savebooks;
    private javax.swing.JPanel searchbooksPanel;
    private javax.swing.JTable searchbooksTable;
    private javax.swing.JPanel searchbutton;
    private javax.swing.JPanel searchcustomerPanel;
    private javax.swing.JPanel searchcustomerbutton;
    private javax.swing.JPanel searchemployeePanel;
    private javax.swing.JPanel searchemployeebutton;
    private javax.swing.JPanel searchsupplierbutton;
    private javax.swing.JPanel searchsuppliersPanel;
    private javax.swing.JLabel settings;
    private javax.swing.JLabel settingsicon;
    private javax.swing.JPanel sidePanel;
    private javax.swing.JLabel suppliers;
    private javax.swing.JPanel suppliersPanel;
    private javax.swing.JPanel suppliersPanel5;
    private javax.swing.JLabel suppliersicon;
    private javax.swing.JLabel totalam;
    private javax.swing.JPanel updateDeletebutton1;
    private javax.swing.JPanel updatebooks;
    private javax.swing.JTable updatebooksTable;
    private javax.swing.JTable updatebooksTable2;
    private javax.swing.JPanel updatebutton;
    private javax.swing.JPanel updatecustomers;
    private javax.swing.JTable updatecustomersTable;
    private javax.swing.JPanel updatedeleteCustomerPanel;
    private javax.swing.JPanel updatedeletePanel;
    private javax.swing.JPanel updatedeletebooksPanel;
    private javax.swing.JPanel updatedeletebutton;
    private javax.swing.JPanel updatedeletesupplierPanel;
    private javax.swing.JPanel updatedeletesupplierbutton;
    private javax.swing.JPanel updateemployees;
    private javax.swing.JTable updateemployeesTable;
    private javax.swing.JPanel updatesuppliers;
    private javax.swing.JTable updatesuppliersTable;
    // End of variables declaration//GEN-END:variables


private void updateQuantity(){
    conn=DatabaseConnection.ConnectDB();
                
       try{
           
            String bid=bookID.getText();
            
            String sql="update addbooks set bstock='"+totqty+"' where bookid='"+bid+"' ";
            pst=conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null,"update successful");
            
            conn.close();
        
    }                                        
    catch(SQLException e){
        JOptionPane.showMessageDialog(null,e);
      }
}
private void updateAfterdelete(){
    conn=DatabaseConnection.ConnectDB();
    int i=jTable1.getSelectedRow();
    int r=0;
    int bookid=Integer.parseInt((String)jTable1.getValueAt(i,r));
    
    try {
        
        String query="select bstock from addbooks where bookid='"+bookid+"'";
        pst=conn.prepareStatement(query);
        rs=pst.executeQuery();
        if(rs.next()){
            int bs=Integer.parseInt(rs.getString("bstock"));
            int qt=Integer.parseInt((String)jTable1.getValueAt(i,2));
            totqnt=bs+qt;
            System.out.println(" updated stock = "+totqnt);
            
        }
        else{
            System.out.println("hiiiiiiiiiiiiiiiii");
        }
        
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null,e);
    }
    try {
        String sql="update addbooks set bstock='"+totqnt+"' where bookid='"+bookid+"' ";
            pst=conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null,"Stock update successful after deletion ");
            
            conn.close();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null,e);
    }
    int d=jTable1.getSelectedRow();
    int t=Integer.parseInt((String)jTable1.getValueAt(d,4));
    //int total=Integer.parseInt((String)totalam.getText());
    to=to-t;
    totalam.setText(String.valueOf(to));
}









}
