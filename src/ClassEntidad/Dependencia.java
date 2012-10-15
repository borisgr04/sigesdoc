package ClassEntidad;

import java.util.ArrayList; 

// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.771E0EFF-5F22-0A7F-1A4B-375E355A17C4]
// </editor-fold> 
public class Dependencia {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.DCCA2FCD-80FF-B575-68C6-D33DE711D09F]
    // </editor-fold> 
    private String id;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.A061354F-C5CA-D821-AAE2-68E8F614CE39]
    // </editor-fold> 
    private String nombre;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.E0653357-B05F-CD73-3407-9E3B9E6F8A23]
    // </editor-fold> 
    private ArrayList<Funcionario> mFuncionario;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.8A89EB81-A388-112C-9B23-DEF655F298EC]
    // </editor-fold> 
    private ArrayList<TRD> mTRD;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.BFF09961-C151-B25F-6ED6-63F6694DCF29]
    // </editor-fold> 
    private ArrayList<ActaTraslado> mActaTraslado;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.72041AFC-2A6A-D8D2-33A8-90220A1B3BAE]
    // </editor-fold> 
    public Dependencia () {
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.FF32DFCD-57BC-E52A-565F-F5CDE7D90A7C]
    // </editor-fold> 
    public String getId () {
        return id;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.9E47A95E-651B-04D0-0F73-A8C9D995CA42]
    // </editor-fold> 
    public void setId (String val) {
        this.id = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.6FADAFC7-5269-F69B-B4AC-0A9552733102]
    // </editor-fold> 
    public ArrayList<ActaTraslado> getActaTraslado () {
        return mActaTraslado;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.91DE949B-2422-BC39-DBCD-90A5D41F1468]
    // </editor-fold> 
    public void setActaTraslado (ArrayList<ActaTraslado> val) {
        this.mActaTraslado = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.F772E744-069A-C7CD-E135-6A962BAEC733]
    // </editor-fold> 
    public ArrayList<Funcionario> getFuncionario () {
        return mFuncionario;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.8B37FA70-BDCE-2F23-1334-66DE797B81B7]
    // </editor-fold> 
    public void setFuncionario (ArrayList<Funcionario> val) {
        this.mFuncionario = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.B2629332-FC33-7AB1-94D0-AED971A2C266]
    // </editor-fold> 
    public ArrayList<TRD> getTRD () {
        return mTRD;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.E89023EB-4560-0181-B07C-63C82DB986FE]
    // </editor-fold> 
    public void setTRD (ArrayList<TRD> val) {
        this.mTRD = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.B209F1FC-5BDD-5CC8-F1E8-D0372A5E84B7]
    // </editor-fold> 
    public String getNombre () {
        return nombre;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.02139C71-ADE9-11E6-6990-2F5BBE8EB6FA]
    // </editor-fold> 
    public void setNombre (String val) {
        this.nombre = val;
    }

}

