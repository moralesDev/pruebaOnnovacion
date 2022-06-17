package com.example.prueba.tecnica.financiero;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {
	
	@GetMapping("")
	public String paginaDefault() {
		return "index";
	}

}
