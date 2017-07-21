package partNumbering_generator;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class sign_up_frame extends javax.swing.JFrame {

    ImageIcon err = new ImageIcon(getClass().getResource("/partNumbering_generator/sign-error-icon (1).png"));
    ImageIcon war = new ImageIcon(getClass().getResource("/partNumbering_generator/sign-warning-icon (1).png"));
    ImageIcon che = new ImageIcon(getClass().getResource("/partNumbering_generator/sign-check-icon (1).png"));
    
    ArrayList<String> uAdmin = new ArrayList<>(), uUser = new ArrayList<>();
    
    String[] AdminArray, UserArray;
    
    String mesUser, mesPass, mesConPass, mesFname, mesLname, mesJob;
    
    Connection conn = null;
    Statement stmnt;
    ResultSet reSet;
    
    public sign_up_frame() {
        initComponents();
        
        setLocationRelativeTo(null);
        
        this.setIconImage(new ImageIcon(getClass().getResource("xepto logo - white bg - x.jpg")).getImage()); 
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        bg_pan = new javax.swing.JPanel();
        header_pan = new javax.swing.JPanel();
        lbl_icon = new javax.swing.JLabel();
        lbl_name = new javax.swing.JLabel();
        lbl_name1 = new javax.swing.JLabel();
        main_pan = new javax.swing.JPanel();
        lbl_head = new javax.swing.JLabel();
        lbl_user = new javax.swing.JLabel();
        lbl_pass = new javax.swing.JLabel();
        lbl_conPass = new javax.swing.JLabel();
        lbl_fname = new javax.swing.JLabel();
        lbl_lname = new javax.swing.JLabel();
        lbl_job = new javax.swing.JLabel();
        txt_user = new javax.swing.JTextField();
        txt_fname = new javax.swing.JTextField();
        txt_lname = new javax.swing.JTextField();
        txt_job = new javax.swing.JTextField();
        txt_pass = new javax.swing.JPasswordField();
        txt_conPass = new javax.swing.JPasswordField();
        btn_sign_up = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btn_check = new javax.swing.JButton();

        jTextField1.setText("jTextField1");

        setTitle("Sign up - Part Number Generator");
        setResizable(false);

        bg_pan.setBackground(new java.awt.Color(204, 204, 255));
        bg_pan.setMaximumSize(new java.awt.Dimension(670, 540));
        bg_pan.setMinimumSize(new java.awt.Dimension(670, 540));
        bg_pan.setPreferredSize(new java.awt.Dimension(670, 540));

        header_pan.setBackground(new java.awt.Color(255, 255, 255));
        header_pan.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lbl_icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/partNumbering_generator/xepto logo - white bg.png"))); // NOI18N

        lbl_name.setFont(new java.awt.Font("Miriam Fixed", 1, 40)); // NOI18N
        lbl_name.setForeground(new java.awt.Color(0, 0, 153));
        lbl_name.setText("Sign-Up");

        lbl_name1.setFont(new java.awt.Font("Tahoma", 1, 35)); // NOI18N
        lbl_name1.setForeground(new java.awt.Color(0, 0, 153));
        lbl_name1.setText("||");

        javax.swing.GroupLayout header_panLayout = new javax.swing.GroupLayout(header_pan);
        header_pan.setLayout(header_panLayout);
        header_panLayout.setHorizontalGroup(
            header_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(header_panLayout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(lbl_icon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_name1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_name)
                .addGap(209, 209, 209))
        );
        header_panLayout.setVerticalGroup(
            header_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(header_panLayout.createSequentialGroup()
                .addGroup(header_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(header_panLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(header_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_name1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl_name)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, header_panLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(lbl_icon)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        main_pan.setBackground(new java.awt.Color(204, 204, 204));
        main_pan.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        main_pan.setMaximumSize(new java.awt.Dimension(650, 443));
        main_pan.setMinimumSize(new java.awt.Dimension(650, 443));

        lbl_head.setFont(new java.awt.Font("Miriam Fixed", 1, 30)); // NOI18N
        lbl_head.setForeground(new java.awt.Color(255, 255, 255));
        lbl_head.setText("------Create an Account------");

        lbl_user.setFont(new java.awt.Font("Miriam Fixed", 0, 20)); // NOI18N
        lbl_user.setText("Username : ");

        lbl_pass.setFont(new java.awt.Font("Miriam Fixed", 0, 20)); // NOI18N
        lbl_pass.setText("Password : ");

        lbl_conPass.setFont(new java.awt.Font("Miriam Fixed", 0, 20)); // NOI18N
        lbl_conPass.setText("Confirm Password : ");

        lbl_fname.setFont(new java.awt.Font("Miriam Fixed", 0, 20)); // NOI18N
        lbl_fname.setText("First Name : ");

        lbl_lname.setFont(new java.awt.Font("Miriam Fixed", 0, 20)); // NOI18N
        lbl_lname.setText("Last Name : ");

        lbl_job.setFont(new java.awt.Font("Miriam Fixed", 0, 20)); // NOI18N
        lbl_job.setText("Job Position : ");

        txt_user.setFont(new java.awt.Font("Miriam", 0, 20)); // NOI18N
        txt_user.setForeground(new java.awt.Color(0, 51, 153));
        txt_user.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        txt_user.setSelectionColor(new java.awt.Color(204, 204, 255));
        txt_user.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_userKeyPressed(evt);
            }
        });

        txt_fname.setFont(new java.awt.Font("Miriam", 0, 20)); // NOI18N
        txt_fname.setForeground(new java.awt.Color(0, 51, 153));
        txt_fname.setPreferredSize(new java.awt.Dimension(299, 28));
        txt_fname.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        txt_fname.setSelectionColor(new java.awt.Color(204, 204, 255));
        txt_fname.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_fnameMousePressed(evt);
            }
        });
        txt_fname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_fnameKeyPressed(evt);
            }
        });

        txt_lname.setFont(new java.awt.Font("Miriam", 0, 20)); // NOI18N
        txt_lname.setForeground(new java.awt.Color(0, 51, 153));
        txt_lname.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        txt_lname.setSelectionColor(new java.awt.Color(204, 204, 255));
        txt_lname.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_lnameMousePressed(evt);
            }
        });
        txt_lname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_lnameActionPerformed(evt);
            }
        });
        txt_lname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_lnameKeyPressed(evt);
            }
        });

        txt_job.setFont(new java.awt.Font("Miriam", 0, 20)); // NOI18N
        txt_job.setForeground(new java.awt.Color(0, 51, 153));
        txt_job.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        txt_job.setSelectionColor(new java.awt.Color(204, 204, 255));
        txt_job.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_jobMousePressed(evt);
            }
        });
        txt_job.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_jobKeyPressed(evt);
            }
        });

        txt_pass.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        txt_pass.setForeground(new java.awt.Color(0, 51, 153));
        txt_pass.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        txt_pass.setSelectionColor(new java.awt.Color(204, 204, 255));
        txt_pass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_passMousePressed(evt);
            }
        });
        txt_pass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_passActionPerformed(evt);
            }
        });
        txt_pass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_passKeyPressed(evt);
            }
        });

        txt_conPass.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        txt_conPass.setForeground(new java.awt.Color(0, 51, 153));
        txt_conPass.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        txt_conPass.setSelectionColor(new java.awt.Color(204, 204, 255));
        txt_conPass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_conPassMousePressed(evt);
            }
        });
        txt_conPass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_conPassKeyPressed(evt);
            }
        });

        btn_sign_up.setFont(new java.awt.Font("Miriam", 0, 20)); // NOI18N
        btn_sign_up.setText("Sign - Up");
        btn_sign_up.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sign_upActionPerformed(evt);
            }
        });
        btn_sign_up.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btn_sign_upKeyPressed(evt);
            }
        });

        btn_check.setFont(new java.awt.Font("Miriam", 0, 20)); // NOI18N
        btn_check.setText("Check");
        btn_check.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_checkMousePressed(evt);
            }
        });
        btn_check.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_checkActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout main_panLayout = new javax.swing.GroupLayout(main_pan);
        main_pan.setLayout(main_panLayout);
        main_panLayout.setHorizontalGroup(
            main_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(main_panLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(main_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, main_panLayout.createSequentialGroup()
                        .addGroup(main_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(main_panLayout.createSequentialGroup()
                                .addGroup(main_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_user)
                                    .addComponent(lbl_pass)
                                    .addComponent(lbl_fname))
                                .addGap(161, 161, 161)
                                .addComponent(lbl_lname)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(main_panLayout.createSequentialGroup()
                                .addGroup(main_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lbl_job, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_conPass, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(main_panLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(main_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_job, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txt_conPass)
                                    .addComponent(txt_pass)
                                    .addComponent(txt_user)
                                    .addGroup(main_panLayout.createSequentialGroup()
                                        .addComponent(txt_fname, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txt_lname)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addGap(13, 13, 13))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, main_panLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lbl_head)
                        .addGap(32, 32, 32))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, main_panLayout.createSequentialGroup()
                        .addComponent(btn_check, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_sign_up, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        main_panLayout.setVerticalGroup(
            main_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(main_panLayout.createSequentialGroup()
                .addGroup(main_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(main_panLayout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(jLabel1))
                    .addGroup(main_panLayout.createSequentialGroup()
                        .addComponent(lbl_head)
                        .addGap(17, 17, 17)
                        .addComponent(lbl_user)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_user, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_pass)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_pass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_conPass)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_conPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(main_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_fname)
                            .addComponent(lbl_lname))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(main_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_lname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_fname, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_job)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_job, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(main_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_sign_up)
                    .addComponent(btn_check))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        btn_sign_up.setVisible(false);

        javax.swing.GroupLayout bg_panLayout = new javax.swing.GroupLayout(bg_pan);
        bg_pan.setLayout(bg_panLayout);
        bg_panLayout.setHorizontalGroup(
            bg_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bg_panLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bg_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(header_pan, javax.swing.GroupLayout.PREFERRED_SIZE, 650, Short.MAX_VALUE)
                    .addComponent(main_pan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        bg_panLayout.setVerticalGroup(
            bg_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bg_panLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(header_pan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(main_pan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg_pan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(bg_pan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_userKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_userKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            if(txt_user.getText().isEmpty()){
                txt_user.requestFocus();
                lbl_user.setIcon(war);
                txt_user.setToolTipText("Enter Your Username");
            }
            else{
                try{
                    Connection connect = DriverManager.getConnection("jdbc:derby://192.168.0.202/partNumbering  " ,"Admin01","07032017");
                    PreparedStatement smt = connect.prepareStatement("SELECT * FROM ADMINS", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                    ResultSet resultset = smt.executeQuery();

                    while(resultset.next()){
                        String db_uname = resultset.getString("username");
                        
                        uAdmin.add(db_uname);
                    }
                    smt.closeOnCompletion();
                    resultset.close();
                    connect.close();
                }
                catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
                
                for(int i = 0; i < uAdmin.size(); i++){
                    AdminArray = uAdmin.toArray(new String[i]);
                }
                
                try{
                    Connection connect1 = DriverManager.getConnection("jdbc:derby://192.168.0.202/partNumbering  " ,"Admin01","07032017");
                    PreparedStatement smt1 = connect1.prepareStatement("SELECT * FROM EMPLOYEE", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                    ResultSet resultset1 = smt1.executeQuery();

                    while(resultset1.next()){
                        String uname = resultset1.getString("username");
                        
                        uUser.add(uname);
                    }
                    smt1.closeOnCompletion();
                    resultset1.close();
                    connect1.close();
                }
                catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
                
                for(int i = 0; i < uUser.size(); i++){
                    UserArray = uUser.toArray(new String[i]);
                }
                
                String condAdmin = "ok";
                String condUser = "ok";
                
                for(int i = 0; i < uAdmin.size(); i++){
                    String temp = AdminArray[i];
                    if(txt_user.getText().matches(temp)){
                        txt_user.requestFocus();
                        lbl_user.setIcon(err);
                        txt_user.setToolTipText("Similar Username. Try Again");
                        condAdmin = "no";
                    }
                }
                
                for(int i = 0; i < uUser.size(); i++){
                    String temp = UserArray[i];
                    if(txt_user.getText().matches(temp)){
                        txt_user.requestFocus();
                        lbl_user.setIcon(err);
                        txt_user.setToolTipText("Similar Username. Try Again");
                        condAdmin = "no";
                    }
                }
                
                if(condAdmin == "ok" && condUser == "ok"){
                    txt_pass.requestFocus();
                    lbl_user.setIcon(che);
                    mesUser = "ok";
                }
            }
        }   
    }//GEN-LAST:event_txt_userKeyPressed

    private void txt_passActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_passActionPerformed

    }//GEN-LAST:event_txt_passActionPerformed

    private void txt_passKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_passKeyPressed
        String passSize = txt_pass.getText();
        
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            if(txt_user.getText().isEmpty()){
                txt_user.requestFocus();
                lbl_user.setIcon(war);
                txt_user.setToolTipText("Enter Your Username");
            }
            else if(txt_pass.getText().isEmpty()){
                txt_pass.requestFocus();
                lbl_pass.setIcon(war);
                txt_pass.setToolTipText("Enter Your Password");
            }
            else if(passSize.length() < 5){
                txt_pass.requestFocus();
                lbl_pass.setIcon(err);
                txt_pass.setToolTipText("Password must contain 5 letters or numbers!");
            }
            else{
                txt_conPass.requestFocus();
                lbl_pass.setIcon(che);
                mesPass = "ok";
            }
            try{
                    Connection connect = DriverManager.getConnection("jdbc:derby://192.168.0.202/partNumbering  " ,"Admin01","07032017");
                    PreparedStatement smt = connect.prepareStatement("SELECT * FROM ADMINS", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                    ResultSet resultset = smt.executeQuery();

                    while(resultset.next()){
                        String db_uname = resultset.getString("username");
                        
                        uAdmin.add(db_uname);
                    }
                    smt.closeOnCompletion();
                    resultset.close();
                    connect.close();
                }
                catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
                
                for(int i = 0; i < uAdmin.size(); i++){
                    AdminArray = uAdmin.toArray(new String[i]);
                }
                
                try{
                    Connection connect1 = DriverManager.getConnection("jdbc:derby://192.168.0.202/partNumbering  " ,"Admin01","07032017");
                    PreparedStatement smt1 = connect1.prepareStatement("SELECT * FROM EMPLOYEE", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                    ResultSet resultset1 = smt1.executeQuery();

                    while(resultset1.next()){
                        String uname = resultset1.getString("username");
                        
                        uUser.add(uname);
                    }
                    smt1.closeOnCompletion();
                    resultset1.close();
                    connect1.close();
                }
                catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
                
                for(int i = 0; i < uUser.size(); i++){
                    UserArray = uUser.toArray(new String[i]);
                }
                
                String condAdmin = "ok";
                String condUser = "ok";
                
                for(int i = 0; i < uAdmin.size(); i++){
                    String temp = AdminArray[i];
                    if(txt_user.getText().matches(temp)){
                        txt_user.requestFocus();
                        lbl_user.setIcon(err);
                        txt_user.setToolTipText("Similar Username. Try Again");
                        condAdmin = "no";
                    }
                }
                
                for(int i = 0; i < uUser.size(); i++){
                    String temp = UserArray[i];
                    if(txt_user.getText().matches(temp)){
                        txt_user.requestFocus();
                        lbl_user.setIcon(err);
                        txt_user.setToolTipText("Similar Username. Try Again");
                        condAdmin = "no";
                    }
                }
                
                if(condAdmin == "ok" && condUser == "ok"){
                    lbl_user.setIcon(che);
                    mesUser = "ok";
                }
        } 
    }//GEN-LAST:event_txt_passKeyPressed

    private void txt_conPassKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_conPassKeyPressed
        String passSize = txt_pass.getText();
        String conPassSize = txt_conPass.getText();
        
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            
            if(txt_user.getText().isEmpty()){
                txt_user.requestFocus();
                lbl_user.setIcon(war);
                txt_user.setToolTipText("Enter Your Username");
            }
            else if(txt_pass.getText().isEmpty()){
                txt_pass.requestFocus();
                lbl_pass.setIcon(war);
                txt_pass.setToolTipText("Enter Your Password");
            }
            else if(passSize.length() < 5){
                txt_pass.requestFocus();
                lbl_pass.setIcon(err);
                txt_pass.setToolTipText("Password must contain 5 letters or numbers!");
            }
            else if(txt_conPass.getText().isEmpty()){
                txt_conPass.requestFocus();
                lbl_conPass.setIcon(war);
                txt_conPass.setToolTipText("Re-enter Your Password");
            }
            else if(conPassSize.length() < 5){
                txt_conPass.requestFocus();
                lbl_conPass.setIcon(err);
                txt_conPass.setToolTipText("Password must contain 5 letters or numbers!");
            }
            else if(!txt_conPass.getText().equals(txt_pass.getText())){
                txt_pass.requestFocus();
                lbl_conPass.setIcon(err);
                lbl_pass.setIcon(err);
                txt_conPass.setToolTipText("Password Do Not Match");
                txt_pass.setToolTipText("Password Do Not Match");
            }
            else{
                txt_fname.requestFocus();
                lbl_conPass.setIcon(che);
                mesConPass = "ok";
            }
            try{
                    Connection connect = DriverManager.getConnection("jdbc:derby://192.168.0.202/partNumbering  " ,"Admin01","07032017");
                    PreparedStatement smt = connect.prepareStatement("SELECT * FROM ADMINS", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                    ResultSet resultset = smt.executeQuery();

                    while(resultset.next()){
                        String db_uname = resultset.getString("username");
                        
                        uAdmin.add(db_uname);
                    }
                    smt.closeOnCompletion();
                    resultset.close();
                    connect.close();
                }
                catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
                
                for(int i = 0; i < uAdmin.size(); i++){
                    AdminArray = uAdmin.toArray(new String[i]);
                }
                
                try{
                    Connection connect1 = DriverManager.getConnection("jdbc:derby://192.168.0.202/partNumbering  " ,"Admin01","07032017");
                    PreparedStatement smt1 = connect1.prepareStatement("SELECT * FROM EMPLOYEE", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                    ResultSet resultset1 = smt1.executeQuery();

                    while(resultset1.next()){
                        String uname = resultset1.getString("username");
                        
                        uUser.add(uname);
                    }
                    smt1.closeOnCompletion();
                    resultset1.close();
                    connect1.close();
                }
                catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
                
                for(int i = 0; i < uUser.size(); i++){
                    UserArray = uUser.toArray(new String[i]);
                }
                
                String condAdmin = "ok";
                String condUser = "ok";
                
                for(int i = 0; i < uAdmin.size(); i++){
                    String temp = AdminArray[i];
                    if(txt_user.getText().matches(temp)){
                        txt_user.requestFocus();
                        lbl_user.setIcon(err);
                        txt_user.setToolTipText("Similar Username. Try Again");
                        condAdmin = "no";
                    }
                }
                
                for(int i = 0; i < uUser.size(); i++){
                    String temp = UserArray[i];
                    if(txt_user.getText().matches(temp)){
                        txt_user.requestFocus();
                        lbl_user.setIcon(err);
                        txt_user.setToolTipText("Similar Username. Try Again");
                        condAdmin = "no";
                    }
                }
                
                if(condAdmin == "ok" && condUser == "ok"){
                    lbl_user.setIcon(che);
                    mesUser = "ok";
                }
        } 
    }//GEN-LAST:event_txt_conPassKeyPressed

    private void txt_lnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_lnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_lnameActionPerformed

    private void btn_sign_upActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sign_upActionPerformed
        try{
                conn = DriverManager.getConnection("jdbc:derby://192.168.0.202/partNumbering  ", "Admin01", "07032017");
                stmnt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                String querySql = "SELECT * FROM EMPLOYEE";
                reSet = stmnt.executeQuery(querySql);

                reSet.next();

                reSet.moveToInsertRow();

                reSet.updateString("username", txt_user.getText());
                reSet.updateString("password", txt_conPass.getText());
                reSet.updateString("first_name", txt_fname.getText());
                reSet.updateString("last_name", txt_lname.getText());
                reSet.updateString("job_title", txt_job.getText());

                reSet.insertRow();
                reSet.moveToCurrentRow();
            }
            catch(Exception ex){
                System.out.println(ex.getMessage());
            }
            finally {
                if (reSet != null) {
                    try {
                        reSet.close();
                    } catch (SQLException e) { /* ignored */}
                }
                if (stmnt != null) {
                    try {
                        stmnt.close();
                    } catch (SQLException e) { /* ignored */}
                }
                if (conn != null) {
                    try {
                        conn.close();
                    } catch (SQLException e) { /* ignored */}
                }
        }
        
        JLabel result = new JLabel("You can now log-in to use the generator!");
        result.setFont(new Font("Monospaced", Font.BOLD, 15));
        JOptionPane.showMessageDialog( null, result, "Account Created!", JOptionPane.INFORMATION_MESSAGE );
        
        this.setVisible(false);
    }//GEN-LAST:event_btn_sign_upActionPerformed

    private void txt_fnameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_fnameKeyPressed
        String passSize = txt_pass.getText();
        String conPassSize = txt_pass.getText();
        
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            if(txt_user.getText().isEmpty()){
                txt_user.requestFocus();
                lbl_user.setIcon(war);
                txt_user.setToolTipText("Enter Your Username");
            }
            else if(txt_pass.getText().isEmpty()){
                txt_pass.requestFocus();
                lbl_pass.setIcon(war);
                txt_pass.setToolTipText("Enter Your Password");
            }
            else if(passSize.length() < 5){
                txt_pass.requestFocus();
                lbl_pass.setIcon(err);
                txt_pass.setToolTipText("Password must contain 5 letters or numbers!");
            }
            else if(txt_conPass.getText().isEmpty()){
                txt_conPass.requestFocus();
                lbl_conPass.setIcon(war);
                txt_conPass.setToolTipText("Re-enter Your Password");
            }
            else if(conPassSize.length() < 5){
                txt_conPass.requestFocus();
                lbl_conPass.setIcon(err);
                txt_conPass.setToolTipText("Password must contain 5 letters or numbers!");
            }
            else if(!txt_conPass.getText().equals(txt_pass.getText())){
                txt_pass.requestFocus();
                lbl_conPass.setIcon(err);
                lbl_pass.setIcon(err);
                txt_conPass.setToolTipText("Password Do Not Match");
                txt_pass.setToolTipText("Password Do Not Match");
            }
            else if(txt_fname.getText().isEmpty()){
                txt_fname.requestFocus();
                lbl_fname.setIcon(war);
                txt_fname.setToolTipText("Enter Your First Name");
            }
            else{
                txt_lname.requestFocus();
                lbl_fname.setIcon(che);
                mesFname = "ok";
            }
            try{
                    Connection connect = DriverManager.getConnection("jdbc:derby://192.168.0.202/partNumbering  " ,"Admin01","07032017");
                    PreparedStatement smt = connect.prepareStatement("SELECT * FROM ADMINS", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                    ResultSet resultset = smt.executeQuery();

                    while(resultset.next()){
                        String db_uname = resultset.getString("username");
                        
                        uAdmin.add(db_uname);
                    }
                    smt.closeOnCompletion();
                    resultset.close();
                    connect.close();
                }
                catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
                
                for(int i = 0; i < uAdmin.size(); i++){
                    AdminArray = uAdmin.toArray(new String[i]);
                }
                
                try{
                    Connection connect1 = DriverManager.getConnection("jdbc:derby://192.168.0.202/partNumbering  " ,"Admin01","07032017");
                    PreparedStatement smt1 = connect1.prepareStatement("SELECT * FROM EMPLOYEE", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                    ResultSet resultset1 = smt1.executeQuery();

                    while(resultset1.next()){
                        String uname = resultset1.getString("username");
                        
                        uUser.add(uname);
                    }
                    smt1.closeOnCompletion();
                    resultset1.close();
                    connect1.close();
                }
                catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
                
                for(int i = 0; i < uUser.size(); i++){
                    UserArray = uUser.toArray(new String[i]);
                }
                
                String condAdmin = "ok";
                String condUser = "ok";
                
                for(int i = 0; i < uAdmin.size(); i++){
                    String temp = AdminArray[i];
                    if(txt_user.getText().matches(temp)){
                        txt_user.requestFocus();
                        lbl_user.setIcon(err);
                        txt_user.setToolTipText("Similar Username. Try Again");
                        condAdmin = "no";
                    }
                }
                
                for(int i = 0; i < uUser.size(); i++){
                    String temp = UserArray[i];
                    if(txt_user.getText().matches(temp)){
                        txt_user.requestFocus();
                        lbl_user.setIcon(err);
                        txt_user.setToolTipText("Similar Username. Try Again");
                        condAdmin = "no";
                    }
                }
                
                if(condAdmin == "ok" && condUser == "ok"){
                    lbl_user.setIcon(che);
                    mesUser = "ok";
                }
        } 
    }//GEN-LAST:event_txt_fnameKeyPressed

    private void txt_lnameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_lnameKeyPressed
        String passSize = txt_pass.getText();
        String conPassSize = txt_pass.getText();
        
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            if(txt_user.getText().isEmpty()){
                txt_user.requestFocus();
                lbl_user.setIcon(war);
                txt_user.setToolTipText("Enter Your Username");
            }
            else if(txt_pass.getText().isEmpty()){
                txt_pass.requestFocus();
                lbl_pass.setIcon(war);
                txt_pass.setToolTipText("Enter Your Password");
            }
            else if(passSize.length() < 5){
                txt_pass.requestFocus();
                lbl_pass.setIcon(err);
                txt_pass.setToolTipText("Password must contain 5 letters or numbers!");
            }
            else if(txt_conPass.getText().isEmpty()){
                txt_conPass.requestFocus();
                lbl_conPass.setIcon(war);
                txt_conPass.setToolTipText("Re-enter Your Password");
            }
            else if(conPassSize.length() < 5){
                txt_conPass.requestFocus();
                lbl_conPass.setIcon(err);
                txt_conPass.setToolTipText("Password must contain 5 letters or numbers!");
            }
            else if(!txt_conPass.getText().equals(txt_pass.getText())){
                txt_pass.requestFocus();
                lbl_conPass.setIcon(err);
                lbl_pass.setIcon(err);
                txt_conPass.setToolTipText("Password Do Not Match");
                txt_pass.setToolTipText("Password Do Not Match");
            }
            else if(txt_fname.getText().isEmpty()){
                txt_fname.requestFocus();
                lbl_fname.setIcon(war);
                txt_fname.setToolTipText("Enter Your First Name");
            }
            else if(txt_lname.getText().isEmpty()){
                txt_lname.requestFocus();
                lbl_lname.setIcon(war);
                txt_lname.setToolTipText("Enter Your Last Name");
            }
            else{
                txt_job.requestFocus();
                lbl_lname.setIcon(che);
                mesLname = "ok";
            }
            try{
                    Connection connect = DriverManager.getConnection("jdbc:derby://192.168.0.202/partNumbering  " ,"Admin01","07032017");
                    PreparedStatement smt = connect.prepareStatement("SELECT * FROM ADMINS", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                    ResultSet resultset = smt.executeQuery();

                    while(resultset.next()){
                        String db_uname = resultset.getString("username");
                        
                        uAdmin.add(db_uname);
                    }
                    smt.closeOnCompletion();
                    resultset.close();
                    connect.close();
                }
                catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
                
                for(int i = 0; i < uAdmin.size(); i++){
                    AdminArray = uAdmin.toArray(new String[i]);
                }
                
                try{
                    Connection connect1 = DriverManager.getConnection("jdbc:derby://192.168.0.202/partNumbering  " ,"Admin01","07032017");
                    PreparedStatement smt1 = connect1.prepareStatement("SELECT * FROM EMPLOYEE", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                    ResultSet resultset1 = smt1.executeQuery();

                    while(resultset1.next()){
                        String uname = resultset1.getString("username");
                        
                        uUser.add(uname);
                    }
                    smt1.closeOnCompletion();
                    resultset1.close();
                    connect1.close();
                }
                catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
                
                for(int i = 0; i < uUser.size(); i++){
                    UserArray = uUser.toArray(new String[i]);
                }
                
                String condAdmin = "ok";
                String condUser = "ok";
                
                for(int i = 0; i < uAdmin.size(); i++){
                    String temp = AdminArray[i];
                    if(txt_user.getText().matches(temp)){
                        txt_user.requestFocus();
                        lbl_user.setIcon(err);
                        txt_user.setToolTipText("Similar Username. Try Again");
                        condAdmin = "no";
                    }
                }
                
                for(int i = 0; i < uUser.size(); i++){
                    String temp = UserArray[i];
                    if(txt_user.getText().matches(temp)){
                        txt_user.requestFocus();
                        lbl_user.setIcon(err);
                        txt_user.setToolTipText("Similar Username. Try Again");
                        condAdmin = "no";
                    }
                }
                
                if(condAdmin == "ok" && condUser == "ok"){
                    lbl_user.setIcon(che);
                    mesUser = "ok";
                }
        } 
    }//GEN-LAST:event_txt_lnameKeyPressed

    private void txt_jobKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_jobKeyPressed
        String passSize = txt_pass.getText();
        String conPassSize = txt_pass.getText();
        
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            
            if(txt_user.getText().isEmpty()){
                txt_user.requestFocus();
                lbl_user.setIcon(war);
                txt_user.setToolTipText("Enter Your Username");
            }
            else if(txt_pass.getText().isEmpty()){
                txt_pass.requestFocus();
                lbl_pass.setIcon(war);
                txt_pass.setToolTipText("Enter Your Password");
            }
            else if(passSize.length() < 5){
                txt_pass.requestFocus();
                lbl_pass.setIcon(err);
                txt_pass.setToolTipText("Password must contain 5 letters or numbers!");
            }
            else if(txt_conPass.getText().isEmpty()){
                txt_conPass.requestFocus();
                lbl_conPass.setIcon(war);
                txt_conPass.setToolTipText("Re-enter Your Password");
            }
            else if(conPassSize.length() < 5){
                txt_conPass.requestFocus();
                lbl_conPass.setIcon(err);
                txt_conPass.setToolTipText("Password must contain 5 letters or numbers!");
            }
            else if(!txt_conPass.getText().equals(txt_pass.getText())){
                txt_pass.requestFocus();
                lbl_conPass.setIcon(err);
                lbl_pass.setIcon(err);
                txt_conPass.setToolTipText("Password Do Not Match");
                txt_pass.setToolTipText("Password Do Not Match");
            }
            else if(txt_fname.getText().isEmpty()){
                txt_fname.requestFocus();
                lbl_fname.setIcon(war);
                txt_fname.setToolTipText("Enter Your First Name");
            }
            else if(txt_lname.getText().isEmpty()){
                txt_lname.requestFocus();
                lbl_lname.setIcon(war);
                txt_lname.setToolTipText("Enter Your Last Name");
            }
            else if(txt_job.getText().isEmpty()){
                txt_job.requestFocus();
                lbl_job.setIcon(war);
                txt_job.setToolTipText("Enter Your Job Position");
            }
            else{
                mesJob = "ok";
                btn_check.doClick();
                lbl_job.setIcon(che);
            }
            try{
                    Connection connect = DriverManager.getConnection("jdbc:derby://192.168.0.202/partNumbering  " ,"Admin01","07032017");
                    PreparedStatement smt = connect.prepareStatement("SELECT * FROM ADMINS", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                    ResultSet resultset = smt.executeQuery();

                    while(resultset.next()){
                        String db_uname = resultset.getString("username");
                        
                        uAdmin.add(db_uname);
                    }
                    smt.closeOnCompletion();
                    resultset.close();
                    connect.close();
                }
                catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
                
                for(int i = 0; i < uAdmin.size(); i++){
                    AdminArray = uAdmin.toArray(new String[i]);
                }
                
                try{
                    Connection connect1 = DriverManager.getConnection("jdbc:derby://192.168.0.202/partNumbering  " ,"Admin01","07032017");
                    PreparedStatement smt1 = connect1.prepareStatement("SELECT * FROM EMPLOYEE", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                    ResultSet resultset1 = smt1.executeQuery();

                    while(resultset1.next()){
                        String uname = resultset1.getString("username");
                        
                        uUser.add(uname);
                    }
                    smt1.closeOnCompletion();
                    resultset1.close();
                    connect1.close();
                }
                catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
                
                for(int i = 0; i < uUser.size(); i++){
                    UserArray = uUser.toArray(new String[i]);
                }
                
                String condAdmin = "ok";
                String condUser = "ok";
                
                for(int i = 0; i < uAdmin.size(); i++){
                    String temp = AdminArray[i];
                    if(txt_user.getText().matches(temp)){
                        txt_user.requestFocus();
                        lbl_user.setIcon(err);
                        txt_user.setToolTipText("Similar Username. Try Again");
                        condAdmin = "no";
                    }
                }
                
                for(int i = 0; i < uUser.size(); i++){
                    String temp = UserArray[i];
                    if(txt_user.getText().matches(temp)){
                        txt_user.requestFocus();
                        lbl_user.setIcon(err);
                        txt_user.setToolTipText("Similar Username. Try Again");
                        condAdmin = "no";
                    }
                }
                
                if(condAdmin == "ok" && condUser == "ok"){
                    lbl_user.setIcon(che);
                    mesUser = "ok";
                }
        } 
    }//GEN-LAST:event_txt_jobKeyPressed

    private void txt_passMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_passMousePressed

            if(txt_user.getText().isEmpty()){
                txt_user.requestFocus();
                lbl_user.setIcon(war);
                txt_user.setToolTipText("Enter Your Username");
            }
            else{
                try{
                    Connection connect = DriverManager.getConnection("jdbc:derby://192.168.0.202/partNumbering  " ,"Admin01","07032017");
                    PreparedStatement smt = connect.prepareStatement("SELECT * FROM ADMINS", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                    ResultSet resultset = smt.executeQuery();

                    while(resultset.next()){
                        String db_uname = resultset.getString("username");
                        
                        uAdmin.add(db_uname);
                    }
                    smt.closeOnCompletion();
                    resultset.close();
                    connect.close();
                }
                catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
                
                for(int i = 0; i < uAdmin.size(); i++){
                    AdminArray = uAdmin.toArray(new String[i]);
                }
                
                try{
                    Connection connect1 = DriverManager.getConnection("jdbc:derby://192.168.0.202/partNumbering  " ,"Admin01","07032017");
                    PreparedStatement smt1 = connect1.prepareStatement("SELECT * FROM EMPLOYEE", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                    ResultSet resultset1 = smt1.executeQuery();

                    while(resultset1.next()){
                        String uname = resultset1.getString("username");
                        
                        uUser.add(uname);
                    }
                    smt1.closeOnCompletion();
                    resultset1.close();
                    connect1.close();
                }
                catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
                
                for(int i = 0; i < uUser.size(); i++){
                    UserArray = uUser.toArray(new String[i]);
                }
                
                String condAdmin = "ok";
                String condUser = "ok";
                
                for(int i = 0; i < uAdmin.size(); i++){
                    String temp = AdminArray[i];
                    if(txt_user.getText().matches(temp)){
                        txt_user.requestFocus();
                        lbl_user.setIcon(err);
                        txt_user.setToolTipText("Similar Username. Try Again");
                        condAdmin = "no";
                    }
                }
                
                for(int i = 0; i < uUser.size(); i++){
                    String temp = UserArray[i];
                    if(txt_user.getText().matches(temp)){
                        txt_user.requestFocus();
                        lbl_user.setIcon(err);
                        txt_user.setToolTipText("Similar Username. Try Again");
                        condAdmin = "no";
                    }
                }
                
                if(condAdmin == "ok" && condUser == "ok"){
                    lbl_user.setIcon(che);
                    mesUser = "ok";
                }
            }
            
 
    }//GEN-LAST:event_txt_passMousePressed

    private void txt_conPassMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_conPassMousePressed
        String passSize = txt_pass.getText();
        
        if(txt_user.getText().isEmpty()){
                txt_user.requestFocus();
                lbl_user.setIcon(war);
                txt_user.setToolTipText("Enter Your Username");
            }
            else if(txt_pass.getText().isEmpty()){
                txt_pass.requestFocus();
                lbl_pass.setIcon(war);
                txt_pass.setToolTipText("Enter Your Password");
            }
            else if(passSize.length() < 5){
                txt_pass.requestFocus();
                lbl_pass.setIcon(err);
                txt_pass.setToolTipText("Password must contain 5 letters or numbers!");
            }
            else{
                txt_conPass.requestFocus();
                lbl_pass.setIcon(che);
            }
        try{
                    Connection connect = DriverManager.getConnection("jdbc:derby://192.168.0.202/partNumbering  " ,"Admin01","07032017");
                    PreparedStatement smt = connect.prepareStatement("SELECT * FROM ADMINS", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                    ResultSet resultset = smt.executeQuery();

                    while(resultset.next()){
                        String db_uname = resultset.getString("username");
                        
                        uAdmin.add(db_uname);
                    }
                    smt.closeOnCompletion();
                    resultset.close();
                    connect.close();
                }
                catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
                
                for(int i = 0; i < uAdmin.size(); i++){
                    AdminArray = uAdmin.toArray(new String[i]);
                }
                
                try{
                    Connection connect1 = DriverManager.getConnection("jdbc:derby://192.168.0.202/partNumbering  " ,"Admin01","07032017");
                    PreparedStatement smt1 = connect1.prepareStatement("SELECT * FROM EMPLOYEE", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                    ResultSet resultset1 = smt1.executeQuery();

                    while(resultset1.next()){
                        String uname = resultset1.getString("username");
                        
                        uUser.add(uname);
                    }
                    smt1.closeOnCompletion();
                    resultset1.close();
                    connect1.close();
                }
                catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
                
                for(int i = 0; i < uUser.size(); i++){
                    UserArray = uUser.toArray(new String[i]);
                }
                
                String condAdmin = "ok";
                String condUser = "ok";
                
                for(int i = 0; i < uAdmin.size(); i++){
                    String temp = AdminArray[i];
                    if(txt_user.getText().matches(temp)){
                        txt_user.requestFocus();
                        lbl_user.setIcon(err);
                        txt_user.setToolTipText("Similar Username. Try Again");
                        condAdmin = "no";
                    }
                }
                
                for(int i = 0; i < uUser.size(); i++){
                    String temp = UserArray[i];
                    if(txt_user.getText().matches(temp)){
                        txt_user.requestFocus();
                        lbl_user.setIcon(err);
                        txt_user.setToolTipText("Similar Username. Try Again");
                        condAdmin = "no";
                    }
                }
                
                if(condAdmin == "ok" && condUser == "ok"){
                    lbl_user.setIcon(che);
                    mesUser = "ok";
                }
    }//GEN-LAST:event_txt_conPassMousePressed

    private void txt_fnameMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_fnameMousePressed
        String passSize = txt_pass.getText();
        String conPassSize = txt_pass.getText();
        
        if(txt_user.getText().isEmpty()){
                txt_user.requestFocus();
                lbl_user.setIcon(war);
                txt_user.setToolTipText("Enter Your Username");
            }
            else if(txt_pass.getText().isEmpty()){
                txt_pass.requestFocus();
                lbl_pass.setIcon(war);
                txt_pass.setToolTipText("Enter Your Password");
            }
            else if(passSize.length() < 5){
                txt_pass.requestFocus();
                lbl_pass.setIcon(err);
                txt_pass.setToolTipText("Password must contain 5 letters or numbers!");
            }
            else if(txt_conPass.getText().isEmpty()){
                txt_conPass.requestFocus();
                lbl_conPass.setIcon(war);
                txt_conPass.setToolTipText("Re-enter Your Password");
            }
            else if(conPassSize.length() < 5){
                txt_conPass.requestFocus();
                lbl_conPass.setIcon(err);
                txt_conPass.setToolTipText("Password must contain 5 letters or numbers!");
            }
            else if(!txt_conPass.getText().equals(txt_pass.getText())){
                txt_pass.requestFocus();
                lbl_conPass.setIcon(err);
                lbl_pass.setIcon(err);
                txt_conPass.setToolTipText("Password Do Not Match");
                txt_pass.setToolTipText("Password Do Not Match");
            }
            else{
                txt_fname.requestFocus();
                lbl_conPass.setIcon(che);
            }
        try{
                    Connection connect = DriverManager.getConnection("jdbc:derby://192.168.0.202/partNumbering  " ,"Admin01","07032017");
                    PreparedStatement smt = connect.prepareStatement("SELECT * FROM ADMINS", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                    ResultSet resultset = smt.executeQuery();

                    while(resultset.next()){
                        String db_uname = resultset.getString("username");
                        
                        uAdmin.add(db_uname);
                    }
                    smt.closeOnCompletion();
                    resultset.close();
                    connect.close();
                }
                catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
                
                for(int i = 0; i < uAdmin.size(); i++){
                    AdminArray = uAdmin.toArray(new String[i]);
                }
                
                try{
                    Connection connect1 = DriverManager.getConnection("jdbc:derby://192.168.0.202/partNumbering  " ,"Admin01","07032017");
                    PreparedStatement smt1 = connect1.prepareStatement("SELECT * FROM EMPLOYEE", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                    ResultSet resultset1 = smt1.executeQuery();

                    while(resultset1.next()){
                        String uname = resultset1.getString("username");
                        
                        uUser.add(uname);
                    }
                    smt1.closeOnCompletion();
                    resultset1.close();
                    connect1.close();
                }
                catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
                
                for(int i = 0; i < uUser.size(); i++){
                    UserArray = uUser.toArray(new String[i]);
                }
                
                String condAdmin = "ok";
                String condUser = "ok";
                
                for(int i = 0; i < uAdmin.size(); i++){
                    String temp = AdminArray[i];
                    if(txt_user.getText().matches(temp)){
                        txt_user.requestFocus();
                        lbl_user.setIcon(err);
                        txt_user.setToolTipText("Similar Username. Try Again");
                        condAdmin = "no";
                    }
                }
                
                for(int i = 0; i < uUser.size(); i++){
                    String temp = UserArray[i];
                    if(txt_user.getText().matches(temp)){
                        txt_user.requestFocus();
                        lbl_user.setIcon(err);
                        txt_user.setToolTipText("Similar Username. Try Again");
                        condAdmin = "no";
                    }
                }
                
                if(condAdmin == "ok" && condUser == "ok"){
                    lbl_user.setIcon(che);
                    mesUser = "ok";
                }
    }//GEN-LAST:event_txt_fnameMousePressed

    private void txt_lnameMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_lnameMousePressed
        String passSize = txt_pass.getText();
        String conPassSize = txt_pass.getText();
        
            if(txt_user.getText().isEmpty()){
                txt_user.requestFocus();
                lbl_user.setIcon(war);
                txt_user.setToolTipText("Enter Your Username");
            }
            else if(txt_pass.getText().isEmpty()){
                txt_pass.requestFocus();
                lbl_pass.setIcon(war);
                txt_pass.setToolTipText("Enter Your Password");
            }
            else if(passSize.length() < 5){
                txt_pass.requestFocus();
                lbl_pass.setIcon(err);
                txt_pass.setToolTipText("Password must contain 5 letters or numbers!");
            }
            else if(txt_conPass.getText().isEmpty()){
                txt_conPass.requestFocus();
                lbl_conPass.setIcon(war);
                txt_conPass.setToolTipText("Re-enter Your Password");
            }
            else if(conPassSize.length() < 5){
                txt_conPass.requestFocus();
                lbl_conPass.setIcon(err);
                txt_conPass.setToolTipText("Password must contain 5 letters or numbers!");
            }
            else if(!txt_conPass.getText().equals(txt_pass.getText())){
                txt_pass.requestFocus();
                lbl_conPass.setIcon(err);
                lbl_pass.setIcon(err);
                txt_conPass.setToolTipText("Password Do Not Match");
                txt_pass.setToolTipText("Password Do Not Match");
            }
            else if(txt_fname.getText().isEmpty()){
                txt_fname.requestFocus();
                lbl_fname.setIcon(war);
                txt_fname.setToolTipText("Enter Your First Name");
            }
            else{
                txt_lname.requestFocus();
                lbl_fname.setIcon(che);
            }
        try{
                    Connection connect = DriverManager.getConnection("jdbc:derby://192.168.0.202/partNumbering  " ,"Admin01","07032017");
                    PreparedStatement smt = connect.prepareStatement("SELECT * FROM ADMINS", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                    ResultSet resultset = smt.executeQuery();

                    while(resultset.next()){
                        String db_uname = resultset.getString("username");
                        
                        uAdmin.add(db_uname);
                    }
                    smt.closeOnCompletion();
                    resultset.close();
                    connect.close();
                }
                catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
                
                for(int i = 0; i < uAdmin.size(); i++){
                    AdminArray = uAdmin.toArray(new String[i]);
                }
                
                try{
                    Connection connect1 = DriverManager.getConnection("jdbc:derby://192.168.0.202/partNumbering  " ,"Admin01","07032017");
                    PreparedStatement smt1 = connect1.prepareStatement("SELECT * FROM EMPLOYEE", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                    ResultSet resultset1 = smt1.executeQuery();

                    while(resultset1.next()){
                        String uname = resultset1.getString("username");
                        
                        uUser.add(uname);
                    }
                    smt1.closeOnCompletion();
                    resultset1.close();
                    connect1.close();
                }
                catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
                
                for(int i = 0; i < uUser.size(); i++){
                    UserArray = uUser.toArray(new String[i]);
                }
                
                String condAdmin = "ok";
                String condUser = "ok";
                
                for(int i = 0; i < uAdmin.size(); i++){
                    String temp = AdminArray[i];
                    if(txt_user.getText().matches(temp)){
                        txt_user.requestFocus();
                        lbl_user.setIcon(err);
                        txt_user.setToolTipText("Similar Username. Try Again");
                        condAdmin = "no";
                    }
                }
                
                for(int i = 0; i < uUser.size(); i++){
                    String temp = UserArray[i];
                    if(txt_user.getText().matches(temp)){
                        txt_user.requestFocus();
                        lbl_user.setIcon(err);
                        txt_user.setToolTipText("Similar Username. Try Again");
                        condAdmin = "no";
                    }
                }
                
                if(condAdmin == "ok" && condUser == "ok"){
                    lbl_user.setIcon(che);
                    mesUser = "ok";
                }
    }//GEN-LAST:event_txt_lnameMousePressed

    private void txt_jobMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_jobMousePressed
        String passSize = txt_pass.getText();
        String conPassSize = txt_pass.getText();
        
            if(txt_user.getText().isEmpty()){
                txt_user.requestFocus();
                lbl_user.setIcon(war);
                txt_user.setToolTipText("Enter Your Username");
            }
            else if(txt_pass.getText().isEmpty()){
                txt_pass.requestFocus();
                lbl_pass.setIcon(war);
                txt_pass.setToolTipText("Enter Your Password");
            }
            else if(passSize.length() < 5){
                txt_pass.requestFocus();
                lbl_pass.setIcon(err);
                txt_pass.setToolTipText("Password must contain 5 letters or numbers!");
            }
            else if(txt_conPass.getText().isEmpty()){
                txt_conPass.requestFocus();
                lbl_conPass.setIcon(war);
                txt_conPass.setToolTipText("Re-enter Your Password");
            }
            else if(conPassSize.length() < 5){
                txt_conPass.requestFocus();
                lbl_conPass.setIcon(err);
                txt_conPass.setToolTipText("Password must contain 5 letters or numbers!");
            }
            else if(!txt_conPass.getText().equals(txt_pass.getText())){
                txt_pass.requestFocus();
                lbl_conPass.setIcon(err);
                lbl_pass.setIcon(err);
                txt_conPass.setToolTipText("Password Do Not Match");
                txt_pass.setToolTipText("Password Do Not Match");
            }
            else if(txt_fname.getText().isEmpty()){
                txt_fname.requestFocus();
                lbl_fname.setIcon(war);
                txt_fname.setToolTipText("Enter Your First Name");
            }
            else if(txt_lname.getText().isEmpty()){
                txt_lname.requestFocus();
                lbl_lname.setIcon(war);
                txt_lname.setToolTipText("Enter Your Last Name");
            }
            else{
                txt_job.requestFocus();
                lbl_lname.setIcon(che);
            }
        try{
                    Connection connect = DriverManager.getConnection("jdbc:derby://192.168.0.202/partNumbering  " ,"Admin01","07032017");
                    PreparedStatement smt = connect.prepareStatement("SELECT * FROM ADMINS", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                    ResultSet resultset = smt.executeQuery();

                    while(resultset.next()){
                        String db_uname = resultset.getString("username");
                        
                        uAdmin.add(db_uname);
                    }
                    smt.closeOnCompletion();
                    resultset.close();
                    connect.close();
                }
                catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
                
                for(int i = 0; i < uAdmin.size(); i++){
                    AdminArray = uAdmin.toArray(new String[i]);
                }
                
                try{
                    Connection connect1 = DriverManager.getConnection("jdbc:derby://192.168.0.202/partNumbering  " ,"Admin01","07032017");
                    PreparedStatement smt1 = connect1.prepareStatement("SELECT * FROM EMPLOYEE", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                    ResultSet resultset1 = smt1.executeQuery();

                    while(resultset1.next()){
                        String uname = resultset1.getString("username");
                        
                        uUser.add(uname);
                    }
                    smt1.closeOnCompletion();
                    resultset1.close();
                    connect1.close();
                }
                catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
                
                for(int i = 0; i < uUser.size(); i++){
                    UserArray = uUser.toArray(new String[i]);
                }
                
                String condAdmin = "ok";
                String condUser = "ok";
                
                for(int i = 0; i < uAdmin.size(); i++){
                    String temp = AdminArray[i];
                    if(txt_user.getText().matches(temp)){
                        txt_user.requestFocus();
                        lbl_user.setIcon(err);
                        txt_user.setToolTipText("Similar Username. Try Again");
                        condAdmin = "no";
                    }
                }
                
                for(int i = 0; i < uUser.size(); i++){
                    String temp = UserArray[i];
                    if(txt_user.getText().matches(temp)){
                        txt_user.requestFocus();
                        lbl_user.setIcon(err);
                        txt_user.setToolTipText("Similar Username. Try Again");
                        condAdmin = "no";
                    }
                }
                
                if(condAdmin == "ok" && condUser == "ok"){
                    lbl_user.setIcon(che);
                    mesUser = "ok";
                }
    }//GEN-LAST:event_txt_jobMousePressed

    private void btn_checkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_checkActionPerformed
        if(mesJob.equals("ok") && mesUser.equals("ok") && mesPass.equals("ok") && mesConPass.equals("ok") && mesFname.equals("ok") && mesLname.equals("ok")){
                    btn_check.setVisible(false);
                    btn_sign_up.setVisible(true);
                    btn_sign_up.requestFocus();
                }
    }//GEN-LAST:event_btn_checkActionPerformed

    private void btn_checkMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_checkMousePressed
                
        String passSize = txt_pass.getText();
        String conPassSize = txt_pass.getText();
        
        if(!txt_user.getText().isEmpty()){
                try{
                    Connection connect = DriverManager.getConnection("jdbc:derby://192.168.0.202/partNumbering  " ,"Admin01","07032017");
                    PreparedStatement smt = connect.prepareStatement("SELECT * FROM ADMINS", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                    ResultSet resultset = smt.executeQuery();

                    while(resultset.next()){
                        String db_uname = resultset.getString("username");
                        
                        uAdmin.add(db_uname);
                    }
                    smt.closeOnCompletion();
                    resultset.close();
                    connect.close();
                }
                catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
                
                for(int i = 0; i < uAdmin.size(); i++){
                    AdminArray = uAdmin.toArray(new String[i]);
                }
                
                try{
                    Connection connect1 = DriverManager.getConnection("jdbc:derby://192.168.0.202/partNumbering  " ,"Admin01","07032017");
                    PreparedStatement smt1 = connect1.prepareStatement("SELECT * FROM EMPLOYEE", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                    ResultSet resultset1 = smt1.executeQuery();

                    while(resultset1.next()){
                        String uname = resultset1.getString("username");
                        
                        uUser.add(uname);
                    }
                    smt1.closeOnCompletion();
                    resultset1.close();
                    connect1.close();
                }
                catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
                
                for(int i = 0; i < uUser.size(); i++){
                    UserArray = uUser.toArray(new String[i]);
                }
                
                String condAdmin = "ok";
                String condUser = "ok";
                
                for(int i = 0; i < uAdmin.size(); i++){
                    String temp = AdminArray[i];
                    if(txt_user.getText().matches(temp)){
                        txt_user.requestFocus();
                        lbl_user.setIcon(err);
                        txt_user.setToolTipText("Similar Username. Try Again");
                        condAdmin = "no";
                    }
                }
                
                for(int i = 0; i < uUser.size(); i++){
                    String temp = UserArray[i];
                    if(txt_user.getText().matches(temp)){
                        txt_user.requestFocus();
                        lbl_user.setIcon(err);
                        txt_user.setToolTipText("Similar Username. Try Again");
                        condAdmin = "no";
                    }
                }
                if(condAdmin == "ok" && condUser == "ok"){
                    txt_pass.requestFocus();
                    lbl_user.setIcon(che);
                    mesUser = "ok";
                }
            }
            if(!txt_pass.getText().isEmpty()){
                if(passSize.length() < 5){
                    JLabel resLabel = new JLabel("All fields are required. \n\nPlease complete all the details!");
                    resLabel.setFont(new Font("Miriam", Font.BOLD, 15));
                    JOptionPane.showMessageDialog( this, resLabel, "Invalid", JOptionPane.ERROR_MESSAGE );
                    txt_pass.requestFocus();
                    lbl_pass.setIcon(err);
                    txt_pass.setToolTipText("Password must contain 5 letters or numbers!");
                }
                else{
                    txt_conPass.requestFocus();
                    lbl_pass.setIcon(che);
                    mesPass = "ok";
                }
            }
            if(!txt_conPass.getText().isEmpty()){
                if(conPassSize.length() < 5){
                    JLabel resLabel = new JLabel("All fields are required. \n\nPlease complete all the details!");
                    resLabel.setFont(new Font("Miriam", Font.BOLD, 15));
                    JOptionPane.showMessageDialog( this, resLabel, "Invalid", JOptionPane.ERROR_MESSAGE );
                    txt_conPass.requestFocus();
                    lbl_conPass.setIcon(err);
                    txt_conPass.setToolTipText("Password must contain 5 letters or numbers!");
                }
                else{
                    txt_fname.requestFocus();
                    lbl_conPass.setIcon(che);
                    mesConPass = "ok";
                }
            }
            if(!txt_conPass.getText().isEmpty()){
                if(conPassSize.length() < 5){
                    JLabel resLabel = new JLabel("All fields are required. \n\nPlease complete all the details!");
                    resLabel.setFont(new Font("Miriam", Font.BOLD, 15));
                    JOptionPane.showMessageDialog( this, resLabel, "Invalid", JOptionPane.ERROR_MESSAGE );
                    txt_conPass.requestFocus();
                    lbl_conPass.setIcon(err);
                    txt_conPass.setToolTipText("Password must contain 5 letters or numbers!");
                }
                else{
                    txt_fname.requestFocus();
                    lbl_conPass.setIcon(che);
                    mesConPass = "ok";
                }
            }
            if(!txt_fname.getText().isEmpty()){
                txt_lname.requestFocus();
                lbl_fname.setIcon(che);
                mesFname = "ok";
            }
            if(!txt_lname.getText().isEmpty()){
                txt_job.requestFocus();
                lbl_lname.setIcon(che);
                mesLname = "ok";
            }

//------------------------------------------------------------------------------------------------------------------------------------

            if(txt_user.getText().isEmpty()){
                JLabel resLabel = new JLabel("All fields are required. \n\nPlease complete all the details!");
                resLabel.setFont(new Font("Miriam", Font.BOLD, 15));
                JOptionPane.showMessageDialog( this, resLabel, "Invalid", JOptionPane.ERROR_MESSAGE );
                txt_user.requestFocus();
                lbl_user.setIcon(war);
                txt_user.setToolTipText("Enter Your Username");
            }
            else if(txt_pass.getText().isEmpty()){
                JLabel resLabel = new JLabel("All fields are required. \n\nPlease complete all the details!");
                resLabel.setFont(new Font("Miriam", Font.BOLD, 15));
                JOptionPane.showMessageDialog( this, resLabel, "Invalid", JOptionPane.ERROR_MESSAGE );
                txt_pass.requestFocus();
                lbl_pass.setIcon(war);
                txt_pass.setToolTipText("Enter Your Password");
            }
            else if(txt_conPass.getText().isEmpty()){
                JLabel resLabel = new JLabel("All fields are required. \n\nPlease complete all the details!");
                resLabel.setFont(new Font("Miriam", Font.BOLD, 15));
                JOptionPane.showMessageDialog( this, resLabel, "Invalid", JOptionPane.ERROR_MESSAGE );
                txt_conPass.requestFocus();
                lbl_conPass.setIcon(war);
                txt_conPass.setToolTipText("Re-enter Your Password");
            }
            else if(!txt_conPass.getText().equals(txt_pass.getText())){
                JLabel resLabel = new JLabel("All fields are required. \n\nPlease complete all the details!");
                resLabel.setFont(new Font("Miriam", Font.BOLD, 15));
                JOptionPane.showMessageDialog( this, resLabel, "Invalid", JOptionPane.ERROR_MESSAGE );
                txt_pass.requestFocus();
                lbl_conPass.setIcon(err);
                lbl_pass.setIcon(err);
                txt_conPass.setToolTipText("Password Do Not Match");
                txt_pass.setToolTipText("Password Do Not Match");
            }
            else if(txt_fname.getText().isEmpty()){
                JLabel resLabel = new JLabel("All fields are required. \n\nPlease complete all the details!");
                resLabel.setFont(new Font("Miriam", Font.BOLD, 15));
                JOptionPane.showMessageDialog( this, resLabel, "Invalid", JOptionPane.ERROR_MESSAGE );
                txt_fname.requestFocus();
                lbl_fname.setIcon(war);
                txt_fname.setToolTipText("Enter Your First Name");
            }
            else if(txt_lname.getText().isEmpty()){
                JLabel resLabel = new JLabel("All fields are required. \n\nPlease complete all the details!");
                resLabel.setFont(new Font("Miriam", Font.BOLD, 15));
                JOptionPane.showMessageDialog( this, resLabel, "Invalid", JOptionPane.ERROR_MESSAGE );
                txt_lname.requestFocus();
                lbl_lname.setIcon(war);
                txt_lname.setToolTipText("Enter Your Last Name");
            }
            else if(txt_job.getText().isEmpty()){
                txt_job.requestFocus();
                lbl_job.setIcon(war);
                txt_job.setToolTipText("Enter Your Job Position");
            }
            else if(!txt_job.getText().isEmpty()){
                mesJob = "ok";
                btn_check.doClick();
                lbl_job.setIcon(che);
                
                if(mesJob.equals("ok") && mesUser.equals("ok") && mesPass.equals("ok") && mesConPass.equals("ok") && mesFname.equals("ok") && mesLname.equals("ok")){
                    btn_check.setVisible(false);
                    btn_sign_up.setVisible(true);
                    btn_sign_up.requestFocus();
                }
            }
    }//GEN-LAST:event_btn_checkMousePressed

    private void btn_sign_upKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btn_sign_upKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            btn_sign_up.doClick();
        }
    }//GEN-LAST:event_btn_sign_upKeyPressed

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
            java.util.logging.Logger.getLogger(sign_up_frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(sign_up_frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(sign_up_frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(sign_up_frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new sign_up_frame().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg_pan;
    private javax.swing.JButton btn_check;
    private javax.swing.JButton btn_sign_up;
    private javax.swing.JPanel header_pan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lbl_conPass;
    private javax.swing.JLabel lbl_fname;
    private javax.swing.JLabel lbl_head;
    private javax.swing.JLabel lbl_icon;
    private javax.swing.JLabel lbl_job;
    private javax.swing.JLabel lbl_lname;
    private javax.swing.JLabel lbl_name;
    private javax.swing.JLabel lbl_name1;
    private javax.swing.JLabel lbl_pass;
    private javax.swing.JLabel lbl_user;
    private javax.swing.JPanel main_pan;
    private javax.swing.JPasswordField txt_conPass;
    private javax.swing.JTextField txt_fname;
    private javax.swing.JTextField txt_job;
    private javax.swing.JTextField txt_lname;
    private javax.swing.JPasswordField txt_pass;
    private javax.swing.JTextField txt_user;
    // End of variables declaration//GEN-END:variables
}
