package org.example.repository.impl;

import org.example.base.repository.impl.BaseRepositoryImpl;
import org.example.entity.Empolyee;
import org.example.repository.EmpolyeeRepository;

import javax.persistence.EntityManager;

public class EmpolyeeRepositoryImpl extends BaseRepositoryImpl<Empolyee,Long> implements EmpolyeeRepository {

    public EmpolyeeRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Empolyee> getEntityClass() {
        return Empolyee.class;
    }
}
