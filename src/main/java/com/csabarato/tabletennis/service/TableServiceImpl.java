package com.csabarato.tabletennis.service;

import com.csabarato.tabletennis.model.Match;
import com.csabarato.tabletennis.model.Player;
import com.csabarato.tabletennis.viewModels.TableDataRow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Table;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TableServiceImpl implements TableService{

    @Autowired
    MatchService matchService;

    private Map<Player,TableDataRow> table = new HashMap<>();

    @Override
    public Map<Player, TableDataRow> calculateTable(Integer competitionId) {

        List<Match> matches = matchService.getAllByCompetition(competitionId);

        matches.forEach(i -> {

            if(i.getPlayer1Point() > i.getPlayer2Point()){
                addNotEqualGameToTable(i.getPlayer1() , i.getPlayer2());
            }
            else if(i.getPlayer2Point() > i.getPlayer1Point() ){
                addNotEqualGameToTable(i.getPlayer2() , i.getPlayer1());
            }
            else{
                addEqualGameToTable(i.getPlayer1() , i.getPlayer2());
            }

        });

        return table;
    }

    private void addNotEqualGameToTable(Player winner, Player loser){

        if(table.containsKey(winner)){
            table.get(winner).numOfWins += 1;
            table.get(winner).points += 3;
        }
        else{
            table.put(winner, new TableDataRow(1,0,0,3));
        }

        if(table.containsKey(loser)){
            table.get(loser).numOfLoses += 1;
        }

        else {
            table.put(loser, new TableDataRow(0,0,1,0));
        }
    }

    private void addEqualGameToTable(Player player1, Player player2){

        if(table.containsKey(player1)){
            table.get(player1).numOfDraws += 1;
            table.get(player1).points += 1;
        }
        else{
            table.put(player1, new TableDataRow(0,1,0,0));
        }

        if(table.containsKey(player2)){
            table.get(player2).numOfDraws += 1;
            table.get(player2).points += 1;
        }

        else {
            table.put(player2, new TableDataRow(0,1,0,0));
        }
    }

    public void clearTable(){
        this.table.clear();
    }
}
