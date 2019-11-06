package com.csabarato.tabletennis.service;

import com.csabarato.tabletennis.model.Trainer;

import java.util.List;

public interface TrainerService {

    List<Trainer> getAll();

    Trainer getById(Integer id);

    List<Trainer> findAllWherePlayerIsNull();


}