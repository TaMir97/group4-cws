package org.example.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.example.base.domain.BaseEntity;
import org.example.entity.enums.Gender;

import javax.persistence.*;
import java.util.List;


@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Patient extends BaseEntity<Long> {

    @OneToOne(fetch = FetchType.LAZY)
    private Person person;

    private String firstName;
    private String lastName;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @OneToMany(mappedBy = "patient",
            cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private List<Prescription> prescriptionList;

}
