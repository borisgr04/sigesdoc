package ClassEntidad;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.4A2ED1A7-9902-9429-7D3D-5C1AE868F528]
// </editor-fold> 
@Entity
@DiscriminatorValue("Funcionario")
public class Funcionario extends Persona {

    private String usuario;
    private String clave;
    private String rol;

    @ManyToOne(cascade= CascadeType.PERSIST)
    private Dependencia dependencia;
    
     @OneToMany(mappedBy = "mProductor")
    private List<DocInterno> docInternos;
    
    @OneToMany(mappedBy = "mDestino")
    private List<DocInternoI> docInternoIs;

    public Dependencia getDependencia() {
        return dependencia;
    }

    public void setDependencia(Dependencia dependencia) {
        this.dependencia = dependencia;
    }

    public List<DocInterno> getDocInternos() {
        return docInternos;
    }

    public void setDocInternos(List<DocInterno> docInternos) {
        this.docInternos = docInternos;
    }

    public List<DocInternoI> getDocInternoIs() {
        return docInternoIs;
    }

    public void setDocInternoIs(List<DocInternoI> docInternoIs) {
        this.docInternoIs = docInternoIs;
    }
    
   
//    public void setUsuarioActual(){
//        Sistema.instancia().setUsuAct(this);
//        Sistema.instancia().setUsuActual(this.getNroIde());
//    }

//    public Funcionario getUsuarioActual(){
//       return Sistema.instancia().getUsuAct();
//    }
    
    public Funcionario () {
    }

    public String getClave () {
        return clave;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.C1355E0F-26C0-6972-2BCA-8DB946221AD0]
    // </editor-fold> 
    public void setClave (String val) {
        this.clave = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.F3D6E41C-8756-068D-1DA2-818604B8A75D]
    // </editor-fold> 
    public String getRol () {
        return rol;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.C9F46FC9-83F4-3F96-94A5-AE1D2D39AA30]
    // </editor-fold> 
    public void setRol (String val) {
        this.rol = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.C82BD883-741E-4898-EE51-AE59AAB50AB5]
    // </editor-fold> 
    public String getUsuario () {
        return usuario;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.18C67C35-E7F9-649A-C8CD-65C42B85061F]
    // </editor-fold> 
    public void setUsuario (String val) {
        this.usuario = val;
    }


//    public ArrayList<Persona> getFuncionario() {
//        ArrayList<Persona> pe = new ArrayList<Persona>();
//        for (Persona per : Sistema.instancia().getLstPer()) {
//            if (per instanceof Funcionario) {
//                pe.add(per);
//            }
//        }
//
//        return pe;
//    }

//    public ArrayList<Persona> getFuncionarioSinActual() {
//        ArrayList<Persona> pe = new ArrayList<Persona>();
//        for (Persona per : Sistema.instancia().getLstPer()) {
//            if (per instanceof Funcionario) {
//                if(!per.getNroIde().equals(this.getUsuarioActual().getNroIde())){
//                    pe.add(per);
//                }
//            }
//        }
//
//        return pe;
//    }



}

