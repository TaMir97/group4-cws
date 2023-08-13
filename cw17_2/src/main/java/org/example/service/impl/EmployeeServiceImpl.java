package org.example.service.impl;

import org.example.base.service.impl.BaseServiceImpl;
import org.example.entity.Employee;
import org.example.repository.EmployeeRepository;
import org.example.service.EmployeeService;

import java.util.List;

public class EmployeeServiceImpl
        extends BaseServiceImpl<Employee,Long, EmployeeRepository>
        implements EmployeeService {


    public EmployeeServiceImpl(EmployeeRepository repository) {
        super(repository);
    }

    @Override
    public List<Employee> findEmployeesByPhoneNumber(Integer telNumber) {
        return repository.findEmployeesByPhoneNumber(telNumber);
    }
}
