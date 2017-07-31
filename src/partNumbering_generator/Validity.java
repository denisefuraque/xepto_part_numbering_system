/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package partNumbering_generator;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JOptionPane;

/**
 *
 * @author ojt
 */
public class Validity {
    private static EntityManager em;
    
    public static boolean check_pn(String pn){
        try{
            em = Persistence.createEntityManagerFactory("partNumberingPU", Host.getPersistence()).createEntityManager();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.toString());
        }         
        
        boolean isUserData = false;
        
        try{
            em.getEntityManagerFactory().getCache().evictAll();
            Query q = em.createNamedQuery("DataUsers.findByPartNumber")
                    .setParameter("partNumber", pn);
            q.getSingleResult();
            isUserData = true;
        }
        catch(NoResultException e){
            
        }
        
        try{
            em.getEntityManagerFactory().getCache().evictAll();
            em.clear();
            Query q = em.createNamedQuery("PartNumberData.findByPartNumber")
                    .setParameter("partNumber", pn);
            q.getSingleResult();
        }
        catch(NoResultException e){
            if(!isUserData){
                return true;
            }
        }
        return false;
    }
}
