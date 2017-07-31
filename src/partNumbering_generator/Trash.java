/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package partNumbering_generator;

import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JOptionPane;

/**
 *
 * @author ojt
 */
public class Trash {
    private EntityManager em;
    private int id;
    private String type;
    
    private String pn, category, description, author, config;
    private Date genDate;
    
    private String username, fName, lName, job, pass;
    
    public Trash(String _pn, String _category, String _description, Date _genDate, String _author, String _config){
        try{
            em = Persistence.createEntityManagerFactory("partNumberingPU", Host.getPersistence()).createEntityManager();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.toString());
        }  
        
        try{
            em.getEntityManagerFactory().getCache().evictAll();  
            Query q = em.createNativeQuery("SELECT * FROM TRASH_PN ORDER BY ID DESC", TrashPn.class);
            TrashPn last = (TrashPn) q.setMaxResults(1).getSingleResult();
            id = last.getId()+1;
        }
        catch(NoResultException e){
            id = 1;
        }
        
        type = "pn";
        pn = _pn;
        category = _category;
        description = _description;
        genDate = _genDate;
        author = _author;
        config = _config;
    }
    
    public Trash(String _username, String _fName, String _lName, String _job, String _pass){
        try{
            em = Persistence.createEntityManagerFactory("partNumberingPU", Host.getPersistence()).createEntityManager();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.toString());
        }  
        
        try{
            em.getEntityManagerFactory().getCache().evictAll();  
            Query q = em.createNativeQuery("SELECT * FROM TRASH_USERS ORDER BY ID DESC", TrashUsers.class);
            TrashUsers last = (TrashUsers) q.setMaxResults(1).getSingleResult();
            id = last.getId()+1;
        }
        catch(NoResultException e){
            id = 1;
        }
        
        type = "user";
        username = _username;
        fName = _fName;
        lName = _lName;
        job = _job;
        pass = _pass;
    }
    
    public void addToDb(){
        if(type.equals("pn")){
            try{
                TrashPn trash = new TrashPn();
                trash.setId(id);
                trash.setPartNumber(pn);
                trash.setCategory(category);
                trash.setDescription(description);
                trash.setGeneratedDate(genDate);
                trash.setAuthor(author);
                trash.setConfiguration(config);

                em.getEntityManagerFactory().getCache().evictAll();                    
                em.getTransaction().begin();
                em.persist(trash);
                em.flush();
                em.getTransaction().commit();                        
            }
            catch(Exception e){
                System.out.println(e.toString());
            }
        }
        
        else if(type.equals("user")){
            try{
                TrashUsers trash = new TrashUsers();
                trash.setFirstName(fName);
                trash.setId(id);
                trash.setJobTitle(job);
                trash.setLastName(lName);
                trash.setPassword(pass);
                trash.setUsername(username);
                
                em.getEntityManagerFactory().getCache().evictAll();                    
                em.getTransaction().begin();
                em.persist(trash);
                em.flush();
                em.getTransaction().commit(); 
            }
            catch(Exception e){
                System.out.println(e.toString());
            }
        }
        else{
            System.out.println("Unknown type of trash");
        }
    }
}
