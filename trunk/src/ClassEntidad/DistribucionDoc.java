package ClassEntidad;

import java.util.ArrayList;
import java.util.Date;

// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.B95C2765-74F1-32D8-8908-9AE8875FD5F3]
// </editor-fold> 
public class DistribucionDoc {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.8D6CB1C7-157B-30A0-6178-3DCF4EB6A8D2]
    // </editor-fold> 
    private Persona mReceptor;
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.6EDAD4E9-727C-7EA4-E244-231F63967E36]
    // </editor-fold> 
    private Persona mDistribuidor;
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.8BCF99FC-8994-8B49-E546-4F66F1B27022]
    // </editor-fold> 
    private Documento mDocumento;

    private Date fechaEnviado;
    private String idPerDest;

    public String getIdPerDest() {
        return idPerDest;
    }

    public void setIdPerDest(String idPerDest) {
        this.idPerDest = idPerDest;
         for (Persona per : Sistema.instancia().getLstPer()) {
            if (per.getNroIde().equals(idPerDest)) {
                this.mReceptor = per;
            }
        }
    }
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

    public ArrayList<DistribucionDoc> getLstDistriDoc() {
        return Sistema.instancia().getLstDistriDoc();
    }

    public ArrayList<DistribucionDoc> getMiBandejaEntrada(String ide_usuario) {
        ArrayList<DistribucionDoc> be = new ArrayList<DistribucionDoc>();
        for (DistribucionDoc d : this.getLstDistriDoc()) {
            if (d.getReceptor().getNroIde().equals(ide_usuario)&&(d.getEstado()==DDEstado.SIN_RECIBIR) ) {
                be.add(d);
            }
        }
        return be;
    }

     public ArrayList<DistribucionDoc> getMiBandejaArchivados(String ide_usuario) {
        ArrayList<DistribucionDoc> be = new ArrayList<DistribucionDoc>();
        for (DistribucionDoc d : this.getLstDistriDoc()) {
            if (d.getReceptor().getNroIde().equals(ide_usuario)&&(d.getEstado()==DDEstado.ARCHIVADO)) {
                be.add(d);
                
            }
        }
        return be;
    }

     public ArrayList<DistribucionDoc> getMiBandejaReenviado(String ide_usuario) {
        ArrayList<DistribucionDoc> be = new ArrayList<DistribucionDoc>();
        for (DistribucionDoc d : this.getLstDistriDoc()) {
            if (d.getReceptor().getNroIde().equals(ide_usuario)&&(d.getEstado()==DDEstado.REENVIADO) ) {
                be.add(d);
            }
        }
        return be;
    }
      public ArrayList<DistribucionDoc> getMiBandejaResp(String ide_usuario) {
        ArrayList<DistribucionDoc> be = new ArrayList<DistribucionDoc>();
        for (DistribucionDoc d : this.getLstDistriDoc()) {
            if (d.getReceptor().getNroIde().equals(ide_usuario)&&(d.getEstado()==DDEstado.RESPONDIDO) ) {
                be.add(d);
            }
        }
        return be;
    }
    public void crear(){
        Sistema.instancia().Add(this);

    }
    public ArrayList<DistribucionDoc> getMiBandejaSalida(String ide_usuario) {
        ArrayList<DistribucionDoc> be = new ArrayList<DistribucionDoc>();
        for (DistribucionDoc d : this.getLstDistriDoc()) {
            if (d.getDistribuidor().getNroIde().equals(ide_usuario)) {
                be.add(d);
            }
        }
        return be;
    }



    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.9C6C535F-939F-B4DE-4359-4118C0A50304]
    // </editor-fold> 
    public DistribucionDoc() {
        super();
        this.Estado = DDEstado.SIN_RECIBIR;
        this.fechaEnviado= new Date();
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.3ADF0F54-D609-D7A9-7DB9-FB65625A1AD6]
    // </editor-fold> 
    public Persona getDistribuidor() {
        return mDistribuidor;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.734D5BD2-6DFB-EFA1-6FAB-DC13776504A3]
    // </editor-fold> 
    public void setDistribuidor(Persona val) {
        this.mDistribuidor = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.93D6CB67-CA0C-91CD-0008-AF491414D64D]
    // </editor-fold> 
    public Documento getDocumento() {
        return mDocumento;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.7D48BC3B-F809-D431-8467-B394A0D7E009]
    // </editor-fold> 
    public void setDocumento(Documento val) {
        this.mDocumento = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.D83AB3F2-DD09-508C-D7A7-60FD7BE0A3D1]
    // </editor-fold> 
    public Persona getReceptor() {
        return mReceptor;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.CCB741D0-FC8B-19A0-635B-725BAC8C1E06]
    // </editor-fold> 
    public void setReceptor(Persona val) {
        this.mReceptor = val;
    }
}

