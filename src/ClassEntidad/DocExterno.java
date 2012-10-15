package ClassEntidad;


// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.3872E9E7-86AB-5ED4-12E6-DAE3A22533D5]
// </editor-fold> 
public class DocExterno extends Documento {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.7536FE5E-E517-0D09-1A71-C78F7D4518C6]
    // </editor-fold> 
    private String rasonSocial;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.A74710FC-2600-DB17-6E1D-5F02908AE0F7]
    // </editor-fold> 
    private PerExterna Origen;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.C534DADE-23D4-8B9F-40A2-DA2BFFFBD6E2]
    // </editor-fold> 
    public DocExterno () {
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.ABBF68FB-C44C-70B6-36FA-DF269845C753]
    // </editor-fold> 
    public PerExterna getIde () {
        return Origen;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.1B30ACAC-84C2-B7A9-0C33-DEF7A2D0E408]
    // </editor-fold> 
    public void setIde (PerExterna val) {
        this.Origen = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.A215E812-31F9-7CC2-696C-EC4A52312AFC]
    // </editor-fold> 
    public String getRasonSocial () {
        return rasonSocial;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.3CA7B4BD-79E1-5711-9091-43E9F5878D2D]
    // </editor-fold> 
    public void setRasonSocial (String val) {
        this.rasonSocial = val;
    }

}

