/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ClassControl;

/**
 *
 * @author borisgr04
 */
public class CtrProdDocIntI extends CtrProdDoc {

    @Override
    public String Guardar() {
     return  super.Guardar(new ValDocInternoI());
    }



    
}
