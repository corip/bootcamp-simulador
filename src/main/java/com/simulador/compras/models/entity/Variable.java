package com.simulador.compras.models.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="variables")
public class Variable implements Serializable {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	private String identificador;
	
	private String valor;
	
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getIdentificador() {
		return identificador;
	}


	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}



	public String getValor() {
		return valor;
	}


	public void setValor(String valor) {
		this.valor = valor;
	}





	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
