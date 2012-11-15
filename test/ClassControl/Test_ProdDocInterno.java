/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassControl;

import ClassEntidad.DocInternoE;
import ClassEntidad.Funcionario;
import ClassEntidad.Sistema;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;
import util.CparaCombo;

/**
 *
 * @author LENOVO
 */
public class Test_ProdDocInterno {

    public Test_ProdDocInterno() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        Sistema s = Sistema.instancia();
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    
     @Test
    public void TestDocSinDepOrigen() {
        DocInternoE d = new DocInternoE();
        Funcionario f = new Funcionario();
        CtrProdDocIntE cd = new CtrProdDocIntE(Sistema.instancia().getEmf());
        
        d.setAsunto("");
        d.setResumen("");
        d.setAnexos(false);
        d.setFolios(1);
        d.setDocOriginador(null);
        cd.setIdSerie(1);
        cd.setIdeProductor("49722106");//Enviar Usuario Actual
        cd.setIdeDestino("7573361");
        cd.setDoc(d);

        d.setFolios(1);
        cd.setDoc(d);
        cd.Guardar();
        System.out.println(cd.getMensaje());
        assertEquals("Resultado","Debe especificar Dependencia Origen",cd.getMensaje());
        
     }
     @Test
     public void TestDocDepOrigenNoExiste() {
        DocInternoE d = new DocInternoE();
        Funcionario f = new Funcionario();
        CtrProdDocIntE cd = new CtrProdDocIntE(Sistema.instancia().getEmf());
        
        d.setAsunto("");
        d.setResumen("");
        d.setAnexos(false);
        d.setFolios(1);
        d.setDocOriginador(null);
        cd.setIdeDepOrigen("10");
        cd.setIdSerie(1);
        cd.setIdeProductor("49722106");//Enviar Usuario Actual
        cd.setIdeDestino("7573361");
        cd.setDoc(d);

        d.setFolios(1);
        cd.setDoc(d);
        cd.Guardar();
        System.out.println(cd.getMensaje());
        assertEquals("Resultado","La Dependencia Especificada No Existe",cd.getMensaje());
    }

     @Test
     public void TestDocSinIdeProd() {
        DocInternoE d = new DocInternoE();
        Funcionario f = new Funcionario();
        CtrProdDocIntE cd = new CtrProdDocIntE(Sistema.instancia().getEmf());
        
        d.setAsunto("");
        d.setResumen("");
        d.setAnexos(false);
        d.setFolios(1);
        d.setDocOriginador(null);
        cd.setIdeDepOrigen("10");
        cd.setIdSerie(1);
        cd.setIdeDepOrigen("03");
        //cd.setIdeProductor("49722106");//Sin Ide Productor
        cd.setIdeDestino("7573361");
        cd.setDoc(d);

        d.setFolios(1);
        cd.setDoc(d);
        cd.Guardar();
        System.out.println(cd.getMensaje());
        assertEquals("Resultado","Debe especificar un productor",cd.getMensaje());
    }

  @Test
     public void TestDocProdNoExiste() {
        DocInternoE d = new DocInternoE();
        Funcionario f = new Funcionario();
        CtrProdDocIntE cd = new CtrProdDocIntE(Sistema.instancia().getEmf());
        
        d.setAsunto("");
        d.setResumen("");
        d.setAnexos(false);
        d.setFolios(1);
        d.setDocOriginador(null);
        cd.setIdeDepOrigen("10");
        cd.setIdSerie(1);
        cd.setIdeDepOrigen("03");
        cd.setIdeProductor("1234");//Sin Ide Productor
        cd.setIdeDestino("7573361");
        cd.setDoc(d);

        d.setFolios(1);
        cd.setDoc(d);
        cd.Guardar();
        System.out.println(cd.getMensaje());
        assertEquals("Resultado","El Productor especificado No Existe",cd.getMensaje());
    }

  
   @Test
     public void TestSinSerie() {
        DocInternoE d = new DocInternoE();
        Funcionario f = new Funcionario();
        CtrProdDocIntE cd = new CtrProdDocIntE(Sistema.instancia().getEmf());
        
        d.setAsunto("");
        d.setResumen("");
        d.setAnexos(false);
        d.setFolios(1);
        d.setDocOriginador(null);
        cd.setIdeDepOrigen("10");
        //cd.setIdSerie();
        cd.setIdeDepOrigen("03");
        cd.setIdeProductor("49722106");//Sin Ide Productor
        cd.setIdeDestino("7573361");
        cd.setDoc(d);

        d.setFolios(1);
        cd.setDoc(d);
        cd.Guardar();
        System.out.println(cd.getMensaje());
        assertEquals("Resultado","Debe Especificar Serie Documental",cd.getMensaje());
    }

    @Test
     public void TestSerieNoExiste() {
        DocInternoE d = new DocInternoE();
        Funcionario f = new Funcionario();
        CtrProdDocIntE cd = new CtrProdDocIntE(Sistema.instancia().getEmf());
        
        d.setAsunto("");
        d.setResumen("");
        d.setAnexos(false);
        d.setFolios(1);
        d.setDocOriginador(null);
        cd.setIdeDepOrigen("10");
        cd.setIdSerie(99);
        cd.setIdeDepOrigen("03");
        cd.setIdeProductor("49722106");//Sin Ide Productor
        cd.setIdeDestino("7573361");
        cd.setDoc(d);

        d.setFolios(1);
        cd.setDoc(d);
        cd.Guardar();
        System.out.println(cd.getMensaje());
        assertEquals("Resultado","La Serie Documental Especificada No existe",cd.getMensaje());
    }


        @Test
     public void TestSinDestino() {
        DocInternoE d = new DocInternoE();
        Funcionario f = new Funcionario();
        CtrProdDocIntE cd = new CtrProdDocIntE(Sistema.instancia().getEmf());
        
        d.setAsunto("");
        d.setResumen("");
        d.setAnexos(false);
        d.setFolios(1);
        d.setDocOriginador(null);
        cd.setIdeDepOrigen("10");
        cd.setIdSerie(1);
        cd.setIdeDepOrigen("03");
        cd.setIdeProductor("49722106");//Sin Ide Productor
        //cd.setIdeDestino("7573361");
        cd.setDoc(d);

        d.setFolios(1);
        cd.setDoc(d);
        cd.Guardar();
        System.out.println(cd.getMensaje());
        assertEquals("Resultado","Debe especificar un destino",cd.getMensaje());
    }

     @Test
     public void TestDestinoNoExiste() {
        DocInternoE d = new DocInternoE();
        Funcionario f = new Funcionario();
        CtrProdDocIntE cd = new CtrProdDocIntE(Sistema.instancia().getEmf());
        
        d.setAsunto("");
        d.setResumen("");
        d.setAnexos(false);
        d.setFolios(1);
        d.setDocOriginador(null);
        cd.setIdeDepOrigen("10");
        cd.setIdSerie(1);
        cd.setIdeDepOrigen("03");
        cd.setIdeProductor("49722106");
        cd.setIdeDestino("7573362");//Destino NO Existe
        cd.setDoc(d);

        d.setFolios(1);
        cd.setDoc(d);
        cd.Guardar();
        System.out.println(cd.getMensaje());
        assertEquals("Resultado","El Destino No Existe",cd.getMensaje());
    }
@Test
     public void TestSinAsunto() {
        DocInternoE d = new DocInternoE();
        Funcionario f = new Funcionario();
        CtrProdDocIntE cd = new CtrProdDocIntE(Sistema.instancia().getEmf());
        
        d.setAsunto("");
        d.setResumen("");
        d.setAnexos(false);
        d.setFolios(1);
        d.setDocOriginador(null);
        cd.setIdeDepOrigen("10");
        cd.setIdSerie(1);
        cd.setIdeDepOrigen("03");
        cd.setIdeProductor("49722106");
        cd.setIdeDestino("7573361");//Destino NO Existe
        cd.setDoc(d);

        d.setFolios(1);
        cd.setDoc(d);
        cd.Guardar();
        System.out.println(cd.getMensaje());
        assertEquals("Resultado","El Destino No Existe",cd.getMensaje());
    }


@Test
     public void TestSinResumen() {
        DocInternoE d = new DocInternoE();
        Funcionario f = new Funcionario();
        CtrProdDocIntE cd = new CtrProdDocIntE(Sistema.instancia().getEmf());
        
        d.setAsunto("xxxx");
        d.setResumen("");
        d.setAnexos(false);
        d.setFolios(1);
        d.setDocOriginador(null);
        cd.setIdeDepOrigen("10");
        cd.setIdSerie(1);
        cd.setIdeDepOrigen("03");
        cd.setIdeProductor("49722106");
        cd.setIdeDestino("7573361");//Destino NO Existe
        cd.setDoc(d);

        d.setFolios(1);
        cd.setDoc(d);
        cd.Guardar();
        System.out.println(cd.getMensaje());
        assertEquals("Resultado","El Destino No Existe",cd.getMensaje());
    }
     /*
     @Test
    public void TestDocOk() {
        DocInternoE d = new DocInternoE();
        Funcionario f = new Funcionario();
        CtrProdDocIntE cd = new CtrProdDocIntE(Sistema.instancia().getEmf());
        d.setAsunto("yyy");
        d.setResumen("RRRRR");
        d.setAnexos(false);
        d.setFolios(1);
        d.setDocOriginador(null);
        cd.setIdSerie(1);
        cd.setIdeDepOrigen("03");
        cd.setIdeProductor("49722106");//Enviar Usuario Actual
        cd.setIdeDestino("7573361");
        cd.setDoc(d);
        d.setAnexos(true);
        d.setFolios(1);
        cd.setDoc(d);
        cd.Guardar();
        System.out.println("OK"+cd.getMensaje());
        assertEquals("Resultado",true,cd.isValido());
    }
*/
     
}