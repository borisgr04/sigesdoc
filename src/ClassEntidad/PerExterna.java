package ClassEntidad;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("PerExterna") 
public class PerExterna extends Persona {
    @OneToMany(mappedBy = "Origen")
    private List<DocExterno> docExternos;

    public List<DocExterno> getDocExternos() {
        return docExternos;
    }

    public void setDocExternos(List<DocExterno> docExternos) {
        this.docExternos = docExternos;
    }

    public List<DocInternoE> getDocInternoEs() {
        return docInternoEs;
    }

    public void setDocInternoEs(List<DocInternoE> docInternoEs) {
        this.docInternoEs = docInternoEs;
    }
    @OneToMany(mappedBy = "mDestino")
    private List<DocInternoE> docInternoEs;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.3636DBCF-73BB-01EB-89BB-FAFB228D30FA]
    // </editor-fold> 
    public PerExterna() {
    }

    public ArrayList<Persona> getPerExterna() {
        ArrayList<Persona> pe = new ArrayList<Persona>();
        for (Persona per : Sistema.instancia().getLstPer()) {
            if (per instanceof PerExterna) {
                pe.add(per);
            }
        }

        return pe;
    }
}

