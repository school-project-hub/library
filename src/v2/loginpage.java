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
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import static v2.Adminpage.prof;

/**
 *
 * @author lenovo
 */
public class loginpage extends javax.swing.JFrame {
       Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
    String sql = null;
    PreparedStatement pst = null;
    
       String filename = null;
    byte[] person_image = null;
    
    public loginpage() {
              super("librarydb");
        initComponents();
         conn = connector.connectiondb();
        this.setLocationRelativeTo(null);
        createacc.setVisible(false);
        fp.setVisible(false);
        
        register_panel.setVisible(false);
        forgotpassword_panel.setVisible(false);
        backpanel.setBackground (new Color(0,0,0,0));
        
         
        
        
         ImageIcon myimage62 = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("usr.png")));     
      Image img11 = myimage62.getImage();
      Image img12 = img11.getScaledInstance(usrn.getWidth(),usrn.getHeight(), Image.SCALE_SMOOTH);
      ImageIcon e = new ImageIcon(img12);
    usrn.setIcon(e);
    
    ImageIcon myimage621 = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("pass.png")));     
      Image img111 = myimage621.getImage();
      Image img112 = img111.getScaledInstance(pss.getWidth(),pss.getHeight(), Image.SCALE_SMOOTH);
      ImageIcon ed = new ImageIcon(img112);
    pss.setIcon(ed);
    
    ImageIcon myimage160 = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("nb.jpeg")));     
      Image img1110 = myimage160.getImage();
      Image img1200 = img1110.getScaledInstance(background.getWidth(),background.getHeight(), Image.SCALE_SMOOTH);
      ImageIcon evp = new ImageIcon(img1200);
    background.setIcon(evp);
    
     kl.setBackground (new Color (0,0,0,0));
     l.setBackground (new Color (0,0,0,0));
     o.setBackground (new Color (0,0,0,0));
        
        /*ImageIcon myimage6211 = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("vv.jpg")));     
      Image img1111 = myimage6211.getImage();
      Image img1121 = img1111.getScaledInstance(backg.getWidth(),backg.getHeight(), Image.SCALE_SMOOTH);
      ImageIcon edw = new ImageIcon(img1121);
    backg.setIcon(edw);*/
        
        new Thread(){
            public void run(){
            while(true){
                Date dNow = new Date ( );
            
            SimpleDateFormat ft = new SimpleDateFormat ("E yyy.MM.dd  hh.mm.ss a");
            String time = ""+ft.format(dNow);
            tym.setText(time);
            }
                }
        }.start();
    }

   int x,y;
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        loginchooser = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        o = new javax.swing.JPanel();
        createacc = new javax.swing.JLabel();
        fp = new javax.swing.JLabel();
        l = new javax.swing.JPanel();
        username2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        pass2 = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        pss = new javax.swing.JLabel();
        usrn = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        tym = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        lop = new javax.swing.JLabel();
        backpanel = new javax.swing.JPanel();
        register_panel = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        idno = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lastname = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        firstname = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        middlename = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        bdchooser = new com.toedter.calendar.JDateChooser();
        jLabel15 = new javax.swing.JLabel();
        male = new javax.swing.JRadioButton();
        female = new javax.swing.JRadioButton();
        pichere = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        chooseimage = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        street = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        brgy = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        city = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        province = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        contactno = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        emailaddress = new javax.swing.JTextField();
        kl = new javax.swing.JPanel();
        authorizatiocode = new javax.swing.JTextField();
        cpassword = new javax.swing.JPasswordField();
        password = new javax.swing.JPasswordField();
        securityA = new javax.swing.JTextField();
        securityQ = new javax.swing.JComboBox<>();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        backg = new javax.swing.JLabel();
        forgotpassword_panel = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        verifyID = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        verifyAnswer = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel32 = new javax.swing.JLabel();
        secretquestion = new javax.swing.JLabel();
        now_retrieve = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 153, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 255), 2));
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

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel2MouseDragged(evt);
            }
        });
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel2MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel2MousePressed(evt);
            }
        });
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        loginchooser.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        loginchooser.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Student", "Admin" }));
        loginchooser.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                loginchooserItemStateChanged(evt);
            }
        });
        loginchooser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                loginchooserKeyReleased(evt);
            }
        });
        jPanel2.add(loginchooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(123, 180, 138, -1));

        jLabel1.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 153));
        jLabel1.setText("LOGIN as");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 173, 81, 35));

        o.setBackground(new java.awt.Color(204, 204, 204));
        o.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        createacc.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        createacc.setText("CREATE ACCOUNT");
        createacc.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        createacc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                createaccMouseClicked(evt);
            }
        });
        o.add(createacc, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 11, 192, -1));

        fp.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        fp.setForeground(new java.awt.Color(153, 0, 51));
        fp.setText("forgot password?");
        fp.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        fp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fpMouseClicked(evt);
            }
        });
        o.add(fp, new org.netbeans.lib.awtextra.AbsoluteConstraints(56, 42, -1, -1));

        jPanel2.add(o, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 426, -1, -1));

        l.setBackground(new java.awt.Color(204, 204, 204));

        username2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        username2.setForeground(new java.awt.Color(0, 0, 204));
        username2.setText("ID");
        username2.setBorder(null);
        username2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        username2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                username2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                username2FocusLost(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 204, 0));
        jLabel3.setText("______________________");

        pass2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        pass2.setForeground(new java.awt.Color(0, 0, 204));
        pass2.setText("PASSWORD");
        pass2.setBorder(null);
        pass2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pass2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                pass2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                pass2FocusLost(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 204, 0));
        jLabel2.setText("______________________");

        pss.setIcon(new javax.swing.ImageIcon("C:\\Users\\lenovo\\Documents\\java proj\\icons\\user_male_200px.png")); // NOI18N

        usrn.setIcon(new javax.swing.ImageIcon("C:\\Users\\lenovo\\Documents\\java proj\\icons\\user_male_200px.png")); // NOI18N

        javax.swing.GroupLayout lLayout = new javax.swing.GroupLayout(l);
        l.setLayout(lLayout);
        lLayout.setHorizontalGroup(
            lLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lLayout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(lLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(usrn, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pss, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(lLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(username2, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pass2, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );
        lLayout.setVerticalGroup(
            lLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(lLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(lLayout.createSequentialGroup()
                        .addComponent(username2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3))
                    .addComponent(usrn, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(lLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lLayout.createSequentialGroup()
                        .addComponent(pass2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2))
                    .addComponent(pss, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.add(l, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 214, -1, -1));

        jButton1.setBackground(new java.awt.Color(204, 255, 153));
        jButton1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton1.setText("sign in");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(113, 386, 100, -1));

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 0, 0));
        jLabel4.setText("   _");
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(212, 13, 30, -1));

        jLabel5.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 0, 0));
        jLabel5.setText("   x");
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(252, 13, 40, -1));

        jPanel5.setBackground(new java.awt.Color(204, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 102));
        jLabel6.setText("BOOK BORROWING");
        jPanel5.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 11, 250, 46));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 102));
        jLabel7.setText("              SYSTEM");
        jPanel5.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 63, 255, -1));

        jLabel33.setIcon(new javax.swing.ImageIcon("C:\\Users\\lenovo\\Documents\\studentprofiling content\\giphy.gif")); // NOI18N
        jPanel5.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(-170, 0, 460, 90));

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 50, 290, -1));

        tym.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        tym.setForeground(new java.awt.Color(255, 255, 255));
        tym.setText("time");
        jPanel2.add(tym, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 16, 290, 30));

        jLabel34.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(51, 51, 255));
        jLabel34.setText("About us");
        jLabel34.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel34.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel34.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel34MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 490, -1, -1));

        lop.setIcon(new javax.swing.ImageIcon("C:\\Users\\lenovo\\Documents\\studentprofiling content\\port.jpg")); // NOI18N
        jPanel2.add(lop, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 290, 520));

        backpanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        register_panel.setBackground(new java.awt.Color(255, 255, 255));
        register_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBackground(new java.awt.Color(255, 255, 204));
        jPanel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel12.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 153, 0));
        jLabel12.setText("REGISTER");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        register_panel.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, -1));

        jLabel36.setText("2x2 type");
        register_panel.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 80, -1, -1));

        idno.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        idno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                idnoKeyReleased(evt);
            }
        });
        register_panel.add(idno, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 44, 134, -1));

        jLabel8.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        jLabel8.setText("ID No.");
        register_panel.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 44, -1, 27));

        jLabel9.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        jLabel9.setText("LAST NAME");
        register_panel.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 88, -1, -1));

        lastname.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        register_panel.add(lastname, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 82, 189, -1));

        jLabel10.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        jLabel10.setText("FIRST NAME");
        register_panel.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 124, -1, 23));

        firstname.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        register_panel.add(firstname, new org.netbeans.lib.awtextra.AbsoluteConstraints(122, 120, 192, -1));

        jLabel11.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        jLabel11.setText("MIDDLE NAME");
        register_panel.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 164, -1, -1));

        middlename.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        register_panel.add(middlename, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 158, 189, -1));

        jLabel23.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        jLabel23.setText("DATE OF BIRTH");
        register_panel.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 191, -1, 48));

        bdchooser.setDateFormatString("yyyy-MM-dd");
        bdchooser.setOpaque(false);
        register_panel.add(bdchooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(128, 191, 152, 30));

        jLabel15.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        jLabel15.setText("GENDER");
        register_panel.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, -1, -1));

        male.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        male.setText("MALE");
        male.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maleActionPerformed(evt);
            }
        });
        register_panel.add(male, new org.netbeans.lib.awtextra.AbsoluteConstraints(128, 248, -1, -1));

        female.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        female.setText("FEMALE");
        female.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                femaleActionPerformed(evt);
            }
        });
        register_panel.add(female, new org.netbeans.lib.awtextra.AbsoluteConstraints(205, 248, -1, -1));

        pichere.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        register_panel.add(pichere, new org.netbeans.lib.awtextra.AbsoluteConstraints(417, 18, 180, 151));

        jLabel35.setText("Maximum size 2mb");
        register_panel.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 170, -1, -1));

        chooseimage.setBackground(new java.awt.Color(0, 204, 204));
        chooseimage.setText("Choose image");
        chooseimage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseimageActionPerformed(evt);
            }
        });
        register_panel.add(chooseimage, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 190, -1, -1));

        jLabel13.setFont(new java.awt.Font("Tempus Sans ITC", 1, 12)); // NOI18N
        jLabel13.setText("STREET");
        register_panel.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 309, -1, -1));

        street.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        register_panel.add(street, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 301, 154, -1));

        jLabel14.setFont(new java.awt.Font("Tempus Sans ITC", 1, 12)); // NOI18N
        jLabel14.setText("BARANGAY");
        register_panel.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 339, -1, 27));

        brgy.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        register_panel.add(brgy, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 339, 154, -1));

        jLabel16.setFont(new java.awt.Font("Tempus Sans ITC", 1, 12)); // NOI18N
        jLabel16.setText("CITY");
        register_panel.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 385, -1, -1));

        city.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        register_panel.add(city, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 377, 154, -1));

        jLabel17.setFont(new java.awt.Font("Tempus Sans ITC", 1, 12)); // NOI18N
        jLabel17.setText("PROVINCE");
        register_panel.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 427, -1, -1));

        province.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        province.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                provinceActionPerformed(evt);
            }
        });
        register_panel.add(province, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 415, 154, 29));

        jLabel18.setFont(new java.awt.Font("Tempus Sans ITC", 1, 12)); // NOI18N
        jLabel18.setText("CONTACT NUMBER");
        register_panel.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 463, -1, -1));

        contactno.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        register_panel.add(contactno, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 455, 154, -1));

        jLabel19.setFont(new java.awt.Font("Tempus Sans ITC", 1, 12)); // NOI18N
        jLabel19.setText("EMAIL-ADDRESS");
        register_panel.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 501, -1, -1));

        emailaddress.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        register_panel.add(emailaddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 493, 154, -1));

        kl.setBackground(new java.awt.Color(255, 255, 255));

        authorizatiocode.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        authorizatiocode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                authorizatiocodeActionPerformed(evt);
            }
        });

        cpassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cpasswordActionPerformed(evt);
            }
        });

        password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordActionPerformed(evt);
            }
        });

        securityA.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        securityA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                securityAActionPerformed(evt);
            }
        });

        securityQ.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        securityQ.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "What is the name of your favourite pet?", "What is your favourite colour?", "What is the name of your first cousin?", "Where did your parents meet?", "When did you spend your first honeymoon?", "Who is your favourite cartoon character?", "What is your favourite manga read?" }));

        jLabel20.setFont(new java.awt.Font("Tempus Sans ITC", 1, 12)); // NOI18N
        jLabel20.setText("SECURITY QUESTION");

        jLabel21.setFont(new java.awt.Font("Tempus Sans ITC", 1, 12)); // NOI18N
        jLabel21.setText("SECURITY ANSWER");

        jLabel22.setFont(new java.awt.Font("Tempus Sans ITC", 1, 12)); // NOI18N
        jLabel22.setText("PASSWORD");

        jLabel24.setFont(new java.awt.Font("Tempus Sans ITC", 1, 12)); // NOI18N
        jLabel24.setText("CONFIRM PASSWORD");

        jLabel25.setFont(new java.awt.Font("Tempus Sans ITC", 1, 12)); // NOI18N
        jLabel25.setText("AUTHORIZATION");

        javax.swing.GroupLayout klLayout = new javax.swing.GroupLayout(kl);
        kl.setLayout(klLayout);
        klLayout.setHorizontalGroup(
            klLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(klLayout.createSequentialGroup()
                .addGroup(klLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(securityQ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(klLayout.createSequentialGroup()
                        .addGroup(klLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addGroup(klLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(klLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(cpassword, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                                .addComponent(password, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(securityA, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(authorizatiocode, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 12, Short.MAX_VALUE))
        );
        klLayout.setVerticalGroup(
            klLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, klLayout.createSequentialGroup()
                .addComponent(securityQ, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(klLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(securityA))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(klLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(klLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(klLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(authorizatiocode)
                    .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        register_panel.add(kl, new org.netbeans.lib.awtextra.AbsoluteConstraints(295, 301, 350, 219));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        jButton2.setBackground(new java.awt.Color(0, 0, 255));
        jButton2.setFont(new java.awt.Font("Trebuchet MS", 1, 17)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("REGISTER NOW!");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        register_panel.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(463, 230, 160, 40));

        backg.setIcon(new javax.swing.ImageIcon("C:\\Users\\lenovo\\Documents\\studentprofiling content\\vv.jpg")); // NOI18N
        register_panel.add(backg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 530));

        backpanel.add(register_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 520));

        forgotpassword_panel.setBackground(new java.awt.Color(0, 0, 0));
        forgotpassword_panel.setForeground(new java.awt.Color(255, 255, 255));

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(153, 0, 0));
        jLabel26.setText(" PASSWORD RECOVERY");

        verifyID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                verifyIDKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                verifyIDKeyReleased(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(0, 102, 102));
        jLabel27.setText("What is your  ID No.?");

        jLabel28.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(0, 102, 102));
        jLabel28.setText("your  ");

        jLabel29.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(0, 102, 102));
        jLabel29.setText("Security Question?");

        jLabel30.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(0, 102, 102));
        jLabel30.setText("Your Answer here:");

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(0, 102, 102));
        jLabel31.setText("Password Retrieved:");

        jButton3.setBackground(new java.awt.Color(0, 204, 204));
        jButton3.setText("START");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel32.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(204, 0, 0));
        jLabel32.setText("cancel");
        jLabel32.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel32MouseClicked(evt);
            }
        });

        secretquestion.setForeground(new java.awt.Color(255, 255, 255));

        now_retrieve.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        now_retrieve.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout forgotpassword_panelLayout = new javax.swing.GroupLayout(forgotpassword_panel);
        forgotpassword_panel.setLayout(forgotpassword_panelLayout);
        forgotpassword_panelLayout.setHorizontalGroup(
            forgotpassword_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(forgotpassword_panelLayout.createSequentialGroup()
                .addGap(157, 157, 157)
                .addGroup(forgotpassword_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(forgotpassword_panelLayout.createSequentialGroup()
                        .addGroup(forgotpassword_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(forgotpassword_panelLayout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(jLabel26))
                            .addGroup(forgotpassword_panelLayout.createSequentialGroup()
                                .addGap(194, 194, 194)
                                .addGroup(forgotpassword_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, forgotpassword_panelLayout.createSequentialGroup()
                                        .addComponent(jLabel32)
                                        .addGap(53, 53, 53)))))
                        .addGap(146, 146, 146))
                    .addGroup(forgotpassword_panelLayout.createSequentialGroup()
                        .addGroup(forgotpassword_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel27)
                            .addComponent(jLabel28)
                            .addComponent(jLabel29)
                            .addComponent(jLabel31)
                            .addComponent(jLabel30))
                        .addGap(39, 39, 39)
                        .addGroup(forgotpassword_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(now_retrieve, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, forgotpassword_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(verifyID, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(verifyAnswer, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(secretquestion, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(70, 70, 70))))
        );
        forgotpassword_panelLayout.setVerticalGroup(
            forgotpassword_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(forgotpassword_panelLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel26)
                .addGap(18, 18, 18)
                .addGroup(forgotpassword_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(verifyID, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27))
                .addGap(32, 32, 32)
                .addGroup(forgotpassword_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(forgotpassword_panelLayout.createSequentialGroup()
                        .addComponent(jLabel28)
                        .addGap(11, 11, 11)
                        .addComponent(jLabel29))
                    .addComponent(secretquestion, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(forgotpassword_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(verifyAnswer, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30))
                .addGap(18, 18, 18)
                .addGroup(forgotpassword_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(now_retrieve, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel32)
                .addContainerGap(161, Short.MAX_VALUE))
        );

        backpanel.add(forgotpassword_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 520));
        backpanel.add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(-6, 0, 650, 520));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(backpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(backpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginchooserKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_loginchooserKeyReleased
       
     
    }//GEN-LAST:event_loginchooserKeyReleased

    private void loginchooserItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_loginchooserItemStateChanged
   if(loginchooser.getSelectedItem().toString().equals("Admin"))
        {
            createacc.setVisible(true);
            fp.setVisible(true);
        }
    if(loginchooser.getSelectedItem().toString().equals("Student"))
        {
            createacc.setVisible(false);
            fp.setVisible(false);
            register_panel.setVisible(false);  
forgotpassword_panel.setVisible(false);
background.setVisible(true);
        }

              
    }//GEN-LAST:event_loginchooserItemStateChanged

    private void jPanel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel2MouseClicked

    private void jPanel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MousePressed
       // TODO add your handling code here:
                        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel2MousePressed

    private void jPanel2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseDragged
         // TODO add your handling code here:
    }//GEN-LAST:event_jPanel2MouseDragged

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
x = evt.getX();
y= evt.getY();         // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1MousePressed

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
  int xx = evt.getXOnScreen();
        int yy = evt.getYOnScreen();
        this.setLocation(xx-x,yy-y);          // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1MouseDragged

    private void username2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_username2FocusGained
      if(username2.getText().trim().toUpperCase().equals("ID"))
        {
            username2.setText("");
            username2.setForeground(Color.BLUE);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_username2FocusGained

    private void username2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_username2FocusLost
   if(username2.getText().trim().toUpperCase().equals("") || username2.getText().trim().toUpperCase().equals("ID"))
   {
       username2.setText("ID");
       username2.setForeground(Color.BLUE);
   }        // TODO add your handling code here:
    }//GEN-LAST:event_username2FocusLost

    private void pass2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pass2FocusGained
      if(pass2.getText().trim().toUpperCase().equals("PASSWORD"))
        {
            pass2.setText("");
            pass2.setForeground(Color.BLUE);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_pass2FocusGained

    private void pass2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pass2FocusLost
           if(pass2.getText().trim().toUpperCase().equals("") || pass2.getText().trim().toUpperCase().equals("PASSWORD"))
   {
       pass2.setText("PASSWORD");
       pass2.setForeground(Color.BLUE);
   }        // TODO add your handling code here:
    }//GEN-LAST:event_pass2FocusLost

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
        
           PreparedStatement st;
        ResultSet rs;
        
        
        
        // get the username & password
        String username = username2.getText();
        String password = String.valueOf(pass2.getPassword());
        
        //create select a query to check if the username and the password exist in the database
        if(loginchooser.getSelectedItem().equals("Admin"))
        {
        String query = "SELECT * FROM `register` WHERE `ID_Number`= ? AND `Password` = ?";
        
        try {
            st = connector.connectiondb().prepareStatement(query);
            
              st.setString(1, username);
              st.setString(2, password);    
              rs = st.executeQuery();
              
              if (rs.next())
              {              
                 
                  
                  JOptionPane.showMessageDialog(null, "Login Success !","Success",1);
                   
                  Adminpage form = new Adminpage();                      
                  form.setVisible(true);  
                 
    
                                         
                  //close the current form
                  this.dispose();
              }
              else
              {
                 
                 JOptionPane.showMessageDialog(null, "Invalid Username / Password","Login Error",2);
                 username2.setText(null);
                 pass2.setText(null); 
              }
                        
        } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
        }}
        
        ////
        
        try{
              byte[] imageBytes;
              Image image;
      
            
                    Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost/librarydb","root","");

            String sq = "select * from register where  ID_Number= ?";
            pst = conn.prepareStatement(sq);
            pst.setString(1, username2.getText());
            
            rs = pst.executeQuery();
            
            if(rs.next()){
            String add11=rs.getString("FirstName");
            Adminpage.fname.setText(add11);
            
            String add22=rs.getString("LastName");
            Adminpage.lname.setText(add22); 
            
            String add33=rs.getString("ID_Number");
            Adminpage.myid.setText(add33);
            
             imageBytes=rs.getBytes("profilepicture");
                image=getToolkit().createImage(imageBytes);
                ImageIcon icon=new ImageIcon(image);             
                 ImageIcon imageIcon = new ImageIcon (new     ImageIcon(image).getImage().getScaledInstance(prof.getWidth(),prof.getHeight(),Image.SCALE_SMOOTH));
                 Adminpage.prof.setIcon(imageIcon);
                 
              String Sqll= "INSERT INTO loginhistory(IDnumber,LastName,FirstName,Type,Date) VALUES (?,?,?,?,?)";

              pst= conn.prepareStatement(Sqll);
          
               
                pst.setString(1, add33);
                pst.setString(2, add22);
                pst.setString(3, add11);
                pst.setString(4,loginchooser.getSelectedItem().toString());               
                pst.setString(5, tym.getText());
                
                
            pst.execute(); 
            
            
            }
            
        }catch (Exception e)
        {
        }
        
  /////////////staff
  if(loginchooser.getSelectedItem().equals("Student"))
        {
        String query = "SELECT * FROM `staff` WHERE `_IDnumber`= ? AND `Password` = ?";
        
        try {
            st = connector.connectiondb().prepareStatement(query);
            
              st.setString(1, username);
              st.setString(2, password);    
              rs = st.executeQuery();
              
              if (rs.next())
              {
                  //show a new form
                  JOptionPane.showMessageDialog(null, "Login Success !","Success",1);
                   
                  
                  
                  Staffpage form = new Staffpage();                      
                  form.setVisible(true);  
                 
    
                                                
                  //close the current form
                  this.dispose();
              }
              else
              {
                 
                 JOptionPane.showMessageDialog(null, "Invalid Username / Password","Login Error",2);
                 username2.setText(null);
                 pass2.setText(null); 
              }
                        
        } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
        }}
  
  try{
            
                    Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost/librarydb","root","");

            String sq = "select * from staff where  _IDnumber= ?";
            pst = conn.prepareStatement(sq);
            pst.setString(1, username2.getText());
            
            rs = pst.executeQuery();
            
            if(rs.next()){
            String add1=rs.getString("_FirstName");
            Staffpage.fname.setText(add1);
            
            String add2=rs.getString("_LastName");
            Staffpage.lname.setText(add2); 
            
            String add3=rs.getString("_IDnumber");
            Staffpage.myid.setText(add3);
            
                String Sql= "INSERT INTO `loginhistory`(`IDnumber`, `LastName`, `FirstName`, `Type`, `Date`) VALUES(?,?,?,?,?)";

              pst= conn.prepareStatement(Sql);
               
                pst.setString(1, add3);
                pst.setString(2, add2);
                pst.setString(3, add1);
                pst.setString(4,loginchooser.getSelectedItem().toString());               
                pst.setString(5, tym.getText());
                
                
            pst.execute();    
                    
            
            }
            
        }catch (Exception e)
        {
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        this.setState(JFrame.ICONIFIED);        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        if(JOptionPane.showConfirmDialog(null,"are u sure u want to exit ?","LOGIN PAGE",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION)
        System.exit(0);
    }//GEN-LAST:event_jLabel5MouseClicked

    private void idnoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_idnoKeyReleased

        try{

            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/librarydb","root","");

            String sq = "select * from register where ID_Number = ?";
            pst = conn.prepareStatement(sq);
            pst.setString(1, idno.getText());

            rs = pst.executeQuery();

            if(rs.next()){
                String add1=rs.getString("ID_Number");
                idno.setText(add1);

                String add2=rs.getString("LastName");
                lastname.setText(add2);

                String add3=rs.getString("FirstName");
                firstname.setText(add3);

                String add4=rs.getString("MiddleName");
                middlename.setText(add4);

                String add6 =rs.getString("Street");
                street.setText(add6);

                String add7=rs.getString("Barangay");
                brgy.setText(add7);

                String add8=rs.getString("City");
                city.setText(add8);

                String add9=rs.getString("Province");
                province.setText(add9);

                String add10=rs.getString("ContactNumber");
                contactno.setText(add10);

                String add11=rs.getString("Email_Address");
                emailaddress.setText(add11);

            }

        }catch (Exception e)
        {JOptionPane.showMessageDialog(null, e);}
    }//GEN-LAST:event_idnoKeyReleased

    private void maleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maleActionPerformed
        if(male.isSelected())
        {female.setSelected(false);}// TODO add your handling code here:
    }//GEN-LAST:event_maleActionPerformed

    private void femaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_femaleActionPerformed
        if(female.isSelected())
        {male.setSelected(false);}        // TODO add your handling code here:
    }//GEN-LAST:event_femaleActionPerformed

    private void chooseimageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooseimageActionPerformed

        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        filename = f.getAbsolutePath();
        ImageIcon imageIcon = new ImageIcon (new ImageIcon(filename).getImage().getScaledInstance(pichere.getWidth(),pichere.getHeight(),Image.SCALE_SMOOTH));
        pichere.setIcon(imageIcon);

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
        // TODO add your handling code here:
    }//GEN-LAST:event_chooseimageActionPerformed

    private void provinceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_provinceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_provinceActionPerformed

    private void authorizatiocodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_authorizatiocodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_authorizatiocodeActionPerformed

    private void cpasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cpasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cpasswordActionPerformed

    private void passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordActionPerformed

    private void securityAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_securityAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_securityAActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(idno.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Provide your ID NUMBER");
        }
        else if(lastname.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Provide your LAST NAME");
        }
        else if(firstname.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Provide your FIRST NAME");
        }
        else if(securityA.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Provide a SECURITY ANSWER");
        }
        else if(password.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Provide a PASSWORD");
        }
        else if(cpassword.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "confirm your password");
        }
        else if(authorizatiocode.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Provide an AUTHORIZATION CODE");
        }

        else
        {

            try {

                String Sql = "INSERT INTO register (ID_Number, LastName, FirstName, MiddleName,BirthDate, Gender, Street, Barangay, City, Province,  ContactNumber, Email_Address, SecurityQuestion, SecurityAnswer, Password, cPassword, Authorization,profilepicture) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                pst= conn.prepareStatement(Sql);

                String selection = null;
                if(male.isSelected())
                {selection = "MALE";}

                if(female.isSelected())
                {selection = "FEMALE";}

                pst.setString(1, idno.getText());
                pst.setString(2,lastname.getText());
                pst.setString(3, firstname.getText());
                pst.setString(4,middlename.getText());
                pst.setString(5,((JTextField)bdchooser.getDateEditor().getUiComponent()).getText());
                pst.setString(6, selection);
                pst.setString(7,street.getText());
                pst.setString(8,brgy.getText());
                pst.setString(9,city.getText());
                pst.setString(10,province.getText());
                pst.setString(11,contactno.getText());
                pst.setString(12,emailaddress.getText());
                pst.setString(13,securityQ.getSelectedItem().toString());
                pst.setString(14,securityA.getText());
                pst.setString(15,password.getText());
                pst.setString(16,cpassword.getText());
                pst.setString(17,authorizatiocode.getText());
                pst.setBytes(18,person_image);
                String value15 = password.getText();
                String value16 = cpassword.getText();
                String value17 = authorizatiocode.getText();

                if(value15.equals(value16) && value17.equals("libraryADMIN"))
                {
                    pst.execute();
                    JOptionPane.showMessageDialog(this, "Succes!","Success", JOptionPane.INFORMATION_MESSAGE);
               idno.setText("");
               lastname.setText("");
               firstname.setText("");
               middlename.setText("");
bdchooser.setDate(null);
                male.setSelected(false);
                female.setSelected(false);
                street.setText("");
                brgy.setText("");
                city.setText("");
                province.setText("");
                contactno.setText("");
                emailaddress.setText("");
               
                securityA.setText("");
                password.setText("");
                cpassword.setText("");
                authorizatiocode.setText("");
                
                password.getText();
                cpassword.getText();
                authorizatiocode.setText("");
                    register_panel.setVisible(false);
                    forgotpassword_panel.setVisible(false);
                    
                   // createacc.setVisible(false);
           // fp.setVisible(false);
            register_panel.setVisible(false);  
forgotpassword_panel.setVisible(false);
background.setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(this,"Please fill fields correctly!", "User not registered", JOptionPane.ERROR_MESSAGE);}

            }
            catch(SQLException | HeadlessException e){
                JOptionPane.showMessageDialog(this, e);}
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void createaccMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_createaccMouseClicked
register_panel.setVisible(true);  
forgotpassword_panel.setVisible(false);
background.setVisible(false);// TODO add your handling code here:
    }//GEN-LAST:event_createaccMouseClicked

    private void fpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fpMouseClicked
register_panel.setVisible(false);
forgotpassword_panel.setVisible(true);
background.setVisible(false);// TODO add your handling code here:
    }//GEN-LAST:event_fpMouseClicked

    private void verifyIDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_verifyIDKeyPressed

        try{

            String sql = "select * from register where ID_Number = ?";
            pst = conn.prepareStatement(sql);
            pst.setString(1, verifyID.getText());
            rs = pst.executeQuery();

            if(rs.next()){

                String add4=rs.getString("ID_Number");
                verifyID.setText(add4);

                String add5=rs.getString("SecurityQuestion");
                secretquestion.setText(add5);

            }

        }catch (Exception e)
        {JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_verifyIDKeyPressed

    private void verifyIDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_verifyIDKeyReleased

    }//GEN-LAST:event_verifyIDKeyReleased

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if(verifyAnswer.getText().equals(""))
        {JOptionPane.showMessageDialog(null, "Nothing to proccess");}
        else{
            try{

                String sq = "select * from register where SecurityAnswer = ?";
                pst = conn.prepareStatement(sq);
                pst.setString(1, verifyAnswer.getText());
                rs = pst.executeQuery();

                if(rs.next()){

                    String add1=rs.getString("cPassword");
                    JOptionPane.showMessageDialog(null,"Password Retrieved!");
                    now_retrieve.setText(add1);
                }
                else{
                    now_retrieve.setText("");
                    verifyAnswer.setText("");
                    secretquestion.setText("");
                    verifyID.setText("");
                    JOptionPane.showMessageDialog(null,"not matched");
                }
            }catch (Exception e)
            {JOptionPane.showMessageDialog(null, e);
            }}
            //////////////

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jLabel32MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel32MouseClicked

        loginpage l = new loginpage();
        l.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel32MouseClicked

    private void jLabel34MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel34MouseClicked
developers op= new developers();
op.setVisible(true);

// TODO add your handling code here:
    }//GEN-LAST:event_jLabel34MouseClicked

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
            java.util.logging.Logger.getLogger(loginpage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(loginpage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(loginpage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(loginpage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new loginpage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField authorizatiocode;
    private javax.swing.JLabel backg;
    private javax.swing.JLabel background;
    private javax.swing.JPanel backpanel;
    private com.toedter.calendar.JDateChooser bdchooser;
    private javax.swing.JTextField brgy;
    private javax.swing.JButton chooseimage;
    private javax.swing.JTextField city;
    private javax.swing.JTextField contactno;
    private javax.swing.JPasswordField cpassword;
    private javax.swing.JLabel createacc;
    private javax.swing.JTextField emailaddress;
    private javax.swing.JRadioButton female;
    private javax.swing.JTextField firstname;
    private javax.swing.JPanel forgotpassword_panel;
    private javax.swing.JLabel fp;
    private javax.swing.JTextField idno;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
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
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel kl;
    private javax.swing.JPanel l;
    private javax.swing.JTextField lastname;
    private javax.swing.JComboBox<String> loginchooser;
    private javax.swing.JLabel lop;
    private javax.swing.JRadioButton male;
    private javax.swing.JTextField middlename;
    private javax.swing.JLabel now_retrieve;
    private javax.swing.JPanel o;
    private javax.swing.JPasswordField pass2;
    private javax.swing.JPasswordField password;
    private javax.swing.JLabel pichere;
    private javax.swing.JTextField province;
    private javax.swing.JLabel pss;
    private javax.swing.JPanel register_panel;
    private javax.swing.JLabel secretquestion;
    private javax.swing.JTextField securityA;
    private javax.swing.JComboBox<String> securityQ;
    private javax.swing.JTextField street;
    private javax.swing.JLabel tym;
    private javax.swing.JTextField username2;
    private javax.swing.JLabel usrn;
    private javax.swing.JTextField verifyAnswer;
    private javax.swing.JTextField verifyID;
    // End of variables declaration//GEN-END:variables
}
