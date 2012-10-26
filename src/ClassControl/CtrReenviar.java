/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ClassControl;

import ClassEntidad.DDEstado;
import ClassEntidad.DistribucionDoc;
import ClassEntidad.Funcionario;

/**
 *
 * @author borisgr04
 */
public class CtrReenviar {
        DistribucionDoc dd;
        String msg;
        boolean valido;

    public boolean isValido() {
        return valido;
    }

    public void setValido(boolean valido) {
        this.valido = valido;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
        

    public DistribucionDoc getDd() {
        return dd;
    }

    public void setDd(DistribucionDoc dd) {
        this.dd = dd;
    }
    public String reenviar(String para ){
        try {
            dd.setEstado(DDEstado.REENVIADO);
            DistribucionDoc dnuevo= new DistribucionDoc();
            Funcionario f= new Funcionario();
            dnuevo.setDistribuidor(f.getUsuarioActual());
            dnuevo.setIdPerDest(para);
            dnuevo.crear();
            msg="Se realizó el Reenvio de Documento";
            valido= true;
        }catch(Exception ex){
            msg= ex.getMessage();
            valido= false;
        }
            return msg;



        }

        
}
