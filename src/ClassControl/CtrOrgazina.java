package ClassControl;

import ClassEntidad.ACTASEstado;
import ClassEntidad.ActaTraslado;
import ClassEntidad.Sistema;
import Servicios.ActaTrasladoService;
import Servicios.exceptions.NonexistentEntityException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.swing.JOptionPane;


// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.B437DEC7-83E2-578F-084B-38F73BEB0381]
// </editor-fold> 
public class CtrOrgazina extends CtrBase{

    ActaTraslado at;
    
    public CtrOrgazina(EntityManagerFactory emf) {
        super(emf);
    }
    
    public boolean isValidoActa(){
    return (at.getNroActa()>0);
    }
    
    public boolean ActaExiste(){
         ActaTrasladoService atss = new ActaTrasladoService(Sistema.instancia().getEmf());
         return(atss.findActaTraslado(at.getNroActa())!=null);
    }       
   
    public boolean isValidoEstante(){
            return (at.getEstante()>0);
    }
    
    public boolean isValidoCaja(){
           return(at.getCaja()>0);
    }
    
    public boolean isValidoUnidad(){
           if (at.getUnidadConsulta()=="Tomo"){return true;}
           else if(at.getUnidadConsulta()=="Caja"){ return true;}   
           else{return false;}
    }
    
    public boolean isValidoEstado(){
    return (at.getEstado()==ACTASEstado.TRASLADADA); //(at.getUnidadConsulta())
    }
    
    public String Validar()
    {
        if(!this.isValidoActa()){
            return "digite un numero de acta Valido";
        }
        if(!this.ActaExiste()){
            return "El Acta no existe";
        }
        if(!this.isValidoEstante()){
           return "El número de Estante no es válido, digite un número mayor que Cero (0)";
            }
        if(!this.isValidoCaja()){
            return "El número de Caja no es válido, digite un número mayor que Cero (0)";
        }
        if (!this.isValidoUnidad()){
            return "Escoja una unidad Valida";
        }
        if(!this.isValidoEstado()){
            return "Los Documentos ya han Sido almacenados en el Archivo Central";
        }
      return "OK";
    }
    
    public String Guardar(ActaTraslado at){
        this.at=at;
        if(at==null){
            this.setValido(false);
            this.setMensaje("No se envio un  Acta Válida");
            return this.getMensaje();
        }
        
       ActaTrasladoService ats = new ActaTrasladoService(Sistema.instancia().getEmf());
        try {
            this.setMensaje(this.Validar());
            if(this.getMensaje().equals("OK"))
            {
             at.setEstado(ACTASEstado.ORGANIZADA);
             ats.edit(at);
             this.setValido(true);
             this.setMensaje("Se registro la entrada a Archivo");
            }
            else{
              this.setValido(false);   
            }
        } catch (NonexistentEntityException ex) {
            this.setMensaje(ex.getMessage());
        } catch (Exception ex) {
            this.setMensaje(ex.getMessage());
        }
         return this.getMensaje();
    }
            

 

}

