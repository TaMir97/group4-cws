package org.example.entity;



import org.example.base.domain.BaseEntity;

import javax.persistence.*;
import java.util.Objects;

@Entity

public class Address extends BaseEntity<Long> {


    private Integer postalCode;
    private Integer postalAddress;
    private String city;

    @ManyToOne
    private Empolyee employee;
    @OneToOne
    private PhoneNumber phoneNumbers;

    public Address(Long id, Integer postalCode, Integer postalAddress, String city, Empolyee employee, PhoneNumber phoneNumbers) {
        super(id);
        this.postalCode = postalCode;
        this.postalAddress = postalAddress;
        this.city = city;
        this.employee = employee;
        this.phoneNumbers = phoneNumbers;
    }

    public Address(Integer postalCode, Integer postalAddress, String city, Empolyee employee, PhoneNumber phoneNumbers) {
        this.postalCode = postalCode;
        this.postalAddress = postalAddress;
        this.city = city;
        this.employee = employee;
        this.phoneNumbers = phoneNumbers;
    }

    public Address() {
    }


    public Integer getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(Integer postalCode) {
        this.postalCode = postalCode;
    }

    public Integer getPostalAddress() {
        return postalAddress;
    }

    public void setPostalAddress(Integer postalAddress) {
        this.postalAddress = postalAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Empolyee getEmployee() {
        return employee;
    }

    public void setEmployee(Empolyee employee) {
        this.employee = employee;
    }

    public PhoneNumber getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(PhoneNumber phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", postalCode=" + postalCode +
                ", postalAddress=" + postalAddress +
                ", city='" + city + '\'' +
                ", employee=" + employee +
                ", phoneNumbers=" + phoneNumbers +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(postalCode, address.postalCode) && Objects.equals(postalAddress, address.postalAddress) && Objects.equals(city, address.city) && Objects.equals(employee, address.employee) && Objects.equals(phoneNumbers, address.phoneNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(postalCode, postalAddress, city, employee, phoneNumbers);
    }
}
