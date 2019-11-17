package com.csabarato.tabletennis.service;

import com.csabarato.tabletennis.model.Player;
import com.csabarato.tabletennis.model.Trainer;
import com.csabarato.tabletennis.repository.PlayerRepository;
import com.csabarato.tabletennis.repository.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrainerServiceImpl implements TrainerService {

    @Autowired
    TrainerRepository trainerRepository;

    @Autowired
    PlayerService playerService;

    @Override
    public List<Trainer> getAll() {
        List<Trainer> trainers = new ArrayList<>();
        trainerRepository.findAll().forEach(i -> trainers.add(i));
        return trainers;
    }

    @Override
    public Trainer getById(Integer id) {
        return trainerRepository.findById(id).get();
    }

    @Override
    public List<Trainer> findAllWherePlayerIsNull() {
        return trainerRepository.findAllByPlayerIsNull();
    }

    public Trainer saveOrUpdate(Trainer trainerToSave){
        return trainerRepository.save(trainerToSave);
    }

    @Override
    public void deleteById(Integer id) {

        Trainer t = trainerRepository.findById(id).get();
        playerService.removeTrainerFromPlayer(t);

        trainerRepository.deleteById(id);
    }
}
