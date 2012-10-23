/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ClassControl;


import ClassEntidad.DocInternoI;
import ClassEntidad.Documento;

/**
 *
 * @author borisgr04
 */
public class ValDocInternoI  implements  IValidador {
    DocInternoI doc;

    public DocInternoI getDoc() {
        return doc;
    }

    public void setDoc(DocInternoI doc) {
        this.doc = doc;
    }
    public String Validar(Documento doc) {
        this.setDoc((DocInternoI)doc);

        if(this.getDoc().getAsunto().isEmpty()){
            return "Falta Asunto";
         }
        else if(this.getDoc().getResumen().isEmpty()){
            return "Falta Resumen";
         }
         else if(this.getDoc().getIdeDepOrigen().isEmpty()){
                return "Falta Destino";
         }
         else if(this.getDoc().getIdPerProd().isEmpty()){
                return "Falta Origen";
         }
        else if(this.getDoc().getIdPerDest().isEmpty()){
                return "Falta Destino";
         }
         else if(this.getDoc().getSerieTRD().isEmpty()){
                return "Falta Destino";
         }
        return "OK";
    }

}


