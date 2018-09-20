/**
 * Created by t00036478 on 08/02/2018.
 */
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class BasicMovieManager {
    private SessionFactory sessionFactory = null;
    // Creating SessionFactory using 4.2 version of Hibernate
    public void initSessionFactory(){
        if (sessionFactory == null) {
            // loads configuration and mappings
            Configuration configuration = new Configuration().configure();
            // builds a session factory from the service registry
            sessionFactory = configuration.buildSessionFactory();
        }
    }
    public void persistMovie(Movie movie) {
        Transaction tx = null;
        Session session = sessionFactory.getCurrentSession();
        try {
            tx = session.beginTransaction();
            session.save(movie);
            tx.commit();
        }
        catch(HibernateException ex) {
            if (tx != null) tx.rollback();
            throw ex;
        }
        finally{
            session.close();
        }
    }
    public static void main(String[] args){
        BasicMovieManager manager = new BasicMovieManager();
        manager.initSessionFactory();
        manager.findMovie(6);
        manager.findAll();
        /*Movie movie = new Movie();
        movie.setId(6);
        movie.setDirector("Martin Scorsese");
        movie.setTitle("Casino");
        movie.setSynopsis("Mafia");
        System.out.println(manager);*/

        /*Movie movie = new Movie();
        movie.setId(5);
        movie.setDirector("Mark Wahlberg");
        movie.setTitle("Shooter");              //accidentally updated the table to have a duplicate movie as i dint think the code had worked
        movie.setSynopsis("Sniper");
        System.out.println(manager);


        manager.persistMovie(movie);*/



    }
    private void findMovie(int movieId) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Movie movie = (Movie)session.load(Movie.class, movieId);
        System.out.println("Movie:"+movie.getTitle());
        session.getTransaction().commit();
    }

    private void findAll() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<Movie> movies = session.createQuery("from Movie").list();
        session.getTransaction().commit();
        for (int i = 0; i < movies.size(); i++) {
            System.out.println(movies.get(i).getTitle());
        }
    }



}



