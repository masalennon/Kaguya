/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Db;

import java.io.Serializable;
import java.util.List;
import static javafx.scene.input.KeyCode.T;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

/**
 *
 * @author Masanari
 * @param <T>
 */
@Stateful
//@Transactional

public class OldCoupleInformationDb<T> implements Serializable {

    @PersistenceContext
    private EntityManager em;
    protected Class<T> entityClass;

//    public OldCoupleInformationDb(Class<T> entityClass) {
//		this.entityClass = entityClass;
//	}
    public void create(OldCoupleInformation oldCoupleInformation) {
        em.persist(oldCoupleInformation);
    }

    public void createa(ParentEntity parentEntity) {
        em.persist(parentEntity);
    }

    public void update(OldCoupleInformation oldCoupleInformation) {
        em.merge(oldCoupleInformation);
    }

    public void delete(OldCoupleInformation oldCoupleInformation) {
        em.remove(em.merge(oldCoupleInformation));  // mergしてから削除する
    }

//    public OldCoupleInformation find(Integer key) {
//        return em.find(OldCoupleInformation.class, key);
//    }
    public OldCoupleInformation find(Integer id) throws IllegalArgumentException {
        return em.find(OldCoupleInformation.class, id);
    }

    public OldCoupleInformation findByAddress(String addressOne) {
        return em.find(OldCoupleInformation.class, addressOne);
    }

    public List<OldCoupleInformation> getAll() {
        return em.createQuery("SELECT c FROM OldCoupleInformation c").getResultList();
    }
//    
//        public OldCoupleInformation findById(Integer id) {
//        return em.createQuery("SELECT c FROM OldCoupleInformation c where c.id = :id");
//    }

    public List<OldCoupleInformation> filterTable(String search) {
        if (search != null) {
            Query query = em.createQuery("SELECT c FROM OldCoupleInformation c WHERE c.addressOne LIKE　:search", OldCoupleInformation.class);
            query.setParameter("search", "%" + search + "%"); //searchを含む文章を検索できる
            return query.getResultList();
//        OldCoupleInformation result = (OldCoupleInformation) query.getResultList();
//        return (List) result;
        } else {
            return getAll();
        }

    }

    public OldCoupleInformation searchToEdit(String mailAddress, Integer id) {
        Query query = em.createQuery("SELECT c FROM OldCoupleInformation c WHERE c.mailAddress =　:mailAddress and c.id = :id", OldCoupleInformation.class);
        query.setParameter("mailAddress", mailAddress);
        query.setParameter("id", id);
        if (query.getResultList() != null) {
            System.out.println("-----------------editList is NOT null------------------");

            return (OldCoupleInformation)query.getSingleResult();
        } else {
            System.out.println("-----------------editList is null------------------");
            return null;
        }
//        OldCoupleInformation result = (OldCoupleInformation) query.getResultList();
//        return (List) result;

    }

    public List<OldCoupleInformation> getAllItems() {
        String queryText = "SELECT item FROM Item as item ORDER BY item.title";
        TypedQuery<OldCoupleInformation> query = em.createQuery(queryText, OldCoupleInformation.class);
        List<OldCoupleInformation> allItems = query.getResultList();
        return allItems;
    }

    public int count() {
        javax.persistence.criteria.CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<OldCoupleInformation> rt = cq.from(OldCoupleInformation.class);
        cq.select(em.getCriteriaBuilder().count(rt));
        javax.persistence.Query q = em.createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }

    public List<OldCoupleInformation> findRange(int[] range) {
        javax.persistence.criteria.CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(OldCoupleInformation.class));
        javax.persistence.Query q = em.createQuery(cq);
        q.setMaxResults(range[1] - range[0]);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

}
