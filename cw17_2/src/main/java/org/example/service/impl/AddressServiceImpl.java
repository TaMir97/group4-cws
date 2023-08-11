package org.example.service.impl;

import org.example.base.service.impl.BaseServiceImpl;
import org.example.entity.Address;
import org.example.repository.AddressRepository;
import org.example.service.AddressService;

public class AddressServiceImpl
        extends BaseServiceImpl<Address,Long, AddressRepository>
        implements AddressService {

    public AddressServiceImpl(AddressRepository repository) {
        super(repository);
    }
}
