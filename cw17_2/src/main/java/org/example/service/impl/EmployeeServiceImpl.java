package org.example.service.impl;

import org.example.base.service.impl.BaseServiceImpl;
import org.example.entity.Employee;
import org.example.repository.EmployeeRepository;
import org.example.service.EmployeeService;

public class EmployeeServiceImpl
        extends BaseServiceImpl<Employee,Long, EmployeeRepository>
        implements EmployeeService {


    public EmployeeServiceImpl(EmployeeRepository repository) {
        super(repository);
    }
}
