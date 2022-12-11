/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package v2;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;


/**
 *
 * @author lenovo
 */
public class Adminpage extends javax.swing.JFrame {

        Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
    String sql = null;
    PreparedStatement pst = null;
  
    String filename = null;
    byte[] person_image = null;
    
    
    public Adminpage() {
        super("librarydb");
        initComponents();
        conn = connector.connectiondb();
        this.setLocationRelativeTo(null);
        addbooktable();
        returntable();
        stafftable();
        loginhistory_table();
        
        new Thread(){
            public void run(){
            while(true){
                Date dNow = new Date ( );
            
            SimpleDateFormat ft = new SimpleDateFormat ("E yyy.MM.dd  hh.mm.ss a");
            String time = ""+ft.format(dNow);
            datehere.setText(time);
            }
                }
        }.start();
        
        
                        
       // stickmans.setVisible(false); 
        window1.setVisible(false);
        window2.setVisible(false);
        updatebook_panel1.setVisible(false);
        addStaff.setVisible(false);
returnPanel.setVisible(false);
myprofile.setVisible(false);
loginhistory.setVisible(false);
     //   go.setVisible(false);

        //updatebook_panel1.setOpaque(false);
       // ((DefaultTableCellRenderer)updatebook_panel1.getDefaultRenderer(String.class)).setOpaque(false);
 
       
        
        //returnPanel.setBackground(new Color(50,50,50,50));
         panel1.setBackground(new Color(100,100,100,100));
        panel2.setBackground(new Color(100,100,100,100));
        panel3.setBackground(new Color(100,100,100,100));
        panel4.setBackground(new Color(100,100,100,100));
        panel5.setBackground(new Color(100,100,100,100));
      
        panel7.setBackground(new Color(100,100,100,100));
        
        fname.setBackground(new Color(0,0,0,0));
      lname.setBackground(new Color(0,0,0,0));
      datehere.setBackground(new Color(0,0,0,0));
      
       // borrowpanel.setBackground(new Color(200,200,200,200));
        //window1.setBackground(new Color(0,0,0,0));
        //window2.setBackground(new Color(50,50,50,50));
        //updatebook_panel1.setBackground(new Color(50,50,50,50));
        myprofile.setBackground(new Color(0,0,0,0));
        //zxc.setBackground(new Color(50,50,50,50));
       // a.setBackground(new Color(50,50,50,50));
        //second.setBackground(new Color(50,50,50,50));
        //addStaff.setBackground(new Color(0,0,0,0));
        
     
      ImageIcon myimage62 = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("bbv2.jpg")));     
      Image img11 = myimage62.getImage();
      Image img12 = img11.getScaledInstance(left.getWidth(),left.getHeight(), Image.SCALE_SMOOTH);
      ImageIcon e = new ImageIcon(img12);
    left.setIcon(e);
    
     ImageIcon myimage6 = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("bbv2.jpg")));     
      Image img121 = myimage6.getImage();
      Image img212 = img121.getScaledInstance(right.getWidth(),right.getHeight(), Image.SCALE_SMOOTH);
      ImageIcon ef = new ImageIcon(img212);
    right.setIcon(ef);
    
    
         ImageIcon myimage60 = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("roomlib.jpg")));     
      Image img110 = myimage60.getImage();
      Image img120 = img110.getScaledInstance(kk.getWidth(),kk.getHeight(), Image.SCALE_SMOOTH);
      ImageIcon ep = new ImageIcon(img120);
    kk.setIcon(ep);
    
     ImageIcon myimage160 = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("proff.png")));     
      Image img1110 = myimage160.getImage();
      Image img1200 = img1110.getScaledInstance(prof.getWidth(),prof.getHeight(), Image.SCALE_SMOOTH);
      ImageIcon evp = new ImageIcon(img1200);
    prof.setIcon(evp);
    
    ImageIcon myimage1160 = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("port.jpg")));     
      Image img11101 = myimage1160.getImage();
      Image img12001 = img11101.getScaledInstance(backg3.getWidth(),backg3.getHeight(), Image.SCALE_SMOOTH);
      ImageIcon evp1 = new ImageIcon(img12001);
    backg3.setIcon(evp1);
    

    }
    
  
    
private void addbooktable(){
    try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/librarydb","root","");
        String sql = "SELECT distinct  `InventoryNumber`, `Category`, `Price`, `Description`, `Author`, `AcquiredDate`, `EstimatedUsefulLife`,`Quantity` FROM `books` group by InventoryNumber asc ";
        PreparedStatement pstmt = con.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        jTable1.setModel(DbUtils.resultSetToTableModel(rs));
    
    }catch (ClassNotFoundException | SQLException e){
        JOptionPane.showMessageDialog(null, e);}}
       
private void returntable(){
    try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/librarydb","root","");
        String sql = "SELECT * FROM `borrowd`";
        PreparedStatement pstmt = con.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        returnbook_table.setModel(DbUtils.resultSetToTableModel(rs));
    
    }catch (ClassNotFoundException | SQLException e){
        JOptionPane.showMessageDialog(null, e);}}

private void stafftable(){
    try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/librarydb","root","");
        String sql = "SELECT distinct CourseYear,_IDnumber,_LastName,_FirstName FROM `staff`";
        PreparedStatement pstmt = con.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        stafftable.setModel(DbUtils.resultSetToTableModel(rs));
    
    }catch (ClassNotFoundException | SQLException e){
        JOptionPane.showMessageDialog(null, e);}}

private void loginhistory_table(){
    try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/librarydb","root","");
        String sql = "SELECT * from loginhistory";
        PreparedStatement pstmt = con.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        loginhistory_table.setModel(DbUtils.resultSetToTableModel(rs));
    
    }catch (ClassNotFoundException | SQLException e){
        JOptionPane.showMessageDialog(null, e);}}
        

   int choice;
     
     public void bookupdate(){
 
     }

    @SuppressWarnings("unchecked")
     int x,y;
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        datehere = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        prof = new javax.swing.JLabel();
        lname = new javax.swing.JLabel();
        fname = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        stickmans = new javax.swing.JLabel();
        myid = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        panel1 = new javax.swing.JPanel();
        borrowpres = new javax.swing.JLabel();
        panel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        panel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        panel4 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        panel5 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        borrowpanel = new javax.swing.JPanel();
        window1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        b_invno = new javax.swing.JTextField();
        b_unit = new javax.swing.JTextField();
        b_discription = new javax.swing.JTextField();
        b_author = new javax.swing.JTextField();
        b_dateacq = new javax.swing.JTextField();
        b_est = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        b_price = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel54 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        rem = new javax.swing.JLabel();
        bqty = new javax.swing.JLabel();
        cqty = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        updatebook_panel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        add_invno = new javax.swing.JTextField();
        add_description = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jLabel32 = new javax.swing.JLabel();
        addbutton = new javax.swing.JButton();
        modify = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        jLabel33 = new javax.swing.JLabel();
        add_est = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        add_author = new javax.swing.JTextField();
        add_price = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        CategoryComboBox = new javax.swing.JComboBox<>();
        ccc = new javax.swing.JLabel();
        qty = new javax.swing.JTextField();
        jLabel75 = new javax.swing.JLabel();
        addStaff = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        stafftable = new javax.swing.JTable();
        jLabel49 = new javax.swing.JLabel();
        addstaff = new javax.swing.JButton();
        _mi = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        Female = new javax.swing.JRadioButton();
        Male = new javax.swing.JRadioButton();
        _id = new javax.swing.JTextField();
        _cy = new javax.swing.JTextField();
        _ln = new javax.swing.JTextField();
        _cont = new javax.swing.JTextField();
        _fn = new javax.swing.JTextField();
        _jDateChooser = new com.toedter.calendar.JDateChooser();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        staffpassword = new javax.swing.JPasswordField();
        myprofile = new javax.swing.JPanel();
        jLabel47 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        a = new javax.swing.JPanel();
        numb = new javax.swing.JLabel();
        brgy = new javax.swing.JLabel();
        fn = new javax.swing.JLabel();
        str = new javax.swing.JLabel();
        email = new javax.swing.JLabel();
        mi = new javax.swing.JLabel();
        gend = new javax.swing.JLabel();
        ln = new javax.swing.JLabel();
        birth = new javax.swing.JLabel();
        city = new javax.swing.JLabel();
        prov = new javax.swing.JLabel();
        id = new javax.swing.JLabel();
        fn1 = new javax.swing.JLabel();
        id1 = new javax.swing.JLabel();
        fn2 = new javax.swing.JLabel();
        ln1 = new javax.swing.JLabel();
        mi1 = new javax.swing.JLabel();
        birth1 = new javax.swing.JLabel();
        gend1 = new javax.swing.JLabel();
        str1 = new javax.swing.JLabel();
        brgy1 = new javax.swing.JLabel();
        city1 = new javax.swing.JLabel();
        prov1 = new javax.swing.JLabel();
        numb1 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        zxc = new javax.swing.JPanel();
        jLabel80 = new javax.swing.JLabel();
        changedp = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        choosefile = new javax.swing.JButton();
        deleteacc = new javax.swing.JButton();
        window2 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        b_idno = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        b_fname = new javax.swing.JTextField();
        b_lname = new javax.swing.JTextField();
        b_mi = new javax.swing.JTextField();
        b_contact = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        b_address = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        returnPanel = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        return_inventory_number = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        return_unit = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        return_desc = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        return_author = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        return_price = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        return_remarks = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        return_idnumber = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        return_firstname = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        return_dateborrowed1 = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        return_lastname = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        return_mi = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        return_book_button = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        returnbook_table = new javax.swing.JTable();
        cont = new javax.swing.JLabel();
        adr = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        qt = new javax.swing.JTextField();
        jLabel78 = new javax.swing.JLabel();
        tot = new javax.swing.JLabel();
        ci = new javax.swing.JLabel();
        loginhistory = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        loginhistory_table = new javax.swing.JTable();
        jLabel73 = new javax.swing.JLabel();
        kk = new javax.swing.JLabel();
        left = new javax.swing.JLabel();
        right = new javax.swing.JLabel();
        return_dateborrowed = new javax.swing.JTextField();
        panel7 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        backg3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.red, java.awt.Color.black, null, null));
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel1MouseDragged(evt);
            }
        });
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
        });
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 0, 0));
        jLabel1.setText("   _");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 0, 30, -1));

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 0, 0));
        jLabel4.setText("   x");
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 0, 40, -1));

        datehere.setEditable(false);
        datehere.setBackground(new java.awt.Color(255, 255, 255));
        datehere.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        datehere.setText("    DATE AND TIME");
        datehere.setBorder(null);
        jPanel1.add(datehere, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 40, 220, 40));

        jLabel2.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 0, 0));
        jLabel2.setText("LOG OUT?");
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, -1, -1));

        prof.setIcon(new javax.swing.ImageIcon("C:\\Users\\lenovo\\Pictures\\Saved Pictures\\bambo.jpg")); // NOI18N
        prof.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(prof, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 80, 70));

        lname.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lname.setText("LAST NAME");
        jPanel1.add(lname, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, 130, -1));

        fname.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        fname.setText("NAME");
        jPanel1.add(fname, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 130, -1));

        jLabel5.setFont(new java.awt.Font("Tempus Sans ITC", 1, 12)); // NOI18N
        jLabel5.setText("MY PROFILE");
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, -1, -1));

        stickmans.setIcon(new javax.swing.ImageIcon("C:\\Users\\lenovo\\Pictures\\Saved Pictures\\tenor.gif")); // NOI18N
        jPanel1.add(stickmans, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 10, 120, 70));

        myid.setText("0000000000");
        myid.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                myidMouseClicked(evt);
            }
        });
        jPanel1.add(myid, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 30, 80, -1));

        jLabel48.setText("ID No. ");
        jPanel1.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, 40, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1020, 90));

        panel1.setBackground(new java.awt.Color(0, 0, 0));
        panel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 255, 255), null, null));
        panel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        borrowpres.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        borrowpres.setForeground(new java.awt.Color(255, 255, 255));
        borrowpres.setText("BORROW");
        borrowpres.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                borrowpresMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addComponent(borrowpres, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(borrowpres)
                .addGap(21, 21, 21))
        );

        getContentPane().add(panel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 200, 40));

        panel2.setBackground(new java.awt.Color(0, 0, 0));
        panel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 255, 255), null, null));
        panel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("RETURN");
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(21, 21, 21))
        );

        getContentPane().add(panel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 200, 40));

        panel3.setBackground(new java.awt.Color(0, 0, 0));
        panel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 255, 255), null, null));
        panel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("BOOKS");
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panel3Layout = new javax.swing.GroupLayout(panel3);
        panel3.setLayout(panel3Layout);
        panel3Layout.setHorizontalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel3Layout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panel3Layout.setVerticalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(21, 21, 21))
        );

        getContentPane().add(panel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 200, 40));

        panel4.setBackground(new java.awt.Color(0, 0, 0));
        panel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 255, 255), null, null));
        panel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("UPDATE BOOKS");
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panel4Layout = new javax.swing.GroupLayout(panel4);
        panel4.setLayout(panel4Layout);
        panel4Layout.setHorizontalGroup(
            panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel4Layout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panel4Layout.setVerticalGroup(
            panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(21, 21, 21))
        );

        getContentPane().add(panel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 200, 40));

        panel5.setBackground(new java.awt.Color(0, 0, 0));
        panel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 255, 255), null, null));
        panel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("STAFF");
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panel5Layout = new javax.swing.GroupLayout(panel5);
        panel5.setLayout(panel5Layout);
        panel5Layout.setHorizontalGroup(
            panel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel5Layout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panel5Layout.setVerticalGroup(
            panel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(20, 20, 20))
        );

        getContentPane().add(panel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, 200, 40));

        jPanel3.setBackground(new java.awt.Color(0, 153, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        borrowpanel.setBackground(new java.awt.Color(51, 153, 255));
        borrowpanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.red, new java.awt.Color(0, 255, 0), null, null));
        borrowpanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        window1.setBackground(new java.awt.Color(255, 255, 255));
        window1.setForeground(new java.awt.Color(204, 0, 51));
        window1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 102));
        jLabel3.setText("BOOK");
        window1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 11, -1, -1));

        b_invno.setBackground(new java.awt.Color(204, 255, 255));
        b_invno.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        b_invno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                b_invnoKeyReleased(evt);
            }
        });
        window1.add(b_invno, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 46, 153, 29));

        b_unit.setEditable(false);
        b_unit.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        window1.add(b_unit, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 114, 153, 29));

        b_discription.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        window1.add(b_discription, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 182, 340, 29));

        b_author.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        window1.add(b_author, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 243, 340, 29));

        b_dateacq.setEditable(false);
        b_dateacq.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        window1.add(b_dateacq, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 311, 152, 29));

        b_est.setEditable(false);
        b_est.setBackground(new java.awt.Color(255, 255, 255));
        b_est.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        window1.add(b_est, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 379, 152, 29));

        jButton1.setBackground(new java.awt.Color(255, 255, 51));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setText("OK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        window1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 426, -1, -1));

        b_price.setEditable(false);
        b_price.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        window1.add(b_price, new org.netbeans.lib.awtextra.AbsoluteConstraints(216, 114, 130, 29));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel54.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel54.setText("INVENTORY NO.");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel54)
                .addGap(30, 30, 30))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel54)
                .addGap(0, 5, Short.MAX_VALUE))
        );

        window1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 100, 20));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setText("CATEGORY");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel14)
                .addGap(0, 5, Short.MAX_VALUE))
        );

        window1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 90, 20));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setText("DISCRIPTION");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel15)
                .addGap(0, 5, Short.MAX_VALUE))
        );

        window1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 100, 20));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setText("AUTHOR");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jLabel16)
                .addGap(0, 5, Short.MAX_VALUE))
        );

        window1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 60, 20));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel17.setText("DATE ACQUIRED");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jLabel17)
                .addGap(0, 5, Short.MAX_VALUE))
        );

        window1.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 100, 20));

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel18.setText("ESTIMATED USEFILLIFE");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jLabel18)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jLabel18)
                .addGap(0, 5, Short.MAX_VALUE))
        );

        window1.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, 140, 20));

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel19.setText("PRICE");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jLabel19)
                .addGap(0, 5, Short.MAX_VALUE))
        );

        window1.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 150, 40, 20));

        rem.setForeground(new java.awt.Color(255, 255, 255));
        rem.setText("rem");
        window1.add(rem, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 50, 20, 30));

        bqty.setForeground(new java.awt.Color(255, 255, 255));
        bqty.setText("1");
        window1.add(bqty, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 50, 20, 30));

        cqty.setForeground(new java.awt.Color(255, 255, 255));
        cqty.setText("this");
        window1.add(cqty, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 60, -1, -1));

        jLabel76.setForeground(new java.awt.Color(255, 255, 255));
        jLabel76.setText("-");
        window1.add(jLabel76, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 60, 20, 10));

        jLabel77.setForeground(new java.awt.Color(255, 255, 255));
        jLabel77.setText("=");
        window1.add(jLabel77, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 60, 20, 10));

        borrowpanel.add(window1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, -1, 470));

        updatebook_panel1.setBackground(new java.awt.Color(51, 51, 51));
        updatebook_panel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTable1.setOpaque(false);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        updatebook_panel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 716, 101));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("UPDATE BOOKS");
        updatebook_panel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        add_invno.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        add_invno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_invnoActionPerformed(evt);
            }
        });
        add_invno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                add_invnoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                add_invnoKeyTyped(evt);
            }
        });
        updatebook_panel1.add(add_invno, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 110, 28));

        add_description.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        add_description.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_descriptionActionPerformed(evt);
            }
        });
        add_description.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                add_descriptionKeyReleased(evt);
            }
        });
        updatebook_panel1.add(add_description, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 287, 28));

        jLabel30.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("DISCRIPTION");
        updatebook_panel1.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, -1, -1));

        jDateChooser2.setDateFormatString("yyyy-MM-dd");
        jDateChooser2.setOpaque(false);
        updatebook_panel1.add(jDateChooser2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 142, 30));

        jLabel32.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("DATE ACQUIRED");
        updatebook_panel1.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, -1, -1));

        addbutton.setBackground(new java.awt.Color(0, 153, 0));
        addbutton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        addbutton.setForeground(new java.awt.Color(255, 255, 255));
        addbutton.setText("ADD");
        addbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addbuttonActionPerformed(evt);
            }
        });
        updatebook_panel1.add(addbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 360, 106, 32));

        modify.setBackground(new java.awt.Color(255, 255, 51));
        modify.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        modify.setForeground(new java.awt.Color(0, 153, 153));
        modify.setText("MODIFY");
        modify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyActionPerformed(evt);
            }
        });
        updatebook_panel1.add(modify, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 360, 106, 32));

        delete.setBackground(new java.awt.Color(204, 0, 0));
        delete.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        delete.setForeground(new java.awt.Color(255, 255, 255));
        delete.setText("DELETE");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });
        updatebook_panel1.add(delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 360, 106, 32));

        jLabel33.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setText("ESTIMATED USEFULLIFE");
        updatebook_panel1.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 310, -1, -1));

        add_est.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        add_est.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_estActionPerformed(evt);
            }
        });
        updatebook_panel1.add(add_est, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 270, 189, 28));

        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("AUTHOR");
        updatebook_panel1.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 250, -1, -1));

        add_author.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        updatebook_panel1.add(add_author, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 210, 287, 28));

        add_price.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        updatebook_panel1.add(add_price, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 140, 155, 28));

        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("Quantity");
        updatebook_panel1.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 175, -1, 20));

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("CATEGORY");
        updatebook_panel1.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 180, -1, -1));

        jLabel55.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(255, 255, 255));
        jLabel55.setText("INVENTORY NO.");
        updatebook_panel1.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, -1));

        CategoryComboBox.setBackground(new java.awt.Color(0, 204, 0));
        CategoryComboBox.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        CategoryComboBox.setForeground(new java.awt.Color(255, 255, 255));
        CategoryComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "IT BOOKS", "HISTORY", "MYSTERY", "SCIENCE FICTION", "POLITICAL THRILLER", "Other" }));
        updatebook_panel1.add(CategoryComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 140, 160, -1));

        ccc.setForeground(new java.awt.Color(51, 51, 51));
        updatebook_panel1.add(ccc, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 220, 30, 20));

        qty.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        qty.setForeground(new java.awt.Color(0, 51, 51));
        updatebook_panel1.add(qty, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 140, 70, 30));

        jLabel75.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel75.setForeground(new java.awt.Color(255, 255, 255));
        jLabel75.setText("PRICE");
        updatebook_panel1.add(jLabel75, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 180, -1, -1));

        borrowpanel.add(updatebook_panel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 30, -1, 400));

        addStaff.setBackground(new java.awt.Color(255, 255, 153));
        addStaff.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        stafftable.setModel(new javax.swing.table.DefaultTableModel(
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
        stafftable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(stafftable);

        addStaff.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 350, 330));

        jLabel49.setFont(new java.awt.Font("DialogInput", 1, 24)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(153, 0, 153));
        jLabel49.setText(" STAFF's");
        addStaff.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        addstaff.setBackground(new java.awt.Color(0, 153, 0));
        addstaff.setForeground(new java.awt.Color(255, 255, 255));
        addstaff.setText("ADD  STAFF");
        addstaff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addstaffActionPerformed(evt);
            }
        });
        addStaff.add(addstaff, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 390, 110, 40));

        _mi.setBackground(new java.awt.Color(102, 102, 102));
        _mi.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        _mi.setForeground(new java.awt.Color(255, 255, 255));
        _mi.setText("MI");
        _mi.setBorder(null);
        _mi.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                _miFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                _miFocusLost(evt);
            }
        });
        _mi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _miActionPerformed(evt);
            }
        });
        addStaff.add(_mi, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 180, 40, 30));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        Female.setBackground(new java.awt.Color(0, 0, 0));
        Female.setFont(new java.awt.Font("Gadugi", 1, 14)); // NOI18N
        Female.setForeground(new java.awt.Color(255, 255, 255));
        Female.setText("FEMALE");
        Female.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FemaleActionPerformed(evt);
            }
        });

        Male.setBackground(new java.awt.Color(0, 0, 0));
        Male.setFont(new java.awt.Font("Gadugi", 1, 14)); // NOI18N
        Male.setForeground(new java.awt.Color(255, 255, 255));
        Male.setText("MALE");
        Male.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MaleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Male)
                .addGap(11, 11, 11)
                .addComponent(Female)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Male)
                    .addComponent(Female))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        addStaff.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 220, 170, 40));

        _id.setBackground(new java.awt.Color(102, 102, 102));
        _id.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        _id.setForeground(new java.awt.Color(255, 255, 255));
        _id.setText("ID NUMBER");
        _id.setBorder(null);
        _id.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                _idFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                _idFocusLost(evt);
            }
        });
        _id.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                _idKeyReleased(evt);
            }
        });
        addStaff.add(_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 20, 200, 30));

        _cy.setBackground(new java.awt.Color(102, 102, 102));
        _cy.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        _cy.setForeground(new java.awt.Color(255, 255, 255));
        _cy.setText("YR/COURSE");
        _cy.setBorder(null);
        _cy.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                _cyFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                _cyFocusLost(evt);
            }
        });
        addStaff.add(_cy, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 60, 200, 30));

        _ln.setBackground(new java.awt.Color(102, 102, 102));
        _ln.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        _ln.setForeground(new java.awt.Color(255, 255, 255));
        _ln.setText("LAST NAME");
        _ln.setBorder(null);
        _ln.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                _lnFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                _lnFocusLost(evt);
            }
        });
        addStaff.add(_ln, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 100, 200, 30));

        _cont.setBackground(new java.awt.Color(102, 102, 102));
        _cont.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        _cont.setForeground(new java.awt.Color(255, 255, 255));
        _cont.setText("CONTACT");
        _cont.setBorder(null);
        _cont.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                _contFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                _contFocusLost(evt);
            }
        });
        addStaff.add(_cont, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 300, 200, 30));

        _fn.setBackground(new java.awt.Color(102, 102, 102));
        _fn.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        _fn.setForeground(new java.awt.Color(255, 255, 255));
        _fn.setText("FIRST NAME");
        _fn.setBorder(null);
        _fn.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                _fnFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                _fnFocusLost(evt);
            }
        });
        addStaff.add(_fn, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 140, 200, 30));

        _jDateChooser.setDateFormatString("yyyy-MM-dd");
        addStaff.add(_jDateChooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(427, 270, 100, -1));

        jLabel50.setFont(new java.awt.Font("Dialog", 2, 14)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(255, 255, 255));
        jLabel50.setText("Date of birth");
        addStaff.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 270, -1, -1));

        jLabel51.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(204, 0, 51));
        jLabel51.setText("______________");
        addStaff.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, -1, -1));

        jLabel52.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(204, 0, 204));
        jLabel52.setText("Manage user's");
        jLabel52.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel52MouseClicked(evt);
            }
        });
        addStaff.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, -1, -1));

        staffpassword.setBackground(new java.awt.Color(102, 102, 102));
        staffpassword.setForeground(new java.awt.Color(255, 255, 255));
        staffpassword.setText("PASSWORD");
        staffpassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                staffpasswordFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                staffpasswordFocusLost(evt);
            }
        });
        addStaff.add(staffpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 340, 200, 30));

        borrowpanel.add(addStaff, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, 650, 440));

        a.setBackground(new java.awt.Color(0, 153, 153));

        numb.setBackground(new java.awt.Color(204, 204, 204));
        numb.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        numb.setForeground(new java.awt.Color(255, 255, 255));
        numb.setText("NUMBER");

        brgy.setBackground(new java.awt.Color(204, 204, 204));
        brgy.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        brgy.setForeground(new java.awt.Color(255, 255, 255));
        brgy.setText("BARANGAY");

        fn.setBackground(new java.awt.Color(204, 204, 204));
        fn.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        fn.setForeground(new java.awt.Color(255, 255, 255));
        fn.setText("FNAME");

        str.setBackground(new java.awt.Color(204, 204, 204));
        str.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        str.setForeground(new java.awt.Color(255, 255, 255));
        str.setText("STREET");

        email.setBackground(new java.awt.Color(204, 204, 204));
        email.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        email.setForeground(new java.awt.Color(255, 255, 255));
        email.setText("EMAIL");

        mi.setBackground(new java.awt.Color(204, 204, 204));
        mi.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        mi.setForeground(new java.awt.Color(255, 255, 255));
        mi.setText("A");

        gend.setBackground(new java.awt.Color(204, 204, 204));
        gend.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        gend.setForeground(new java.awt.Color(255, 255, 255));
        gend.setText("GENDER");

        ln.setBackground(new java.awt.Color(204, 204, 204));
        ln.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        ln.setForeground(new java.awt.Color(255, 255, 255));
        ln.setText("LNAME");

        birth.setBackground(new java.awt.Color(204, 204, 204));
        birth.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        birth.setForeground(new java.awt.Color(255, 255, 255));
        birth.setText("BIRTH");

        city.setBackground(new java.awt.Color(204, 204, 204));
        city.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        city.setForeground(new java.awt.Color(255, 255, 255));
        city.setText("CITY");

        prov.setBackground(new java.awt.Color(204, 204, 204));
        prov.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        prov.setForeground(new java.awt.Color(255, 255, 255));
        prov.setText("PROVINCE");

        id.setBackground(new java.awt.Color(204, 204, 204));
        id.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        id.setForeground(new java.awt.Color(255, 255, 255));
        id.setText("0000000000");

        fn1.setFont(new java.awt.Font("DialogInput", 1, 36)); // NOI18N
        fn1.setForeground(new java.awt.Color(255, 255, 255));
        fn1.setText("MY PROFILE");

        id1.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        id1.setForeground(new java.awt.Color(255, 102, 0));
        id1.setText("___________");

        fn2.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        fn2.setForeground(new java.awt.Color(255, 102, 0));
        fn2.setText("___________");

        ln1.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        ln1.setForeground(new java.awt.Color(255, 102, 0));
        ln1.setText("___________");

        mi1.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        mi1.setForeground(new java.awt.Color(255, 102, 0));
        mi1.setText("___");

        birth1.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        birth1.setForeground(new java.awt.Color(255, 102, 0));
        birth1.setText("___________");

        gend1.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        gend1.setForeground(new java.awt.Color(255, 102, 0));
        gend1.setText("___________");

        str1.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        str1.setForeground(new java.awt.Color(255, 102, 0));
        str1.setText("___________");

        brgy1.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        brgy1.setForeground(new java.awt.Color(255, 102, 0));
        brgy1.setText("___________");

        city1.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        city1.setForeground(new java.awt.Color(255, 102, 0));
        city1.setText("___________");

        prov1.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        prov1.setForeground(new java.awt.Color(255, 102, 0));
        prov1.setText("___________");

        numb1.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        numb1.setForeground(new java.awt.Color(255, 102, 0));
        numb1.setText("___________");

        jLabel13.setText("-");

        jLabel27.setText("-");

        jLabel57.setText("-");

        jLabel60.setText("-");

        jLabel61.setText("-");

        jLabel63.setText("-");

        jLabel66.setText("-");

        jLabel67.setText("-");

        jLabel69.setText("-");

        jLabel70.setText("-");

        jLabel71.setText("-");

        jLabel72.setText("-");

        javax.swing.GroupLayout aLayout = new javax.swing.GroupLayout(a);
        a.setLayout(aLayout);
        aLayout.setHorizontalGroup(
            aLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(aLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(aLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel61, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel63, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel66, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel67, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel69, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel70, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel71, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(aLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(aLayout.createSequentialGroup()
                        .addComponent(ln, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(aLayout.createSequentialGroup()
                        .addGroup(aLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(gend, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(birth, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(str, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(aLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(prov, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(numb, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(city, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(brgy, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fn1)
                            .addGroup(aLayout.createSequentialGroup()
                                .addGroup(aLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(id, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fn, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel72, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(9, 9, 9)
                                .addComponent(mi, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(45, Short.MAX_VALUE))))
            .addGroup(aLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(aLayout.createSequentialGroup()
                    .addGap(64, 64, 64)
                    .addComponent(id1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(250, Short.MAX_VALUE)))
            .addGroup(aLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(aLayout.createSequentialGroup()
                    .addGap(64, 64, 64)
                    .addComponent(fn2, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(229, Short.MAX_VALUE)))
            .addGroup(aLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(aLayout.createSequentialGroup()
                    .addGap(64, 64, 64)
                    .addComponent(ln1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(246, Short.MAX_VALUE)))
            .addGroup(aLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, aLayout.createSequentialGroup()
                    .addContainerGap(277, Short.MAX_VALUE)
                    .addComponent(mi1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(35, 35, 35)))
            .addGroup(aLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(aLayout.createSequentialGroup()
                    .addGap(64, 64, 64)
                    .addComponent(birth1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(246, Short.MAX_VALUE)))
            .addGroup(aLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(aLayout.createSequentialGroup()
                    .addGap(64, 64, 64)
                    .addComponent(gend1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(246, Short.MAX_VALUE)))
            .addGroup(aLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(aLayout.createSequentialGroup()
                    .addGap(64, 64, 64)
                    .addComponent(str1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(246, Short.MAX_VALUE)))
            .addGroup(aLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(aLayout.createSequentialGroup()
                    .addGap(64, 64, 64)
                    .addComponent(brgy1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(145, Short.MAX_VALUE)))
            .addGroup(aLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(aLayout.createSequentialGroup()
                    .addGap(64, 64, 64)
                    .addComponent(city1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(175, Short.MAX_VALUE)))
            .addGroup(aLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(aLayout.createSequentialGroup()
                    .addGap(64, 64, 64)
                    .addComponent(prov1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(104, 104, 104)))
            .addGroup(aLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(aLayout.createSequentialGroup()
                    .addGap(64, 64, 64)
                    .addComponent(numb1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(186, Short.MAX_VALUE)))
        );
        aLayout.setVerticalGroup(
            aLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(aLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(fn1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(aLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(aLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(mi))
                    .addGroup(aLayout.createSequentialGroup()
                        .addGroup(aLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(id)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(aLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fn)
                            .addComponent(jLabel27)
                            .addComponent(jLabel72))))
                .addGap(2, 2, 2)
                .addGroup(aLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ln)
                    .addComponent(jLabel57))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(aLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(birth)
                    .addComponent(jLabel60))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(aLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gend)
                    .addComponent(jLabel61))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(aLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(str)
                    .addComponent(jLabel63))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(aLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(brgy)
                    .addComponent(jLabel66))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(aLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(city)
                    .addComponent(jLabel67))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(aLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(prov)
                    .addComponent(jLabel69))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(aLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numb)
                    .addComponent(jLabel70))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(aLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(email)
                    .addComponent(jLabel71))
                .addContainerGap())
            .addGroup(aLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(aLayout.createSequentialGroup()
                    .addGap(79, 79, 79)
                    .addComponent(id1)
                    .addContainerGap(311, Short.MAX_VALUE)))
            .addGroup(aLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(aLayout.createSequentialGroup()
                    .addGap(110, 110, 110)
                    .addComponent(fn2)
                    .addContainerGap(280, Short.MAX_VALUE)))
            .addGroup(aLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(aLayout.createSequentialGroup()
                    .addGap(137, 137, 137)
                    .addComponent(ln1)
                    .addContainerGap(253, Short.MAX_VALUE)))
            .addGroup(aLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(aLayout.createSequentialGroup()
                    .addGap(110, 110, 110)
                    .addComponent(mi1)
                    .addContainerGap(280, Short.MAX_VALUE)))
            .addGroup(aLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(aLayout.createSequentialGroup()
                    .addGap(168, 168, 168)
                    .addComponent(birth1)
                    .addContainerGap(222, Short.MAX_VALUE)))
            .addGroup(aLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, aLayout.createSequentialGroup()
                    .addContainerGap(208, Short.MAX_VALUE)
                    .addComponent(gend1)
                    .addGap(182, 182, 182)))
            .addGroup(aLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, aLayout.createSequentialGroup()
                    .addContainerGap(239, Short.MAX_VALUE)
                    .addComponent(str1)
                    .addGap(151, 151, 151)))
            .addGroup(aLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, aLayout.createSequentialGroup()
                    .addContainerGap(270, Short.MAX_VALUE)
                    .addComponent(brgy1)
                    .addGap(120, 120, 120)))
            .addGroup(aLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, aLayout.createSequentialGroup()
                    .addContainerGap(301, Short.MAX_VALUE)
                    .addComponent(city1)
                    .addGap(89, 89, 89)))
            .addGroup(aLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, aLayout.createSequentialGroup()
                    .addContainerGap(332, Short.MAX_VALUE)
                    .addComponent(prov1)
                    .addGap(58, 58, 58)))
            .addGroup(aLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, aLayout.createSequentialGroup()
                    .addContainerGap(363, Short.MAX_VALUE)
                    .addComponent(numb1)
                    .addGap(27, 27, 27)))
        );

        zxc.setBackground(new java.awt.Color(0, 153, 153));

        jLabel80.setFont(new java.awt.Font("Gill Sans MT", 1, 14)); // NOI18N
        jLabel80.setText("CHANGE PROFILE PICTURE");

        changedp.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));

        jButton3.setBackground(new java.awt.Color(0, 102, 255));
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("SAVE CHANGES");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        choosefile.setBackground(new java.awt.Color(0, 153, 153));
        choosefile.setForeground(new java.awt.Color(255, 255, 255));
        choosefile.setText("upload photo");
        choosefile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                choosefileActionPerformed(evt);
            }
        });

        deleteacc.setBackground(new java.awt.Color(153, 0, 0));
        deleteacc.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        deleteacc.setForeground(new java.awt.Color(255, 255, 255));
        deleteacc.setText("DELETE MY ACCOUNT");
        deleteacc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteaccActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout zxcLayout = new javax.swing.GroupLayout(zxc);
        zxc.setLayout(zxcLayout);
        zxcLayout.setHorizontalGroup(
            zxcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(zxcLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(zxcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3)
                    .addComponent(jLabel80)
                    .addGroup(zxcLayout.createSequentialGroup()
                        .addComponent(choosefile)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(changedp, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(deleteacc, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(532, Short.MAX_VALUE))
        );
        zxcLayout.setVerticalGroup(
            zxcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(zxcLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel80)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(zxcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(changedp, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(choosefile, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addComponent(deleteacc, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );

        javax.swing.GroupLayout myprofileLayout = new javax.swing.GroupLayout(myprofile);
        myprofile.setLayout(myprofileLayout);
        myprofileLayout.setHorizontalGroup(
            myprofileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(myprofileLayout.createSequentialGroup()
                .addGroup(myprofileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(myprofileLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(myprofileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(myprofileLayout.createSequentialGroup()
                                .addComponent(jLabel62, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(166, 166, 166)
                                .addComponent(jLabel68, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(myprofileLayout.createSequentialGroup()
                                .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(193, 193, 193)
                                .addComponent(jLabel65, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(myprofileLayout.createSequentialGroup()
                                .addGroup(myprofileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(166, 166, 166)
                                .addComponent(jLabel64, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(myprofileLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(a, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(zxc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        myprofileLayout.setVerticalGroup(
            myprofileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(myprofileLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(myprofileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(zxc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(a, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(myprofileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(myprofileLayout.createSequentialGroup()
                        .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(myprofileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(myprofileLayout.createSequentialGroup()
                                .addGroup(myprofileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel64, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel65, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel62, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel68, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        borrowpanel.add(myprofile, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 800, 430));

        window2.setBackground(new java.awt.Color(255, 255, 255));
        window2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 102, 102));
        jLabel12.setText("BORROWER");
        window2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 11, -1, -1));

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel21.setText("ID NO.");
        window2.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 81, 113, -1));

        b_idno.setBackground(new java.awt.Color(204, 255, 255));
        b_idno.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        b_idno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                b_idnoKeyReleased(evt);
            }
        });
        window2.add(b_idno, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 46, 149, 29));

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel22.setText("FIRST NAME");
        window2.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 149, 113, -1));

        b_fname.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        window2.add(b_fname, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 114, 198, 29));

        b_lname.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        b_lname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_lnameActionPerformed(evt);
            }
        });
        window2.add(b_lname, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 183, 198, 29));

        b_mi.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        window2.add(b_mi, new org.netbeans.lib.awtextra.AbsoluteConstraints(236, 114, 59, 29));

        b_contact.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        b_contact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_contactActionPerformed(evt);
            }
        });
        window2.add(b_contact, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 330, 29));

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel23.setText("M.I.");
        window2.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(236, 149, 59, -1));

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel24.setText("LAST NAME");
        window2.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 215, 172, -1));

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel25.setText("CONTACT/  EMAIL-ADDRESS");
        window2.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 276, 172, -1));

        b_address.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        b_address.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_addressActionPerformed(evt);
            }
        });
        window2.add(b_address, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 309, 330, 29));

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel26.setText("ADDRESS");
        window2.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 344, 172, -1));

        jButton2.setBackground(new java.awt.Color(0, 204, 0));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("BORROW");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        window2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(122, 387, 120, 30));

        borrowpanel.add(window2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 0, 360, 470));

        returnPanel.setBackground(new java.awt.Color(51, 51, 51));
        returnPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel34.setBackground(new java.awt.Color(255, 255, 255));
        jLabel34.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setText("RETURN BOOK");
        returnPanel.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 12, -1, -1));

        return_inventory_number.setBackground(new java.awt.Color(153, 255, 255));
        return_inventory_number.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        return_inventory_number.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                return_inventory_numberKeyReleased(evt);
            }
        });
        returnPanel.add(return_inventory_number, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 182, 155, 28));

        jLabel35.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setText("INVENTORY NUMBER");
        returnPanel.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 212, -1, -1));

        return_unit.setEditable(false);
        return_unit.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        returnPanel.add(return_unit, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 142, 28));

        jLabel36.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setText("CATEGORY");
        returnPanel.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, -1, -1));

        return_desc.setBackground(new java.awt.Color(153, 255, 255));
        return_desc.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        return_desc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                return_descActionPerformed(evt);
            }
        });
        return_desc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                return_descKeyReleased(evt);
            }
        });
        returnPanel.add(return_desc, new org.netbeans.lib.awtextra.AbsoluteConstraints(233, 182, 430, 28));

        jLabel37.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setText("QTY.");
        returnPanel.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 215, 30, 20));

        return_author.setEditable(false);
        return_author.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        return_author.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                return_authorKeyReleased(evt);
            }
        });
        returnPanel.add(return_author, new org.netbeans.lib.awtextra.AbsoluteConstraints(183, 249, 240, 28));

        jLabel38.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setText("AUTHOR");
        returnPanel.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(183, 283, -1, -1));

        return_price.setEditable(false);
        return_price.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        returnPanel.add(return_price, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 310, 135, 28));

        jLabel39.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setText("PRICE");
        returnPanel.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 340, -1, -1));

        return_remarks.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        return_remarks.setForeground(new java.awt.Color(255, 0, 51));
        returnPanel.add(return_remarks, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 310, 144, 28));

        jLabel40.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 255, 255));
        jLabel40.setText("REMARKS");
        returnPanel.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 350, -1, -1));

        return_idnumber.setBackground(new java.awt.Color(153, 255, 255));
        return_idnumber.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        return_idnumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                return_idnumberActionPerformed(evt);
            }
        });
        return_idnumber.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                return_idnumberKeyReleased(evt);
            }
        });
        returnPanel.add(return_idnumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 313, 173, 28));

        jLabel42.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(255, 255, 255));
        jLabel42.setText("ID NUMBER");
        returnPanel.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 343, -1, -1));

        return_firstname.setEditable(false);
        return_firstname.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        returnPanel.add(return_firstname, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 380, 160, 28));

        jLabel41.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(255, 255, 255));
        jLabel41.setText("FIRST NAME");
        returnPanel.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 410, -1, -1));

        return_dateborrowed1.setEditable(false);
        return_dateborrowed1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        return_dateborrowed1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                return_dateborrowed1ActionPerformed(evt);
            }
        });
        returnPanel.add(return_dateborrowed1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 250, 230, 28));

        jLabel43.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(255, 255, 255));
        jLabel43.setText("BORROWED DATE");
        returnPanel.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 280, -1, -1));

        return_lastname.setEditable(false);
        return_lastname.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        returnPanel.add(return_lastname, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 170, 28));

        jLabel44.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(255, 255, 255));
        jLabel44.setText("LAST NAME");
        returnPanel.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 410, -1, -1));

        return_mi.setEditable(false);
        return_mi.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        returnPanel.add(return_mi, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 380, 32, 28));

        jLabel45.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(255, 255, 255));
        jLabel45.setText("M.I.");
        returnPanel.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 410, -1, -1));

        return_book_button.setBackground(new java.awt.Color(0, 153, 255));
        return_book_button.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        return_book_button.setForeground(new java.awt.Color(255, 255, 255));
        return_book_button.setText("RETURN");
        return_book_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                return_book_buttonActionPerformed(evt);
            }
        });
        returnPanel.add(return_book_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 405, 80, 30));

        returnbook_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "set"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        returnbook_table.getTableHeader().setReorderingAllowed(false);
        returnbook_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                returnbook_tableMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(returnbook_table);

        returnPanel.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 48, 760, 123));

        cont.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        cont.setForeground(new java.awt.Color(255, 255, 255));
        cont.setText("CONTACT");
        returnPanel.add(cont, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 340, 179, 28));

        adr.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        adr.setForeground(new java.awt.Color(255, 255, 255));
        adr.setText("ADDRESS");
        returnPanel.add(adr, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 370, 179, 28));

        jLabel11.setIcon(new javax.swing.ImageIcon("C:\\Users\\lenovo\\Documents\\java proj\\icons\\call2_32.png")); // NOI18N
        returnPanel.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 340, 30, 21));

        jLabel46.setIcon(new javax.swing.ImageIcon("C:\\Users\\lenovo\\Documents\\java proj\\icons\\home2_32.png")); // NOI18N
        returnPanel.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 370, 30, 21));

        qt.setBackground(new java.awt.Color(51, 51, 51));
        qt.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        qt.setForeground(new java.awt.Color(255, 255, 255));
        qt.setBorder(null);
        returnPanel.add(qt, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 180, 30, 30));

        jLabel78.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel78.setForeground(new java.awt.Color(255, 255, 255));
        jLabel78.setText("DESCRIPTION");
        returnPanel.add(jLabel78, new org.netbeans.lib.awtextra.AbsoluteConstraints(233, 216, 100, -1));

        tot.setForeground(new java.awt.Color(51, 51, 51));
        tot.setText("sum");
        returnPanel.add(tot, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 220, -1, -1));

        ci.setForeground(new java.awt.Color(51, 51, 51));
        ci.setText("current");
        returnPanel.add(ci, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 220, -1, -1));

        borrowpanel.add(returnPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 760, 450));

        loginhistory.setBackground(new java.awt.Color(51, 51, 51));
        loginhistory.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        loginhistory_table.setForeground(new java.awt.Color(153, 0, 0));
        loginhistory_table.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(loginhistory_table);

        loginhistory.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 670, 380));

        jLabel73.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel73.setForeground(new java.awt.Color(255, 255, 255));
        jLabel73.setText("Login history");
        loginhistory.add(jLabel73, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        borrowpanel.add(loginhistory, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, 670, 400));

        kk.setIcon(new javax.swing.ImageIcon("C:\\Users\\lenovo\\Pictures\\Saved Pictures\\nature.gif")); // NOI18N
        borrowpanel.add(kk, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 740, 480));
        borrowpanel.add(left, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 40, 480));
        borrowpanel.add(right, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, -10, 40, 490));

        return_dateborrowed.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        borrowpanel.add(return_dateborrowed, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 390, 140, 28));

        jPanel3.add(borrowpanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 480));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 90, 820, 480));

        panel7.setBackground(new java.awt.Color(0, 0, 0));
        panel7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 255, 255), null, null));
        panel7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("         HISTORY");
        jLabel20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel20MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panel7Layout = new javax.swing.GroupLayout(panel7);
        panel7.setLayout(panel7Layout);
        panel7Layout.setHorizontalGroup(
            panel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                .addContainerGap())
        );
        panel7Layout.setVerticalGroup(
            panel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel20)
                .addContainerGap())
        );

        getContentPane().add(panel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 410, 200, 40));

        jLabel74.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        jLabel74.setForeground(new java.awt.Color(153, 0, 0));
        jLabel74.setText("     Logs");
        jLabel74.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 204, 204), new java.awt.Color(0, 153, 153), null, null));
        jLabel74.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel74.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel74MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel74, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 490, 120, 70));

        backg3.setIcon(new javax.swing.ImageIcon("C:\\Users\\lenovo\\Documents\\library v2 images\\giphy (2).gif")); // NOI18N
        backg3.setToolTipText("");
        backg3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 204)));
        backg3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backg3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                backg3MouseEntered(evt);
            }
        });
        getContentPane().add(backg3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 300, 480));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void b_lnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_lnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_b_lnameActionPerformed

    private void b_contactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_contactActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_b_contactActionPerformed

    private void b_addressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_addressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_b_addressActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
  if(b_invno.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "choose book to borrow");
            
        }
  else{
    window2.setVisible(true);
  jButton1.setVisible(false);}
// TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void borrowpresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_borrowpresMouseClicked
loginhistory.setVisible(false);
        jButton1.setVisible(true);
updatebook_panel1.setVisible(false);
window1.setVisible(true);
window2.setVisible(false);
addStaff.setVisible(false);
returnPanel.setVisible(false); 
a.setVisible(false);
zxc.setVisible(false);
    }//GEN-LAST:event_borrowpresMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

 if(b_idno.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Enter Student ID Number","missing",3);
        }
  else if(b_fname.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Enter Student First Name","missing",3);
        }
  else if(b_invno.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "NO BOOK SELECTED","missing",3);
        }
        else if(b_mi.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Enter Student Middle Initial","missing",3);
        }
        else if(b_lname.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Enter Student Last Name","missing",3);
        }

        else if(b_contact.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Enter Student Contact","missing",3);
        }
        else if(b_address.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Enter Student Address","missing",3);
        }
        else{
            try{
             
              String Sql= "INSERT INTO borrowd (Quantity,InventoryNumber, Category, price, Description,Author,  IDnumber, LastName, FirstName, Mi, Contact_EmailAddress, Address, Date) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
              pst= conn.prepareStatement(Sql);
              
              pst.setString(1, bqty.getText()); 
              pst.setString(2, b_invno.getText());            
              pst.setString(3,b_unit.getText());
              pst.setString(4, b_price.getText());
              pst.setString(5,b_discription.getText());
              pst.setString(6,b_author.getText());
              pst.setString(7,b_idno.getText());
             // pst.setString(6,((JTextField)jDateChooser2.getDateEditor().getUiComponent()).getText());
             pst.setString(8,b_lname.getText()); 
             pst.setString(9,b_fname.getText());
              pst.setString(10,b_mi.getText());
              
              pst.setString(11,b_contact.getText());
              pst.setString(12,b_address.getText());
              pst.setString(13,datehere.getText());
              
              pst.execute();
              addbooktable();
              
               JOptionPane.showMessageDialog(null, "Approved!");
               
                    
                String value3 = b_invno.getText();
 String sqll = "UPDATE `books` SET `InventoryNumber`=?,`Quantity`=? WHERE InventoryNumber = '"+value3+"'";
            pst=conn.prepareStatement(sqll);
           
            pst.setString(1, b_invno.getText());
            pst.setString(2, rem.getText());
              // JOptionPane.showMessageDialog(null, "success!");
            pst.execute();
               
               rem.setText("");
              b_invno.setText("");            
              b_unit.setText("");
              b_price.setText("");
             b_discription.setText("");
             b_idno.setText("");
             // pst.setString(6,((JTextField)jDateChooser2.getDateEditor().getUiComponent()).getText());
             b_fname.setText("");
             b_mi.setText("");
             b_lname.setText("");
             b_contact.setText("");
              b_address.setText("");
             //datehere.setText("");
             b_author.setText("");
             b_dateacq.setText("");
             b_est.setText("");
        window1.setVisible(false);
window2.setVisible(false);

            addbooktable();}

            catch(SQLException | HeadlessException e){JOptionPane.showMessageDialog(null,"Duplicate ID entry","INVALID",3);}
            returntable();
        }     
        
        
// TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
loginhistory.setVisible(false);
        
myprofile.setVisible(false);    
a.setVisible(false);
zxc.setVisible(false);
zxc.setVisible(false);
jButton1.setVisible(false);
updatebook_panel1.setVisible(true);
window1.setVisible(false);
window2.setVisible(false);
addStaff.setVisible(false);
returnPanel.setVisible(false);
addbooktable();

        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel9MouseClicked

    private void b_invnoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_b_invnoKeyReleased
 
        String cc = b_invno.getText();
        
        if(cc.equals(""))
        {
        b_invno.setText("");
        b_unit.setText("");
        b_price.setText("");
        b_discription.setText("");
        b_author.setText("");
        b_dateacq.setText("");
        b_est.setText("");
        }
        try{
            
                    Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost/librarydb","root","");
        
            String sq = "select * from books where InventoryNumber = ?";
            pst = conn.prepareStatement(sq);
            pst.setString(1, b_invno.getText());
            
            rs = pst.executeQuery();
            
           
           
           
      if(rs.next()){
          

          
        String add1=rs.getString("InventoryNumber");
        b_invno.setText(add1);
        
        String add2=rs.getString("Category");
        b_unit.setText(add2);
        
        String add3=rs.getString("Price");
        b_price.setText(add3);
        
        String add4=rs.getString("Description");
        b_discription.setText(add4);
        
        String add5=rs.getString("Author");
        b_author.setText(add5);
        
   String add6 =rs.getString("AcquiredDate");
 b_dateacq.setText(add6);
        
        String add7=rs.getString("EstimatedUsefulLife");
        b_est.setText(add7);
        
        
            String add77=rs.getString("counterr");
                
        
         String add8=rs.getString("Quantity");
        cqty.setText(add8);
        ///
          String aa = bqty.getText();
        int qq = Integer.parseInt(aa);
        
  String bb = cqty.getText();      
 int cqq = Integer.parseInt(bb);
 
 
  //String g = tt.getText();
 int gg=0;
  
 if(cqty.getText().equals("0"))
 {
     rem.setText("null");
     JOptionPane.showMessageDialog(this, "book not available");
 }
 else{
 gg  = cqq-qq;
 
 rem.setText(Integer.toString(gg)); 
 }
    }
            
        }catch (Exception e)
        {JOptionPane.showMessageDialog(null, "Book unavailable!");}         // TODO add your handling code here:
    }//GEN-LAST:event_b_invnoKeyReleased

    private void b_idnoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_b_idnoKeyReleased

        String ccc = b_idno.getText();
        
        if(ccc.equals(""))
        {
        b_fname.setText("");
        b_mi.setText("");
        b_lname.setText("");
        b_contact.setText("");
        b_address.setText("");
        }
        try{
            
                    Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost/librarydb","root","");
        
            String sq = "select * from history where IDnumber = ?";
            pst = conn.prepareStatement(sq);
            pst.setString(1, b_idno.getText());
            
            rs = pst.executeQuery();
            
           
           
           
      if(rs.next()){
     
        
        String add2=rs.getString("FirstName");
        b_fname.setText(add2);
        
        String add3=rs.getString("Mi");
        b_mi.setText(add3);
        
        String add4=rs.getString("LastName");
        b_lname.setText(add4);
        
        String add5=rs.getString("Contact_EmailAddress");
        b_contact.setText(add5);
                
        String add7=rs.getString("Address");
        b_address.setText(add7);
        
    }
            
        }catch (Exception e)
        {JOptionPane.showMessageDialog(null, e);} 
        
    }//GEN-LAST:event_b_idnoKeyReleased

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
loginhistory.setVisible(false);
myprofile.setVisible(false);    
a.setVisible(false);
zxc.setVisible(false);
zxc.setVisible(false);
jButton1.setVisible(false);
updatebook_panel1.setVisible(false);
window1.setVisible(false);
window2.setVisible(false);
addStaff.setVisible(false);
returnPanel.setVisible(true);       // TODO add your handling code here:
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
loginhistory.setVisible(false);
        myprofile.setVisible(false);    
a.setVisible(false);
zxc.setVisible(false);
zxc.setVisible(false);
jButton1.setVisible(false);
updatebook_panel1.setVisible(false);
window1.setVisible(false);
window2.setVisible(false);
addStaff.setVisible(true);
returnPanel.setVisible(false);
        stafftable();
 
// TODO add your handling code here:
    }//GEN-LAST:event_jLabel10MouseClicked

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        try{
            int row = jTable1.getSelectedRow();
            String click = (jTable1.getModel().getValueAt(row, 0).toString());
            String sql = "select * from books where InventoryNumber = '"+click+"' ";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if(rs.next())
            {
                
                
                String add1=rs.getString("InventoryNumber");
                add_invno.setText(add1);

                
                String categ=rs.getString("Category");
                switch (categ){
                    case "IT BOOKS":
                        CategoryComboBox.setSelectedIndex(0);
                        break;
                    case "HISTORY":
                        CategoryComboBox.setSelectedIndex(1);
                        break;
                    case "MYSTERY":
                        CategoryComboBox.setSelectedIndex(2);
                        break;
                        
                         case "SCIENCE FICTION":
                        CategoryComboBox.setSelectedIndex(3);
                        break;
                        
                         case "POLITICAL THRILLER":
                        CategoryComboBox.setSelectedIndex(4);
                        break;
                        
                        case "Other":
                        CategoryComboBox.setSelectedIndex(5);
                        break;

                }

                String add3=rs.getString("Price");
                add_price.setText(add3);

                String add4=rs.getString("Description");
                add_description.setText(add4);

                String add5=rs.getString("Author");
                add_author.setText(add5);

                Date add6 =rs.getDate("AcquiredDate");
                jDateChooser2.setDate(add6);

                String add7=rs.getString("EstimatedUsefulLife");
                add_est.setText(add7);
                      
                String add8=rs.getString("Quantity");
                qty.setText(add8);
                                
                String add9=rs.getString("counterr");
                ccc.setText(add9);

            }

        }catch(SQLException e){JOptionPane.showMessageDialog(null, e);}
    }//GEN-LAST:event_jTable1MouseClicked

    private void add_invnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_invnoActionPerformed

    }//GEN-LAST:event_add_invnoActionPerformed

    private void add_invnoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_add_invnoKeyReleased

               DefaultTableModel dm  = new functionclass().bookupdate(choice,add_invno.getText());
        jTable1.setModel(dm);
        
        String clear = add_invno.getText();
      if(clear.equals(""))
      {
                 add_invno.setText("");
                add_price.setText("");
                add_description.setText("");
                add_author.setText("");
                jDateChooser2.setDate(null);
                add_est.setText("");
      }
        /*
        try{

            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/librarydb","root","");

            String sq = "select * from books where InventoryNumber = ?";
            pst = conn.prepareStatement(sq);
            pst.setString(1, add_invno.getText());

            rs = pst.executeQuery();

            if(rs.next()){
                String add1=rs.getString("InventoryNumber");
                add_invno.setText(add1);

    String categ=rs.getString("Category");
                switch (categ){
                    case "IT BOOKS":
                        CategoryComboBox.setSelectedIndex(0);
                        break;
                    case "HISTORY":
                        CategoryComboBox.setSelectedIndex(1);
                        break;
                    case "SCIENCE & DISCOVERY":
                        CategoryComboBox.setSelectedIndex(2);
                        break;

                }


                String add3=rs.getString("Price");
                add_price.setText(add3);

                String add4=rs.getString("Description");
                add_description.setText(add4);

                String add5=rs.getString("Author");
                add_author.setText(add5);

                Date add6 =rs.getDate("AcquiredDate");
                jDateChooser2.setDate(add6);

                String add7=rs.getString("EstimatedUsefulLife");
                add_est.setText(add7);
                
 

            }

        }catch (Exception e)
        {JOptionPane.showMessageDialog(null, e);}      */  // TODO add your handling code here:
    }//GEN-LAST:event_add_invnoKeyReleased

    private void add_invnoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_add_invnoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_add_invnoKeyTyped

    private void addbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addbuttonActionPerformed
        if(add_invno.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "missing book inventory number");
        }
        else if(CategoryComboBox.getSelectedItem().toString().equals(""))
        {
            JOptionPane.showMessageDialog(null, "missing book Category");
        }
        else if(add_price.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "missing book price");
        }
        else if(add_description.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "missing book description");
        }

        else if(add_author.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "missing book author");
        }
        else if(add_est.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "missing book estimated useful life");
        }
        else{
            try{

                String Sql= "INSERT INTO books (InventoryNumber, Category,Price,  Description, Author,AcquiredDate,EstimatedUsefulLife,Quantity) VALUES (?,?,?,?,?,?,?,?)";
                pst= conn.prepareStatement(Sql);


                pst.setString(1, add_invno.getText());
                pst.setString(2,CategoryComboBox.getSelectedItem().toString());
                pst.setString(3, add_price.getText());
                pst.setString(4,add_description.getText());
                pst.setString(5,add_author.getText());
                pst.setString(6,((JTextField)jDateChooser2.getDateEditor().getUiComponent()).getText());
                pst.setString(7,add_est.getText());
                pst.setString(8,qty.getText());
                
                

                pst.execute();

                JOptionPane.showMessageDialog(null,"BOOK ADDED SUCCESSFULY!");

                add_invno.setText("");
                //add_unit.setText("");
                add_price.setText("");
                add_description.setText("");
                add_author.setText("");
                jDateChooser2.setDate(null);
                add_est.setText("");
                qty.setText("");

                addbooktable();}

            catch(SQLException | HeadlessException e){JOptionPane.showMessageDialog(null, e);}

        }        // TODO add your handling code here:
    }//GEN-LAST:event_addbuttonActionPerformed

    private void modifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifyActionPerformed
        if(add_invno.getText().equals(""))
        {JOptionPane.showMessageDialog(null, "invalid");}
        else{
            try{
                  String value1 = ccc.getText();
                String sql = "UPDATE `books` SET `InventoryNumber`=?,`Category`=?,`Price`=?,`Description`=?,`Author`=?,`AcquiredDate`=?,`EstimatedUsefulLife`=?,`Quantity`=?,`counterr`=? WHERE counterr = '"+value1+"'";
                pst=conn.prepareStatement(sql);
                 
                
                //String value1 = add_invno.getText();
                pst.setString(1,add_invno.getText());
                
                String categ = CategoryComboBox.getSelectedItem().toString();
                pst.setString(2, categ);            
                pst.setString(3, add_price.getText());
                pst.setString(4, add_description.getText());
                pst.setString(5, add_author.getText());
                
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String date = sdf.format(jDateChooser2.getDate());
                pst.setString(6, date);
                
                pst.setString(7,add_est.getText());
                 pst.setString(8,qty.getText());
                pst.setString(9,ccc.getText());
                
                
         

                
                JOptionPane.showMessageDialog(null, "Update Successfuly!");
                pst.execute();
                add_invno.setText("");
                //add_unit.setText("");
                add_price.setText("");
                add_description.setText("");
                add_author.setText("");
                jDateChooser2.setDate(null);
                add_est.setText("");
                ccc.setText("");
                qty.setText("");

                addbooktable();

            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_modifyActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed

        if(add_invno.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Choose to delete");
        }

        else{
            String sql="delete from books where InventoryNumber = ?";

            try{
                pst=conn.prepareStatement(sql);

                pst.setString(1,add_invno.getText());
                if(JOptionPane.showConfirmDialog(null,"CONFIRM TO TERMINATE?",null,JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION)
                pst.execute();
                add_invno.setText("");
                //add_unit.setText("");
                add_price.setText("");
                add_description.setText("");
                add_author.setText("");
                jDateChooser2.setDate(null);
                add_est.setText("");

                {
                    addbooktable();
                }

            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e);}
            addbooktable();
        }
    }//GEN-LAST:event_deleteActionPerformed

    private void add_estActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_estActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_add_estActionPerformed

    private void return_inventory_numberKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_return_inventory_numberKeyReleased

               DefaultTableModel dm  = new functionclass().returninv(choice,return_inventory_number.getText());
        returnbook_table.setModel(dm);

        

        
        String c = return_inventory_number.getText();
        
        if(c.equals(""))
        {
                return_inventory_number.setText("");
                return_unit.setText("");
                return_price.setText("");
                return_desc.setText("");
                return_author.setText("");
                return_idnumber.setText("");
                return_lastname.setText("");
                return_firstname.setText("");

                return_mi.setText("");

                return_dateborrowed1.setText("");

        }
        
        /*
        try{

            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/librarydb","root","");

            String sq = "select * from borrowd where InventoryNumber = ?";
            pst = conn.prepareStatement(sq);
            pst.setString(1, return_inventory_number.getText());

            rs = pst.executeQuery();

            if(rs.next()){
                
                
                String add1=rs.getString("InventoryNumber");
                return_inventory_number.setText(add1);

                String add2=rs.getString("Category");
                return_unit.setText(add2);

                String add3=rs.getString("Price");
                return_price.setText(add3);

                String add4=rs.getString("Description");
                return_desc.setText(add4);

                String add5=rs.getString("Author");
                return_author.setText(add5);

                String add6 =rs.getString("IDnumber");
                return_idnumber.setText(add6);

                String add7=rs.getString("LastName");
                return_lastname.setText(add7);

                String add8=rs.getString("FirstName");
                return_firstname.setText(add8);

                String add9=rs.getString("Mi");
                return_mi.setText(add9);

                String add10=rs.getString("Date");
                return_dateborrowed1.setText(add10);

            }
        }catch (Exception e)
        {JOptionPane.showMessageDialog(null, e);}        */
        // TODO add your handling code here:
    }//GEN-LAST:event_return_inventory_numberKeyReleased

    private void return_idnumberKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_return_idnumberKeyReleased
  DefaultTableModel dm  = new functionclass().returnid(choice,return_idnumber.getText());
        returnbook_table.setModel(dm);   
        
        String c = return_idnumber.getText();
        
        if(c.equals(""))
        {
              
                return_idnumber.setText("");
                return_lastname.setText("");
                return_firstname.setText("");

                return_mi.setText("");

                return_dateborrowed1.setText("");

        }
    }//GEN-LAST:event_return_idnumberKeyReleased

    private void return_dateborrowed1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_return_dateborrowed1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_return_dateborrowed1ActionPerformed

    private void return_book_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_return_book_buttonActionPerformed
       if(return_inventory_number.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "SELECT BOOK TO RETURN!");
        }
       else if(return_idnumber.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "missing student info");
        }
else{
        String sql="delete from borrowd where IDnumber = ?";
        
        try{
            pst=conn.prepareStatement(sql);
                       
            pst.setString(1,return_idnumber.getText());
            
            pst.execute();            
           
                stmt = conn.createStatement();
                String value1 = return_inventory_number.getText();
                String value2 = return_unit.getText();              
                String value3= return_price.getText();
                String value4 = return_desc.getText();
                String value5 = return_author.getText();
                String value6 = return_idnumber.getText();
                String value7 = return_lastname.getText();
                String value8 = return_firstname.getText();
                String value9 = return_mi.getText();
                String value13 = cont.getText();
                String value14 = adr.getText();
                String value10 = return_dateborrowed1.getText();      
                String value11 = datehere.getText();
                String value12 = return_remarks.getText();
                String value20 = "_";

                String Sql = "INSERT INTO history (InventoryNumber, Category, Price, Description, Author, IDnumber, LastName, FirstName, MI,Contact_EmailAddress,Address, DateBorrowed, DateReturned, Remarks,_) VALUES ('"+value1+"','"+value2+"','"+value3+"','"+value4+"','"+value5+"','"+value6+"','"+value7+"','"+value8+"','"+value9+"','"+value13+"','"+value14+"','"+value10+"','"+value11+"','"+value12+"','"+value20+"')";
                stmt.executeUpdate(Sql);
                JOptionPane.showMessageDialog(null,"Book Returned!");
         returntable();
         
         
         ///update
                String ff = return_inventory_number.getText();
                String sqls = "UPDATE `books` SET `InventoryNumber`=?,`Quantity`=? WHERE InventoryNumber = '"+ff+"'";
                pst=conn.prepareStatement(sqls);
                 
                
            
                pst.setString(1,return_inventory_number.getText());
                 pst.setString(2,tot.getText());
                  pst.execute();    
                  addbooktable();
         
         
    //history_table();
        }catch(Exception e)
            {JOptionPane.showMessageDialog(null, e);}
       }
        returntable();
//history_table();

        
        
                return_inventory_number.setText("");
                return_unit.setText("");
                return_price.setText("");
                return_desc.setText("");
                return_author.setText("");
                return_idnumber.setText("");
                return_lastname.setText("");
                return_firstname.setText("");
                return_mi.setText("");               
                return_dateborrowed1.setText("");
                datehere.setText("");
                cont.setText("");
                adr.setText("");
                return_remarks.setText("");
                ci.setText("");
                tot.setText("");


    }//GEN-LAST:event_return_book_buttonActionPerformed

    private void returnbook_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_returnbook_tableMouseClicked
        
        
        
        try{           
            int row = returnbook_table.getSelectedRow();
    String click = (returnbook_table.getModel().getValueAt(row, 6).toString());
    String sql = "select * from borrowd where IDnumber = '"+click+"' ";
    pst = conn.prepareStatement(sql);
    rs = pst.executeQuery();
            
            if(rs.next())
            {
   
                
                String add1=rs.getString("InventoryNumber");
                return_inventory_number.setText(add1);

                String add2=rs.getString("Category");
                return_unit.setText(add2);

                String add3=rs.getString("Price");
                return_price.setText(add3);

                String add4=rs.getString("Description");
                return_desc.setText(add4);

                String add5=rs.getString("Author");
                return_author.setText(add5);

                String add6 =rs.getString("IDnumber");
                return_idnumber.setText(add6);

                String add7=rs.getString("LastName");
                return_lastname.setText(add7);

                String add8=rs.getString("FirstName");
                return_firstname.setText(add8);

                String add9=rs.getString("Mi");
                return_mi.setText(add9);

                String add10=rs.getString("Date");
                return_dateborrowed1.setText(add10);
                
                String add11=rs.getString("Contact_EmailAddress");
                cont.setText(add11);
                
                String add12=rs.getString("Address");
                adr.setText(add12);
                
                String add13=rs.getString("Quantity");
                qt.setText(add13);
                
                
                
                
            }
                String sql2 = "select * from books where InventoryNumber = ? ";
     pst = conn.prepareStatement(sql2);
            pst.setString(1, return_inventory_number.getText());
            
            rs = pst.executeQuery();
            
            if(rs.next())
            {
   
                
                String add12=rs.getString("InventoryNumber");
                //adr.setText(add12);
                
                String add13=rs.getString("Quantity");
                ci.setText(add13);    
                
 String aa = qt.getText();
 int qq = Integer.parseInt(aa);
        
 String bb = ci.getText();      
 int cqq = Integer.parseInt(bb);
 
 
  //String g = tt.getText();
 int gg=0;
  
 gg  = cqq+qq;
 
 tot.setText(Integer.toString(gg)); 

                
            

        }}catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        
        
        ///
          

        // TODO add your handling code here:
    }//GEN-LAST:event_returnbook_tableMouseClicked

    private void return_descKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_return_descKeyReleased

        DefaultTableModel dm  = new functionclass().returndesc(choice,return_desc.getText());
        returnbook_table.setModel(dm);

        /*
                
        String c = return_desc.getText();
        
        if(c.equals(""))
        {
                return_inventory_number.setText("");
                return_unit.setText("");
                return_price.setText("");
                return_desc.setText("");
                return_author.setText("");
                return_idnumber.setText("");
                return_lastname.setText("");
                return_firstname.setText("");

                return_mi.setText("");

                return_dateborrowed1.setText("");

        }
        try{

            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/librarydb","root","");

            String sq = "select * from borrowd where Description = ?";
            pst = conn.prepareStatement(sq);
            pst.setString(1, return_desc.getText());

            rs = pst.executeQuery();

            if(rs.next()){
                String add1=rs.getString("InventoryNumber");
                return_inventory_number.setText(add1);

                String add2=rs.getString("Category");
                return_unit.setText(add2);

                String add3=rs.getString("Price");
                return_price.setText(add3);

                String add4=rs.getString("Description");
                return_desc.setText(add4);

                String add5=rs.getString("Author");
                return_author.setText(add5);

                String add6 =rs.getString("IDnumber");
                return_idnumber.setText(add6);

                String add7=rs.getString("LastName");
                return_lastname.setText(add7);

                String add8=rs.getString("FirstName");
                return_firstname.setText(add8);

                String add9=rs.getString("Mi");
                return_mi.setText(add9);

                String add10=rs.getString("Date");
                return_dateborrowed1.setText(add10);

            }
        }catch (Exception e)
        {JOptionPane.showMessageDialog(null, e);}  */
        // TODO add your handling code here:
    }//GEN-LAST:event_return_descKeyReleased

    private void return_authorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_return_authorKeyReleased
try{

            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/librarydb","root","");

            String sq = "select * from borrowd where Author = ?";
            pst = conn.prepareStatement(sq);
            pst.setString(1, return_author.getText());

            rs = pst.executeQuery();

            if(rs.next()){
                String add1=rs.getString("InventoryNumber");
                return_inventory_number.setText(add1);

                String add2=rs.getString("Category");
                return_unit.setText(add2);

                String add3=rs.getString("Price");
                return_price.setText(add3);

                String add4=rs.getString("Description");
                return_desc.setText(add4);

                String add5=rs.getString("Author");
                return_author.setText(add5);

                String add6 =rs.getString("IDnumber");
                return_idnumber.setText(add6);

                String add7=rs.getString("LastName");
                return_lastname.setText(add7);

                String add8=rs.getString("FirstName");
                return_firstname.setText(add8);

                String add9=rs.getString("Mi");
                return_mi.setText(add9);

                String add10=rs.getString("Date");
                return_dateborrowed1.setText(add10);

            }
        }catch (Exception e)
        {JOptionPane.showMessageDialog(null, e);}     
        
    }//GEN-LAST:event_return_authorKeyReleased

    private void jLabel20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseClicked
      
        history b= new history();
        b.setVisible(true);
       
    }//GEN-LAST:event_jLabel20MouseClicked

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        books p = new books();
        p.setVisible(true);
        
    }//GEN-LAST:event_jLabel8MouseClicked

    private void deleteaccActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteaccActionPerformed
       if(JOptionPane.showConfirmDialog(null,"confirm to delete","ACCOUNT",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION)
       {
        try{  String sql="delete from register where ID_Number = ?";
                pst=conn.prepareStatement(sql);
                pst.setString(1,id.getText());
                pst.execute();
                
                loginpage l = new loginpage();
                l.setVisible(true);
                this.dispose();
               

            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e);}}
       else
       {
       }
    }//GEN-LAST:event_deleteaccActionPerformed

    private void _miActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__miActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event__miActionPerformed

    private void addstaffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addstaffActionPerformed
       
        if(_id.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "missing 'ID NUMBER'");
        }
        else{
            try{
                String Sql= "INSERT INTO staff (_IDnumber, CourseYear, _LastName, _FirstName, _Mi, _Gender, _BirthDate, _Contact, DateRegistered,Password) VALUES (?,?,?,?,?,?,?,?,?,?)";

               pst= conn.prepareStatement(Sql);
               
                String gend = null;
                 if(Male.isSelected())
                {gend = "MALE";}
                if(Female.isSelected())
                {gend = "FEMALE";}
                
                 pst.setString(1, _id.getText());
                  pst.setString(2, _cy.getText());
                 pst.setString(3, _ln.getText());
                  pst.setString(4, _fn.getText());
                   pst.setString(5, _mi.getText());
                    pst.setString(6, gend);
                    pst.setString(7,((JTextField)_jDateChooser.getDateEditor().getUiComponent()).getText());
                      pst.setString(8, _cont.getText());
                       pst.setString(9, datehere.getText());
                                           pst.setString(10, staffpassword.getText());
            
                  
                
               
                  
                JOptionPane.showMessageDialog(null,"SUCCESS");
            pst.execute();
                    stafftable();}

            catch(SQLException | HeadlessException e){JOptionPane.showMessageDialog(null, e);}

        }
    }//GEN-LAST:event_addstaffActionPerformed

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        x = evt.getX();
        y= evt.getY();

        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1MousePressed

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged

        int xx = evt.getXOnScreen();
        int yy = evt.getYOnScreen();
        this.setLocation(xx-x,yy-y);

        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1MouseDragged

    private void myidMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_myidMouseClicked

        myprofile.setVisible(true);
        zxc.setVisible(false);
        jButton1.setVisible(false);
        updatebook_panel1.setVisible(false);
        window1.setVisible(false);
        window2.setVisible(false);
        addStaff.setVisible(false);
        returnPanel.setVisible(false);
    }//GEN-LAST:event_myidMouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        myprofile.setVisible(true);
        zxc.setVisible(true);
        //second.setVisible(true);
        a.setVisible(true);
        jButton1.setVisible(false);
        updatebook_panel1.setVisible(false);
        window1.setVisible(false);
        window2.setVisible(false);
        addStaff.setVisible(false);
        returnPanel.setVisible(false);
        try{

              byte[] imageBytes;
              Image image;
      
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/librarydb","root","");

            String sq = "select * from register where  ID_Number= ?";
            pst = conn.prepareStatement(sq);
            pst.setString(1, myid.getText());

            rs = pst.executeQuery();

            if(rs.next()){

                String add1=rs.getString("ID_Number");
                id.setText(add1);

                String add2=rs.getString("FirstName");
                fn.setText(add2);

                String add3=rs.getString("MiddleName");
                mi.setText(add3);

                String add4=rs.getString("LastName");
                ln.setText(add4);

                String add=rs.getString("BirthDate");
                birth.setText(add);

                String add6=rs.getString("Gender");
                gend.setText(add6);

                String add7=rs.getString("Street");
                str.setText(add7);

                String add8=rs.getString("Barangay");
                brgy.setText(add8);

                String add9=rs.getString("City");
                city.setText(add9);

                String add10=rs.getString("Province");
                prov.setText(add10);

                String add11=rs.getString("ContactNumber");
                numb.setText(add11);

                String add12=rs.getString("Email_Address");
                email.setText(add12);

            
                imageBytes=rs.getBytes("profilepicture");
                image=getToolkit().createImage(imageBytes);
                ImageIcon icon=new ImageIcon(image);             
                 ImageIcon imageIcon = new ImageIcon (new     ImageIcon(image).getImage().getScaledInstance(prof.getWidth(),prof.getHeight(),Image.SCALE_SMOOTH));
                 prof.setIcon(imageIcon);
            }

        }catch (Exception e)
        {
           // JOptionPane.showMessageDialog(null ,e);
        }
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        if(JOptionPane.showConfirmDialog(null,"logout?","PAGE",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION)
        {
            loginpage p = new loginpage();
            p.setVisible(true);
            this.dispose();}
        else
        {}
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        if(JOptionPane.showConfirmDialog(null,"are u sure u want to exit ?","MENU",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION)

        System.exit(0);      // TODO add your handling code here:
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        this.setState(JFrame.ICONIFIED);        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel52MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel52MouseClicked
      staffs t =new staffs();
      stafftable();
      t.setVisible(true);
      
    }//GEN-LAST:event_jLabel52MouseClicked

    private void _idKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event__idKeyReleased
      
        try{

            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/librarydb","root","");

            String sq = "select * from staff where _IDnumber = ?";
            pst = conn.prepareStatement(sq);
            pst.setString(1, _id.getText());

            rs = pst.executeQuery();

            if(rs.next()){
                String add1=rs.getString("_IDnumber");
                _id.setText(add1);

                String add2=rs.getString("CourseYear");
                _cy.setText(add2);

                String add3=rs.getString("_LastName");
                _ln.setText(add3);

                String add4=rs.getString("_FirstName");
                _fn.setText(add4);

                String add6 =rs.getString("_Mi");
                _mi.setText(add6);

                
                   Date add8 =rs.getDate("_BirthDate");
                _jDateChooser.setDate(add8);
                
                String add9=rs.getString("_Contact");
                _cont.setText(add9);

                

            }

        }catch (Exception e)
        {JOptionPane.showMessageDialog(null, e);}
    }//GEN-LAST:event__idKeyReleased

    private void choosefileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_choosefileActionPerformed
       
        
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        filename = f.getAbsolutePath();
        ImageIcon imageIcon = new ImageIcon (new ImageIcon(filename).getImage().getScaledInstance(changedp.getWidth(),changedp.getHeight(),Image.SCALE_SMOOTH));
        changedp.setIcon(imageIcon);
        
        try{
            File image = new File(filename);
            FileInputStream fis = new FileInputStream(image);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            for(int readNum; (readNum=fis.read(buf))!=-1;){
                bos.write(buf,0,readNum);
            }
            person_image=bos.toByteArray();
            
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_choosefileActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
try{   
    byte[] imageBytes;
              Image images;
              
     File image = new File(filename);      
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
        
                String value1 = myid.getText();
                String Sql= "update register set profilepicture=? where ID_Number=" +value1;

               pst= conn.prepareStatement(Sql);              
                     pst.setBytes(1,person_image);                  
                JOptionPane.showMessageDialog(null,"PROFILE IMAGE CHANGE SUCCESSFULY!");
            pst.executeUpdate();
            person_image=bos.toByteArray();
                    }
            catch(SQLException | HeadlessException e){JOptionPane.showMessageDialog(null, e);}

  try{
              byte[] imageBytes;
              Image image;
      
            
                    Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost/librarydb","root","");

            String sq = "select * from register where  ID_Number= ?";
            pst = conn.prepareStatement(sq);
            pst.setString(1, myid.getText());
            
            rs = pst.executeQuery();
            
            if(rs.next()){
            
             imageBytes=rs.getBytes("profilepicture");
                image=getToolkit().createImage(imageBytes);
                ImageIcon icon=new ImageIcon(image);             
                 ImageIcon imageIcon = new ImageIcon (new     ImageIcon(image).getImage().getScaledInstance(prof.getWidth(),prof.getHeight(),Image.SCALE_SMOOTH));
                prof.setIcon(imageIcon);
                 
                    
            
            }
            
        }catch (Exception e)
        {
        }
 
         
    }//GEN-LAST:event_jButton3ActionPerformed

    private void add_descriptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_descriptionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_add_descriptionActionPerformed

    private void return_descActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_return_descActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_return_descActionPerformed

    private void return_idnumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_return_idnumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_return_idnumberActionPerformed

    private void MaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MaleActionPerformed
if(Male.isSelected())
    Female.setSelected(false);
    }//GEN-LAST:event_MaleActionPerformed

    private void FemaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FemaleActionPerformed
if(Female.isSelected())
    Male.setSelected(false);       
    }//GEN-LAST:event_FemaleActionPerformed

    private void add_descriptionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_add_descriptionKeyReleased
/*
 DefaultTableModel dm  = new functionclass().bookupdatedesc(choice,add_description.getText());
        jTable1.setModel(dm);*/
        
        
    }//GEN-LAST:event_add_descriptionKeyReleased

    private void _idFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event__idFocusGained
        
           if(_id.getText().trim().toUpperCase().equals("ID NUMBER"))
        {
            _id.setText("");
            _id.setForeground(Color.WHITE);
        }
    }//GEN-LAST:event__idFocusGained

    private void _idFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event__idFocusLost
                  if(_id.getText().trim().toUpperCase().equals("") || _id.getText().trim().toUpperCase().equals("ID NUMBER"))
   {
       _id.setText("ID NUMBER");
       _id.setForeground(Color.WHITE);
   }
    }//GEN-LAST:event__idFocusLost

    private void _cyFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event__cyFocusGained
       
             if(_cy.getText().trim().toUpperCase().equals("YR/COURSE"))
        {
            _cy.setText("");
            _cy.setForeground(Color.WHITE);
        }
    }//GEN-LAST:event__cyFocusGained

    private void _cyFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event__cyFocusLost

     if(_cy.getText().trim().toUpperCase().equals("") || _cy.getText().trim().toUpperCase().equals("YR/COURSE"))
   {
       _cy.setText("YR/COURSE");
       _cy.setForeground(Color.WHITE);
   }
    }//GEN-LAST:event__cyFocusLost

    private void _lnFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event__lnFocusLost
      
            if(_ln.getText().trim().toUpperCase().equals("") || _ln.getText().trim().toUpperCase().equals("LAST NAME"))
   {
       _ln.setText("LAST NAME");
       _ln.setForeground(Color.WHITE);
   }
    }//GEN-LAST:event__lnFocusLost

    private void _lnFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event__lnFocusGained
      
           if(_ln.getText().trim().toUpperCase().equals("LAST NAME"))
        {
            _ln.setText("");
            _ln.setForeground(Color.WHITE);
        }
    }//GEN-LAST:event__lnFocusGained

    private void _fnFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event__fnFocusGained
       
             if(_fn.getText().trim().toUpperCase().equals("FIRST NAME"))
        {
            _fn.setText("");
            _fn.setForeground(Color.WHITE);
        }
    }//GEN-LAST:event__fnFocusGained

    private void _fnFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event__fnFocusLost
       
  if(_fn.getText().trim().toUpperCase().equals("") || _fn.getText().trim().toUpperCase().equals("FIRST NAME"))
   {
       _fn.setText("FIRST NAME");
       _fn.setForeground(Color.WHITE);
   }
    }//GEN-LAST:event__fnFocusLost

    private void _miFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event__miFocusGained
        
        if(_mi.getText().trim().toUpperCase().equals("MI"))
        {
            _mi.setText("");
            _mi.setForeground(Color.WHITE);
        }
    }//GEN-LAST:event__miFocusGained

    private void _miFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event__miFocusLost
     
         if(_mi.getText().trim().toUpperCase().equals("") || _mi.getText().trim().toUpperCase().equals("MI"))
   {
       _mi.setText("MI");
       _mi.setForeground(Color.WHITE);
   }
    }//GEN-LAST:event__miFocusLost

    private void _contFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event__contFocusGained
     
            if(_cont.getText().trim().toUpperCase().equals("CONTACT"))
        {
            _cont.setText("");
            _cont.setForeground(Color.WHITE);
        }
    }//GEN-LAST:event__contFocusGained

    private void _contFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event__contFocusLost
     
        if(_cont.getText().trim().toUpperCase().equals("") || _cont.getText().trim().toUpperCase().equals("CONTACT"))
   {
       _cont.setText("CONTACT");
       _cont.setForeground(Color.WHITE);
   }
    }//GEN-LAST:event__contFocusLost

    private void staffpasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_staffpasswordFocusGained
       
        if(staffpassword.getText().trim().toUpperCase().equals("PASSWORD"))
        {
            staffpassword.setText("");
            staffpassword.setForeground(Color.WHITE);
        }
    }//GEN-LAST:event_staffpasswordFocusGained

    private void staffpasswordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_staffpasswordFocusLost
        
        if(staffpassword.getText().trim().toUpperCase().equals("") || staffpassword.getText().trim().toUpperCase().equals("PASSWORD"))
   {
       staffpassword.setText("PASSWORD");
       staffpassword.setForeground(Color.WHITE);
   }
    }//GEN-LAST:event_staffpasswordFocusLost

    private void backg3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backg3MouseClicked
 window1.setVisible(false);
        window2.setVisible(false);
        updatebook_panel1.setVisible(false);
        addStaff.setVisible(false);
returnPanel.setVisible(false);
myprofile.setVisible(false);  
loginhistory.setVisible(false);
// TODO add your handling code here:
    }//GEN-LAST:event_backg3MouseClicked

    private void backg3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backg3MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_backg3MouseEntered

    private void jLabel74MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel74MouseClicked
 window1.setVisible(false);
        window2.setVisible(false);
        updatebook_panel1.setVisible(false);
        addStaff.setVisible(false);
returnPanel.setVisible(false);
myprofile.setVisible(false);  
loginhistory.setVisible(true);  
loginhistory_table();
// TODO add your handling code here:
    }//GEN-LAST:event_jLabel74MouseClicked

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Adminpage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Adminpage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Adminpage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Adminpage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Adminpage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JComboBox<String> CategoryComboBox;
    private javax.swing.JRadioButton Female;
    private javax.swing.JRadioButton Male;
    private javax.swing.JTextField _cont;
    private javax.swing.JTextField _cy;
    private javax.swing.JTextField _fn;
    private javax.swing.JTextField _id;
    private com.toedter.calendar.JDateChooser _jDateChooser;
    private javax.swing.JTextField _ln;
    private javax.swing.JTextField _mi;
    private javax.swing.JPanel a;
    private javax.swing.JPanel addStaff;
    private javax.swing.JTextField add_author;
    private javax.swing.JTextField add_description;
    private javax.swing.JTextField add_est;
    private javax.swing.JTextField add_invno;
    private javax.swing.JTextField add_price;
    private javax.swing.JButton addbutton;
    private javax.swing.JButton addstaff;
    private javax.swing.JLabel adr;
    private javax.swing.JTextField b_address;
    private javax.swing.JTextField b_author;
    private javax.swing.JTextField b_contact;
    private javax.swing.JTextField b_dateacq;
    private javax.swing.JTextField b_discription;
    private javax.swing.JTextField b_est;
    private javax.swing.JTextField b_fname;
    private javax.swing.JTextField b_idno;
    private javax.swing.JTextField b_invno;
    private javax.swing.JTextField b_lname;
    private javax.swing.JTextField b_mi;
    private javax.swing.JTextField b_price;
    private javax.swing.JTextField b_unit;
    private javax.swing.JLabel backg3;
    public javax.swing.JLabel birth;
    public javax.swing.JLabel birth1;
    private javax.swing.JPanel borrowpanel;
    private javax.swing.JLabel borrowpres;
    private javax.swing.JLabel bqty;
    private javax.swing.JLabel brgy;
    private javax.swing.JLabel brgy1;
    private javax.swing.JLabel ccc;
    public static javax.swing.JLabel changedp;
    private javax.swing.JButton choosefile;
    private javax.swing.JLabel ci;
    private javax.swing.JLabel city;
    private javax.swing.JLabel city1;
    private javax.swing.JLabel cont;
    private javax.swing.JLabel cqty;
    private javax.swing.JTextField datehere;
    private javax.swing.JButton delete;
    private javax.swing.JButton deleteacc;
    private javax.swing.JLabel email;
    public static javax.swing.JLabel fn;
    public static javax.swing.JLabel fn1;
    public static javax.swing.JLabel fn2;
    public static javax.swing.JLabel fname;
    private javax.swing.JLabel gend;
    private javax.swing.JLabel gend1;
    public static javax.swing.JLabel id;
    public static javax.swing.JLabel id1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
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
    public static javax.swing.JLabel jLabel5;
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
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    public static javax.swing.JTable jTable1;
    private javax.swing.JLabel kk;
    private javax.swing.JLabel left;
    public static javax.swing.JLabel ln;
    public static javax.swing.JLabel ln1;
    public static javax.swing.JLabel lname;
    private javax.swing.JPanel loginhistory;
    private javax.swing.JTable loginhistory_table;
    public static javax.swing.JLabel mi;
    public static javax.swing.JLabel mi1;
    private javax.swing.JButton modify;
    public static javax.swing.JLabel myid;
    private javax.swing.JPanel myprofile;
    private javax.swing.JLabel numb;
    private javax.swing.JLabel numb1;
    private javax.swing.JPanel panel1;
    private javax.swing.JPanel panel2;
    private javax.swing.JPanel panel3;
    private javax.swing.JPanel panel4;
    private javax.swing.JPanel panel5;
    private javax.swing.JPanel panel7;
    public static javax.swing.JLabel prof;
    private javax.swing.JLabel prov;
    private javax.swing.JLabel prov1;
    private javax.swing.JTextField qt;
    private javax.swing.JTextField qty;
    private javax.swing.JLabel rem;
    private javax.swing.JPanel returnPanel;
    private javax.swing.JTextField return_author;
    private javax.swing.JButton return_book_button;
    private javax.swing.JTextField return_dateborrowed;
    private javax.swing.JTextField return_dateborrowed1;
    private javax.swing.JTextField return_desc;
    private javax.swing.JTextField return_firstname;
    private javax.swing.JTextField return_idnumber;
    private javax.swing.JTextField return_inventory_number;
    private javax.swing.JTextField return_lastname;
    private javax.swing.JTextField return_mi;
    private javax.swing.JTextField return_price;
    private javax.swing.JTextField return_remarks;
    private javax.swing.JTextField return_unit;
    private javax.swing.JTable returnbook_table;
    private javax.swing.JLabel right;
    private javax.swing.JPasswordField staffpassword;
    private javax.swing.JTable stafftable;
    private javax.swing.JLabel stickmans;
    private javax.swing.JLabel str;
    private javax.swing.JLabel str1;
    private javax.swing.JLabel tot;
    private javax.swing.JPanel updatebook_panel1;
    private javax.swing.JPanel window1;
    private javax.swing.JPanel window2;
    private javax.swing.JPanel zxc;
    // End of variables declaration//GEN-END:variables
}
