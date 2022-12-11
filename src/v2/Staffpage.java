/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package v2;

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
import static v2.Adminpage.jTable1;

public class Staffpage extends javax.swing.JFrame {

    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
    String sql = null;
    PreparedStatement pst = null;
    
    public Staffpage() {
         super("librarydb");
        initComponents();
        conn = connector.connectiondb();
        returntable();
        
        this.setLocationRelativeTo(null);
        
        
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
                
         window1.setVisible(false);
        window2.setVisible(false);
returnPanel.setVisible(false);
//myprofile.setVisible(false);
        
       back.setBackground(new Color(0,0,0,0));
        
        panel1.setBackground(new Color(100,100,100,100));
        panel2.setBackground(new Color(100,100,100,100));
        panel3.setBackground(new Color(100,100,100,100));      
        panel7.setBackground(new Color(100,100,100,100));
       // window1.setBackground(new Color(100,100,100,100));
        //window2.setBackground(new Color(100,100,100,100));
       // returnPanel.setBackground(new Color(100,100,100,100));
        
        
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
    
    ImageIcon myimage16 = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("proff.png")));     
      Image img1211 = myimage16.getImage();
      Image img2112 = img1211.getScaledInstance(prof.getWidth(),prof.getHeight(), Image.SCALE_SMOOTH);
      ImageIcon ewf = new ImageIcon(img2112);
    prof.setIcon(ewf);
    
    
     ImageIcon myimage60 = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("roomlib.jpg")));     
      Image img110 = myimage60.getImage();
      Image img120 = img110.getScaledInstance(kk1.getWidth(),kk1.getHeight(), Image.SCALE_SMOOTH);
      ImageIcon ep = new ImageIcon(img120);
    kk1.setIcon(ep);

    
     ImageIcon myimage1160 = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("port.jpg")));     
      Image img11101 = myimage1160.getImage();
      Image img12001 = img11101.getScaledInstance(backg3.getWidth(),backg3.getHeight(), Image.SCALE_SMOOTH);
      ImageIcon evp1 = new ImageIcon(img12001);
    backg3.setIcon(evp1);
    
    }
    
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
    
    private void addbooktable(){
    try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/librarydb","root","");
        String sql = "SELECT distinct  `InventoryNumber`, `Category`, `Price`, `Description`, `Author`, `AcquiredDate`, `EstimatedUsefulLife`,`Quantity` FROM `books` group by InventoryNumber asc ";
        PreparedStatement pstmt = con.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        //jTable1.setModel(DbUtils.resultSetToTableModel(rs));
    
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
        stickmans = new javax.swing.JLabel();
        myid = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        panel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        panel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        panel1 = new javax.swing.JPanel();
        borrowpres = new javax.swing.JLabel();
        panel7 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        backg3 = new javax.swing.JLabel();
        salogpanel = new javax.swing.JPanel();
        left = new javax.swing.JLabel();
        right = new javax.swing.JLabel();
        back = new javax.swing.JPanel();
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
        jLabel47 = new javax.swing.JLabel();
        qt = new javax.swing.JTextField();
        ci = new javax.swing.JLabel();
        tott = new javax.swing.JLabel();
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
        window1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        b_invno = new javax.swing.JTextField();
        b_unit = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        b_discription = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        b_author = new javax.swing.JTextField();
        b_dateacq = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        b_est = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        b_price = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        bqty = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        cqty = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        rem = new javax.swing.JLabel();
        kk1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 204), 3));
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
        lname.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 51)));
        jPanel1.add(lname, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, 130, -1));

        fname.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        fname.setText("NAME");
        fname.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 51)));
        jPanel1.add(fname, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 130, -1));

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

        panel3.setBackground(new java.awt.Color(0, 0, 0));
        panel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 102, 102), new java.awt.Color(0, 204, 204), null, null));
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

        getContentPane().add(panel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 200, 40));

        panel2.setBackground(new java.awt.Color(0, 0, 0));
        panel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 102, 102), new java.awt.Color(0, 204, 204), null, null));
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
            .addGroup(panel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(21, 21, 21))
        );

        getContentPane().add(panel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 200, 40));

        panel1.setBackground(new java.awt.Color(0, 0, 0));
        panel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 102, 102), new java.awt.Color(0, 204, 204), null, null));
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

        panel7.setBackground(new java.awt.Color(0, 0, 0));
        panel7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 102, 102), new java.awt.Color(0, 204, 204), null, null));
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

        getContentPane().add(panel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 200, 40));

        backg3.setIcon(new javax.swing.ImageIcon("C:\\Users\\lenovo\\Documents\\library v2 images\\giphy (2).gif")); // NOI18N
        backg3.setToolTipText("");
        backg3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 204)));
        backg3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backg3MouseClicked(evt);
            }
        });
        getContentPane().add(backg3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-90, 90, 290, 480));

        salogpanel.setBackground(new java.awt.Color(0, 153, 255));
        salogpanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        salogpanel.add(left, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 40, 490));
        salogpanel.add(right, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 10, 40, 490));

        back.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        returnPanel.add(return_inventory_number, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 155, 28));

        jLabel35.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setText("INVENTORY NUMBER");
        returnPanel.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, -1, -1));

        return_unit.setEditable(false);
        return_unit.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        returnPanel.add(return_unit, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 142, 28));

        jLabel36.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setText("CATEGORY");
        returnPanel.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, -1, -1));

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
        returnPanel.add(return_desc, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 210, 440, 28));

        jLabel37.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setText("DESCRIPTION");
        returnPanel.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 240, -1, -1));

        return_author.setEditable(false);
        return_author.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        return_author.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                return_authorKeyReleased(evt);
            }
        });
        returnPanel.add(return_author, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 270, 220, 28));

        jLabel38.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setText("AUTHOR");
        returnPanel.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 300, -1, -1));

        return_price.setEditable(false);
        return_price.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        returnPanel.add(return_price, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 135, 28));

        jLabel39.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setText("PRICE");
        returnPanel.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, -1, -1));

        return_remarks.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        return_remarks.setForeground(new java.awt.Color(255, 0, 51));
        returnPanel.add(return_remarks, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 330, 160, 28));

        jLabel40.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 255, 255));
        jLabel40.setText("REMARKS");
        returnPanel.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 360, -1, -1));

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
        returnPanel.add(return_idnumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, 140, 28));

        jLabel42.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(255, 255, 255));
        jLabel42.setText("ID NUMBER");
        returnPanel.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, -1, -1));

        return_firstname.setEditable(false);
        return_firstname.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        returnPanel.add(return_firstname, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 390, 160, 28));

        jLabel41.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(255, 255, 255));
        jLabel41.setText("FIRST NAME");
        returnPanel.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 420, -1, -1));

        return_dateborrowed1.setEditable(false);
        return_dateborrowed1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        return_dateborrowed1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                return_dateborrowed1ActionPerformed(evt);
            }
        });
        returnPanel.add(return_dateborrowed1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 270, 230, 28));

        jLabel43.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(255, 255, 255));
        jLabel43.setText("BORROWED DATE");
        returnPanel.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 300, -1, -1));

        return_lastname.setEditable(false);
        return_lastname.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        returnPanel.add(return_lastname, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 390, 140, 28));

        jLabel44.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(255, 255, 255));
        jLabel44.setText("LAST NAME");
        returnPanel.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 420, -1, -1));

        return_mi.setEditable(false);
        return_mi.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        returnPanel.add(return_mi, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 390, 32, 28));

        jLabel45.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(255, 255, 255));
        jLabel45.setText("M.I.");
        returnPanel.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 420, -1, -1));

        return_book_button.setBackground(new java.awt.Color(0, 153, 255));
        return_book_button.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        return_book_button.setForeground(new java.awt.Color(255, 255, 255));
        return_book_button.setText("RETURN BOOK NOW");
        return_book_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                return_book_buttonActionPerformed(evt);
            }
        });
        returnPanel.add(return_book_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 409, 160, 40));

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

        returnPanel.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 48, 760, 139));

        cont.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        cont.setForeground(new java.awt.Color(255, 255, 255));
        cont.setText("CONTACT");
        returnPanel.add(cont, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 320, 170, 30));

        adr.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        adr.setForeground(new java.awt.Color(255, 255, 255));
        adr.setText("ADDRESS");
        returnPanel.add(adr, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 340, 170, 30));

        jLabel11.setIcon(new javax.swing.ImageIcon("C:\\Users\\lenovo\\Documents\\java proj\\icons\\call2_32.png")); // NOI18N
        returnPanel.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 320, 30, 20));

        jLabel46.setIcon(new javax.swing.ImageIcon("C:\\Users\\lenovo\\Documents\\java proj\\icons\\home2_32.png")); // NOI18N
        returnPanel.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 350, 30, 20));

        jLabel47.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(255, 255, 255));
        jLabel47.setText("QTY.");
        returnPanel.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 240, 30, 20));

        qt.setBackground(new java.awt.Color(51, 51, 51));
        qt.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        qt.setForeground(new java.awt.Color(255, 255, 255));
        qt.setBorder(null);
        returnPanel.add(qt, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 210, 30, 30));

        ci.setForeground(new java.awt.Color(255, 255, 255));
        ci.setText("current");
        returnPanel.add(ci, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 240, -1, -1));

        tott.setForeground(new java.awt.Color(255, 255, 255));
        tott.setText("sum");
        returnPanel.add(tott, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 240, -1, -1));

        back.add(returnPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 760, 460));

        window2.setBackground(new java.awt.Color(255, 255, 255));
        window2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 204)));
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
        window2.add(b_contact, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 241, 330, 29));

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
        window2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(122, 387, -1, -1));

        back.add(window2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 0, 370, 470));

        window1.setBackground(new java.awt.Color(255, 255, 255));
        window1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 204)));
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

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setText("CATEGORY");
        window1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 149, 103, -1));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setText("DISCRIPTION");
        window1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 217, 103, -1));

        b_discription.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        window1.add(b_discription, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 182, 330, 29));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setText("AUTHOR");
        window1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 278, 113, -1));

        b_author.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        window1.add(b_author, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 243, 330, 29));

        b_dateacq.setEditable(false);
        b_dateacq.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        window1.add(b_dateacq, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 311, 152, 29));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel17.setText("DATE ACQUIRED");
        window1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 346, 113, -1));

        b_est.setEditable(false);
        b_est.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        window1.add(b_est, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 379, 152, 29));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel18.setText("ESTIMATED USEFILLIFE");
        window1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 414, 156, -1));

        b_price.setEditable(false);
        b_price.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        window1.add(b_price, new org.netbeans.lib.awtextra.AbsoluteConstraints(216, 114, 120, 29));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel19.setText("PRICE");
        window1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(216, 149, 103, -1));

        jLabel54.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel54.setText("INVENTORY NO.");
        window1.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 81, 113, -1));

        bqty.setForeground(new java.awt.Color(255, 255, 255));
        bqty.setText("1");
        window1.add(bqty, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 50, 20, 30));

        jLabel76.setForeground(new java.awt.Color(255, 255, 255));
        jLabel76.setText("-");
        window1.add(jLabel76, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 60, 20, 10));

        cqty.setForeground(new java.awt.Color(255, 255, 255));
        cqty.setText("this");
        window1.add(cqty, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 60, -1, -1));

        jLabel77.setForeground(new java.awt.Color(255, 255, 255));
        jLabel77.setText("=");
        window1.add(jLabel77, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 60, 20, 10));

        rem.setForeground(new java.awt.Color(255, 255, 255));
        rem.setText("rem");
        window1.add(rem, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 50, 20, 30));

        back.add(window1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, -10, 390, 470));

        salogpanel.add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 810, 460));

        kk1.setForeground(new java.awt.Color(0, 153, 255));
        kk1.setIcon(new javax.swing.ImageIcon("C:\\Users\\lenovo\\Documents\\library v2 images\\roomlib.jpg")); // NOI18N
        salogpanel.add(kk1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 760, 480));

        getContentPane().add(salogpanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, 820, 490));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        this.setState(JFrame.ICONIFIED);        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        if(JOptionPane.showConfirmDialog(null,"are u sure u want to exit ?","MENU",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION)

        System.exit(0);      // TODO add your handling code here:
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        if(JOptionPane.showConfirmDialog(null,"logout?","PAGE",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION)
        {
            loginpage p = new loginpage();
            p.setVisible(true);
            this.dispose();}
        else
        {}
    }//GEN-LAST:event_jLabel2MouseClicked

    private void myidMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_myidMouseClicked



        //jButton1.setVisible(false);

        window1.setVisible(false);
        window2.setVisible(false);
        returnPanel.setVisible(false);
    }//GEN-LAST:event_myidMouseClicked

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged

        int xx = evt.getXOnScreen();
        int yy = evt.getYOnScreen();
        this.setLocation(xx-x,yy-y);

        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1MouseDragged

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        x = evt.getX();
        y= evt.getY();

        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1MousePressed

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        books p = new books();
        p.setVisible(true);

    }//GEN-LAST:event_jLabel8MouseClicked

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked

      //  jButton1.show(false);

        window1.show(false);
        window2.show(false);

        returnPanel.show(true);  
        
returntable();// TODO add your handling code here:
    }//GEN-LAST:event_jLabel7MouseClicked

    private void borrowpresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_borrowpresMouseClicked
       // jButton1.setVisible(true);
  
        window1.show(true);
        window2.show(true);
        returnPanel.show(false);

    }//GEN-LAST:event_borrowpresMouseClicked

    private void jLabel20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseClicked

        history b= new history();
        b.setVisible(true);
        history.clearhisb.setVisible(false);

    }//GEN-LAST:event_jLabel20MouseClicked

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
        {JOptionPane.showMessageDialog(null, "Book not available");}         // TODO add your handling code here:
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

    private void b_lnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_lnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_b_lnameActionPerformed

    private void b_contactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_contactActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_b_contactActionPerformed

    private void b_addressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_addressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_b_addressActionPerformed

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
                //window1.setVisible(false);
                //window2.setVisible(false);

             }

            catch(SQLException | HeadlessException e){JOptionPane.showMessageDialog(null,"BOOK is not return yet or duplicate ID entry","INVALID",3);}
            //returntable();
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

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

        
/*        String c = return_inventory_number.getText();

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
        {JOptionPane.showMessageDialog(null, e);}     */
// TODO add your handling code here:
    }//GEN-LAST:event_return_inventory_numberKeyReleased

    private void return_descActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_return_descActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_return_descActionPerformed

    private void return_descKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_return_descKeyReleased
DefaultTableModel dm  = new functionclass().returndesc(choice,return_desc.getText());
        returnbook_table.setModel(dm);
/*        String c = return_desc.getText();

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
        {JOptionPane.showMessageDialog(null, e);}       */  // TODO add your handling code here:
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

    private void return_idnumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_return_idnumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_return_idnumberActionPerformed

    private void return_idnumberKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_return_idnumberKeyReleased

        
        DefaultTableModel dm  = new functionclass().returnid(choice,return_idnumber.getText());
        returnbook_table.setModel(dm);
/*        String c = return_idnumber.getText();

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

        }*/
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

                ///
                String ff = return_inventory_number.getText();
                String sqls = "UPDATE `books` SET `InventoryNumber`=?,`Quantity`=? WHERE InventoryNumber = '"+ff+"'";
                pst=conn.prepareStatement(sqls);

                pst.setString(1,return_inventory_number.getText());
                 pst.setString(2,tott.getText());
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
                tott.setText("");

    }//GEN-LAST:event_return_book_buttonActionPerformed

    private void returnbook_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_returnbook_tableMouseClicked

        try{
            int row = returnbook_table.getSelectedRow();
            String click = (returnbook_table.getModel().getValueAt(row, 6).toString());
            String sql = "select * from borrowd where IDnumber= '"+click+"' ";
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
            String sql3 = "select * from books where InventoryNumber = ? ";
     pst = conn.prepareStatement(sql3);
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
 
 tott.setText(Integer.toString(gg)); 
            }

        }catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e);
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_returnbook_tableMouseClicked

    private void backg3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backg3MouseClicked
       // TODO add your handling code here:
    }//GEN-LAST:event_backg3MouseClicked

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
            java.util.logging.Logger.getLogger(Staffpage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Staffpage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Staffpage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Staffpage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Staffpage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
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
    private javax.swing.JPanel back;
    private javax.swing.JLabel backg3;
    private javax.swing.JLabel borrowpres;
    private javax.swing.JLabel bqty;
    private javax.swing.JLabel ci;
    private javax.swing.JLabel cont;
    private javax.swing.JLabel cqty;
    private javax.swing.JTextField datehere;
    public static javax.swing.JLabel fname;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
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
    private javax.swing.JLabel jLabel3;
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
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel kk1;
    private javax.swing.JLabel left;
    public static javax.swing.JLabel lname;
    public static javax.swing.JLabel myid;
    private javax.swing.JPanel panel1;
    private javax.swing.JPanel panel2;
    private javax.swing.JPanel panel3;
    private javax.swing.JPanel panel7;
    public static javax.swing.JLabel prof;
    private javax.swing.JTextField qt;
    private javax.swing.JLabel rem;
    private javax.swing.JPanel returnPanel;
    private javax.swing.JTextField return_author;
    private javax.swing.JButton return_book_button;
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
    private javax.swing.JPanel salogpanel;
    private javax.swing.JLabel stickmans;
    private javax.swing.JLabel tott;
    private javax.swing.JPanel window1;
    private javax.swing.JPanel window2;
    // End of variables declaration//GEN-END:variables
}
