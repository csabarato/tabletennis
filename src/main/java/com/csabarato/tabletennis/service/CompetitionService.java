package com.csabarato.tabletennis.service;

import com.csabarato.tabletennis.model.Competition;

import java.util.List;

public interface CompetitionService {

    List<Competition> getAll();

    Competition getById(Integer id);

    Competition saveOrUpdate(Competition compToSave);

    void delete(Integer compId);

    Competition addPlayerToCompetition(Integer competitionId , Integer playerId);

    Competition removePlayerFromCompetition(Integer competitionId, Integer playerId);
}
