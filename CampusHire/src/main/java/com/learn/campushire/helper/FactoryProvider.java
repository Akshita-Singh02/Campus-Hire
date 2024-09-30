package com.learn.campushire.helper;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FactoryProvider {
    private static SessionFactory factory;

    public static SessionFactory getFactory() {
        if (factory == null) {
            try {
                // Build the session factory using the hibernate.cfg.xml file
                factory = new Configuration()
                        .configure("hibernate.cfg.xml")
                        .buildSessionFactory();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return factory;
    }

    // Optionally add shutdown hook to close the factory
    public static void closeFactory() {
        if (factory != null) {
            factory.close();
        }
    }
}
