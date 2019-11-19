package com.csabarato.tabletennis.service;

import com.csabarato.tabletennis.model.Match;

import java.util.List;

public interface MatchService {

    Match saveOrUpdate(Match match);

    List<Match> getAllByCompetition(Integer competitionId);
}
