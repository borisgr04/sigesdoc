/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ClassControl;

import ClassEntidad.Funcionario;
import ClassEntidad.Sistema;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author LENOVO
 */
public class Test_login {
    CtrLogin vl= new CtrLogin();
    public Test_login() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        


    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    
     @Test
     //Usuarios Correctos
     public void TestLoginOk() {
     Funcionario f = new Funcionario();
     f.setUsuario("49722106");
     f.setClave("1234");
     assertEquals(vl.validar(f.getUsuario(), f.getClave()),true);
     }

     @Test
     public void TestLoginUsuarioIncorrecto() {
     Funcionario f = new Funcionario();
     f.setUsuario("123569");
     f.setClave("12345");
     assertEquals(vl.validar(f.getUsuario(), f.getClave()),false);
     }


     @Test
     public void TestLoginClaveIncorrecto() {
     Funcionario f = new Funcionario();
     f.setUsuario("49722106");
     f.setClave("");
     assertEquals(vl.validar(f.getUsuario(), f.getClave()),false);
     }



     @Test
     public void TestLoginClaveUsuarioIncorrecto() {
     Funcionario f = new Funcionario();
     f.setUsuario("9722106");
     f.setClave("1");
     assertEquals(vl.validar(f.getUsuario(), f.getClave()),false);
     }




}