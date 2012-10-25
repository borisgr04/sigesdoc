package ClassEntidad;

import java.util.ArrayList;

// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.D71E8A35-852D-FD33-D70B-C49A9FF92E55]
// </editor-fold> 
public class PerExterna extends Persona {

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

