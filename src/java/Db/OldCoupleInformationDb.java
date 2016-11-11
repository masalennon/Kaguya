/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Db;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Masanari
 * @param <T>
 */
@Stateless
public class OldCoupleInformationDb<T> {
    
    @PersistenceContext
    private EntityManager em;
    
    public void create(T entity) {
        em.merge(entity);
    }
    
}
