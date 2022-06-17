package com.example.prueba.tecnica.financiero.cliente;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, UUID> {
	
	public List<Cliente> findByRut(String rut);

}
