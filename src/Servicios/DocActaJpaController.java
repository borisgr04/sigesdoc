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
import ClassEntidad.Documento;
import ClassEntidad.ActaTraslado;
import ClassEntidad.DocActa;
import Servicios.exceptions.NonexistentEntityException;
import Servicios.exceptions.PreexistingEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Boris
 */
public class DocActaJpaController implements Serializable {

    public DocActaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(DocActa docActa) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Documento mDocumento = docActa.getmDocumento();
            if (mDocumento != null) {
                mDocumento = em.getReference(mDocumento.getClass(), mDocumento.getNoDocumento());
                docActa.setmDocumento(mDocumento);
            }
            ActaTraslado actaTraslado = docActa.getActaTraslado();
            if (actaTraslado != null) {
                actaTraslado = em.getReference(actaTraslado.getClass(), actaTraslado.getNroActa());
                docActa.setActaTraslado(actaTraslado);
            }
            em.persist(docActa);
            if (mDocumento != null) {
                DocActa oldDocActaOfMDocumento = mDocumento.getDocActa();
                if (oldDocActaOfMDocumento != null) {
                    oldDocActaOfMDocumento.setmDocumento(null);
                    oldDocActaOfMDocumento = em.merge(oldDocActaOfMDocumento);
                }
                mDocumento.setDocActa(docActa);
                mDocumento = em.merge(mDocumento);
            }
            if (actaTraslado != null) {
                actaTraslado.getDocActas().add(docActa);
                actaTraslado = em.merge(actaTraslado);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findDocActa(docActa.getId()) != null) {
                throw new PreexistingEntityException("DocActa " + docActa + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(DocActa docActa) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            DocActa persistentDocActa = em.find(DocActa.class, docActa.getId());
            Documento mDocumentoOld = persistentDocActa.getmDocumento();
            Documento mDocumentoNew = docActa.getmDocumento();
            ActaTraslado actaTrasladoOld = persistentDocActa.getActaTraslado();
            ActaTraslado actaTrasladoNew = docActa.getActaTraslado();
            if (mDocumentoNew != null) {
                mDocumentoNew = em.getReference(mDocumentoNew.getClass(), mDocumentoNew.getNoDocumento());
                docActa.setmDocumento(mDocumentoNew);
            }
            if (actaTrasladoNew != null) {
                actaTrasladoNew = em.getReference(actaTrasladoNew.getClass(), actaTrasladoNew.getNroActa());
                docActa.setActaTraslado(actaTrasladoNew);
            }
            docActa = em.merge(docActa);
            if (mDocumentoOld != null && !mDocumentoOld.equals(mDocumentoNew)) {
                mDocumentoOld.setDocActa(null);
                mDocumentoOld = em.merge(mDocumentoOld);
            }
            if (mDocumentoNew != null && !mDocumentoNew.equals(mDocumentoOld)) {
                DocActa oldDocActaOfMDocumento = mDocumentoNew.getDocActa();
                if (oldDocActaOfMDocumento != null) {
                    oldDocActaOfMDocumento.setmDocumento(null);
                    oldDocActaOfMDocumento = em.merge(oldDocActaOfMDocumento);
                }
                mDocumentoNew.setDocActa(docActa);
                mDocumentoNew = em.merge(mDocumentoNew);
            }
            if (actaTrasladoOld != null && !actaTrasladoOld.equals(actaTrasladoNew)) {
                actaTrasladoOld.getDocActas().remove(docActa);
                actaTrasladoOld = em.merge(actaTrasladoOld);
            }
            if (actaTrasladoNew != null && !actaTrasladoNew.equals(actaTrasladoOld)) {
                actaTrasladoNew.getDocActas().add(docActa);
                actaTrasladoNew = em.merge(actaTrasladoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = docActa.getId();
                if (findDocActa(id) == null) {
                    throw new NonexistentEntityException("The docActa with id " + id + " no longer exists.");
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
            DocActa docActa;
            try {
                docActa = em.getReference(DocActa.class, id);
                docActa.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The docActa with id " + id + " no longer exists.", enfe);
            }
            Documento mDocumento = docActa.getmDocumento();
            if (mDocumento != null) {
                mDocumento.setDocActa(null);
                mDocumento = em.merge(mDocumento);
            }
            ActaTraslado actaTraslado = docActa.getActaTraslado();
            if (actaTraslado != null) {
                actaTraslado.getDocActas().remove(docActa);
                actaTraslado = em.merge(actaTraslado);
            }
            em.remove(docActa);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<DocActa> findDocActaEntities() {
        return findDocActaEntities(true, -1, -1);
    }

    public List<DocActa> findDocActaEntities(int maxResults, int firstResult) {
        return findDocActaEntities(false, maxResults, firstResult);
    }

    private List<DocActa> findDocActaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(DocActa.class));
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

    public DocActa findDocActa(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(DocActa.class, id);
        } finally {
            em.close();
        }
    }

    public int getDocActaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<DocActa> rt = cq.from(DocActa.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
