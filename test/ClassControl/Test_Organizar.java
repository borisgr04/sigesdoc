/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassControl;

import ClassEntidad.ACTASEstado;
import ClassEntidad.ActaTraslado;
import ClassEntidad.DocInternoE;
import ClassEntidad.Funcionario;
import ClassEntidad.Sistema;
import Servicios.ActaTrasladoService;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;
import util.CparaCombo;

/**
 *
 * @author LENOVO
 */
public class Test_Organizar {

    public Test_Organizar() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        Sistema s = Sistema.instancia();
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    
    @Test
    public void TestValNroActa() {
      ActaTraslado d = new ActaTraslado();
      CtrOrgazina cd = new CtrOrgazina(Sistema.instancia().getEmf());
      d.setNroActa(-1);
      d.setEstante(1);
      d.setCaja(1);
      cd.Guardar(d);
      System.out.println(cd.getMensaje());
      assertEquals("Resultado","digite un numero de acta Valido",cd.getMensaje());  
     }
    
    @Test
    public void TestValActaExiste() {
      ActaTraslado d = new ActaTraslado();
      CtrOrgazina cd = new CtrOrgazina(Sistema.instancia().getEmf());
      d.setEstante(1);
      d.setCaja(1);
      d.setNroActa(5);
      cd.Guardar(d);
      System.out.println(cd.getMensaje());
      assertEquals("Resultado","El Acta no existe",cd.getMensaje());  
     }
    
    @Test
    public void TestValEstante() {
      ActaTraslado d = new ActaTraslado();
      CtrOrgazina cd = new CtrOrgazina(Sistema.instancia().getEmf());
      d.setNroActa(2056);
      d.setEstante(-1);
      d.setCaja(1);
      
      cd.Guardar(d);
      System.out.println(cd.getMensaje());
      assertEquals("Resultado","El número de Estante no es válido, digite un número mayor que Cero (0)",cd.getMensaje());  
     }
    
    @Test
     public void TestValCaja() {
      ActaTraslado d = new ActaTraslado();
      CtrOrgazina cd = new CtrOrgazina(Sistema.instancia().getEmf());
      d.setEstante(1);
      d.setCaja(0);
      d.setNroActa(2056);
      cd.Guardar(d);
      System.out.println(cd.getMensaje());
      assertEquals("Resultado","El número de Caja no es válido, digite un número mayor que Cero (0)",cd.getMensaje());  
     }
    
     @Test
     public void Testunidad() {
      ActaTraslado d = new ActaTraslado();
      CtrOrgazina cd = new CtrOrgazina(Sistema.instancia().getEmf());
      d.setEstante(1);
      d.setCaja(1);
      d.setNroActa(2056);
      d.setUnidadConsulta("");
      cd.Guardar(d);
      System.out.println(cd.getMensaje());
      assertEquals("Resultado","Escoja una unidad Valida",cd.getMensaje());  
     }
     
     @Test
     public void Testestado() {
      ActaTraslado d = new ActaTraslado();
      CtrOrgazina cd = new CtrOrgazina(Sistema.instancia().getEmf());
      d.setEstante(1);
      d.setCaja(1);
      d.setNroActa(2056);
      d.setUnidadConsulta("Tomo");
      d.setEstado(ACTASEstado.ORGANIZADA);
      cd.Guardar(d);
      System.out.println(cd.getMensaje());
      assertEquals("Resultado","Los Documentos ya han Sido almacenados en el Archivo Central",cd.getMensaje());  
     }
     
//     @Test
//     public void Testok() {
//      ActaTraslado d = new ActaTraslado();
//      CtrOrgazina cd = new CtrOrgazina(Sistema.instancia().getEmf());
//      d.setEstante(1);
//      d.setCaja(1);
//      d.setNroActa(2056);
//      d.setUnidadConsulta("Tomo");
//      d.setEstado(ACTASEstado.TRASLADADA);
//      System.out.println(cd.getMensaje());
//      assertEquals("Resultado","OK",cd.Guardar(d));  
//     }
     
     
     
}