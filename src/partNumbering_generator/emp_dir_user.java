
package partNumbering_generator;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
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
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class emp_dir_user extends javax.swing.JFrame {

    DefaultTableModel model = new DefaultTableModel(){
        @Override
        public boolean isCellEditable(int row, int column){
            return false;
        }
    };
    
    ArrayList<class_user> dataList = new ArrayList<>();
    ArrayList<String> datapass = new ArrayList<>();
    
    String pWord;
    
    Connection con = null;
    Statement st;
    ResultSet rs;
    
    Connection conn = null;
    Statement stmnt;
    ResultSet reSet;
    
    String value1 = "", value2 = "", value3 = "", value4 = "";
    String rowPass = "";
    
    int curRow = 0;
    
    public emp_dir_user() {
        
        initComponents();

        this.setIconImage(new ImageIcon(getClass().getResource("xepto logo - white bg - x.jpg")).getImage()); 
        
        setLocationRelativeTo(null);
        
        //call function
        findData();
        user();
        
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

    //delete data
    private void btn_delete_confirmationActionPerformed(java.awt.event.ActionEvent evt){
        
        Object[] options = { "Yes", "No"};
        
        int n = JOptionPane.showOptionDialog(this, "If you click YES, you won't be able to undo this DELETE operation \n\nAre you sure you want to DELETE this record?", "You are about to DELETE a RECORD!!", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
        
        switch (n){
            case 0:
                Connection connect = null;
                Statement state = null;
                ResultSet result = null; 
                try{
                    connect = DriverManager.getConnection("jdbc:derby://localhost/partNumbering  ", "Admin01", "07032017");
                    state = connect.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                    String query = "SELECT * FROM EMPLOYEE";
                    result = state.executeQuery(query);
                    
                    int SelectedRowIndex = tbl_database.getSelectedRow();
                    if (tbl_database.getRowSorter()!=null) {
                        SelectedRowIndex = tbl_database.getRowSorter().convertRowIndexToModel(SelectedRowIndex);
                    }
                    model.removeRow(SelectedRowIndex);
                    curRow = SelectedRowIndex + 1;
                    result.absolute(curRow);
                    result.deleteRow();
                }
                catch(Exception ex){
                    System.out.println(ex.getMessage());
                }
                finally{
                    if(result != null){
                        try{
                            result.close();
                        }
                        catch (SQLException e) { /* ignored */}
                    }
                    if(state != null){
                        try{
                            state.close();
                        }
                        catch (SQLException e) { /* ignored */}
                    }
                    if(connect != null){
                        try{
                            connect.close();
                        }
                        catch (SQLException e) { /* ignored */}
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
            con = DriverManager.getConnection("jdbc:derby://localhost/partNumbering  " ,"Admin01","07032017");
        }
        catch(SQLException ex){
                  System.out.println(ex.getMessage());
        }
        return con;
    }

    //function to return arraylist with particular data
    public ArrayList<class_user> ListClass_Data(String ValToSearch){
        
        try{
            con = getConnection();
            st= con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String searchQuery = "SELECT * FROM EMPLOYEE WHERE ('username' || 'password' || 'first_name' || 'last_name' || 'job_title') LIKE '%" + ValToSearch + "%'";
            rs = st.executeQuery(searchQuery);
            
            class_user data;
            
            while(rs.next()){
                data = new class_user(
                                    rs.getString("username"),
                                    rs.getString("first_name"),
                                    rs.getString("last_name"),
                                    rs.getString("job_title"),
                                    rs.getString("password")
                                     );
                dataList.add(data);
            }
        }        
        catch(SQLException ex){
                System.out.println(ex.getMessage());
                }
        finally {
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
        return dataList;
    }
    
    //function to Display data in JTable
    public void findData(){
        ArrayList<class_user> data = ListClass_Data(txt_search.getText());
        model.setColumnIdentifiers(new Object[]{"Username", "First Name", "Last Name", "Job"});
        Object[] row = new Object[4];
        
        for (int i = 0; i < data.size(); i++){
            row[0] = data.get(i).getUname();
            row[1]= data.get(i).getFname();
            row[2] = data.get(i).getLname();
            row[3] = data.get(i).getJob();
            model.addRow(row);
        }
        tbl_database.setModel(model);
    }
    
    public void user(){
            try{
                String host = "jdbc:derby://localhost/partNumbering  ";
                String username = "Admin01";
                String password = "07032017";
                //Execute some sql and load the records into the resultset
                try (Connection con0 = DriverManager.getConnection(host, username, password)) {
                    //Execute some sql and load the records into the resultset
                    
                    Statement stmt0 = con0.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE );
                    String sql = "SELECT * FROM EMPLOYEE";
                    //getting the data for the external
                    try (ResultSet rs0 = stmt0.executeQuery(sql)) {
                        //getting the data for the external
                        
                        while(rs0.next()){
                            
                            pWord = rs0.getString("password");
                            
                            //populating arraylist with data from the database
                            
                            datapass.add(pWord);
                            
                        }
                        rs0.close();
                        stmt0.closeOnCompletion();
                        con0.close();
                    }
                }
            }
            catch(SQLException err){
                JOptionPane.showMessageDialog(this, err.getMessage());
            }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        partNumberingPUEntityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("partNumberingPU").createEntityManager();
        employeeQuery = java.beans.Beans.isDesignTime() ? null : partNumberingPUEntityManager.createQuery("SELECT e FROM Employee e");
        employeeList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : employeeQuery.getResultList();
        bg_pan = new javax.swing.JPanel();
        data_pan = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_database = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        txt_search = new javax.swing.JTextField();
        btn_search = new javax.swing.JButton();
        header_pan = new javax.swing.JPanel();
        lbl_icon = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btn_delete = new javax.swing.JButton();
        btn_save = new javax.swing.JButton();

        setTitle("Employee Directory - User - Part Number Generator");

        bg_pan.setBackground(new java.awt.Color(204, 204, 255));

        data_pan.setBackground(new java.awt.Color(204, 204, 204));
        data_pan.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DATABASE", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Miriam Fixed", 1, 20), new java.awt.Color(255, 255, 255))); // NOI18N
        data_pan.setMaximumSize(new java.awt.Dimension(445, 840));
        data_pan.setMinimumSize(new java.awt.Dimension(445, 840));

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, employeeList, tbl_database);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${username}"));
        columnBinding.setColumnName("Username");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${firstName}"));
        columnBinding.setColumnName("First Name");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${lastName}"));
        columnBinding.setColumnName("Last Name");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${jobTitle}"));
        columnBinding.setColumnName("Job Title");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        tbl_database.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbl_databaseMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_database);
        if (tbl_database.getColumnModel().getColumnCount() > 0) {
            tbl_database.getColumnModel().getColumn(0).setResizable(false);
            tbl_database.getColumnModel().getColumn(1).setResizable(false);
            tbl_database.getColumnModel().getColumn(2).setResizable(false);
            tbl_database.getColumnModel().getColumn(3).setResizable(false);
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        jLabel1.setText("Employee Directory-User");

        javax.swing.GroupLayout header_panLayout = new javax.swing.GroupLayout(header_pan);
        header_pan.setLayout(header_panLayout);
        header_panLayout.setHorizontalGroup(
            header_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(header_panLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_icon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 504, Short.MAX_VALUE)
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

        btn_delete.setBackground(new java.awt.Color(204, 204, 255));
        btn_delete.setFont(new java.awt.Font("Miriam", 0, 20)); // NOI18N
        btn_delete.setText("Delete Account");
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });

        btn_save.setBackground(new java.awt.Color(204, 204, 255));
        btn_save.setFont(new java.awt.Font("Miriam", 0, 20)); // NOI18N
        btn_save.setText("Move to Admin");
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
                    .addComponent(data_pan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(header_pan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(bg_panLayout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(bg_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_delete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_save, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_searchActionPerformed
        
    }//GEN-LAST:event_btn_searchActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed

    }//GEN-LAST:event_btn_deleteActionPerformed

    private void btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveActionPerformed
        Object[] options = { "Yes", "No"};

        int opt = JOptionPane.showOptionDialog(this, "If you click YES, the data will be SAVED in the main database \n\tand it will be DELETED in this database permanently.\n\nAre you sure you want to SAVE this record?", "You are about to SAVE a RECORD!!", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);

        switch(opt){

            case 0:

            try{
                conn = DriverManager.getConnection("jdbc:derby://localhost/partNumbering  ", "Admin01", "07032017");
                stmnt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                String querySql = "SELECT * FROM ADMINS";
                reSet = stmnt.executeQuery(querySql);

                reSet.next();

                reSet.moveToInsertRow();

                reSet.updateString("username", value1);
                reSet.updateString("password", rowPass);
                reSet.updateString("first_name", value2);
                reSet.updateString("last_name", value3);
                reSet.updateString("job_title", value4);

                reSet.insertRow();
                reSet.moveToCurrentRow();

                Vector row = new Vector();
                row.add(value1);
                row.add(value2);
                row.add(value3);
                row.add(value4);

            }
            catch(Exception ex){
                System.out.println(ex.getMessage());
            }
            finally {
                if (reSet != null) {
                    try {
                        reSet.close();
                    } catch (SQLException e) { /* ignored */}
                }
                if (stmnt != null) {
                    try {
                        stmnt.close();
                    } catch (SQLException e) { /* ignored */}
                }
                if (conn != null) {
                    try {
                        conn.close();
                    } catch (SQLException e) { /* ignored */}
                }
            }
            Connection connect = null;
            Statement state = null;
            ResultSet result = null;
            try{
                connect = DriverManager.getConnection("jdbc:derby://localhost/partNumbering  ", "Admin01", "07032017");
                connect = getConnection();
                state = connect.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                String query = "SELECT * FROM EMPLOYEE";
                result = state.executeQuery(query);

                int SelectedRowIndex = tbl_database.getSelectedRow();
                if (tbl_database.getRowSorter()!=null)
                    SelectedRowIndex = tbl_database.getRowSorter().convertRowIndexToModel(SelectedRowIndex);
                model.removeRow(SelectedRowIndex);
                curRow = SelectedRowIndex + 1;
                result.absolute(curRow);
                result.deleteRow();
            }
            catch(Exception ex){
                System.out.println(ex.getMessage());
            }
            finally{
                if(result != null){
                    try{
                        result.close();
                    }
                    catch (SQLException e) { /* ignored */}
                }
                if(state != null){
                    try{
                        state.close();
                    }
                    catch (SQLException e) { /* ignored */}
                }
                if(connect != null){
                    try{
                        connect.close();
                    }
                    catch (SQLException e) { /* ignored */}
                }
            }
            break;

            case 1:
            break;

        }
    }//GEN-LAST:event_btn_saveActionPerformed

    private void tbl_databaseMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_databaseMousePressed
        int row = tbl_database.getSelectedRow();
        if (tbl_database.getRowSorter()!=null) {
            row = tbl_database.getRowSorter().convertRowIndexToModel(row);
        }
        value1 = tbl_database.getModel().getValueAt(row, 0).toString();
        value2 = tbl_database.getModel().getValueAt(row, 1).toString();
        value3 = tbl_database.getModel().getValueAt(row, 2).toString();
        value4 = tbl_database.getModel().getValueAt(row, 3).toString();
        
        rowPass = dataList.get(row).getPword();
    }//GEN-LAST:event_tbl_databaseMousePressed

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
            java.util.logging.Logger.getLogger(emp_dir_user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(emp_dir_user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(emp_dir_user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(emp_dir_user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new emp_dir_user().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg_pan;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_save;
    private javax.swing.JButton btn_search;
    private javax.swing.JPanel data_pan;
    private java.util.List<partNumbering_generator.Employee> employeeList;
    private javax.persistence.Query employeeQuery;
    private javax.swing.JPanel header_pan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_icon;
    private javax.persistence.EntityManager partNumberingPUEntityManager;
    private javax.swing.JTable tbl_database;
    private javax.swing.JTextField txt_search;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
