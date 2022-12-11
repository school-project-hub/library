/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package v2;

import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
import static v2.Adminpage.jTable1;

/**
 *
 * @author lenovo
 */
public class staffs extends javax.swing.JFrame {

    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
    String sql = null;
    PreparedStatement pst = null;
    
    public staffs() {
        super("librarydb");
        initComponents();
         conn = connector.connectiondb();
        staffstable();
        this.setLocationRelativeTo(null);
    
          ImageIcon myimage1160 = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("books.jpg")));     
      Image img11101 = myimage1160.getImage();
      Image img12001 = img11101.getScaledInstance(asd.getWidth(),asd.getHeight(), Image.SCALE_SMOOTH);
      ImageIcon evp1 = new ImageIcon(img12001);
    asd.setIcon(evp1);
        
    }

    private void staffstable(){
    try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/librarydb","root","");
        String sql = "SELECT distinct _IDnumber as ID, CourseYear, _LastName as LASTNAME, _FirstName as FIRSTNAME, _Mi as MI, _Gender as GENDER, _BirthDate as BIRTHDATE, _Contact AS CONTACT, DateRegistered from staff";
        PreparedStatement pstmt = con.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        staffstable.setModel(DbUtils.resultSetToTableModel(rs));
    
    }catch (ClassNotFoundException | SQLException e){
        JOptionPane.showMessageDialog(null, e);}}
    
    int choice;
     
     public void choice(){
     }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        staffstable = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        asd = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        sid = new javax.swing.JTextField();
        scy = new javax.swing.JLabel();
        sln = new javax.swing.JLabel();
        sfn = new javax.swing.JLabel();
        smi = new javax.swing.JLabel();
        sgend = new javax.swing.JLabel();
        sbd = new javax.swing.JLabel();
        scont = new javax.swing.JLabel();
        sdr = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.red, java.awt.Color.red, java.awt.Color.orange, java.awt.Color.orange));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        staffstable.setModel(new javax.swing.table.DefaultTableModel(
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
        staffstable.getTableHeader().setReorderingAllowed(false);
        staffstable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                staffstableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(staffstable);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        asd.setIcon(new javax.swing.ImageIcon("C:\\Users\\lenovo\\Pictures\\Saved Pictures\\books-animated-103763-9858017.gif")); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(asd, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 14, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(asd, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                .addContainerGap())
        );

        jButton1.setBackground(new java.awt.Color(204, 0, 0));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("DELETE USER");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 0, 0));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("BACK");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1041, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(59, 59, 59))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        sid.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        sid.setForeground(new java.awt.Color(0, 51, 51));
        sid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                sidKeyReleased(evt);
            }
        });

        scy.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        scy.setForeground(new java.awt.Color(0, 51, 51));

        sln.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        sln.setForeground(new java.awt.Color(0, 51, 51));

        sfn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        sfn.setForeground(new java.awt.Color(0, 51, 51));

        smi.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        smi.setForeground(new java.awt.Color(0, 51, 51));

        sgend.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        sgend.setForeground(new java.awt.Color(0, 51, 51));

        sbd.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        sbd.setForeground(new java.awt.Color(0, 51, 51));

        scont.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        scont.setForeground(new java.awt.Color(0, 51, 51));

        sdr.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        sdr.setForeground(new java.awt.Color(0, 51, 51));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("ID NUMBER");

        jLabel2.setText("____________________________________________________________________________________________________________________________________________________________________________");
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(sid, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scy, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sln, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sfn, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(smi, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(sgend, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sbd, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scont, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sdr, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(scy, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sln, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sfn, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(smi, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sgend, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sbd, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(scont, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sdr, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(53, 53, 53))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void staffstableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_staffstableMouseClicked
  
                try{
            int row = staffstable.getSelectedRow();
            String click = (staffstable.getModel().getValueAt(row, 0).toString());
            String sql = "select * from staff where _IDnumber = '"+click+"' ";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if(rs.next())
            {
                String add1=rs.getString("_IDnumber");
                sid.setText(add1);

                String add2=rs.getString("CourseYear");
                scy.setText(add2);

                String add3=rs.getString("_LastName");
                sln.setText(add3);

                String add4=rs.getString("_FirstName");
                sfn.setText(add4);

                String add5=rs.getString("_Mi");
                smi.setText(add5);

                String add6=rs.getString("_Gender");
                sgend.setText(add6);

                String add7=rs.getString("_BirthDate");
                sbd.setText(add7);
                
                String add8=rs.getString("_Contact");
                scont.setText(add8);
                
                String add9=rs.getString("DateRegistered");
                sdr.setText(add9);
            }

        }catch(SQLException e){JOptionPane.showMessageDialog(null, e);}
        
    }//GEN-LAST:event_staffstableMouseClicked

    private void sidKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_sidKeyReleased

          DefaultTableModel dm  = new functionclass().staffs(choice,sid.getText());
        staffstable.setModel(dm);

   String th = sid.getText();
            if(th.equals("")){
                
                sid.setText("");
                scy.setText("");
                sln.setText("");
                sfn.setText("");
                smi.setText("");
                sgend.setText("");
                sbd.setText("");
                scont.setText("");
                sdr.setText("");

            }        
/*        try{

            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/librarydb","root","");

            String sq = "select * from staff where _IDnumber = ?";
            pst = conn.prepareStatement(sq);
            pst.setString(1, sid.getText());

            rs = pst.executeQuery();

            if(rs.next()){

                String add1=rs.getString("_IDnumber");
                sid.setText(add1);

                String add2=rs.getString("CourseYear");
                scy.setText(add2);

                String add3=rs.getString("_LastName");
                sln.setText(add3);

                String add4=rs.getString("_FirstName");
                sfn.setText(add4);

                String add5=rs.getString("_Mi");
                smi.setText(add5);

                String add6=rs.getString("_Gender");
                sgend.setText(add6);

                String add7=rs.getString("_BirthDate");
                sbd.setText(add7);
                
                String add8=rs.getString("_Contact");
                scont.setText(add8);
                
                String add9=rs.getString("DateRegistered");
                sdr.setText(add9);

            }
            String th = sid.getText();
            if(th.equals("")){
                
                sid.setText("");
                scy.setText("");
                sln.setText("");
                sfn.setText("");
                smi.setText("");
                sgend.setText("");
                sbd.setText("");
                scont.setText("");
                sdr.setText("");

            }

        }catch (Exception e)
        {JOptionPane.showMessageDialog(null, e);}    */      // TODO add your handling code here:
    }//GEN-LAST:event_sidKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      
        if(sid.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Choose to delete");
        }

        else{
            String sql="delete from staff where _IDnumber = ?";

            try{
                pst=conn.prepareStatement(sql);

                pst.setString(1,sid.getText());
                if(JOptionPane.showConfirmDialog(null,"CONFIRM TO DELETE?",null,JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION)
                pst.execute();
              
                sid.setText("");
                scy.setText("");
                sln.setText("");
                sfn.setText("");
                smi.setText("");
                sgend.setText("");
                sbd.setText("");
                scont.setText("");
                sdr.setText("");

                {
                    staffstable();
                }

            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e);}
             staffstable();
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
this.dispose(); 
// TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(staffs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(staffs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(staffs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(staffs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new staffs().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel asd;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel sbd;
    private javax.swing.JLabel scont;
    private javax.swing.JLabel scy;
    private javax.swing.JLabel sdr;
    private javax.swing.JLabel sfn;
    private javax.swing.JLabel sgend;
    private javax.swing.JTextField sid;
    private javax.swing.JLabel sln;
    private javax.swing.JLabel smi;
    private javax.swing.JTable staffstable;
    // End of variables declaration//GEN-END:variables
}
