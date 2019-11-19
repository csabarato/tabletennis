package com.csabarato.tabletennis.service;

import com.csabarato.tabletennis.model.Competition;
import com.csabarato.tabletennis.model.Match;
import com.csabarato.tabletennis.repository.CompetitionRepository;
import com.csabarato.tabletennis.repository.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.ManagedArray;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchServiceImpl implements MatchService {

    @Autowired
    MatchRepository matchRepository;

    @Autowired
    CompetitionRepository competitionRepository;

    @Override
    public Match saveOrUpdate(Match match) {
        return matchRepository.save(match);
    }

    public List<Match> getAllByCompetition(Integer competitionId){

        Competition comp = competitionRepository.findById(competitionId).get();
        return matchRepository.findAllByCompetition(comp);
    }
}
