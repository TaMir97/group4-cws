package org.example.service;

import org.example.base.service.BaseService;
import org.example.entity.Address;
import org.example.entity.Employee;

import java.util.List;

public interface AddressService  extends BaseService<Address,Long> {
    List<Employee> findByPostalCode(int postalCode);
    List<Employee> findByPostalCodeCriteria(int postalCode);

}
