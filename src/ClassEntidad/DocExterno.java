package ClassEntidad;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;


// <editor-fold defaultstate="collapsed" desc=" UML Marker ">
// #[regen=yes,id=DCE.3872E9E7-86AB-5ED4-12E6-DAE3A22533D5]
// </editor-fold>
@Entity
@DiscriminatorValue("DocExterno")
public class DocExterno extends Documento {

    @ManyToOne(cascade= CascadeType.PERSIST)
    private PerExterna Origen;
    private int PlazoVec;

    public int getPlazoVec() {
        return PlazoVec;
    }
    public void setPlazoVec(int PlazoVec) {
        this.PlazoVec = PlazoVec;
    }
    
    public DocExterno () {
    }
    
    public PerExterna getIde () {
        return Origen;
    }
    
    public void setIde (PerExterna val) {
        this.Origen = val;
    }

}

