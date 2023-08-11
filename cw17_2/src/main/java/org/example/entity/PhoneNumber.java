package org.example.entity;


import lombok.Data;
import org.example.base.domain.BaseEntity;

import javax.persistence.Entity;
import java.util.Objects;

@Entity
public class PhoneNumber extends BaseEntity<Long> {


   private Integer telNumber;
   private Integer mobNumber;

    public PhoneNumber(Long aLong, Integer telNumber) {
        super(aLong);
        this.telNumber = telNumber;
    }

    public PhoneNumber(Integer telNumber, Integer mobNumber) {
        this.telNumber = telNumber;
        this.mobNumber = mobNumber;
    }

    public PhoneNumber() {
    }

    public Integer getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(Integer telNumber) {
        this.telNumber = telNumber;
    }

    public Integer getMobNumber() {
        return mobNumber;
    }

    public void setMobNumber(Integer mobNumber) {
        this.mobNumber = mobNumber;
    }

    @Override
    public String toString() {
        return "PhoneNumber{" +
                "id=" + id +
                ", telNumber=" + telNumber +
                ", mobNumber=" + mobNumber +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhoneNumber that = (PhoneNumber) o;
        return Objects.equals(telNumber, that.telNumber) && Objects.equals(mobNumber, that.mobNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(telNumber, mobNumber);
    }
}