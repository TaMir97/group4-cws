package org.example.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.example.base.domain.BaseEntity;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Admin extends BaseEntity<Long> {

    @OneToOne(fetch = FetchType.LAZY)
    private Person person;
    private String AdminLevel;



}
