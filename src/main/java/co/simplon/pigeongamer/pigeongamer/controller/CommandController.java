package co.simplon.pigeongamer.pigeongamer.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import co.simplon.pigeongamer.pigeongamer.model.Command;
import co.simplon.pigeongamer.pigeongamer.model.Product;
import co.simplon.pigeongamer.pigeongamer.service.CommandService;

@Controller
public class CommandController {
	@Autowired
    private CommandService commandService;
    
	/**
	 * Handles GET requests for the dashboard page.
	 *
	 * @param model The model for the view.
	 * @return The name of the view template for the dashboard page.
	 */
    @GetMapping("/dashboard")
    public String viewDashboardPage(Model model) {
       model.addAttribute("listCommands", commandService.getAllCommands());
       return "dashboard";
    }
    
    /**
     * Handles POST requests to save a new command.
     *
     * @param command The command to save.
     * @param req The HTTP request.
     * @return A string indicating that the client should be redirected to the root URL.
     */
    @PostMapping("/new_command")
    public String saveCommand(@ModelAttribute("command") Command command, HttpServletRequest req) {
        // save command to database
    	SessionCtrl session = new SessionCtrl();
    	commandService.saveCommand((List<Product>) session.getSessionUserCart(req));
    	//(List<Integer>) session.getSessionUserCart(req);
    	//System.out.println((List<Integer>) session.getSessionUserCart(req));
        return "redirect:/";
    }

}
