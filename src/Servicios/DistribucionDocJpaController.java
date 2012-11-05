/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import ClassEntidad.DistribucionDoc;
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
public class DistribucionDocJpaController implements Serializable {

    public DistribucionDocJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(DistribucionDoc distribucionDoc) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(distribucionDoc);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findDistribucionDoc(distribucionDoc.getId()) != null) {
                throw new PreexistingEntityException("DistribucionDoc " + distribucionDoc + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(DistribucionDoc distribucionDoc) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            distribucionDoc = em.merge(distribucionDoc);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = distribucionDoc.getId();
                if (findDistribucionDoc(id) == null) {
                    throw new NonexistentEntityException("The distribucionDoc with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            DistribucionDoc distribucionDoc;
            try {
                distribucionDoc = em.getReference(DistribucionDoc.class, id);
                distribucionDoc.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The distribucionDoc with id " + id + " no longer exists.", enfe);
            }
            em.remove(distribucionDoc);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<DistribucionDoc> findDistribucionDocEntities() {
        return findDistribucionDocEntities(true, -1, -1);
    }

    public List<DistribucionDoc> findDistribucionDocEntities(int maxResults, int firstResult) {
        return findDistribucionDocEntities(false, maxResults, firstResult);
    }

    private List<DistribucionDoc> findDistribucionDocEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(DistribucionDoc.class));
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

    public DistribucionDoc findDistribucionDoc(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(DistribucionDoc.class, id);
        } finally {
            em.close();
        }
    }

    public int getDistribucionDocCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<DistribucionDoc> rt = cq.from(DistribucionDoc.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
