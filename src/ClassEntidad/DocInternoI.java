/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ClassEntidad;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 *
 * @author borisgr04
 */
@Entity
@DiscriminatorValue("DocInternoI")
public class DocInternoI extends DocInterno {
    
    
    @ManyToOne(cascade= CascadeType.MERGE)
    private Funcionario mDestino;

    public Funcionario getmDestino() {
        return mDestino;
    }

    public void setmDestino(Funcionario mDestino) {
        this.mDestino = mDestino;
    }
    
    public DocInternoI() {
        this.setTipoDocumento("I");
    }


}
