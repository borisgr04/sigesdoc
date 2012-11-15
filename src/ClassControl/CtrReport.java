/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassControl;

import ClassEntidad.Documento;
import ClassEntidad.Sistema;
import Servicios.DocumentoService;
import java.util.List;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author borsigr04
 */
public class CtrReport extends CtrBase{

    public CtrReport(EntityManagerFactory emf) {
        super(emf);
    }
 
    
    public List<Documento> getDatos(){
        
        DocumentoService ds= new DocumentoService(this.emf);
        return ds.findDocumentoEntities();
    
    
    
    }
}
