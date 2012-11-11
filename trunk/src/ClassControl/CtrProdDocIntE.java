/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ClassControl;

import ClassEntidad.Dependencia;
import ClassEntidad.DocInternoE;
import ClassEntidad.Funcionario;
import ClassEntidad.PerExterna;
import ClassEntidad.Sistema;
import Servicios.DependenciaService;
import Servicios.FuncionarioService;
import Servicios.PerExternaService;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author borisgr04
 */
public class CtrProdDocIntE extends CtrProdDocInterno {

    public CtrProdDocIntE(EntityManagerFactory emf) {
        super(emf);
    }
    
    @Override
    public String Guardar() {
        Dependencia dp=InicializarDepOrigen();
        PerExterna perExtDes=InicializarPerExtDestino();
        Funcionario funProd= InicializarFuncionarioProd();
        ((DocInternoE)this.doc).setDepOrigen(dp);
        ((DocInternoE)this.doc).setmDestino(perExtDes);
        ((DocInternoE)this.doc).setmProductor(funProd);
        return  super.Guardar(new ValDocInternoE());
    }
    
    private PerExterna InicializarPerExtDestino() {
        PerExternaService ps= new PerExternaService(emf);
        PerExterna perExtDes=ps.findPerExterna(this.getIdeDestino());
        return perExtDes;
    }



    
}
