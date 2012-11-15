/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ClassControl;

import ClassEntidad.DocInternoE;
import ClassEntidad.PerExterna;
import Servicios.PerExternaService;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author borisgr04
 */
public class CtrProdDocIntE extends CtrProdDocInterno {

    //Constructor   
    public CtrProdDocIntE(EntityManagerFactory emf) {
        super(emf);
    }
   
    //Se Sobreescribe el Get de Documentos
    @Override
    public DocInternoE getDoc(){
        return (DocInternoE) this.doc;
    }
    
    //Se Sobre escribe Inicialalizar Objetos y Se agregan los adicionales
     @Override
     public void inicializarObjetos(){
        super.inicializarObjetos();
        InicializarPerExtDestino();
        
    }
   
     private void InicializarPerExtDestino() {
         
         if(this.getIdeDestino()!=null){
        PerExternaService ps= new PerExternaService(emf);
        PerExterna perExtDes=ps.findPerExterna(this.getIdeDestino());
        this.getDoc().setmDestino(perExtDes);
         }
        
    }


    
}
