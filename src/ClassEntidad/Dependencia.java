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
    
    private String nombre;
   
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
    
    public Dependencia() {
    }

    public String getId() {
        return id;
    }

    public void setId(String val) {
        this.id = val;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String val) {
        this.nombre = val;
    }

    public Dependencia(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    
    
    
}

