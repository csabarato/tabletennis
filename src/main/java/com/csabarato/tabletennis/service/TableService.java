package com.csabarato.tabletennis.service;

import com.csabarato.tabletennis.model.Match;
import com.csabarato.tabletennis.model.Player;
import com.csabarato.tabletennis.viewModels.TableDataRow;

import java.util.List;
import java.util.Map;

public interface TableService {

    Map<Player, TableDataRow> calculateTable(Integer competitionId);

    void clearTable();

}
