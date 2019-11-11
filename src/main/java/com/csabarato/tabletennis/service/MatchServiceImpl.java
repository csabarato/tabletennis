package com.csabarato.tabletennis.service;

import com.csabarato.tabletennis.model.Match;
import com.csabarato.tabletennis.repository.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MatchServiceImpl implements MatchService {

    @Autowired
    MatchRepository matchRepository;

    @Override
    public Match saveOrUpdate(Match match) {
        return matchRepository.save(match);
    }
}
