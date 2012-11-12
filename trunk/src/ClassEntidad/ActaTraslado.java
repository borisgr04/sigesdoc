package ClassEntidad;

import java.io.Serializable;
import java.util.ArrayList; 
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;


@Entity
public class ActaTraslado implements  Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int nroActa;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecActa;

    @ManyToOne(cascade= CascadeType.MERGE)
    private Dependencia dependencia;

    //@OneToMany(mappedBy = "actaTraslado")
    @OneToMany(mappedBy = "actaTraslado", cascade=CascadeType.PERSIST)
    private List<Documento> docActas;

    public List<Documento> getDocActas() {
        return docActas;
    }

    public void setDocActas(List<Documento> docActas) {
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

    public Date getFecActa () {
        return fecActa;
    }

    public void setFecActa (Date val) {
        this.fecActa = val;
    }

    public int getNroActa () {
        return nroActa;
    }

    public void setNroActa (int val) {
        this.nroActa = val;
    }

}

