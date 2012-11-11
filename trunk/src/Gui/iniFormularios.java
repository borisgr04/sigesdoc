/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Gui;

import ClassEntidad.Funcionario;
import ClassEntidad.Sistema;
import javax.swing.JLabel;

/**
 *
 * @author borisgr04
 */
public class iniFormularios {
 public static void mostrarUsuarioActual(JLabel UsuarioActual){
      
        Funcionario f=Sistema.instancia().getUsuAct();
        if(!(f==null))
        {
            UsuarioActual.setText(f.getNombres());
        }
    }
}
