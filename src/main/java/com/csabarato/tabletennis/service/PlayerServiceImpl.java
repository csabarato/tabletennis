package com.csabarato.tabletennis.service;

import com.csabarato.tabletennis.model.Player;
import com.csabarato.tabletennis.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    PlayerRepository playerRepository;

    @Override
    public List<Player> getAllPlayers() {
        List<Player> players = new ArrayList<>();
        playerRepository.findAll().forEach(i -> players.add(i));
        return players;
    }
}
