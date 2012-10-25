package ClassEntidad;

import java.util.ArrayList;


// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.4A2ED1A7-9902-9429-7D3D-5C1AE868F528]
// </editor-fold> 
public class Funcionario extends Persona {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.8679179D-957B-6617-504D-973062A57284]
    // </editor-fold> 
    private String usuario;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.C32BA2A8-64A4-26D3-D12D-974961652754]
    // </editor-fold> 
    private String clave;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.2BB45C71-1CE2-087A-440A-9274F30A7D1E]
    // </editor-fold> 
    private String rol;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.C5C46D26-26D8-B047-CA33-2CCBF621C0A8]
    // </editor-fold> 
    public Funcionario () {
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.0A3D322D-A7D9-4D10-6CC0-8E1194724D09]
    // </editor-fold> 
    public String getClave () {
        return clave;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.C1355E0F-26C0-6972-2BCA-8DB946221AD0]
    // </editor-fold> 
    public void setClave (String val) {
        this.clave = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.F3D6E41C-8756-068D-1DA2-818604B8A75D]
    // </editor-fold> 
    public String getRol () {
        return rol;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.C9F46FC9-83F4-3F96-94A5-AE1D2D39AA30]
    // </editor-fold> 
    public void setRol (String val) {
        this.rol = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.C82BD883-741E-4898-EE51-AE59AAB50AB5]
    // </editor-fold> 
    public String getUsuario () {
        return usuario;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.18C67C35-E7F9-649A-C8CD-65C42B85061F]
    // </editor-fold> 
    public void setUsuario (String val) {
        this.usuario = val;
    }


    public ArrayList<Persona> getFuncionario() {
        ArrayList<Persona> pe = new ArrayList<Persona>();
        for (Persona per : Sistema.instancia().getLstPer()) {
            if (per instanceof Funcionario) {
                pe.add(per);
            }
        }

        return pe;
    }

}

