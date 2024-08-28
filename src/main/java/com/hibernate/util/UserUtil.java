package com.hibernate.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.hibernate.entity.User;

public class UserUtil {

    private static final SessionFactory sessionFactory;

    // Static block for initializing the SessionFactory
    static {
        try {
            sessionFactory = new Configuration()
                .configure("Config.xml")
                .addAnnotatedClass(User.class)
                .buildSessionFactory();
        } catch (Throwable ex) {
            // Log the exception (optional)
            System.err.println("SessionFactory initialization failed: " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    // Method to retrieve the SessionFactory
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    // Method to close the SessionFactory (useful for application shutdown)
    public static void shutdown() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }
}

