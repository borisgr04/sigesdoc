package ClassControl;
// #[regen=yes,id=DCE.F434F2A5-F885-D16A-A55E-0295FF38F45E]
// </editor-fold> 

import ClassEntidad.DDEstado;
import ClassEntidad.DistribucionDoc;

public class CtrTramite {
    DistribucionDoc dd;

    public DistribucionDoc getDd() {
        return dd;
    }

    public void setDd(DistribucionDoc dd) {
        this.dd = dd;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.72E5AA6F-6B4D-FEFD-0058-ABCA57678E30]
    // </editor-fold> 
    public CtrTramite () {
    }

    public String Archivar(){
         dd.setEstado(DDEstado.ARCHIVADO);
         dd.getDocumento().setEstado(DDEstado.ARCHIVADO);
         return "Se Archivo el Documento";
    }
}

