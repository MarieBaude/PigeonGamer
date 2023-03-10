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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import co.simplon.pigeongamer.pigeongamer.model.Product;
import co.simplon.pigeongamer.pigeongamer.service.ProductService;

@Controller
public class ProductController {
	 	
	@Autowired
    private ProductService productService;

	/**
	 * Handles GET requests for the home page.
	 *
	 * @param req The HTTP request.
	 * @param model The model for the view.
	 * @return The name of the view template for the home page.
	 */
    @GetMapping("/")
    public String viewHomePage(HttpServletRequest req, Model model) {
		SessionCtrl session = new SessionCtrl();
		// if not session : create session
        if(session.getSessionUserCart(req) == null) {
        	session.setSession(req);
		}
        model.addAttribute("listProducts", productService.getAllProducts());
        model.addAttribute("cartList", (List<Product>) session.getSessionUserCart(req));
        return "index";
    }
    
    /**
     * Handles GET requests for the product page.
     *
     * @param model The model for the view.
     * @return The name of the view template for the product page.
     */
    @GetMapping("/showProduct")
    public String viewDashboardPage(Model model) {
        model.addAttribute("listProducts", productService.getAllProducts());
        return "supplier_product";
    }
    
    /**
	 * Save a product to the database.
	 * @param product The product to save.
	 * @param req The HTTP request containing information about the product to save.
	 * @return A string representing the redirect to the view of products.
    */
    @PostMapping("/saveProduct")
    public String saveProduct(@ModelAttribute("product") Product product, HttpServletRequest req) {
    	Product productToUpdate = productService.getProductById(product.getId_product());
    	int num = Integer.parseInt(req.getParameter("nbProductToCommand"));
    	productService.saveProduct(productToUpdate, num);
    	
        return "redirect:/showProduct";
    }
    
    /**
     * Handles GET requests to display a form for updating a product.
     *
     * @param id_product The ID of the product to update.
     * @param model The model for the view.
     * @return The name of the view template for the update form.
     */
    @GetMapping("/showFormForUpdate/{id_product}")
    public String showFormForUpdate(@PathVariable(value = "id_product") long id_product, Model model) {
        Product product = productService.getProductById(id_product);
        model.addAttribute("product", product);
        return "update_product";
    }
    
    
	
}
