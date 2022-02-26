package org.example.utils;

import org.example.models.*;
import org.example.models.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
public class HibernateSessionFactoryUtil {
    private static SessionFactory sessionFactory;

    private HibernateSessionFactoryUtil() {}

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(Client.class);
                configuration.addAnnotatedClass(Comment.class);
                configuration.addAnnotatedClass(Contract.class);
                configuration.addAnnotatedClass(Countries.class);
                configuration.addAnnotatedClass(Discounts.class);
                configuration.addAnnotatedClass(Feed.class);
                configuration.addAnnotatedClass(Hotel.class);
                configuration.addAnnotatedClass(NameTours.class);
                configuration.addAnnotatedClass(Tour.class);
                configuration.addAnnotatedClass(Worker.class);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());

            } catch (Exception e) {
                System.out.println("Исключение!" + e);
            }
        }
        return sessionFactory;
    }
}
