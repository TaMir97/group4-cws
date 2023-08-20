package org.example.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.example.base.domain.BaseEntity;
import org.example.entity.enums.AdminLevel;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Admin extends BaseEntity<Long> {

    @OneToOne(fetch = FetchType.LAZY)
    private Person person;

    @Enumerated(EnumType.STRING)
    private AdminLevel adminLevel;



}
