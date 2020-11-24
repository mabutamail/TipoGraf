package com.github.mabutamail.tipograf.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import static com.github.mabutamail.tipograf.ProgramStart.LOGGER;

public class HibernateSessionFactory {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    public static SessionFactory buildSessionFactory() {
        try {
            LOGGER.info("====================   Create the SessionFactory from hibernate.cfg.xml    ====================");
            return new Configuration().configure().buildSessionFactory();
        } catch (Exception ex) {
            LOGGER.info("====================   buildSessionFactory() Initial SessionFactory creation failed    ====================");
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        LOGGER.info("====================   getSessionFactory()    ====================");
        return sessionFactory;
    }

    public static void shutdown() {
        LOGGER.info("====================   shutdown() Close caches and connection pools    ====================");
        getSessionFactory().close();

    }
}