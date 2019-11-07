package com.csabarato.tabletennis.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "competition")
public class Competition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer competitionID;

    @NotNull
    private String location;

    @NotNull
    private Date date;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "player_competition",
            joinColumns = @JoinColumn(name ="competitionID"),
            inverseJoinColumns = @JoinColumn(name = "playerID")
    )
    private Set<Player> participants;

    public Competition() {
    }

    public Competition(@NotNull String location, @NotNull Date date) {
        this.location = location;
        this.date = date;
    }

    public Integer getCompetitionID() {
        return competitionID;
    }

    public void setCompetitionID(Integer competitionID) {
        this.competitionID = competitionID;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Set<Player> getParticipants() {
        return participants;
    }

    public void setParticipants(Set<Player> participants) {
        this.participants = participants;
    }
}
