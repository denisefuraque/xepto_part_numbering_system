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
    private String pn, category, description, author, config;
    private Date genDate;
    
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
        
        pn = _pn;
        category = _category;
        description = _description;
        genDate = _genDate;
        author = _author;
        config = _config;
    }
    public void addToDb(){
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
}
