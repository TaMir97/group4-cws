package org.example.repository;

import org.example.base.repository.BaseRepository;
import org.example.entity.Address;
import org.example.entity.Employee;

import java.util.List;


public interface AddressRepository extends BaseRepository<Address,Long> {
    List<Employee> findByPostalCode(int postalCode);
    List<Employee> findByPostalCodeCriteria(int postalCode);
}
