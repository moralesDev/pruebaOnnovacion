package com.example.prueba.tecnica.financiero.movimiento;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.prueba.tecnica.financiero.cuenta.Cuenta;
import com.example.prueba.tecnica.financiero.cuenta.CuentaRepository;
import com.example.prueba.tecnica.financiero.error.ErrorMessage;

@RestController
@RequestMapping("/movimiento")
public class MovimientoController {
	
	@Autowired
	private MovimientoRepository repo;
	
	@Autowired
	private CuentaRepository cuentaRepo;
	
	@GetMapping
	private List<Movimiento> getMovimientos(){
		return repo.findAll();
	}
	
	@PostMapping
	private ResponseEntity<?> guardarMovimiento(@Valid @RequestBody Movimiento movimiento){
		ErrorMessage errorMessage = new ErrorMessage();
		Optional<Cuenta> cuenta = cuentaRepo.findById(movimiento.getCuenta().getId());
		if(cuenta.isPresent()) {
			if(cuenta.get().getMoneda().getId() == movimiento.getMoneda().getId()) {
				if(MovimientoRepository.calcularNuevoValor(cuenta.get().getSaldo(),movimiento.getSaldo(),movimiento.getMoneda().getId())) {
					repo.save(movimiento);
					return new ResponseEntity<Movimiento>(movimiento,HttpStatus.OK);
				}else {
					errorMessage.setError("El valor supera el límite de la cuenta.");
				}
			}else {
				errorMessage.setError("El tipo de moneda del movimiento es diferente al de la cuenta.");
			}
		}else {
			errorMessage.setError("No existe la cuenta a asociar al movimiento.");
		}
		return new ResponseEntity<ErrorMessage>(errorMessage,HttpStatus.OK);
	}
	

}
