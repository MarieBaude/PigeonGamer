package co.simplon.pigeongamer.pigeongamer.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import co.simplon.pigeongamer.pigeongamer.model.Product;
import co.simplon.pigeongamer.pigeongamer.service.ProductService;
import co.simplon.pigeongamer.pigeongamer.service.ProductServicelmpl;

public class SessionCtrl {
	private ProductService productService;
	
	public void setSession(HttpServletRequest req) {
		
		
		HttpSession session = req.getSession();
		
		List<Product> listCart = new ArrayList<>();
		List<Integer> listId = new ArrayList<>();
		
		session.setAttribute("sessionUserCart", listCart);
		session.setAttribute("isSessionCreated", true);
		System.out.println("Session créer");
	}
	
	public Object getSessionUserCart(HttpServletRequest req) {
		HttpSession session = req.getSession();
		return session.getAttribute("sessionUserCart");
	}
	
	public void updateSessionUserCart(HttpServletRequest req, int productId) {
		HttpSession session = req.getSession();
		
		Product product = productService.getProductById(id_product);

		// Retrieve the list from the session
		List<Product> listProduct = (List<Product>) getSessionUserCart(req);
		List<Product> listId = (List<Product>) getSessionUserCart(req);

		if (!listId.contains(productId)) {
			listId.add(productId);
			session.setAttribute("sessionUserCart", listId);
			System.out.println("Ajout dans le panier du produit " + productId);
		} else {
			System.out.println("Produit déjà dans le panier");
		}
			
		//return session.getAttribute("sessionUserCart");
	}
	
	public Boolean isSessionCreated(HttpServletRequest req) {
		HttpSession session = req.getSession();
		return (Boolean) session.getAttribute("sessionUserCart");
	}
	
}
