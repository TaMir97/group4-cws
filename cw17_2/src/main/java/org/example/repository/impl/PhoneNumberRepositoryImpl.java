package org.example.repository.impl;

import org.example.base.repository.impl.BaseRepositoryImpl;
import org.example.entity.PhoneNumber;
import org.example.repository.PhoneNumberRepository;

import javax.persistence.EntityManager;

public class PhoneNumberRepositoryImpl extends BaseRepositoryImpl<PhoneNumber,Long> implements PhoneNumberRepository {
    public PhoneNumberRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<PhoneNumber> getEntityClass() {
        return PhoneNumber.class;
    }
}
