package com.example.prueba.tecnica.financiero.cuenta;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;

import com.example.prueba.tecnica.financiero.cliente.Cliente;
import com.example.prueba.tecnica.financiero.moneda.Moneda;

@Entity
@Table(name = "cuenta")
public class Cuenta {

	@Id
	@GeneratedValue
	@Type(type = "uuid-char")
	private UUID id;

	@NotNull
	@NotBlank(message = "El numero de cuenta es obligatorio")
	@Column(unique = true)
	private String num_cuenta;

	@ManyToOne
	@JoinColumn(name = "tipo_moneda")
	private Moneda moneda;

	@Column(columnDefinition = "double default 0")
	private double saldo;

	@ManyToOne
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getNum_cuenta() {
		return num_cuenta;
	}

	public void setNum_cuenta(String num_cuenta) {
		this.num_cuenta = num_cuenta;
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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Cuenta() {
		super();
	}

	public Cuenta(@NotNull @NotBlank(message = "El numero de cuenta es obligatorio") String num_cuenta, Moneda moneda,
			Cliente cliente, double saldo) {
		super();
		this.num_cuenta = num_cuenta;
		this.moneda = moneda;
		this.saldo = saldo;
		this.cliente = cliente;
	}

}
