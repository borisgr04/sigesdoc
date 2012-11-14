/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassControl;

import ClassEntidad.Dependencia;
import ClassEntidad.DocInterno;
import ClassEntidad.Funcionario;
import Servicios.DependenciaService;
import Servicios.FuncionarioService;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author borsigr04
 */
public abstract class CtrProdDocInterno extends CtrProdDoc {

    private String ideProductor;
    private String ideDestino;
    private String ideDepOrigen;

    public CtrProdDocInterno(EntityManagerFactory emf) {
        super(emf);
    }

    public String getIdeProductor() {
        return ideProductor;
    }

    public void setIdeProductor(String ideProductor) {
        this.ideProductor = ideProductor;
    }

    public String getIdeDestino() {
        return ideDestino;
    }

    public void setIdeDestino(String ideDestino) {
        this.ideDestino = ideDestino;
    }

    public String getIdeDepOrigen() {
        return ideDepOrigen;
    }

    public void setIdeDepOrigen(String ideDepOrigen) {
        this.ideDepOrigen = ideDepOrigen;
    }

    protected void InicializarFuncionarioProd() {
        FuncionarioService ds = new FuncionarioService(emf);
        Funcionario dp = ds.findFuncionario(this.ideProductor);
        this.getDoc().setmProductor(dp);
    }

    protected void InicializarDepOrigen() {
        DependenciaService ds = new DependenciaService(emf);
        Dependencia dp = ds.findDependencia(this.ideDepOrigen);
        this.getDoc().setDepOrigen(dp);
    }

    @Override
    public void inicializarObjetos() {
        super.inicializarObjetos();
        InicializarDepOrigen();
        InicializarFuncionarioProd();
    }

    @Override
    String ValidarDatos() {
        if (this.getIdeProductor().isEmpty()) {
            return "Debe especificar un productor";
        } else if (this.getDoc().getDe() == null) {
            return "Debe especificar productor";
        } else  if (this.getIdeDepOrigen().isEmpty()) {
            return "Debe especificar Dependencia Origen";
        } else if (getDoc().getDepOrigen() == null) {
            return "La Dependencia Especificada No Existe";
        } else if (this.getIdSerie() == 0) {
            return "Falta Serie Documental";
        } else if (this.getDoc().getSerie() == null) {
            return "La Serie Documental Especificada No existe en al base de datos";
        } else if (this.getIdeDestino().isEmpty()) {
            return "Debe especificar un destino";
        } else if (this.getDoc().getDe() == null) {
            return "Debe especificar un Destino";
        } else if (doc.getAsunto().isEmpty()) {
            return "Falta Asunto";
        } else if (getDoc().getResumen().isEmpty()) {
            return "Falta diligenciar Resumen";
        }
        return "OK";
    }

    @Override
    public DocInterno getDoc() {
        return (DocInterno) this.doc;
    }
}
