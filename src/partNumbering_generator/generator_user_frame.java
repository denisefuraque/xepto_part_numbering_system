
package partNumbering_generator;

import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Box;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public final class generator_user_frame extends javax.swing.JFrame {

    int curRow = 0;
    ArrayList<String> ext_name, ext_code;
    ArrayList<String> intPro_name, intPro_code;
    ArrayList<String> intSpec_name, intSpec_code;
    ArrayList<String> intRep_name, intRep_code;
    ArrayList<String> mechPart_name, mechPart_code;
    ArrayList<String> compPeri_name, compPeri_code;
    ArrayList<String> elecPart_name, elecPart_code;
    ArrayList<String> netPart_name, netPart_code;
    ArrayList<String> conPart_name, conPart_code;
    
    String comCode_col;
    String comName_col;
    
    String commodity_code;
    String yearTextArea;
    String yearText;
    String monthText;
    String dayText;
    
    int tempInt = 0000;
    
    String host_address = Host.getHost();
    
    public generator_user_frame() {
        initComponents();
        
        setLocationRelativeTo(null);
        
        this.setIconImage(new ImageIcon(getClass().getResource("xepto logo - white bg - x.jpg")).getImage()); 
        
        DoConnect_external();
        DoConnect_intPro();
        DoConnect_intSpec();
        DoConnect_intRep();
        DoConnect_mechPart();
        DoConnect_compPeri();
        DoConnect_elecPart(); 
        DoConnect_netPart();
        DoConnect_conPart();
        
        cmb_scheme.setSelectedIndex(0);
        
    }
    
    public void DoConnect_external(){
            
            //reads the database
            
            ext_name = new ArrayList<>();
            ext_code = new ArrayList<>();

            try{
                //Connect to the database - External Released Commodity

                String host = "jdbc:derby://" + host_address + "/partNumbering  ";
                String username = "Admin01";
                String password = "07032017";
                //Execute some sql and load the records into the resultset
                try (Connection con0 = DriverManager.getConnection(host, username, password)) {
                    //Execute some sql and load the records into the resultset
                    
                    Statement stmt0 = con0.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE );
                    String sql = "SELECT * FROM EXTERNAL_RELEASED_DOCUMENTS";
                    //getting the data for the external
                    try (ResultSet rs0 = stmt0.executeQuery(sql)) {
                        //getting the data for the external
                        
                        while(rs0.next()){
                            
                            comCode_col = rs0.getString("commodity_code");
                            comName_col = rs0.getString("commodity_name");
                            
                            //populating arraylist with data from the database
                            
                            ext_name.add(comName_col);
                            ext_code.add(comCode_col);
                            
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
    
    public void DoConnect_intPro(){
            
            //reads the database
            
            intPro_name = new ArrayList<>();
            intPro_code = new ArrayList<>();

            try{
                //Connect to the database - External Released Commodity

                String host = "jdbc:derby://" + host_address + "/partNumbering  ";
                String username = "Admin01";
                String password = "07032017";
                //Execute some sql and load the records into the resultset
                try (Connection con1 = DriverManager.getConnection(host, username, password)) {
                    //Execute some sql and load the records into the resultset
                    
                    Statement stmt1 = con1.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE );
                    String sql = "SELECT * FROM INTERNAL_PROCESS_DOCUMENT";
                    ResultSet rs1 = stmt1.executeQuery(sql);
                    
                    //getting the data for the external
                    
                    while(rs1.next()){
                        
                        comCode_col = rs1.getString("commodity_code");
                        comName_col = rs1.getString("commodity_name");
                        
                        //populating arraylist with data from the database
                        
                        intPro_name.add(comName_col);
                        intPro_code.add(comCode_col);
                        
                    }
                    
                    stmt1.closeOnCompletion();
                    rs1.close();
                }

            }
            catch(SQLException err){
                JOptionPane.showMessageDialog(this, err.getMessage());
            }

    }
    
    public void DoConnect_intSpec(){
            
            //reads the database
            
            intSpec_name = new ArrayList<>();
            intSpec_code = new ArrayList<>();

            try{
                //Connect to the database - External Released Commodity

                String host = "jdbc:derby://" + host_address + "/partNumbering  ";
                String username = "Admin01";
                String password = "07032017";
                //Execute some sql and load the records into the resultset
                try (Connection con2 = DriverManager.getConnection(host, username, password)) {
                    //Execute some sql and load the records into the resultset
                    
                    Statement stmt2 = con2.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE );
                    String sql = "SELECT * FROM INTERNAL_SPECIFICATION_DOCUMENT";
                    ResultSet rs2 = stmt2.executeQuery(sql);
                    
                    //getting the data for the external
                    
                    while(rs2.next()){
                        
                        comCode_col = rs2.getString("commodity_code");
                        comName_col = rs2.getString("commodity_name");
                        
                        //populating arraylist with data from the database
                        
                        intSpec_name.add(comName_col);
                        intSpec_code.add(comCode_col);
                        
                    }
                    
                    stmt2.closeOnCompletion();
                    rs2.close();
                }
                
            }
            catch(SQLException err){
                JOptionPane.showMessageDialog(this, err.getMessage());
            }

    }
    
    public void DoConnect_intRep(){
            
            //reads the database
            
            intRep_name = new ArrayList<>();
            intRep_code = new ArrayList<>();

            try{
                //Connect to the database - External Released Commodity

                String host = "jdbc:derby://" + host_address + "/partNumbering  ";
                String username = "Admin01";
                String password = "07032017";
                //Execute some sql and load the records into the resultset
                try (Connection con3 = DriverManager.getConnection(host, username, password)) {
                    //Execute some sql and load the records into the resultset
                    
                    Statement stmt3 = con3.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE );
                    String sql = "SELECT * FROM INTERNAL_REPORT_DOCUMENTS";
                    ResultSet rs3 = stmt3.executeQuery(sql);
                    
                    //getting the data for the external
                    
                    while(rs3.next()){
                        
                        comCode_col = rs3.getString("commodity_code");
                        comName_col = rs3.getString("commodity_name");
                        
                        //populating arraylist with data from the database
                        
                        intRep_name.add(comName_col);
                        intRep_code.add(comCode_col);
                        
                    }
                    
                    stmt3.closeOnCompletion();
                    rs3.close();
                }
                
            }
            catch(SQLException err){
                JOptionPane.showMessageDialog(this, err.getMessage());
            }

    }
    
    public void DoConnect_mechPart(){
            
            //reads the database
            
            mechPart_name = new ArrayList<>();
            mechPart_code = new ArrayList<>();

            try{
                //Connect to the database - External Released Commodity

                String host = "jdbc:derby://" + host_address + "/partNumbering  ";
                String username = "Admin01";
                String password = "07032017";
                //Execute some sql and load the records into the resultset
                try (Connection con4 = DriverManager.getConnection(host, username, password)) {
                    //Execute some sql and load the records into the resultset
                    
                    Statement stmt4 = con4.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE );
                    String sql = "SELECT * FROM MECHANICAL_PART_COMMODITY";
                    ResultSet rs4 = stmt4.executeQuery(sql);
                    
                    //getting the data for the external
                    
                    while(rs4.next()){
                        
                        comCode_col = rs4.getString("commodity_code");
                        comName_col = rs4.getString("commodity_name");
                        
                        //populating arraylist with data from the database
                        
                        mechPart_name.add(comName_col);
                        mechPart_code.add(comCode_col);
                        
                    }
                    
                    stmt4.closeOnCompletion();
                    rs4.close();
                }
                
            }
            catch(SQLException err){
                JOptionPane.showMessageDialog(this, err.getMessage());
            }

    }
    
    public void DoConnect_compPeri(){
            
            //reads the database
            
            compPeri_name = new ArrayList<>();
            compPeri_code = new ArrayList<>();

            try{
                //Connect to the database - External Released Commodity

                String host = "jdbc:derby://" + host_address + "/partNumbering  ";
                String username = "Admin01";
                String password = "07032017";
                //Execute some sql and load the records into the resultset
                try (Connection con5 = DriverManager.getConnection(host, username, password)) {
                    //Execute some sql and load the records into the resultset
                    
                    Statement stmt5 = con5.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE );
                    String sql = "SELECT * FROM COMPUTER_PERIPHERALS_COMMODITY";
                    ResultSet rs5 = stmt5.executeQuery(sql);
                    
                    //getting the data for the external
                    
                    while(rs5.next()){
                        
                        comCode_col = rs5.getString("commodity_code");
                        comName_col = rs5.getString("commodity_name");
                        
                        //populating arraylist with data from the database
                        
                        compPeri_name.add(comName_col);
                        compPeri_code.add(comCode_col);
                        
                    }
                    
                    stmt5.closeOnCompletion();
                    rs5.close();
                }
                
            }
            catch(SQLException err){
                JOptionPane.showMessageDialog(this, err.getMessage());
            }

    }
    
    public void DoConnect_elecPart(){
            
            //reads the database
            
            elecPart_name = new ArrayList<>();
            elecPart_code = new ArrayList<>();

            try{
                //Connect to the database - External Released Commodity

                String host = "jdbc:derby://" + host_address + "/partNumbering  ";
                String username = "Admin01";
                String password = "07032017";
                //Execute some sql and load the records into the resultset
                try (Connection con6 = DriverManager.getConnection(host, username, password)) {
                    //Execute some sql and load the records into the resultset
                    
                    Statement stmt6 = con6.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE );
                    String sql = "SELECT * FROM ELECTRICAL_PART_COMMODITY";
                    ResultSet rs6 = stmt6.executeQuery(sql);
                    
                    //getting the data for the external
                    
                    while(rs6.next()){
                        
                        comCode_col = rs6.getString("commodity_code");
                        comName_col = rs6.getString("commodity_name");
                        
                        //populating arraylist with data from the database
                        
                        elecPart_name.add(comName_col);
                        elecPart_code.add(comCode_col);
                        
                    }
                    
                    stmt6.closeOnCompletion();
                    rs6.close();
                }
            }
            catch(SQLException err){
                JOptionPane.showMessageDialog(this, err.getMessage());
            }

    }
    
    public void DoConnect_netPart(){
            
            //reads the database
            
            netPart_name = new ArrayList<>();
            netPart_code = new ArrayList<>();

            try{
                //Connect to the database - External Released Commodity

                String host = "jdbc:derby://" + host_address + "/partNumbering  ";
                String username = "Admin01";
                String password = "07032017";
                //Execute some sql and load the records into the resultset
                try (Connection con7 = DriverManager.getConnection(host, username, password)) {
                    //Execute some sql and load the records into the resultset
                    
                    Statement stmt7 = con7.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE );
                    String sql = "SELECT * FROM NETWORKING_PERIPHERAL_COMMODITY";
                    ResultSet rs7 = stmt7.executeQuery(sql);
                    
                    //getting the data for the external
                    
                    while(rs7.next()){
                        
                        comCode_col = rs7.getString("commodity_code");
                        comName_col = rs7.getString("commodity_name");
                        
                        //populating arraylist with data from the database
                        
                        netPart_name.add(comName_col);
                        netPart_code.add(comCode_col);
                        
                    }
                    
                    stmt7.closeOnCompletion();
                    rs7.close();
                }

            }
            catch(SQLException err){
                JOptionPane.showMessageDialog(this, err.getMessage());
            }

    }
    
    public void DoConnect_conPart(){
            
            //reads the database
            
            conPart_name = new ArrayList<>();
            conPart_code = new ArrayList<>();

            try{
                //Connect to the database - External Released Commodity

                String host = "jdbc:derby://" + host_address + "/partNumbering  ";
                String username = "Admin01";
                String password = "07032017";
                //Execute some sql and load the records into the resultset
                try (Connection con8 = DriverManager.getConnection(host, username, password)) {
                    //Execute some sql and load the records into the resultset
                    
                    Statement stmt8 = con8.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE );
                    String sql = "SELECT * FROM CONSUMABLE_PARTS";
                    ResultSet rs8 = stmt8.executeQuery(sql);
                    
                    //getting the data for the external
                    
                    while(rs8.next()){
                        
                        comCode_col = rs8.getString("commodity_code");
                        comName_col = rs8.getString("commodity_name");
                        
                        //populating arraylist with data from the database
                        
                        conPart_name.add(comName_col);
                        conPart_code.add(comCode_col);
                        
                    }
                    
                    stmt8.closeOnCompletion();
                    rs8.close();
                }

            }
            catch(SQLException err){
                JOptionPane.showMessageDialog(this, err.getMessage());
            }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg_pan = new javax.swing.JPanel();
        logo_pan = new javax.swing.JPanel();
        lbl_logo = new javax.swing.JLabel();
        lbl_png = new javax.swing.JLabel();
        input_pan = new javax.swing.JPanel();
        lbl_cateogry = new javax.swing.JLabel();
        cmb_name = new javax.swing.JComboBox<>();
        seq_pan = new javax.swing.JPanel();
        txt_seq = new javax.swing.JTextField();
        projDate_pan = new javax.swing.JPanel();
        txt_year = new javax.swing.JTextField();
        cmb_month = new javax.swing.JComboBox<>();
        cmb_day = new javax.swing.JComboBox<>();
        lbl_year = new javax.swing.JLabel();
        lbl_month = new javax.swing.JLabel();
        lbl_day = new javax.swing.JLabel();
        config_pan = new javax.swing.JPanel();
        txt_config = new javax.swing.JTextField();
        btn_generate = new javax.swing.JButton();
        cmb_scheme = new javax.swing.JComboBox<>();
        generated_pan = new javax.swing.JPanel();
        lbl_genPartNum = new javax.swing.JLabel();
        open_save_db_pan = new javax.swing.JPanel();
        btn_open_save = new javax.swing.JButton();
        btn_new = new javax.swing.JButton();
        btn_edit = new javax.swing.JButton();
        btn_check = new javax.swing.JButton();
        mnu_user_gen = new javax.swing.JMenuBar();
        mnu_uData = new javax.swing.JMenu();
        mnu_uData_view = new javax.swing.JMenuItem();
        mnu_uData_add = new javax.swing.JMenuItem();
        mnu_uAccount = new javax.swing.JMenu();
        mnu_uAccount_logout = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Part Numbering Generator - User");
        setMaximumSize(new java.awt.Dimension(800, 500));
        setMinimumSize(new java.awt.Dimension(800, 500));
        setResizable(false);
        setSize(new java.awt.Dimension(800, 500));

        bg_pan.setBackground(new java.awt.Color(204, 204, 255));
        bg_pan.setMaximumSize(new java.awt.Dimension(800, 500));
        bg_pan.setMinimumSize(new java.awt.Dimension(800, 500));
        bg_pan.setPreferredSize(new java.awt.Dimension(800, 500));

        logo_pan.setBackground(new java.awt.Color(0, 0, 102));
        logo_pan.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        logo_pan.setMaximumSize(new java.awt.Dimension(780, 65));
        logo_pan.setMinimumSize(new java.awt.Dimension(780, 65));
        logo_pan.setPreferredSize(new java.awt.Dimension(780, 65));

        lbl_logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/partNumbering_generator/xepto logo - white bg.png"))); // NOI18N

        lbl_png.setFont(new java.awt.Font("Miriam Fixed", 1, 35)); // NOI18N
        lbl_png.setForeground(new java.awt.Color(255, 255, 255));
        lbl_png.setText("Part Number Generator");

        javax.swing.GroupLayout logo_panLayout = new javax.swing.GroupLayout(logo_pan);
        logo_pan.setLayout(logo_panLayout);
        logo_panLayout.setHorizontalGroup(
            logo_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(logo_panLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_logo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_png, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(6, 6, 6))
        );
        logo_panLayout.setVerticalGroup(
            logo_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(logo_panLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(logo_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbl_logo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_png, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        input_pan.setBackground(new java.awt.Color(204, 204, 204));
        input_pan.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Input the following data", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Miriam Fixed", 1, 20), new java.awt.Color(255, 255, 255))); // NOI18N
        input_pan.setMaximumSize(new java.awt.Dimension(478, 383));
        input_pan.setMinimumSize(new java.awt.Dimension(478, 383));
        input_pan.setPreferredSize(new java.awt.Dimension(478, 383));

        lbl_cateogry.setFont(new java.awt.Font("Miriam Fixed", 1, 20)); // NOI18N
        lbl_cateogry.setForeground(new java.awt.Color(255, 255, 255));
        lbl_cateogry.setText("Commodity Name : ");

        cmb_name.setBackground(new java.awt.Color(204, 204, 255));
        cmb_name.setFont(new java.awt.Font("Miriam", 0, 20)); // NOI18N
        cmb_name.setMaximumRowCount(4);
        cmb_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_nameActionPerformed(evt);
            }
        });

        seq_pan.setBackground(new java.awt.Color(204, 204, 204));
        seq_pan.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sequence", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Miriam Fixed", 1, 20), new java.awt.Color(255, 255, 255))); // NOI18N

        txt_seq.setFont(new java.awt.Font("Miriam", 0, 20)); // NOI18N
        txt_seq.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_seqKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_seqKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout seq_panLayout = new javax.swing.GroupLayout(seq_pan);
        seq_pan.setLayout(seq_panLayout);
        seq_panLayout.setHorizontalGroup(
            seq_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(seq_panLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_seq, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                .addContainerGap())
        );
        seq_panLayout.setVerticalGroup(
            seq_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, seq_panLayout.createSequentialGroup()
                .addComponent(txt_seq)
                .addGap(5, 5, 5))
        );

        projDate_pan.setBackground(new java.awt.Color(204, 204, 204));
        projDate_pan.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Project Date :", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Miriam Fixed", 1, 20), new java.awt.Color(255, 255, 255))); // NOI18N

        txt_year.setFont(new java.awt.Font("Miriam", 0, 20)); // NOI18N
        txt_year.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_yearKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_yearKeyTyped(evt);
            }
        });

        cmb_month.setBackground(new java.awt.Color(204, 204, 255));
        cmb_month.setFont(new java.awt.Font("Miriam", 0, 20)); // NOI18N
        cmb_month.setMaximumRowCount(4);
        cmb_month.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));
        cmb_month.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmb_monthItemStateChanged(evt);
            }
        });
        cmb_month.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_monthActionPerformed(evt);
            }
        });

        cmb_day.setBackground(new java.awt.Color(204, 204, 255));
        cmb_day.setFont(new java.awt.Font("Miriam", 0, 20)); // NOI18N
        cmb_day.setMaximumRowCount(4);
        cmb_day.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        cmb_day.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cmb_dayMousePressed(evt);
            }
        });
        cmb_day.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_dayActionPerformed(evt);
            }
        });

        lbl_year.setFont(new java.awt.Font("Miriam Fixed", 0, 20)); // NOI18N
        lbl_year.setText("year");

        lbl_month.setFont(new java.awt.Font("Miriam Fixed", 0, 20)); // NOI18N
        lbl_month.setText("month");

        lbl_day.setFont(new java.awt.Font("Miriam Fixed", 0, 20)); // NOI18N
        lbl_day.setText("day");

        javax.swing.GroupLayout projDate_panLayout = new javax.swing.GroupLayout(projDate_pan);
        projDate_pan.setLayout(projDate_panLayout);
        projDate_panLayout.setHorizontalGroup(
            projDate_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(projDate_panLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_year, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmb_month, 0, 142, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmb_day, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, projDate_panLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(lbl_year)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_month)
                .addGap(71, 71, 71)
                .addComponent(lbl_day)
                .addGap(69, 69, 69))
        );
        projDate_panLayout.setVerticalGroup(
            projDate_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(projDate_panLayout.createSequentialGroup()
                .addGroup(projDate_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_day)
                    .addComponent(lbl_month)
                    .addComponent(lbl_year))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(projDate_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_year)
                    .addComponent(cmb_day, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cmb_month))
                .addContainerGap())
        );

        cmb_month.setSelectedIndex(0);
        cmb_day.setSelectedIndex(0);

        config_pan.setBackground(new java.awt.Color(204, 204, 204));
        config_pan.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Configuration", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Miriam Fixed", 1, 20), new java.awt.Color(255, 255, 255))); // NOI18N

        txt_config.setFont(new java.awt.Font("Miriam", 0, 20)); // NOI18N
        txt_config.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_configKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_configKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout config_panLayout = new javax.swing.GroupLayout(config_pan);
        config_pan.setLayout(config_panLayout);
        config_panLayout.setHorizontalGroup(
            config_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(config_panLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_config)
                .addContainerGap())
        );
        config_panLayout.setVerticalGroup(
            config_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, config_panLayout.createSequentialGroup()
                .addComponent(txt_config)
                .addGap(5, 5, 5))
        );

        txt_config.setEditable(false);

        btn_generate.setBackground(new java.awt.Color(204, 204, 255));
        btn_generate.setFont(new java.awt.Font("Miriam", 0, 20)); // NOI18N
        btn_generate.setText("Generate");
        btn_generate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_generateActionPerformed(evt);
            }
        });

        cmb_scheme.setBackground(new java.awt.Color(204, 204, 255));
        cmb_scheme.setFont(new java.awt.Font("Miriam", 0, 20)); // NOI18N
        cmb_scheme.setMaximumRowCount(4);
        cmb_scheme.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Consumable Parts", "Networking Peripheral Commodity", "Electrical Part Commodity", "Computer Peripherals Commodity", "Mechanical Part Commodity", "External Released Documents", "Internal Report Documents", "Internal Specification Document", "Internal Process Document" }));
        cmb_scheme.setMaximumSize(new java.awt.Dimension(360, 49));
        cmb_scheme.setMinimumSize(new java.awt.Dimension(360, 49));
        cmb_scheme.setPreferredSize(new java.awt.Dimension(360, 49));
        cmb_scheme.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmb_schemeItemStateChanged(evt);
            }
        });
        cmb_scheme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_schemeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout input_panLayout = new javax.swing.GroupLayout(input_pan);
        input_pan.setLayout(input_panLayout);
        input_panLayout.setHorizontalGroup(
            input_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(input_panLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(input_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmb_name, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(projDate_pan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_generate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(input_panLayout.createSequentialGroup()
                        .addComponent(seq_pan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(config_pan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(input_panLayout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addComponent(lbl_cateogry)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(cmb_scheme, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        input_panLayout.setVerticalGroup(
            input_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(input_panLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cmb_scheme, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_cateogry)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmb_name, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(projDate_pan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(input_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(seq_pan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(config_pan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_generate)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        seq_pan.setVisible(false);
        projDate_pan.setVisible(false);
        config_pan.setVisible(false);
        btn_generate.setEnabled(false);

        generated_pan.setBackground(new java.awt.Color(204, 204, 204));
        generated_pan.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Part Number", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Miriam Fixed", 1, 20), new java.awt.Color(255, 255, 255))); // NOI18N
        generated_pan.setMaximumSize(new java.awt.Dimension(274, 190));
        generated_pan.setMinimumSize(new java.awt.Dimension(274, 190));
        generated_pan.setPreferredSize(new java.awt.Dimension(274, 190));
        generated_pan.setRequestFocusEnabled(false);

        lbl_genPartNum.setFont(new java.awt.Font("Miriam", 1, 35)); // NOI18N
        lbl_genPartNum.setForeground(new java.awt.Color(255, 255, 255));
        lbl_genPartNum.setText("000-000000-0000");

        javax.swing.GroupLayout generated_panLayout = new javax.swing.GroupLayout(generated_pan);
        generated_pan.setLayout(generated_panLayout);
        generated_panLayout.setHorizontalGroup(
            generated_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, generated_panLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_genPartNum)
                .addGap(31, 31, 31))
        );
        generated_panLayout.setVerticalGroup(
            generated_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(generated_panLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(lbl_genPartNum, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lbl_genPartNum.setVisible(false);

        open_save_db_pan.setBackground(new java.awt.Color(204, 204, 204));
        open_save_db_pan.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btn_open_save.setBackground(new java.awt.Color(204, 204, 255));
        btn_open_save.setFont(new java.awt.Font("Miriam", 0, 20)); // NOI18N
        btn_open_save.setText("Open Database & Save");
        btn_open_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_open_saveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout open_save_db_panLayout = new javax.swing.GroupLayout(open_save_db_pan);
        open_save_db_pan.setLayout(open_save_db_panLayout);
        open_save_db_panLayout.setHorizontalGroup(
            open_save_db_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(open_save_db_panLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_open_save, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        open_save_db_panLayout.setVerticalGroup(
            open_save_db_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(open_save_db_panLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(btn_open_save)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        btn_new.setBackground(new java.awt.Color(204, 204, 255));
        btn_new.setFont(new java.awt.Font("Miriam", 0, 20)); // NOI18N
        btn_new.setText("New Record");
        btn_new.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_newActionPerformed(evt);
            }
        });

        btn_edit.setBackground(new java.awt.Color(204, 204, 255));
        btn_edit.setFont(new java.awt.Font("Miriam", 0, 20)); // NOI18N
        btn_edit.setText("Edit Record");
        btn_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editActionPerformed(evt);
            }
        });

        btn_check.setBackground(new java.awt.Color(204, 204, 255));
        btn_check.setFont(new java.awt.Font("Miriam", 0, 20)); // NOI18N
        btn_check.setText("Check Database");
        btn_check.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_checkActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout bg_panLayout = new javax.swing.GroupLayout(bg_pan);
        bg_pan.setLayout(bg_panLayout);
        bg_panLayout.setHorizontalGroup(
            bg_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bg_panLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bg_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(logo_pan, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(bg_panLayout.createSequentialGroup()
                        .addComponent(input_pan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(bg_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bg_panLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(generated_pan, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(bg_panLayout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addGroup(bg_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btn_edit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btn_check, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(open_save_db_pan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btn_new, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addContainerGap(91, Short.MAX_VALUE))
        );
        bg_panLayout.setVerticalGroup(
            bg_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bg_panLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(logo_pan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(bg_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(bg_panLayout.createSequentialGroup()
                        .addComponent(generated_pan, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(open_save_db_pan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_new)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_edit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_check))
                    .addComponent(input_pan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        open_save_db_pan.setVisible(false);
        btn_new.setEnabled(false);
        btn_edit.setEnabled(false);
        btn_check.setEnabled(false);

        mnu_user_gen.setFont(new java.awt.Font("Miriam", 0, 20)); // NOI18N

        mnu_uData.setText("Database");
        mnu_uData.setFont(new java.awt.Font("Miriam", 0, 20)); // NOI18N

        mnu_uData_view.setFont(new java.awt.Font("Miriam", 0, 17)); // NOI18N
        mnu_uData_view.setIcon(new javax.swing.ImageIcon(getClass().getResource("/partNumbering_generator/database_icon.png"))); // NOI18N
        mnu_uData_view.setText("View Database");
        mnu_uData_view.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnu_uData_viewActionPerformed(evt);
            }
        });
        mnu_uData.add(mnu_uData_view);

        mnu_uData_add.setFont(new java.awt.Font("Miriam", 0, 17)); // NOI18N
        mnu_uData_add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/partNumbering_generator/database_open_icon.png"))); // NOI18N
        mnu_uData_add.setText("Data For Approval");
        mnu_uData_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnu_uData_addActionPerformed(evt);
            }
        });
        mnu_uData.add(mnu_uData_add);

        mnu_user_gen.add(mnu_uData);

        mnu_uAccount.setText("Account");
        mnu_uAccount.setFont(new java.awt.Font("Miriam", 0, 20)); // NOI18N

        mnu_uAccount_logout.setFont(new java.awt.Font("Miriam", 0, 17)); // NOI18N
        mnu_uAccount_logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/partNumbering_generator/logout_icon.png"))); // NOI18N
        mnu_uAccount_logout.setText("Logout");
        mnu_uAccount_logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnu_uAccount_logoutActionPerformed(evt);
            }
        });
        mnu_uAccount.add(mnu_uAccount_logout);

        mnu_user_gen.add(Box.createHorizontalGlue());

        mnu_user_gen.add(mnu_uAccount);

        setJMenuBar(mnu_user_gen);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(bg_pan, javax.swing.GroupLayout.PREFERRED_SIZE, 877, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg_pan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_open_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_open_saveActionPerformed
        //clearing all inputted items

        cmb_name.removeAllItems();
        cmb_month.setSelectedIndex(0);
        cmb_day.setSelectedIndex(0);
        txt_year.setText("");
        txt_seq.setText("");
        txt_config.setText("");

        //hide lbl_genPartNum

        lbl_genPartNum.setVisible(false);

        //setEnable all input_pan objects

        cmb_scheme.setEnabled(true);
        cmb_name.setEnabled(true);
        cmb_month.setEnabled(true);
        cmb_day.setEnabled(true);
        txt_year.setEnabled(true);
        txt_seq.setEnabled(true);
        txt_config.setEnabled(true);

        //hide project_date_pan

        projDate_pan.setVisible(false);
        seq_pan.setVisible(false);
        config_pan.setVisible(false);

        //hide open_save btn

        open_save_db_pan.setVisible(false);

        //setEnable(false) to all buttons outside input_pan

        btn_new.setEnabled(false);
        btn_edit.setEnabled(false);
        btn_check.setEnabled(false);
            
        try {
            new save_data_user(lbl_genPartNum.getText(),cmb_scheme.getSelectedItem().toString()).setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(generator_frame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        cmb_scheme.setSelectedIndex(0);
    }//GEN-LAST:event_btn_open_saveActionPerformed

    private void btn_newActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_newActionPerformed
        //clearing all inputted items
        
        cmb_scheme.setSelectedIndex(0);
        cmb_name.removeAllItems();
        cmb_month.setSelectedIndex(0);
        cmb_day.setSelectedIndex(0);
        txt_year.setText("");
        txt_seq.setText("");
        txt_config.setText("");
        
        //hide lbl_genPartNum
        
        lbl_genPartNum.setVisible(false);
        
        //setEnable all input_pan objects
        
        cmb_scheme.setEnabled(true);
        cmb_name.setEnabled(true);
        cmb_month.setEnabled(true);
        cmb_day.setEnabled(true);
        txt_year.setEnabled(true);
        txt_seq.setEnabled(true);
        txt_config.setEnabled(true);
        
        //hide project_date_pan
        
        projDate_pan.setVisible(false);
        seq_pan.setVisible(false);
        config_pan.setVisible(false);
        
        //hide open_save btn
        
        open_save_db_pan.setVisible(false);
        
        //setEnable(false) to all buttons outside input_pan
        
        btn_new.setEnabled(false);
        btn_edit.setEnabled(false);
        btn_check.setEnabled(false);
    }//GEN-LAST:event_btn_newActionPerformed

    private void btn_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editActionPerformed
        //setEnable all input_pan objects
        
        cmb_scheme.setEnabled(true);
        cmb_name.setEnabled(true);
        cmb_month.setEnabled(true);
        cmb_day.setEnabled(true);
        txt_year.setEnabled(true);
        txt_seq.setEnabled(true);
        txt_config.setEnabled(true);
        
        //hide open_save btn
        
        open_save_db_pan.setVisible(false);
        
        //generate button enabled
        
        btn_generate.setEnabled(true);
        
        //setEnable(false) to all buttons outside input_pan
        
        btn_new.setEnabled(false);
        btn_edit.setEnabled(false);
        btn_check.setEnabled(false);
    }//GEN-LAST:event_btn_editActionPerformed

    private void btn_checkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_checkActionPerformed
        //open_save_db_pan.setVisible(true);
        try{
            Connection connect = DriverManager.getConnection("jdbc:derby://" + host_address + "/partNumbering  " , "Admin01", "07032017");
            Statement state = connect.createStatement();
            String sql = "SELECT * FROM Admin01.DATA_USERS";
            ResultSet res = state.executeQuery(sql);
            String sim = "";
            
            while(res.next()){
                if(lbl_genPartNum.getText().equals(res.getString("Part_Number"))){
                    sim = "SIMILAR";
                }
            }
            
            Statement state1 = connect.createStatement();
            String sql1 = "SELECT * FROM Admin01.PART_NUMBER_DATA";
            ResultSet res1 = state1.executeQuery(sql1);
            
            while(res1.next()){
                if(lbl_genPartNum.getText().equals(res1.getString("Part_Number"))){
                    sim = "SIMILAR";
                }
            }
            
            if("SIMILAR".equals(sim)){
                JOptionPane.showMessageDialog(this, "Similar Part Number!!! \n Try Again.","Error", JOptionPane.ERROR_MESSAGE);
                
                //setEnable(false) to all buttons outside input_pan
        
                btn_new.setEnabled(false);
                btn_edit.setEnabled(false);
                btn_check.setEnabled(false);
                
                //setEnable all input_pan objects
                
                btn_generate.setEnabled(true);
                cmb_scheme.setEnabled(true);
                cmb_name.setEnabled(true);
                cmb_month.setEnabled(true);
                cmb_day.setEnabled(true);
                txt_year.setEnabled(true);
                txt_seq.setEnabled(true);
                txt_config.setEnabled(true);
            }
            else{
                open_save_db_pan.setVisible(true);
            }
            
                    
        } catch (SQLException ex) {
            Logger.getLogger(generator_user_frame.class.getName()).log(Level.SEVERE, null, ex);
        }
                    


    }//GEN-LAST:event_btn_checkActionPerformed

    private void cmb_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_nameActionPerformed
        
    }//GEN-LAST:event_cmb_nameActionPerformed

    private void btn_generateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_generateActionPerformed
        
        Calendar now = Calendar.getInstance();
        int year = now.get(Calendar.YEAR);
        System.out.println(String.valueOf(year));
        int month = now.get(Calendar.MONTH);
        System.out.println(String.valueOf(month));
        int day = now.get(Calendar.DATE);
        System.out.println(String.valueOf(day));
        
        if(txt_year.getText().length() != 4){
            JOptionPane.showMessageDialog(this, "Year must have 4 digits!! \n\nTry Again.", "Wrong Input", JOptionPane.ERROR_MESSAGE);
            
            //setEnable all input_pan objects

            cmb_scheme.setEnabled(true);
            cmb_name.setEnabled(true);
            cmb_month.setEnabled(true);
            cmb_day.setEnabled(true);
            txt_year.setEnabled(true);
            txt_seq.setEnabled(true);
            txt_config.setEnabled(true);

            //hide open_save btn

            open_save_db_pan.setVisible(false);

            //generate button enabled

            btn_generate.setEnabled(true);

            //setEnable(false) to all buttons outside input_pan

            btn_new.setEnabled(false);
            btn_edit.setEnabled(false);
            btn_check.setEnabled(false);
        }
        else if(Integer.parseInt(txt_year.getText())>year){
            JOptionPane.showMessageDialog(this, "Wrong inputted year! \n\nTry Again.", "Wrong Input", JOptionPane.ERROR_MESSAGE);
            
            //setEnable all input_pan objects

            cmb_scheme.setEnabled(true);
            cmb_name.setEnabled(true);
            cmb_month.setEnabled(true);
            cmb_day.setEnabled(true);
            txt_year.setEnabled(true);
            txt_seq.setEnabled(true);
            txt_config.setEnabled(true);

            //hide open_save btn

            open_save_db_pan.setVisible(false);

            //generate button enabled

            btn_generate.setEnabled(true);

            //setEnable(false) to all buttons outside input_pan

            btn_new.setEnabled(false);
            btn_edit.setEnabled(false);
            btn_check.setEnabled(false);
        }
        else if(Integer.parseInt(txt_year.getText()) == year && cmb_month.getSelectedIndex() > month){
            JOptionPane.showMessageDialog(this, "Wrong inputted month of the current year! \n\nTry Again.", "Wrong Input", JOptionPane.ERROR_MESSAGE);
            
            //setEnable all input_pan objects

            cmb_scheme.setEnabled(true);
            cmb_name.setEnabled(true);
            cmb_month.setEnabled(true);
            cmb_day.setEnabled(true);
            txt_year.setEnabled(true);
            txt_seq.setEnabled(true);
            txt_config.setEnabled(true);

            //hide open_save btn

            open_save_db_pan.setVisible(false);

            //generate button enabled

            btn_generate.setEnabled(true);

            //setEnable(false) to all buttons outside input_pan

            btn_new.setEnabled(false);
            btn_edit.setEnabled(false);
            btn_check.setEnabled(false);
        }
        else if(Integer.parseInt(txt_year.getText()) == year && cmb_month.getSelectedIndex() == month && Integer.parseInt(cmb_day.getSelectedItem().toString()) > day){
            JOptionPane.showMessageDialog(this, "Wrong inputted day of the current month & year! \n\nTry Again.", "Wrong Input", JOptionPane.ERROR_MESSAGE);
            
            //setEnable all input_pan objects

            cmb_scheme.setEnabled(true);
            cmb_name.setEnabled(true);
            cmb_month.setEnabled(true);
            cmb_day.setEnabled(true);
            txt_year.setEnabled(true);
            txt_seq.setEnabled(true);
            txt_config.setEnabled(true);

            //hide open_save btn

            open_save_db_pan.setVisible(false);

            //generate button enabled

            btn_generate.setEnabled(true);

            //setEnable(false) to all buttons outside input_pan

            btn_new.setEnabled(false);
            btn_edit.setEnabled(false);
            btn_check.setEnabled(false);
        }
        else if(txt_seq.getText().length() != 6){
            JOptionPane.showMessageDialog(this, "Sequence Number must have 6 digits!! \n\nTry Again.", "Wrong Input", JOptionPane.ERROR_MESSAGE);
            
            //setEnable all input_pan objects

            cmb_scheme.setEnabled(true);
            cmb_name.setEnabled(true);
            cmb_month.setEnabled(true);
            cmb_day.setEnabled(true);
            txt_year.setEnabled(true);
            txt_seq.setEnabled(true);
            txt_config.setEnabled(true);

            //hide open_save btn

            open_save_db_pan.setVisible(false);

            //generate button enabled

            btn_generate.setEnabled(true);

            //setEnable(false) to all buttons outside input_pan

            btn_new.setEnabled(false);
            btn_edit.setEnabled(false);
            btn_check.setEnabled(false);
            
        }
        else if(txt_config.getText().length() != 4){
            JOptionPane.showMessageDialog(this, "Configuration Number must have 4 digits!! \n\nTry Again.", "Wrong Input", JOptionPane.ERROR_MESSAGE);
            
            //setEnable all input_pan objects

            cmb_scheme.setEnabled(true);
            cmb_name.setEnabled(true);
            cmb_month.setEnabled(true);
            cmb_day.setEnabled(true);
            txt_year.setEnabled(true);
            txt_seq.setEnabled(true);
            txt_config.setEnabled(true);

            //hide open_save btn

            open_save_db_pan.setVisible(false);

            //generate button enabled

            btn_generate.setEnabled(true);

            //setEnable(false) to all buttons outside input_pan

            btn_new.setEnabled(false);
            btn_edit.setEnabled(false);
            btn_check.setEnabled(false);
        
        }
        else{
            //for commodity code
        
            int comNameSelected = cmb_name.getSelectedIndex();

            switch (cmb_scheme.getSelectedIndex()) {
                case 0:
                    for(int i=0; i<= conPart_code.size(); i++){
                        if(i == comNameSelected)
                            commodity_code = conPart_code.get(i);
                    }   break;
                case 1:
                    for(int i=0; i<= netPart_code.size(); i++){
                        if(i == comNameSelected)
                            commodity_code = netPart_code.get(i);
                    }   break;
                case 2:
                    for(int i=0; i<= elecPart_code.size(); i++){
                        if(i == comNameSelected)
                            commodity_code = elecPart_code.get(i);
                    }   break;
                case 3:
                    for(int i=0; i <= compPeri_code.size(); i++){
                        if(i == comNameSelected)
                            commodity_code = compPeri_code.get(i);
                    }   break;             
                case 4:
                    for(int i=0; i <= mechPart_code.size(); i++){
                        if(i == comNameSelected)
                            commodity_code = mechPart_code.get(i);
                    }   break; 
                case 5:
                    for(int i=0; i <= ext_code.size(); i++){
                        if(i == comNameSelected)
                            commodity_code = ext_code.get(i);
                    }   break;
                case 6:
                    for(int i=0; i <= intRep_code.size(); i++){
                        if(i == comNameSelected)
                            commodity_code = intRep_code.get(i);
                    }   break;
                case 7:
                    for(int i=0; i <= intSpec_code.size(); i++){
                        if(i == comNameSelected)
                            commodity_code = intSpec_code.get(i);
                    }   break;
                case 8:
                    for(int i=0; i <= intPro_code.size(); i++){
                        if(i == comNameSelected)
                            commodity_code = intPro_code.get(i);
                    }   break;
                default:
                    for(int i=0; i <= compPeri_code.size(); i++){
                        if(i == comNameSelected)
                            commodity_code = compPeri_code.get(i);
                    }   break;
            }

            //for magic number or sequence number

            String suffix = "";

            if(seq_pan.isVisible() == true){

                //getting the value of sequence textfield

                String seq = txt_seq.getText();

                //suffix to be used for lbl_genPartNum

                suffix = commodity_code + "-" + seq + "-" + txt_config.getText();
            }
            else if(projDate_pan.isVisible() == true){

                //getting the year

                yearText = txt_year.getText();

                yearTextArea = yearText.substring(yearText.lastIndexOf(" ") + 3);

                //getting the month

                int monthSelected = cmb_month.getSelectedIndex();

                for(int i=0; i <= cmb_month.getItemCount(); i++){
                    if(i == monthSelected){

                        if(monthSelected<9){
                            monthText = "0" + Integer.toString(cmb_month.getSelectedIndex()+1);
                        }
                        else{
                            monthText = Integer.toString(cmb_month.getSelectedIndex()+1);
                        }
                    }
                }

                //getting the day

                dayText = cmb_day.getSelectedItem().toString();

                if(cmb_scheme.getSelectedIndex() == 5 || cmb_scheme.getSelectedIndex() == 8){

                    //suffix to be used for lbl_genPartNum

                    suffix = commodity_code + "-" + yearTextArea + monthText + dayText + "-" + txt_config.getText();    
                }
                else{

                    //suffix to be used for lbl_genPartNum

                    suffix = commodity_code + "-" + dayText + monthText + yearTextArea + "-" + txt_config.getText();
                }

            }

            //generated_panel
            lbl_genPartNum.setVisible(true);
            lbl_genPartNum.setText(suffix);

            //setEnabled(false) to all the input_pan objects
            btn_generate.setEnabled(false);
            cmb_scheme.setEnabled(false);
            cmb_name.setEnabled(false);
            cmb_month.setEnabled(false);
            cmb_day.setEnabled(false);
            txt_year.setEnabled(false);
            txt_config.setEnabled(false);
            txt_seq.setEnabled(false);

            //setEnable(true) to all buttons outside input_pan
            btn_new.setEnabled(true);
            btn_edit.setEnabled(true);
            btn_check.setEnabled(true);
        }
    }//GEN-LAST:event_btn_generateActionPerformed

    private void mnu_uAccount_logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnu_uAccount_logoutActionPerformed
        
        Object[] options = {"Yes",
                            "No"};
        int n = JOptionPane.showOptionDialog(this, "If there is unsaved data, the data will not be saved. \n\nContinue Log-Out?","You are about to LOG-OUT!",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null, options, options[0]);
        
        switch(n){
            case 0:
                this.setVisible(false);
                new login_frame().setVisible(true);
                
                //clearing all inputted items
        
                cmb_scheme.setSelectedIndex(0);
                cmb_name.removeAllItems();
                cmb_month.setSelectedIndex(0);
                cmb_day.setSelectedIndex(0);
                txt_year.setText("");
                txt_seq.setText("");
                txt_config.setText("");

                //hide lbl_genPartNum

                lbl_genPartNum.setVisible(false);

                //setEnable all input_pan objects

                cmb_scheme.setEnabled(true);
                cmb_name.setEnabled(true);
                cmb_month.setEnabled(true);
                cmb_day.setEnabled(true);
                txt_year.setEnabled(true);
                txt_seq.setEnabled(true);
                txt_config.setEnabled(true);

                //hide project_date_pan

                projDate_pan.setVisible(false);
                seq_pan.setVisible(false);
                config_pan.setVisible(false);

                //hide open_save btn

                open_save_db_pan.setVisible(false);

                //setEnable(false) to all buttons outside input_pan

                btn_new.setEnabled(false);
                btn_edit.setEnabled(false);
                btn_check.setEnabled(false);
                
                break;
            case 1:
                break;
        }
    }//GEN-LAST:event_mnu_uAccount_logoutActionPerformed

    private void cmb_monthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_monthActionPerformed

        String cmbMonthSelected = (String)cmb_month.getSelectedItem();

        if(null == cmbMonthSelected){
            cmb_month.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        }
        else switch (cmbMonthSelected) {
            case "April":
            case "June":
            case "September":
            case "November":
            cmb_day.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30" }));
            break;
            case "February":
            cmb_day.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29"}));
            break;
            default:
            cmb_day.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
            break;
        }
    }//GEN-LAST:event_cmb_monthActionPerformed

    private void cmb_dayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_dayActionPerformed

    }//GEN-LAST:event_cmb_dayActionPerformed

    private void cmb_schemeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_schemeActionPerformed

        switch (cmb_scheme.getSelectedIndex()) {
            case 0:
                //deleting previous cmb_name values
                
                cmb_name.removeAllItems();
                
                //populating cmbbox with the name from the array

                for(int i = 0; i<conPart_name.size(); i++)
                    cmb_name.addItem(conPart_name.get(i));
                    
                //setVisible(true)
                    
                projDate_pan.setVisible(false);
                seq_pan.setVisible(true);
                config_pan.setVisible(true);
                
                //set year == 0000
                txt_year.setText("0000");
                txt_seq.setText("");
                break;
            case 1:
                //deleting previous cmb_name values
                
                cmb_name.removeAllItems();
                
                //populating cmbbox with the name from the array

                for(int i = 0; i<netPart_name.size(); i++)
                    cmb_name.addItem(netPart_name.get(i));
                    
                //setVisible(true)
                    
                projDate_pan.setVisible(false);
                seq_pan.setVisible(true);
                config_pan.setVisible(true);
                
                //set year == 0000
                txt_year.setText("0000");
                txt_seq.setText("");
                break;
            case 2:
                //deleting previous cmb_name values
                
                cmb_name.removeAllItems();
                
                //populating cmbbox with the name from the array

                for(int i = 0; i<elecPart_name.size(); i++)
                    cmb_name.addItem(elecPart_name.get(i));
                    
                //setVisible(true)
                    
                projDate_pan.setVisible(false);
                seq_pan.setVisible(true);
                config_pan.setVisible(true);
                
                //set year == 0000
                txt_year.setText("0000");
                txt_seq.setText("");
                break;    
            case 3:
                //deleting previous cmb_name values
                
                cmb_name.removeAllItems();
                
                //populating cmbbox with the name from the array

                for(int i = 0; i<compPeri_name.size(); i++)
                    cmb_name.addItem(compPeri_name.get(i));
                    
                //setVisible(true)
                
                projDate_pan.setVisible(false);
                seq_pan.setVisible(true);
                config_pan.setVisible(true);
                
                //set year == 0000
                txt_year.setText("0000");
                txt_seq.setText("");
                break;       
            case 4:
                //deleting previous cmb_name values
                
                cmb_name.removeAllItems();
                
                //populating cmbbox with the name from the array

                for(int i = 0; i<mechPart_name.size(); i++)
                    cmb_name.addItem(mechPart_name.get(i));
                    
                //setVisible(true)
                   
                projDate_pan.setVisible(false);
                seq_pan.setVisible(true);
                config_pan.setVisible(true);
                
                //set year == 0000
                txt_year.setText("0000");
                txt_seq.setText("");
                break;    
            case 5:
                //deleting previous cmb_name values
                
                cmb_name.removeAllItems();
                
                //populating cmbbox with the name from the array

                for(int i = 0; i<ext_name.size(); i++)
                    cmb_name.addItem(ext_name.get(i));
                    
                //setVisible(true)
                   
                projDate_pan.setVisible(true);
                seq_pan.setVisible(false);
                config_pan.setVisible(true);
                
                //set seq == 000000
                txt_seq.setText("000000");
                txt_year.setText("");
                break;
            case 6:
                //deleting previous cmb_name values
                
                cmb_name.removeAllItems();
                
                //populating cmbbox with the name from the array

                for(int i = 0; i<intRep_name.size(); i++)
                    cmb_name.addItem(intRep_name.get(i));
                    
                //setVisible(true)
                    
                projDate_pan.setVisible(true);
                seq_pan.setVisible(false);
                config_pan.setVisible(true);
                //set seq == 000000
                txt_seq.setText("000000");
                txt_year.setText("");
                break;
            case 7:
                //deleting previous cmb_name values
                
                cmb_name.removeAllItems();
                
                //populating cmbbox with the name from the array

                for(int i = 0; i<intSpec_name.size(); i++)
                    cmb_name.addItem(intSpec_name.get(i));
                    
                //setVisible(true)
                    
                projDate_pan.setVisible(true);
                seq_pan.setVisible(false);
                config_pan.setVisible(true);
                
                //set seq == 000000
                txt_seq.setText("000000");
                txt_year.setText("");
                break;
            case 8:
                //deleting previous cmb_name values
                
                cmb_name.removeAllItems();
                
                //populating cmbbox with the name from the array

                for(int i = 0; i<intPro_name.size(); i++)
                    cmb_name.addItem(intPro_name.get(i));
                    
                //setVisible(true)
                    
                projDate_pan.setVisible(true);
                seq_pan.setVisible(false);
                config_pan.setVisible(true);
                
                //set seq == 000000
                txt_seq.setText("000000");
                txt_year.setText("");
                break;
            default:
                //populating cmbbox with the name from the array

                for(int i = 0; i<conPart_name.size(); i++)
                    cmb_name.addItem(conPart_name.get(i));
                    
                //setVisible(true)
                    
                projDate_pan.setVisible(true);
                config_pan.setVisible(true);
                break;
        }        
       
    }//GEN-LAST:event_cmb_schemeActionPerformed

    private void mnu_uData_viewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnu_uData_viewActionPerformed
        new view_database_user().setVisible(true);
    }//GEN-LAST:event_mnu_uData_viewActionPerformed

    private void cmb_schemeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmb_schemeItemStateChanged

    }//GEN-LAST:event_cmb_schemeItemStateChanged

    private void txt_configKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_configKeyTyped
        if (txt_config.getText().length() >= 4 ){
            evt.consume();
            
        }       
        else if(txt_config.getText().length() >= 3){
            btn_generate.setEnabled(true);
        }
    }//GEN-LAST:event_txt_configKeyTyped

    private void txt_seqKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_seqKeyTyped
        if (txt_seq.getText().length() >= 6 )
            evt.consume();
        txt_config.setEditable(true);
    }//GEN-LAST:event_txt_seqKeyTyped

    private void txt_yearKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_yearKeyTyped
        if (txt_year.getText().length() >= 4 )
            evt.consume();
        txt_config.setEditable(true);
    }//GEN-LAST:event_txt_yearKeyTyped

    private void txt_configKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_configKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            if(txt_config.getText().length() == 4)
                btn_generate.doClick();
            else{
               JOptionPane.showMessageDialog(this, "Configuration Number must be 4 digits!! \n Try Again.", "Error!", JOptionPane.ERROR_MESSAGE);
           }
        }
    }//GEN-LAST:event_txt_configKeyPressed

    private void txt_seqKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_seqKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            if(txt_seq.getText().length() == 6)
               txt_config.requestFocus();
            else{
               JOptionPane.showMessageDialog(this, "Sequence Number must be 6 digits!! \n Try Again.", "Error!", JOptionPane.ERROR_MESSAGE);
           }
        }
    }//GEN-LAST:event_txt_seqKeyPressed

    private void txt_yearKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_yearKeyPressed
        
        char[] year_arr = txt_year.getText().toCharArray();
        
        if(evt.getKeyCode()==KeyEvent.VK_ENTER)
           if(txt_year.getText().length() == 4){
               for(int i = 0; i < year_arr.length ; i++){
                   if(Character.isDigit(year_arr[i])){
                       cmb_month.requestFocus();
                       txt_config.setEditable(true);
                   }
                   else{
                       JOptionPane.showMessageDialog(this, "Year must be integers only!!! \n Try Again.", "Error!", JOptionPane.ERROR_MESSAGE);
                   }
               }
           }
           else{
               JOptionPane.showMessageDialog(this, "Year must be 4 numeric digits!!! \n Try Again.", "Error!", JOptionPane.ERROR_MESSAGE);
           }
    }//GEN-LAST:event_txt_yearKeyPressed

    private void cmb_monthItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmb_monthItemStateChanged

    }//GEN-LAST:event_cmb_monthItemStateChanged

    private void cmb_dayMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmb_dayMousePressed

    }//GEN-LAST:event_cmb_dayMousePressed

    private void mnu_uData_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnu_uData_addActionPerformed
        new view_user_save().setVisible(true);
    }//GEN-LAST:event_mnu_uData_addActionPerformed

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
            java.util.logging.Logger.getLogger(generator_user_frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(generator_user_frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(generator_user_frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(generator_user_frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new generator_user_frame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg_pan;
    private javax.swing.JButton btn_check;
    private javax.swing.JButton btn_edit;
    private javax.swing.JButton btn_generate;
    private javax.swing.JButton btn_new;
    private javax.swing.JButton btn_open_save;
    private javax.swing.JComboBox<String> cmb_day;
    private javax.swing.JComboBox<String> cmb_month;
    private javax.swing.JComboBox<String> cmb_name;
    private javax.swing.JComboBox<String> cmb_scheme;
    private javax.swing.JPanel config_pan;
    private javax.swing.JPanel generated_pan;
    private javax.swing.JPanel input_pan;
    private javax.swing.JLabel lbl_cateogry;
    private javax.swing.JLabel lbl_day;
    private javax.swing.JLabel lbl_genPartNum;
    private javax.swing.JLabel lbl_logo;
    private javax.swing.JLabel lbl_month;
    private javax.swing.JLabel lbl_png;
    private javax.swing.JLabel lbl_year;
    private javax.swing.JPanel logo_pan;
    private javax.swing.JMenu mnu_uAccount;
    private javax.swing.JMenuItem mnu_uAccount_logout;
    private javax.swing.JMenu mnu_uData;
    private javax.swing.JMenuItem mnu_uData_add;
    private javax.swing.JMenuItem mnu_uData_view;
    private javax.swing.JMenuBar mnu_user_gen;
    private javax.swing.JPanel open_save_db_pan;
    private javax.swing.JPanel projDate_pan;
    private javax.swing.JPanel seq_pan;
    private javax.swing.JTextField txt_config;
    private javax.swing.JTextField txt_seq;
    private javax.swing.JTextField txt_year;
    // End of variables declaration//GEN-END:variables
}
