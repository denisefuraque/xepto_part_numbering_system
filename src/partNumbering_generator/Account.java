/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package partNumbering_generator;

/**
 *
 * @author Denise Furaque
 */
public class Account {
    static private String userName;
    static private String userType;
    
    public Account(){
        
    }
    
    public static String getUser(){
        return userName;
    }
    
    public static void setUser(String name){
        try {
            userName = name;
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    
    public static void setType(String type){
        userType = type;
    }
    public static String getType(){
        return userType;
    }
    
}
