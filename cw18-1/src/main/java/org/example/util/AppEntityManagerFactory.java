package org.example.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AppEntityManagerFactory {


    private AppEntityManagerFactory() {
    }


    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY;
    private static final EntityManager ENTITY_MANAGER;


    static {
        ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("postgres");
        ENTITY_MANAGER = ENTITY_MANAGER_FACTORY.createEntityManager();
    }

    public static EntityManager getEntityManager() {
        return ENTITY_MANAGER;
    }
}
