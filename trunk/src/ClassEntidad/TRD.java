package ClassEntidad;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class TRD implements Serializable {
    
    @Id
    private Long id;
    
    private String Id_Serie;
    
    @ManyToOne(cascade= CascadeType.PERSIST)
    private Dependencia dependencia;
    
    private int noCons;

    private String serie;

    private int tRetenAC;
    
    private int tRetAG;

    private String dispFinal;

    private int proced;
    @OneToMany(mappedBy = "serie")
    private List<Documento> documentos;

    public List<Documento> getDocumentos() {
        return documentos;
    }

    public void setDocumentos(List<Documento> documentos) {
        this.documentos = documentos;
    }

    
    public Dependencia getDependencia() {
        return dependencia;
    }

    public void setDependencia(Dependencia dependencia) {
        this.dependencia = dependencia;
    }
//    
//    public void actConsSerie() {
//        Sistema.instancia().actConsSerie(this);
//    }

    public String getId_Serie() {
        return Id_Serie;
    }

    public TRD(String Id_Serie) {
        this.Id_Serie = Id_Serie;
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

    public TRD () {
    }

    
//    public static TRD buscarSerie(String Id_Serie) {
//        return Sistema.instancia().buscarSerie(Id_Serie);
//    }
    
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

 
//    public ArrayList<TRD> getTRD(){
//        return Sistema.instancia().getLstTRD();
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TRD(Long id) {
        this.id = id;
    }


}

