package org.example.service.impl;

import org.example.base.service.impl.BaseServiceImpl;
import org.example.entity.Empolyee;
import org.example.repository.EmpolyeeRepository;
import org.example.service.EmpolyeeService;

public class EmpolyeeServiceImpl
        extends BaseServiceImpl<Empolyee,Long, EmpolyeeRepository>
        implements EmpolyeeService {


    public EmpolyeeServiceImpl(EmpolyeeRepository repository) {
        super(repository);
    }
}
