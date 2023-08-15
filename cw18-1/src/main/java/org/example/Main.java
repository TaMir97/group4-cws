package org.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class Main {


    public static void main(String[] args) {


        EntityManagerFactory ENTITY_MANAGER_FACTORY;
        EntityManager ENTITY_MANAGER;


        ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("postgres");
        ENTITY_MANAGER = ENTITY_MANAGER_FACTORY.createEntityManager();

        ENTITY_MANAGER.getTransaction().begin();
        ENTITY_MANAGER.getTransaction().commit();




    }
}