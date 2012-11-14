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

       if (ValAsunto()) {
           return "Falta Asunto";
       } else if (ValResumen()) {
           return "Falta Resumen";
       } else if (ValAsigPerDest()) {
           return "Falta Resumen";
       } else if (ValAsigProd()) {
            return "Falta Resumen";
       } else if (ValIdePerDest()) {
           return "Falta Destino";
       } else if (ValIdeProd()) {
           return "Falta Productor";
       } else if (ValSerieTRD()) {
           return "Falta Serie Documental";
       }
        return "OK";
    }

    private boolean ValAsunto() {
        return this.getDoc().getAsunto().isEmpty();
    }

 

    private boolean ValAsigPerDest() {
        return (getDoc().getDestino()==null) ;              
    }

    private boolean ValIdePerDest() {
        return  (getDoc().getDestino().getNroIde().isEmpty());              
    }
    private boolean ValAsigProd() {
        return (getDoc().getOrigen()==null) ;
    }
    
    private boolean ValIdeProd() {
        return (getDoc().getOrigen().getNroIde().isEmpty()) ;
    }
    
    private boolean ValResumen() {
        return this.getDoc().getResumen().isEmpty();
    }

    private boolean ValSerieTRD() {
       return (this.getDoc().getSerie()== null);
    }

    public DistribucionDoc DistribuirDoc(Documento hg) {
        this.setDoc((DocExterno) doc);
            DistribucionDoc dd=new DistribucionDoc();
            dd.setDistribuidor(doc.getOrigen());
            dd.setmReceptor(doc.getDestino());//Por primera Vez
            dd.setDocumento(doc);
            return dd;
    }
}


