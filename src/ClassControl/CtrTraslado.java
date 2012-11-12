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

    public void Guardar(ActaTraslado at){
        
        ActaTrasladoService ats=new ActaTrasladoService(this.emf);
        at.setDependencia(this.InicializarDependencia());
        ats.create(at);
        this.setMensaje("Se Creó el Acta de Traslado N° " + at.getNroActa()+"\n Los Documentos estan marcados como TRASLADADOS");
        
    }
    
     private Dependencia InicializarDependencia() {
        DependenciaService ps= new DependenciaService(emf);
        Dependencia perExtDes=ps.findDependencia(this.getDep());
        return perExtDes;
    }

}

