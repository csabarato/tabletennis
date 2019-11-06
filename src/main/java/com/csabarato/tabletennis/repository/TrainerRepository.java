package com.csabarato.tabletennis.repository;

import com.csabarato.tabletennis.model.Trainer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TrainerRepository extends CrudRepository<Trainer, Integer > {

    List<Trainer> findAllByPlayerIsNull();

}
