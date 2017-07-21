/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package partNumbering_generator;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

/**
 *
 * @author ojt
 */
public class Host {
    static private String host_address;
    
    public Host(){
    }
    
    public static void fetchHost(){
        try {
            Scanner s = new Scanner(new FileReader("host.txt"));
            host_address = s.nextLine();
        } 
        catch (Exception e) {
            host_address = "localhost";
        }
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
    }
}
