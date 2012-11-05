package ClassEntidad;

import java.io.Serializable;
import java.util.ArrayList; 
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class ActaTraslado implements  Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int nroActa;

    private String fecActa;

    @ManyToOne(cascade= CascadeType.PERSIST)
    private Dependencia dependencia;

    @OneToMany(mappedBy = "actaTraslado")
    private List<DocActa> docActas;

    public List<DocActa> getDocActas() {
        return docActas;
    }

    public void setDocActas(List<DocActa> docActas) {
        this.docActas = docActas;
    }

    public Dependencia getDependencia() {
        return dependencia;
    }

    public void setDependencia(Dependencia dependencia) {
        this.dependencia = dependencia;
    }

    public ActaTraslado () {
    }

    public String getFecActa () {
        return fecActa;
    }

    public void setFecActa (String val) {
        this.fecActa = val;
    }

    public int getNroActa () {
        return nroActa;
    }

    public void setNroActa (int val) {
        this.nroActa = val;
    }

}

