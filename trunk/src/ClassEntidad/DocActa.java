package ClassEntidad;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


@Entity
public class DocActa implements Serializable {

    @Id
    private Long id;
        
    @OneToOne(cascade= CascadeType.PERSIST)
    private Documento mDocumento;
    
    @ManyToOne(cascade= CascadeType.PERSIST)
    private ActaTraslado actaTraslado;

    public Documento getmDocumento() {
        return mDocumento;
    }

    public void setmDocumento(Documento mDocumento) {
        this.mDocumento = mDocumento;
    }

    public ActaTraslado getActaTraslado() {
        return actaTraslado;
    }

    public void setActaTraslado(ActaTraslado actaTraslado) {
        this.actaTraslado = actaTraslado;
    }

    public Documento getDocumento () {
        return mDocumento;
    }

    public void setDocumento (Documento val) {
        this.mDocumento = val;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public DocActa () {
    }


}

