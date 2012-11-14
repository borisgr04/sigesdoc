package ClassControl;

import ClassEntidad.DistribucionDoc;
import ClassEntidad.DocExterno;
import ClassEntidad.Funcionario;
import ClassEntidad.PerExterna;
import Servicios.DistribucionDocService;
import Servicios.FuncionarioService;
import Servicios.PerExternaService;
import javax.persistence.EntityManagerFactory;

// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.BDD77CDF-734C-E0AC-F813-9434E90C6094]
// </editor-fold> 
public class CtrRecepcion extends CtrProdDoc {

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

    protected void InicializarFuncionarioDest() {
        FuncionarioService ds = new FuncionarioService(emf);
        Funcionario dp = ds.findFuncionario(this.getIdeDestino());
        this.getDoc().setDestino(dp);

    }

    private void InicializarPerExtOrigen() {
        PerExternaService ps = new PerExternaService(emf);
        PerExterna perExtDes = ps.findPerExterna(this.getIdeOrigen());
        this.getDoc().setOrigen(perExtDes);

    }

    private void InicializarDocRel() {
        DistribucionDocService dcs = new DistribucionDocService(emf);
        DistribucionDoc DocRel = dcs.findxNoDoc(this.getIdDocRel());
        this.getDoc().setDocOriginador(DocRel);
    }

     @Override
    String ValidarDatos() {
        if (this.getIdeOrigen().isEmpty()) {
            return "Debe especificar un Remitente";
        } else if (this.getDoc().getDe() == null) {
            return "Debe Remintente Nó Válido";
        } else if (this.getIdeDestino().isEmpty()) {
            return "Debe especificar un Destino";
        } else if (this.getIdSerie() == 0) {
            return "Falta Serie Documental";
        } else if (this.getDoc().getSerie() == null) {
            return "La Serie Documental Especificada No existe en al base de datos";
        } else if (this.getIdeDestino().isEmpty()) {
            return "Debe especificar un destino";
        } else if (this.getDoc().getDe() == null) {
            return "Debe especificar un Destino";
        } else if (doc.getAsunto().isEmpty()) {
            return "Falta Asunto";
        } else if (getDoc().getResumen().isEmpty()) {
            return "Falta diligenciar Resumen";
        }
        return "OK";
    }

    @Override
    public DocExterno getDoc() {
        return (DocExterno) this.doc;
    }

    @Override
    public void inicializarObjetos() {
        super.inicializarObjetos();
        //Se Inicializan los Objetos Locales
        this.InicializarPerExtOrigen();
        this.InicializarFuncionarioDest();
        this.InicializarDocRel();
    }
}
