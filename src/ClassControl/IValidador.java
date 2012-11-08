/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ClassControl;

import ClassEntidad.DistribucionDoc;
import ClassEntidad.Documento;

/**
 *
 * @author borisgr04
 */
public interface IValidador {
    String Validar (Documento hg);
    DistribucionDoc DistribuirDoc (Documento hg);
}
