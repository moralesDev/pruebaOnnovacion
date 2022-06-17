package com.example.prueba.tecnica.financiero.movimiento;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;

import com.example.prueba.tecnica.financiero.cuenta.Cuenta;
import com.example.prueba.tecnica.financiero.moneda.Moneda;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "movimiento")
public class Movimiento {

	@Id
	@GeneratedValue
	@Type(type = "uuid-char")
	private UUID id;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "tipo_moneda")
	private Moneda moneda;

	@NotNull
	@Column
	private double saldo;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_cuenta")
	@JsonBackReference
	private Cuenta cuenta;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public Moneda getMoneda() {
		return moneda;
	}

	public void setMoneda(Moneda moneda) {
		this.moneda = moneda;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public Cuenta getCuenta() {
		return cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}

	public Movimiento() {
		super();
	}

	public Movimiento(@NotNull Moneda moneda, @NotNull double saldo, @NotNull Cuenta cuenta) {
		super();
		this.moneda = moneda;
		this.saldo = saldo;
		this.cuenta = cuenta;
	}

}
