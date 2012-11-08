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
public class CtrProdDocIntE extends CtrProdDoc {

      
    
    private String ideProductor;
    private String ideDestino;
    private String ideDepOrigen;

    public CtrProdDocIntE(EntityManagerFactory emf) {
        super(emf);
    }
    
    
    public String getIdeProductor() {
        return ideProductor;
    }

    public void setIdeProductor(String ideProductor) {
        this.ideProductor = ideProductor;
    }

    public String getIdeDestino() {
        return ideDestino;
    }

    public void setIdeDestino(String ideDestino) {
        this.ideDestino = ideDestino;
    }

    public String getIdeDepOrigen() {
        return ideDepOrigen;
    }

    public void setIdeDepOrigen(String ideDepOrigen) {
        this.ideDepOrigen = ideDepOrigen;
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
    
     private Funcionario InicializarFuncionarioProd() {
        FuncionarioService ds= new FuncionarioService(emf);
        Funcionario dp=ds.findFuncionario(this.ideProductor);
        return dp;
    }

    private Dependencia InicializarDepOrigen() {
        DependenciaService ds= new DependenciaService(emf);
        Dependencia dp=ds.findDependencia(this.ideDepOrigen);
        return dp;
    }

    private PerExterna InicializarPerExtDestino() {
        PerExternaService ps= new PerExternaService(emf);
        PerExterna perExtDes=ps.findPerExterna(this.ideDestino);
        return perExtDes;
    }



    
}
