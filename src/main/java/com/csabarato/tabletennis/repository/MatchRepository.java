package com.csabarato.tabletennis.repository;

import com.csabarato.tabletennis.model.Competition;
import com.csabarato.tabletennis.model.Match;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MatchRepository extends CrudRepository<Match, Integer> {

    List<Match> findAllByCompetition(Competition competition);
}
