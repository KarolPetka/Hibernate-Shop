package project.database.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtils {

    private static HibernateUtils instance = null;

    private SessionFactory sessionFactory;

    private HibernateUtils() {
        StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
                .configure("Hibernate.xml")
                .build();
        Metadata metadata = new MetadataSources(standardRegistry)
                .getMetadataBuilder()
                .build();
        sessionFactory = metadata.getSessionFactoryBuilder()
                .build();
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static HibernateUtils instance() {
        if (instance == null) {
            instance = new HibernateUtils();
        }
        return instance;
    }
}