package com.csabarato.tabletennis.service;

import com.csabarato.tabletennis.model.Player;
import com.csabarato.tabletennis.model.Trainer;

import java.util.List;

public interface PlayerService {

    List<Player> getAll();

    Player getById(Integer id);

    Player saveOrUpdate(Player playerToSave);

    void deleteById(Integer id);

    void removeTrainerFromPlayer(Trainer trainer);

}
