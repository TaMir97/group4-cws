package org.example.util;



import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AppEntityManagerFactory {

    private static final EntityManagerFactory entityManagerFactory ;

    static {
        entityManagerFactory =  Persistence.createEntityManagerFactory("postgres");
    }


    private AppEntityManagerFactory() {
    }

    public static EntityManager getEntityManagerFactory() {
        return  entityManagerFactory.createEntityManager();
    }
}
