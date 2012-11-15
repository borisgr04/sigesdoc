/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassControl;

import ClassEntidad.Dependencia;
import ClassEntidad.Funcionario;
import ClassEntidad.PerExterna;
import ClassEntidad.Sistema;
import Servicios.DependenciaService;
import Servicios.FuncionarioService;
import Servicios.PerExternaService;
import Servicios.exceptions.PreexistingEntityException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author borsigr04
 */
public class CtrFuncionario extends CtrBase {

    Funcionario pe;
    
    private String DepFun;

    public String getDepFun() {
        return DepFun;
    }

    public void setDepFun(String DepFun) {
        this.DepFun = DepFun;
    }

    public Funcionario getPe() {
        return pe;
    }

    public void setPe(Funcionario pe) {
        this.pe = pe;
    }
    public CtrFuncionario(EntityManagerFactory emf) {
        super(emf);
    }
    String Validar(){
        if(pe.getApellidos()==null || pe.getApellidos().isEmpty())
        {
        return "El apellido es obligatorio";
        }
        if(pe.getNombres()==null || pe.getNombres().isEmpty())
        {
        return "El apellido es obligatorio";
        }    
        if(pe.getDireccion()==null || pe.getDireccion().isEmpty())
        {
        return "El apellido es obligatorio";
        }
        if(pe.getEmail()==null || pe.getEmail().isEmpty())
        {
        return "El apellido es obligatorio";
        }    
        
       return "OK";
    }
    public void Guardar(){
        try {
            FuncionarioService pes=new FuncionarioService(Sistema.instancia().getEmf());
            this.setValido(false);
            this.setMensaje(Validar());
            if(this.getMensaje().equals("OK")){
                pes.create(pe);
                this.setValido(true);
            }
        } catch (PreexistingEntityException ex) {
            this.setMensaje(ex.getMessage());
            this.setValido(false);
        } catch (Exception ex) {
            this.setMensaje(ex.getMessage());
            this.setValido(false);
        }
    
    }
    
     protected void InicializarDepOrigen() {
        if(this.getDepFun()!=null){
        DependenciaService ds = new DependenciaService(emf);
        Dependencia dp = ds.findDependencia(this.getDepFun());
        this.pe.setDependencia(dp);
        }
        
     }
}
