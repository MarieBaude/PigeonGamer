package co.simplon.pigeongamer.pigeongamer.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import co.simplon.pigeongamer.pigeongamer.model.Product;
import co.simplon.pigeongamer.pigeongamer.service.ProductService;

@Controller
public class CartController {
	@Autowired
    private ProductService productService;
	
	@PostMapping("/addToCart")
	public String addToCart(HttpServletRequest req) {
		SessionCtrl session = new SessionCtrl();
		System.out.println(":: list:" + session.getSessionUserCart(req));
		System.out.println(":: req:" + req.getParameter("idProduct"));
		
		int productId = Integer.parseInt(req.getParameter("idProduct"));			
		Product product = productService.getProductById((long)productId);
		session.updateSessionUserCart(req, product);
		
		return "redirect:/";
	}
	
}
