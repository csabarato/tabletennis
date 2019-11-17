package com.csabarato.tabletennis.service;

import com.csabarato.tabletennis.model.Competition;
import com.csabarato.tabletennis.model.Player;
import com.csabarato.tabletennis.repository.CompetitionRepository;
import org.hibernate.exception.DataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CompetitionServiceImpl implements CompetitionService {

    @Autowired
    CompetitionRepository competitionRepository;

    @Autowired
    PlayerService playerService;

    @Override
    public List<Competition> getAll() {
        List<Competition> competitions=new ArrayList<>();
        competitionRepository.findAll().forEach(i -> competitions.add(i));
        return competitions;
    }

    @Override
    public Competition getById(Integer id) {
        return competitionRepository.findById(id).get();
    }

    @Override
    public Competition saveOrUpdate(Competition compToSave){
        return competitionRepository.save(compToSave);
    }

    @Override
    public Competition addPlayerToCompetition(Integer competitionId, Integer playerId) {
        Competition competition = competitionRepository.findById(competitionId).get();

        competition.addParticipant(playerService.getById(playerId));
        return competition;
    }

    @Override
    public Competition removePlayerFromCompetition(Integer competitionId, Integer playerId) {

        Competition competition = competitionRepository.findById(competitionId).get();
        competition.getParticipants().removeIf(i -> i.getPlayerID() == playerId);

        return competition;
    }

    @Override
    public void delete(Integer compId) {
        competitionRepository.deleteById(compId);
    }
}
