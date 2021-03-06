package com.csabarato.tabletennis.model;

import org.hibernate.annotations.Cascade;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.servlet.http.PushBuilder;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "player")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer playerID;

    @NotNull
    private String name;

    @Column(name = "birthdate")
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd" )
    private Date birthDate;

    @OneToOne
    @JoinColumn(name = "trainerID")
    private Trainer trainer;

    @ManyToOne
    @JoinColumn(name = "countrycode", nullable = false)
    private Country country;

    @ManyToMany(mappedBy = "participants", cascade = CascadeType.REFRESH)
    Set<Competition> attendedCompetitions;

    public Player(){}

    public Player(String name, Date birthDate, Trainer trainer, Country country) {
        this.name = name;
        this.birthDate = birthDate;
        this.trainer = trainer;
        this.country = country;
    }

    public Integer getPlayerID() {
        return playerID;
    }

    public void setPlayerID(Integer playerID) {
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

    public Set<Competition> getAttendedCompetitions() {
        return attendedCompetitions;
    }

    public void setAttendedCompetitions(Set<Competition> attendedCompetitions) {
        this.attendedCompetitions = attendedCompetitions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return playerID.equals(player.playerID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerID);
    }
}
