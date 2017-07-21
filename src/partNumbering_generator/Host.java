/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package partNumbering_generator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ojt
 */
public class Host {
    static private String host_address;
    
    public Host(){
    }
    
    public static String getHost(){
        try {
            Scanner s = new Scanner(new FileReader("host.txt"));
            host_address = s.nextLine();
        } 
        catch (Exception e) {
            host_address = "localhost";
        }
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
