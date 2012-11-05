/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import ClassEntidad.DocExterno;
import Servicios.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Boris
 */
public class DocExternoJpaController implements Serializable {

    public DocExternoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(DocExterno docExterno) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(docExterno);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(DocExterno docExterno) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            docExterno = em.merge(docExterno);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = docExterno.getNoDocumento();
                if (findDocExterno(id) == null) {
                    throw new NonexistentEntityException("The docExterno with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            DocExterno docExterno;
            try {
                docExterno = em.getReference(DocExterno.class, id);
                docExterno.getNoDocumento();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The docExterno with id " + id + " no longer exists.", enfe);
            }
            em.remove(docExterno);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<DocExterno> findDocExternoEntities() {
        return findDocExternoEntities(true, -1, -1);
    }

    public List<DocExterno> findDocExternoEntities(int maxResults, int firstResult) {
        return findDocExternoEntities(false, maxResults, firstResult);
    }

    private List<DocExterno> findDocExternoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(DocExterno.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public DocExterno findDocExterno(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(DocExterno.class, id);
        } finally {
            em.close();
        }
    }

    public int getDocExternoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<DocExterno> rt = cq.from(DocExterno.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
