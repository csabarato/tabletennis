package com.csabarato.tabletennis.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "match")
public class Match {

    @Id
    @NotNull
    private Integer matchID;

    @OneToOne
    @JoinColumn(name = "player1ID", insertable = false, updatable = false)
    private Player player1;

    @OneToOne
    @JoinColumn(name = "player2ID", insertable = false, updatable = false )
    private Player player2;

    @NotNull
    private Integer player1Point;

    @NotNull
    private Integer player2point;

    public Match() {
    }

    public Match(Player player1, Player player2, Integer player1Point, Integer player2point) {
        this.player1 = player1;
        this.player2 = player2;
        this.player1Point = player1Point;
        this.player2point = player2point;

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

    public Integer getPlayer2point() {
        return player2point;
    }

    public void setPlayer2point(Integer player2point) {
        this.player2point = player2point;
    }
}
