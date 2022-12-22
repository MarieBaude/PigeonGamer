package co.simplon.pigeongamer.pigeongamer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import co.simplon.pigeongamer.pigeongamer.model.Command;
import co.simplon.pigeongamer.pigeongamer.service.CommandService;
public class CommandController {
	@Autowired
    private CommandService commandService;
    
    @GetMapping("/dashboard")
    public String viewDashboardPage(Model model) {
        model.addAttribute("listCommands", commandService.getAllCommands());
        return "dashboard";
    }

    @GetMapping("/showNewCommandForm")
    public String showNewCommandForm(Model model) {
        // create product attribute to bind form data
    	Command command = new Command();
        model.addAttribute("product", command);
        return "new_product";
    }

    @PostMapping("/saveProduct")
    public String saveCommand(@ModelAttribute("command") Command command) {
        // save product to database
    	commandService.saveCommand(command);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id_product}")
    public String showFormForUpdate(@PathVariable(value = "id_command") long id_command, Model model) {

        // get employee from the service
    	Command command = commandService.getCommandById(id_command);

        // set product as a model attribute to pre-populate the form
        model.addAttribute("command", command);
        return "update_product";
    }

    @GetMapping("/deleteCommand/{id_command}")
    public String deleteCommand(@PathVariable(value = "id_command") long id_command) {

        // call delete product method 
        this.commandService.deleteCommandById(id_command);
        return "redirect:/";
    }
}
