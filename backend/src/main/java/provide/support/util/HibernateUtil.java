package provide.support.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import provide.support.model.MonitoringUrl;

import javax.persistence.EntityManager;
import javax.persistence.Table;

/**
 * @author Igor Gnes on 6/22/17.
 */
public class HibernateUtil {

    private static SessionFactory SESSION_FACTORY = buildSessionFactory();

    /**
     * Return SessionFactory configuration.
     */
    private static SessionFactory buildSessionFactory() {

        Configuration configuration = new Configuration().configure(HibernateUtil.class.getResource("/hibernate.cfg.xml"));
        configuration.addAnnotatedClass(MonitoringUrl.class);
        StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();
        serviceRegistryBuilder.applySettings(configuration.getProperties());
        ServiceRegistry serviceRegistry = serviceRegistryBuilder.build();
        return configuration.buildSessionFactory(serviceRegistry);

        //        try {
//            final File configFile = new File("src/main/resources/hibernate.cfg.xml");
//            return new Configuration().configure(
//                    configFile).buildSessionFactory();
//
//        } catch (Throwable e) {
//            System.err.println("Initial SessionFactory creation failed." + e);
//            throw new ExceptionInInitializerError(e);
//        }
    }

    public static SessionFactory getSessionFactory() {
        return SESSION_FACTORY;
    }

    public static void shutdown() {
        getSessionFactory().close();
    }
}
