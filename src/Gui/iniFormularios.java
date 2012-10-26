/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Gui;

import ClassEntidad.Funcionario;
import javax.swing.JLabel;

/**
 *
 * @author borisgr04
 */
public class iniFormularios {
 public static void mostrarUsuarioActual(JLabel UsuarioActual){
        Funcionario f= new Funcionario();
        String usu=f.getUsActual();
        if(!usu.isEmpty())
        {
            UsuarioActual.setText(f.getUsuarioActual().getNombres());
        }
    }
}
