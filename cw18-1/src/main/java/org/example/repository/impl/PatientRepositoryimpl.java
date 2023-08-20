package org.example.repository.impl;

import org.example.base.repository.impl.BaseRepositoryImpl;
import org.example.entity.Patient;
import org.example.repository.PatientRepository;


import javax.persistence.EntityManager;

public class PatientRepositoryimpl extends BaseRepositoryImpl<Patient,Long> implements PatientRepository {
    public PatientRepositoryimpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Patient> getEntityClass() {
        return Patient.class;
    }
}
