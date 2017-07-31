
package partNumbering_generator;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class save_data_admin extends javax.swing.JFrame {
    
    DefaultTableModel model = new DefaultTableModel(){
        @Override
        public boolean isCellEditable(int row, int column){
            return false;
        }
    };
    
    String pn, cat;
    
    EntityManager em;
    
    public save_data_admin(String partNum, String category){
        
        initComponents();
        
        try{
            em = Persistence.createEntityManagerFactory("partNumberingPU", Host.getPersistence()).createEntityManager();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.toString());
        }   
        
        this.setIconImage(new ImageIcon(getClass().getResource("xepto logo - white bg - x.jpg")).getImage()); 
        
        this.pn = partNum;
        this.cat = category;
        
        txt_partNum.setText(partNum);
        txt_cat.setText(category);
        
        setLocationRelativeTo(null);
        
        fetchData();
        
    }

    public void fetchData(){
        
        try{
            ArrayList<Class_data> dataList = new ArrayList<>();
            Class_data data;
            
            em.getEntityManagerFactory().getCache().evictAll();
            Query q = em.createNamedQuery("PartNumberData.findAll");
            List<PartNumberData> pnd = q.getResultList();
            for(PartNumberData d: pnd){
                data = new Class_data(
                                    d.getPartNumber(),
                                    d.getCategory(),
                                    d.getDescription(), 
                                    d.getGeneratedDate(),
                                    d.getAuthor(),
                                    d.getConfiguration(),
                                    d.getManufacturer(),
                                    d.getMpn(),
                                    d.getWhereUsed()
                                    );
                dataList.add(data);
            }
            
            model.setColumnIdentifiers(new Object[]{"Part Number", "Category", "Description", "Generated Date", "Author", "Configuration", "Manufacturer", "MPN", "Where Used"});
            Object[] row = new Object[9];

            for (int i = 0; i < dataList.size(); i++){
                row[0] = dataList.get(i).getPn();
                row[1] = dataList.get(i).getCat();
                row[2] = dataList.get(i).getDes();
                row[3] = dataList.get(i).getDate();
                row[4] = dataList.get(i).getAut();
                row[5] = dataList.get(i).getConfig();
                row[6] = dataList.get(i).getManu();
                row[7] = dataList.get(i).getMpn();
                row[8] = dataList.get(i).getWhere();
                model.addRow(row);
            }
            tbl_database.setModel(model);
        }
        catch(Exception e){
            System.out.println(e.toString());

        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg_pan = new javax.swing.JPanel();
        database_pan = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_database = new javax.swing.JTable();
        information_pan = new javax.swing.JPanel();
        lbl_partNumber = new javax.swing.JLabel();
        lbl_category = new javax.swing.JLabel();
        lbl_description = new javax.swing.JLabel();
        txt_partNum = new javax.swing.JTextField();
        txt_cat = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_des = new javax.swing.JTextArea();
        btn_save = new javax.swing.JButton();
        txt_wu = new javax.swing.JTextField();
        txt_mpn = new javax.swing.JTextField();
        txt_manu = new javax.swing.JTextField();
        lbl_manu = new javax.swing.JLabel();
        lbl_mpn = new javax.swing.JLabel();
        lbl_wu = new javax.swing.JLabel();
        header_pan = new javax.swing.JPanel();
        lbl_icon = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setTitle("Save Record (Admin) - Part Number Generator");
        setMaximumSize(new java.awt.Dimension(700, 660));
        setMinimumSize(new java.awt.Dimension(700, 660));
        setPreferredSize(new java.awt.Dimension(700, 660));
        setResizable(false);
        setSize(new java.awt.Dimension(700, 660));

        bg_pan.setBackground(new java.awt.Color(204, 204, 255));
        bg_pan.setMaximumSize(new java.awt.Dimension(700, 535));
        bg_pan.setMinimumSize(new java.awt.Dimension(700, 535));

        database_pan.setBackground(new java.awt.Color(204, 204, 204));
        database_pan.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DATABASE", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Miriam Fixed", 1, 20), new java.awt.Color(255, 255, 255))); // NOI18N

        jScrollPane1.setViewportView(tbl_database);
        if (tbl_database.getColumnModel().getColumnCount() > 0) {
            tbl_database.getColumnModel().getColumn(0).setResizable(false);
            tbl_database.getColumnModel().getColumn(1).setResizable(false);
            tbl_database.getColumnModel().getColumn(2).setResizable(false);
        }

        javax.swing.GroupLayout database_panLayout = new javax.swing.GroupLayout(database_pan);
        database_pan.setLayout(database_panLayout);
        database_panLayout.setHorizontalGroup(
            database_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(database_panLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        database_panLayout.setVerticalGroup(
            database_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        information_pan.setBackground(new java.awt.Color(204, 204, 204));
        information_pan.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "INFORMATION", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Miriam Fixed", 1, 20), new java.awt.Color(255, 255, 255))); // NOI18N
        information_pan.setMinimumSize(new java.awt.Dimension(479, 324));
        information_pan.setPreferredSize(new java.awt.Dimension(479, 324));

        lbl_partNumber.setFont(new java.awt.Font("Miriam", 0, 20)); // NOI18N
        lbl_partNumber.setText("Part Number : ");

        lbl_category.setFont(new java.awt.Font("Miriam", 0, 20)); // NOI18N
        lbl_category.setText("Description : ");

        lbl_description.setFont(new java.awt.Font("Miriam", 0, 20)); // NOI18N
        lbl_description.setText("Category : ");

        txt_partNum.setFont(new java.awt.Font("Miriam", 0, 20)); // NOI18N

        txt_cat.setFont(new java.awt.Font("Miriam", 0, 20)); // NOI18N

        txt_des.setColumns(20);
        txt_des.setFont(new java.awt.Font("Miriam", 0, 20)); // NOI18N
        txt_des.setRows(5);
        jScrollPane2.setViewportView(txt_des);

        btn_save.setBackground(new java.awt.Color(204, 204, 255));
        btn_save.setFont(new java.awt.Font("Miriam", 0, 20)); // NOI18N
        btn_save.setText("Save");
        btn_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_saveActionPerformed(evt);
            }
        });

        txt_wu.setFont(new java.awt.Font("Miriam", 0, 20)); // NOI18N
        txt_wu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_wuActionPerformed(evt);
            }
        });

        txt_mpn.setFont(new java.awt.Font("Miriam", 0, 20)); // NOI18N
        txt_mpn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_mpnActionPerformed(evt);
            }
        });

        txt_manu.setFont(new java.awt.Font("Miriam", 0, 20)); // NOI18N
        txt_manu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_manuActionPerformed(evt);
            }
        });

        lbl_manu.setFont(new java.awt.Font("Miriam", 0, 20)); // NOI18N
        lbl_manu.setText("Manufacturer : ");

        lbl_mpn.setFont(new java.awt.Font("Miriam", 0, 20)); // NOI18N
        lbl_mpn.setText("MPN : ");

        lbl_wu.setFont(new java.awt.Font("Miriam", 0, 20)); // NOI18N
        lbl_wu.setText("Where - Used : ");

        javax.swing.GroupLayout information_panLayout = new javax.swing.GroupLayout(information_pan);
        information_pan.setLayout(information_panLayout);
        information_panLayout.setHorizontalGroup(
            information_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(information_panLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(information_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(information_panLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(information_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbl_description)
                            .addComponent(lbl_partNumber))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(information_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_cat, javax.swing.GroupLayout.DEFAULT_SIZE, 503, Short.MAX_VALUE)
                            .addComponent(txt_partNum)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, information_panLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_save, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, information_panLayout.createSequentialGroup()
                        .addGroup(information_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_manu, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbl_mpn, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbl_wu, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(information_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_manu)
                            .addComponent(txt_mpn)
                            .addComponent(txt_wu)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, information_panLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(lbl_category)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2)))
                .addContainerGap())
        );
        information_panLayout.setVerticalGroup(
            information_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, information_panLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(information_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_partNumber)
                    .addComponent(txt_partNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(information_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_description)
                    .addComponent(txt_cat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(information_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_category))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(information_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_manu)
                    .addComponent(txt_manu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(information_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_mpn)
                    .addComponent(txt_mpn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(information_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_wu)
                    .addComponent(txt_wu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_save)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        txt_partNum.setEditable(false);
        txt_cat.setEditable(false);

        header_pan.setBackground(new java.awt.Color(0, 0, 153));
        header_pan.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lbl_icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/partNumbering_generator/xepto logo - white bg.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Miriam Fixed", 1, 33)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Save Record(Admin)");

        javax.swing.GroupLayout header_panLayout = new javax.swing.GroupLayout(header_pan);
        header_pan.setLayout(header_panLayout);
        header_panLayout.setHorizontalGroup(
            header_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(header_panLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_icon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        header_panLayout.setVerticalGroup(
            header_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(header_panLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(header_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbl_icon)
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout bg_panLayout = new javax.swing.GroupLayout(bg_pan);
        bg_pan.setLayout(bg_panLayout);
        bg_panLayout.setHorizontalGroup(
            bg_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bg_panLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bg_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(header_pan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(database_pan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(information_pan, javax.swing.GroupLayout.DEFAULT_SIZE, 676, Short.MAX_VALUE))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        bg_panLayout.setVerticalGroup(
            bg_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bg_panLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(header_pan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(database_pan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(information_pan, javax.swing.GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg_pan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg_pan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveActionPerformed
        
        String aut = Account.getUser();
        Date today = new Date();
        java.sql.Date sqlDate = new java.sql.Date(Calendar.getInstance().getTimeInMillis());
        String config = txt_partNum.getText().substring(txt_partNum.getText().length() - 4);
       
        Object[] options = { "Yes", "No"};

        int opt = JOptionPane.showOptionDialog(this, "If you click YES, the data will be SAVED in the 'to be approved' database \n\tand only the admin can save it to the main database.", "You are about to SAVE a RECORD!!", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);

        switch(opt){

            case 0:

                //add selected data to part number data
                try{
                    PartNumberData data = new PartNumberData();
                    data.setPartNumber(pn);
                    data.setCategory(cat);
                    data.setDescription(txt_des.getText());
                    data.setGeneratedDate(sqlDate);
                    data.setAuthor(aut);
                    data.setConfiguration(config);
                    data.setManufacturer(txt_manu.getText());
                    data.setMpn(txt_mpn.getText());
                    data.setWhereUsed(txt_wu.getText());

                    em.getEntityManagerFactory().getCache().evictAll();
                    em.getTransaction().begin();
                    em.persist(data);
                    em.flush();
                    em.getTransaction().commit();
                    
                    btn_save.setVisible(false);
                    System.out.println("xx");
                }
                catch(Exception err){
                    JOptionPane.showMessageDialog(null, "Similar Part Number! Try Again.", "alert", JOptionPane.ERROR_MESSAGE);
            
                    this.setVisible(false);
                    txt_partNum.setText("");
                    txt_cat.setText("");
                    txt_des.setText("");

                    System.out.println(err.getMessage());
                }

            case 1:
                break;

        }

        txt_partNum.setText("");
        txt_cat.setText("");
        txt_des.setText("");
        this.setVisible(false);
        
    }//GEN-LAST:event_btn_saveActionPerformed

    private void txt_wuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_wuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_wuActionPerformed

    private void txt_mpnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_mpnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_mpnActionPerformed

    private void txt_manuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_manuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_manuActionPerformed

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
            java.util.logging.Logger.getLogger(save_data_admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(save_data_admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(save_data_admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(save_data_admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new save_data_admin(null, null).setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg_pan;
    private javax.swing.JButton btn_save;
    private javax.swing.JPanel database_pan;
    private javax.swing.JPanel header_pan;
    private javax.swing.JPanel information_pan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_category;
    private javax.swing.JLabel lbl_description;
    private javax.swing.JLabel lbl_icon;
    private javax.swing.JLabel lbl_manu;
    private javax.swing.JLabel lbl_mpn;
    private javax.swing.JLabel lbl_partNumber;
    private javax.swing.JLabel lbl_wu;
    private javax.swing.JTable tbl_database;
    private javax.swing.JTextField txt_cat;
    private javax.swing.JTextArea txt_des;
    private javax.swing.JTextField txt_manu;
    private javax.swing.JTextField txt_mpn;
    private javax.swing.JTextField txt_partNum;
    private javax.swing.JTextField txt_wu;
    // End of variables declaration//GEN-END:variables
}
