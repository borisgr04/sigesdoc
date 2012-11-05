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
import ClassEntidad.Funcionario;
import ClassEntidad.Dependencia;
import ClassEntidad.DocInternoI;
import Servicios.exceptions.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Boris
 */
public class DocInternoIJpaController implements Serializable {

    public DocInternoIJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(DocInternoI docInternoI) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Funcionario mDestino = docInternoI.getmDestino();
            if (mDestino != null) {
                mDestino = em.getReference(mDestino.getClass(), mDestino.getNroIde());
                docInternoI.setmDestino(mDestino);
            }
            Dependencia depOrigen = docInternoI.getDepOrigen();
            if (depOrigen != null) {
                depOrigen = em.getReference(depOrigen.getClass(), depOrigen.getId());
                docInternoI.setDepOrigen(depOrigen);
            }
            Funcionario mProductor = docInternoI.getmProductor();
            if (mProductor != null) {
                mProductor = em.getReference(mProductor.getClass(), mProductor.getNroIde());
                docInternoI.setmProductor(mProductor);
            }
            em.persist(docInternoI);
            if (mDestino != null) {
                mDestino.getDocInternoIs().add(docInternoI);
                mDestino = em.merge(mDestino);
            }
            if (depOrigen != null) {
                depOrigen.getDocInternos().add(docInternoI);
                depOrigen = em.merge(depOrigen);
            }
            if (mProductor != null) {
                mProductor.getDocInternos().add(docInternoI);
                mProductor = em.merge(mProductor);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(DocInternoI docInternoI) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            DocInternoI persistentDocInternoI = em.find(DocInternoI.class, docInternoI.getNoDocumento());
            Funcionario mDestinoOld = persistentDocInternoI.getmDestino();
            Funcionario mDestinoNew = docInternoI.getmDestino();
            Dependencia depOrigenOld = persistentDocInternoI.getDepOrigen();
            Dependencia depOrigenNew = docInternoI.getDepOrigen();
            Funcionario mProductorOld = persistentDocInternoI.getmProductor();
            Funcionario mProductorNew = docInternoI.getmProductor();
            if (mDestinoNew != null) {
                mDestinoNew = em.getReference(mDestinoNew.getClass(), mDestinoNew.getNroIde());
                docInternoI.setmDestino(mDestinoNew);
            }
            if (depOrigenNew != null) {
                depOrigenNew = em.getReference(depOrigenNew.getClass(), depOrigenNew.getId());
                docInternoI.setDepOrigen(depOrigenNew);
            }
            if (mProductorNew != null) {
                mProductorNew = em.getReference(mProductorNew.getClass(), mProductorNew.getNroIde());
                docInternoI.setmProductor(mProductorNew);
            }
            docInternoI = em.merge(docInternoI);
            if (mDestinoOld != null && !mDestinoOld.equals(mDestinoNew)) {
                mDestinoOld.getDocInternoIs().remove(docInternoI);
                mDestinoOld = em.merge(mDestinoOld);
            }
            if (mDestinoNew != null && !mDestinoNew.equals(mDestinoOld)) {
                mDestinoNew.getDocInternoIs().add(docInternoI);
                mDestinoNew = em.merge(mDestinoNew);
            }
            if (depOrigenOld != null && !depOrigenOld.equals(depOrigenNew)) {
                depOrigenOld.getDocInternos().remove(docInternoI);
                depOrigenOld = em.merge(depOrigenOld);
            }
            if (depOrigenNew != null && !depOrigenNew.equals(depOrigenOld)) {
                depOrigenNew.getDocInternos().add(docInternoI);
                depOrigenNew = em.merge(depOrigenNew);
            }
            if (mProductorOld != null && !mProductorOld.equals(mProductorNew)) {
                mProductorOld.getDocInternos().remove(docInternoI);
                mProductorOld = em.merge(mProductorOld);
            }
            if (mProductorNew != null && !mProductorNew.equals(mProductorOld)) {
                mProductorNew.getDocInternos().add(docInternoI);
                mProductorNew = em.merge(mProductorNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = docInternoI.getNoDocumento();
                if (findDocInternoI(id) == null) {
                    throw new NonexistentEntityException("The docInternoI with id " + id + " no longer exists.");
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
            DocInternoI docInternoI;
            try {
                docInternoI = em.getReference(DocInternoI.class, id);
                docInternoI.getNoDocumento();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The docInternoI with id " + id + " no longer exists.", enfe);
            }
            Funcionario mDestino = docInternoI.getmDestino();
            if (mDestino != null) {
                mDestino.getDocInternoIs().remove(docInternoI);
                mDestino = em.merge(mDestino);
            }
            Dependencia depOrigen = docInternoI.getDepOrigen();
            if (depOrigen != null) {
                depOrigen.getDocInternos().remove(docInternoI);
                depOrigen = em.merge(depOrigen);
            }
            Funcionario mProductor = docInternoI.getmProductor();
            if (mProductor != null) {
                mProductor.getDocInternos().remove(docInternoI);
                mProductor = em.merge(mProductor);
            }
            em.remove(docInternoI);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<DocInternoI> findDocInternoIEntities() {
        return findDocInternoIEntities(true, -1, -1);
    }

    public List<DocInternoI> findDocInternoIEntities(int maxResults, int firstResult) {
        return findDocInternoIEntities(false, maxResults, firstResult);
    }

    private List<DocInternoI> findDocInternoIEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(DocInternoI.class));
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

    public DocInternoI findDocInternoI(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(DocInternoI.class, id);
        } finally {
            em.close();
        }
    }

    public int getDocInternoICount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<DocInternoI> rt = cq.from(DocInternoI.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
