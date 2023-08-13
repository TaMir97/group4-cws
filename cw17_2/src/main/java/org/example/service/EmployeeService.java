package org.example.service;

import org.example.base.service.BaseService;
import org.example.entity.Employee;

import java.util.List;

public interface EmployeeService extends BaseService<Employee,Long> {
    List<Employee> findEmployeesByPhoneNumber(Integer telNumber);

}
