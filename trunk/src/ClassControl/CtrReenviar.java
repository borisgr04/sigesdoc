/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ClassControl;

import ClassEntidad.DDEstado;
import ClassEntidad.DistribucionDoc;
import ClassEntidad.Funcionario;
import ClassEntidad.Persona;
import ClassEntidad.Sistema;
import Servicios.FuncionarioService;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author borisgr04
 */
public class CtrReenviar extends CtrBase {
        DistribucionDoc dd;
        boolean valido;
    private String ideDistribuidor;
    private String IdeReceptor;

    public CtrReenviar(EntityManagerFactory emf) {
        super(emf);
    }

   protected Funcionario InicializarFuncionarioDist() {
        FuncionarioService ds= new FuncionarioService(emf);
        Funcionario dp=ds.findFuncionario(this.ideDistribuidor);
        return dp;
    }

     protected Funcionario InicializarFuncionarioRecep() {
        FuncionarioService ds= new FuncionarioService(emf);
        Funcionario dp=ds.findFuncionario(this.IdeReceptor);
        return dp;
    }
    public boolean isValido() {
        return valido;
    }

    public void setValido(boolean valido) {
        this.valido = valido;
    }

    public DistribucionDoc getDd() {
        return dd;
    }

    public void setDd(DistribucionDoc dd) {
        this.dd = dd;
    }
    public String reenviar(String ideDistribuidor, String ideReceptor){
        try {
            this.ideDistribuidor=ideDistribuidor;
            this.IdeReceptor= ideReceptor;
            em= this.getEntityManager();
            dd.setEstado(DDEstado.REENVIADO);
            DistribucionDoc dnuevo= new DistribucionDoc();
            Persona Dist = this.InicializarFuncionarioDist();
            Persona Rec = this.InicializarFuncionarioRecep();
            dnuevo.setDistribuidor(Dist);
            dnuevo.setmReceptor(Rec);
            dnuevo.setDocumento(dd.getDocumento());
            dnuevo.setEstado(DDEstado.SIN_RECIBIR);
            em.getTransaction().begin();
            em.merge(dd);
            em.persist(dnuevo);
            em.getTransaction().commit();
            Sistema.instancia().Notificar();
            this.setMensaje("Se realizó el Reenvio de Documento");
            valido= true;
        }catch(Exception ex){
            this.setMensaje(ex.getMessage());
            valido= false;
        }
            return this.getMensaje();



        }

        
}
