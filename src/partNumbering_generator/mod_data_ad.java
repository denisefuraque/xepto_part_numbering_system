
package partNumbering_generator;

import java.util.Date;
import javax.swing.ImageIcon;

/**
 *
 * @author Denise Furaque
 */
public class mod_data_ad extends javax.swing.JFrame {

    String pn, cat, des, aut, con;
    Date date;
    
    public mod_data_ad(String part, String category, String description, Date genDate, String author, String configuration) {
        initComponents();
        
        this.setIconImage(new ImageIcon(getClass().getResource("xepto logo - white bg - x.jpg")).getImage());
        setLocationRelativeTo(null);
        
        pn = part;
        cat = category;
        des =  description;
        date = genDate;
        aut = author;
        con = configuration;
        
        txt_pn.setText(pn);
        txt_cat.setText(cat);
        txt_des.setText(des);
        txt_date.setText(date.toString());
        txt_aut.setText(aut);
        txt_config.setText(con);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg_pan = new javax.swing.JPanel();
        in_pan = new javax.swing.JPanel();
        lbl_pn = new javax.swing.JLabel();
        lbl_cat = new javax.swing.JLabel();
        txt_pn = new javax.swing.JTextField();
        txt_cat = new javax.swing.JTextField();
        lbl_des = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_des = new javax.swing.JTextArea();
        lbl_date = new javax.swing.JLabel();
        txt_date = new javax.swing.JTextField();
        lbl_config = new javax.swing.JLabel();
        lbl_aut = new javax.swing.JLabel();
        txt_aut = new javax.swing.JTextField();
        txt_config = new javax.swing.JTextField();
        btn_mod = new javax.swing.JButton();
        btn_save = new javax.swing.JButton();
        btn_back = new javax.swing.JButton();

        setTitle("Part Number Information (Admin) - Part Number Generator");

        bg_pan.setBackground(new java.awt.Color(204, 204, 255));
        bg_pan.setMaximumSize(new java.awt.Dimension(600, 400));
        bg_pan.setMinimumSize(new java.awt.Dimension(600, 400));

        in_pan.setBackground(new java.awt.Color(204, 204, 204));
        in_pan.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 153), 5, true));
        in_pan.setMaximumSize(new java.awt.Dimension(580, 325));
        in_pan.setMinimumSize(new java.awt.Dimension(580, 325));

        lbl_pn.setFont(new java.awt.Font("Miriam Fixed", 1, 20)); // NOI18N
        lbl_pn.setText("Part Number : ");

        lbl_cat.setFont(new java.awt.Font("Miriam Fixed", 1, 20)); // NOI18N
        lbl_cat.setText("Category : ");

        txt_pn.setEditable(false);
        txt_pn.setBackground(new java.awt.Color(153, 153, 153));
        txt_pn.setFont(new java.awt.Font("Miriam", 0, 20)); // NOI18N
        txt_pn.setForeground(new java.awt.Color(255, 255, 255));
        txt_pn.setMaximumSize(new java.awt.Dimension(403, 30));
        txt_pn.setMinimumSize(new java.awt.Dimension(365, 30));
        txt_pn.setPreferredSize(new java.awt.Dimension(403, 30));
        txt_pn.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        txt_pn.setSelectionColor(new java.awt.Color(153, 204, 255));

        txt_cat.setEditable(false);
        txt_cat.setBackground(new java.awt.Color(153, 153, 153));
        txt_cat.setFont(new java.awt.Font("Miriam", 0, 20)); // NOI18N
        txt_cat.setForeground(new java.awt.Color(255, 255, 255));
        txt_cat.setMaximumSize(new java.awt.Dimension(403, 30));
        txt_cat.setMinimumSize(new java.awt.Dimension(365, 30));
        txt_cat.setPreferredSize(new java.awt.Dimension(403, 30));
        txt_cat.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        txt_cat.setSelectionColor(new java.awt.Color(153, 204, 255));

        lbl_des.setFont(new java.awt.Font("Miriam Fixed", 1, 20)); // NOI18N
        lbl_des.setText("Description : ");

        txt_des.setEditable(false);
        txt_des.setBackground(new java.awt.Color(153, 153, 153));
        txt_des.setColumns(20);
        txt_des.setFont(new java.awt.Font("Miriam", 0, 20)); // NOI18N
        txt_des.setForeground(new java.awt.Color(255, 255, 255));
        txt_des.setLineWrap(true);
        txt_des.setRows(5);
        txt_des.setWrapStyleWord(true);
        txt_des.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        txt_des.setSelectionColor(new java.awt.Color(153, 204, 255));
        jScrollPane1.setViewportView(txt_des);

        lbl_date.setFont(new java.awt.Font("Miriam Fixed", 1, 20)); // NOI18N
        lbl_date.setText("Generated Date : ");

        txt_date.setEditable(false);
        txt_date.setBackground(new java.awt.Color(153, 153, 153));
        txt_date.setFont(new java.awt.Font("Miriam", 0, 20)); // NOI18N
        txt_date.setForeground(new java.awt.Color(255, 255, 255));
        txt_date.setMaximumSize(new java.awt.Dimension(403, 30));
        txt_date.setMinimumSize(new java.awt.Dimension(365, 30));
        txt_date.setPreferredSize(new java.awt.Dimension(403, 30));
        txt_date.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        txt_date.setSelectionColor(new java.awt.Color(153, 204, 255));

        lbl_config.setFont(new java.awt.Font("Miriam Fixed", 1, 20)); // NOI18N
        lbl_config.setText("Configuration : ");

        lbl_aut.setFont(new java.awt.Font("Miriam Fixed", 1, 20)); // NOI18N
        lbl_aut.setText("Author : ");

        txt_aut.setEditable(false);
        txt_aut.setBackground(new java.awt.Color(153, 153, 153));
        txt_aut.setFont(new java.awt.Font("Miriam", 0, 20)); // NOI18N
        txt_aut.setForeground(new java.awt.Color(255, 255, 255));
        txt_aut.setMaximumSize(new java.awt.Dimension(403, 30));
        txt_aut.setMinimumSize(new java.awt.Dimension(365, 30));
        txt_aut.setPreferredSize(new java.awt.Dimension(403, 30));
        txt_aut.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        txt_aut.setSelectionColor(new java.awt.Color(153, 204, 255));

        txt_config.setEditable(false);
        txt_config.setBackground(new java.awt.Color(153, 153, 153));
        txt_config.setFont(new java.awt.Font("Miriam", 0, 20)); // NOI18N
        txt_config.setForeground(new java.awt.Color(255, 255, 255));
        txt_config.setMaximumSize(new java.awt.Dimension(403, 30));
        txt_config.setMinimumSize(new java.awt.Dimension(365, 30));
        txt_config.setPreferredSize(new java.awt.Dimension(403, 30));
        txt_config.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        txt_config.setSelectionColor(new java.awt.Color(153, 204, 255));

        javax.swing.GroupLayout in_panLayout = new javax.swing.GroupLayout(in_pan);
        in_pan.setLayout(in_panLayout);
        in_panLayout.setHorizontalGroup(
            in_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, in_panLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(in_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, in_panLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(in_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbl_cat)
                            .addComponent(lbl_pn))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(in_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_cat, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                            .addComponent(txt_pn, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, in_panLayout.createSequentialGroup()
                        .addGroup(in_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbl_date)
                            .addComponent(lbl_des)
                            .addComponent(lbl_config)
                            .addComponent(lbl_aut))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(in_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addComponent(txt_date, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                            .addComponent(txt_aut, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                            .addComponent(txt_config, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))))
                .addContainerGap())
        );
        in_panLayout.setVerticalGroup(
            in_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(in_panLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(in_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_pn)
                    .addComponent(txt_pn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(in_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_cat)
                    .addComponent(txt_cat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(in_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_des)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(in_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_date))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(in_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(in_panLayout.createSequentialGroup()
                        .addGroup(in_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_aut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_aut))
                        .addGap(36, 36, 36))
                    .addGroup(in_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbl_config)
                        .addComponent(txt_config, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
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
                        .addGap(0, 40, Short.MAX_VALUE)))
                .addContainerGap())
        );
        bg_panLayout.setVerticalGroup(
            bg_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bg_panLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(in_pan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(bg_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_mod)
                    .addComponent(btn_save)
                    .addComponent(btn_back))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        txt_pn.setEditable(true);
        txt_cat.setEditable(true);
        txt_des.setEditable(true);
        txt_date.setEditable(true);
        txt_aut.setEditable(true);
        txt_config.setEditable(true);

        txt_pn.requestFocus();
        txt_pn.selectAll();

        btn_mod.setEnabled(false);
        btn_save.setEnabled(true);
    }//GEN-LAST:event_btn_modActionPerformed

    private void btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveActionPerformed

    }//GEN-LAST:event_btn_saveActionPerformed

    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backActionPerformed
        this.setVisible(false);
        new view_database().setVisible(true);
    }//GEN-LAST:event_btn_backActionPerformed

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
            java.util.logging.Logger.getLogger(mod_data_ad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mod_data_ad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mod_data_ad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mod_data_ad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new mod_data_ad(null, null, null, null, null, null).setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg_pan;
    private javax.swing.JButton btn_back;
    private javax.swing.JButton btn_mod;
    private javax.swing.JButton btn_save;
    private javax.swing.JPanel in_pan;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_aut;
    private javax.swing.JLabel lbl_cat;
    private javax.swing.JLabel lbl_config;
    private javax.swing.JLabel lbl_date;
    private javax.swing.JLabel lbl_des;
    private javax.swing.JLabel lbl_pn;
    private javax.swing.JTextField txt_aut;
    private javax.swing.JTextField txt_cat;
    private javax.swing.JTextField txt_config;
    private javax.swing.JTextField txt_date;
    private javax.swing.JTextArea txt_des;
    private javax.swing.JTextField txt_pn;
    // End of variables declaration//GEN-END:variables
}
