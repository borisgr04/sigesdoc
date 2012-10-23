package ClassEntidad;

import java.util.ArrayList;
import java.util.Date;

// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.1EB730AD-86A4-CB1C-C085-9FD58A110678]
// </editor-fold> 
public abstract class Documento {

    private int folios;
    private String idPerProd;
    private String idPerDest;
    private Date FechaReg;
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.471FA084-4D58-1305-829E-0C2B9A34201B]
    // </editor-fold> 
    private Persona mProductor;
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.49E81458-1403-2DD5-5535-5231440C8154]
    // </editor-fold> 
    private int noDocumento;
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.2543FB2B-BA7D-3631-28C7-E25EF1576B29]
    // </editor-fold> 
    private String serieTRD;
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.048FDAEA-C383-1BC3-9EF1-40B83548D5DE]
    // </editor-fold> 
    private String estado;
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.C1611B51-725F-4889-BBA1-1059696EB368]
    // </editor-fold> 
    private String asunto;
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.4AC1FBBB-0A89-7551-02FD-A35E40CB79B3]
    // </editor-fold> 
    private String resumen;
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.2D614B4E-774C-E08B-C87D-48B5FD07F4BA]
    // </editor-fold> 
    
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.D9870980-0CB3-1A44-0BF9-D2F3DC0D2337]
    // </editor-fold> 
    private boolean anexos;
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.865C2F67-7D9F-DCD3-26E0-E2E0304A4120]
    // </editor-fold> 
    private Persona mDestino;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.72C96063-A70A-ACA9-23B8-95C55A1B1680]
    // </editor-fold> 
    public Documento() {
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.EF207F11-33E1-ACFA-B516-E6AB80FAF899]
    // </editor-fold> 
    public boolean getAnexos() {
        return anexos;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.3B6407D4-A10C-658E-7854-C293034EA53E]
    // </editor-fold> 
    public void setAnexos(boolean val) {
        this.anexos = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.EA6E3166-D483-C7D0-5A0E-44EAF05545C2]
    // </editor-fold> 
    public String getAsunto() {
        return asunto;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.25ADDA24-D95C-55C3-1C98-0F47F11FBFAC]
    // </editor-fold> 
    public void setAsunto(String val) {
        this.asunto = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.6ACD8034-0B24-249B-E025-D7BF47A45FFD]
    // </editor-fold> 
    public String getEstado() {
        return estado;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.550CE830-499F-5C63-177F-582B73E65BB6]
    // </editor-fold> 
    public void setEstado(String val) {
        this.estado = val;
    }


    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.33586D89-C288-912B-AF8E-1EFF57027F35]
    // </editor-fold> 
    public Persona getDestino() {
        mDestino = null;
        for (Persona per : Sistema.instancia().getLstPer()) {
            if (per.getNroIde().equals(this.idPerDest)) {
                mDestino = per;
            }
        }
        return mDestino;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.9B9441B3-5E30-C2A5-7A77-85207212A6D6]
    // </editor-fold> 
    public void setDestino(Persona val) {
        this.mDestino = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.89C41A92-AFDE-5C2A-60EF-575C353D0772]
    // </editor-fold> 
    public int getNoDocumento() {
        return noDocumento;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.B66FF99C-6FC7-D898-E425-2EC3E58D29D5]
    // </editor-fold> 
    public void setNoDocumento(int val) {
        this.noDocumento = val;
    }

    public int getFolios() {
        return folios;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.691033AB-BBA5-B32E-7C47-05C2350D48CE]
    // </editor-fold> 
    public String getResumen() {
        return resumen;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.AAC8001E-44DD-20C9-A7CC-C3503FAF336B]
    // </editor-fold> 
    public void setResumen(String val) {
        this.resumen = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.C7781DA7-E369-7AD1-F229-CC08F3DC210F]
    // </editor-fold> 
    public String getSerieTRD() {
        return serieTRD;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.AEA2D6B9-452D-6E72-71A0-8D74C195CE3B]
    // </editor-fold> 
    public void setSerieTRD(String val) {
        this.serieTRD = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.D07C2AE2-3CE2-4A0B-5CC0-91797DA45FBF]
    // </editor-fold> 
    public Persona getProductor() {
        mProductor = null;
        for (Persona per : Sistema.instancia().getLstPer()) {
            if (per.getNroIde().equals(this.idPerProd)) {
                mProductor = per;
            }
        }
        return mProductor;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.027C33E8-184F-9563-5A1D-1AAC06430362]
    // </editor-fold> 
    public void setProductor(Persona val) {
        this.mProductor = val;
    }

    public String crear() {
//        this.FechaReg= Date.
        this.FechaReg= new Date();
        Sistema.instancia().Add(this);
        return "Se Registro el Documento " + this.getNoDocumento();

    }

    public ArrayList<Documento> getDocumentos() {
        return Sistema.instancia().getLstDoc();
    }

    public Date getFechaReg() {
        return FechaReg;
    }

    public String getIdPerProd() {
        return idPerProd;
    }

    public void setIdPerProd(String idPerProd) {
        this.idPerProd = idPerProd;
    }

    public void setFolios(int folios) {
        this.folios = folios;
    }

    public String getIdPerDest() {
        return idPerDest;
    }

    public void setIdPerDest(String idPerDest) {
        this.idPerDest = idPerDest;
    }
}

