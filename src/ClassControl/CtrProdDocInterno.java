/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassControl;

import ClassEntidad.Dependencia;
import ClassEntidad.DocInternoE;
import ClassEntidad.Funcionario;
import ClassEntidad.PerExterna;
import Servicios.DependenciaService;
import Servicios.FuncionarioService;
import Servicios.PerExternaService;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author borsigr04
 */
public abstract class CtrProdDocInterno extends CtrProdDoc {

    private String ideProductor;
    private String ideDestino;
    private String ideDepOrigen;

    public CtrProdDocInterno(EntityManagerFactory emf) {
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
    public abstract String Guardar(); 
        
     protected Funcionario InicializarFuncionarioProd() {
        FuncionarioService ds= new FuncionarioService(emf);
        Funcionario dp=ds.findFuncionario(this.ideProductor);
        return dp;
    }

    protected Dependencia InicializarDepOrigen() {
        DependenciaService ds= new DependenciaService(emf);
        Dependencia dp=ds.findDependencia(this.ideDepOrigen);
        return dp;
    }

    

   
    
}
