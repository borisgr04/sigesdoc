package ClassControl;

import ClassEntidad.ActaTraslado;
import ClassEntidad.Sistema;
import Servicios.ActaTrasladoService;
import Servicios.exceptions.NonexistentEntityException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;


// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.B437DEC7-83E2-578F-084B-38F73BEB0381]
// </editor-fold> 
public class CtrOrgazina extends CtrBase{

    public CtrOrgazina(EntityManagerFactory emf) {
        super(emf);
    }
    
    
    public String Guardar(ActaTraslado at){
       ActaTrasladoService ats = new ActaTrasladoService(Sistema.instancia().getEmf());
        try {
            ats.edit(at);
            this.setMensaje("Se Creó el Acta de Traslado N° " + at.getNroActa()+"\n Los Documentos estan marcados como TRASLADADOS");
        } catch (NonexistentEntityException ex) {
            this.setMensaje(ex.getMessage());
        } catch (Exception ex) {
            this.setMensaje(ex.getMessage());
        }
         return this.getMensaje();
    }
            

 

}

