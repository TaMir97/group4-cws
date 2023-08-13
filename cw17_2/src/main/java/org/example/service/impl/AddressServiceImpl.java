package org.example.service.impl;

import org.example.base.service.impl.BaseServiceImpl;
import org.example.entity.Address;
import org.example.entity.Employee;
import org.example.repository.AddressRepository;
import org.example.service.AddressService;

import java.util.List;

public class AddressServiceImpl
        extends BaseServiceImpl<Address,Long, AddressRepository>
        implements AddressService {

    public AddressServiceImpl(AddressRepository repository) {
        super(repository);
    }

    @Override
    public List<Employee> findByPostalCode(int postalCode) {
        return repository.findByPostalCode(postalCode);
    }

    @Override
    public List<Employee> findByPostalCodeCriteria(int postalCode) {
        return repository.findByPostalCodeCriteria(postalCode);
    }


}
