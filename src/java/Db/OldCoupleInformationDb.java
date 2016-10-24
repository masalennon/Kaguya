/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Db;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Masanari
 */
@Stateless
public class OldCoupleInformationDb {
    
    @PersistenceContext
    private EntityManager em;
    
    public void create(OldCoupleInformation oci) {
        em.persist(oci);
    }
}
