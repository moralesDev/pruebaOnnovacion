package com.example.prueba.tecnica.financiero.cliente;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
	
	public List<Cliente> findByRut(String rut);

}
