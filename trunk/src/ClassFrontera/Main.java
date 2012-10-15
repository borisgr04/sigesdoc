/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ClassFrontera;

import ClassEntidad.Sistema;
import ClassEntidad.DocExterno;
import ClassEntidad.DocInterno;
import ClassEntidad.DocInternoI;
import ClassEntidad.Documento;
import ClassEntidad.TRD;


/**
 *
 * @author borisgr04
 */
public class Main {

    public static void main(String[] args){
        //Producir Documento
        DocInternoI d= new DocInternoI();

        d.setAsunto("Prueba");
        d.setNoFolio(true);
        d.setResumen("PRueba Interno 1");
        d.setTipoDocumento("I");
        d.setEstado(1);
        d.setSerieTRD("01");
        d.setIdeFunProd("7573361");
        d.setIdeFunDestino("49722106");
        TRD t = TRD.buscarSerie("01");
        if(t!=null){
            int ncons=t.getNoCons()+1;
            d.setNoDocumento(ncons);
            System.out.println(d.crear());
        //d.setDestino(null)
        }
        for(Documento e:Sistema.instancia().getLstDoc()){
            System.out.println(e.getNoDocumento());
            System.out.println(e.getAsunto());
            System.out.println(e.getResumen());
            System.out.println("----------------");
        }


    }
}
