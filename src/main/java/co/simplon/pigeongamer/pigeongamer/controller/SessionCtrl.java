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

	
	public void setSession(HttpServletRequest req) {
		
		
		HttpSession session = req.getSession();
		
		List<Product> listCart = new ArrayList<>();
		//List<Integer> listId = new ArrayList<>();
		
		session.setAttribute("sessionUserCart", listCart);
		session.setAttribute("isSessionCreated", true);
		System.out.println("Session créer");
	}
	
	public Object getSessionUserCart(HttpServletRequest req) {
		HttpSession session = req.getSession();
		return session.getAttribute("sessionUserCart");
	}
	
	public void updateSessionUserCart(HttpServletRequest req, Product product) {
		HttpSession session = req.getSession();
		//ProductService productService = new ProductServicelmpl();
		
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
			
		//return session.getAttribute("sessionUserCart");
	}
	
	public void removeProductFromCart(HttpServletRequest req, Product product) {
	  HttpSession session = req.getSession();
	  List<Product> listProduct =  (List<Product>) getSessionUserCart(req);
	  if (listProduct.contains(product)) {
	    listProduct.remove(product);
	    session.setAttribute("sessionUserCart", listProduct);
	  }
	}
	
	public Boolean isSessionCreated(HttpServletRequest req) {
		HttpSession session = req.getSession();
		return (Boolean) session.getAttribute("sessionUserCart");
	}
	
}
