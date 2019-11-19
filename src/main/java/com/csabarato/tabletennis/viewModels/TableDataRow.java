package com.csabarato.tabletennis.viewModels;

public class TableDataRow {

    public Integer numOfWins;

    public Integer numOfDraws;

    public Integer numOfLoses;

    public Integer points;

    public TableDataRow() {
    }

    public TableDataRow(Integer numOfWins, Integer numOfDraws, Integer numOfLoses, Integer points) {
        this.numOfWins = numOfWins;
        this.numOfDraws = numOfDraws;
        this.numOfLoses = numOfLoses;
        this.points = points;
    }
}
