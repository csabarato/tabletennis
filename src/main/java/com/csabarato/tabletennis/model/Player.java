package com.csabarato.tabletennis.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "Player")
public class Player {

    @Id
    @NotNull
    private Integer playerID;

    @NotNull
    private String name;

    @Column(name = "birthdate")
    @NotNull
    private Date birthDate;

    private int trainerID;

    @Column(name = "countrycode")
    @NotNull
    private String countryCode;

    public Player(){}

    public Player(String name, Date birthDate, int trainerID, String countryCode) {
        this.name = name;
        this.birthDate = birthDate;
        this.trainerID = trainerID;
        this.countryCode = countryCode;
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

    public int getTrainerID() {
        return trainerID;
    }

    public void setTrainerID(int trainerID) {
        this.trainerID = trainerID;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
}
