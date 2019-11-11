package com.csabarato.tabletennis.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "matches")
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer matchID;

    @OneToOne
    @JoinColumn(name = "player1ID")
    private Player player1;

    @OneToOne
    @JoinColumn(name = "player2ID" )
    private Player player2;

    @Column(name = "player1Point")
    private Integer player1Point;

    @Column(name = "player2Point")
    private Integer player2Point;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name  = "competitionID")
    private Competition competition;

    public Match() {
    }

    public Match(Player player1 , Player player2, Integer player1Point, Integer player2point, Competition competition) {
        this.player1 = player1;
        this.player2 = player2;
        this.player1Point = player1Point;
        this.player2Point = player2Point;
        this.competition = competition;
    }

    public Integer getMatchID() {
        return matchID;
    }

    public void setMatchID(Integer matchID) {
        this.matchID = matchID;
    }

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public Integer getPlayer1Point() {
        return player1Point;
    }

    public void setPlayer1Point(Integer player1Point) {
        this.player1Point = player1Point;
    }

    public Integer getPlayer2Point() {
        return player2Point;
    }

    public void setPlayer2Point(Integer player2Point) {
        this.player2Point = player2Point;
    }

    public Competition getCompetition() {
        return competition;
    }

    public void setCompetition(Competition competition) {
        this.competition = competition;
    }
}
