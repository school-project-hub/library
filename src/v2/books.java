/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package v2;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
import static v2.Adminpage.jTable1;

/**
 *
 * @author lenovo
 */
public class books extends javax.swing.JFrame {

         Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
    String sql = null;
    PreparedStatement pst = null;
   
    
    public books() {
         super("librarydb");
        initComponents();
        conn = connector.connectiondb();
        this.setLocationRelativeTo(null);
        
        
   viewbooks();
   
        //booklanes.setVisible(false);
        //searchbook.setVisible(false);
       
       // jclose.setBackground(new Color(60,60,50,60));
        booklanes.setBackground(new Color(0,0,0,0));

        booklanes.setBackground(new Color(0,0,0,0));
        
        lane1.setBackground(new Color(100,100,100,100));
        lane2.setBackground(new Color(100,100,100,100));
        lane3.setBackground(new Color(100,100,100,100));
        lane4.setBackground(new Color(100,100,100,100));
        lane5.setBackground(new Color(100,100,100,100));
        
        
        selection.setBackground(new Color(100,100,100,100));
        
        ImageIcon myimage160 = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("lib.jpg")));     
      Image img1110 = myimage160.getImage();
      Image img1200 = img1110.getScaledInstance(jLabel1.getWidth(),jLabel1.getHeight(), Image.SCALE_SMOOTH);
      ImageIcon evp = new ImageIcon(img1200);
    jLabel1.setIcon(evp);
    }
    
    private void viewbooks(){
    try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/librarydb","root","");
        String sql = "SELECT distinct  `InventoryNumber`, `Category`, `Price`, `Description`, `Author`, `AcquiredDate`, `EstimatedUsefulLife`,`Quantity` FROM `books` group by InventoryNumber asc ";
        PreparedStatement pstmt = con.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        jtable_users.setModel(DbUtils.resultSetToTableModel(rs));
    
    }catch (ClassNotFoundException | SQLException e){
        JOptionPane.showMessageDialog(null, e);}}
    
            
            
    @SuppressWarnings("unchecked")
   
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        selection = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lane1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        lane2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        lane3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        lane4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        lane5 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jclose = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        booklanes = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtable_users = new javax.swing.JTable();
        searchbox = new javax.swing.JTextField();
        desx = new javax.swing.JLabel();
        as1 = new javax.swing.JLabel();
        as2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        selection.setBackground(new java.awt.Color(0, 204, 204));
        selection.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("DialogInput", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("CATEGORY");
        selection.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 21, 180, -1));

        lane1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 0, 0), java.awt.Color.orange, null, null));

        jLabel4.setFont(new java.awt.Font("DialogInput", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 0));
        jLabel4.setText("LANE 1 /IT BOOKS");
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout lane1Layout = new javax.swing.GroupLayout(lane1);
        lane1.setLayout(lane1Layout);
        lane1Layout.setHorizontalGroup(
            lane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        lane1Layout.setVerticalGroup(
            lane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                .addContainerGap())
        );

        selection.add(lane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 240, -1));

        lane2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 0, 0), java.awt.Color.orange, null, null));

        jLabel5.setFont(new java.awt.Font("Leelawadee UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 0));
        jLabel5.setText("LANE 2 /SCIENCE FICTION");
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout lane2Layout = new javax.swing.GroupLayout(lane2);
        lane2.setLayout(lane2Layout);
        lane2Layout.setHorizontalGroup(
            lane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lane2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        lane2Layout.setVerticalGroup(
            lane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lane2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                .addContainerGap())
        );

        selection.add(lane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 240, -1));

        lane3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 0, 0), java.awt.Color.orange, null, null));

        jLabel6.setFont(new java.awt.Font("DialogInput", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 0));
        jLabel6.setText("LANE 3 /HISTORY");
        jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout lane3Layout = new javax.swing.GroupLayout(lane3);
        lane3.setLayout(lane3Layout);
        lane3Layout.setHorizontalGroup(
            lane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lane3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                .addContainerGap())
        );
        lane3Layout.setVerticalGroup(
            lane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lane3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                .addContainerGap())
        );

        selection.add(lane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 240, -1));

        lane4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 0, 0), java.awt.Color.orange, null, null));

        jLabel7.setFont(new java.awt.Font("DialogInput", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 0));
        jLabel7.setText("LANE 4 MYSTERY");
        jLabel7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout lane4Layout = new javax.swing.GroupLayout(lane4);
        lane4.setLayout(lane4Layout);
        lane4Layout.setHorizontalGroup(
            lane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lane4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                .addContainerGap())
        );
        lane4Layout.setVerticalGroup(
            lane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lane4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                .addContainerGap())
        );

        selection.add(lane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, 240, -1));

        lane5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 0, 0), java.awt.Color.orange, null, null));

        jLabel8.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 0));
        jLabel8.setText("LANE 5 POLITICAL THRILLER");
        jLabel8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout lane5Layout = new javax.swing.GroupLayout(lane5);
        lane5.setLayout(lane5Layout);
        lane5Layout.setHorizontalGroup(
            lane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lane5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        lane5Layout.setVerticalGroup(
            lane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lane5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                .addContainerGap())
        );

        selection.add(lane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, 240, -1));

        jclose.setBackground(new java.awt.Color(153, 0, 0));
        jclose.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jclose.setForeground(new java.awt.Color(255, 255, 255));
        jclose.setText("X *CLOSE");
        jclose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcloseActionPerformed(evt);
            }
        });
        selection.add(jclose, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 500, 230, -1));

        jLabel3.setFont(new java.awt.Font("DialogInput", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 0));
        jLabel3.setText("      BOOKS");
        jLabel3.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)));
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        selection.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 90, 240, -1));

        jPanel1.add(selection, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 260, 540));

        booklanes.setBackground(new java.awt.Color(153, 255, 204));
        booklanes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtable_users.setBackground(new java.awt.Color(153, 255, 255));
        jtable_users.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jtable_users.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jtable_users.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jtable_users);

        booklanes.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 81, 840, 310));

        searchbox.setBackground(new java.awt.Color(0, 0, 0));
        searchbox.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        searchbox.setForeground(new java.awt.Color(255, 255, 255));
        searchbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchboxActionPerformed(evt);
            }
        });
        searchbox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchboxKeyReleased(evt);
            }
        });
        booklanes.add(searchbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 40, 300, 30));

        desx.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        desx.setForeground(new java.awt.Color(255, 255, 255));
        desx.setText("Description");
        booklanes.add(desx, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 40, -1, 20));

        as1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        as1.setForeground(new java.awt.Color(255, 255, 255));
        as1.setText("Search the Book");
        booklanes.add(as1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, 20));

        as2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        as2.setForeground(new java.awt.Color(255, 255, 255));
        as2.setText("here:");
        booklanes.add(as2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 40, -1, 20));

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setText("Lane: Other  /   Category: Other");
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        booklanes.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, 310, 50));

        jPanel1.add(booklanes, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 60, 870, 480));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1150, 570));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
      booklanes.setVisible(true);

    try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/librarydb","root","");
        String sql = "SELECT distinct `InventoryNumber`, `Category`, `Price`, `Description`, `Author`, `AcquiredDate`, `EstimatedUsefulLife`,`Quantity` FROM `books` where Category = 'IT BOOKS'";
        PreparedStatement pstmt = con.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        jtable_users.setModel(DbUtils.resultSetToTableModel(rs));

    }catch (ClassNotFoundException | SQLException e){
        JOptionPane.showMessageDialog(null, e);}

        
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
      booklanes.setVisible(true);

          try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/librarydb","root","");
        String sql = "SELECT distinct `InventoryNumber`, `Category`, `Price`, `Description`, `Author`, `AcquiredDate`, `EstimatedUsefulLife`,`Quantity` FROM `books` where Category = 'SCIENCE FICTION'";
        PreparedStatement pstmt = con.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        jtable_users.setModel(DbUtils.resultSetToTableModel(rs));

    }catch (ClassNotFoundException | SQLException e){
        JOptionPane.showMessageDialog(null, e);}

      
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
  booklanes.setVisible(true);
  
     try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/librarydb","root","");
        String sql = "SELECT distinct `InventoryNumber`, `Category`, `Price`, `Description`, `Author`, `AcquiredDate`, `EstimatedUsefulLife`,`Quantity` FROM `books` where Category = 'HISTORY'";
        PreparedStatement pstmt = con.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        jtable_users.setModel(DbUtils.resultSetToTableModel(rs));

    }catch (ClassNotFoundException | SQLException e){
        JOptionPane.showMessageDialog(null, e);}

    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
booklanes.setVisible(true);

  try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/librarydb","root","");
        String sql = "SELECT distinct `InventoryNumber`, `Category`, `Price`, `Description`, `Author`, `AcquiredDate`, `EstimatedUsefulLife`,`Quantity` FROM `books` where Category = 'MYSTERY'";
        PreparedStatement pstmt = con.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        jtable_users.setModel(DbUtils.resultSetToTableModel(rs));

    }catch (ClassNotFoundException | SQLException e){
        JOptionPane.showMessageDialog(null, e);}

    }//GEN-LAST:event_jLabel7MouseClicked

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
 try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/librarydb","root","");
        String sql = "SELECT distinct `InventoryNumber`, `Category`, `Price`, `Description`, `Author`, `AcquiredDate`, `EstimatedUsefulLife`,`Quantity` FROM `books` where Category = 'POLITICAL THRILLER'";
        PreparedStatement pstmt = con.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        jtable_users.setModel(DbUtils.resultSetToTableModel(rs));

    }catch (ClassNotFoundException | SQLException e){
        JOptionPane.showMessageDialog(null, e);       
    }
        
    }//GEN-LAST:event_jLabel8MouseClicked

    private void jcloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcloseActionPerformed
this.dispose();       
    }//GEN-LAST:event_jcloseActionPerformed

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
viewbooks(); 
    }//GEN-LAST:event_jLabel3MouseClicked

    private void searchboxKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchboxKeyReleased

        
        DefaultTableModel dm  = new functionclass().functionclassB(desx.getText(),searchbox.getText());
        jtable_users.setModel(dm);
        

                
    }//GEN-LAST:event_searchboxKeyReleased

    private void searchboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchboxActionPerformed

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked

    try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/librarydb","root","");
        String sql = "SELECT distinct `InventoryNumber`, `Category`, `Price`, `Description`, `Author`, `AcquiredDate`, `EstimatedUsefulLife`,`Quantity` FROM `books` where Category = 'Other'";
        PreparedStatement pstmt = con.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        jtable_users.setModel(DbUtils.resultSetToTableModel(rs));

    }catch (ClassNotFoundException | SQLException e){
        JOptionPane.showMessageDialog(null, e);}        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel9MouseClicked

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
            java.util.logging.Logger.getLogger(books.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(books.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(books.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(books.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new books().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel as1;
    private javax.swing.JLabel as2;
    private javax.swing.JPanel booklanes;
    private javax.swing.JLabel desx;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jclose;
    private javax.swing.JTable jtable_users;
    private javax.swing.JPanel lane1;
    private javax.swing.JPanel lane2;
    private javax.swing.JPanel lane3;
    private javax.swing.JPanel lane4;
    private javax.swing.JPanel lane5;
    private javax.swing.JTextField searchbox;
    private javax.swing.JPanel selection;
    // End of variables declaration//GEN-END:variables
}
