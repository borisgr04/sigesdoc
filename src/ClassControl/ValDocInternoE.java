/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ClassControl;

import ClassEntidad.DocInternoE;
import ClassEntidad.Documento;

/**
 *
 * @author borisgr04
 */
public class ValDocInternoE  implements  IValidador {
    DocInternoE doc;

    public DocInternoE getDoc() {
        return doc;
    }

    public void setDoc(DocInternoE doc) {
        this.doc = doc;
    }
    public String Validar(Documento doc) {
        String strVal="";
        this.setDoc((DocInternoE)doc);


        if(this.getDoc().getDireccion().isEmpty()){
            return "Falta Dirección";
        }
        else if(this.getDoc().getAsunto().isEmpty()){
            return "Falta Asunto";
         }
        else if(this.getDoc().getResumen().isEmpty()){
            return "Falta Resumen";
         }
        else if(this.getDoc().getNomDestino().isEmpty()){
            return "Falta Destino";
         }
        else if(this.getDoc().getSerieTRD().isEmpty()){
                return "Falta Destino";
        }

        
        return "OK";
    }

}


