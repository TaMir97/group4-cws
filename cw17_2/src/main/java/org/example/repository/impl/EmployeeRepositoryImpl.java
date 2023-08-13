package org.example.repository.impl;

import org.example.base.repository.impl.BaseRepositoryImpl;
import org.example.entity.Address;
import org.example.entity.Employee;
import org.example.entity.PhoneNumber;
import org.example.repository.EmployeeRepository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import java.util.List;

public class EmployeeRepositoryImpl extends BaseRepositoryImpl<Employee,Long> implements EmployeeRepository {

    public EmployeeRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Employee> getEntityClass() {
        return Employee.class;
    }


    public List<Employee> findEmployeesByPhoneNumber(Integer telNumber) {
        CriteriaBuilder criteriaBuilder = entityManger.getCriteriaBuilder();
        CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);

        Root<Address> addressRoot = criteriaQuery.from(Address.class);
        Join<Address, PhoneNumber> phoneNumberJoin = addressRoot.join("phoneNumbers");
        Join<Address, Employee> employeeJoin = addressRoot.join("employee");

        criteriaQuery.select(employeeJoin)
                .distinct(true)
                .where(criteriaBuilder.equal(phoneNumberJoin.get("telNumber"), telNumber));

        TypedQuery<Employee> query = entityManger.createQuery(criteriaQuery);
        return query.getResultList();
    }
}
