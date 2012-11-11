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

    public  static String UsuActual;

    public String getUsuActual() {
        return UsuActual;
    }

    public void setUsuActual(String UsuAct) {
        Sistema.UsuActual = UsuAct;
    }
    

    public ArrayList<Persona> getLstPer() {
        return lstPer;
    }

    public ArrayList<DistribucionDoc> getLstDistriDoc() {
        return lstDistriDoc;
    }

    public void setLstDistriDoc(ArrayList<DistribucionDoc> lstDistriDoc) {
        this.lstDistriDoc = lstDistriDoc;
    }

    public void setLstPer(ArrayList<Persona> lstPer) {
        this.lstPer = lstPer;
    }
   private ArrayList<Dependencia> lstDep = new ArrayList<Dependencia>();
   private String NomApp="SIGEDOC";

    public String getNomApp() {
        return NomApp;
    }
   
    public ArrayList<Dependencia> getLstDep() {
        return lstDep;
    }

    public void setLstDep(ArrayList<Dependencia> lstDep) {
        this.lstDep = lstDep;
    }
   private ArrayList<ActaTraslado> lstActaT = new ArrayList<ActaTraslado>();
   private ArrayList<DistribucionDoc> lstDistriDoc = new ArrayList<DistribucionDoc>();
   private ArrayList<TRD> lstTRD = new ArrayList<TRD>();

    public ArrayList<TRD> getLstTRD() {
        return lstTRD;
    }

    public void setLstTRD(ArrayList<TRD> lstTRD) {
        this.lstTRD = lstTRD;
    }
   
   private Sistema(){
       emf = Persistence.createEntityManagerFactory(UnidadPersistencia);
   }

   public void Add(Documento d){
        getLstDoc().add(d);
        this.setChanged();
        this.notifyObservers();
   }

   public void Add(DistribucionDoc dd){
        this.getLstDistriDoc().add(dd);
        this.setChanged();
        this.notifyObservers();
   }

    /**
     * @return the lstDoc
     */
    public ArrayList<Documento> getLstDoc() {
        return lstDoc;
    }

    /**
     * @param lstDoc the lstDoc to set
     */
    public void setLstDoc(ArrayList<Documento> lstDoc) {
        this.lstDoc = lstDoc;
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
