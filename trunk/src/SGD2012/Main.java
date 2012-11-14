/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SGD2012;

import ClassControl.CtrProdDocIntI;
import ClassEntidad.Dependencia;
import ClassEntidad.DocInternoI;
import ClassEntidad.Funcionario;
import ClassEntidad.PerExterna;
import ClassEntidad.TRD;
import Gui.Reportes;
import Servicios.DependenciaService;
import Servicios.FuncionarioService;
import Servicios.PerExternaService;
import Servicios.TRDService;
import Servicios.exceptions.PreexistingEntityException;
import java.awt.Desktop;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author borisgr04
 */
public class Main {

    /*   public void consultar() {
     EntityManagerFactory emf;
     EntityManager em;
     Map<String, String> properties = new HashMap();
     properties.put("javax.persistence.jdbc.user", "root");
     properties.put("javax.persistence.jdbc.password", "root");
     emf = Persistence.createEntityManagerFactory("GRLUPU");
     em = emf.createEntityManager();
     ActorService actorService = new ActorService(emf);
     PersonService personService = new PersonService(emf);
     MovieService movieService = new MovieService(emf);
     ArtistService artistService = new ArtistService(emf);
     DirectorService directorService = new DirectorService(emf);
     SongService songService = new SongService(emf);
     SoundTrackService soundtrackService = new SoundTrackService(emf);

     try {
     System.out.println("INFORMATION ON THE DATABASE");
     System.out.println("\nPERSON:");
     System.out.println(personService.findPersonEntities());
     System.out.println("\nACTOR:");
     System.out.println(actorService.findActorEntities());
     System.out.println("\nDIRECCTORES:");
     System.out.println(directorService.findDirectorEntities());
     System.out.println("\nARTISTAS:");
     System.out.println(artistService.findArtistEntities());
     System.out.println("\nMOVIES:");
     System.out.println(movieService.findMovieEntities());
     System.out.println("\nSONG:");
     System.out.println(songService.findSongEntities());
     System.out.println("\nSOUNDTRACKS:");

     for (SoundTrack s : soundtrackService.findSoundTrackEntities()) {
     System.out.println(s.toString());
     }


     } catch (Exception ex) {
     }
     }
     */
    public void crear() {


        EntityManagerFactory emf;
        EntityManager em;
        Map<String, String> properties = new HashMap();
        emf = Persistence.createEntityManagerFactory("SGD2012PU");
        em = emf.createEntityManager();


//        di.setSerie(new TRD(l));
        //Funcionario f=new Funcionario("49722106", "1234", "FUNCIONARIA", "49722106", "ANYA","BOLAÑO", "583","anya@hotmail.com");
        Funcionario f2 = new Funcionario("7573361", "1234", "FUNCIONARIO", "7573361", "BORIS", "GONZALEZ", "583", "boris@hotmail.com");
        PerExterna pe = new PerExterna("77009398", "BORIS LUIS", "GONZALEZ PEREZ", "3118001885", "borispapa@hotmail.com");
        PerExternaService peSer = new PerExternaService(emf);
        //  peSer.create(pe);
        FuncionarioService fs = new FuncionarioService(emf);
        try {
            //fs.create(f);
            fs.create(f2);
        } catch (PreexistingEntityException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }


    }

    public void mostrarURL() {
        try {
            
            String dir = "file:///E:/reporte.html";
            Desktop.getDesktop().browse(new URI(dir));
        } catch (Exception e) {
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.print("Hola Mundo");
        Main yo = new Main();
        
        Reportes r = new Reportes();
        r.generarReporte();
        //yo.crear();
        yo.mostrarURL();
        

    }
}
