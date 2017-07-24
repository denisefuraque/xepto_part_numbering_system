/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package partNumbering_generator;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Map;

/**
 *
 * @author ojt
 */
public class Host {
    static private String host_address;
    static private Map persistenceMap;
    
    public Host(){
        
    }
    
    public static void fetchHost(){
        try {
            Scanner s = new Scanner(new FileReader("host.txt"));
            host_address = s.nextLine();
        } 
        catch (FileNotFoundException e) {
            host_address = "localhost";
        }
        
        updatePersistenceAddress();
    }
    
    public static String getHost(){
        return host_address;
    }
    
    public static void setHost(String address){
        try {
            host_address = address;
            FileWriter writer = new FileWriter("host.txt");
            writer.write(host_address);
            writer.flush();
            writer.close();
        } catch (Exception ex) {
            
        }
        
        updatePersistenceAddress();
    }
    
    public static void updatePersistenceAddress(){
        persistenceMap = new HashMap();
        persistenceMap.put("javax.persistence.jdbc.url", "jdbc:derby://" + host_address + "/partNumbering");
    }
    
    public static Map getPersistence(){
        return persistenceMap;
    }
    
}
