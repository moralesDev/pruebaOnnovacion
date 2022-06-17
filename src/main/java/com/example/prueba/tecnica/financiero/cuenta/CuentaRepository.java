package com.example.prueba.tecnica.financiero.cuenta;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CuentaRepository extends JpaRepository<Cuenta, UUID> {
	

}
