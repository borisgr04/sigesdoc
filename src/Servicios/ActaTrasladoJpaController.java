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
import ClassEntidad.DocActa;
import Servicios.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Boris
 */
public class ActaTrasladoJpaController implements Serializable {

    public ActaTrasladoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ActaTraslado actaTraslado) {
        if (actaTraslado.getDocActas() == null) {
            actaTraslado.setDocActas(new ArrayList<DocActa>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Dependencia dependencia = actaTraslado.getDependencia();
            if (dependencia != null) {
                dependencia = em.getReference(dependencia.getClass(), dependencia.getId());
                actaTraslado.setDependencia(dependencia);
            }
            List<DocActa> attachedDocActas = new ArrayList<DocActa>();
            for (DocActa docActasDocActaToAttach : actaTraslado.getDocActas()) {
                docActasDocActaToAttach = em.getReference(docActasDocActaToAttach.getClass(), docActasDocActaToAttach.getId());
                attachedDocActas.add(docActasDocActaToAttach);
            }
            actaTraslado.setDocActas(attachedDocActas);
            em.persist(actaTraslado);
            if (dependencia != null) {
                dependencia.getActaTraslados().add(actaTraslado);
                dependencia = em.merge(dependencia);
            }
            for (DocActa docActasDocActa : actaTraslado.getDocActas()) {
                ActaTraslado oldActaTrasladoOfDocActasDocActa = docActasDocActa.getActaTraslado();
                docActasDocActa.setActaTraslado(actaTraslado);
                docActasDocActa = em.merge(docActasDocActa);
                if (oldActaTrasladoOfDocActasDocActa != null) {
                    oldActaTrasladoOfDocActasDocActa.getDocActas().remove(docActasDocActa);
                    oldActaTrasladoOfDocActasDocActa = em.merge(oldActaTrasladoOfDocActasDocActa);
                }
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
            List<DocActa> docActasOld = persistentActaTraslado.getDocActas();
            List<DocActa> docActasNew = actaTraslado.getDocActas();
            if (dependenciaNew != null) {
                dependenciaNew = em.getReference(dependenciaNew.getClass(), dependenciaNew.getId());
                actaTraslado.setDependencia(dependenciaNew);
            }
            List<DocActa> attachedDocActasNew = new ArrayList<DocActa>();
            for (DocActa docActasNewDocActaToAttach : docActasNew) {
                docActasNewDocActaToAttach = em.getReference(docActasNewDocActaToAttach.getClass(), docActasNewDocActaToAttach.getId());
                attachedDocActasNew.add(docActasNewDocActaToAttach);
            }
            docActasNew = attachedDocActasNew;
            actaTraslado.setDocActas(docActasNew);
            actaTraslado = em.merge(actaTraslado);
            if (dependenciaOld != null && !dependenciaOld.equals(dependenciaNew)) {
                dependenciaOld.getActaTraslados().remove(actaTraslado);
                dependenciaOld = em.merge(dependenciaOld);
            }
            if (dependenciaNew != null && !dependenciaNew.equals(dependenciaOld)) {
                dependenciaNew.getActaTraslados().add(actaTraslado);
                dependenciaNew = em.merge(dependenciaNew);
            }
            for (DocActa docActasOldDocActa : docActasOld) {
                if (!docActasNew.contains(docActasOldDocActa)) {
                    docActasOldDocActa.setActaTraslado(null);
                    docActasOldDocActa = em.merge(docActasOldDocActa);
                }
            }
            for (DocActa docActasNewDocActa : docActasNew) {
                if (!docActasOld.contains(docActasNewDocActa)) {
                    ActaTraslado oldActaTrasladoOfDocActasNewDocActa = docActasNewDocActa.getActaTraslado();
                    docActasNewDocActa.setActaTraslado(actaTraslado);
                    docActasNewDocActa = em.merge(docActasNewDocActa);
                    if (oldActaTrasladoOfDocActasNewDocActa != null && !oldActaTrasladoOfDocActasNewDocActa.equals(actaTraslado)) {
                        oldActaTrasladoOfDocActasNewDocActa.getDocActas().remove(docActasNewDocActa);
                        oldActaTrasladoOfDocActasNewDocActa = em.merge(oldActaTrasladoOfDocActasNewDocActa);
                    }
                }
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
            List<DocActa> docActas = actaTraslado.getDocActas();
            for (DocActa docActasDocActa : docActas) {
                docActasDocActa.setActaTraslado(null);
                docActasDocActa = em.merge(docActasDocActa);
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
