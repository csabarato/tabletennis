package com.csabarato.tabletennis.controller;

import com.csabarato.tabletennis.model.Competition;
import com.csabarato.tabletennis.model.Player;
import com.csabarato.tabletennis.service.CompetitionService;
import com.csabarato.tabletennis.service.TableService;
import com.csabarato.tabletennis.viewModels.TableDataRow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
public class TableController {

    @Autowired
    TableService tableService;

    @RequestMapping(value = "/competitions/{id}/table" , method = RequestMethod.GET)
    public String getTableForCompetition(@PathVariable("id") Integer compId, Model model){

        tableService.clearTable();
        Map<Player,TableDataRow> table = tableService.calculateTable(compId);

        model.addAttribute("table" , table);

        return "tableResources/table";
    }


}
