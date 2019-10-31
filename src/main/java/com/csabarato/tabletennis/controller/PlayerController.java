package com.csabarato.tabletennis.controller;

import com.csabarato.tabletennis.model.Player;
import com.csabarato.tabletennis.service.CountryService;
import com.csabarato.tabletennis.service.CountryServiceImpl;
import com.csabarato.tabletennis.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String listAllPlayers(Model model){
        model.addAttribute("players", playerService.getAllPlayers());
        return "playerResources/players";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String getNewPlayerForm(Model model){
        model.addAttribute("player", new Player());
        model.addAttribute("countries", countryService.getCountries());

        return "playerResources/playerForm";
    }



}
