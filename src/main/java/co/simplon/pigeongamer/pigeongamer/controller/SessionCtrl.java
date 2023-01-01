package co.simplon.pigeongamer.pigeongamer.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionCtrl {
	public void setSession(HttpServletRequest req) {
		HttpSession session = req.getSession();
		
		List<Integer> listCart = new ArrayList<>();
		
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

		// Retrieve the list from the session
		List<Integer> list = (List<Integer>) getSessionUserCart(req);

		if (!list.contains(productId)) {
			list.add(productId);
			session.setAttribute("sessionUserCart", list);
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
