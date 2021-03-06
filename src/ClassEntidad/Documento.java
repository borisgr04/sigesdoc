package ClassEntidad;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Inheritance(strategy= InheritanceType.JOINED)
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Documento.findxTrasladar", query = "SELECT d FROM Documento d WHERE d.serie = :serie  AND d.FechaReg>=:FechaReg AND d.estado=:estado")})
public abstract class Documento implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int noDocumento;
    private int folios;
    private DDEstado estado;
    private String asunto;
    private String resumen;
    private boolean anexos;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date FechaReg;
    
//    @Temporal(javax.persistence.TemporalType.DATE)
//    private Date FechaArc;
//
//    public Date getFechaArc() {
//        return FechaArc;
//    }
//
//    public void setFechaArc(Date FechaArc) {
//        this.FechaArc = FechaArc;
//    }
    
    @ManyToOne(cascade= CascadeType.REFRESH)
    private ActaTraslado actaTraslado;

    public ActaTraslado getActaTraslado() {
        return actaTraslado;
    }

    public void setActaTraslado(ActaTraslado actaTraslado) {
        this.actaTraslado = actaTraslado;
    }

    public void setFechaReg(Date FechaReg) {
        this.FechaReg = FechaReg;
    }
  
    @ManyToOne(cascade= CascadeType.REFRESH)
    private DistribucionDoc DocOriginador;
  

    public DistribucionDoc getDocOriginador() {
        return DocOriginador;
    }

    public void setDocOriginador(DistribucionDoc DocOriginador) {
        this.DocOriginador = DocOriginador;
    }

   //@OneToOne(mappedBy = "mDocumento")
    //private DocActa docActa;

    @ManyToOne(cascade= CascadeType.REFRESH)
    private TRD serie;
    
    @OneToMany(mappedBy = "mDocumento",cascade= CascadeType.PERSIST )
    private List<DistribucionDoc> distribucionDocs= new ArrayList<DistribucionDoc>();
    
    

    public TRD getSerie() {
        return serie;
    }

    public void setSerie(TRD serie) {
        this.serie = serie;
    }

//    public DocActa getDocActa() {
 //       return docActa;
 //   }

  //  public void setDocActa(DocActa docActa) {
  //      this.docActa = docActa;
  //  }

    public List<DistribucionDoc> getDistribucionDocs() {
        return distribucionDocs;
    }

    public void setDistribucionDocs(List<DistribucionDoc> distribucionDocs) {
        this.distribucionDocs = distribucionDocs;
    }
  
    public DDEstado getEstado() {
         return estado;
    }

    public void setEstado(DDEstado estado) {
        this.estado = estado;
    }
    
    public Documento() {
    }

    public boolean getAnexos() {
        return anexos;
    }

    public void setAnexos(boolean val) {
        this.anexos = val;
    }

    public String getAsunto() {
        return asunto;
    }

    
    public void setAsunto(String val) {
        this.asunto = val;
    }

    public int getNoDocumento() {
        return noDocumento;
    }
    
    public void setNoDocumento(int val) {
        this.noDocumento = val;
    }

    public int getFolios() {
        return folios;
    }

    public String getResumen() {
        return resumen;
    }

    public void setResumen(String val) {
        this.resumen = val;
    }

    public Date getFechaReg() {
        return FechaReg;
    }

    public void setFolios(int folios) {
        this.folios = folios;
    }
  
    
    public abstract Persona getDe();
    public abstract Persona getPara();
  
}

