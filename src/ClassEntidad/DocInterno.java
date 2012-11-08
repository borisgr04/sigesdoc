package ClassEntidad;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;


@Entity
@DiscriminatorValue("DocInterno")
public class DocInterno extends Documento {

    private String TipoDocumento;
    
    @ManyToOne(cascade= CascadeType.MERGE)
    private Funcionario mProductor;

    @ManyToOne(cascade= CascadeType.MERGE, fetch= FetchType.LAZY)
    private Dependencia depOrigen;
    

    public Dependencia getDepOrigen() {
        return depOrigen;
    }

    public void setDepOrigen(Dependencia depOrigen) {
        this.depOrigen = depOrigen;
    }
    
    public String getTipoDocumento() {
        return TipoDocumento;
    }
    
    public void setTipoDocumento(String TipoDocumento) {
        this.TipoDocumento = TipoDocumento;
    }
   public Funcionario getmProductor() {
        return mProductor;
    }

    public void setmProductor(Funcionario mProductor) {
        this.mProductor = mProductor;
    }    
    public DocInterno () {
    }

    
}

