package org.example.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.example.base.domain.BaseEntity;
import org.example.entity.enums.Role;

import javax.persistence.*;


@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Person extends BaseEntity<Long> {



    private String username;
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Admin admin;

    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Patient patient;

}
