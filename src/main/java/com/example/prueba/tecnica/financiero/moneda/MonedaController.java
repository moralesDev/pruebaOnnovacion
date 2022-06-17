package com.example.prueba.tecnica.financiero.moneda;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("moneda")
public class MonedaController {
	
	@Autowired
	private MonedaRepository repo;
	
	@GetMapping
	private List<Moneda> getMonedas(){
		return repo.findAll();
	}

}
