package co.simplon.pigeongamer.pigeongamer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import co.simplon.pigeongamer.pigeongamer.model.Product;
import co.simplon.pigeongamer.pigeongamer.model.Supplier;
import co.simplon.pigeongamer.pigeongamer.service.SupplierService;

@Controller
public class SupplierController {
	  @Autowired
	  private SupplierService supplierService;
	  
	  @GetMapping("/suppliers")
	  public String PageSupplier(Model model) {
	    Supplier supplier = new Supplier();
		 model.addAttribute("listSuppliers", supplierService.getAllSuppliers());
		 model.addAttribute("supplier", supplier);
	    return "listAndAddSupplier";
	  }
	    @PostMapping("/saveSupplier")
	    public String saveProduct(@ModelAttribute("supplier") Supplier supplier) {
	        // save product to database
	    	supplierService.saveSupplier(supplier);
	        return "redirect:/suppliers";
	    }
}
