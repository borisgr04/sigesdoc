/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import ClassEntidad.ActaTraslado;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import ClassEntidad.Dependencia;
import Servicios.exceptions.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author borsigr04
 */
public class ActaTrasladoService implements Serializable {

    public ActaTrasladoService(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ActaTraslado actaTraslado) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Dependencia dependencia = actaTraslado.getDependencia();
            if (dependencia != null) {
                dependencia = em.getReference(dependencia.getClass(), dependencia.getId());
                actaTraslado.setDependencia(dependencia);
            }
            em.persist(actaTraslado);
            if (dependencia != null) {
                dependencia.getActaTraslados().add(actaTraslado);
                dependencia = em.merge(dependencia);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ActaTraslado actaTraslado) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ActaTraslado persistentActaTraslado = em.find(ActaTraslado.class, actaTraslado.getNroActa());
            Dependencia dependenciaOld = persistentActaTraslado.getDependencia();
            Dependencia dependenciaNew = actaTraslado.getDependencia();
            if (dependenciaNew != null) {
                dependenciaNew = em.getReference(dependenciaNew.getClass(), dependenciaNew.getId());
                actaTraslado.setDependencia(dependenciaNew);
            }
            actaTraslado = em.merge(actaTraslado);
            if (dependenciaOld != null && !dependenciaOld.equals(dependenciaNew)) {
                dependenciaOld.getActaTraslados().remove(actaTraslado);
                dependenciaOld = em.merge(dependenciaOld);
            }
            if (dependenciaNew != null && !dependenciaNew.equals(dependenciaOld)) {
                dependenciaNew.getActaTraslados().add(actaTraslado);
                dependenciaNew = em.merge(dependenciaNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = actaTraslado.getNroActa();
                if (findActaTraslado(id) == null) {
                    throw new NonexistentEntityException("The actaTraslado with id " + id + " no longer exists.");
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
            ActaTraslado actaTraslado;
            try {
                actaTraslado = em.getReference(ActaTraslado.class, id);
                actaTraslado.getNroActa();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The actaTraslado with id " + id + " no longer exists.", enfe);
            }
            Dependencia dependencia = actaTraslado.getDependencia();
            if (dependencia != null) {
                dependencia.getActaTraslados().remove(actaTraslado);
                dependencia = em.merge(dependencia);
            }
            em.remove(actaTraslado);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ActaTraslado> findActaTrasladoEntities() {
        return findActaTrasladoEntities(true, -1, -1);
    }

    public List<ActaTraslado> findActaTrasladoEntities(int maxResults, int firstResult) {
        return findActaTrasladoEntities(false, maxResults, firstResult);
    }

    private List<ActaTraslado> findActaTrasladoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ActaTraslado.class));
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

    public ActaTraslado findActaTraslado(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ActaTraslado.class, id);
        } finally {
            em.close();
        }
    }

    public int getActaTrasladoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ActaTraslado> rt = cq.from(ActaTraslado.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
