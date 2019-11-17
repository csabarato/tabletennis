package com.csabarato.tabletennis.repository;

import com.csabarato.tabletennis.model.Player;
import com.csabarato.tabletennis.model.Trainer;
import org.springframework.data.repository.CrudRepository;

public interface PlayerRepository extends CrudRepository<Player, Integer> {

    Player findByTrainer(Trainer trainer);
}
