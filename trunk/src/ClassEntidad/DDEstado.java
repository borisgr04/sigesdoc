/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ClassEntidad;

/**
 *
 * @author borisgr04
 */

public enum DDEstado{
   SIN_RECIBIR("SIN_RECIBIR"), REENVIADO("REENVIADO"),RESPONDIDO("RESPONDIDO"),ARCHIVADO("ARCHIVADO"),TRASLADADO("TRASLADADO") ;
   private String estado;

    DDEstado(String estado){
      this.estado = estado;
   }

   public String getEstado(){
      return this.estado;
   }
}