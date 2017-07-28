package partNumbering_generator;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JOptionPane;

/**
 *
 * @author Denise Furaque
 */
public class exportToCSV {
    
    private EntityManager em;
    
    public exportToCSV(){
        
    }
    
    public void export(){
        
        try{
            em = Persistence.createEntityManagerFactory("partNumberingPU", Host.getPersistence()).createEntityManager();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.toString());
        }
        
        try{
            String date = new SimpleDateFormat("YYYY-MM-dd").format(Calendar.getInstance().getTime());
            FileWriter fw = new FileWriter("Part Number (" + date + ").csv");
            em.getEntityManagerFactory().getCache().evictAll();
            Query q_fw = em.createNamedQuery("PartNumberData.findAll");
            List<PartNumberData> list_data = q_fw.getResultList();
            
            fw.append("Part Number");
            fw.append(',');
            fw.append("Category");
            fw.append(',');
            fw.append("Description");
            fw.append(',');
            fw.append("Generated Date");
            fw.append(',');
            fw.append("Author");
            fw.append(',');
            fw.append("Configuration");
            fw.append('\n');
            
            for(PartNumberData d: list_data)
            {
                fw.append(d.getPartNumber());
                fw.append(',');
                fw.append(d.getCategory());
                fw.append(',');
                fw.append(d.getDescription());
                fw.append(',');
                fw.append(d.getGeneratedDate().toString());
                fw.append(',');
                fw.append(d.getAuthor());
                fw.append(',');
                fw.append(d.getConfiguration());
                fw.append('\n');
            }
            fw.flush();
            fw.close();
            JOptionPane.showMessageDialog(null, "CSV File is created successfully.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,"The process cannot access the file because \n     it is being used by another process \nClose the file first before saving\n\n CSV failed to save.","ERROR OCCURED!",JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
}
