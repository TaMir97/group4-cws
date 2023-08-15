package org.example;

import org.example.entity.Admin;
import org.example.entity.Person;
import org.example.entity.enums.Role;
import org.example.repository.AdminRepository;
import org.example.repository.PersonRepository;
import org.example.repository.impl.AdminRepositoryImpl;
import org.example.repository.impl.PersonRepositoryImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class Main {


    public static void main(String[] args) {


        EntityManagerFactory ENTITY_MANAGER_FACTORY;
        EntityManager ENTITY_MANAGER;


        ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("postgres");
        ENTITY_MANAGER = ENTITY_MANAGER_FACTORY.createEntityManager();

        Person person = new Person();
        person.setUsername("Tahoo");
        person.setPassword("123");
        person.setRole(Role.ADMIN);
        PersonRepository personRepository = new PersonRepositoryImpl(ENTITY_MANAGER);

        Admin admin = new Admin();
        admin.setAdminLevel("High");
        admin.setPerson(person);
        AdminRepository adminRepository = new AdminRepositoryImpl(ENTITY_MANAGER);

        person.setAdmin(admin);

        ENTITY_MANAGER.getTransaction().begin();

        personRepository.save(person);
        adminRepository.save(admin);

        ENTITY_MANAGER.getTransaction().commit();




    }
}