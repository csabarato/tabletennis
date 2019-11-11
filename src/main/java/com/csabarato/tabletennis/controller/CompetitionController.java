package com.csabarato.tabletennis.controller;

import com.csabarato.tabletennis.model.Competition;
import com.csabarato.tabletennis.model.Match;
import com.csabarato.tabletennis.model.Player;
import com.csabarato.tabletennis.service.CompetitionService;
import com.csabarato.tabletennis.service.MatchService;
import com.csabarato.tabletennis.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.stream.Collectors;

@Controller
@RequestMapping(value = "/competitions")
public class CompetitionController {

    @Autowired
    CompetitionService competitionService;

    @Autowired
    PlayerService playerService;

    @Autowired
    MatchService matchService;

    @RequestMapping(value = "/list" , method = RequestMethod.GET)
    public String listAllCompetitions(Model model){

        model.addAttribute("comps", competitionService.getAll());
        return "compResources/competitions";
    }

    @RequestMapping(value = "/add" , method = RequestMethod.POST)
    public String saveOrUpdateCompetition(@ModelAttribute Competition comp){
        competitionService.saveOrUpdate(comp);
        return "redirect:/competitions/list";
    }

    @RequestMapping(value = "/{id}/listPlayers" , method = RequestMethod.GET)
    public String listParticipants(@PathVariable("id") Integer compId , Model model ){
            model.addAttribute("players" , competitionService.getById(compId).getParticipants());
            return "playerResources/players";
    }

    @RequestMapping(value = "/{id}/addPlayer" , method = RequestMethod.POST)
    public String addPlayerToComp(@PathVariable("id") Integer compId , @RequestParam Integer playerID ){

        competitionService.saveOrUpdate(
                competitionService.addPlayerToCompetition(compId, playerID));
        return "redirect:/competitions/list";
    }

    @RequestMapping(value = "/{id}/removePlayer" , method = RequestMethod.POST)
    public String removePlayerFromComp(@PathVariable("id") Integer compId , @RequestParam Integer playerID ){

        competitionService.saveOrUpdate(
                competitionService.removePlayerFromCompetition(compId, playerID));
        return "redirect:/competitions/list";
    }

    @RequestMapping(value="/{id}/listMatches" , method = RequestMethod.GET)
    public String listMatches(Model model, @PathVariable("id") Integer compId){

        Competition competition = competitionService.getById(compId);

        model.addAttribute("comp", competition);
        model.addAttribute("matches" , competition.getMatches());

        return "matchResources/matches";
    }

    @RequestMapping(value="/{id}/addMatch" , method = RequestMethod.POST)
    public String addMatchToCompetition(@ModelAttribute Match match, @PathVariable("id") Integer compId){

        Competition competition = competitionService.getById(compId);
        match.setCompetition(competition);

        matchService.saveOrUpdate(match);

        return "redirect:/competitions/" + compId + "/listMatches";
    }


    // GET mappings to return Forms to browser.
    @RequestMapping(value = "/{id}/addPlayer" , method = RequestMethod.GET)
    public String getAddPlayerToCompForm(@PathVariable("id") Integer compId,  Model model){

        Competition competition = competitionService.getById(compId);

        model.addAttribute("comp" , competition);
        model.addAttribute("player" , new Player());
        model.addAttribute("players", playerService.getAll().stream().filter(
                i-> ! i.getAttendedCompetitions().contains(competition)
        ).collect(Collectors.toList()) );

        return  "compResources/compAddPlayer";
    }

    @RequestMapping(value = "/{id}/removePlayer" , method = RequestMethod.GET)
    public String getRemovePlayerFromCompForm(@PathVariable("id") Integer compId, Model model){
        Competition competition = competitionService.getById(compId);

        model.addAttribute("comp" , competition);
        model.addAttribute("player" , new Player());
        model.addAttribute("players", playerService.getAll().stream().filter(
                i-> i.getAttendedCompetitions().contains(competition)
        ).collect(Collectors.toList()) );

        return  "compResources/compRemovePlayer";
    }

    @RequestMapping(value = "/new" , method = RequestMethod.GET)
    public String getNewCompetitionForm(Model model){
        model.addAttribute("comp" , new Competition());
        return "compResources/compForm";
    }

    @RequestMapping(value = "{compId}/newMatch", method = RequestMethod.GET)
    public String getNewMatchForm( @PathVariable("compId") Integer compId,  Model model){

        Competition comp = competitionService.getById(compId);

        model.addAttribute("comp" , comp);
        model.addAttribute("match", new Match());
        model.addAttribute("players", comp.getParticipants());

        return "matchResources/matchForm";
    }
}
