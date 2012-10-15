package ClassEntidad;

import java.util.ArrayList; 

// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.66BAEF14-8553-EB9E-9C4B-3A18B13958FD]
// </editor-fold> 
public class ActaTraslado {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.496AAFC7-9598-A213-82F0-5E1B74A09731]
    // </editor-fold> 
    private int nroActa;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.3F0CBF56-9791-FC34-1E62-CEE77D0AB24F]
    // </editor-fold> 
    private String fecActa;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.8CF0D1E6-DF2C-2B5E-5C0A-03073B4274C0]
    // </editor-fold> 
    private ArrayList<DocActa> mDocActa;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.3EB220BB-8031-32FB-770A-E237E1DCE084]
    // </editor-fold> 
    public ActaTraslado () {
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.64BD1968-46D9-DF58-802E-3F88BA4F7564]
    // </editor-fold> 
    public String getFecActa () {
        return fecActa;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.CABB2D4B-7D4A-CEDE-6DFD-C7FC97F40D37]
    // </editor-fold> 
    public void setFecActa (String val) {
        this.fecActa = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.C803EB56-CA74-8E16-3E94-C0978D00CA5A]
    // </editor-fold> 
    public ArrayList<DocActa> getDocActa () {
        return mDocActa;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.0FE77F4D-F16C-99F5-64E8-2897484503C7]
    // </editor-fold> 
    public void setDocActa (ArrayList<DocActa> val) {
        this.mDocActa = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.D2A7D170-71D2-0C9C-EC5F-7FF0FC876BCB]
    // </editor-fold> 
    public int getNroActa () {
        return nroActa;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.CD328B2F-C1FD-3F9D-D786-126D42659FB4]
    // </editor-fold> 
    public void setNroActa (int val) {
        this.nroActa = val;
    }

}

