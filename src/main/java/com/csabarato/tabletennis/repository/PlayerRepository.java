package com.csabarato.tabletennis.repository;

import com.csabarato.tabletennis.model.Player;
import org.springframework.data.repository.CrudRepository;

public interface PlayerRepository extends CrudRepository<Player, Integer> {
}
