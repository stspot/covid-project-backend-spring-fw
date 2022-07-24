package projectC.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class HomeController {

	@GetMapping("/")
	public String hello() {
		return this.welcomeMessage();
	}
	
	private String welcomeMessage() {
		String msg = String.format("<h1>Welcome</h1>%n<h2>Links:</h2>%n1. Common Information for Covid -> http://localhost:81/common-information/all");
		return msg;
	}
}

