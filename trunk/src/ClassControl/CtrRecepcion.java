package ClassControl;
import ClassEntidad.DistribucionDoc;
import ClassEntidad.DocExterno;
import ClassEntidad.Documento;
import ClassEntidad.Funcionario;
import ClassEntidad.PerExterna;
import ClassEntidad.TRD;
import Servicios.DistribucionDocService;
import Servicios.DocumentoService;
import Servicios.FuncionarioService;
import Servicios.PerExternaService;
import Servicios.TRDService;
import javax.persistence.EntityManagerFactory;

// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.BDD77CDF-734C-E0AC-F813-9434E90C6094]
// </editor-fold> 
public class CtrRecepcion extends CtrProdDoc{

    private String IdeDestino;
    private String IdeOrigen;
    private int IdDocRel;
   
    public int getIdDocRel() {
        return IdDocRel;
    }

    public void setIdDocRel(int IdDocRel) {
        this.IdDocRel = IdDocRel;
    }

    public String getIdeOrigen() {
        return IdeOrigen;
    }

    public void setIdeOrigen(String IdeOrigen) {
        this.IdeOrigen = IdeOrigen;
    }

    public String getIdeDestino() {
        return IdeDestino;
    }

    public void setIdeDestino(String IdeDestino) {
        this.IdeDestino = IdeDestino;
    }
    
 public CtrRecepcion(EntityManagerFactory emf) {
        super(emf);
 }
 
 
 protected Funcionario InicializarFuncionarioDest() {
        FuncionarioService ds= new FuncionarioService(emf);
        Funcionario dp=ds.findFuncionario(this.getIdeDestino());
        return dp;
  }
 
 private PerExterna InicializarPerExtOrigen() {
        PerExternaService ps= new PerExternaService(emf);
        PerExterna perExtDes=ps.findPerExterna(this.getIdeOrigen());
        return perExtDes;
    }
 private DistribucionDoc InicializarDocRel() {
        DistribucionDocService dcs= new DistribucionDocService(emf);
        DistribucionDoc DocRel=dcs.findxNoDoc(this.getIdDocRel());
        return DocRel;
    }
 

 
  @Override
  public String Guardar(){
      
     if (!this.getIdeDestino().isEmpty()){
      Funcionario funDes=InicializarFuncionarioDest();
      ((DocExterno)this.doc).setDestino(funDes);
     }
     
      if (!this.IdeOrigen.isEmpty()){
      PerExterna Pext=InicializarPerExtOrigen();
      ((DocExterno)this.doc).setOrigen(Pext);
      }
      
      
      if (this.getIdDocRel()!=0){
         DistribucionDoc Drel=InicializarDocRel();
         if (Drel==null){
            this.setMensaje("El Documeto Relacionado no existe");
            return this.mensaje;  
         }
         
         else{
             ((DocExterno)this.doc).setDocOriginador(Drel);
         }
      }
     
      
      return  super.Guardar(new ValDocExterno());
     
  }
}
    



