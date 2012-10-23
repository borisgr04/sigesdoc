/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ClassEntidad;

import java.util.ArrayList;
import java.util.Observable;

/**
 *
 * @author borisgr04
 */
public class Sistema extends  Observable  {
   public static Sistema instancia;// = new Sistema();
   private ArrayList<Documento> lstDoc = new ArrayList<Documento>();
   private ArrayList<Persona> lstPer = new ArrayList<Persona>();

    public ArrayList<Persona> getLstPer() {
        return lstPer;
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
       Funcionario f= new Funcionario();
       f.setApellidos("Bolaño");
       f.setNombres("Anya");
       f.setEmail("anyamiyeth@hotmail.com");
       f.setNroIde("7573361");
       f.setRol("F");
       f.setTelefono("3174335758");
       f.setClave("12345");
       f.setUsuario("7573361");
       f.setDireccion("Cll 5 # 24 - 47");
       lstPer.add(f);
       
       f= new Funcionario();
       f.setApellidos("Bolaño");
       f.setNombres("Anya");
       f.setEmail("anyamiyeth@hotmail.com");
       f.setNroIde("7573361");
       f.setRol("A");
       f.setTelefono("3174335758");
       f.setClave("12345");
       f.setUsuario("7573361");
       f.setDireccion("Cll 5 # 24 - 47");
       lstPer.add(f);
       
       Dependencia dep = new Dependencia();
       dep.setId("01");
       dep.setNombre("DESPACHO");
       lstDep.add(dep);

       dep = new Dependencia();
       dep.setId("01");
       dep.setNombre("JURIDICA");
       lstDep.add(dep);

       TRD serie = new TRD();
        serie.setId_Serie("01");
       serie.setDispFinal("CT");
       serie.setSerie("Memorando");
       serie.settRetAG(5);
       serie.settRetenAC(2);
       serie.setNoCons(0);
       lstTRD.add(serie);

       serie.setId_Serie("02");
       serie.setDispFinal("CT");
       serie.setSerie("Circular");
       serie.settRetAG(5);
       serie.settRetenAC(2);
       serie.setNoCons(0);
       lstTRD.add(serie);
       
       serie = new TRD();
       serie.setId_Serie("03");
       serie.setDispFinal("CT");
       serie.setSerie("Memorando");
       serie.settRetAG(5);
       serie.settRetenAC(2);
       serie.setNoCons(0);
       lstTRD.add(serie);



   }

   public void Add(Documento d){
        getLstDoc().add(d);
        this.setChanged();
        this.notifyObservers();
        int i=2;



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


    public TRD buscarSerie(String Id_Serie){
        TRD r=null;
        for(TRD d:lstTRD){
            if(d.getId_Serie().equals(Id_Serie))
            {
            r=d;
            break;
            }
        }
        return r;
    }

    public void actConsSerie(TRD t){
        t.setNoCons(t.getNoCons()+1);
    }


}
