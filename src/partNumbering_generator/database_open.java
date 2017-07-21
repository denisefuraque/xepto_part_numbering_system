
package partNumbering_generator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class database_open extends javax.swing.JFrame {

    Connection con;
    Statement stmt;
    ResultSet rs;
    
    String comCode_col;
    String comName_col;
    
    DefaultTableModel dtm = new DefaultTableModel(0, 0);
    
    String pn, cat, pn1, cat1;
    
    String host_address = Host.getHost();
    
    public database_open(String partNum, String category) throws SQLException {
        
        initComponents();
        
        this.setIconImage(new ImageIcon(getClass().getResource("xepto logo - white bg - x.jpg")).getImage()); 
        
        this.pn = partNum;
        this.cat = category;
        
        txt_partNum.setText(pn);
        txt_cat.setText(cat);
        
        pn1 = pn;
        cat1 = cat;
        
        setLocationRelativeTo(null);
        
        DoConnect();
        
    }

    public void DoConnect() throws SQLException{
        
        try{
            //Connect to the database
            
            String host = "jdbc:derby://" + host_address + "/partNumbering  ";
            String username = "Admin01";
            String password = "07032017";
            con = DriverManager.getConnection(host, username, password);
            
            //Execute some sql and load the records into the resultset
            
            Statement stmt1 = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String sql = "SELECT * FROM PART_NUMBER_DATA";
            rs = stmt1.executeQuery(sql);
            
            //move the cursor the first record
            
            rs.next();
        
        }
        catch(SQLException err){
            JOptionPane.showMessageDialog(database_open.this, err.getMessage());
        }
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        partNumberingPUEntityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("partNumberingPU").createEntityManager();
        partNumberDataQuery = java.beans.Beans.isDesignTime() ? null : partNumberingPUEntityManager.createQuery("SELECT p FROM PartNumberData p");
        partNumberDataList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : partNumberDataQuery.getResultList();
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
        header_pan = new javax.swing.JPanel();
        lbl_icon = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setTitle("Save Record (Admin) - Part Number Generator");
        setMaximumSize(new java.awt.Dimension(700, 600));
        setMinimumSize(new java.awt.Dimension(700, 600));
        setPreferredSize(new java.awt.Dimension(700, 600));
        setResizable(false);
        setSize(new java.awt.Dimension(700, 600));

        bg_pan.setBackground(new java.awt.Color(204, 204, 255));
        bg_pan.setMaximumSize(new java.awt.Dimension(700, 535));
        bg_pan.setMinimumSize(new java.awt.Dimension(700, 535));

        database_pan.setBackground(new java.awt.Color(204, 204, 204));
        database_pan.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DATABASE", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Miriam Fixed", 1, 20), new java.awt.Color(255, 255, 255))); // NOI18N

        tbl_database.setModel(dtm);

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, partNumberDataList, tbl_database);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${partNumber}"));
        columnBinding.setColumnName("Part Number");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${category}"));
        columnBinding.setColumnName("Category");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${description}"));
        columnBinding.setColumnName("Description");
        columnBinding.setColumnClass(String.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
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
            .addGroup(database_panLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                .addContainerGap())
        );

        information_pan.setBackground(new java.awt.Color(204, 204, 204));
        information_pan.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "INFORMATION", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Miriam Fixed", 1, 20), new java.awt.Color(255, 255, 255))); // NOI18N

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

        javax.swing.GroupLayout information_panLayout = new javax.swing.GroupLayout(information_pan);
        information_pan.setLayout(information_panLayout);
        information_panLayout.setHorizontalGroup(
            information_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(information_panLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(information_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbl_description)
                    .addComponent(lbl_partNumber)
                    .addComponent(lbl_category))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(information_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addComponent(txt_cat)
                    .addComponent(txt_partNum))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, information_panLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_save, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
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
                .addGroup(information_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(information_panLayout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(lbl_category))
                    .addGroup(information_panLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_save)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                    .addComponent(information_pan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        bg_panLayout.setVerticalGroup(
            bg_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bg_panLayout.createSequentialGroup()
                .addGap(0, 12, Short.MAX_VALUE)
                .addComponent(header_pan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(database_pan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(information_pan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
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

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveActionPerformed
        

        try{

            rs.moveToInsertRow();
            
            rs.updateString("part_number", txt_partNum.getText());
            rs.updateString("category", txt_cat.getText());
            rs.updateString("description", txt_des.getText());
            
            rs.insertRow();
            rs.moveToCurrentRow();
            
            Vector row = new Vector();
            row.add(txt_partNum.getText());
            row.add(txt_cat.getText());
            row.add(txt_des.getText());
            dtm.addRow(row);
            dtm.fireTableDataChanged();
            
            btn_save.setVisible(false);
        
        }
        catch(SQLException err){
            JOptionPane.showMessageDialog(null, "Similar Part Number! Try Again.", "alert", JOptionPane.ERROR_MESSAGE);
            
            this.setVisible(false);
            txt_partNum.setText("");
            txt_cat.setText("");
            txt_des.setText("");
            
            System.out.println(err.getMessage());
        }
        finally{
            if(con != null)
                  try{
                      this.con.close(); 
                  }catch(SQLException e){
                      System.out.println("PreparedStatement close problem");
                  }
            if(con != null)
                  try{
                      this.con.close();
                  }catch(SQLException e){
                      System.out.println("Database Connection close problem");
                }
        }
        
        txt_partNum.setText("");
        txt_cat.setText("");
        txt_des.setText("");
        this.setVisible(false);
        
    }//GEN-LAST:event_btn_saveActionPerformed

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
            java.util.logging.Logger.getLogger(database_open.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(database_open.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(database_open.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(database_open.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new database_open(null, null).setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(database_open.class.getName()).log(Level.SEVERE, null, ex);
            }
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
    private javax.swing.JLabel lbl_partNumber;
    private java.util.List<partNumbering_generator.PartNumberData> partNumberDataList;
    private javax.persistence.Query partNumberDataQuery;
    private javax.persistence.EntityManager partNumberingPUEntityManager;
    private javax.swing.JTable tbl_database;
    private javax.swing.JTextField txt_cat;
    private javax.swing.JTextArea txt_des;
    private javax.swing.JTextField txt_partNum;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
