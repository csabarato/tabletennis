package com.csabarato.tabletennis.controller;

import com.csabarato.tabletennis.model.Player;
import com.csabarato.tabletennis.service.CountryService;
import com.csabarato.tabletennis.service.PlayerService;
import com.csabarato.tabletennis.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.stream.Collectors;

@Controller
@RequestMapping(value = "/players")
public class PlayerController {

    @Autowired
    PlayerService playerService;

    @Autowired
    CountryService countryService;

    @Autowired
    TrainerService trainerService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String listAllPlayers(Model model){
        model.addAttribute("players", playerService.getAll());
        return "playerResources/players";
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String getNewPlayerForm(Model model){

        model.addAttribute("player", new Player() );
        model.addAttribute("countries", countryService.getCountries());
        model.addAttribute("trainers",  trainerService.findAllWherePlayerIsNull());
        return "playerResources/playerForm";
    }

    @RequestMapping(value="/add", method = RequestMethod.POST)
    public String addNewPlayer(@ModelAttribute Player newPlayer){

        String countryCode = newPlayer.getCountry().getCountryCode();
        Integer trainerId = newPlayer.getTrainer().getTrainerID();

        newPlayer.setCountry(countryService.getByCountryCode(countryCode));
        newPlayer.setTrainer(trainerService.getById(trainerId));

        playerService.save(newPlayer);
        return "redirect:list";
    }

    @RequestMapping(value = "/update/{id}")
    public String getUpdatePlayerForm( @PathVariable("id") Integer playerId ,  Model model){

        model.addAttribute("player" , playerService.getById(playerId));

        model.addAttribute("countries" , countryService.getCountries());
        model.addAttribute("trainers", trainerService.findAllWherePlayerIsNull());
        return "playerResources/playerForm";
    }

}
