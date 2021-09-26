package edu.isistan.torneo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Jugador extends Persona{

	
	//FIELDS

	@Column
	private int numero;
	@Column
	private String posicion;
	
	
	//CONSTRUCTORS
	
	public Jugador() {	}


	public Jugador(String nombre, int numero, String posicion) {
		super(nombre);
		this.numero = numero;
		this.posicion = posicion;
	}

	
	//METHODS
	
	//GETTERS & SETTERS

	public int getNumero() {
		return numero;
	}


	public void setNumero(int numero) {
		this.numero = numero;
	}


	public String getPosicion() {
		return posicion;
	}


	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}
	
}
