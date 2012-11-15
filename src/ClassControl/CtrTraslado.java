package ClassControl;

import ClassEntidad.ActaTraslado;
import ClassEntidad.Dependencia;
import Servicios.ActaTrasladoService;
import Servicios.DependenciaService;
import javax.persistence.EntityManagerFactory;

// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.4A3CC895-577B-06A3-4326-5E7BD49F11AC]
// </editor-fold> 
public class CtrTraslado extends CtrBase {

    String dep;

    public String getDep() {
        return dep;
    }

    public void setDep(String dep) {
        this.dep = dep;
    }

    public CtrTraslado(EntityManagerFactory emf) {
        super(emf);
    }

    String validar(ActaTraslado at) {
        if (at.getFecActa() == null) {
            return "La fecha del Acta no puede estar vacia";
        }
        if(this.getDep()==null){
            return "Debe especificar una dependencia";
        }
        if(at.getDependencia()==null){
            return "Dependencia especificada no existe";
        }
        if(at.getDocActas()==null || at.getDocActas().isEmpty()){
            return "Debe especificar al menos un documento en el Acta";
        }
//        if(at.getCaja()==0){
//        return "Debe especificar número de Caja";
//        }
        return "OK";
    }

    public void Guardar(ActaTraslado at) {
        at.setDependencia(this.InicializarDependencia());
        this.setMensaje(this.validar(at));
        if (this.getMensaje().equals("OK")) {
            ActaTrasladoService ats = new ActaTrasladoService(this.emf);
            at.setDependencia(this.InicializarDependencia());
            ats.create(at);
            this.setMensaje("Se Creó el Acta de Traslado N° " + at.getNroActa() + "\n Los Documentos estan marcados como TRASLADADOS");
        }
    }

    private Dependencia InicializarDependencia() {
        DependenciaService ps = new DependenciaService(emf);
        return ps.findDependencia(this.getDep());
    }
}
