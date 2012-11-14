/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ClassEntidad;

/**
 *
 * @author borisgr04
 */

public enum ACTASEstado{
   TRASLADADA("TRASLADADA"), ORGANIZADA("ORGANIZADA");
   private String estado;

    ACTASEstado(String estado){
      this.estado = estado;
   }

   public String getEstado(){
      return this.estado;
   }
}

