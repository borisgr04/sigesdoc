/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassControl;

import ClassEntidad.DocExterno;
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
public class Test_RecepcionarDoc {

    public Test_RecepcionarDoc() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        Sistema s = Sistema.instancia();


    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Test
    public void TestDocSinIdeProd() {
        DocExterno d = new DocExterno();
        Funcionario f = new Funcionario();
        CtrRecepcion cd = new CtrRecepcion(Sistema.instancia().getEmf());
        d.setAsunto("");
        d.setResumen("");
        d.setAnexos(false);
        d.setFolios(1);
        d.setDocOriginador(null);
        cd.setIdSerie(1);
        //cd.setIdeProductor("49722106");//Sin Ide Productor
        cd.setIdeDestino("7573361");
        cd.setDoc(d);
        d.setFolios(1);
        cd.setDoc(d);
        cd.Guardar();
        System.out.println(cd.getMensaje());
        assertEquals("Resultado", "Debe especificar un Remitente", cd.getMensaje());
    }

    @Test
    public void TestDocProdNoExiste() {
        DocExterno d = new DocExterno();
        Funcionario f = new Funcionario();
        CtrRecepcion cd = new CtrRecepcion(Sistema.instancia().getEmf());

        d.setAsunto("");
        d.setResumen("");
        d.setAnexos(false);
        cd.setIdeOrigen("99");
        d.setFolios(1);
        d.setDocOriginador(null);
        cd.setIdSerie(1);
        cd.setIdeDestino("7573361");
        cd.setDoc(d);

        d.setFolios(1);
        cd.setDoc(d);
        cd.Guardar();
        System.out.println(cd.getMensaje());
        assertEquals("Resultado", "El Remitente especificado No Existe", cd.getMensaje());
    }

    @Test
    public void TestSinSerie() {
        DocExterno d = new DocExterno();
        Funcionario f = new Funcionario();
        CtrRecepcion cd = new CtrRecepcion(Sistema.instancia().getEmf());

        d.setAsunto("");
        d.setResumen("");
        d.setAnexos(false);
        d.setFolios(1);
        d.setDocOriginador(null);
        cd.setIdeOrigen("77009398");
        //cd.setIdSerie();
        cd.setIdeDestino("7573361");
        cd.setDoc(d);

        d.setFolios(1);
        cd.setDoc(d);
        cd.Guardar();
        System.out.println(cd.getMensaje());
        assertEquals("Resultado", "Debe Especificar Serie Documental", cd.getMensaje());
    }

    @Test
    public void TestSerieNoExiste() {
        DocExterno d = new DocExterno();
        Funcionario f = new Funcionario();
        CtrRecepcion cd = new CtrRecepcion(Sistema.instancia().getEmf());

        d.setAsunto("");
        d.setResumen("");
        d.setAnexos(false);
        d.setFolios(1);
        d.setDocOriginador(null);
        cd.setIdeOrigen("77009398");
        //cd.setIdSerie();
        cd.setIdeDestino("7573361");
        cd.setDoc(d);

        d.setFolios(1);
        cd.setDoc(d);
        cd.Guardar();
        System.out.println(cd.getMensaje());
        assertEquals("Resultado", "Debe Especificar Serie Documental", cd.getMensaje());
    }

    @Test
    public void TestSinDestino() {
        DocExterno d = new DocExterno();
        Funcionario f = new Funcionario();
        CtrRecepcion cd = new CtrRecepcion(Sistema.instancia().getEmf());

        d.setAsunto("");
        d.setResumen("");
        d.setAnexos(false);
        d.setFolios(1);
        d.setDocOriginador(null);
        cd.setIdeOrigen("77009398");
        //cd.setIdSerie();
        cd.setIdeDestino("7573361");
        cd.setDoc(d);

        d.setFolios(1);
        cd.setDoc(d);
        cd.Guardar();
        System.out.println(cd.getMensaje());
        assertEquals("Resultado", "Debe Especificar Serie Documental", cd.getMensaje());
    }

    @Test
    public void TestDestinoNoExiste() {
        DocExterno d = new DocExterno();
        Funcionario f = new Funcionario();
        CtrRecepcion cd = new CtrRecepcion(Sistema.instancia().getEmf());

        d.setAsunto("");
        d.setResumen("");
        d.setAnexos(false);
        d.setFolios(1);
        d.setDocOriginador(null);
        cd.setIdeOrigen("77009398");
        cd.setIdSerie(1);
        cd.setIdeDestino("7573362");
        cd.setDoc(d);

        d.setFolios(1);
        cd.setDoc(d);
        cd.Guardar();
        System.out.println(cd.getMensaje());
        assertEquals("Resultado", "El Destino especificado no es válido", cd.getMensaje());
    }

    @Test
    public void TestSinAsunto() {
        DocExterno d = new DocExterno();
        Funcionario f = new Funcionario();
        CtrRecepcion cd = new CtrRecepcion(Sistema.instancia().getEmf());

        d.setAsunto("");
        d.setResumen("");
        d.setAnexos(false);
        d.setFolios(1);
        d.setDocOriginador(null);
        cd.setIdeOrigen("77009398");
        cd.setIdSerie(1);
        cd.setIdeDestino("7573361");
        cd.setDoc(d);

        d.setFolios(1);
        cd.setDoc(d);
        cd.Guardar();
        System.out.println(cd.getMensaje());
        assertEquals("Resultado", "Falta Asunto", cd.getMensaje());
    }

    @Test
    public void TestSinResumen() {
        DocExterno d = new DocExterno();
        Funcionario f = new Funcionario();
        CtrRecepcion cd = new CtrRecepcion(Sistema.instancia().getEmf());

        d.setAsunto("qqq");
        d.setResumen("");
        d.setAnexos(false);
        d.setFolios(1);
        d.setDocOriginador(null);
        cd.setIdeOrigen("77009398");
        cd.setIdSerie(1);
        cd.setIdeDestino("7573361");
        cd.setDoc(d);

        d.setFolios(1);
        cd.setDoc(d);
        cd.Guardar();
        System.out.println(cd.getMensaje());

        assertEquals("Resultado", "Falta diligenciar Resumen", cd.getMensaje());
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