package org.example.repository.impl;

import org.example.base.repository.impl.BaseRepositoryImpl;
import org.example.entity.Address;
import org.example.repository.AddressRepository;
import javax.persistence.EntityManager;

public class AddressRepositoryImpl extends BaseRepositoryImpl<Address,Long> implements AddressRepository {

    public AddressRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Address> getEntityClass() {
        return Address.class;
    }
}
