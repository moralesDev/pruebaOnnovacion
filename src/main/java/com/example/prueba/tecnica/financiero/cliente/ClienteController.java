package com.example.prueba.tecnica.financiero.cliente;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.prueba.tecnica.financiero.error.ErrorMessage;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteRepository repo;
	
	@GetMapping("/listar")
	private List<Cliente> getClientes(){
		return repo.findAll();
	}
	
	@PostMapping("/guardar")
	private ResponseEntity<?> guardarCliente(@Valid @RequestBody Cliente cliente) {
		ErrorMessage errorMessage = new ErrorMessage();
		if(!cliente.getRut().isEmpty()) {
			List<Cliente> list = repo.findByRut(cliente.getRut());
			if(list.isEmpty()) {
				repo.save(cliente);
				return new ResponseEntity<Cliente>(cliente,HttpStatus.OK);
			}
		}else {
			errorMessage.setError("El campo RUT esta vacio.");			
			return new ResponseEntity<ErrorMessage>(errorMessage,HttpStatus.OK);
		}
		errorMessage.setError("Ya existe el cliente con el RUT ingresado.");	
		return new ResponseEntity<ErrorMessage>(errorMessage,HttpStatus.OK);
	}

}
