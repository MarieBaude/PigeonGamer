package co.simplon.pigeongamer.pigeongamer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import co.simplon.pigeongamer.pigeongamer.model.Historical;
import co.simplon.pigeongamer.pigeongamer.model.Product;
import co.simplon.pigeongamer.pigeongamer.model.Supplier;
import co.simplon.pigeongamer.pigeongamer.service.HistoricalService;
import co.simplon.pigeongamer.pigeongamer.service.ProductService;
import co.simplon.pigeongamer.pigeongamer.service.SupplierService;

@Controller
public class HistoricalController {
	  @Autowired
	  private HistoricalService historicalService;
	  
	  @GetMapping("/historical")
	  public String PageHistorical(Model model) {
	    Historical historical = new Historical();
		 model.addAttribute("listHistoricals", historicalService.getAllHistorical());
		 model.addAttribute("historical", historical);
	    return "historique";
	  }
	    @PostMapping("/saveHistorical")
	    public String saveProduct(@ModelAttribute("historical") Historical historical,@ModelAttribute("product") Product product) {
	        // save product to database
	    	
	        return "redirect:/historical";
	    }
}