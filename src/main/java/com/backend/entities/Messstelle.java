package com.backend.entities;

import javax.persistence.*;
import java.io.Serializable;

import static javax.persistence.GenerationType.*;

/**
 * Created by masc on 02.12.2016.
 */
@Entity
public class Messstelle implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;


    protected Messstelle() {}

    public Messstelle(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }


    @Override
    public String toString(){
        return this.firstName + " " + this.lastName;
    }

}


