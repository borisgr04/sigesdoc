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
import ClassEntidad.DocInterno;
import java.util.ArrayList;
import java.util.List;
import ClassEntidad.TRD;
import ClassEntidad.ActaTraslado;
import ClassEntidad.Dependencia;
import Servicios.exceptions.NonexistentEntityException;
import Servicios.exceptions.PreexistingEntityException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Boris
 */
public class DependenciaJpaController implements Serializable {

    public DependenciaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Dependencia dependencia) throws PreexistingEntityException, Exception {
        if (dependencia.getDocInternos() == null) {
            dependencia.setDocInternos(new ArrayList<DocInterno>());
        }
        if (dependencia.gettRDs() == null) {
            dependencia.settRDs(new ArrayList<TRD>());
        }
        if (dependencia.getActaTraslados() == null) {
            dependencia.setActaTraslados(new ArrayList<ActaTraslado>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<DocInterno> attachedDocInternos = new ArrayList<DocInterno>();
            for (DocInterno docInternosDocInternoToAttach : dependencia.getDocInternos()) {
                docInternosDocInternoToAttach = em.getReference(docInternosDocInternoToAttach.getClass(), docInternosDocInternoToAttach.getNoDocumento());
                attachedDocInternos.add(docInternosDocInternoToAttach);
            }
            dependencia.setDocInternos(attachedDocInternos);
            List<TRD> attachedtRDs = new ArrayList<TRD>();
            for (TRD tRDsTRDToAttach : dependencia.gettRDs()) {
                tRDsTRDToAttach = em.getReference(tRDsTRDToAttach.getClass(), tRDsTRDToAttach.getId());
                attachedtRDs.add(tRDsTRDToAttach);
            }
            dependencia.settRDs(attachedtRDs);
            List<ActaTraslado> attachedActaTraslados = new ArrayList<ActaTraslado>();
            for (ActaTraslado actaTrasladosActaTrasladoToAttach : dependencia.getActaTraslados()) {
                actaTrasladosActaTrasladoToAttach = em.getReference(actaTrasladosActaTrasladoToAttach.getClass(), actaTrasladosActaTrasladoToAttach.getNroActa());
                attachedActaTraslados.add(actaTrasladosActaTrasladoToAttach);
            }
            dependencia.setActaTraslados(attachedActaTraslados);
            em.persist(dependencia);
            for (DocInterno docInternosDocInterno : dependencia.getDocInternos()) {
                Dependencia oldDepOrigenOfDocInternosDocInterno = docInternosDocInterno.getDepOrigen();
                docInternosDocInterno.setDepOrigen(dependencia);
                docInternosDocInterno = em.merge(docInternosDocInterno);
                if (oldDepOrigenOfDocInternosDocInterno != null) {
                    oldDepOrigenOfDocInternosDocInterno.getDocInternos().remove(docInternosDocInterno);
                    oldDepOrigenOfDocInternosDocInterno = em.merge(oldDepOrigenOfDocInternosDocInterno);
                }
            }
            for (TRD tRDsTRD : dependencia.gettRDs()) {
                Dependencia oldDependenciaOfTRDsTRD = tRDsTRD.getDependencia();
                tRDsTRD.setDependencia(dependencia);
                tRDsTRD = em.merge(tRDsTRD);
                if (oldDependenciaOfTRDsTRD != null) {
                    oldDependenciaOfTRDsTRD.gettRDs().remove(tRDsTRD);
                    oldDependenciaOfTRDsTRD = em.merge(oldDependenciaOfTRDsTRD);
                }
            }
            for (ActaTraslado actaTrasladosActaTraslado : dependencia.getActaTraslados()) {
                Dependencia oldDependenciaOfActaTrasladosActaTraslado = actaTrasladosActaTraslado.getDependencia();
                actaTrasladosActaTraslado.setDependencia(dependencia);
                actaTrasladosActaTraslado = em.merge(actaTrasladosActaTraslado);
                if (oldDependenciaOfActaTrasladosActaTraslado != null) {
                    oldDependenciaOfActaTrasladosActaTraslado.getActaTraslados().remove(actaTrasladosActaTraslado);
                    oldDependenciaOfActaTrasladosActaTraslado = em.merge(oldDependenciaOfActaTrasladosActaTraslado);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findDependencia(dependencia.getId()) != null) {
                throw new PreexistingEntityException("Dependencia " + dependencia + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Dependencia dependencia) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Dependencia persistentDependencia = em.find(Dependencia.class, dependencia.getId());
            List<DocInterno> docInternosOld = persistentDependencia.getDocInternos();
            List<DocInterno> docInternosNew = dependencia.getDocInternos();
            List<TRD> tRDsOld = persistentDependencia.gettRDs();
            List<TRD> tRDsNew = dependencia.gettRDs();
            List<ActaTraslado> actaTrasladosOld = persistentDependencia.getActaTraslados();
            List<ActaTraslado> actaTrasladosNew = dependencia.getActaTraslados();
            List<DocInterno> attachedDocInternosNew = new ArrayList<DocInterno>();
            for (DocInterno docInternosNewDocInternoToAttach : docInternosNew) {
                docInternosNewDocInternoToAttach = em.getReference(docInternosNewDocInternoToAttach.getClass(), docInternosNewDocInternoToAttach.getNoDocumento());
                attachedDocInternosNew.add(docInternosNewDocInternoToAttach);
            }
            docInternosNew = attachedDocInternosNew;
            dependencia.setDocInternos(docInternosNew);
            List<TRD> attachedtRDsNew = new ArrayList<TRD>();
            for (TRD tRDsNewTRDToAttach : tRDsNew) {
                tRDsNewTRDToAttach = em.getReference(tRDsNewTRDToAttach.getClass(), tRDsNewTRDToAttach.getId());
                attachedtRDsNew.add(tRDsNewTRDToAttach);
            }
            tRDsNew = attachedtRDsNew;
            dependencia.settRDs(tRDsNew);
            List<ActaTraslado> attachedActaTrasladosNew = new ArrayList<ActaTraslado>();
            for (ActaTraslado actaTrasladosNewActaTrasladoToAttach : actaTrasladosNew) {
                actaTrasladosNewActaTrasladoToAttach = em.getReference(actaTrasladosNewActaTrasladoToAttach.getClass(), actaTrasladosNewActaTrasladoToAttach.getNroActa());
                attachedActaTrasladosNew.add(actaTrasladosNewActaTrasladoToAttach);
            }
            actaTrasladosNew = attachedActaTrasladosNew;
            dependencia.setActaTraslados(actaTrasladosNew);
            dependencia = em.merge(dependencia);
            for (DocInterno docInternosOldDocInterno : docInternosOld) {
                if (!docInternosNew.contains(docInternosOldDocInterno)) {
                    docInternosOldDocInterno.setDepOrigen(null);
                    docInternosOldDocInterno = em.merge(docInternosOldDocInterno);
                }
            }
            for (DocInterno docInternosNewDocInterno : docInternosNew) {
                if (!docInternosOld.contains(docInternosNewDocInterno)) {
                    Dependencia oldDepOrigenOfDocInternosNewDocInterno = docInternosNewDocInterno.getDepOrigen();
                    docInternosNewDocInterno.setDepOrigen(dependencia);
                    docInternosNewDocInterno = em.merge(docInternosNewDocInterno);
                    if (oldDepOrigenOfDocInternosNewDocInterno != null && !oldDepOrigenOfDocInternosNewDocInterno.equals(dependencia)) {
                        oldDepOrigenOfDocInternosNewDocInterno.getDocInternos().remove(docInternosNewDocInterno);
                        oldDepOrigenOfDocInternosNewDocInterno = em.merge(oldDepOrigenOfDocInternosNewDocInterno);
                    }
                }
            }
            for (TRD tRDsOldTRD : tRDsOld) {
                if (!tRDsNew.contains(tRDsOldTRD)) {
                    tRDsOldTRD.setDependencia(null);
                    tRDsOldTRD = em.merge(tRDsOldTRD);
                }
            }
            for (TRD tRDsNewTRD : tRDsNew) {
                if (!tRDsOld.contains(tRDsNewTRD)) {
                    Dependencia oldDependenciaOfTRDsNewTRD = tRDsNewTRD.getDependencia();
                    tRDsNewTRD.setDependencia(dependencia);
                    tRDsNewTRD = em.merge(tRDsNewTRD);
                    if (oldDependenciaOfTRDsNewTRD != null && !oldDependenciaOfTRDsNewTRD.equals(dependencia)) {
                        oldDependenciaOfTRDsNewTRD.gettRDs().remove(tRDsNewTRD);
                        oldDependenciaOfTRDsNewTRD = em.merge(oldDependenciaOfTRDsNewTRD);
                    }
                }
            }
            for (ActaTraslado actaTrasladosOldActaTraslado : actaTrasladosOld) {
                if (!actaTrasladosNew.contains(actaTrasladosOldActaTraslado)) {
                    actaTrasladosOldActaTraslado.setDependencia(null);
                    actaTrasladosOldActaTraslado = em.merge(actaTrasladosOldActaTraslado);
                }
            }
            for (ActaTraslado actaTrasladosNewActaTraslado : actaTrasladosNew) {
                if (!actaTrasladosOld.contains(actaTrasladosNewActaTraslado)) {
                    Dependencia oldDependenciaOfActaTrasladosNewActaTraslado = actaTrasladosNewActaTraslado.getDependencia();
                    actaTrasladosNewActaTraslado.setDependencia(dependencia);
                    actaTrasladosNewActaTraslado = em.merge(actaTrasladosNewActaTraslado);
                    if (oldDependenciaOfActaTrasladosNewActaTraslado != null && !oldDependenciaOfActaTrasladosNewActaTraslado.equals(dependencia)) {
                        oldDependenciaOfActaTrasladosNewActaTraslado.getActaTraslados().remove(actaTrasladosNewActaTraslado);
                        oldDependenciaOfActaTrasladosNewActaTraslado = em.merge(oldDependenciaOfActaTrasladosNewActaTraslado);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = dependencia.getId();
                if (findDependencia(id) == null) {
                    throw new NonexistentEntityException("The dependencia with id " + id + " no longer exists.");
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
            Dependencia dependencia;
            try {
                dependencia = em.getReference(Dependencia.class, id);
                dependencia.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The dependencia with id " + id + " no longer exists.", enfe);
            }
            List<DocInterno> docInternos = dependencia.getDocInternos();
            for (DocInterno docInternosDocInterno : docInternos) {
                docInternosDocInterno.setDepOrigen(null);
                docInternosDocInterno = em.merge(docInternosDocInterno);
            }
            List<TRD> tRDs = dependencia.gettRDs();
            for (TRD tRDsTRD : tRDs) {
                tRDsTRD.setDependencia(null);
                tRDsTRD = em.merge(tRDsTRD);
            }
            List<ActaTraslado> actaTraslados = dependencia.getActaTraslados();
            for (ActaTraslado actaTrasladosActaTraslado : actaTraslados) {
                actaTrasladosActaTraslado.setDependencia(null);
                actaTrasladosActaTraslado = em.merge(actaTrasladosActaTraslado);
            }
            em.remove(dependencia);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Dependencia> findDependenciaEntities() {
        return findDependenciaEntities(true, -1, -1);
    }

    public List<Dependencia> findDependenciaEntities(int maxResults, int firstResult) {
        return findDependenciaEntities(false, maxResults, firstResult);
    }

    private List<Dependencia> findDependenciaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Dependencia.class));
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
    
    public List<Dependencia> findByNombre(String nombre) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Dependencia.class));
            Query q = em.createNamedQuery("Dependencia.findByNombre");
            q.setParameter("nombre", nombre);
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Dependencia findDependencia(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Dependencia.class, id);
        } finally {
            em.close();
        }
    }

    public int getDependenciaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Dependencia> rt = cq.from(Dependencia.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
