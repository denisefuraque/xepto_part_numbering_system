
package partNumbering_generator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class mod_user_admin extends javax.swing.JFrame {

    String user, pass, fname, lname, job;
    
    public mod_user_admin(String mod_user, String mod_pass, String mod_fname, String mod_lname, String mod_job) {
        initComponents();
        
        this.setIconImage(new ImageIcon(getClass().getResource("xepto logo - white bg - x.jpg")).getImage());
        setLocationRelativeTo(null);
        
        user = mod_user;
        pass = mod_pass;
        fname = mod_fname;
        lname = mod_lname;
        job = mod_job;
        
        txt_user.setText(mod_user);
        txt_pass.setText(mod_pass);
        txt_fname.setText(mod_fname);
        txt_lname.setText(mod_lname);
        txt_job.setText(mod_job);
        txt_pType.setText("Administrator");
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg_pan = new javax.swing.JPanel();
        in_pan = new javax.swing.JPanel();
        lbl_user = new javax.swing.JLabel();
        lbl_pass = new javax.swing.JLabel();
        lbl_fname = new javax.swing.JLabel();
        lbl_lname = new javax.swing.JLabel();
        lbl_job = new javax.swing.JLabel();
        lbl_pType = new javax.swing.JLabel();
        txt_user = new javax.swing.JTextField();
        txt_fname = new javax.swing.JTextField();
        txt_lname = new javax.swing.JTextField();
        txt_pType = new javax.swing.JTextField();
        txt_job = new javax.swing.JTextField();
        txt_pass = new javax.swing.JPasswordField();
        btn_mod = new javax.swing.JButton();
        btn_save = new javax.swing.JButton();
        btn_back = new javax.swing.JButton();

        setTitle("User Information");
        setMaximumSize(new java.awt.Dimension(600, 400));
        setMinimumSize(new java.awt.Dimension(600, 400));
        setSize(new java.awt.Dimension(600, 400));

        bg_pan.setBackground(new java.awt.Color(204, 204, 255));
        bg_pan.setMaximumSize(new java.awt.Dimension(600, 400));
        bg_pan.setMinimumSize(new java.awt.Dimension(600, 400));

        in_pan.setBackground(new java.awt.Color(204, 204, 204));
        in_pan.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 153), 5, true));
        in_pan.setMaximumSize(new java.awt.Dimension(580, 325));
        in_pan.setMinimumSize(new java.awt.Dimension(580, 325));

        lbl_user.setFont(new java.awt.Font("Miriam Fixed", 1, 20)); // NOI18N
        lbl_user.setText("Username : ");

        lbl_pass.setFont(new java.awt.Font("Miriam Fixed", 1, 20)); // NOI18N
        lbl_pass.setText("Password :");

        lbl_fname.setFont(new java.awt.Font("Miriam Fixed", 1, 20)); // NOI18N
        lbl_fname.setText("First Name : ");

        lbl_lname.setFont(new java.awt.Font("Miriam Fixed", 1, 20)); // NOI18N
        lbl_lname.setText("Last Name : ");

        lbl_job.setFont(new java.awt.Font("Miriam Fixed", 1, 20)); // NOI18N
        lbl_job.setText("Job Position : ");

        lbl_pType.setFont(new java.awt.Font("Miriam Fixed", 1, 20)); // NOI18N
        lbl_pType.setText("Permission Type: ");

        txt_user.setEditable(false);
        txt_user.setBackground(new java.awt.Color(153, 153, 153));
        txt_user.setFont(new java.awt.Font("Miriam", 0, 20)); // NOI18N
        txt_user.setForeground(new java.awt.Color(255, 255, 255));
        txt_user.setMaximumSize(new java.awt.Dimension(403, 30));
        txt_user.setMinimumSize(new java.awt.Dimension(403, 30));
        txt_user.setPreferredSize(new java.awt.Dimension(403, 30));
        txt_user.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        txt_user.setSelectionColor(new java.awt.Color(153, 204, 255));

        txt_fname.setEditable(false);
        txt_fname.setBackground(new java.awt.Color(153, 153, 153));
        txt_fname.setFont(new java.awt.Font("Miriam", 0, 20)); // NOI18N
        txt_fname.setForeground(new java.awt.Color(255, 255, 255));
        txt_fname.setMaximumSize(new java.awt.Dimension(265, 30));
        txt_fname.setMinimumSize(new java.awt.Dimension(265, 30));
        txt_fname.setPreferredSize(new java.awt.Dimension(265, 30));
        txt_fname.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        txt_fname.setSelectionColor(new java.awt.Color(153, 204, 255));

        txt_lname.setEditable(false);
        txt_lname.setBackground(new java.awt.Color(153, 153, 153));
        txt_lname.setFont(new java.awt.Font("Miriam", 0, 20)); // NOI18N
        txt_lname.setForeground(new java.awt.Color(255, 255, 255));
        txt_lname.setMaximumSize(new java.awt.Dimension(267, 30));
        txt_lname.setMinimumSize(new java.awt.Dimension(267, 30));
        txt_lname.setPreferredSize(new java.awt.Dimension(267, 30));
        txt_lname.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        txt_lname.setSelectionColor(new java.awt.Color(153, 204, 255));

        txt_pType.setEditable(false);
        txt_pType.setBackground(new java.awt.Color(153, 153, 153));
        txt_pType.setFont(new java.awt.Font("Miriam", 0, 20)); // NOI18N
        txt_pType.setForeground(new java.awt.Color(255, 255, 255));
        txt_pType.setMaximumSize(new java.awt.Dimension(550, 30));
        txt_pType.setMinimumSize(new java.awt.Dimension(550, 30));
        txt_pType.setPreferredSize(new java.awt.Dimension(550, 30));
        txt_pType.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        txt_pType.setSelectionColor(new java.awt.Color(153, 204, 255));

        txt_job.setEditable(false);
        txt_job.setBackground(new java.awt.Color(153, 153, 153));
        txt_job.setFont(new java.awt.Font("Miriam", 0, 20)); // NOI18N
        txt_job.setForeground(new java.awt.Color(255, 255, 255));
        txt_job.setMaximumSize(new java.awt.Dimension(550, 30));
        txt_job.setMinimumSize(new java.awt.Dimension(550, 30));
        txt_job.setPreferredSize(new java.awt.Dimension(550, 30));
        txt_job.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        txt_job.setSelectionColor(new java.awt.Color(153, 204, 255));

        txt_pass.setEditable(false);
        txt_pass.setBackground(new java.awt.Color(153, 153, 153));
        txt_pass.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        txt_pass.setForeground(new java.awt.Color(255, 255, 255));
        txt_pass.setMaximumSize(new java.awt.Dimension(403, 30));
        txt_pass.setMinimumSize(new java.awt.Dimension(403, 30));
        txt_pass.setPreferredSize(new java.awt.Dimension(403, 30));
        txt_pass.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        txt_pass.setSelectionColor(new java.awt.Color(153, 204, 255));

        javax.swing.GroupLayout in_panLayout = new javax.swing.GroupLayout(in_pan);
        in_pan.setLayout(in_panLayout);
        in_panLayout.setHorizontalGroup(
            in_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(in_panLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(in_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(in_panLayout.createSequentialGroup()
                        .addComponent(lbl_user)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_user, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(in_panLayout.createSequentialGroup()
                        .addGroup(in_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(in_panLayout.createSequentialGroup()
                                .addComponent(lbl_fname)
                                .addGap(102, 102, 102)
                                .addComponent(lbl_lname))
                            .addComponent(lbl_job)
                            .addComponent(lbl_pType))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(in_panLayout.createSequentialGroup()
                        .addComponent(txt_fname, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txt_lname, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(txt_pType, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_job, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(in_panLayout.createSequentialGroup()
                        .addComponent(lbl_pass)
                        .addGap(18, 18, 18)
                        .addComponent(txt_pass, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        in_panLayout.setVerticalGroup(
            in_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(in_panLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(in_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_user)
                    .addComponent(txt_user, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(in_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_pass)
                    .addComponent(txt_pass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(in_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_lname)
                    .addComponent(lbl_fname))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(in_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_lname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_fname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_job)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_job, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(lbl_pType)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_pType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        btn_mod.setBackground(new java.awt.Color(204, 204, 255));
        btn_mod.setFont(new java.awt.Font("Miriam", 0, 20)); // NOI18N
        btn_mod.setIcon(new javax.swing.ImageIcon(getClass().getResource("/partNumbering_generator/Text-Edit-icon.png"))); // NOI18N
        btn_mod.setText("Modify");
        btn_mod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modActionPerformed(evt);
            }
        });

        btn_save.setBackground(new java.awt.Color(204, 204, 255));
        btn_save.setFont(new java.awt.Font("Miriam", 0, 20)); // NOI18N
        btn_save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/partNumbering_generator/Actions-document-save-as-icon.png"))); // NOI18N
        btn_save.setText("Save");
        btn_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_saveActionPerformed(evt);
            }
        });

        btn_back.setBackground(new java.awt.Color(204, 204, 255));
        btn_back.setFont(new java.awt.Font("Miriam", 0, 20)); // NOI18N
        btn_back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/partNumbering_generator/Go-back-icon.png"))); // NOI18N
        btn_back.setText("Back");
        btn_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_backActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout bg_panLayout = new javax.swing.GroupLayout(bg_pan);
        bg_pan.setLayout(bg_panLayout);
        bg_panLayout.setHorizontalGroup(
            bg_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bg_panLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bg_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(in_pan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(bg_panLayout.createSequentialGroup()
                        .addComponent(btn_mod, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_save, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_back, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        bg_panLayout.setVerticalGroup(
            bg_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bg_panLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(in_pan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(bg_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_mod)
                    .addComponent(btn_save)
                    .addComponent(btn_back))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        btn_save.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg_pan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg_pan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_modActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modActionPerformed
        txt_user.setEditable(true);
        txt_pass.setEditable(true);
        txt_fname.setEditable(true);
        txt_lname.setEditable(true);
        txt_job.setEditable(true);
        
        txt_user.requestFocus();
        txt_user.selectAll();
        
        btn_mod.setEnabled(false);
        btn_save.setEnabled(true);
    }//GEN-LAST:event_btn_modActionPerformed

    private void btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveActionPerformed
        if(txt_pass.getText().equals(pass)){
            JPasswordField pwd = new JPasswordField();
            int action = JOptionPane.showConfirmDialog(null, pwd,"Enter Your Password",JOptionPane.OK_CANCEL_OPTION);
            switch(action){
                case 0:
                    if(pwd.getText().equals(txt_pass.getText())){
                        Object[] options = {"Yes","No"};
                        int opt = JOptionPane.showOptionDialog(this, "Are you sure you want to modify the data?", "WARNING!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,null,options,options[1]);
                        switch (opt){
                            case 0:
                                try {
                                    String val1 = txt_user.getText();
                                    String val2 = txt_pass.getText();
                                    String val3 = txt_fname.getText();
                                    String val4 = txt_lname.getText();
                                    String val5 = txt_job.getText(); 
                                    String host = "jdbc:derby://localhost/partNumbering";
                                    String username = "Admin01";
                                    String password = "07032017";
                                    Connection connect = DriverManager.getConnection(host, username, password);
                                    String sql = "UPDATE ADMINS SET USERNAME = ?, PASSWORD = ?, FIRST_NAME = ?, LAST_NAME = ?, JOB_TITLE = ?  WHERE USERNAME = ?";
                                    PreparedStatement stmt = connect.prepareStatement(sql);
                                    stmt.setString(1, val1);
                                    stmt.setString(2, val2);
                                    stmt.setString(3, val3);
                                    stmt.setString(4, val4);
                                    stmt.setString(5, val5);
                                    stmt.setString(6, user);
                                    stmt.executeUpdate();
                                    JOptionPane.showMessageDialog(null, "Database has been Updated !");
                                    
                                    btn_save.setEnabled(false);
                                    btn_mod.setEnabled(true);
                                    txt_user.setEditable(false);
                                    txt_pass.setEditable(false);
                                    txt_fname.setEditable(false);
                                    txt_lname.setEditable(false);
                                    txt_job.setEditable(false);
                                } catch (SQLException e){
                                    JOptionPane.showMessageDialog(null, e);
                                }
                                break;
                            case 1:
                                txt_pass.setText(pass);
                                break;
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(this, "WRONG PASSWORD", "ERROR", JOptionPane.ERROR_MESSAGE);
                        btn_save.doClick();
                        }
                    break;
                case 1:
                    break;
            }
        }
        else{
            JPasswordField pwd = new JPasswordField();
            int action = JOptionPane.showConfirmDialog(null, pwd,"Enter Old Password",JOptionPane.OK_CANCEL_OPTION);
            System.out.println(action + " " + pwd.getText());
            switch(action){
                case 0:
                    if(pwd.getText().equals(pass)){
                        JPasswordField pwd1 = new JPasswordField();
                        int action1 = JOptionPane.showConfirmDialog(null, pwd1,"Confirm New Password",JOptionPane.OK_CANCEL_OPTION);
                        switch(action1){
                            case 0:
                                if(pwd1.getText().equals(txt_pass.getText())){
                                    Object[] options = {"Yes","No"};
                                    int opt = JOptionPane.showOptionDialog(this, "Are you sure you want to modify the data?", "WARNING!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,null,options,options[1]);
                                        switch (opt){
                                            case 0:
                                                try {
                                                    String val1 = txt_user.getText();
                                                    String val2 = txt_pass.getText();
                                                    String val3 = txt_fname.getText();
                                                    String val4 = txt_lname.getText();
                                                    String val5 = txt_job.getText(); 
                                                    String host = "jdbc:derby://localhost/partNumbering";
                                                    String username = "Admin01";
                                                    String password = "07032017";
                                                    Connection connect = DriverManager.getConnection(host, username, password);
                                                    String sql = "UPDATE ADMINS SET USERNAME = ?, PASSWORD = ?, FIRST_NAME = ?, LAST_NAME = ?, JOB_TITLE = ?  WHERE USERNAME = ?";
                                                    PreparedStatement stmt = connect.prepareStatement(sql);
                                                    stmt.setString(1, val1);
                                                    stmt.setString(2, val2);
                                                    stmt.setString(3, val3);
                                                    stmt.setString(4, val4);
                                                    stmt.setString(5, val5);
                                                    stmt.setString(6, user);
                                                    stmt.executeUpdate();
                                                    JOptionPane.showMessageDialog(null, "Database has been Updated !");
                                                    
                                                    btn_save.setEnabled(false);
                                                    btn_mod.setEnabled(true);
                                                    txt_user.setEditable(false);
                                                    txt_pass.setEditable(false);
                                                    txt_fname.setEditable(false);
                                                    txt_lname.setEditable(false);
                                                    txt_job.setEditable(false);
                                                } catch (SQLException e){
                                                    JOptionPane.showMessageDialog(null, e);
                                                }
                                                break;
                                            case 1:
                                                txt_pass.setText(pass);
                                                break;
                                        }
                                    }
                                    else{
                                        JOptionPane.showMessageDialog(this, "WRONG PASSWORD", "ERROR", JOptionPane.ERROR_MESSAGE);
                                        btn_save.doClick();
                                    }
                                    break;
                                case 1:
                                    break;
                            }
                    }
                    else{
                        JOptionPane.showMessageDialog(this, "WRONG PASSWORD", "ERROR", JOptionPane.ERROR_MESSAGE);
                        btn_save.doClick();
                    }
                    break;
                case 1:
                    break;
            }
        }
    }//GEN-LAST:event_btn_saveActionPerformed

    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backActionPerformed
        this.setVisible(false);
        new emp_dir_admin().setVisible(true);
    }//GEN-LAST:event_btn_backActionPerformed

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
            java.util.logging.Logger.getLogger(mod_user_admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mod_user_admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mod_user_admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mod_user_admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new mod_user_admin(null, null, null, null, null).setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg_pan;
    private javax.swing.JButton btn_back;
    private javax.swing.JButton btn_mod;
    private javax.swing.JButton btn_save;
    private javax.swing.JPanel in_pan;
    private javax.swing.JLabel lbl_fname;
    private javax.swing.JLabel lbl_job;
    private javax.swing.JLabel lbl_lname;
    private javax.swing.JLabel lbl_pType;
    private javax.swing.JLabel lbl_pass;
    private javax.swing.JLabel lbl_user;
    private javax.swing.JTextField txt_fname;
    private javax.swing.JTextField txt_job;
    private javax.swing.JTextField txt_lname;
    private javax.swing.JTextField txt_pType;
    private javax.swing.JPasswordField txt_pass;
    private javax.swing.JTextField txt_user;
    // End of variables declaration//GEN-END:variables
}
