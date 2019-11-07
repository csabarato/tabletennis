package com.csabarato.tabletennis.controller;

import com.csabarato.tabletennis.model.Country;
import com.csabarato.tabletennis.model.Trainer;
import com.csabarato.tabletennis.service.CountryService;
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
@RequestMapping(value = "/trainers")
public class TrainerController {

    @Autowired
    TrainerService trainerService;

    @Autowired
    CountryService countryService;

    @RequestMapping(value = "/list" , method = RequestMethod.GET )
    String listAllTrainers(Model model){
        model.addAttribute("trainers", trainerService.getAll()) ;
    return "trainerResources/trainers";
    }

    @RequestMapping(value = "/add" , method = RequestMethod.POST)
    String saveOrUpdateTrainer(@ModelAttribute Trainer trainerToSave ){

        String countryCode = trainerToSave.getCountry().getCountryCode();
        trainerToSave.setCountry(countryService.getByCountryCode(countryCode));
        trainerService.saveOrUpdate(trainerToSave);
        return "redirect:list";
    }

    // GET mappings to return Forms to browser.
    @RequestMapping(value = "/new", method = RequestMethod.GET)
    String getNewTrainerForm(Model model){
        model.addAttribute("trainer" , new Trainer());
        model.addAttribute("countries", countryService.getCountries());
        return "trainerResources/trainerForm";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    String getUpdateTrainerForm(@PathVariable("id") Integer trainerId ,  Model model){

        model.addAttribute("trainer" , trainerService.getById(trainerId));
        model.addAttribute("countries", countryService.getCountries());
        return "trainerResources/trainerForm";
    }


}
