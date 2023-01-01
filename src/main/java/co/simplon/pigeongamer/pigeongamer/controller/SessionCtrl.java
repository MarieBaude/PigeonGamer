package co.simplon.pigeongamer.pigeongamer.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionCtrl {
	public void setSession(HttpServletRequest req) {
		HttpSession session = req.getSession();
		session.setAttribute("sessionUserCart", "totoCart");
	}
	
	public Object getSessionUserCart(HttpServletRequest req) {
		HttpSession session = req.getSession();
		return session.getAttribute("sessionUserCart");
	}
	
}
