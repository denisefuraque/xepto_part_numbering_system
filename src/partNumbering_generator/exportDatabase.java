package partNumbering_generator;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class exportDatabase {
        
        String host_address = Host.getHost();
            
    public void main(String[] args) {
        
        //String host_address = Host.getHost();
        
        String filename ="Desktop:generated_part_number.csv";
        try {
            FileWriter fw = new FileWriter(filename);
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            Connection conn = DriverManager.getConnection("jdbc:derby://" + host_address + "/partNumbering  " ,"Admin01","07032017");
            String query = "select * from part_number_data";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                fw.append(rs.getString(1));
                fw.append(',');
                fw.append(rs.getString(2));
                fw.append(',');
                fw.append(rs.getString(3));
                fw.append('\n');
               }
            fw.flush();
            fw.close();
            conn.close();
            System.out.println("CSV File is created successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}