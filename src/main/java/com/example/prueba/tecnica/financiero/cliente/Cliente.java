package com.example.prueba.tecnica.financiero.cliente;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.example.prueba.tecnica.financiero.tipoDocumento.TipoDocumento;

@Entity(name = "cliente")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	/* Persona natural */
	@Column(length = 80)
	private String nombre;

	@Column(length = 250)
	private String apellido;

	@Column(unique = true)
	private String num_documento;

	/* Persona juridica */
	@Column(length = 80)
	private String razon_social;
	
	@Column(length = 4,columnDefinition = "int default 0")
	private int anno_fundacion;
	
	@NotNull
	@Column(unique = true)
	private String rut;

	@ManyToOne
	@JoinColumn(name = "tipo_documento")
	private TipoDocumento tipoDocumento;

	@Column(columnDefinition = "boolean default true")
	private boolean blnNatural;

	public boolean isBlnNatural() {
		return blnNatural;
	}

	public void setBlnNatural(boolean blnNatural) {
		this.blnNatural = blnNatural;
	}

	public TipoDocumento getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(TipoDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNum_documento() {
		return num_documento;
	}

	public void setNum_documento(String num_documento) {
		this.num_documento = num_documento;
	}

	public String getRazon_social() {
		return razon_social;
	}

	public void setRazon_social(String razon_social) {
		this.razon_social = razon_social;
	}

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}
	
	public int getAnno_fundacion() {
		return anno_fundacion;
	}

	public void setAnno_fundacion(int anno_fundacion) {
		this.anno_fundacion = anno_fundacion;
	}

	public Cliente() {
		super();
	}

	public Cliente(String nombre, String apellido, String num_documento, String razon_social, String rut,
			TipoDocumento tipoDocumento,boolean blnNatural,int anno_fundacion) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.num_documento = num_documento;
		this.razon_social = razon_social;
		this.rut = rut;
		this.tipoDocumento = tipoDocumento;
		this.blnNatural = blnNatural;
		this.anno_fundacion = anno_fundacion;
	}

}
