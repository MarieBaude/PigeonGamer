package co.simplon.pigeongamer.pigeongamer.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CartController {
	@PostMapping("/addToCart")
	public String addToCart(HttpServletRequest req) {
		SessionCtrl session = new SessionCtrl();
		System.out.println(":: fcvhg:" + session.getSessionUserCart(req));
		//System.out.println(":: req:" + req);
		if(session.getSessionUserCart(req) == null) {
			session.setSession(req);
		} else {
			System.out.println("t nul");
		}
		return "index";
	}
	
}
