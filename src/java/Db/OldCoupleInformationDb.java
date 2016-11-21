/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Db;


import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 *
 * @author Masanari
 * @param <T>
 */
@Stateful
//@Transactional

public class OldCoupleInformationDb implements Serializable{
    
    @PersistenceContext
    private EntityManager em;

    public void create(OldCoupleInformation oldCoupleInformation) {
        
        em.persist(oldCoupleInformation);
    }

    public void update(OldCoupleInformation oldCoupleInformation) {
        em.merge(oldCoupleInformation);
    }

    public void delete(OldCoupleInformation oldCoupleInformation) {
        em.remove(em.merge(oldCoupleInformation));  // mergしてから削除する
    }

    public OldCoupleInformation find(Integer key) {
        return em.find(OldCoupleInformation.class, key);
    }

    public List<OldCoupleInformation> getAll() {
        return em.createQuery("SELECT c FROM OldCoupleInformation c").getResultList();
    }   
}
