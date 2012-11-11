/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ClassControl;

import ClassEntidad.Dependencia;
import ClassEntidad.DocInternoI;
import ClassEntidad.Funcionario;
import Servicios.FuncionarioService;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author borisgr04
 */
public class CtrProdDocIntI extends CtrProdDocInterno {

    public CtrProdDocIntI(EntityManagerFactory emf) {
        super(emf);
    }

    @Override
    public String Guardar() {
        Dependencia dp=InicializarDepOrigen();
        Funcionario funDes=InicializarFuncionarioDest();
        Funcionario funProd= InicializarFuncionarioProd();
        ((DocInternoI)this.doc).setDepOrigen(dp);
        ((DocInternoI)this.doc).setmDestino(funDes);
        ((DocInternoI)this.doc).setmProductor(funProd);
    
        return  super.Guardar(new ValDocInternoI());
   
    }

    protected Funcionario InicializarFuncionarioDest() {
        FuncionarioService ds= new FuncionarioService(emf);
        Funcionario dp=ds.findFuncionario(this.getIdeDestino());
        return dp;
    }

    
}
