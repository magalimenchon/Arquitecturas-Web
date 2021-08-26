package edu.isistan.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Direccion {

	
//FIELDS

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@Column
	private String ciudad;
	@Column
	private String calle;
	
	
//CONSTRUCTORS
	
	public Direccion() {
		super();
	}
	
	public Direccion(String ciudad, String calle) {
		super();
		this.ciudad = ciudad;
		this.calle = calle;
	}

	
//METHODS
	
//GETTERS & SETTERS

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public int getId() {
		return id;
	}

//OVERRIDES
	
	@Override
	public String toString() {
		return "Direccion [id=" + id + ", ciudad=" + ciudad + ", calle=" + calle + "]";
	}
	
}
