package org.example;

import org.example.entity.Address;
import org.example.entity.Employee;
import org.example.entity.PhoneNumber;
import org.example.repository.AddressRepository;
import org.example.repository.EmployeeRepository;
import org.example.repository.PhoneNumberRepository;
import org.example.repository.impl.AddressRepositoryImpl;
import org.example.repository.impl.EmployeeRepositoryImpl;
import org.example.repository.impl.PhoneNumberRepositoryImpl;
import org.example.service.AddressService;
import org.example.service.EmployeeService;
import org.example.service.PhoneNumberService;
import org.example.service.impl.AddressServiceImpl;
import org.example.service.impl.EmployeeServiceImpl;
import org.example.service.impl.PhoneNumberServiceImpl;
import org.example.util.AppEntityManagerFactory;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        EntityManager entityManager = AppEntityManagerFactory.getEntityManagerFactory();

        EmployeeRepository employeeRepository = new EmployeeRepositoryImpl(entityManager);
        EmployeeService employeeService = new EmployeeServiceImpl(employeeRepository);

        PhoneNumberRepository phoneNumberRepository = new PhoneNumberRepositoryImpl(entityManager);
        PhoneNumberService phoneNumberService = new PhoneNumberServiceImpl(phoneNumberRepository);

        AddressRepository addressRepository = new AddressRepositoryImpl(entityManager);
        AddressService addressService = new AddressServiceImpl(addressRepository);

//        Employee empolyee = new Employee();
//        empolyee.setName("Tahoo");
//        empolyee.setSalary(15.5);
//        empolyee.setEmpCode(123456);
//        employeeService.save(empolyee);
//
//        Random random = new Random();
//        List<Address> addressList = new ArrayList<>();
//        for (int i = 0; i < 5; i++) {
//            Address address = new Address();
//
//            PhoneNumber phoneNumber = new PhoneNumber();
//            phoneNumber.setMobNumber(random.nextInt(100000));
//            phoneNumber.setTelNumber(random.nextInt(200000));
//            phoneNumberService.save(phoneNumber);
//
//            address.setEmployee(empolyee);
//            address.setCity("Yazd");
//            address.setPostalAddress(random.nextInt(1000));
//            address.setPostalCode(random.nextInt(1000));
//            address.setPhoneNumbers(phoneNumber);
//
//            addressList.add(address);
//        }
//
//        addressService.saveAll(addressList);

        System.out.println(addressService.findByPostalCodeCriteria(571));

        System.out.println(employeeService.findEmployeesByPhoneNumber(162801));


    }
}