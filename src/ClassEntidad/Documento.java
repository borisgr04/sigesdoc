package ClassEntidad;

import java.util.ArrayList;
import java.util.Date;


// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.1EB730AD-86A4-CB1C-C085-9FD58A110678]
// </editor-fold> 
public abstract class Documento {

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
    private int estado;

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
    private String fecha;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.D9870980-0CB3-1A44-0BF9-D2F3DC0D2337]
    // </editor-fold> 
    private int anexos;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.1789F6FC-AB5C-3F07-BC07-C134407BB799]
    // </editor-fold> 
    private boolean noFolio;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.865C2F67-7D9F-DCD3-26E0-E2E0304A4120]
    // </editor-fold> 
    private Persona mDestino;


    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.72C96063-A70A-ACA9-23B8-95C55A1B1680]
    // </editor-fold> 
    public Documento () {
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.EF207F11-33E1-ACFA-B516-E6AB80FAF899]
    // </editor-fold> 
    public int getAnexos () {
        return anexos;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.3B6407D4-A10C-658E-7854-C293034EA53E]
    // </editor-fold> 
    public void setAnexos (int val) {
        this.anexos = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.EA6E3166-D483-C7D0-5A0E-44EAF05545C2]
    // </editor-fold> 
    public String getAsunto () {
        return asunto;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.25ADDA24-D95C-55C3-1C98-0F47F11FBFAC]
    // </editor-fold> 
    public void setAsunto (String val) {
        this.asunto = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.6ACD8034-0B24-249B-E025-D7BF47A45FFD]
    // </editor-fold> 
    public int getEstado () {
        return estado;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.550CE830-499F-5C63-177F-582B73E65BB6]
    // </editor-fold> 
    public void setEstado (int val) {
        this.estado = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.73551275-756E-2BAA-D187-DBB8E26ECE04]
    // </editor-fold> 
    public String getFecha () {
        return fecha;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.6B0B8A04-28B8-D92B-4B3E-1F43D12E4C13]
    // </editor-fold> 
    public void setFecha (String val) {
        this.fecha = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.33586D89-C288-912B-AF8E-1EFF57027F35]
    // </editor-fold> 
    public Persona getDestino () {
        return mDestino;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.9B9441B3-5E30-C2A5-7A77-85207212A6D6]
    // </editor-fold> 
    public void setDestino (Persona val) {
        this.mDestino = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.89C41A92-AFDE-5C2A-60EF-575C353D0772]
    // </editor-fold> 
    public int getNoDocumento () {
        return noDocumento;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.B66FF99C-6FC7-D898-E425-2EC3E58D29D5]
    // </editor-fold> 
    public void setNoDocumento (int val) {
        this.noDocumento = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.C415F520-0531-9214-B4E0-EB27E8F30C9B]
    // </editor-fold> 
    public boolean getNoFolio () {
        return noFolio;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.A3D10245-B7AA-73E6-6443-97017D197F3A]
    // </editor-fold> 
    public void setNoFolio (boolean val) {
        this.noFolio = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.691033AB-BBA5-B32E-7C47-05C2350D48CE]
    // </editor-fold> 
    public String getResumen () {
        return resumen;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.AAC8001E-44DD-20C9-A7CC-C3503FAF336B]
    // </editor-fold> 
    public void setResumen (String val) {
        this.resumen = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.C7781DA7-E369-7AD1-F229-CC08F3DC210F]
    // </editor-fold> 
    public String getSerieTRD () {
        return serieTRD;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.AEA2D6B9-452D-6E72-71A0-8D74C195CE3B]
    // </editor-fold> 
    public void setSerieTRD (String val) {
        this.serieTRD = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.D07C2AE2-3CE2-4A0B-5CC0-91797DA45FBF]
    // </editor-fold> 
    public Persona getProductor () {
        return mProductor;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.027C33E8-184F-9563-5A1D-1AAC06430362]
    // </editor-fold> 
    public void setProductor (Persona val) {
        this.mProductor = val;
    }

    public String crear(){
//        this.FechaReg= Date.
        Sistema.instancia().Add(this);
        return "Se Registro el Documento " +this.getNoDocumento() ;

    }

    public ArrayList<Documento> getDocumentos(){
      return Sistema.instancia().getLstDoc();
    }

    Date FechaReg;

    public Date getFechaReg() {
        return FechaReg;
    }
    
}

