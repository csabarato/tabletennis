package com.csabarato.tabletennis.service;

import com.csabarato.tabletennis.model.Player;
import com.csabarato.tabletennis.model.Trainer;
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
    public Player saveOrUpdate(Player playerToSave) {
        return playerRepository.save(playerToSave);
    }

    @Override
    public void deleteById(Integer id) {
        playerRepository.deleteById(id);
    }

    @Override
    public void removeTrainerFromPlayer(Trainer trainer) {
        Player player =playerRepository.findByTrainer(trainer);
        if (player != null) {
            player.setTrainer(null);
            playerRepository.save(player);
        }
    }
}
