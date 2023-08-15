package org.example.repository.impl;

import org.example.base.repository.impl.BaseRepositoryImpl;
import org.example.entity.Admin;
import org.example.entity.Person;
import org.example.repository.AdminRepository;
import org.example.repository.PersonRepository;
import org.example.util.AppEntityManagerFactory;

import javax.persistence.EntityManager;
import java.util.Collection;

public class PersonRepositoryImpl extends BaseRepositoryImpl<Person,Long> implements PersonRepository {
    EntityManager ENTITY_MANAGER = AppEntityManagerFactory.getEntityManager();

    public PersonRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Person> getEntityClass() {
        return Person.class;
    }
}
