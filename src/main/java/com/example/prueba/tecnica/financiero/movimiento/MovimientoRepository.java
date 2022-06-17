package com.example.prueba.tecnica.financiero.movimiento;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MovimientoRepository extends JpaRepository<Movimiento, UUID> {

	public double valorLimitePeso = 1000000;
	public double valorLimiteDolar = 300;
	public double valorLimineEuro = 150;

	public List<Movimiento> findBycuenta_id(UUID cuenta);

	public static boolean calcularNuevoValor(double valorCuenta, double valorEntrante, int idTipoMoneda) {
		boolean permitir = false;
		switch (idTipoMoneda) {
		case 1: {
			if (valorCuenta + valorEntrante <= valorLimitePeso) {
				permitir = true;
				break;
			}

		}
		case 2: {
			if (valorCuenta + valorEntrante <= valorLimiteDolar) {
				permitir = true;
				break;
			}
		}
		case 3: {
			if (valorCuenta + valorEntrante <= valorLimineEuro) {
				permitir = true;
				break;
			}
		}
		default:
			return false;
		}

		return permitir;
	}

}
