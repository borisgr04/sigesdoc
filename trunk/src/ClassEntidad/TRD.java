package ClassEntidad;

import java.util.ArrayList; 

// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.8E51194F-DF62-0DF0-F794-3780A204129C]
// </editor-fold> 
public class TRD {

    private String Id_Serie;

    public String getId_Serie() {
        return Id_Serie;
    }

    public void setId_Serie(String Id_Serie) {
        this.Id_Serie = Id_Serie;
    }

    public int getNoCons() {
        return noCons;
    }

    public void setNoCons(int noCons) {
        this.noCons = noCons;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.27738132-413A-82BB-B4BA-D2B2117B88DF]
    // </editor-fold> 
    private int noCons;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.108516EA-98D2-0884-20CD-712BF6BA476D]
    // </editor-fold> 
    private String serie;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.E13BFBEE-78A8-34CA-8110-7D8210137040]
    // </editor-fold> 
    private int tRetenAC;

    public int gettRetAG() {
        return tRetAG;
    }

    public void settRetAG(int tRetAG) {
        this.tRetAG = tRetAG;
    }

    public int gettRetenAC() {
        return tRetenAC;
    }

    public void settRetenAC(int tRetenAC) {
        this.tRetenAC = tRetenAC;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.93E10889-82C3-7DB4-1FFD-66DC40DD137F]
    // </editor-fold> 
    private int tRetAG;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.81C7A6A4-FC53-9F19-B136-9EEAA158E1B5]
    // </editor-fold> 
    private String dispFinal;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.CEE817B9-C278-F0E7-347C-5D8B830BFBA9]
    // </editor-fold> 
    private int proced;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.7C497303-8AC9-B5B1-7944-310AC1DEB54A]
    // </editor-fold> 
    private ArrayList<Documento> mDocumento;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.4A26C873-3DF5-3F88-3365-B60D5218CCBB]
    // </editor-fold> 
    public TRD () {
    }

    
    public static TRD buscarSerie(String Id_Serie) {
        return Sistema.instancia().buscarSerie(Id_Serie);
    }

   


    

   // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.23474759-16A9-280C-E91D-DFB3EE5194AD]
    // </editor-fold> 
    public String getDispFinal () {
        return dispFinal;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.0565F44B-3B69-52D7-7AB2-D2970AC3AFCF]
    // </editor-fold> 
    public void setDispFinal (String val) {
        this.dispFinal = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.F68E6ED8-0F47-D68C-F7CB-48975E676001]
    // </editor-fold> 
    public ArrayList<Documento> getDocumento () {
        return mDocumento;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.1F175316-5685-8081-EF32-E383F2CA4288]
    // </editor-fold> 
    public void setDocumento (ArrayList<Documento> val) {
        this.mDocumento = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.22393D07-70C4-4B99-8D14-5B01646A55E2]
    // </editor-fold> 
    public int getProced () {
        return proced;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.BF1FA8A6-85D8-5C07-529D-49ECEFB080B0]
    // </editor-fold> 
    public void setProced (int val) {
        this.proced = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.92FFC5DF-A921-1B4E-97C2-F76A455D9133]
    // </editor-fold> 
    public String getSerie () {
        return serie;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.3F7F7736-B51B-B451-405B-6E8412F1D53B]
    // </editor-fold> 
    public void setSerie (String val) {
        this.serie = val;
    }



}

