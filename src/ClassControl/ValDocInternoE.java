/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassControl;

import ClassEntidad.DistribucionDoc;
import ClassEntidad.DocInternoE;
import ClassEntidad.Documento;

/**
 *
 * @author borisgr04
 */
public class ValDocInternoE implements IValidador {

    DocInternoE doc;

    public DocInternoE getDoc() {
        return doc;
    }

    public void setDoc(DocInternoE doc) {
        this.doc = doc;
    }

    public String Validar(Documento doc) {
        this.setDoc((DocInternoE) doc);

//        if (ValDireccion()) {
//            return "Falta Dirección";
//        } else if (ValAsunto()) {
//            return "Falta Asunto";
//        } else if (ValResumen()) {
//            return "Falta Resumen";
//        } else if (ValIdeDepOrigen()) {
//            return "Falta Dependencia Origen";
//        } else if (ValIdPerProd()) {
//            return "Falta Productor";}
//        else if (ValIdePerDest()) {
//            return "Falta Destino";
//        } else if (ValSerieTRD()) {
//            return "Falta Serie Documental";
//        }
        return "OK";
    }

    private boolean ValAsunto() {
        return this.getDoc().getAsunto().isEmpty();
    }

//    private boolean ValDireccion() {
//        return this.getDoc().getDireccion().isEmpty();
//    }
//
//    private boolean ValIdPerProd() {
//        return this.getDoc().getIdPerProd().isEmpty();
//    }
//
//    private boolean ValIdePerDest() {
//        return this.getDoc().getIdPerDest().isEmpty();
//    }

    private boolean ValResumen() {
        return this.getDoc().getResumen().isEmpty();
    }

//    private boolean ValSerieTRD() {
//        return this.getDoc().getSerieTRD().isEmpty();
//    }
//
//    private boolean ValIdeDepOrigen() {
//        return this.getDoc().getIdeDepOrigen().isEmpty();
//    }

    public DistribucionDoc DistribuirDoc(Documento hg) {
        this.setDoc((DocInternoE) doc);
            DistribucionDoc dd=new DistribucionDoc();
            dd.setDistribuidor(doc.getmProductor());
            dd.setReceptor(doc.getmDestino());//Por primera Vez
            dd.setDocumento(doc);
            return dd;
    }
}


