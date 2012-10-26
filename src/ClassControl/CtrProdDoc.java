package ClassControl;



import ClassEntidad.DistribucionDoc;
import ClassEntidad.Documento;
import ClassEntidad.TRD;


/**
 *  <p style="margin-top: 0">
 *        Este Clase Maneja
 *      </p>
 */
// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.80F6EA50-E23F-D29D-B14D-181D560CD7CF]
// </editor-fold> 
public abstract class CtrProdDoc {

    Documento doc;
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

    public Documento getDoc() {
        return doc;
    }

    public void setDoc(Documento doc) {
        this.doc = doc;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.05128E10-507F-BF34-68F7-7CCDDB4957FF]
    // </editor-fold> 
    public CtrProdDoc () {
    }
    
    public abstract String Guardar();

    protected String Guardar(IValidador validador){
        valido=false;
        this.mensaje=validador.Validar(doc);
        if(mensaje.equals("OK")){
            TRD t = TRD.buscarSerie(doc.getSerieTRD());
            if(t!=null){
                int ncons=t.getNoCons()+1;
                doc.setNoDocumento(ncons);
                //
                DistribucionDoc dd=new DistribucionDoc();
                dd.setDistribuidor(doc.getProductor());//Por Primera Vez
                dd.setReceptor(doc.getDestino());//Por primera Vez
                dd.setDocumento(doc);
                dd.crear();
                ////
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

