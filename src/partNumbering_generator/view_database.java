package partNumbering_generator;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public final class view_database extends javax.swing.JFrame {
    
    DefaultTableModel model = new DefaultTableModel(){
        @Override
        public boolean isCellEditable(int row, int column){
            return false;
        }
    };
    
    ArrayList<Class_data> dataList = new ArrayList<>();
    
    Connection con = null, con1 = null;
    Statement st, st1;
    ResultSet rs, rs1;
    
    int curRow = 0;
    
    public view_database() {
        initComponents();
        
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
        btn_delete.addActionListener(this::btn_delete_confirmationActionPerformed);
    }
    
    //opens a joptionpane to confirm whether the user is sure to delete the record
    private void btn_delete_confirmationActionPerformed(java.awt.event.ActionEvent evt){
        
        Object[] options = {"Yes",
                            "No"};
        int n = JOptionPane.showOptionDialog(this, "If you click YES, you won't be able to undo this Delete operation \n\nAre you sure you want to delete? ","You are about to DELETE a Record!",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE,null, options, options[0]);
        
        switch (n){
            case 0:
                try{
                    con = DriverManager.getConnection("jdbc:derby://localhost/partNumbering  " ,"Admin01","07032017");
                    con = getConnection();
                    st= con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                    String searchQuery = "SELECT * FROM PART_NUMBER_DATA";
                    rs = st.executeQuery(searchQuery);
                    
                    int SelectedRowIndex = tbl_database.getSelectedRow();
                    model.removeRow(SelectedRowIndex);
                    curRow = SelectedRowIndex + 1;
                    rs.absolute(curRow);
                    rs.deleteRow();
                    //rs.previous();
                }
                catch(Exception ex){
                   System.out.println(ex.getMessage());
               }finally {
                    if (rs != null) {
                        try {
                            rs.close();
                        } catch (SQLException e) { /* ignored */}
                    }
                    if (st != null) {
                        try {
                            st.close();
                        } catch (SQLException e) { /* ignored */}
                    }
                    if (con != null) {
                        try {
                            con.close();
                        } catch (SQLException e) { /* ignored */}
                    }
                }
                break;
                
            case 1:
                break;
        }
    
    }
    
    //function to connect sql
    public Connection getConnection(){
        
        try{
            con1 = DriverManager.getConnection("jdbc:derby://localhost/partNumbering  " ,"Admin01","07032017");
        }
        catch(SQLException ex){
                  System.out.println(ex.getMessage());
        }
        return con1;
    }

    //function to return arraylist with particular data
    public ArrayList<Class_data> ListClass_Data(String ValToSearch){
        
        try{
            con1 = getConnection();
            st1= con1.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String searchQuery1 = "SELECT* FROM PART_NUMBER_DATA WHERE ('part_number' || 'category' || 'description') LIKE '%" + ValToSearch + "%'";
            rs1 = st1.executeQuery(searchQuery1);
            
            Class_data data;
            
            while(rs1.next()){
                data = new Class_data(
                                    rs1.getString("part_number"),
                                    rs1.getString("category"),
                                    rs1.getString("description")
                                     );
                dataList.add(data);
            }
        }        
        catch(SQLException ex){
                System.out.println(ex.getMessage());
                }
        finally {
            if (rs1 != null) {
                try {
                    rs1.close();
                } catch (SQLException e) { /* ignored */}
            }
            if (st1 != null) {
                try {
                    st1.close();
                } catch (SQLException e) { /* ignored */}
            }
            if (con1 != null) {
                try {
                    con1.close();
                } catch (SQLException e) { /* ignored */}
            }
        }
        return dataList;
    }
    
    //function to Display data in JTable
    public void findData(){
        ArrayList<Class_data> data = ListClass_Data(txt_search.getText());
        model.setColumnIdentifiers(new Object[]{"Part_Number", "Category", "Description"});
        Object[] row = new Object[4];
        
        for (int i = 0; i < data.size(); i++){
            row[0] = data.get(i).getPn();
            row[1]= data.get(i).getCat();
            row[2] = data.get(i).getDes();
            model.addRow(row);
        }
        tbl_database.setModel(model);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        partNumberingPUEntityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("partNumberingPU").createEntityManager();
        partNumberDataQuery = java.beans.Beans.isDesignTime() ? null : partNumberingPUEntityManager.createQuery("SELECT p FROM PartNumberData p");
        partNumberDataList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : partNumberDataQuery.getResultList();
        bg_pan = new javax.swing.JPanel();
        data_pan = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_database = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        txt_search = new javax.swing.JTextField();
        btn_search = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        header_pan = new javax.swing.JPanel();
        lbl_icon = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setTitle("View Database (Admin) - Part Number Generator");
        setMaximumSize(new java.awt.Dimension(860, 530));
        setMinimumSize(new java.awt.Dimension(860, 530));
        setSize(new java.awt.Dimension(860, 530));

        bg_pan.setBackground(new java.awt.Color(204, 204, 255));

        data_pan.setBackground(new java.awt.Color(204, 204, 204));
        data_pan.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DATABASE", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Miriam Fixed", 1, 20), new java.awt.Color(255, 255, 255))); // NOI18N
        data_pan.setMaximumSize(new java.awt.Dimension(445, 840));
        data_pan.setMinimumSize(new java.awt.Dimension(445, 840));
        data_pan.setPreferredSize(new java.awt.Dimension(445, 840));

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
        if (tbl_database.getColumnModel().getColumnCount() > 0) {
            tbl_database.getColumnModel().getColumn(0).setResizable(false);
            tbl_database.getColumnModel().getColumn(1).setResizable(false);
            tbl_database.getColumnModel().getColumn(2).setResizable(false);
        }

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
                .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_search, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
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

        btn_delete.setBackground(new java.awt.Color(204, 204, 255));
        btn_delete.setFont(new java.awt.Font("Miriam", 0, 20)); // NOI18N
        btn_delete.setText("Delete Record");
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });

        header_pan.setBackground(new java.awt.Color(0, 0, 153));
        header_pan.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lbl_icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/partNumbering_generator/xepto logo - white bg.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Miriam Fixed", 1, 35)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("View Database (Admin)");

        javax.swing.GroupLayout header_panLayout = new javax.swing.GroupLayout(header_pan);
        header_pan.setLayout(header_panLayout);
        header_panLayout.setHorizontalGroup(
            header_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(header_panLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_icon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 493, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addGroup(bg_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(data_pan, javax.swing.GroupLayout.DEFAULT_SIZE, 840, Short.MAX_VALUE)
                    .addGroup(bg_panLayout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_delete, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE))
                    .addComponent(header_pan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                    .addComponent(btn_delete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        //new view_database().setVisible(true);
    }//GEN-LAST:event_btn_deleteActionPerformed

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
            java.util.logging.Logger.getLogger(view_database.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(view_database.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(view_database.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(view_database.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new view_database().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg_pan;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_search;
    private javax.swing.JPanel data_pan;
    private javax.swing.JPanel header_pan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_icon;
    private java.util.List<partNumbering_generator.PartNumberData> partNumberDataList;
    private javax.persistence.Query partNumberDataQuery;
    private javax.persistence.EntityManager partNumberingPUEntityManager;
    private javax.swing.JTable tbl_database;
    private javax.swing.JTextField txt_search;
    // End of variables declaration//GEN-END:variables
}
