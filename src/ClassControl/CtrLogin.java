/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassControl;

import ClassEntidad.Funcionario;
import ClassEntidad.Persona;
import ClassEntidad.Sistema;
import Servicios.FuncionarioService;

/**
 *
 * @author borisgr04
 */
public class CtrLogin {

    String msg;
    Funcionario usuarioActual;

    public Funcionario getUsuarioActual() {
        return usuarioActual;
    }

    public void setUsuarioActual(Funcionario usuarioActual) {
        this.usuarioActual = usuarioActual;
    }

    public String getMsg() {
        return msg;
    }

    public boolean validar(String usuario, String clave) {

        Funcionario f = new Funcionario();
        FuncionarioService fs = new FuncionarioService(Sistema.instancia().getEmf());
        f = fs.findFuncionario(usuario);
        if (!(f == null)) {
            if (f.getClave().equals(clave)) {
                msg = "OK";
                Sistema.instancia().setUsuAct(f);
                return true;
            } else {
                msg = "Credenciales no Válidos";
                return false;
            }
        } else {
            msg = "Usuario No existe en la base de datos";
            return false;
        }
    }
}
