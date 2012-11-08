package ClassEntidad;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

@Entity
public class DistribucionDoc implements Serializable {

    @Id    
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @ManyToOne(cascade= CascadeType.MERGE)
    private Persona mReceptor;
    
    @ManyToOne(cascade= CascadeType.MERGE)
    private Persona mDistribuidor;
    
    @ManyToOne(cascade=CascadeType.MERGE)
    private Documento mDocumento;

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

//    public ArrayList<DistribucionDoc> getLstDistriDoc() {
//        return Sistema.instancia().getLstDistriDoc();
//    }
//
//    public ArrayList<DistribucionDoc> getMiBandejaEntrada(String ide_usuario) {
//        ArrayList<DistribucionDoc> be = new ArrayList<DistribucionDoc>();
//        for (DistribucionDoc d : this.getLstDistriDoc()) {
//            if (d.getReceptor().getNroIde().equals(ide_usuario)&&(d.getEstado()==DDEstado.SIN_RECIBIR) ) {
//                be.add(d);
//            }
//        }
//        return be;
//    }

//     public ArrayList<DistribucionDoc> getMiBandejaArchivados(String ide_usuario) {
//        ArrayList<DistribucionDoc> be = new ArrayList<DistribucionDoc>();
//        for (DistribucionDoc d : this.getLstDistriDoc()) {
//            if (d.getReceptor().getNroIde().equals(ide_usuario)&&(d.getEstado()==DDEstado.ARCHIVADO)) {
//                be.add(d);
//                
//            }
//        }
//        return be;
//    }

//     public ArrayList<DistribucionDoc> getMiBandejaReenviado(String ide_usuario) {
//        ArrayList<DistribucionDoc> be = new ArrayList<DistribucionDoc>();
//        for (DistribucionDoc d : this.getLstDistriDoc()) {
//            if (d.getReceptor().getNroIde().equals(ide_usuario)&&(d.getEstado()==DDEstado.REENVIADO) ) {
//                be.add(d);
//            }
//        }
//        return be;
//    }
//      public ArrayList<DistribucionDoc> getMiBandejaResp(String ide_usuario) {
//        ArrayList<DistribucionDoc> be = new ArrayList<DistribucionDoc>();
//        for (DistribucionDoc d : this.getLstDistriDoc()) {
//            if (d.getReceptor().getNroIde().equals(ide_usuario)&&(d.getEstado()==DDEstado.RESPONDIDO) ) {
//                be.add(d);
//            }
//        }
//        return be;
//    }
//    public void crear(){
//        Sistema.instancia().Add(this);
//
//    }
//    public ArrayList<DistribucionDoc> getMiBandejaSalida(String ide_usuario) {
//        ArrayList<DistribucionDoc> be = new ArrayList<DistribucionDoc>();
//        for (DistribucionDoc d : this.getLstDistriDoc()) {
//            if (d.getDistribuidor().getNroIde().equals(ide_usuario)) {
//                be.add(d);
//            }
//        }
//        return be;
//    }


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

    public Persona getReceptor() {
        return mReceptor;
    }

    public void setReceptor(Persona val) {
        this.mReceptor = val;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

