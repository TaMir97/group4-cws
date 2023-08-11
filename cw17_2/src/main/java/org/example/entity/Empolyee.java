package org.example.entity;


import org.example.base.domain.BaseEntity;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Objects;

@Entity
public class Empolyee extends BaseEntity<Long> {


   private String name;
   private Integer empCode;
   private double  salary;

   @OneToMany(mappedBy = "employee",cascade = {CascadeType.PERSIST, CascadeType.MERGE})
   private Address addresses[];


   public Empolyee(Long aLong, String name, Integer empCode, double salary, Address[] addresses) {
      super(aLong);
      this.name = name;
      this.empCode = empCode;
      this.salary = salary;
      this.addresses = addresses;
   }

   public Empolyee(String name, Integer empCode, double salary, Address[] addresses) {
      this.name = name;
      this.empCode = empCode;
      this.salary = salary;
      this.addresses = addresses;
   }

   public Empolyee() {
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

   public double getSalary() {
      return salary;
   }

   public void setSalary(double salary) {
      this.salary = salary;
   }

   public Address[] getAddresses() {
      return addresses;
   }

   public void setAddresses(Address[] addresses) {
      this.addresses = addresses;
   }

   @Override
   public String toString() {
      return "Empolyee{" +
              "id=" + id +
              ", name='" + name + '\'' +
              ", empCode=" + empCode +
              ", salary=" + salary +
              ", addresses=" + Arrays.toString(addresses) +
              '}';
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Empolyee empolyee = (Empolyee) o;
      return Double.compare(empolyee.salary, salary) == 0 && Objects.equals(name, empolyee.name) && Objects.equals(empCode, empolyee.empCode) && Arrays.equals(addresses, empolyee.addresses);
   }

   @Override
   public int hashCode() {
      int result = Objects.hash(name, empCode, salary);
      result = 31 * result + Arrays.hashCode(addresses);
      return result;
   }
}
