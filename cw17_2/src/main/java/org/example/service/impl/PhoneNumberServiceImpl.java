package org.example.service.impl;

import org.example.base.service.impl.BaseServiceImpl;
import org.example.entity.PhoneNumber;
import org.example.repository.PhoneNumberRepository;
import org.example.service.PhoneNumberService;

public class PhoneNumberServiceImpl
        extends BaseServiceImpl<PhoneNumber,Long, PhoneNumberRepository>
        implements PhoneNumberService {

    public PhoneNumberServiceImpl(PhoneNumberRepository repository) {
        super(repository);
    }
}
