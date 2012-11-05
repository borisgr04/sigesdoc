/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import ClassEntidad.PerExterna;
import Servicios.exceptions.NonexistentEntityException;
import Servicios.exceptions.PreexistingEntityException;
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
public class PerExternaJpaController implements Serializable {

    public PerExternaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PerExterna perExterna) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(perExterna);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPerExterna(perExterna.getNroIde()) != null) {
                throw new PreexistingEntityException("PerExterna " + perExterna + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PerExterna perExterna) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            perExterna = em.merge(perExterna);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = perExterna.getNroIde();
                if (findPerExterna(id) == null) {
                    throw new NonexistentEntityException("The perExterna with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PerExterna perExterna;
            try {
                perExterna = em.getReference(PerExterna.class, id);
                perExterna.getNroIde();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The perExterna with id " + id + " no longer exists.", enfe);
            }
            em.remove(perExterna);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PerExterna> findPerExternaEntities() {
        return findPerExternaEntities(true, -1, -1);
    }

    public List<PerExterna> findPerExternaEntities(int maxResults, int firstResult) {
        return findPerExternaEntities(false, maxResults, firstResult);
    }

    private List<PerExterna> findPerExternaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PerExterna.class));
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

    public PerExterna findPerExterna(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PerExterna.class, id);
        } finally {
            em.close();
        }
    }

    public int getPerExternaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PerExterna> rt = cq.from(PerExterna.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
