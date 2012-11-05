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
import ClassEntidad.DocInterno;
import ClassEntidad.Funcionario;
import Servicios.exceptions.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Boris
 */
public class DocInternoJpaController implements Serializable {

    public DocInternoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(DocInterno docInterno) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Dependencia depOrigen = docInterno.getDepOrigen();
            if (depOrigen != null) {
                depOrigen = em.getReference(depOrigen.getClass(), depOrigen.getId());
                docInterno.setDepOrigen(depOrigen);
            }
            Funcionario mProductor = docInterno.getmProductor();
            if (mProductor != null) {
                mProductor = em.getReference(mProductor.getClass(), mProductor.getNroIde());
                docInterno.setmProductor(mProductor);
            }
            em.persist(docInterno);
            if (depOrigen != null) {
                depOrigen.getDocInternos().add(docInterno);
                depOrigen = em.merge(depOrigen);
            }
            if (mProductor != null) {
                mProductor.getDocInternos().add(docInterno);
                mProductor = em.merge(mProductor);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(DocInterno docInterno) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            DocInterno persistentDocInterno = em.find(DocInterno.class, docInterno.getNoDocumento());
            Dependencia depOrigenOld = persistentDocInterno.getDepOrigen();
            Dependencia depOrigenNew = docInterno.getDepOrigen();
            Funcionario mProductorOld = persistentDocInterno.getmProductor();
            Funcionario mProductorNew = docInterno.getmProductor();
            if (depOrigenNew != null) {
                depOrigenNew = em.getReference(depOrigenNew.getClass(), depOrigenNew.getId());
                docInterno.setDepOrigen(depOrigenNew);
            }
            if (mProductorNew != null) {
                mProductorNew = em.getReference(mProductorNew.getClass(), mProductorNew.getNroIde());
                docInterno.setmProductor(mProductorNew);
            }
            docInterno = em.merge(docInterno);
            if (depOrigenOld != null && !depOrigenOld.equals(depOrigenNew)) {
                depOrigenOld.getDocInternos().remove(docInterno);
                depOrigenOld = em.merge(depOrigenOld);
            }
            if (depOrigenNew != null && !depOrigenNew.equals(depOrigenOld)) {
                depOrigenNew.getDocInternos().add(docInterno);
                depOrigenNew = em.merge(depOrigenNew);
            }
            if (mProductorOld != null && !mProductorOld.equals(mProductorNew)) {
                mProductorOld.getDocInternos().remove(docInterno);
                mProductorOld = em.merge(mProductorOld);
            }
            if (mProductorNew != null && !mProductorNew.equals(mProductorOld)) {
                mProductorNew.getDocInternos().add(docInterno);
                mProductorNew = em.merge(mProductorNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = docInterno.getNoDocumento();
                if (findDocInterno(id) == null) {
                    throw new NonexistentEntityException("The docInterno with id " + id + " no longer exists.");
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
            DocInterno docInterno;
            try {
                docInterno = em.getReference(DocInterno.class, id);
                docInterno.getNoDocumento();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The docInterno with id " + id + " no longer exists.", enfe);
            }
            Dependencia depOrigen = docInterno.getDepOrigen();
            if (depOrigen != null) {
                depOrigen.getDocInternos().remove(docInterno);
                depOrigen = em.merge(depOrigen);
            }
            Funcionario mProductor = docInterno.getmProductor();
            if (mProductor != null) {
                mProductor.getDocInternos().remove(docInterno);
                mProductor = em.merge(mProductor);
            }
            em.remove(docInterno);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<DocInterno> findDocInternoEntities() {
        return findDocInternoEntities(true, -1, -1);
    }

    public List<DocInterno> findDocInternoEntities(int maxResults, int firstResult) {
        return findDocInternoEntities(false, maxResults, firstResult);
    }

    private List<DocInterno> findDocInternoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(DocInterno.class));
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

    public DocInterno findDocInterno(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(DocInterno.class, id);
        } finally {
            em.close();
        }
    }

    public int getDocInternoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<DocInterno> rt = cq.from(DocInterno.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
