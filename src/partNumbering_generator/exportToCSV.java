package partNumbering_generator;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JOptionPane;

/**
 *
 * @author Denise Furaque
 */
public class exportToCSV {
    
    static private String host_address;
    
    EntityManager em;
    
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
            
            Scanner s = new Scanner(new FileReader("host.txt"));
            host_address = s.nextLine();
            
            try{
                FileWriter fw = new FileWriter("part_number_csv.csv");
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
        } catch (FileNotFoundException ex) {
                Logger.getLogger(exportToCSV.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
}
