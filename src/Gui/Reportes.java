/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import java.io.*;

/**
 *
 * @author borsigr04
 */
public class Reportes {

    public Reportes() {

        generarReporte();
    }

    public void generarReporte() {
        try {
            FileWriter archivo = new FileWriter("E:\\reporte.html");

            PrintWriter escritura = new PrintWriter(archivo);


    //escribimos un archivo de texto con la estructura de html

            escritura.println("<html>");
            escritura.println(" <body>");
            escritura.println(" <h1><center>Listado de Clientes almacenados</center></h1>");
            escritura.println("<br><br>");
            for (int i = 0; i < 10; i++) {
                escritura.println("Nombre: " + (i + 1) + "<br>");
            }
            escritura.println(" </body>");
            escritura.println("</html>");

    //nos aseguramos de cerrar el archivo
            archivo.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
