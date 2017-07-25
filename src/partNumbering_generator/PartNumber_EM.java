/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package partNumbering_generator;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

/**
 *
 * @author ojt
 */
public class PartNumber_EM {
    private static EntityManager em;
    
    public PartNumber_EM(){
        
    }
    
    public static void initEM(){
        try{
            em = Persistence.createEntityManagerFactory("partNumberingPU", Host.getPersistence()).createEntityManager();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.toString());
        }   
    }
    
    public static EntityManager getEM(){
        return em;
    }
}
