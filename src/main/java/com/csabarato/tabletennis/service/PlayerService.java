package com.csabarato.tabletennis.service;

import com.csabarato.tabletennis.model.Player;

import java.util.List;

public interface PlayerService {

    List<Player> getAll();

    Player save(Player newPlayer);

}
