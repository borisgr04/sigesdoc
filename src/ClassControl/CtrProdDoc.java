package ClassControl;



import ClassEntidad.Dependencia;
import ClassEntidad.DistribucionDoc;
import ClassEntidad.Documento;
import ClassEntidad.TRD;
import Servicios.DependenciaService;
import Servicios.DistribucionDocService;
import Servicios.DocumentoService;
import Servicios.TRDService;
import Servicios.exceptions.PreexistingEntityException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


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
    public long IdSerie;

    public long getIdSerie() {
        return IdSerie;
    }

    public void setIdSerie(long IdSerie) {
        this.IdSerie = IdSerie;
    }
    
   private TRD InicializarSerie() {
        TRDService trds= new TRDService(emf);
        TRD trdserie=trds.findTRD(this.IdSerie);
        return trdserie;
    }

    public CtrProdDoc(EntityManagerFactory emf) {
        this.emf = emf;
    }
    protected EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    
    protected EntityManager em;

    
    
    Map<String, String> properties = new HashMap();
    
    
    public String getMensaje() {
        return mensaje;
    }
    

    public boolean isValido() {
        return valido;
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
    
    public List<Dependencia> getDependencias(){
        em = this.getEntityManager();
        DependenciaService ds = new DependenciaService(emf);
        return ds.findDependenciaEntities();
    }
    
    public abstract String Guardar();

    protected String Guardar(IValidador validador){
        valido=false;
        this.mensaje=validador.Validar(doc);
        if(mensaje.equals("OK")){
            em= this.getEntityManager();
            TRD t=this.InicializarSerie();
            doc.setSerie(t);
            TRDService trdS=new TRDService(emf);
            DocumentoService ds=new DocumentoService(emf);
            DistribucionDocService ddS=new DistribucionDocService(emf);
            
//            try {
                    int ncons=doc.getSerie().getNoCons()+1;
                    doc.setNoDocumento(ncons);
                    DistribucionDoc dd= validador.DistribuirDoc(doc);
                    doc.getDistribucionDocs().add(dd);
                    doc.getSerie().setNoCons(ncons);
                    t.setNoCons(ncons);
                    valido=true;
                    em.getTransaction().begin();
                    em.merge(t);
                    em.persist(doc);
                    em.getTransaction().commit();
                    mensaje="Se Guardo";
                    return mensaje;
//                } catch (PreexistingEntityException ex) {
//                    Logger.getLogger(CtrProdDoc.class.getName()).log(Level.SEVERE, null, ex);
//                } catch (Exception ex) {
//                    Logger.getLogger(CtrProdDoc.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            
        }
        
        return mensaje;
        
    }
    
}

 