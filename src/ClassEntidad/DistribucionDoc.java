package ClassEntidad;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

@Entity
@NamedQueries({
    @NamedQuery(name = "DistribucionDoc.findMiBandejaEntrada", query = "SELECT d FROM DistribucionDoc d WHERE d.Estado=:Estado AND  d.mReceptor = :mReceptor"),
    @NamedQuery(name = "DistribucionDoc.findMiBandejaSalida", query = "SELECT d FROM DistribucionDoc d WHERE d.mDistribuidor = :mDistribuidor")
})public class DistribucionDoc implements Serializable {

    @Id    
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @ManyToOne(cascade= CascadeType.MERGE)
    private Persona mReceptor;
    
    @ManyToOne(cascade= CascadeType.MERGE)
    private Persona mDistribuidor;
    
    @ManyToOne(cascade=CascadeType.MERGE)
    private Documento mDocumento;
    @OneToMany(mappedBy = "DocOriginador")
    private List<Documento> docOriginados;

    public Persona getmReceptor() {
        return mReceptor;
    }

    public void setmReceptor(Persona mReceptor) {
        this.mReceptor = mReceptor;
    }

    public Persona getmDistribuidor() {
        return mDistribuidor;
    }

    public void setmDistribuidor(Persona mDistribuidor) {
        this.mDistribuidor = mDistribuidor;
    }

    public Documento getmDocumento() {
        return mDocumento;
    }

    public void setmDocumento(Documento mDocumento) {
        this.mDocumento = mDocumento;
    }

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaEnviado;
    
    public Date getFechaEnviado() {
        return fechaEnviado;
    }

    public void setFechaEnviado(Date fechaEnviado) {
        this.fechaEnviado = fechaEnviado;
    }

    private DDEstado Estado;

    public DDEstado getEstado() {
        return Estado;
    }

    public void setEstado(DDEstado mEstado) {
        this.Estado = mEstado;
    }

    public DistribucionDoc() {
        super();
        this.Estado = DDEstado.SIN_RECIBIR;
        this.fechaEnviado= new Date();
    }

    public Persona getDistribuidor() {
        return mDistribuidor;
    }

    public void setDistribuidor(Persona val) {
        this.mDistribuidor = val;
    }

    public Documento getDocumento() {
        return mDocumento;
    }

    public void setDocumento(Documento val) {
        this.mDocumento = val;
    }

  
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

