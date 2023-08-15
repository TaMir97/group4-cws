package org.example.repository.impl;

import org.example.base.repository.impl.BaseRepositoryImpl;
import org.example.entity.Admin;
import org.example.repository.AdminRepository;
import org.example.util.AppEntityManagerFactory;

import javax.persistence.EntityManager;

public class AdminRepositoryImpl extends BaseRepositoryImpl<Admin,Long> implements AdminRepository {

    EntityManager ENTITY_MANAGER = AppEntityManagerFactory.getEntityManager();

    public AdminRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }


    @Override
    public Class<Admin> getEntityClass() {
        return Admin.class;
    }
}
