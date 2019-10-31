package com.csabarato.tabletennis.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name = "country")
public class Country {

    @Id
    @Column(name= "countrycode")
    @NotNull
    private String countryCode;

    @NotNull
    private String name;

    @OneToMany(mappedBy = "country")
    private Set<Player> players;

    @OneToMany(mappedBy = "country")
    private Set<Trainer> trainers;

    public Country() {
    }

    public Country(String countryCode, String name) {
        this.countryCode = countryCode;
        this.name = name;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Set<Player> players) {
        this.players = players;
    }

    public Set<Trainer> getTrainers() {
        return trainers;
    }

    public void setTrainers(Set<Trainer> trainers) {
        this.trainers = trainers;
    }
}
