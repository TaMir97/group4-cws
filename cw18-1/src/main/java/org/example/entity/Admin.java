package org.example.entity;

import javax.persistence.*;

@Entity



@AttributeOverrides({
        @AttributeOverride(name = "password", column = @Column(name = "password")),
        @AttributeOverride(name = "username", column = @Column(name = "username"))
})

public class Admin extends Person{

    private String AdminLevel;



}
