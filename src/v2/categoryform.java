/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package v2;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author lenovo
 */
public class categoryform extends javax.swing.JFrame {

  Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
    String sql = null;
    PreparedStatement pst = null;
    public categoryform() {
         super("librarydb");
        initComponents();
        conn = connector.connectiondb();
        this.setLocationRelativeTo(null);
    }

    
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        addcat = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        addcat.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        addcat.setForeground(new java.awt.Color(0, 102, 102));
        addcat.setText(":");
        jPanel1.add(addcat, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 170, 40));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setText("Add Category");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 170, 40));

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton2.setText("DONE");
        jButton2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jButton2ItemStateChanged(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 230, 180));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      
        try{

                String Sql= "INSERT INTO bok (Category) VALUES (?)";
                pst= conn.prepareStatement(Sql);


                pst.setString(1, addcat.getText());      

                pst.execute();

                JOptionPane.showMessageDialog(null,"success");

                addcat.setText("");

                }catch(SQLException | HeadlessException e){JOptionPane.showMessageDialog(null, e);}

            
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
Adminpage.CategoryComboBox.removeAllItems();
       
                 try{
                conn = DriverManager.getConnection("jdbc:mysql://localhost/librarydb","root","");
                String sql="SELECT Category FROM bok GROUP BY Category";
                pst = conn.prepareStatement(sql);
                rs=pst.executeQuery();
                while(rs.next())
                { 
                    Adminpage.CategoryComboBox.addItem(rs.getString(1));
                }
                
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, ex);
            } 
        
        this.dispose();          // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jButton2ItemStateChanged
Adminpage.CategoryComboBox.removeAllItems();
       
                 try{
                conn = DriverManager.getConnection("jdbc:mysql://localhost/librarydb","root","");
                String sql="SELECT Category FROM bok GROUP BY Category";
                pst = conn.prepareStatement(sql);
                rs=pst.executeQuery();
                while(rs.next())
                { 
                    Adminpage.CategoryComboBox.addItem(rs.getString(1));
                }
                
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, ex);
            } 
        
        this.dispose();          // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ItemStateChanged

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
            java.util.logging.Logger.getLogger(categoryform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(categoryform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(categoryform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(categoryform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new categoryform().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField addcat;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
