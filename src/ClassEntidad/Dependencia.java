package ClassEntidad;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;

// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.771E0EFF-5F22-0A7F-1A4B-375E355A17C4]
// </editor-fold> 
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dependencia.findAll", query = "SELECT d FROM Dependencia d"),
    @NamedQuery(name = "Dependencia.findById", query = "SELECT d FROM Dependencia d WHERE d.id = :id"),
    @NamedQuery(name = "Dependencia.findByNombre", query = "SELECT d FROM Dependencia d WHERE d.nombre = :nombre")})
public class Dependencia implements Serializable {

    @Override
    public String toString() {
        return "Dependencia{" + "id=" + id + ", nombre=" + nombre + ", docInternos=" + docInternos + ", tRDs=" + tRDs + ", actaTraslados=" + actaTraslados + '}';
    }

    
    
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.DCCA2FCD-80FF-B575-68C6-D33DE711D09F]
    // </editor-fold> 
    @Id
    private String id;
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.A061354F-C5CA-D821-AAE2-68E8F614CE39]
    // </editor-fold> 
    private String nombre;
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.E0653357-B05F-CD73-3407-9E3B9E6F8A23]
    // </editor-fold> 
    @OneToMany(mappedBy = "depOrigen")
    private List<DocInterno> docInternos;

    public List<DocInterno> getDocInternos() {
        return docInternos;
    }

    public void setDocInternos(List<DocInterno> docInternos) {
        this.docInternos = docInternos;
    }

    public List<TRD> gettRDs() {
        return tRDs;
    }

    public void settRDs(List<TRD> tRDs) {
        this.tRDs = tRDs;
    }

    public List<ActaTraslado> getActaTraslados() {
        return actaTraslados;
    }

    public void setActaTraslados(List<ActaTraslado> actaTraslados) {
        this.actaTraslados = actaTraslados;
    }
    @OneToMany(mappedBy = "dependencia")
    private List<TRD> tRDs;
    
    @OneToMany(mappedBy = "dependencia")
    private List<ActaTraslado> actaTraslados;
    


    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.72041AFC-2A6A-D8D2-33A8-90220A1B3BAE]
    // </editor-fold> 
    public Dependencia() {
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.FF32DFCD-57BC-E52A-565F-F5CDE7D90A7C]
    // </editor-fold> 
    public String getId() {
        return id;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.9E47A95E-651B-04D0-0F73-A8C9D995CA42]
    // </editor-fold> 
    public void setId(String val) {
        this.id = val;
    }



    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.B209F1FC-5BDD-5CC8-F1E8-D0372A5E84B7]
    // </editor-fold> 
    public String getNombre() {
        return nombre;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.02139C71-ADE9-11E6-6990-2F5BBE8EB6FA]
    // </editor-fold> 
    public void setNombre(String val) {
        this.nombre = val;
    }

    public ArrayList<Dependencia> getDependencias() {
        return Sistema.instancia().getLstDep();
    }

    public Dependencia(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    
    
    
}

