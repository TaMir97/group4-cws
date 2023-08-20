package org.example.entity;

import lombok.Data;
import org.example.base.domain.BaseEntity;

import javax.persistence.*;
import java.util.List;


@Entity
@Data


public class Item extends BaseEntity<Long> {

    private String name;
    private Integer price;


    private Boolean doesExist;

    @ManyToMany(mappedBy = "itemList")
    private List<Prescription> prescriptionList;

}
