package com.csabarato.tabletennis.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "player")
public class Player {

    @Id
    @NotNull
    private Integer playerID;

    @NotNull
    private String name;

    @Column(name = "birthdate")
    @NotNull
    private Date birthDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "trainerID")
    private Trainer trainer;

    @ManyToOne
    @JoinColumn(name = "countrycode", nullable = false)
    private Country country;

    @ManyToMany
    @JoinTable(
            name = "player_competition",
            joinColumns = @JoinColumn(name ="playerID"),
            inverseJoinColumns = @JoinColumn(name = "competitionID")
    )
    Set<Competition> attendedCompetitions;

    public Player(){}

    public Player(String name, Date birthDate, Trainer trainer, Country country) {
        this.name = name;
        this.birthDate = birthDate;
        this.trainer = trainer;
        this.country = country;
    }

    public int getPlayerID() {
        return playerID;
    }

    public void setPlayerID(int playerID) {
        this.playerID = playerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Trainer getTrainer() {
        return this.trainer ;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public void setPlayerID(Integer playerID) {
        this.playerID = playerID;
    }

    public Set<Competition> getAttendedCompetitions() {
        return attendedCompetitions;
    }

    public void setAttendedCompetitions(Set<Competition> attendedCompetitions) {
        this.attendedCompetitions = attendedCompetitions;
    }
}
