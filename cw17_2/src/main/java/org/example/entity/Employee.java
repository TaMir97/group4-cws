package org.example.entity;


import org.example.base.domain.BaseEntity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Employee extends BaseEntity<Long> {


   private String name;
   private Integer empCode;
   private Double  salary;

   @OneToMany(mappedBy = "employee",cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE}, fetch = FetchType.LAZY)
   private List<Address> addressList;


   public Employee(Long aLong, String name, Integer empCode, double salary, List<Address> addresses) {
      super(aLong);
      this.name = name;
      this.empCode = empCode;
      this.salary = salary;
      this.addressList = addresses;
   }

   public Employee(String name, Integer empCode, double salary, List<Address> addresses) {
      this.name = name;
      this.empCode = empCode;
      this.salary = salary;
      this.addressList = addresses;
   }

   public Employee() {
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public Integer getEmpCode() {
      return empCode;
   }

   public void setEmpCode(Integer empCode) {
      this.empCode = empCode;
   }

   public Double getSalary() {
      return salary;
   }

   public void setSalary(double salary) {
      this.salary = salary;
   }

   public List<Address> getAddresses() {
      return addressList;
   }

   public void setAddresses(List<Address> addresses) {
      this.addressList = addresses;
   }

   @Override
   public String toString() {
      return "Employee{" +
              "name='" + name + '\'' +
              ", empCode=" + empCode +
              ", salary=" + salary ;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Employee empolyee = (Employee) o;
      return Objects.equals(name, empolyee.name) && Objects.equals(empCode, empolyee.empCode) && Objects.equals(salary, empolyee.salary) && Objects.equals(addressList, empolyee.addressList);
   }

   @Override
   public int hashCode() {
      return Objects.hash(name, empCode, salary, addressList);
   }
}
