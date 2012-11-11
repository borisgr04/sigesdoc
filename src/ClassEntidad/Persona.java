package ClassEntidad;

// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

// #[regen=yes,id=DCE.27E8B16E-E306-583D-291A-C6971D1E98F6]
// </editor-fold> 
@Entity
@Inheritance(strategy= InheritanceType.JOINED)
public class Persona implements Serializable {

    @Id
    private String nroIde;
    
    private String nombres;

    private String apellidos;
    
    private String direccion;
    
    private String telefono;
    
    private String email;
    
    @OneToMany(mappedBy = "mReceptor")
    private List<DistribucionDoc> distDocRecep;
    @OneToMany(mappedBy = "mDistribuidor")
    private List<DistribucionDoc> distDocDistri;
    
   
    public List<DistribucionDoc> getDistDocRecep() {
        return distDocRecep;
    }

    public void setDistDocRecep(List<DistribucionDoc> distDocRecep) {
        this.distDocRecep = distDocRecep;
    }

    public List<DistribucionDoc> getDistDocDistri() {
        return distDocDistri;
    }

    public void setDistDocDistri(List<DistribucionDoc> distDocDistri) {
        this.distDocDistri = distDocDistri;
    }
    
   
    
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.A3BF31F8-8782-1EE1-1425-749A1D926E4B]
    // </editor-fold> 
    public Persona() {
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.D031F027-7CFF-513C-816D-19D42E4687DD]
    // </editor-fold> 
    public String getApellidos() {
        return apellidos;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.BC0D6628-FDB3-E191-99FD-DB87C39E5491]
    // </editor-fold> 
    public void setApellidos(String val) {
        this.apellidos = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.42BCFE8D-8A97-107E-1836-F9472605ECB3]
    // </editor-fold> 
    public String getDireccion() {
        return direccion;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.88DC27F0-3647-9EDD-3524-24EDC9251D52]
    // </editor-fold> 
    public void setDireccion(String val) {
        this.direccion = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.F0D15353-3CC2-DC34-CB4D-467BB04F589C]
    // </editor-fold> 
    public String getEmail() {
        return email;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.3E4C38C7-9353-B432-7984-EA2DA7F07AEA]
    // </editor-fold> 
    public void setEmail(String val) {
        this.email = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.6E058241-C962-092E-9D04-227D58A59F78]
    // </editor-fold> 
    public String getNombres() {
        return nombres;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.27729F2E-F63F-62DB-174D-F2CB1B723A62]
    // </editor-fold> 
    public void setNombres(String val) {
        this.nombres = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.37423864-7FDB-C0DF-D54F-A1DEFA5EAB98]
    // </editor-fold> 
    public String getNroIde() {
        return nroIde;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.1911CAC6-17AB-C9A9-3CC6-ECB2D6F0F0F3]
    // </editor-fold> 
    public void setNroIde(String val) {
        this.nroIde = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.164E29CE-ECCF-41E7-CDC6-174B5A442C0B]
    // </editor-fold> 
    public String getTelefono() {
        return telefono;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.E84B166A-E60A-32A8-F6DA-B7439B83132E]
    // </editor-fold> 
    public void setTelefono(String val) {
        this.telefono = val;
    }

//    public ArrayList<Persona> getPersonas() {
//        return Sistema.instancia().getLstPer();
//    }

    public Persona(String nroIde, String nombres, String apellidos, String telefono, String email) {
        this.nroIde = nroIde;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.email = email;
    }
}

