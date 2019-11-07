package com.csabarato.tabletennis.service;

import com.csabarato.tabletennis.model.Player;

import java.util.List;

public interface PlayerService {

    List<Player> getAll();

    Player getById(Integer id);

    Player saveOrUpdate(Player playerToSave);

}
