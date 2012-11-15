/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassControl;

import ClassEntidad.DocInternoI;
import ClassEntidad.Funcionario;
import Servicios.FuncionarioService;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author borisgr04
 */
public class CtrProdDocIntI extends CtrProdDocInterno {
    
    
    @Override
    public DocInternoI getDoc(){
        return (DocInternoI) this.doc;
    }
    
    public CtrProdDocIntI(EntityManagerFactory emf) {
        super(emf);
    }

    @Override
     public void inicializarObjetos(){
        super.inicializarObjetos();
        //Local
        InicializarFuncionarioDest();
        
    }
    
    protected void InicializarFuncionarioDest() {
        if(this.getIdeDestino()!=null){
        FuncionarioService ds = new FuncionarioService(emf);
        Funcionario dp = ds.findFuncionario(this.getIdeDestino());
        this.getDoc().setmDestino(dp);
        }
    }


    
    

            
}
