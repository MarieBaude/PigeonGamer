package co.simplon.pigeongamer.pigeongamer.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import co.simplon.pigeongamer.pigeongamer.model.Product;
import co.simplon.pigeongamer.pigeongamer.service.ProductService;

@Controller
public class ProductController {
	 	
	@Autowired
    private ProductService productService;

    // display list of product
    @GetMapping("/")
    public String viewHomePage(HttpServletRequest req, Model model) {
		SessionCtrl session = new SessionCtrl();
		// if not session : create session
        if(session.getSessionUserCart(req) == null) {
			session.setSession(req);
		}
        model.addAttribute("listProducts", productService.getAllProducts());
        model.addAttribute("cartList", (List<Integer>) session.getSessionUserCart(req));
        return "index";
    }
    
    @GetMapping("/showNewProductForm")
    public String showNewProductForm(Model model) {
        // create product attribute to bind form data
    	Product product = new Product();
        model.addAttribute("product", product);
        return "new_product";
    }

    @PostMapping("/saveProduct")
    public String saveProduct(@ModelAttribute("product") Product product) {
        // save product to database
    	productService.saveProduct(product);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id_product}")
    public String showFormForUpdate(@PathVariable(value = "id_product") long id_product, Model model) {

        // get employee from the service
    	Product product = productService.getProductById(id_product);

        // set product as a model attribute to pre-populate the form
        model.addAttribute("product", product);
        return "update_product";
    }

    @GetMapping("/deleteProduct/{id_product}")
    public String deleteProduct(@PathVariable(value = "id_product") long id_product) {

        // call delete product method 
        this.productService.deleteProductById(id_product);
        return "redirect:/";
    }
	
}
