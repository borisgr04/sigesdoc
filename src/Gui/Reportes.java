/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import ClassControl.CtrReport;
import ClassEntidad.DDEstado;
import ClassEntidad.Documento;
import ClassEntidad.Sistema;
import java.io.*;

/**
 *
 * @author borsigr04
 */
public class Reportes {

    public Reportes() {

        generarReporte();
    }
    private String ImprimirHead(){
        String fila="<tr>";
        fila+="<th>N DOC</th>";
        fila+="<th>ASUNTO</th>";
        fila+="<th>SERIE</th>";
        fila+="<tH>RTE AG</tH>";
        fila+="<tH>RTE AC</tH>";
        fila+="<tH>DISP FINAL</tH>";
        fila+="<th>ESTADO</th>";
        fila+="<th>ORIGEN</th>";
        fila+="<th>DESTINO</th>";
        fila+="<tH>N ACTA TRASLADO</tH>";
        fila+="<tH>CAJA</tH>";
        fila+="<tH>UNIDAD CONSL</tH>";
        fila+="<tH>FECHA ARCHIVO</tH>";
        
        fila+="</tr>";        
        return fila;
        
    }
    private String ImprimirFila(Documento d ){
        String fila="<tr>";
        fila+="<td>"+d.getNoDocumento()+"</td>";
        fila+="<td>"+d.getAsunto()+"</td>";
        fila+="<td>"+d.getSerie().getSerie()+"</td>";
        fila+="<td>"+d.getSerie().gettRetAG()+"</td>";
        fila+="<td>"+d.getSerie().gettRetenAC()+"</td>";
        fila+="<td>"+d.getSerie().getDispFinal()+"</td>";
        fila+="<td>"+d.getEstado()+"</td>";
        fila+="<td>"+d.getDe().getNombres()+"</td>";
        fila+="<td>"+d.getPara().getNombres()+"</td>";
        fila+="<td>"+d.getActaTraslado().getNroActa()+"</td>";
        fila+="<td>"+d.getActaTraslado().getCaja()+"</td>";
        fila+="<td>"+d.getActaTraslado().getUnidadConsulta()+"</td>";
        fila+="<td>"+d.getActaTraslado().getFecActaOrg()+"</td>";
        
        
        fila+="</tr>";        
        return fila;
    }
    public void generarReporte() {
        try {
            FileWriter archivo = new FileWriter("E:\\reporte.html");

            PrintWriter html = new PrintWriter(archivo);

            CtrReport cr = new CtrReport(Sistema.instancia().getEmf());

    //escribimos un archivo de texto con la estructura de html

            html.println("<html>");
            html.println(" <body>");
            html.println(" <h1><center>Listado de Documentos</center></h1>");
            html.println(" <h1><center>SISTEMA DE GESTION DOCUMENTAL</center></h1>");
            html.println("<table border=1>");
            html.println(this.ImprimirHead());
            for (Documento d: cr.getDatos()) {
               if(d.getEstado()==DDEstado.TRASLADADO){
                html.println(this.ImprimirFila(d));
               }
            }
            html.println("<table>");
            html.println(" </body>");
            html.println("</html>");

    //nos aseguramos de cerrar el archivo
            archivo.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
