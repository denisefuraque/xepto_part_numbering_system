package partNumbering_generator;

import java.awt.Font;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class sign_up_frame extends javax.swing.JFrame {

    ImageIcon err = new ImageIcon(getClass().getResource("/partNumbering_generator/sign-error-icon (1).png"));
    ImageIcon war = new ImageIcon(getClass().getResource("/partNumbering_generator/sign-warning-icon (1).png"));
    ImageIcon che = new ImageIcon(getClass().getResource("/partNumbering_generator/sign-check-icon (1).png"));
    
    String username;
    
    String host_address = Host.getHost();
    
    EntityManager em;
    
    public sign_up_frame() {
        initComponents();
        
        try{
            em = Persistence.createEntityManagerFactory("partNumberingPU", Host.getPersistence()).createEntityManager();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.toString());
        }  
        
        setLocationRelativeTo(null);
        
        this.setIconImage(new ImageIcon(getClass().getResource("xepto logo - white bg - x.jpg")).getImage()); 
        
    }
    
    public boolean usernameInAdmin(){
        try{
            em.getEntityManagerFactory().getCache().evictAll();
            Query q = em.createNamedQuery("Admins.findByUsername")
                    .setParameter("username", username);
            q.getSingleResult();
            return true;
        }
        catch(NoResultException e){
            return false;
        }
    }
    
    public boolean usernameInUser(){
        try{
            em.getEntityManagerFactory().getCache().evictAll();
            Query q = em.createNamedQuery("Employee.findByUsername")
                    .setParameter("username", username);
            q.getSingleResult();
            return true;
        }
        catch(NoResultException e){
            return false;
        }
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

        txt_fname.setFont(new java.awt.Font("Miriam", 0, 20)); // NOI18N
        txt_fname.setForeground(new java.awt.Color(0, 51, 153));
        txt_fname.setPreferredSize(new java.awt.Dimension(299, 28));
        txt_fname.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        txt_fname.setSelectionColor(new java.awt.Color(204, 204, 255));

        txt_lname.setFont(new java.awt.Font("Miriam", 0, 20)); // NOI18N
        txt_lname.setForeground(new java.awt.Color(0, 51, 153));
        txt_lname.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        txt_lname.setSelectionColor(new java.awt.Color(204, 204, 255));

        txt_job.setFont(new java.awt.Font("Miriam", 0, 20)); // NOI18N
        txt_job.setForeground(new java.awt.Color(0, 51, 153));
        txt_job.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        txt_job.setSelectionColor(new java.awt.Color(204, 204, 255));

        txt_pass.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        txt_pass.setForeground(new java.awt.Color(0, 51, 153));
        txt_pass.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        txt_pass.setSelectionColor(new java.awt.Color(204, 204, 255));

        txt_conPass.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        txt_conPass.setForeground(new java.awt.Color(0, 51, 153));
        txt_conPass.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        txt_conPass.setSelectionColor(new java.awt.Color(204, 204, 255));

        btn_sign_up.setFont(new java.awt.Font("Miriam", 0, 20)); // NOI18N
        btn_sign_up.setText("Sign - Up");
        btn_sign_up.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sign_upActionPerformed(evt);
            }
        });

        btn_check.setFont(new java.awt.Font("Miriam", 0, 20)); // NOI18N
        btn_check.setText("Check");
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
                                .addGap(10, 10, 10)
                                .addGroup(main_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_job, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txt_conPass)
                                    .addComponent(txt_pass)
                                    .addComponent(txt_user)
                                    .addGroup(main_panLayout.createSequentialGroup()
                                        .addComponent(txt_fname, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txt_lname))))
                            .addGroup(main_panLayout.createSequentialGroup()
                                .addGroup(main_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(main_panLayout.createSequentialGroup()
                                        .addGroup(main_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbl_user)
                                            .addComponent(lbl_pass)
                                            .addComponent(lbl_fname))
                                        .addGap(161, 161, 161)
                                        .addComponent(lbl_lname))
                                    .addComponent(lbl_job)
                                    .addComponent(lbl_conPass))
                                .addGap(0, 0, Short.MAX_VALUE)))
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

    private void btn_sign_upActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sign_upActionPerformed
        try{
            Employee emp = new Employee(
                                    txt_user.getText(),
                                    txt_conPass.getText(),
                                    txt_fname.getText(),
                                    txt_lname.getText(),
                                    txt_job.getText()
                                );
            em.getEntityManagerFactory().getCache().evictAll();            
            em.getTransaction().begin();
            em.persist(emp);
            em.flush();
            em.getTransaction().commit();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        
        JLabel result = new JLabel("You can now log-in to use the generator!");
        result.setFont(new Font("Monospaced", Font.BOLD, 15));
        JOptionPane.showMessageDialog( null, result, "Account Created!", JOptionPane.INFORMATION_MESSAGE );
        
        this.setVisible(false);
    }//GEN-LAST:event_btn_sign_upActionPerformed

    private void btn_checkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_checkActionPerformed

        username = txt_user.getText();
        
        if(usernameInAdmin() || usernameInUser()){
            lbl_user.setIcon(err);
            txt_user.requestFocus();
            txt_user.setToolTipText("Similar Username");
        }
        else if(!usernameInAdmin() || !txt_user.getText().isEmpty() || !usernameInUser()){
            lbl_user.setIcon(che);
            txt_user.setToolTipText("OK");
        }
        else if(txt_user.getText().isEmpty()){
            lbl_user.setIcon(war);
            txt_user.setToolTipText("Enter your Username!");
        }
        
        if(txt_fname.getText().isEmpty()){
            lbl_fname.setIcon(war);
            txt_fname.setToolTipText("Enter Your First Name!");
        }
        else if(!txt_fname.getText().isEmpty()){
            lbl_fname.setIcon(che);
            txt_fname.setToolTipText("OK");
        }

        if(txt_lname.getText().isEmpty()){
            lbl_lname.setIcon(war);
            txt_lname.setToolTipText("Enter your Last Name!");
        }
        
        else if(!txt_lname.getText().isEmpty()){
            lbl_lname.setIcon(che);
            txt_lname.setToolTipText("OK");
        }
        
        if(txt_job.getText().isEmpty()){
            lbl_job.setIcon(war);
            txt_job.setToolTipText("Enter your Job Position!");
        }
        else if(!txt_job.getText().isEmpty()){
            lbl_job.setIcon(che);
            txt_job.setToolTipText("OK");
        }
        
        if(txt_pass.getText().isEmpty()){
            lbl_pass.setIcon(war);
            txt_pass.setToolTipText("Enter your Password!");
        }
        else if(!txt_pass.getText().isEmpty()){
            if(txt_pass.getText().length() < 5){
                lbl_pass.setIcon(err);
                txt_pass.setToolTipText("Password should be more than 5 digits!");
            }
            else{
                lbl_pass.setIcon(che);
                txt_pass.setToolTipText("OK");
            }
        }
        if(txt_conPass.getText().isEmpty()){
            lbl_conPass.setIcon(war);
            txt_conPass.setToolTipText("Re-enter your Password");
        }
        else if(!txt_conPass.getText().isEmpty()){
            if(txt_conPass.getText().length() < 5){
                lbl_conPass.setIcon(err);
                txt_conPass.setToolTipText("Password should be more than 5 digits!");
            }
            if(txt_conPass.getText().length() >= 5){
                if(!txt_conPass.getText().equals(txt_pass.getText())){
                    lbl_conPass.setIcon(err);
                    lbl_pass.setIcon(err);
                    txt_pass.setToolTipText("Password does not match!");
                    txt_conPass.setToolTipText("Password does not match!");
                }
                else{
                    lbl_conPass.setIcon(che);
                    lbl_pass.setIcon(che);
                    txt_conPass.setToolTipText("OK");
                    txt_pass.setToolTipText("OK");
                }
            }
        }
        
        
        if(lbl_user.getIcon() == che && lbl_pass.getIcon() == che && lbl_conPass.getIcon() == che && lbl_fname.getIcon() == che && lbl_lname.getIcon() == che && lbl_job.getIcon() == che){
                    btn_check.setVisible(false);
                    btn_sign_up.setVisible(true);
                    btn_sign_up.requestFocus();
                }
    }//GEN-LAST:event_btn_checkActionPerformed

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
