package partNumbering_generator;

import java.awt.event.KeyEvent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.persistence.*;
import javax.swing.JOptionPane;

public class login_frame extends javax.swing.JFrame {

    String host = Host.getHost();
    
    public login_frame() {
        
        initComponents();
        
        lbl_host.setText("Host: " + host);
        
        setLocationRelativeTo(null);
        
        this.setIconImage(new ImageIcon(getClass().getResource("xepto logo - white bg - x.jpg")).getImage()); 
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg_pan = new javax.swing.JPanel();
        header_pan = new javax.swing.JPanel();
        lbl_icon = new javax.swing.JLabel();
        login_pan = new javax.swing.JPanel();
        lbl_username = new javax.swing.JLabel();
        lbl_password = new javax.swing.JLabel();
        txt_username = new javax.swing.JTextField();
        btn_enter = new javax.swing.JButton();
        txt_password = new javax.swing.JPasswordField();
        err_mes = new javax.swing.JLabel();
        acc_pan = new javax.swing.JPanel();
        btn_signup = new javax.swing.JButton();
        lbl_host = new javax.swing.JLabel();
        btn_changeHost = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Log-in - Part Number Generator");
        setPreferredSize(new java.awt.Dimension(500, 400));
        setResizable(false);

        bg_pan.setBackground(new java.awt.Color(204, 204, 255));
        bg_pan.setToolTipText("");

        header_pan.setBackground(new java.awt.Color(255, 255, 255));
        header_pan.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        lbl_icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/partNumbering_generator/xepto logo - white bg - login.jpg"))); // NOI18N

        javax.swing.GroupLayout header_panLayout = new javax.swing.GroupLayout(header_pan);
        header_pan.setLayout(header_panLayout);
        header_panLayout.setHorizontalGroup(
            header_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, header_panLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_icon, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(87, 87, 87))
        );
        header_panLayout.setVerticalGroup(
            header_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(header_panLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_icon)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        login_pan.setBackground(new java.awt.Color(204, 204, 204));
        login_pan.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "LOG-IN", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Miriam Fixed", 1, 20), new java.awt.Color(255, 255, 255))); // NOI18N

        lbl_username.setFont(new java.awt.Font("Miriam Fixed", 0, 20)); // NOI18N
        lbl_username.setText("Username : ");

        lbl_password.setFont(new java.awt.Font("Miriam Fixed", 0, 20)); // NOI18N
        lbl_password.setText("Password : ");

        txt_username.setFont(new java.awt.Font("Miriam Fixed", 0, 20)); // NOI18N
        txt_username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_usernameActionPerformed(evt);
            }
        });
        txt_username.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_usernameKeyPressed(evt);
            }
        });

        btn_enter.setBackground(new java.awt.Color(204, 204, 255));
        btn_enter.setFont(new java.awt.Font("Miriam", 0, 20)); // NOI18N
        btn_enter.setText("ENTER");
        btn_enter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_enterActionPerformed(evt);
            }
        });

        txt_password.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        txt_password.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_passwordKeyPressed(evt);
            }
        });

        err_mes.setFont(new java.awt.Font("Miriam", 0, 15)); // NOI18N
        err_mes.setForeground(new java.awt.Color(255, 0, 0));
        err_mes.setText("Wrong Username / Password! Try Again.");

        javax.swing.GroupLayout login_panLayout = new javax.swing.GroupLayout(login_pan);
        login_pan.setLayout(login_panLayout);
        login_panLayout.setHorizontalGroup(
            login_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, login_panLayout.createSequentialGroup()
                .addGroup(login_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(login_panLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(login_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(login_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(login_panLayout.createSequentialGroup()
                                    .addComponent(lbl_password)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txt_password))
                                .addGroup(login_panLayout.createSequentialGroup()
                                    .addComponent(lbl_username)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txt_username, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, login_panLayout.createSequentialGroup()
                                .addGap(0, 80, Short.MAX_VALUE)
                                .addComponent(err_mes)
                                .addGap(68, 68, 68))))
                    .addGroup(login_panLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_enter)
                        .addGap(164, 164, 164)))
                .addContainerGap())
        );
        login_panLayout.setVerticalGroup(
            login_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, login_panLayout.createSequentialGroup()
                .addGap(0, 12, Short.MAX_VALUE)
                .addGroup(login_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_username)
                    .addComponent(txt_username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(login_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_password)
                    .addComponent(txt_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_enter, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(err_mes))
        );

        err_mes.setVisible(false);

        acc_pan.setBackground(new java.awt.Color(204, 204, 204));
        acc_pan.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "No Account?", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Miriam Fixed", 1, 20), new java.awt.Color(255, 255, 255))); // NOI18N

        btn_signup.setBackground(new java.awt.Color(204, 204, 255));
        btn_signup.setFont(new java.awt.Font("Miriam", 1, 15)); // NOI18N
        btn_signup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/partNumbering_generator/add_user_icon.png"))); // NOI18N
        btn_signup.setText("Sign - Up ");
        btn_signup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_signupActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout acc_panLayout = new javax.swing.GroupLayout(acc_pan);
        acc_pan.setLayout(acc_panLayout);
        acc_panLayout.setHorizontalGroup(
            acc_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(acc_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(acc_panLayout.createSequentialGroup()
                    .addGap(0, 158, Short.MAX_VALUE)
                    .addComponent(btn_signup)
                    .addGap(0, 159, Short.MAX_VALUE)))
        );
        acc_panLayout.setVerticalGroup(
            acc_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 45, Short.MAX_VALUE)
            .addGroup(acc_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(acc_panLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(btn_signup)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        lbl_host.setText("Host:");

        btn_changeHost.setBackground(new java.awt.Color(204, 204, 255));
        btn_changeHost.setFont(new java.awt.Font("Miriam", 0, 12)); // NOI18N
        btn_changeHost.setText("Change");
        btn_changeHost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_changeHostActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout bg_panLayout = new javax.swing.GroupLayout(bg_pan);
        bg_pan.setLayout(bg_panLayout);
        bg_panLayout.setHorizontalGroup(
            bg_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bg_panLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(bg_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(bg_panLayout.createSequentialGroup()
                        .addComponent(lbl_host)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_changeHost))
                    .addGroup(bg_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(acc_pan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(login_pan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(header_pan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        bg_panLayout.setVerticalGroup(
            bg_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bg_panLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(header_pan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(bg_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_host)
                    .addComponent(btn_changeHost, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(login_pan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(acc_pan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg_pan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg_pan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_usernameActionPerformed
        
    }//GEN-LAST:event_txt_usernameActionPerformed

    private void btn_enterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_enterActionPerformed
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection connect = DriverManager.getConnection("jdbc:derby://localhost/partNumbering " ,"Admin01","07032017");
            PreparedStatement smt = connect.prepareStatement("SELECT * FROM ADMINS", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet resultset = smt.executeQuery();
            
            String user = txt_username.getText();
            StringBuilder pass_sb = new StringBuilder(txt_password.getPassword().length);
            for(Character c : txt_password.getPassword())
                pass_sb.append(c.charValue());
            String pass = pass_sb.toString();
            
            while(resultset.next()){
                String db_uname = resultset.getString("username");
                String db_pword = resultset.getString("password");
                
                if((user.equals(db_uname)) && (pass.equals(db_pword))){
                        new generator_admin_frame().setVisible(true);
                        this.setVisible(false);
                        txt_username.setText("");
                        txt_password.setText("");
                }
                else{
                    PreparedStatement smt1 = connect.prepareStatement("SELECT * FROM EMPLOYEE", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                    ResultSet resultset1 = smt1.executeQuery();
                    
                    String user1 = txt_username.getText();
                    StringBuilder pass_sb1 = new StringBuilder(txt_password.getPassword().length);
                    for(Character c : txt_password.getPassword())
                        pass_sb1.append(c.charValue());
                    String pass1 = pass_sb1.toString();
                    
                    while(resultset1.next()){
                        String db_uname1 = resultset1.getString("username");
                        String db_pword1 = resultset1.getString("password");

                        if((user1.equals(db_uname1)) && (pass1.equals(db_pword1))){
                                new generator_user_frame().setVisible(true);
                                this.setVisible(false);
                                txt_username.setText("");
                                txt_password.setText("");
                        }
                        else{
                            err_mes.setVisible(true);
                        }
                        
                    }
                    smt1.closeOnCompletion();
                    resultset1.close();
                }
            }
            smt.closeOnCompletion();
            resultset.close();
            connect.close();
        }
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(login_frame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_enterActionPerformed

    private void txt_usernameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_usernameKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
           txt_password.requestFocus();
        }   
    }//GEN-LAST:event_txt_usernameKeyPressed

    private void txt_passwordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_passwordKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
           btn_enter.doClick();
        } 
    }//GEN-LAST:event_txt_passwordKeyPressed

    private void btn_signupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_signupActionPerformed
        new sign_up_frame().setVisible(true);
    }//GEN-LAST:event_btn_signupActionPerformed

    private void btn_changeHostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_changeHostActionPerformed
        Pattern ip_pattern = Pattern.compile("(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})");
        Matcher ip_matcher;
        boolean valid_ip = false;
        
        do{
            String input_host = JOptionPane.showInputDialog("Enter new host address");
            ip_matcher = ip_pattern.matcher(input_host);
            
            if(ip_matcher.matches() || input_host.equals("localhost")){
                valid_ip = true;
            }
            
            if(ip_matcher.matches()){
                for(int x=1; x <= ip_matcher.groupCount(); x++){
                    int block = Integer.parseInt(ip_matcher.group(x));
                    if(block < 0 || block > 255){
                        valid_ip = false;
                        JOptionPane.showMessageDialog(null, "Please an IP address within 0.0.0.0 "
                                + "and 255.255.255.255.",
                                "Invalid address", JOptionPane.ERROR_MESSAGE);
                        break;
                    }
                }
            }
            if(valid_ip){
                host = input_host;
                Host.setHost(host);
                JOptionPane.showMessageDialog(null, "Host Address changed to " + Host.getHost());
                lbl_host.setText("Host: " + Host.getHost());
            }
            else if(!ip_matcher.matches()){
                JOptionPane.showMessageDialog(null, "Please enter a valid IPv4 address.",
                    "Invalid address format", JOptionPane.ERROR_MESSAGE);
            }
        }while(!valid_ip);
    }//GEN-LAST:event_btn_changeHostActionPerformed

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
            java.util.logging.Logger.getLogger(login_frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login_frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login_frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login_frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new login_frame().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel acc_pan;
    private javax.swing.JPanel bg_pan;
    private javax.swing.JButton btn_changeHost;
    private javax.swing.JButton btn_enter;
    private javax.swing.JButton btn_signup;
    private javax.swing.JLabel err_mes;
    private javax.swing.JPanel header_pan;
    private javax.swing.JLabel lbl_host;
    private javax.swing.JLabel lbl_icon;
    private javax.swing.JLabel lbl_password;
    private javax.swing.JLabel lbl_username;
    private javax.swing.JPanel login_pan;
    private javax.swing.JPasswordField txt_password;
    private javax.swing.JTextField txt_username;
    // End of variables declaration//GEN-END:variables

}
