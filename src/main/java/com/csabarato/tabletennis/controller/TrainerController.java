package com.csabarato.tabletennis.controller;

import com.csabarato.tabletennis.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.stream.Collectors;

@Controller
@RequestMapping(value = "/trainers")
public class TrainerController {

    @Autowired
    TrainerService trainerService;

    @RequestMapping(value = "/list" , method = RequestMethod.GET )
    String listAllTrainers(Model model){
        model.addAttribute("trainers", trainerService.getAll()) ;
    return "trainerResources/trainers";
    }

}
