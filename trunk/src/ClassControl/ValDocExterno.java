/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassControl;

import ClassEntidad.DistribucionDoc;
import ClassEntidad.DocExterno;
import ClassEntidad.Documento;

/**
 *
 * @author borisgr04
 */
public class ValDocExterno implements IValidador {

    DocExterno doc;

    public DocExterno getDoc() {
        return doc;
    }

    public void setDoc(DocExterno doc) {
        this.doc = doc;
    }

    public String Validar(Documento doc) {
        this.setDoc((DocExterno) doc);

//        if (ValIde()) {
//            return "Falta Escoger la Entidad remitente";
//        } else if (ValAsunto()) {
//            return "Falta Asunto";
//        } else if (ValResumen()) {
//            return "Falta Resumen";
//        } else if (ValIdePerDest()) {
//            return "Falta Destino";
//        } else if (ValIdeProd()) {
//            return "Falta Productor";
//        } else if (ValSerieTRD()) {
//            return "Falta Serie Documental";
//        }
        return "OK";
    }

    private boolean ValAsunto() {
        return this.getDoc().getAsunto().isEmpty();
    }

//    private boolean ValIde() {
//        return this.getDoc().getOrigen().getNroIde().isEmpty();
//    }
//
//    private boolean ValIdePerDest() {
//        return this.getDoc().getIdPerDest().isEmpty();
//    }
//
//    private boolean ValIdeProd() {
//        return this.getDoc().getIdPerProd().isEmpty();
//    }

    private boolean ValResumen() {
        return this.getDoc().getResumen().isEmpty();
    }
//
//    private boolean ValSerieTRD() {
//        return this.getDoc().getSerieTRD().isEmpty();
//    }

    public DistribucionDoc DistribuirDoc(Documento hg) {
        this.setDoc((DocExterno) doc);
            DistribucionDoc dd=new DistribucionDoc();
            dd.setDistribuidor(doc.getOrigen());
            dd.setmReceptor(doc.getDestino());//Por primera Vez
            dd.setDocumento(doc);
            return dd;
    }
}


