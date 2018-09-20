

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;

/**
 * Class that demonstratest the Hibernate's configuration capabilities
 *
 * @author mkonda
 *
 */
public class ConfigurationTest {

    /**
     * Tests for simple configuration which looks for either
     * hibernate.properties or hibernate.cfg.xml in classpath.
     */
    public void testVanillaConfiguration() {

        Configuration configuration = new Configuration().configure();

        System.out.println("Configuration: "
                + configuration.configure().toString());
    }

    public void testProgrammaticConfiguration() {

        Configuration configuration = new Configuration()
                .setProperty("hibernate.connection.url", "jdbc:oracle:thin:@//studentoracle.students.ittralee.ie:1521/orcl")
                .setProperty("hibernate.connection.dialect", "oracle.jdbc.OracleDriver")
                .setProperty("hibernate.connection.username", "t00199360")
                .setProperty("hibernate.connection.password", "dn9xj3gf")
                .setProperty("hibernate.current_session_context_class", "thread")
                .addResource("Movie.hbm.xml");

       System.out.println("Programmatic Configuration: "
               + configuration.toString());
        
       SessionFactory sf =  configuration.buildSessionFactory();
       Session s = sf.getCurrentSession();
       System.out.println("Session: "+s.toString());
    }

    public static void main(String[] args) {
        ConfigurationTest test = new ConfigurationTest();
          //test.testVanillaConfiguration();
          test.testProgrammaticConfiguration();
    }
}
