package org.example.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.example.base.domain.BaseEntity;
import org.example.entity.enums.Role;

import javax.persistence.*;


@EqualsAndHashCode(callSuper = true)
@Entity
@Data
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Person extends BaseEntity<Long> {


    @Column(name = "username")
    private String username;
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;




}
