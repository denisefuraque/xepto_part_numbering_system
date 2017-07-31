package partNumbering_generator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Date;
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

public final class trash_pn_db extends javax.swing.JFrame {
    
    DefaultTableModel model = new DefaultTableModel(){
        @Override
        public boolean isCellEditable(int row, int column){
            return false;
        }
    };
    
    ArrayList<Class_data> dataList = new ArrayList<>();
    
    EntityManager em;
    
    String account_type, db;
    
    List<String> partNumber;
    String category, description, author, config;
    Date genDate;
    int[] row;
    int selectedRowCount;
    
    public trash_pn_db() {
        initComponents();
        
        this.setIconImage(new ImageIcon(getClass().getResource("xepto logo - white bg - x.jpg")).getImage()); 
        
        try{
            em = Persistence.createEntityManagerFactory("partNumberingPU", Host.getPersistence()).createEntityManager();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.toString());
        }        
        
        setLocationRelativeTo(null);
        
        account_type = Account.getType();
        
        if(account_type.equals("admin")){
            db = "database";
        }
        else if(account_type.equals("user")){
            db = "database for approval";
        }
        
        partNumber = new ArrayList<>();
        
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
        };
        
        btn_search.addActionListener(al);
        btn_retrieve.addActionListener(this::btn_retrieve_confirmationActionPerformed);
    }
    
    //opens a joptionpane to confirm whether the user is sure to delete the record
    private void btn_retrieve_confirmationActionPerformed(java.awt.event.ActionEvent evt){
        Object[] options = {"Yes",
                            "No"};
        int n = JOptionPane.showOptionDialog(this, "Records selected will be restored in the " + db + ".\n\nClick 'Yes' to proceed.",
                "Retrieve part number records",
                JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE,null, options, options[0]);
        switch (n){
            case 0:
                try{
                    String invalidPn = "";
                    int deleted = 0;
                    for(int i=0; i<selectedRowCount; i++){
                        em.getEntityManagerFactory().getCache().evictAll();    
                        Query q = em.createNamedQuery("TrashPn.findByPartNumber")
                                .setParameter("partNumber", partNumber.get(i));
                        TrashPn d = (TrashPn) q.setMaxResults(1).getSingleResult();
                        
                        if(!Validity.check_pn(d.getPartNumber())){
                            invalidPn += "\n" + d.getPartNumber();
                            continue;
                        }
                        
                        if(account_type.equals("admin")){
                            PartNumberData data = new PartNumberData();
                            data.setPartNumber(d.getPartNumber());
                            data.setCategory(d.getCategory());
                            data.setDescription(d.getDescription());
                            data.setGeneratedDate(d.getGeneratedDate());
                            data.setAuthor(d.getAuthor());
                            data.setConfiguration(d.getConfiguration());
                            data.setManufacturer(d.getManufacturer());
                            data.setMpn(d.getMpn());
                            data.setWhereUsed(d.getWhereUsed());
                                                    
                            em.getEntityManagerFactory().getCache().evictAll();                    
                            em.getTransaction().begin();
                            em.persist(data);
                            em.flush();
                            em.getTransaction().commit();  
                        }
                        else if(account_type.equals("user")){
                            DataUsers data = new DataUsers();
                            data.setPartNumber(d.getPartNumber());
                            data.setCategory(d.getCategory());
                            data.setDescription(d.getDescription());
                            data.setGeneratedDate(d.getGeneratedDate());
                            data.setAuthor(d.getAuthor());
                            data.setConfiguration(d.getConfiguration());
                            data.setManufacturer(d.getManufacturer());
                            data.setMpn(d.getMpn());
                            data.setWhereUsed(d.getWhereUsed());
                                                    
                            em.getEntityManagerFactory().getCache().evictAll();                    
                            em.getTransaction().begin();
                            em.persist(data);
                            em.flush();
                            em.getTransaction().commit(); 
                        }

                        
                        em.getEntityManagerFactory().getCache().evictAll(); 
                        em.getTransaction().begin();
                        em.remove(d);
                        em.flush();
                        em.getTransaction().commit();

                        model.removeRow(row[i]-deleted);
                        deleted++;
                    }
                    
                    if(!invalidPn.equals("")){
                        JOptionPane.showMessageDialog(null, "The following part numbers are already used in the database."
                                + "\nThese records are not restored.\n"
                                + invalidPn,
                                "Part numbers present in the database", JOptionPane.ERROR_MESSAGE);
                    }
                }
                catch(Exception e){
                    System.out.println(e.toString());
                }
                break;
            case 1:
                break;
        }
    
    }

    //function to return arraylist with particular data
    public ArrayList<Class_data> ListClass_Data(){
        
        try{
            Class_data data;
            
            em.getEntityManagerFactory().getCache().evictAll();
            Query q = em.createNamedQuery("TrashPn.findAll");
            List<TrashPn> trash = q.getResultList();
            for(TrashPn d: trash){
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
            System.out.print(e.toString());
        }
        
        return dataList;
    }
    
    //function to Display data in JTable
    public void findData(){
        ArrayList<Class_data> data = ListClass_Data();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_database = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        txt_search = new javax.swing.JTextField();
        btn_search = new javax.swing.JButton();
        btn_retrieve = new javax.swing.JButton();
        header_pan = new javax.swing.JPanel();
        lbl_icon = new javax.swing.JLabel();
        lbl_header = new javax.swing.JLabel();

        setTitle("View Database (Admin) - Part Number Generator");
        setMinimumSize(new java.awt.Dimension(860, 530));
        setSize(new java.awt.Dimension(860, 530));

        bg_pan.setBackground(new java.awt.Color(204, 204, 255));

        data_pan.setBackground(new java.awt.Color(204, 204, 204));
        data_pan.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DATABASE", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Miriam Fixed", 1, 20), new java.awt.Color(255, 255, 255))); // NOI18N
        data_pan.setMaximumSize(new java.awt.Dimension(445, 840));
        data_pan.setMinimumSize(new java.awt.Dimension(445, 840));
        data_pan.setPreferredSize(new java.awt.Dimension(445, 840));

        tbl_database.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tbl_databaseMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_database);
        if (tbl_database.getColumnModel().getColumnCount() > 0) {
            tbl_database.getColumnModel().getColumn(0).setResizable(false);
            tbl_database.getColumnModel().getColumn(1).setResizable(false);
            tbl_database.getColumnModel().getColumn(2).setResizable(false);
            tbl_database.getColumnModel().getColumn(3).setResizable(false);
            tbl_database.getColumnModel().getColumn(4).setResizable(false);
            tbl_database.getColumnModel().getColumn(5).setResizable(false);
        }

        javax.swing.GroupLayout data_panLayout = new javax.swing.GroupLayout(data_pan);
        data_pan.setLayout(data_panLayout);
        data_panLayout.setHorizontalGroup(
            data_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(data_panLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        data_panLayout.setVerticalGroup(
            data_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(data_panLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_search, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
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

        btn_retrieve.setBackground(new java.awt.Color(204, 204, 255));
        btn_retrieve.setFont(new java.awt.Font("Miriam", 0, 20)); // NOI18N
        btn_retrieve.setText("Retrieve Record");
        btn_retrieve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_retrieveActionPerformed(evt);
            }
        });

        header_pan.setBackground(new java.awt.Color(0, 0, 153));
        header_pan.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lbl_icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/partNumbering_generator/xepto logo - white bg.png"))); // NOI18N

        lbl_header.setFont(new java.awt.Font("Miriam Fixed", 1, 35)); // NOI18N
        lbl_header.setForeground(new java.awt.Color(255, 255, 255));
        lbl_header.setText("Deleted Part Numbers");

        javax.swing.GroupLayout header_panLayout = new javax.swing.GroupLayout(header_pan);
        header_pan.setLayout(header_panLayout);
        header_panLayout.setHorizontalGroup(
            header_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(header_panLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_icon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        header_panLayout.setVerticalGroup(
            header_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(header_panLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(header_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbl_icon)
                    .addComponent(lbl_header))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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
                        .addComponent(btn_retrieve, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(header_pan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(data_pan, javax.swing.GroupLayout.DEFAULT_SIZE, 907, Short.MAX_VALUE))
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
                .addGroup(bg_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_retrieve, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18))
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

    private void btn_retrieveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_retrieveActionPerformed
        //new view_database().setVisible(true);
    }//GEN-LAST:event_btn_retrieveActionPerformed

    private void tbl_databaseMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_databaseMouseReleased
        partNumber.clear();
        
        selectedRowCount = tbl_database.getSelectedRowCount();
        row = tbl_database.getSelectedRows();
        for(int i=0; i<row.length; i++){
            if (tbl_database.getRowSorter()!=null) {
                row[i] = tbl_database.getRowSorter().convertRowIndexToModel(row[i]);
            }
            partNumber.add(tbl_database.getModel().getValueAt(row[i], 0).toString());
            System.out.println(row[i]);
        }
    }//GEN-LAST:event_tbl_databaseMouseReleased

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
            java.util.logging.Logger.getLogger(trash_pn_db.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(trash_pn_db.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(trash_pn_db.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(trash_pn_db.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new trash_pn_db().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg_pan;
    private javax.swing.JButton btn_retrieve;
    private javax.swing.JButton btn_search;
    private javax.swing.JPanel data_pan;
    private javax.swing.JPanel header_pan;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_header;
    private javax.swing.JLabel lbl_icon;
    private javax.swing.JTable tbl_database;
    private javax.swing.JTextField txt_search;
    // End of variables declaration//GEN-END:variables
}
