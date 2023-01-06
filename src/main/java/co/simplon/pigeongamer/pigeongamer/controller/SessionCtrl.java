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
	@Autowired
    private ProductService productService;

	/**
	 * Creates a new session for the user.
	 *
	 * @param req The HTTP request.
	 */
	public void setSession(HttpServletRequest req) {
		HttpSession session = req.getSession();
		
		List<Product> listCart = new ArrayList<>();
		
		session.setAttribute("sessionUserCart", listCart);
		session.setAttribute("isSessionCreated", true);
		System.out.println("Session créer");
	}
	
	/**
	 * Retrieves the user's cart from the current session.
	 *
	 * @param req The HTTP request.
	 * @return The user's cart, or null if the cart does not exist in the session.
	 */
	public Object getSessionUserCart(HttpServletRequest req) {
		HttpSession session = req.getSession();
		return session.getAttribute("sessionUserCart");
	}
	
	/**
	 * Updates the user's cart in the current session by adding a product to it.
	 *
	 * @param req The HTTP request.
	 * @param product The product to add to the cart.
	 */
	public void updateSessionUserCart(HttpServletRequest req, Product product) {
		HttpSession session = req.getSession();
		
		if(product == null) return;	

		// Retrieve the list from the session
		List<Product> listProduct =  (List<Product>) getSessionUserCart(req);
		List<Long> listId = new ArrayList<>();
		
		System.out.println("----------------------------------");			
		System.out.println(listProduct);			
		System.out.println("----------------------------------");
		
		listProduct.forEach(p -> listId.add(p.getId_product()));

		if (!listId.contains(product.getId_product())) {
			listProduct.add(product);
			session.setAttribute("sessionUserCart", listProduct);
			System.out.println("Ajout dans le panier du produit " + product);
		} else {
			System.out.println("Produit déjà dans le panier");
		}
	}
	
	/**
	 * Updates the user's cart in the current session by removing a product from it.
	 *
	 * @param req The HTTP request.
	 * @param product The product to remove from the cart.
	 */
	public void removeProductFromCart(HttpServletRequest req, Product product) {
	  HttpSession session = req.getSession();
	  List<Product> listProduct =  (List<Product>) getSessionUserCart(req);
	  if (listProduct.contains(product)) {
	    listProduct.remove(product);
	    session.setAttribute("sessionUserCart", listProduct);
	  }
	}
	
	/**
	 * Determines whether a session has been created for the user.
	 *
	 * @param req The HTTP request.
	 * @return true if a session has been created, false otherwise.
	 */
	public Boolean isSessionCreated(HttpServletRequest req) {
		HttpSession session = req.getSession();
		return (Boolean) session.getAttribute("sessionUserCart");
	}
	
}
