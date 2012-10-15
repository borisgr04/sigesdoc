package ClassControl;


import java.util.ArrayList;
import ClassEntidad.DocInterno;
import ClassEntidad.TRD;


/**
 *  <p style="margin-top: 0">
 *        Este Clase Maneja
 *      </p>
 */
// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.80F6EA50-E23F-D29D-B14D-181D560CD7CF]
// </editor-fold> 
public class CtrProdDoc {

    DocInterno doc = new DocInterno();

    public DocInterno getDoc() {
        return doc;
    }

    public void setDoc(DocInterno doc) {
        this.doc = doc;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.05128E10-507F-BF34-68F7-7CCDDB4957FF]
    // </editor-fold> 
    public CtrProdDoc () {
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.16FF95CC-2726-55AE-4E21-3294FE1A7F66]
    // </editor-fold> 
    public int Recibir (ArrayList<DocInterno> Doc) {
        return 0;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.C1722A42-7E35-FD8F-016C-2BDA517B23D4]
    // </editor-fold> 
    public int Validar (ArrayList<DocInterno> DI) {
        return 0;
    }

    public String Guardar(){

        TRD t = TRD.buscarSerie(doc.getSerieTRD());
        if(t!=null){
            int ncons=t.getNoCons()+1;
            doc.setNoDocumento(ncons);
            t.actConsSerie();
            return doc.crear();
        }else
        {
        return "La Serie No pertenece a una TRD";
        }


    }
}

