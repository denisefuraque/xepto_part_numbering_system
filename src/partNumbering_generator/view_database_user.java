
package partNumbering_generator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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

public class view_database_user extends javax.swing.JFrame {

    DefaultTableModel model = new DefaultTableModel(){
        @Override
        public boolean isCellEditable(int row, int column){
            return false;
        }
    };
    
    ArrayList<Class_data> dataList = new ArrayList<>();
    
    String host_address = Host.getHost();
    
    EntityManager em;
    
    public view_database_user() {
        
        initComponents();
        
        try{
            em = Persistence.createEntityManagerFactory("partNumberingPU", Host.getPersistence()).createEntityManager();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.toString());
        }   
        
        this.setIconImage(new ImageIcon(getClass().getResource("xepto logo - white bg - x.jpg")).getImage()); 
        
        setLocationRelativeTo(null);
        
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
    }

    //function to return arraylist with particular data
    public ArrayList<Class_data> ListClass_Data(String ValToSearch){
        try{
            Class_data data;
            
            Query q = em.createNamedQuery("PartNumberData.findAll");
            List<PartNumberData> pnd = q.getResultList();
            for(PartNumberData d: pnd){
                data = new Class_data(
                                    d.getPartNumber(),
                                    d.getCategory(),
                                    d.getDescription(),
                                    d.getGeneratedDate(),
                                    d.getAuthor(),
                                    d.getConfiguration()
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
        ArrayList<Class_data> data = ListClass_Data(txt_search.getText());
        model.setColumnIdentifiers(new Object[]{"Part Number", "Category", "Description", "Generated Date", "Author", "Configuration"});
        Object[] row = new Object[6];
        
        for (int i = 0; i < data.size(); i++){
            row[0] = data.get(i).getPn();
            row[1] = data.get(i).getCat();
            row[2] = data.get(i).getDes();
            row[3] = data.get(i).getDate();
            row[4] = data.get(i).getAut();
            row[5] = data.get(i).getConfig();
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
        btn_export = new javax.swing.JButton();

        setTitle("View Database (User) - Part Number Generator");

        bg_pan.setBackground(new java.awt.Color(204, 204, 255));

        data_pan.setBackground(new java.awt.Color(204, 204, 204));
        data_pan.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DATABASE", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Miriam Fixed", 1, 20), new java.awt.Color(255, 255, 255))); // NOI18N
        data_pan.setMaximumSize(new java.awt.Dimension(445, 840));
        data_pan.setMinimumSize(new java.awt.Dimension(445, 840));

        tbl_database.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
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
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addComponent(txt_search, javax.swing.GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE)
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

        jLabel1.setFont(new java.awt.Font("Miriam Fixed", 1, 35)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("View Database (User)");

        javax.swing.GroupLayout header_panLayout = new javax.swing.GroupLayout(header_pan);
        header_pan.setLayout(header_panLayout);
        header_panLayout.setHorizontalGroup(
            header_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(header_panLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_icon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 522, Short.MAX_VALUE)
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

        btn_export.setBackground(new java.awt.Color(204, 204, 255));
        btn_export.setFont(new java.awt.Font("Miriam", 0, 20)); // NOI18N
        btn_export.setText("Export to CSV");
        btn_export.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_exportActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout bg_panLayout = new javax.swing.GroupLayout(bg_pan);
        bg_pan.setLayout(bg_panLayout);
        bg_panLayout.setHorizontalGroup(
            bg_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bg_panLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bg_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(data_pan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(header_pan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(bg_panLayout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_export, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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
                    .addComponent(btn_export, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void btn_exportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_exportActionPerformed
        exportToCSV ex = new exportToCSV();
        ex.export();
        JOptionPane.showMessageDialog(this, "CSV File is created successfully.");
    }//GEN-LAST:event_btn_exportActionPerformed

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
            java.util.logging.Logger.getLogger(view_database_user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(view_database_user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(view_database_user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(view_database_user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new view_database_user().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg_pan;
    private javax.swing.JButton btn_export;
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
