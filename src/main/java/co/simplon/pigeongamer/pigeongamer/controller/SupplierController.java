package co.simplon.pigeongamer.pigeongamer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import co.simplon.pigeongamer.pigeongamer.service.SupplierService;

@Controller
public class SupplierController {
	  @Autowired
	  private SupplierService supplierService;
	  
	  @GetMapping("/suppliers")
	  public String PageSupplier(Model model) {
		 model.addAttribute("listSuppliers", supplierService.getAllSuppliers());
	    return "listAndAddSupplier";
	  }
}
