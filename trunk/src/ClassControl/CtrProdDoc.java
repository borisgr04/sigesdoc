package ClassControl;



import ClassEntidad.DDEstado;
import ClassEntidad.Dependencia;
import ClassEntidad.DistribucionDoc;
import ClassEntidad.Documento;
import ClassEntidad.Sistema;
import ClassEntidad.TRD;
import Servicios.DependenciaService;
import Servicios.DocumentoService;
import Servicios.TRDService;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManagerFactory;


 
public abstract class CtrProdDoc extends CtrBase {
    Documento doc;
    private boolean valido;
    public long IdSerie;

    public CtrProdDoc(EntityManagerFactory emf) {
        super(emf);
    }

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
    
    public boolean isValido() {
        return valido;
    }


    public Documento getDoc() {
        return doc;
    }

    public void setDoc(Documento doc) {
        this.doc = doc;
    }
    
    public List<Dependencia> getDependencias(){
        em = this.getEntityManager();
        DependenciaService ds = new DependenciaService(emf);
        return ds.findDependenciaEntities();
    }
    
    public abstract String Guardar();

    protected String Guardar(IValidador validador){
        valido=false;
        this.setMensaje(validador.Validar(doc));
        if(this.getMensaje().equals("OK")){
            em= this.getEntityManager();
            TRD t=this.InicializarSerie();
            doc.setSerie(t);
            int ncons=doc.getSerie().getNoCons()+1;
            doc.setNoDocumento(ncons);
            DistribucionDoc dd= validador.DistribuirDoc(doc);
            doc.getDistribucionDocs().add(dd);
            doc.getSerie().setNoCons(ncons);
            doc.setEstado(DDEstado.SIN_RECIBIR);
            doc.setFechaReg(new Date());
            //t.setNoCons(ncons);
            valido=true;
            if(doc.getDocOriginador()!=null)
            {
              doc.getDocOriginador().setEstado(DDEstado.RESPONDIDO);
            }
            DocumentoService ds=new DocumentoService(this.emf);
            ds.create(doc);
            Sistema.instancia().Notificar();
            this.setMensaje("Se Guardo");
            return this.getMensaje();
          
        }
        
        return this.getMensaje();
        
    }
    
}

 