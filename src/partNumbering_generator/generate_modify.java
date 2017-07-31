
package partNumbering_generator;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class generate_modify extends javax.swing.JFrame {
    
    ArrayList<String> adm, use;
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
    
    String admUn, useUn;
    
    String commodity_code;
    String yearTextArea;
    String yearText;
    String monthText;
    String dayText;
    
    String host_address = Host.getHost();
    
    EntityManager em;
    
    String ty, pn, cat, des, aut, con, un;
    Date date;
    
    Admins logged_admin;
    String message;
    
    public generate_modify(String type, String part, String category, String description, Date genDate, String author, String configuration) {
        
        initComponents();
        
        try{
            em = Persistence.createEntityManagerFactory("partNumberingPU", Host.getPersistence()).createEntityManager();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.toString());
        }   
        
        setLocationRelativeTo(null);
        
        this.setIconImage(new ImageIcon(getClass().getResource("xepto logo - white bg - x.jpg")).getImage()); 
        
        if(Account.getType().equals("admin")){
            un = "admin";
            this.setTitle("Modify Part Number Information - Admin (" + Account.getUser() + ")" );
        }
        else{
            un = "password";
            this.setTitle("Modify Part Number Information - User (" + Account.getUser() + ")" );
        }
        
        ty = type;
        pn = part;
        cat = category;
        des =  description;
        date = genDate;
        aut = author;
        con = configuration;
        
        DoConnect_external();
        DoConnect_intPro();
        DoConnect_intSpec();
        DoConnect_intRep();
        DoConnect_mechPart();
        DoConnect_compPeri();
        DoConnect_elecPart(); 
        DoConnect_netPart();
        DoConnect_conPart();
        
        lbl_oldpn.setText(pn);
        getCat();
        getComCode();
        setSeq();
        txt_config.setText(pn.substring(11));
        txt_des.setText(des);
        setAutCmb();
        getAut();
        
    }

    public void setAutCmb(){
        
        adm = new ArrayList<>();
        use = new ArrayList<>();

        try{
            em.getEntityManagerFactory().getCache().evictAll();
            Query q = em.createNamedQuery("Admins.findAll");
            List<Admins> list = q.getResultList();

            for(Admins record: list){
                admUn = record.getUsername();

                adm.add(admUn);
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.toString());
        }
        
        try{
            em.getEntityManagerFactory().getCache().evictAll();
            Query q = em.createNamedQuery("Employee.findAll");
            List<Employee> list = q.getResultList();

            for(Employee record: list){
                useUn = record.getUsername();

                use.add(useUn);
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.toString());
        }
           
        for(int i = 0; i<adm.size(); i++)
            cmb_aut.addItem(adm.get(i));
        cmb_aut.addItem("-------------------------------------");
        for(int i = 0; i<use.size(); i++)
            cmb_aut.addItem(use.get(i));
        
    }
    
    public void getCat(){
        for(int i = 0; i < cmb_scheme.getItemCount(); i++){
            if(cmb_scheme.getItemAt(i).matches(cat)){
                cmb_scheme.setSelectedIndex(i);
            }
        }
    }
    
    public void getComCode(){
        String comCode = pn.substring(0, 3);
        
        String[] conPart = conPart_code.toArray(new String[conPart_code.size()]);
        String[] netPart = netPart_code.toArray(new String[netPart_code.size()]);
        String[] elecPart = elecPart_code.toArray(new String[elecPart_code.size()]);
        String[] compPeri = compPeri_code.toArray(new String[compPeri_code.size()]);
        String[] mechPart = mechPart_code.toArray(new String[mechPart_code.size()]);
        String[] ext = ext_code.toArray(new String[ext_code.size()]);
        String[] intRep = intRep_code.toArray(new String[intRep_code.size()]);
        String[] intSpec = intSpec_code.toArray(new String[intSpec_code.size()]);
        String[] intPro = intPro_code.toArray(new String[intPro_code.size()]);
        
        switch (cmb_scheme.getSelectedIndex()) {
            case 0:
                for(int i=0; i< conPart_code.size(); i++){
                    if(conPart[i].equals(comCode)){
                        cmb_name.setSelectedIndex(i);
                    }
                }   break;
            case 1:
                for(int i=0; i< netPart_code.size(); i++){
                    if(netPart[i].equals(comCode))
                        cmb_name.setSelectedIndex(i);
                }   break;
            case 2:
                for(int i=0; i< elecPart_code.size(); i++){
                    if(elecPart[i].equals(comCode))
                        cmb_name.setSelectedIndex(i);
                }   break;
            case 3:
                for(int i=0; i < compPeri_code.size(); i++){
                    if(compPeri[i].equals(comCode))
                        cmb_name.setSelectedIndex(i);
                }   break;             
            case 4:
                for(int i=0; i < mechPart_code.size(); i++){
                    if(mechPart[i].equals(comCode))
                        cmb_name.setSelectedIndex(i);
                }   break; 
            case 5:
                for(int i=0; i < ext_code.size(); i++){
                    if(ext[i].equals(comCode))
                        cmb_name.setSelectedIndex(i);
                }   break;
            case 6:
                for(int i=0; i < intRep_code.size(); i++){
                    if(intRep[i].equals(comCode))
                        cmb_name.setSelectedIndex(i);
                }   break;
            case 7:
                for(int i=0; i < intSpec_code.size(); i++){
                    if(intSpec.equals(comCode))
                        cmb_name.setSelectedIndex(i);
                }   break;
            case 8:
                for(int i=0; i < intPro_code.size(); i++){
                    if(intPro.equals(comCode))
                        cmb_name.setSelectedIndex(i);
                }   break;
        }
    }
    
    public void setSeq(){
        if(projDate_pan.isVisible()){
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            String strDate = dateFormat.format(date);            
            if(cmb_scheme.getSelectedIndex() == 5 || cmb_scheme.getSelectedIndex() == 8){
                String year_gen = strDate.substring(6, 8);
                String year = pn.substring(4, 6);
                txt_year.setText(year_gen.concat(year));
                
                String mon = pn.substring(6,8);
                int mon_1 = Integer.parseInt(mon);
                cmb_month.setSelectedIndex(mon_1 - 1);
                
                String day = pn.substring(8,10);
                int day_1 = Integer.parseInt(day);
                cmb_day.setSelectedIndex(day_1 - 1);
            }
            else{
                String year_gen = strDate.substring(6, 8);
                String year = pn.substring(8, 10);
                txt_year.setText(year_gen.concat(year));
                
                String mon = pn.substring(6,8);
                int mon_1 = Integer.parseInt(mon);
                cmb_month.setSelectedIndex(mon_1 - 1);
                
                String day = pn.substring(4,6);
                int day_1 = Integer.parseInt(day);
                cmb_day.setSelectedIndex(day_1 - 1);
            }
        }
        else{
            txt_seq.setText(pn.substring(4, 10));
        }
    }
    
    public void getAut(){
        for(int i = 0; i < cmb_aut.getItemCount(); i++){
            if(cmb_aut.getItemAt(i).matches(aut)){
                cmb_aut.setSelectedIndex(i);
            }
        }
    }
    
    public void DoConnect_external(){
            
            ext_name = new ArrayList<>();
            ext_code = new ArrayList<>();
            
            try{
                em.getEntityManagerFactory().getCache().evictAll();
                Query q = em.createNamedQuery("ExternalReleasedDocuments.findAll");
                List<ExternalReleasedDocuments> list = q.getResultList();
                
                for(ExternalReleasedDocuments record: list){
                    comCode_col = record.getCommodityCode();
                    comName_col = record.getCommodityName();
                    
                    ext_name.add(comName_col);
                    ext_code.add(comCode_col);
                }
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, e.toString());
            }

    }
    
    public void DoConnect_intPro(){
            
            intPro_name = new ArrayList<>();
            intPro_code = new ArrayList<>();

            try{
                em.getEntityManagerFactory().getCache().evictAll();
                Query q = em.createNamedQuery("InternalProcessDocument.findAll");
                List<InternalProcessDocument> list = q.getResultList();
                
                for(InternalProcessDocument record: list){
                    comCode_col = record.getCommodityCode();
                    comName_col = record.getCommodityName();
                    
                    intPro_name.add(comName_col);
                    intPro_code.add(comCode_col);
                }
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, e.toString());
            }

    }
    
    public void DoConnect_intSpec(){
 
            intSpec_name = new ArrayList<>();
            intSpec_code = new ArrayList<>();

            try{
                em.getEntityManagerFactory().getCache().evictAll();
                Query q = em.createNamedQuery("InternalSpecificationDocument.findAll");
                List<InternalSpecificationDocument> list = q.getResultList();
                
                for(InternalSpecificationDocument record: list){
                    comCode_col = record.getCommodityCode();
                    comName_col = record.getCommodityName();
                    
                    intSpec_name.add(comName_col);
                    intSpec_code.add(comCode_col);
                }
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, e.toString());
            }

    }
    
    public void DoConnect_intRep(){
            
            intRep_name = new ArrayList<>();
            intRep_code = new ArrayList<>();

            try{
                em.getEntityManagerFactory().getCache().evictAll();
                Query q = em.createNamedQuery("InternalReportDocuments.findAll");
                List<InternalReportDocuments> list = q.getResultList();
                
                for(InternalReportDocuments record: list){
                    comCode_col = record.getCommodityCode();
                    comName_col = record.getCommodityName();
                    
                    intRep_name.add(comName_col);
                    intRep_code.add(comCode_col);
                }
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, e.toString());
            }

    }
    
    public void DoConnect_mechPart(){
            
            mechPart_name = new ArrayList<>();
            mechPart_code = new ArrayList<>();

            try{
                em.getEntityManagerFactory().getCache().evictAll();
                Query q = em.createNamedQuery("MechanicalPartCommodity.findAll");
                List<MechanicalPartCommodity> list = q.getResultList();
                
                for(MechanicalPartCommodity record: list){
                    comCode_col = record.getCommodityCode();
                    comName_col = record.getCommodityName();
                    
                    mechPart_name.add(comName_col);
                    mechPart_code.add(comCode_col);
                }
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, e.toString());
            }

    }
    
    public void DoConnect_compPeri(){
            
            compPeri_name = new ArrayList<>();
            compPeri_code = new ArrayList<>();

            try{
                em.getEntityManagerFactory().getCache().evictAll();
                Query q = em.createNamedQuery("ComputerPeripheralsCommodity.findAll");
                List<ComputerPeripheralsCommodity> list = q.getResultList();
                
                for(ComputerPeripheralsCommodity record: list){
                    comCode_col = record.getCommodityCode();
                    comName_col = record.getCommodityName();
                    
                    compPeri_name.add(comName_col);
                    compPeri_code.add(comCode_col);
                }
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, e.toString());
            }

    }
    
    public void DoConnect_elecPart(){
            
            elecPart_name = new ArrayList<>();
            elecPart_code = new ArrayList<>();

            try{
                em.getEntityManagerFactory().getCache().evictAll();
                Query q = em.createNamedQuery("ElectricalPartCommodity.findAll");
                List<ElectricalPartCommodity> list = q.getResultList();
                
                for(ElectricalPartCommodity record: list){
                    comCode_col = record.getCommodityCode();
                    comName_col = record.getCommodityName();
                    
                    elecPart_name.add(comName_col);
                    elecPart_code.add(comCode_col);
                }
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, e.toString());
            }

    }
    
    public void DoConnect_netPart(){
            
            netPart_name = new ArrayList<>();
            netPart_code = new ArrayList<>();

            try{
                em.getEntityManagerFactory().getCache().evictAll();
                Query q = em.createNamedQuery("NetworkingPeripheralCommodity.findAll");
                List<NetworkingPeripheralCommodity> list = q.getResultList();
                
                for(NetworkingPeripheralCommodity record: list){
                    comCode_col = record.getCommodityCode();
                    comName_col = record.getCommodityName();
                    
                    netPart_name.add(comName_col);
                    netPart_code.add(comCode_col);
                }
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, e.toString());
            }

    }
    
    public void DoConnect_conPart(){
            
            conPart_name = new ArrayList<>();
            conPart_code = new ArrayList<>();

            try{
                em.getEntityManagerFactory().getCache().evictAll();
                Query q = em.createNamedQuery("ConsumableParts.findAll");
                List<ConsumableParts> list = q.getResultList();
                
                for(ConsumableParts record: list){
                    comCode_col = record.getCommodityCode();
                    comName_col = record.getCommodityName();
                    
                    conPart_name.add(comName_col);
                    conPart_code.add(comCode_col);
                }
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, e.toString());
            }

    }    
    
    public void updateMain(PartNumberData partNum, String m_part, String m_cat, String m_des, Date m_date, String m_aut, String m_config) throws Exception{
        em.getEntityManagerFactory().getCache().evictAll();
        em.getTransaction().begin();
        em.remove(partNum);
        em.flush();
        em.getTransaction().commit();
        
        em.getEntityManagerFactory().getCache().evictAll();
        em.clear();
        em.getTransaction().begin();
        PartNumberData new_data = new PartNumberData();
        new_data.setPartNumber(m_part);
        new_data.setCategory(m_cat);
        new_data.setDescription(m_des);
        new_data.setGeneratedDate(m_date);
        new_data.setAuthor(m_aut);
        new_data.setConfiguration(m_config);
        em.persist(new_data);
        em.flush();
        em.getTransaction().commit();
    }
    
    public void updateTba(DataUsers tba, String m_part, String m_cat, String m_des, Date m_date, String m_aut, String m_config) throws Exception{
        em.getEntityManagerFactory().getCache().evictAll();
        em.getTransaction().begin();
        em.remove(tba);
        em.flush();
        em.getTransaction().commit();
        
        em.getEntityManagerFactory().getCache().evictAll();
        em.clear();
        em.getTransaction().begin();
        DataUsers new_data = new DataUsers();
        new_data.setPartNumber(m_part);
        new_data.setCategory(m_cat);
        new_data.setDescription(m_des);
        new_data.setGeneratedDate(m_date);
        new_data.setAuthor(m_aut);
        new_data.setConfiguration(m_config);
        em.persist(new_data);
        em.flush();
        em.getTransaction().commit();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg_pan3 = new javax.swing.JPanel();
        input_pan = new javax.swing.JPanel();
        lbl_cateogry = new javax.swing.JLabel();
        cmb_name = new javax.swing.JComboBox<>();
        cmb_scheme = new javax.swing.JComboBox<>();
        merge_pan = new javax.swing.JPanel();
        projDate_pan = new javax.swing.JPanel();
        txt_year = new javax.swing.JTextField();
        cmb_month = new javax.swing.JComboBox<>();
        cmb_day = new javax.swing.JComboBox<>();
        lbl_year = new javax.swing.JLabel();
        lbl_month = new javax.swing.JLabel();
        lbl_day = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btn_generate = new javax.swing.JButton();
        seq_pan = new javax.swing.JPanel();
        txt_seq = new javax.swing.JTextField();
        config_pan = new javax.swing.JPanel();
        txt_config = new javax.swing.JTextField();
        des_pan = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_des = new javax.swing.JTextArea();
        lbl_cateogry1 = new javax.swing.JLabel();
        aut_pan = new javax.swing.JPanel();
        cmb_aut = new javax.swing.JComboBox<>();
        btn_save = new javax.swing.JButton();
        btn_back = new javax.swing.JButton();
        generated_pan = new javax.swing.JPanel();
        lbl_genPartNum = new javax.swing.JLabel();
        lbl_oldpn = new javax.swing.JLabel();
        sep = new javax.swing.JSeparator();

        setMinimumSize(new java.awt.Dimension(750, 450));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        bg_pan3.setBackground(new java.awt.Color(204, 204, 255));
        bg_pan3.setMaximumSize(new java.awt.Dimension(800, 500));
        bg_pan3.setMinimumSize(new java.awt.Dimension(800, 500));
        bg_pan3.setLayout(null);

        input_pan.setBackground(new java.awt.Color(204, 204, 204));
        input_pan.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Modify the following data", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Miriam Fixed", 1, 20), new java.awt.Color(255, 255, 255))); // NOI18N
        input_pan.setMaximumSize(new java.awt.Dimension(484, 383));
        input_pan.setMinimumSize(new java.awt.Dimension(484, 383));
        input_pan.setLayout(null);

        lbl_cateogry.setFont(new java.awt.Font("Miriam Fixed", 1, 20)); // NOI18N
        lbl_cateogry.setForeground(new java.awt.Color(255, 255, 255));
        lbl_cateogry.setText("Category :");
        lbl_cateogry.setMaximumSize(new java.awt.Dimension(32767, 32767));
        input_pan.add(lbl_cateogry);
        lbl_cateogry.setBounds(10, 30, 221, 21);

        cmb_name.setBackground(new java.awt.Color(204, 204, 255));
        cmb_name.setFont(new java.awt.Font("Miriam", 0, 20)); // NOI18N
        input_pan.add(cmb_name);
        cmb_name.setBounds(10, 110, 420, 33);

        cmb_scheme.setBackground(new java.awt.Color(204, 204, 255));
        cmb_scheme.setFont(new java.awt.Font("Miriam", 0, 20)); // NOI18N
        cmb_scheme.setMaximumRowCount(4);
        cmb_scheme.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Consumable Parts", "Networking Peripheral Commodity", "Electrical Part Commodity", "Computer Peripherals Commodity", "Mechanical Part Commodity", "External Released Documents", "Internal Report Documents", "Internal Specification Document", "Internal Process Document" }));
        cmb_scheme.setMinimumSize(new java.awt.Dimension(360, 49));
        cmb_scheme.setPreferredSize(new java.awt.Dimension(360, 49));
        cmb_scheme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_schemeActionPerformed(evt);
            }
        });
        input_pan.add(cmb_scheme);
        cmb_scheme.setBounds(10, 50, 420, 30);

        merge_pan.setBackground(new java.awt.Color(204, 204, 204));

        projDate_pan.setBackground(new java.awt.Color(204, 204, 204));
        projDate_pan.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Project Date :", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Miriam Fixed", 1, 20), new java.awt.Color(255, 255, 255))); // NOI18N
        projDate_pan.setMinimumSize(new java.awt.Dimension(444, 90));

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
        cmb_month.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));
        cmb_month.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_monthActionPerformed(evt);
            }
        });

        cmb_day.setBackground(new java.awt.Color(204, 204, 255));
        cmb_day.setFont(new java.awt.Font("Miriam", 0, 20)); // NOI18N
        cmb_day.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

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
                .addComponent(txt_year, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmb_month, 0, 0, Short.MAX_VALUE)
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
                    .addComponent(txt_year, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                    .addComponent(cmb_day, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cmb_month))
                .addGap(4, 4, 4))
        );

        txt_year.setText("2017");

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setMinimumSize(new java.awt.Dimension(38, 122));

        btn_generate.setBackground(new java.awt.Color(204, 204, 255));
        btn_generate.setFont(new java.awt.Font("Miriam", 0, 20)); // NOI18N
        btn_generate.setText("Check Part Number");
        btn_generate.setMaximumSize(new java.awt.Dimension(32767, 32767));
        btn_generate.setMinimumSize(new java.awt.Dimension(133, 31));
        btn_generate.setPreferredSize(new java.awt.Dimension(133, 31));
        btn_generate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_generateActionPerformed(evt);
            }
        });

        seq_pan.setBackground(new java.awt.Color(204, 204, 204));
        seq_pan.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sequence", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Miriam Fixed", 1, 20), new java.awt.Color(255, 255, 255))); // NOI18N
        seq_pan.setMinimumSize(new java.awt.Dimension(38, 58));

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
                .addComponent(txt_seq)
                .addContainerGap())
        );
        seq_panLayout.setVerticalGroup(
            seq_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt_seq)
        );

        txt_seq.setText("000000");

        config_pan.setBackground(new java.awt.Color(204, 204, 204));
        config_pan.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Configuration", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Miriam Fixed", 1, 20), new java.awt.Color(255, 255, 255))); // NOI18N
        config_pan.setMinimumSize(new java.awt.Dimension(38, 58));

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
            .addComponent(txt_config)
        );

        txt_config.setText("0000");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(config_pan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(seq_pan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_generate, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(seq_pan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(config_pan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_generate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        seq_pan.setVisible(false);
        config_pan.setVisible(false);

        javax.swing.GroupLayout merge_panLayout = new javax.swing.GroupLayout(merge_pan);
        merge_pan.setLayout(merge_panLayout);
        merge_panLayout.setHorizontalGroup(
            merge_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(merge_panLayout.createSequentialGroup()
                .addGroup(merge_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(projDate_pan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 420, Short.MAX_VALUE))
                .addContainerGap())
        );
        merge_panLayout.setVerticalGroup(
            merge_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(merge_panLayout.createSequentialGroup()
                .addComponent(projDate_pan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        projDate_pan.setVisible(false);

        input_pan.add(merge_pan);
        merge_pan.setBounds(10, 150, 430, 270);

        des_pan.setBackground(new java.awt.Color(204, 204, 204));
        des_pan.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Description", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Miriam Fixed", 1, 20), new java.awt.Color(255, 255, 255))); // NOI18N
        des_pan.setLayout(null);

        txt_des.setColumns(20);
        txt_des.setFont(new java.awt.Font("Miriam", 0, 20)); // NOI18N
        txt_des.setLineWrap(true);
        txt_des.setRows(5);
        txt_des.setWrapStyleWord(true);
        jScrollPane1.setViewportView(txt_des);

        des_pan.add(jScrollPane1);
        jScrollPane1.setBounds(16, 22, 258, 116);

        input_pan.add(des_pan);
        des_pan.setBounds(440, 130, 290, 150);

        lbl_cateogry1.setFont(new java.awt.Font("Miriam Fixed", 1, 20)); // NOI18N
        lbl_cateogry1.setForeground(new java.awt.Color(255, 255, 255));
        lbl_cateogry1.setText("Commodity Name : ");
        lbl_cateogry1.setMaximumSize(new java.awt.Dimension(32767, 32767));
        input_pan.add(lbl_cateogry1);
        lbl_cateogry1.setBounds(10, 90, 221, 21);

        aut_pan.setBackground(new java.awt.Color(204, 204, 204));
        aut_pan.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Author", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Miriam Fixed", 1, 20), new java.awt.Color(255, 255, 255))); // NOI18N
        aut_pan.setLayout(null);

        cmb_aut.setBackground(new java.awt.Color(204, 204, 255));
        cmb_aut.setFont(new java.awt.Font("Miriam", 0, 20)); // NOI18N
        aut_pan.add(cmb_aut);
        cmb_aut.setBounds(16, 23, 258, 30);

        input_pan.add(aut_pan);
        aut_pan.setBounds(440, 280, 290, 70);

        btn_save.setBackground(new java.awt.Color(204, 204, 255));
        btn_save.setFont(new java.awt.Font("Miriam", 0, 20)); // NOI18N
        btn_save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/partNumbering_generator/Actions-document-save-as-icon.png"))); // NOI18N
        btn_save.setText("Save");
        btn_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_saveActionPerformed(evt);
            }
        });
        input_pan.add(btn_save);
        btn_save.setBounds(440, 360, 140, 41);

        btn_back.setBackground(new java.awt.Color(204, 204, 255));
        btn_back.setFont(new java.awt.Font("Miriam", 0, 20)); // NOI18N
        btn_back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/partNumbering_generator/Go-back-icon.png"))); // NOI18N
        btn_back.setText("Back");
        btn_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_backActionPerformed(evt);
            }
        });
        input_pan.add(btn_back);
        btn_back.setBounds(590, 360, 140, 41);

        generated_pan.setBackground(new java.awt.Color(204, 204, 204));
        generated_pan.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Part Number", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Miriam Fixed", 1, 20), new java.awt.Color(255, 255, 255))); // NOI18N
        generated_pan.setMinimumSize(new java.awt.Dimension(290, 181));
        generated_pan.setRequestFocusEnabled(false);
        generated_pan.setLayout(null);

        lbl_genPartNum.setFont(new java.awt.Font("Tahoma", 1, 25)); // NOI18N
        lbl_genPartNum.setForeground(new java.awt.Color(255, 255, 255));
        lbl_genPartNum.setText("000-000000-0000");
        lbl_genPartNum.setMaximumSize(new java.awt.Dimension(32767, 32767));
        generated_pan.add(lbl_genPartNum);
        lbl_genPartNum.setBounds(30, 60, 230, 30);
        lbl_genPartNum.setVisible(false);

        lbl_oldpn.setFont(new java.awt.Font("Tahoma", 1, 25)); // NOI18N
        lbl_oldpn.setForeground(new java.awt.Color(255, 255, 255));
        lbl_oldpn.setText("000-000000-0000");
        lbl_oldpn.setMaximumSize(new java.awt.Dimension(32767, 32767));
        generated_pan.add(lbl_oldpn);
        lbl_oldpn.setBounds(30, 30, 230, 30);
        generated_pan.add(sep);
        sep.setBounds(10, 60, 270, 10);
        sep.setVisible(false);

        input_pan.add(generated_pan);
        generated_pan.setBounds(440, 20, 290, 110);

        bg_pan3.add(input_pan);
        input_pan.setBounds(10, 10, 740, 430);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg_pan3, javax.swing.GroupLayout.PREFERRED_SIZE, 760, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg_pan3, javax.swing.GroupLayout.PREFERRED_SIZE, 450, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmb_schemeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_schemeActionPerformed
        Calendar now = Calendar.getInstance();
        int year = now.get(Calendar.YEAR);
        String yr = Integer.toString(year);
        
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
                txt_year.setText(yr);
                txt_seq.setText("000000");
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
                txt_year.setText(yr);
                txt_seq.setText("000000");
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
                txt_year.setText(yr);
                txt_seq.setText("000000");
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
                txt_year.setText(yr);
                txt_seq.setText("000000");
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
                txt_year.setText(yr);
                txt_seq.setText("000000");
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
                txt_year.setText(yr);
                txt_seq.setText("000000");
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
                txt_year.setText(yr);
                txt_seq.setText("000000");
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
                txt_year.setText(yr);
                txt_seq.setText("000000");
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
                txt_year.setText(yr);
                txt_seq.setText("000000");
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

    private void txt_yearKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_yearKeyTyped
        if (txt_year.getText().length() >= 4 )
            evt.consume();
        txt_config.setEditable(true);
    }//GEN-LAST:event_txt_yearKeyTyped

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

    private void txt_seqKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_seqKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            if(txt_seq.getText().length() == 6)
                txt_config.requestFocus();
            else{
                JOptionPane.showMessageDialog(this, "Sequence Number must be 6 digits!! \n Try Again.", "Error!", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_txt_seqKeyPressed

    private void txt_seqKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_seqKeyTyped
        if (txt_seq.getText().length() >= 6 )
            evt.consume();
        txt_config.setEditable(true);
    }//GEN-LAST:event_txt_seqKeyTyped

    private void txt_configKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_configKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            if(txt_config.getText().length() == 4)
                txt_des.requestFocus();
            else{
                JOptionPane.showMessageDialog(this, "Configuration Number must be 4 digits!! \n Try Again.", "Error!", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_txt_configKeyPressed

    private void txt_configKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_configKeyTyped
        if (txt_config.getText().length() >= 4 )
            evt.consume();
        txt_des.setEditable(true);
    }//GEN-LAST:event_txt_configKeyTyped

    private void btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveActionPerformed
        btn_generate.doClick();

        PartNumberData pn_data = null;
        DataUsers tba_data = null;

        if(ty.equals("main")){
            em.getEntityManagerFactory().getCache().evictAll();
            Query q = em.createNamedQuery("PartNumberData.findByPartNumber")
                    .setParameter("partNumber", pn);
            pn_data = (PartNumberData) q.getSingleResult();
        }
        else if(ty.equals("tba")){
            em.getEntityManagerFactory().getCache().evictAll();
            Query q = em.createNamedQuery("DataUsers.findByPartNumber")
                    .setParameter("partNumber", pn);
            tba_data = (DataUsers) q.getSingleResult();
        }

        String val1 = lbl_genPartNum.getText();
        String val2 = cmb_scheme.getSelectedItem().toString();
        String val3 = txt_des.getText();
        String val4 = cmb_aut.getSelectedItem().toString();
        String val5 = txt_config.getText();
        
        try{
            em.getEntityManagerFactory().getCache().evictAll();
            Query q = em.createNamedQuery("Admins.findByUsername")
                    .setParameter("username", Account.getUser());
            logged_admin = (Admins) q.getSingleResult();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println(message);
        if("ok".equals(message)){
        JPasswordField pwd = new JPasswordField();
        int action = JOptionPane.showConfirmDialog(null, pwd,"Enter " + logged_admin.getUsername() + "'s Password",JOptionPane.OK_CANCEL_OPTION);
        switch(action){
            case 0:
                if(pwd.getText().equals(logged_admin.getPassword())){
                    Object[] options = {"Yes","No"};
                    int opt = JOptionPane.showOptionDialog(this, "Are you sure you want to modify the data?", "WARNING!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,null,options,options[1]);
                    switch (opt){
                        case 0:
                            try {
                                if(ty.equals("main")){
                                    updateMain(pn_data, val1, val2, val3, date, val4, val5);
                                }
                                else if(ty.equals("tba")){
                                    updateTba(tba_data, val1, val2, val3, date, val4, val5);
                                }
                                JOptionPane.showMessageDialog(null, "Database has been Updated !");
                            } catch (Exception e){
                                JOptionPane.showMessageDialog(null, e);
                            }
                            break;
                        case 1:
                            break;
                    }
                }
                else{
                    JOptionPane.showMessageDialog(this, "WRONG PASSWORD", "ERROR", JOptionPane.ERROR_MESSAGE);
                    btn_save.doClick();
                    }
                break;
            case 1:
                break;
            }
        this.setVisible(false);
        new mod_pn(ty, lbl_genPartNum.getText(), cmb_scheme.getSelectedItem().toString(), txt_des.getText(), date, cmb_aut.getSelectedItem().toString(), txt_config.getText()).setVisible(true);
        }
        else if("no".equals(message)){
            
        }
    }//GEN-LAST:event_btn_saveActionPerformed

    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backActionPerformed
        this.setVisible(false);
        new mod_pn(ty, pn, cat, des, date, aut, con).setVisible(true);
    }//GEN-LAST:event_btn_backActionPerformed

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
        }
        else if(Integer.parseInt(txt_year.getText())>year){
            JOptionPane.showMessageDialog(this, "Wrong inputted year! \n\nTry Again.", "Wrong Input", JOptionPane.ERROR_MESSAGE);
        }
        else if(Integer.parseInt(txt_year.getText()) == year && cmb_month.getSelectedIndex() > month){
            JOptionPane.showMessageDialog(this, "Wrong inputted month of the current year! \n\nTry Again.", "Wrong Input", JOptionPane.ERROR_MESSAGE);
        }
        else if(Integer.parseInt(txt_year.getText()) == year && cmb_month.getSelectedIndex() == month && Integer.parseInt(cmb_day.getSelectedItem().toString()) > day){
            JOptionPane.showMessageDialog(this, "Wrong inputted day of the current month & year! \n\nTry Again.", "Wrong Input", JOptionPane.ERROR_MESSAGE);
        }
        else if(txt_seq.getText().length() != 6){
            JOptionPane.showMessageDialog(this, "Sequence Number must have 6 digits!! \n\nTry Again.", "Wrong Input", JOptionPane.ERROR_MESSAGE);
        }
        else if(txt_config.getText().length() != 4){
            JOptionPane.showMessageDialog(this, "Configuration Number must have 4 digits!! \n\nTry Again.", "Wrong Input", JOptionPane.ERROR_MESSAGE);
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
            lbl_oldpn.setForeground(Color.red);
            sep.setVisible(true);
            lbl_genPartNum.setVisible(true);
            lbl_genPartNum.setText(suffix);
        }
        
        
        String gen_pn = lbl_genPartNum.getText();
        
        if(gen_pn.equals(pn)){
            btn_save.setEnabled(true);
            lbl_genPartNum.setForeground(Color.white);
            message = "ok";
        }
        else{
            boolean valid_pn = false;
            boolean isUserData = false;

            try{
                em.getEntityManagerFactory().getCache().evictAll();
                Query q = em.createNamedQuery("DataUsers.findByPartNumber")
                        .setParameter("partNumber", gen_pn);
                DataUsers data = (DataUsers) q.getSingleResult();
                isUserData = true;
            }
            catch(NoResultException e){

            }
            try{
                em.getEntityManagerFactory().getCache().evictAll();
                em.clear();
                Query q = em.createNamedQuery("PartNumberData.findByPartNumber")
                        .setParameter("partNumber", gen_pn);
                PartNumberData data = (PartNumberData) q.getSingleResult();
            }
            catch(NoResultException e){
                if(!isUserData){
                    valid_pn = true;
                }
            }

            if(valid_pn){
                message = "ok";
                btn_save.setEnabled(true);
                lbl_genPartNum.setForeground(Color.white);
            }
            else{
                message = "no";
                JOptionPane.showMessageDialog(this, "Similar Part Number!!! \n Try Again.","Error", JOptionPane.ERROR_MESSAGE);
                lbl_genPartNum.setForeground(Color.BLUE);
            }
        }
    }//GEN-LAST:event_btn_generateActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        new mod_pn(ty, pn, cat, des, date, aut, con).setVisible(true);
    }//GEN-LAST:event_formWindowClosing

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
            java.util.logging.Logger.getLogger(generate_modify.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(generate_modify.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(generate_modify.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(generate_modify.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new generate_modify(null, null, null, null, null, null, null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel aut_pan;
    private javax.swing.JPanel bg_pan3;
    private javax.swing.JButton btn_back;
    private javax.swing.JButton btn_generate;
    private javax.swing.JButton btn_save;
    private javax.swing.JComboBox<String> cmb_aut;
    private javax.swing.JComboBox<String> cmb_day;
    private javax.swing.JComboBox<String> cmb_month;
    private javax.swing.JComboBox<String> cmb_name;
    private javax.swing.JComboBox<String> cmb_scheme;
    private javax.swing.JPanel config_pan;
    private javax.swing.JPanel des_pan;
    private javax.swing.JPanel generated_pan;
    private javax.swing.JPanel input_pan;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_cateogry;
    private javax.swing.JLabel lbl_cateogry1;
    private javax.swing.JLabel lbl_day;
    private javax.swing.JLabel lbl_genPartNum;
    private javax.swing.JLabel lbl_month;
    private javax.swing.JLabel lbl_oldpn;
    private javax.swing.JLabel lbl_year;
    private javax.swing.JPanel merge_pan;
    private javax.swing.JPanel projDate_pan;
    private javax.swing.JSeparator sep;
    private javax.swing.JPanel seq_pan;
    private javax.swing.JTextField txt_config;
    private javax.swing.JTextArea txt_des;
    private javax.swing.JTextField txt_seq;
    private javax.swing.JTextField txt_year;
    // End of variables declaration//GEN-END:variables
}
