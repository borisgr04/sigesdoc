/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ClassControl;

import ClassEntidad.DocExterno;
import ClassEntidad.Documento;

/**
 *
 * @author borisgr04
 */
public class ValDocExterno  implements  IValidador {
    DocExterno doc;

    public DocExterno getDoc() {
        return doc;
    }

    public void setDoc(DocExterno doc) {
        this.doc = doc;
    }
    public String Validar(Documento doc) {
        this.setDoc((DocExterno)doc);

        if(this.getDoc().getIde().getNroIde().isEmpty()){
            return "Falta Escoger la Entidad remitente";
        }
        else if(this.getDoc().getAsunto().isEmpty()){
            return "Falta Asunto";
         }
        else if(this.getDoc().getResumen().isEmpty()){
            return "Falta Resumen";
         }
        else if(this.getDoc().getIdPerDest().isEmpty()){
                return "Falta Destino";
         }
        else if(this.getDoc().getIdPerProd().isEmpty()){
                return "Falta Destino";
         }

         else if(this.getDoc().getSerieTRD().isEmpty()){
                return "Falta Destino";
         }
        return "OK";
    }

}


