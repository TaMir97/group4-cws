package org.example.repository.impl;

import org.example.base.repository.impl.BaseRepositoryImpl;
import org.example.entity.Employee;
import org.example.repository.EmployeeRepository;

import javax.persistence.EntityManager;

public class EmployeeRepositoryImpl extends BaseRepositoryImpl<Employee,Long> implements EmployeeRepository {

    public EmployeeRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Employee> getEntityClass() {
        return Employee.class;
    }


}
