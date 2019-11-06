package com.csabarato.tabletennis.service;

import com.csabarato.tabletennis.model.Player;
import com.csabarato.tabletennis.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    PlayerRepository playerRepository;

    @Override
    public List<Player> getAll() {
        List<Player> players = new ArrayList<>();
        playerRepository.findAll().forEach(i -> players.add(i));
        return players;
    }

    public Player getById(Integer id){
        return playerRepository.findById(id).get();
    }

    @Override
    public Player save(Player newPlayer) {
        return playerRepository.save(newPlayer);
    }

    public Player update(Integer id, Player updatedPlayer){

        Optional<Player> player = playerRepository.findById(id);
        return  playerRepository.save(updatedPlayer);
    }
}
