package com.example.prueba.tecnica.financiero.cuenta;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.prueba.tecnica.financiero.cliente.Cliente;
import com.example.prueba.tecnica.financiero.cliente.ClienteRepository;
import com.example.prueba.tecnica.financiero.error.ErrorMessage;

@RestController
@RequestMapping("/cuenta")
public class CuentaController {
	
	@Autowired
	private CuentaRepository repo;
	
	@Autowired
	private ClienteRepository repoCliente;
	
	@GetMapping("/listar")
	private List<Cuenta> getCuentas(){
		return repo.findAll();
	}
	
	@PostMapping("/guardar")
	private ResponseEntity<?> guardarCuenta(@Valid @RequestBody Cuenta cuenta){
		
		
		repo.save(cuenta);
		return new ResponseEntity<Cuenta>(cuenta, HttpStatus.OK);
		
	}
}
