package com.example.prueba.tecnica.financiero.moneda;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "tipo_moneda")
public class Moneda {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	private String tipo_moneda;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTipo_moneda() {
		return tipo_moneda;
	}

	public void setTipo_moneda(String tipo_moneda) {
		this.tipo_moneda = tipo_moneda;
	}
	
	

}
