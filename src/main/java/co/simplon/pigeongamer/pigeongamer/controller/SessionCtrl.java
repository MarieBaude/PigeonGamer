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
	}
	
	public Object getSessionUserCart(HttpServletRequest req) {
		HttpSession session = req.getSession();
		return session.getAttribute("sessionUserCart");
	}
	
	public Boolean isSessionCreated(HttpServletRequest req) {
		HttpSession session = req.getSession();
		return (Boolean) session.getAttribute("sessionUserCart");
	}
	
}
