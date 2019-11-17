package com.csabarato.tabletennis.controller;

import com.csabarato.tabletennis.model.Country;
import com.csabarato.tabletennis.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/countries")
public class CountryController {

    @Autowired
    CountryService countryService;

    @RequestMapping(value = "/list" , method = RequestMethod.GET)
    public String getCountries(Model model){
        model.addAttribute("countries" , countryService.getCountries());
        return "countryResources/countries";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String saveOrUpdateCountry(@ModelAttribute Country country){

        Country c  = new Country();

        c.setCountryCode(country.getCountryCode());
        c.setName(country.getName());

        countryService.saveOrUpdate(c);
        return "redirect:list";
    }

    @RequestMapping(value = "/new")
    public String getNewCountryForm(Model model){
        model.addAttribute("country" , new Country());
        return "countryResources/countryForm";
    }

}
