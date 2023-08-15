package org.example.util;

import org.example.repository.*;
import org.example.repository.impl.*;
import org.example.service.*;
import org.example.service.impl.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AppEntityManagerFactory {

    private AppEntityManagerFactory() {
    }


    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY;
    private static final EntityManager ENTITY_MANAGER;
    private static final AddressRepository ADDRESS_REPOSITORY;
    private static final AddressService ADDRESS_SERVICE;
    private static final EmployeeRepository EMPOLYEE_REPOSITORY;
    private static final EmployeeService EMPOLYEE_SERVICE;
    private static final PhoneNumberRepository PHONE_NUMBER_REPOSITORY;
    private static final PhoneNumberService PHONE_NUMBER_SERVICE;

    static {
        ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("postgres");
        ENTITY_MANAGER = ENTITY_MANAGER_FACTORY.createEntityManager();

        ADDRESS_REPOSITORY = new AddressRepositoryImpl(ENTITY_MANAGER);
        ADDRESS_SERVICE = new AddressServiceImpl(ADDRESS_REPOSITORY);

        EMPOLYEE_REPOSITORY = new EmpolyeeRepositoryImpl(ENTITY_MANAGER);
        EMPOLYEE_SERVICE = new EmpolyeeServiceImpl(EMPOLYEE_REPOSITORY) ;

        PHONE_NUMBER_REPOSITORY = new PhoneNumberRepositoryImpl(ENTITY_MANAGER);
        PHONE_NUMBER_SERVICE = new PhoneNumberServiceImpl(PHONE_NUMBER_REPOSITORY);
    }


    public static AddressService getAddressService(){
        return ADDRESS_SERVICE;
    }

    public static EmpolyeeService getEmpolyeeService() {
        return EMPOLYEE_SERVICE;
    }

    public static PhoneNumberService getPhoneNumberService() {
        return PHONE_NUMBER_SERVICE;
    }


}
