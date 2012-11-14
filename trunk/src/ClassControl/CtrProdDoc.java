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
        TRDService trds = new TRDService(emf);
        TRD trdserie = trds.findTRD(this.IdSerie);
        return trdserie;
    }

 

    public Documento getDoc() {
        return doc;
    }

    public void setDoc(Documento doc) {
        this.doc = doc;
    }

    public List<Dependencia> getDependencias() {
        em = this.getEntityManager();
        DependenciaService ds = new DependenciaService(emf);
        return ds.findDependenciaEntities();
    }

     public String Guardar() {
        this.inicializarObjetos();
        this.setMensaje(ValidarDatos());
        if(this.getMensaje().equals("OK")){
            return guardarDoc();
        }
        else{
            return this.getMensaje();
        }
    }
    private String guardarDoc() {
        this.setValido(false);
        int ncons = doc.getSerie().getNoCons() + 1;
        doc.setNoDocumento(ncons);
        DistribucionDoc dd = DistribuirDoc();
        doc.getDistribucionDocs().add(dd);
        doc.getSerie().setNoCons(ncons);
        doc.setEstado(DDEstado.SIN_RECIBIR);
        doc.setFechaReg(new Date());
        int DocRel = 0;
        if (doc.getDocOriginador() != null) {
            doc.getDocOriginador().setEstado(DDEstado.RESPONDIDO);
            DocRel = doc.getDocOriginador().getDocumento().getNoDocumento();
        }
        DocumentoService ds = new DocumentoService(this.emf);
        ds.create(doc);
       this.setValido(true);
        Sistema.instancia().Notificar();
        this.setMensaje("Se Registro el Documento N° " + doc.getNoDocumento());
         return this.getMensaje();

    }

    abstract String ValidarDatos ();
    
    public void inicializarObjetos(){
        TRD t = this.InicializarSerie();
        doc.setSerie(t);
    }
    
      public DistribucionDoc DistribuirDoc() {
        DistribucionDoc dd = new DistribucionDoc();
        dd.setDistribuidor(getDoc().getDe());
        dd.setmReceptor(getDoc().getPara());//Por primera Vez
        dd.setDocumento(getDoc());
        return dd;
    }
    
}
