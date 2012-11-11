/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import ClassEntidad.Dependencia;
import ClassEntidad.Documento;
import ClassEntidad.TRD;
import Servicios.exceptions.NonexistentEntityException;
import Servicios.exceptions.PreexistingEntityException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author borsigr04
 */
public class TRDService implements Serializable {

    public TRDService(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TRD TRD) throws PreexistingEntityException, Exception {
        if (TRD.getDocumentos() == null) {
            TRD.setDocumentos(new ArrayList<Documento>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Dependencia dependencia = TRD.getDependencia();
            if (dependencia != null) {
                dependencia = em.getReference(dependencia.getClass(), dependencia.getId());
                TRD.setDependencia(dependencia);
            }
            List<Documento> attachedDocumentos = new ArrayList<Documento>();
            for (Documento documentosDocumentoToAttach : TRD.getDocumentos()) {
                documentosDocumentoToAttach = em.getReference(documentosDocumentoToAttach.getClass(), documentosDocumentoToAttach.getNoDocumento());
                attachedDocumentos.add(documentosDocumentoToAttach);
            }
            TRD.setDocumentos(attachedDocumentos);
            em.persist(TRD);
            if (dependencia != null) {
                dependencia.gettRDs().add(TRD);
                dependencia = em.merge(dependencia);
            }
            for (Documento documentosDocumento : TRD.getDocumentos()) {
                TRD oldSerieOfDocumentosDocumento = documentosDocumento.getSerie();
                documentosDocumento.setSerie(TRD);
                documentosDocumento = em.merge(documentosDocumento);
                if (oldSerieOfDocumentosDocumento != null) {
                    oldSerieOfDocumentosDocumento.getDocumentos().remove(documentosDocumento);
                    oldSerieOfDocumentosDocumento = em.merge(oldSerieOfDocumentosDocumento);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTRD(TRD.getId()) != null) {
                throw new PreexistingEntityException("TRD " + TRD + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TRD TRD) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TRD persistentTRD = em.find(TRD.class, TRD.getId());
            Dependencia dependenciaOld = persistentTRD.getDependencia();
            Dependencia dependenciaNew = TRD.getDependencia();
            List<Documento> documentosOld = persistentTRD.getDocumentos();
            List<Documento> documentosNew = TRD.getDocumentos();
            if (dependenciaNew != null) {
                dependenciaNew = em.getReference(dependenciaNew.getClass(), dependenciaNew.getId());
                TRD.setDependencia(dependenciaNew);
            }
            List<Documento> attachedDocumentosNew = new ArrayList<Documento>();
            for (Documento documentosNewDocumentoToAttach : documentosNew) {
                documentosNewDocumentoToAttach = em.getReference(documentosNewDocumentoToAttach.getClass(), documentosNewDocumentoToAttach.getNoDocumento());
                attachedDocumentosNew.add(documentosNewDocumentoToAttach);
            }
            documentosNew = attachedDocumentosNew;
            TRD.setDocumentos(documentosNew);
            TRD = em.merge(TRD);
            if (dependenciaOld != null && !dependenciaOld.equals(dependenciaNew)) {
                dependenciaOld.gettRDs().remove(TRD);
                dependenciaOld = em.merge(dependenciaOld);
            }
            if (dependenciaNew != null && !dependenciaNew.equals(dependenciaOld)) {
                dependenciaNew.gettRDs().add(TRD);
                dependenciaNew = em.merge(dependenciaNew);
            }
            for (Documento documentosOldDocumento : documentosOld) {
                if (!documentosNew.contains(documentosOldDocumento)) {
                    documentosOldDocumento.setSerie(null);
                    documentosOldDocumento = em.merge(documentosOldDocumento);
                }
            }
            for (Documento documentosNewDocumento : documentosNew) {
                if (!documentosOld.contains(documentosNewDocumento)) {
                    TRD oldSerieOfDocumentosNewDocumento = documentosNewDocumento.getSerie();
                    documentosNewDocumento.setSerie(TRD);
                    documentosNewDocumento = em.merge(documentosNewDocumento);
                    if (oldSerieOfDocumentosNewDocumento != null && !oldSerieOfDocumentosNewDocumento.equals(TRD)) {
                        oldSerieOfDocumentosNewDocumento.getDocumentos().remove(documentosNewDocumento);
                        oldSerieOfDocumentosNewDocumento = em.merge(oldSerieOfDocumentosNewDocumento);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = TRD.getId();
                if (findTRD(id) == null) {
                    throw new NonexistentEntityException("The tRD with id " + id + " no longer exists.");
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
            TRD TRD;
            try {
                TRD = em.getReference(TRD.class, id);
                TRD.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The TRD with id " + id + " no longer exists.", enfe);
            }
            Dependencia dependencia = TRD.getDependencia();
            if (dependencia != null) {
                dependencia.gettRDs().remove(TRD);
                dependencia = em.merge(dependencia);
            }
            List<Documento> documentos = TRD.getDocumentos();
            for (Documento documentosDocumento : documentos) {
                documentosDocumento.setSerie(null);
                documentosDocumento = em.merge(documentosDocumento);
            }
            em.remove(TRD);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TRD> findTRDEntities() {
        return findTRDEntities(true, -1, -1);
    }

    public List<TRD> findTRDEntities(int maxResults, int firstResult) {
        return findTRDEntities(false, maxResults, firstResult);
    }

    private List<TRD> findTRDEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TRD.class));
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

    public TRD findTRD(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TRD.class, id);
        } finally {
            em.close();
        }
    }

    public int getTRDCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TRD> rt = cq.from(TRD.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
