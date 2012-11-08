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
@DiscriminatorValue("DocInternoE")
public class DocInternoE extends DocInterno {

    public DocInternoE() {
        this.setTipoDocumento("E");
    }
        
    @ManyToOne(cascade= CascadeType.MERGE)
    private PerExterna mDestino;

    public PerExterna getmDestino() {
        return mDestino;
    }

    public void setmDestino(PerExterna mDestino) {
        this.mDestino = mDestino;
    }


}
