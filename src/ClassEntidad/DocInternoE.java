/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassEntidad;

/**
 *
 * @author borisgr04
 */
public class DocInternoE extends DocInterno {

    public DocInternoE() {

        this.setTipoDocumento("E");
    }

    private String nomDestino;
    private String direccion;

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNomDestino() {
        return nomDestino;
    }

    public void setNomDestino(String nomDestino) {
        this.nomDestino = nomDestino;
    }
}
