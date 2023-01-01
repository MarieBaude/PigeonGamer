package co.simplon.pigeongamer.pigeongamer.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CartController {
	@PostMapping("/addToCart")
	public String addToCart(HttpServletRequest req) {
		SessionCtrl session = new SessionCtrl();
		System.out.println(":: list:" + session.getSessionUserCart(req));
		System.out.println(":: req:" + req.getParameter("idProduct"));
		
		// Retrieve the list from the session
		List<Integer> list = (List<Integer>) session.getSessionUserCart(req);
		int productId = Integer.parseInt(req.getParameter("idProduct"));
		
		
		if (!list.contains(productId)) {
			System.out.println("Session déjà créer");
			list.add(productId);
		}
		return "redirect:/";
	}
	
}
