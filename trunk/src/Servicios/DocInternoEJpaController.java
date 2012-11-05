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
import ClassEntidad.PerExterna;
import ClassEntidad.Dependencia;
import ClassEntidad.DocInternoE;
import ClassEntidad.Funcionario;
import Servicios.exceptions.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Boris
 */
public class DocInternoEJpaController implements Serializable {

    public DocInternoEJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(DocInternoE docInternoE) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PerExterna mDestino = docInternoE.getmDestino();
            if (mDestino != null) {
                mDestino = em.getReference(mDestino.getClass(), mDestino.getNroIde());
                docInternoE.setmDestino(mDestino);
            }
            Dependencia depOrigen = docInternoE.getDepOrigen();
            if (depOrigen != null) {
                depOrigen = em.getReference(depOrigen.getClass(), depOrigen.getId());
                docInternoE.setDepOrigen(depOrigen);
            }
            Funcionario mProductor = docInternoE.getmProductor();
            if (mProductor != null) {
                mProductor = em.getReference(mProductor.getClass(), mProductor.getNroIde());
                docInternoE.setmProductor(mProductor);
            }
            em.persist(docInternoE);
            if (mDestino != null) {
                mDestino.getDocInternoEs().add(docInternoE);
                mDestino = em.merge(mDestino);
            }
            if (depOrigen != null) {
                depOrigen.getDocInternos().add(docInternoE);
                depOrigen = em.merge(depOrigen);
            }
            if (mProductor != null) {
                mProductor.getDocInternos().add(docInternoE);
                mProductor = em.merge(mProductor);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(DocInternoE docInternoE) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            DocInternoE persistentDocInternoE = em.find(DocInternoE.class, docInternoE.getNoDocumento());
            PerExterna mDestinoOld = persistentDocInternoE.getmDestino();
            PerExterna mDestinoNew = docInternoE.getmDestino();
            Dependencia depOrigenOld = persistentDocInternoE.getDepOrigen();
            Dependencia depOrigenNew = docInternoE.getDepOrigen();
            Funcionario mProductorOld = persistentDocInternoE.getmProductor();
            Funcionario mProductorNew = docInternoE.getmProductor();
            if (mDestinoNew != null) {
                mDestinoNew = em.getReference(mDestinoNew.getClass(), mDestinoNew.getNroIde());
                docInternoE.setmDestino(mDestinoNew);
            }
            if (depOrigenNew != null) {
                depOrigenNew = em.getReference(depOrigenNew.getClass(), depOrigenNew.getId());
                docInternoE.setDepOrigen(depOrigenNew);
            }
            if (mProductorNew != null) {
                mProductorNew = em.getReference(mProductorNew.getClass(), mProductorNew.getNroIde());
                docInternoE.setmProductor(mProductorNew);
            }
            docInternoE = em.merge(docInternoE);
            if (mDestinoOld != null && !mDestinoOld.equals(mDestinoNew)) {
                mDestinoOld.getDocInternoEs().remove(docInternoE);
                mDestinoOld = em.merge(mDestinoOld);
            }
            if (mDestinoNew != null && !mDestinoNew.equals(mDestinoOld)) {
                mDestinoNew.getDocInternoEs().add(docInternoE);
                mDestinoNew = em.merge(mDestinoNew);
            }
            if (depOrigenOld != null && !depOrigenOld.equals(depOrigenNew)) {
                depOrigenOld.getDocInternos().remove(docInternoE);
                depOrigenOld = em.merge(depOrigenOld);
            }
            if (depOrigenNew != null && !depOrigenNew.equals(depOrigenOld)) {
                depOrigenNew.getDocInternos().add(docInternoE);
                depOrigenNew = em.merge(depOrigenNew);
            }
            if (mProductorOld != null && !mProductorOld.equals(mProductorNew)) {
                mProductorOld.getDocInternos().remove(docInternoE);
                mProductorOld = em.merge(mProductorOld);
            }
            if (mProductorNew != null && !mProductorNew.equals(mProductorOld)) {
                mProductorNew.getDocInternos().add(docInternoE);
                mProductorNew = em.merge(mProductorNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = docInternoE.getNoDocumento();
                if (findDocInternoE(id) == null) {
                    throw new NonexistentEntityException("The docInternoE with id " + id + " no longer exists.");
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
            DocInternoE docInternoE;
            try {
                docInternoE = em.getReference(DocInternoE.class, id);
                docInternoE.getNoDocumento();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The docInternoE with id " + id + " no longer exists.", enfe);
            }
            PerExterna mDestino = docInternoE.getmDestino();
            if (mDestino != null) {
                mDestino.getDocInternoEs().remove(docInternoE);
                mDestino = em.merge(mDestino);
            }
            Dependencia depOrigen = docInternoE.getDepOrigen();
            if (depOrigen != null) {
                depOrigen.getDocInternos().remove(docInternoE);
                depOrigen = em.merge(depOrigen);
            }
            Funcionario mProductor = docInternoE.getmProductor();
            if (mProductor != null) {
                mProductor.getDocInternos().remove(docInternoE);
                mProductor = em.merge(mProductor);
            }
            em.remove(docInternoE);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<DocInternoE> findDocInternoEEntities() {
        return findDocInternoEEntities(true, -1, -1);
    }

    public List<DocInternoE> findDocInternoEEntities(int maxResults, int firstResult) {
        return findDocInternoEEntities(false, maxResults, firstResult);
    }

    private List<DocInternoE> findDocInternoEEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(DocInternoE.class));
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

    public DocInternoE findDocInternoE(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(DocInternoE.class, id);
        } finally {
            em.close();
        }
    }

    public int getDocInternoECount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<DocInternoE> rt = cq.from(DocInternoE.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
