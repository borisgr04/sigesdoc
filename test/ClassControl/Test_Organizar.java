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
      
      d.setEstante(1);
      d.setCaja(1);
      d.setNroActa(5);
      cd.Guardar(d);
      System.out.println(cd.isValidoActa());
      assertEquals("Resultado","El Acta no existe",cd.Guardar(d));  
     }
    
    @Test
    public void TestValEstante() {
      ActaTraslado d = new ActaTraslado();
      CtrOrgazina cd = new CtrOrgazina(Sistema.instancia().getEmf());
      d.setEstante(-1);
      d.setCaja(1);
      d.setNroActa(1701);
      cd.Guardar(d);
      //System.out.println(cd.getMensaje());
      assertEquals("Resultado","El número de Estante no es válido, digite un número mayor que Cero (0)",cd.Guardar(d));  
     }
    
     public void TestValCaja() {
      ActaTraslado d = new ActaTraslado();
      CtrOrgazina cd = new CtrOrgazina(Sistema.instancia().getEmf());
      d.setEstante(1);
      d.setCaja(0);
      d.setNroActa(1701);
      System.out.println(cd.getMensaje());
      assertEquals("Resultado","El número de Caja no es válido, digite un número mayor que Cero (0)",cd.Guardar(d));  
     }
     
     public void Testunidad() {
      ActaTraslado d = new ActaTraslado();
      CtrOrgazina cd = new CtrOrgazina(Sistema.instancia().getEmf());
      d.setEstante(1);
      d.setCaja(1);
      d.setNroActa(1701);
      d.setUnidadConsulta("");
      System.out.println(cd.getMensaje());
      assertEquals("Resultado","Escoja una unidad Valida",cd.Guardar(d));  
     }
     
     public void Testestado() {
      ActaTraslado d = new ActaTraslado();
      CtrOrgazina cd = new CtrOrgazina(Sistema.instancia().getEmf());
      d.setEstante(1);
      d.setCaja(1);
      d.setNroActa(1701);
      d.setUnidadConsulta("");
      d.setEstado(ACTASEstado.ORGANIZADA);
      System.out.println(cd.getMensaje());
      assertEquals("Resultado","Los Archivos ya han Sido almacenados en el Archivo central y estan Organizados en un Estanta",cd.Guardar(d));  
     }
     
     public void Testok() {
      ActaTraslado d = new ActaTraslado();
      CtrOrgazina cd = new CtrOrgazina(Sistema.instancia().getEmf());
      d.setEstante(1);
      d.setCaja(1);
      d.setNroActa(1701);
      d.setUnidadConsulta("");
      d.setEstado(ACTASEstado.TRASLADADA);
      System.out.println(cd.getMensaje());
      assertEquals("Resultado","OK",cd.Guardar(d));  
     }
     
     
     
}