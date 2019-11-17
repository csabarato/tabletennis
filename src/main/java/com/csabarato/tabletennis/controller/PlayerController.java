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
import org.thymeleaf.model.IModel;

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

    @RequestMapping(value="/add", method = RequestMethod.POST)
    public String saveOrUpdatePlayer(@ModelAttribute Player playerToSave){

        String countryCode = playerToSave.getCountry().getCountryCode();
        Integer trainerId = playerToSave.getTrainer().getTrainerID();

        playerToSave.setCountry(countryService.getByCountryCode(countryCode));
        playerToSave.setTrainer(trainerService.getById(trainerId));

        // save OR update !!!
        playerService.saveOrUpdate(playerToSave);
        return "redirect:list";
    }

    @RequestMapping(value = "/delete/{id}")
    public String deletePlayerById(@PathVariable("id") Integer playerId){
        playerService.deleteById(playerId);
        return "redirect:/players/list";
    }

    @RequestMapping(value = "/{id}/attendances", method = RequestMethod.GET)
    public String getPlayerAttendances(@PathVariable("id") Integer id , Model model){

        model.addAttribute("comps" , playerService.getById(id).getAttendedCompetitions());
        return "compResources/competitions";
    }

    // GET mappings to return Forms to browser.
    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String getNewPlayerForm(Model model){

        model.addAttribute("player", new Player() );
        model.addAttribute("countries", countryService.getCountries());
        model.addAttribute("trainers",  trainerService.findAllWherePlayerIsNull());
        return "playerResources/playerForm";
    }

    @RequestMapping(value = "/update/{id}" , method = RequestMethod.GET)
    public String getUpdatePlayerForm( @PathVariable("id") Integer playerId ,  Model model){

        model.addAttribute("player" , playerService.getById(playerId));

        model.addAttribute("countries" , countryService.getCountries());
        model.addAttribute("trainers", trainerService.findAllWherePlayerIsNull());
        return "playerResources/playerForm";
    }
}
