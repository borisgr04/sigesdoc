/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package util;

/**
 *
 * @author borisgr04
 */
public class CparaCombo {

  private String nombreDeEjemplo;
  private String codigo;

  public CparaCombo(String codigo, String nombreDeEjemplo)
      {
        this.codigo=codigo;
        this.nombreDeEjemplo=nombreDeEjemplo;
      }
    public String getNombreDeEjemplo() {
        return nombreDeEjemplo;
    }

    public void setNombreDeEjemplo(String nombreDeEjemplo) {
        this.nombreDeEjemplo = nombreDeEjemplo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String toString()
    {
     return nombreDeEjemplo;
    }



}