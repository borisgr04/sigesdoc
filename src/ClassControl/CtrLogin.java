<<<<<<< .mine
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ClassControl;

import ClassEntidad.Funcionario;
import ClassEntidad.Persona;
import ClassEntidad.Sistema;

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
    public boolean validar(String usuario, String clave)    {
        Funcionario f=new Funcionario();
        for(Persona fun: f.getFuncionario()){
           Funcionario fp=(Funcionario)fun;
            if(fp.getUsuario().equals(usuario)&&fp.getClave().equals(clave)){
                msg="OK";
                Sistema.instancia().setUsuAct(fp);
                Sistema.instancia().setUsuActual(usuario);
                Sistema.UsuActual=usuario;
                return true;
            }
        }
        msg="Credenciales no Válidos";
        return false;
    }
}
=======
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ClassControl;

/**
 *
 * @author LENOVO
 */
public class CtrLogin {

}
>>>>>>> .r33
