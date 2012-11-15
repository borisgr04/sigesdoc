/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import ClassEntidad.ActaTraslado;
import ClassEntidad.DDEstado;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import ClassEntidad.Dependencia;
import ClassEntidad.Documento;
import Servicios.exceptions.NonexistentEntityException;
import java.util.ArrayList;
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
        if (actaTraslado.getDocActas() == null) {
            actaTraslado.setDocActas(new ArrayList<Documento>());
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
            List<Documento> attachedDocActas = new ArrayList<Documento>();
            for (Documento docActasDocumentoToAttach : actaTraslado.getDocActas()) {
                docActasDocumentoToAttach = em.getReference(docActasDocumentoToAttach.getClass(), docActasDocumentoToAttach.getNoDocumento());
                attachedDocActas.add(docActasDocumentoToAttach);
            }
            actaTraslado.setDocActas(attachedDocActas);
            em.persist(actaTraslado);
            if (dependencia != null) {
                dependencia.getActaTraslados().add(actaTraslado);
                dependencia = em.merge(dependencia);
            }
            for (Documento docActasDocumento : actaTraslado.getDocActas()) {
                ActaTraslado oldActaTrasladoOfDocActasDocumento = docActasDocumento.getActaTraslado();
                docActasDocumento.setActaTraslado(actaTraslado);
                docActasDocumento.setEstado(DDEstado.TRASLADADO);
                docActasDocumento = em.merge(docActasDocumento);
                if (oldActaTrasladoOfDocActasDocumento != null) {
                    oldActaTrasladoOfDocActasDocumento.getDocActas().remove(docActasDocumento);
                    oldActaTrasladoOfDocActasDocumento = em.merge(oldActaTrasladoOfDocActasDocumento);
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
            List<Documento> docActasOld = persistentActaTraslado.getDocActas();
            List<Documento> docActasNew = actaTraslado.getDocActas();
            if (dependenciaNew != null) {
                dependenciaNew = em.getReference(dependenciaNew.getClass(), dependenciaNew.getId());
                actaTraslado.setDependencia(dependenciaNew);
            }
            List<Documento> attachedDocActasNew = new ArrayList<Documento>();
            for (Documento docActasNewDocumentoToAttach : docActasNew) {
                docActasNewDocumentoToAttach = em.getReference(docActasNewDocumentoToAttach.getClass(), docActasNewDocumentoToAttach.getNoDocumento());
                docActasNewDocumentoToAttach.setEstado(DDEstado.ORGANIZADO);
                attachedDocActasNew.add(docActasNewDocumentoToAttach);
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
            for (Documento docActasOldDocumento : docActasOld) {
                if (!docActasNew.contains(docActasOldDocumento)) {
                    docActasOldDocumento.setActaTraslado(null);
                    docActasOldDocumento = em.merge(docActasOldDocumento);
                }
            }
            for (Documento docActasNewDocumento : docActasNew) {
                if (!docActasOld.contains(docActasNewDocumento)) {
                    ActaTraslado oldActaTrasladoOfDocActasNewDocumento = docActasNewDocumento.getActaTraslado();
                    docActasNewDocumento.setActaTraslado(actaTraslado);
                    docActasNewDocumento = em.merge(docActasNewDocumento);
                    if (oldActaTrasladoOfDocActasNewDocumento != null && !oldActaTrasladoOfDocActasNewDocumento.equals(actaTraslado)) {
                        oldActaTrasladoOfDocActasNewDocumento.getDocActas().remove(docActasNewDocumento);
                        oldActaTrasladoOfDocActasNewDocumento = em.merge(oldActaTrasladoOfDocActasNewDocumento);
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
            List<Documento> docActas = actaTraslado.getDocActas();
            for (Documento docActasDocumento : docActas) {
                docActasDocumento.setActaTraslado(null);
                docActasDocumento = em.merge(docActasDocumento);
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
