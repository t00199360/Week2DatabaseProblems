import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by t00036478 on 08/02/2018.
 */
public class TestAutoCreate {
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
        public void persistTrade(Trade trade) {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            session.save(trade);
            session.getTransaction().commit();
        }


        public static void main(String[] args){
            TestAutoCreate manager = new TestAutoCreate();
            manager.initSessionFactory();

            Trade trade = new Trade();
            trade.setTradeId(123l);
            trade.setQuantity(10.0);
            trade.setSecurity("secure");
            System.out.println(trade);

            manager.persistTrade(trade);
        }
    }

