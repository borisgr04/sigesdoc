package ClassControl;
// #[regen=yes,id=DCE.F434F2A5-F885-D16A-A55E-0295FF38F45E]
// </editor-fold> 

import ClassEntidad.DDEstado;
import ClassEntidad.DistribucionDoc;
import Servicios.DistribucionDocService;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;

public class CtrTramite extends CtrBase {
    DistribucionDoc dd;

    public DistribucionDoc getDd() {
        return dd;
    }

    public void setDd(DistribucionDoc dd) {
        this.dd = dd;
    }

    public CtrTramite(EntityManagerFactory emf) {
        super(emf);
    }

    public String Archivar() {
         dd.setEstado(DDEstado.ARCHIVADO);
         dd.getDocumento().setEstado(DDEstado.ARCHIVADO);
         DistribucionDocService dds=new DistribucionDocService(this.emf);
        try {
            dds.edit(dd);
        } catch (Exception ex) {
            Logger.getLogger(CtrTramite.class.getName()).log(Level.SEVERE, null, ex);
            return ex.getMessage();
        }
         return "Se Archivo el Documento";
    }
}

