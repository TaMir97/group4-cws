package org.example.repository.impl;

import org.example.base.repository.impl.BaseRepositoryImpl;
import org.example.entity.Address;
import org.example.entity.Employee;
import org.example.repository.AddressRepository;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class AddressRepositoryImpl extends BaseRepositoryImpl<Address,Long> implements AddressRepository {

    public AddressRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Address> getEntityClass() {
        return Address.class;
    }

    @Override
    public List<Employee> findByPostalCode(int postalCode) {
        String findEmployeeByPostalCod = "from Address as a where a.postalCode=:P";
        Query query = entityManger.createQuery(findEmployeeByPostalCod);
        query.setParameter("P",postalCode);
        List<Address> addressList = query.getResultList();
        return addressList.stream().map(Address::getEmployee).toList();
    }

    public List<Employee> findByPostalCodeCriteria(int postalCode){
        CriteriaBuilder criteriaBuilder = entityManger.getCriteriaBuilder();
        CriteriaQuery<Address> criteriaQuery = criteriaBuilder.createQuery(Address.class);
        Root<Address> root = criteriaQuery.from(Address.class);
        criteriaQuery.select(root).where(criteriaBuilder.equal(root.<Integer>get("postalCode"), postalCode));
        Query query = entityManger.createQuery(criteriaQuery);
        List<Address> addressList = query.getResultList();
        return addressList.stream().map(Address::getEmployee).toList();
    }

//    public List<Employee> findByTelNumberCriteria(int telNumber){
//        CriteriaBuilder criteriaBuilder = entityManger.getCriteriaBuilder();
//        CriteriaQuery<Address> criteriaQuery = criteriaBuilder.createQuery(Address.class);
//        Root<Address> root = criteriaQuery.from(Address.class);
//        criteriaQuery.select(root).where(criteriaBuilder.equal(root.<Integer>get("postalCode"), postalCode));
//        Query query = entityManger.createQuery(criteriaQuery);
//        List<Address> addressList = query.getResultList();
//        return addressList.stream().map(Address::getEmployee).toList();
//    }

//    @Override
//    public List<Employee> findByTelNumberCriteria(int telNumber) {
//        String findEmployeeByPostalCod = "from Task t join projectUserMap m where m = :user";
//        Query query = entityManger.createQuery(findEmployeeByPostalCod);
//        query.setParameter("P",postalCode);
//        List<Address> addressList = query.getResultList();
//        return addressList.stream().map(Address::getEmployee).toList();
//    }
}
