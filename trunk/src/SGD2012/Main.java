/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SGD2012;


import ClassEntidad.Dependencia;
import Servicios.DependenciaJpaController;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.eclipse.persistence.sessions.Session;
import org.eclipse.persistence.sessions.factories.SessionFactory;

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

        Dependencia dep = new Dependencia("05","Prueba DepXX");

        em = emf.createEntityManager();
        


        DependenciaJpaController depSer = new DependenciaJpaController(emf);
        System.out.println(depSer.findByNombre("Prueba DepXX"));
        
        

        try {
            //depSer.create(dep);
            //depSer.destroy(dep.getId());
        } catch (Exception ex) {
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.print("Hola Mundo");
        Main yo = new Main();
        yo.crear();

    }
}
