package partNumbering_generator;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Denise Furaque
 */
public class exportToCSV {
    
    static private String host_address;
    
    public exportToCSV(){
        
    }
    
    public void export(){
        
        try{
            
            Scanner s = new Scanner(new FileReader("host.txt"));
            host_address = s.nextLine();
            
            try{
                FileWriter fw = new FileWriter("part_number_csv.csv");
                Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
                Connection conn = DriverManager.getConnection("jdbc:derby://" + host_address + "/partNumbering  ", "Admin01", "07032017");
                String query  = "SELECT * FROM PART_NUMBER_DATA";
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                
                ResultSetMetaData metadata = rs.getMetaData();
                int columnCount = metadata.getColumnCount();
                
                for(int i=1; i<=columnCount; i++){
                    String columnName = metadata.getColumnName(i);
                    fw.append(columnName);
                    fw.append(',');
                }
                
                fw.append('\n');
                
                while(rs.next())
                {
                    fw.append(rs.getString(1));
                    fw.append(',');
                    fw.append(rs.getString(2));
                    fw.append(',');
                    fw.append(rs.getString(3));
                    fw.append(',');
                    fw.append(rs.getString(4));
                    fw.append(',');
                    fw.append(rs.getString(5));
                    fw.append(',');
                    fw.append(rs.getString(6));
                    fw.append('\n');
                }
                fw.flush();
                fw.close();
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(exportToCSV.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
}
