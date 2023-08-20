package org.example.entity;

import lombok.Data;
import org.example.base.domain.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.List;


@Entity
@Data

public class Prescription extends BaseEntity<Long> {


    private Boolean isConfirm;

    private Integer priceOfAll;

    @ManyToMany
    private List<Item> itemList;

    @ManyToOne
    private Patient patient;
}
