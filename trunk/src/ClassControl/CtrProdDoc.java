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
    private IValidador validador;
    private boolean valido;
    private String mensaje;

    public String getMensaje() {
        return mensaje;
    }
    

    public boolean isValido() {
        return valido;
    }


    public IValidador getValidador() {
        return validador;
    }

    public void setValidador(IValidador validador) {
        this.validador = validador;
    }

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

    public String Guardar(IValidador validador){
        valido=false;
        this.mensaje=validador.Validar(doc);
        if(mensaje.equals("OK")){
            TRD t = TRD.buscarSerie(doc.getSerieTRD());
            if(t!=null){
                int ncons=t.getNoCons()+1;
                doc.setNoDocumento(ncons);
                t.actConsSerie();
                valido=true;
                mensaje=doc.crear();
                return mensaje;
            }else
            {
                return "La Serie No pertenece a una TRD";
            }
        }
        else
        {
          return mensaje;
        }



    }
}

