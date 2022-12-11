/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package v2;

import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author lenovo
 */
public class loadingscreen extends javax.swing.JFrame {
    
    
    public loadingscreen() {
        initComponents();
        
        this.setLocationRelativeTo(null);
        
        ImageIcon myimage6 = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("loadingwhite.PNG")));     
      Image img121 = myimage6.getImage();
      Image img212 = img121.getScaledInstance(jLabel1.getWidth(),jLabel1.getHeight(), Image.SCALE_SMOOTH);
      ImageIcon ef = new ImageIcon(img212);
    jLabel1.setIcon(ef);
    }

  
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 204), 3));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        counter.setFont(new java.awt.Font("Tempus Sans ITC", 1, 36)); // NOI18N
        counter.setForeground(new java.awt.Color(0, 255, 255));
        counter.setText("1O0%");
        jPanel1.add(counter, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 450, 100, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\lenovo\\Documents\\java proj\\icons\\loadingwhite.png")); // NOI18N
        jLabel1.setText("img");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 380, 200, 170));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 883, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 572, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        loadingscreen kx = new loadingscreen();
       
        kx.setVisible(true);
        
                   try{
           for (int i=0; i<=100; i++){
               Thread.sleep(100);
               loadingscreen.counter.setText(Integer.toString(i)+"%");
               
               if(i==100){
                   loginpage sl = new loginpage();
                 
                    kx.dispose();
                      sl.show();
                }  
                }         
                        }catch(InterruptedException ez)
                        {
                            JOptionPane.showMessageDialog(null, ez);
                        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new loadingscreen().setVisible(true);
            }
        });
        String cc = counter.getText();
        if(cc == "100%")
        {
            loadingscreen kcx = new loadingscreen();
       
        kcx.setVisible(false);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static final javax.swing.JLabel counter = new javax.swing.JLabel();
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
