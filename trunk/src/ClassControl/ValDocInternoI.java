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
public class ValDocInternoI implements IValidador {

    DocInternoI doc;

    public DocInternoI getDoc() {
        return doc;
    }

    public void setDoc(DocInternoI doc) {
        this.doc = doc;
    }

    public String Validar(Documento doc) {
        this.setDoc((DocInternoI) doc);

        if (ValAsunto()) {
            return "Falta Asunto";
        } else if (ValResumen()) {
            return "Falta Resumen";
        } else if (ValIdeDepOrigen()) {
            return "Falta Dependencia Origen";
        } else if (ValIdPerProd()) {
            return "Falta Productor";
        } else if (ValIdePerDest()) {
            return "Falta Destino";
        } else if (ValSerieTRD()) {
            return "Falta Serie Documental";
        }
        return "OK";
    }

    private boolean ValAsunto() {
        return this.getDoc().getAsunto().isEmpty();
    }

    private boolean ValIdeDepOrigen() {
        return this.getDoc().getIdeDepOrigen().isEmpty();
    }

    private boolean ValIdePerDest() {
        return this.getDoc().getIdPerDest().isEmpty();
    }

    private boolean ValIdPerProd() {
        return this.getDoc().getIdPerProd().isEmpty();
    }

    private boolean ValResumen() {
        return this.getDoc().getResumen().isEmpty();
    }

    private boolean ValSerieTRD() {
        return this.getDoc().getSerieTRD().isEmpty();
    }
}


