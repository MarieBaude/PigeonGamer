package co.simplon.pigeongamer.pigeongamer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import co.simplon.pigeongamer.pigeongamer.model.Command;
import co.simplon.pigeongamer.pigeongamer.service.CommandService;

@Controller
public class CommandController {
	@Autowired
    private CommandService commandService;
    
    @GetMapping("/dashboard")
    public String viewDashboardPage(Model model) {
       model.addAttribute("listCommands", commandService.getAllCommands());
       return "dashboard";
    }

    @PostMapping("/new_command")
    public void saveOrder(@RequestBody List<Long> productList) {
      CommandService.saveCommand(productList);
    }

    @PostMapping("/saveCommand")
    public String saveCommand(@ModelAttribute("command") Command command) {
        // save command to database
    	commandService.saveCommand(command);
        return "redirect:/";
    }

}