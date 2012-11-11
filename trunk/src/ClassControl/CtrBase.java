/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassControl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author borsigr04
 */
public class CtrBase {
    private String mensaje;

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

   public CtrBase(EntityManagerFactory emf) {
        this.emf = emf;
    }
    protected EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    
    protected EntityManager em;   
}
