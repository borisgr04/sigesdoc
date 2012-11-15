/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassControl;


import ClassEntidad.ActaTraslado;
import ClassEntidad.Documento;
import ClassEntidad.Sistema;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author LENOVO
 */
public class Test_Traslado {

    public Test_Traslado() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        Sistema s = Sistema.instancia();


    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Test
    public void TestActaTrasladoSinFecha() {
        ActaTraslado at = new ActaTraslado();
        CtrTraslado cd = new CtrTraslado(Sistema.instancia().getEmf());
       List<Documento> ld= new ArrayList<Documento>(); 
       //at.setFecActa(this.fechaJC.getCalendar().getTime());
       at.setDocActas(ld);
       cd.setDep("03");
       cd.Guardar(at);
           
        System.out.println(cd.getMensaje());
        assertEquals("Resultado", "La fecha del Acta no puede estar vacia", cd.getMensaje());
    }

    
@Test
    public void TestActaTrasladoSinDocs() {
        ActaTraslado at = new ActaTraslado();
        CtrTraslado cd = new CtrTraslado(Sistema.instancia().getEmf());
       List<Documento> ld= new ArrayList<Documento>(); 
       at.setFecActa(new Date());
       //at.setDocActas(ld);
       cd.setDep("03");
       cd.Guardar(at);
           
        System.out.println(cd.getMensaje());
        assertEquals("Resultado", "Debe especificar al menos un documento en el Acta", cd.getMensaje());
    }
       
          @Test
    public void TestActaTrasladoSinDep() {
        ActaTraslado at = new ActaTraslado();
        CtrTraslado cd = new CtrTraslado(Sistema.instancia().getEmf());
       List<Documento> ld= new ArrayList<Documento>(); 
       at.setFecActa(new Date());
       at.setDocActas(ld);
       //cd.setDep("03");
       cd.Guardar(at);
           
        System.out.println(cd.getMensaje());
        assertEquals("Resultado", "Debe especificar una dependencia", cd.getMensaje());
    }
   
}