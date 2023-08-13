package org.example.repository;

import org.example.base.repository.BaseRepository;
import org.example.entity.Employee;

import java.util.List;


public interface EmployeeRepository extends BaseRepository<Employee,Long>  {
    List<Employee> findEmployeesByPhoneNumber(Integer telNumber);

}
