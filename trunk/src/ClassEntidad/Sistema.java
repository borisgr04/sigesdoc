/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ClassEntidad;

import Servicios.DependenciaService;
import Servicios.DistribucionDocService;
import Servicios.FuncionarioService;
import Servicios.PerExternaService;
import Servicios.TRDService;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author borisgr04
 */
public class Sistema extends  Observable  {
   public static Sistema instancia;// = new Sistema();
   private ArrayList<Documento> lstDoc = new ArrayList<Documento>();
   private ArrayList<Persona> lstPer = new ArrayList<Persona>();
   Funcionario usuAct=new Funcionario();
   static String UnidadPersistencia="SGD2012PU";
   EntityManagerFactory emf;
   private Funcionario usuarioActual;
   private String NomApp="SIGEDOC";
  

    public String getNomApp() {
        return NomApp;
    }
    public EntityManagerFactory getEmf() {
        return emf;
    }

    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }
   
    
   public Funcionario getUsuAct() {
        return usuAct;
    }

    public void setUsuAct(Funcionario usuAct) {
        this.usuAct = usuAct;
    }
 
   private Sistema(){
       emf = Persistence.createEntityManagerFactory(UnidadPersistencia);
   }

   public void Notificar(){
        this.setChanged();
        this.notifyObservers();
   }

    public static Sistema instancia() {
        if (instancia == null) {
        instancia = new Sistema();
        
        }
        return instancia;
        }


    public List<Dependencia> getDependencias(){
        emf = Persistence.createEntityManagerFactory(UnidadPersistencia);
        EntityManager  em = emf.createEntityManager();
        DependenciaService ds = new DependenciaService(emf);
        return ds.findDependenciaEntities();
    }
    
    public List<TRD> getTRD(){
        EntityManager em = emf.createEntityManager();
        TRDService ds = new TRDService(emf);
        return ds.findTRDEntities();
    }

     public List<PerExterna> getPerExternas(){
        EntityManager em = emf.createEntityManager();
        PerExternaService ds = new PerExternaService(emf);
        return ds.findPerExternaEntities();
    }
     
      public List<DistribucionDoc> getDistribucionDoc(){
        EntityManager em = emf.createEntityManager();
        DistribucionDocService ds = new DistribucionDocService(emf);
        return ds.findDistribucionDocEntities();
    }
      
  public List<Funcionario> getFuncionarios(){
        EntityManager em = emf.createEntityManager();
        FuncionarioService ds = new FuncionarioService(emf);
        return ds.findFuncionarioEntities();
    }

    public List<DistribucionDoc> getMisBandejaSalida() {
        DistribucionDocService ds= new DistribucionDocService(emf);
        return ds.findMiBandejaSalida(usuAct);
    } 
    public List<DistribucionDoc> getMisBandejaEntrada(DDEstado Estado) {
        DistribucionDocService ds= new DistribucionDocService(emf);
        return ds.findMiBandejaEntrada(usuAct, Estado);
    }
    
     public List<Funcionario> getOtrosFuncionarios() {
        FuncionarioService ds= new FuncionarioService(emf);
        return ds.findOtrosFuncionarios(usuAct.getUsuario());
    }
}
