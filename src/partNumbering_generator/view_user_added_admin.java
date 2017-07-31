package partNumbering_generator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class view_user_added_admin extends javax.swing.JFrame {
    DefaultTableModel model = new DefaultTableModel(){
        @Override
        public boolean isCellEditable(int row, int column){
            return false;
        }
    };
    
    ArrayList<Class_data> dataList = new ArrayList<>();
    
    EntityManager em;
    
    List<String> partNumber, category, description, author, config;
    List<Date> genDate;
    String category1, description1, author1, config1;
    Date genDate1;
    int[] row;
    int selectedRowCount;
    
    public view_user_added_admin() {
        initComponents();
        
        try{
            em = Persistence.createEntityManagerFactory("partNumberingPU", Host.getPersistence()).createEntityManager();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.toString());
        }   
        
        this.setIconImage(new ImageIcon(getClass().getResource("xepto logo - white bg - x.jpg")).getImage()); 
        
        setLocationRelativeTo(null);
        
        partNumber = new ArrayList<>();
        category = new ArrayList<>();
        description = new ArrayList<>();
        genDate = new ArrayList<>();
        author = new ArrayList<>();
        config = new ArrayList<>();
        
        //call function
        findData();
        
        final TableRowSorter<TableModel> sorter;
        sorter = new TableRowSorter<>(model);
        tbl_database.setRowSorter(sorter);
        
        ActionListener al;
        al = (ActionEvent e) -> {
            String expr = txt_search.getText();
            sorter.setRowFilter(RowFilter.regexFilter(expr));
            sorter.setSortKeys(null);
            tbl_database.clearSelection();
        };
        
        btn_search.addActionListener(al);
        btn_delete.addActionListener(this::btn_delete_confirmationActionPerformed);
    }
    
    //opens a joptionpane to confirm whether the user is sure to delete the record
    private void btn_delete_confirmationActionPerformed(java.awt.event.ActionEvent evt){
        
        Object[] options = {"Yes",
                            "No"};
        int n = JOptionPane.showOptionDialog(this, "If you click YES, you won't be able to undo this Delete operation \n\nAre you sure you want to delete? ",
                "You are about to DELETE " + selectedRowCount + " Record!",
                JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE,null, options, options[0]);
        
        switch (n){
            case 0:
                try{
                    for(int i=0; i<selectedRowCount; i++){
                        em.getEntityManagerFactory().getCache().evictAll();    
                        em.getTransaction().begin();
                        Query q = em.createNamedQuery("DataUsers.findByPartNumber")
                                .setParameter("partNumber", partNumber.get(i));
                        DataUsers d = (DataUsers) q.getSingleResult();
                        
                        Trash trash = new Trash(d.getPartNumber(), d.getCategory(), d.getDescription(), 
                                d.getGeneratedDate(), d.getAuthor(), d.getConfiguration());
                        trash.addToDb();
                        
                        em.remove(d);
                        em.flush();
                        em.getTransaction().commit();

                        model.removeRow(row[i]-i);                        
                    }
                }
                catch(Exception e){
                    System.out.println(e.toString()+selectedRowCount);
                }
                break;
                
            case 1:
                break;
        }
    
    }
    

    //function to return arraylist with particular data
    public ArrayList<Class_data> ListClass_Data(String ValToSearch){
        try{
            Class_data data;
            
            em.getEntityManagerFactory().getCache().evictAll();
            Query q = em.createNamedQuery("DataUsers.findAll");
            List<DataUsers> list_data = q.getResultList();
            for(DataUsers d: list_data){
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

        }
        catch(Exception e){
            System.out.println(e.toString());
        }
        
        return dataList;
    }

    //function to Display data in JTable
    public void findData(){
        ArrayList<Class_data> data = ListClass_Data(txt_search.getText());
        model.setColumnIdentifiers(new Object[]{"Part Number", "Category", "Description", "Generated Date", "Author", "Configuration", "Manufacturer", "MPN", "Where Used"});
        Object[] row = new Object[9];
        
        for (int i = 0; i < data.size(); i++){
            row[0] = data.get(i).getPn();
            row[1] = data.get(i).getCat();
            row[2] = data.get(i).getDes();
            row[3] = data.get(i).getDate();
            row[4] = data.get(i).getAut();
            row[5] = data.get(i).getConfig();
            row[6] = data.get(i).getManu();
            row[7] = data.get(i).getMpn();
            row[8] = data.get(i).getWhere();
            model.addRow(row);
        }
        tbl_database.setModel(model);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg_pan = new javax.swing.JPanel();
        data_pan = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_database = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        txt_search = new javax.swing.JTextField();
        btn_search = new javax.swing.JButton();
        header_pan = new javax.swing.JPanel();
        lbl_icon = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btn_delete = new javax.swing.JButton();
        btn_save = new javax.swing.JButton();

        setTitle("Data For Approval (Admin) - Part Number Generator");

        bg_pan.setBackground(new java.awt.Color(204, 204, 255));

        data_pan.setBackground(new java.awt.Color(204, 204, 204));
        data_pan.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DATABASE", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Miriam Fixed", 1, 20), new java.awt.Color(255, 255, 255))); // NOI18N
        data_pan.setMaximumSize(new java.awt.Dimension(445, 840));
        data_pan.setMinimumSize(new java.awt.Dimension(445, 840));

        tbl_database.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_databaseMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tbl_databaseMouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_database);

        javax.swing.GroupLayout data_panLayout = new javax.swing.GroupLayout(data_pan);
        data_pan.setLayout(data_panLayout);
        data_panLayout.setHorizontalGroup(
            data_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(data_panLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        data_panLayout.setVerticalGroup(
            data_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(data_panLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Search", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Miriam Fixed", 1, 20), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel1.setMaximumSize(new java.awt.Dimension(214, 150));
        jPanel1.setMinimumSize(new java.awt.Dimension(214, 150));

        txt_search.setFont(new java.awt.Font("Miriam", 0, 20)); // NOI18N

        btn_search.setBackground(new java.awt.Color(204, 204, 255));
        btn_search.setFont(new java.awt.Font("Miriam", 0, 20)); // NOI18N
        btn_search.setText("Search");
        btn_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_searchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_search, javax.swing.GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_search, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_search))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        txt_search.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    btn_search.doClick();
                }
                if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE){
                    btn_search.doClick();
                }
            }
        });

        header_pan.setBackground(new java.awt.Color(0, 0, 153));
        header_pan.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lbl_icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/partNumbering_generator/xepto logo - white bg.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Miriam Fixed", 1, 31)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Data For Approval(Admin)");

        javax.swing.GroupLayout header_panLayout = new javax.swing.GroupLayout(header_pan);
        header_pan.setLayout(header_panLayout);
        header_panLayout.setHorizontalGroup(
            header_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(header_panLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_icon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        btn_delete.setBackground(new java.awt.Color(204, 204, 255));
        btn_delete.setFont(new java.awt.Font("Miriam", 0, 20)); // NOI18N
        btn_delete.setText("Delete Record");
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });

        btn_save.setBackground(new java.awt.Color(204, 204, 255));
        btn_save.setFont(new java.awt.Font("Miriam", 0, 20)); // NOI18N
        btn_save.setText("Save Record");
        btn_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_saveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout bg_panLayout = new javax.swing.GroupLayout(bg_pan);
        bg_pan.setLayout(bg_panLayout);
        bg_panLayout.setHorizontalGroup(
            bg_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bg_panLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bg_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bg_panLayout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(bg_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_delete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_save, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(bg_panLayout.createSequentialGroup()
                        .addGroup(bg_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(header_pan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(data_pan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        bg_panLayout.setVerticalGroup(
            bg_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bg_panLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(header_pan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(data_pan, javax.swing.GroupLayout.PREFERRED_SIZE, 373, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(bg_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(bg_panLayout.createSequentialGroup()
                        .addComponent(btn_delete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_save)))
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
            .addComponent(bg_pan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_searchActionPerformed

    }//GEN-LAST:event_btn_searchActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveActionPerformed
        
        Object[] options = { "Yes", "No"};

        int opt = JOptionPane.showOptionDialog(this, "If you click YES, " + selectedRowCount + 
                " data will be SAVED in the main database \n\tand will be DELETED in this database.\n\nAre you sure you want to SAVE selected record/s?", 
                "You are about to SAVE " + selectedRowCount + " RECORD/S!", 
                JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);

        switch(opt){

            case 0:

                //add selected data to part number data
                try{
                    for(int i=0; i<selectedRowCount; i++){
                        PartNumberData data = new PartNumberData();
                        data.setPartNumber(partNumber.get(i));
                        data.setCategory(category.get(i));
                        data.setDescription(description.get(i));
                        data.setGeneratedDate(genDate.get(i));
                        data.setAuthor(author.get(i));
                        data.setConfiguration(config.get(i));

                        em.getEntityManagerFactory().getCache().evictAll();                    
                        em.getTransaction().begin();
                        em.persist(data);
                        em.flush();
                        em.getTransaction().commit();                        
                    }
                }
                catch(Exception e){
                    System.out.println(e.toString());
                }

                try{
                    for(int i=0; i<selectedRowCount; i++){
                        em.getEntityManagerFactory().getCache().evictAll();    
                        em.getTransaction().begin();
                        Query q = em.createNamedQuery("DataUsers.findByPartNumber")
                                .setParameter("partNumber", partNumber.get(i));
                        DataUsers d = (DataUsers) q.getSingleResult();
                        em.remove(d);
                        em.flush();
                        em.getTransaction().commit();

                        model.removeRow(row[i]-i);                        
                    }
                }
                catch(Exception e){
                    System.out.println(e.toString());
                }

            case 1:
                break;

        }
    }//GEN-LAST:event_btn_saveActionPerformed

    private void tbl_databaseMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_databaseMouseReleased
        partNumber.clear();
        category.clear();
        description.clear();
        genDate.clear();
        author.clear();
        config.clear();
        
        selectedRowCount = tbl_database.getSelectedRowCount();
        row = tbl_database.getSelectedRows();
        for(int i=0; i<row.length; i++){
            if (tbl_database.getRowSorter()!=null) {
                row[i] = tbl_database.getRowSorter().convertRowIndexToModel(row[i]);
            }
            partNumber.add(tbl_database.getModel().getValueAt(row[i], 0).toString());
            category.add(tbl_database.getModel().getValueAt(row[i], 1).toString());
            description.add(tbl_database.getModel().getValueAt(row[i], 2).toString());
            genDate.add((Date) tbl_database.getModel().getValueAt(row[i], 3));
            author.add(tbl_database.getModel().getValueAt(row[i], 4).toString());
            config.add(tbl_database.getModel().getValueAt(row[i], 5).toString());
            System.out.println(row[i]);
        }
    }//GEN-LAST:event_tbl_databaseMouseReleased

    private void tbl_databaseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_databaseMouseClicked
        if (evt.getClickCount() == 2) {
            category1 = tbl_database.getModel().getValueAt(row[0], 1).toString();
            description1 = tbl_database.getModel().getValueAt(row[0], 2).toString();
            genDate1 = (Date) tbl_database.getModel().getValueAt(row[0], 3);
            author1 = tbl_database.getModel().getValueAt(row[0], 4).toString();
            config1 = tbl_database.getModel().getValueAt(row[0], 5).toString();
            
            this.hide();
            new mod_pn("admin_tba", partNumber.get(0), category1, description1, genDate1, author1, config1).setVisible(true);
        }
    }//GEN-LAST:event_tbl_databaseMouseClicked

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
            java.util.logging.Logger.getLogger(view_user_added_admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(view_user_added_admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(view_user_added_admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(view_user_added_admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new view_user_added_admin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg_pan;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_save;
    private javax.swing.JButton btn_search;
    private javax.swing.JPanel data_pan;
    private javax.swing.JPanel header_pan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_icon;
    private javax.swing.JTable tbl_database;
    private javax.swing.JTextField txt_search;
    // End of variables declaration//GEN-END:variables
}
