package org.example;

import org.example.entity.Admin;
import org.example.entity.Patient;
import org.example.entity.Person;
import org.example.entity.enums.AdminLevel;
import org.example.entity.enums.Gender;
import org.example.entity.enums.Role;
import org.example.repository.AdminRepository;
import org.example.repository.PatientRepository;
import org.example.repository.PersonRepository;
import org.example.repository.impl.AdminRepositoryImpl;
import org.example.repository.impl.PatientRepositoryimpl;
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
        admin.setAdminLevel(AdminLevel.LEVEL_3);
        admin.setPerson(person);
        AdminRepository adminRepository = new AdminRepositoryImpl(ENTITY_MANAGER);
        person.setAdmin(admin);

        Person person2 = new Person();
        person2.setPassword("sdfgssdfg");
        person2.setUsername("username2");
        person2.setRole(Role.PATIENT);

        Person person3 = new Person();
        person3.setPassword("asgztj");
        person3.setUsername("username3");
        person3.setRole(Role.PATIENT);

        Person person4 = new Person();
        person4.setPassword("gylk");
        person4.setUsername("username4");
        person4.setRole(Role.PATIENT);





        PatientRepository patientRepository = new PatientRepositoryimpl(ENTITY_MANAGER);
        Patient patient1 = new Patient();
        patient1.setFirstName("Amin");
        patient1.setLastName("Bazgir");
        patient1.setGender(Gender.MALE);
        person2.setPatient(patient1);
        patient1.setPerson(person2);

        Patient patient2 = new Patient();
        patient2.setFirstName("Amin2222");
        patient2.setLastName("Bazgir");
        patient2.setGender(Gender.MALE);
        person3.setPatient(patient2);
        patient2.setPerson(person3);


        Patient patient3 = new Patient();
        patient3.setFirstName("Amin3333");
        patient3.setLastName("Bazgir");
        patient3.setGender(Gender.MALE);
        person4.setPatient(patient3);
        patient3.setPerson(person4);





        ENTITY_MANAGER.getTransaction().begin();

        personRepository.save(person2);
        patientRepository.save(patient1);

        personRepository.save(person3);
        patientRepository.save(patient2);

        patientRepository.save(patient3);
        personRepository.save(person4);

        personRepository.save(person);
        adminRepository.save(admin);

        ENTITY_MANAGER.getTransaction().commit();





    }
}