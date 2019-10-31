package com.csabarato.tabletennis.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "trainer")
public class Trainer {

    @Id
    @NotNull
    private Integer trainerID;

    @NotNull
    private String name;

    @ManyToOne
    @JoinColumn(name = "countrycode", nullable = false)
    private Country country;

    public Trainer() {
    }

    public Trainer(String name, Country country) {
        this.name = name;
        this.country = country;
    }

    public Integer getTrainerID() {
        return trainerID;
    }

    public void setTrainerID(Integer trainerID) {
        this.trainerID = trainerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
