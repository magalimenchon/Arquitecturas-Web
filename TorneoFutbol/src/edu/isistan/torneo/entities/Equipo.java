package edu.isistan.torneo.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
@Entity
public class Equipo {

	
	//FIELDS
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column
	private String nombre;
	@OneToOne
	private Persona dt;
	@OneToMany
	@JoinTable(name = "Titulares")
	private List<Jugador> titulares;
	@OneToMany
	@JoinTable(name = "Suplentes")
	private List<Jugador> suplentes;
	
	
	//CONSTRUCTORS
	
	public Equipo() {	}


	public Equipo(String nombre, Persona dt) {
		super();
		this.nombre = nombre;
		this.dt = dt;
		this.titulares = new ArrayList<>();
		this.suplentes = new ArrayList<>();
	}

	
	//METHODS
	
	//GETTERS & SETTERS

	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Persona getDt() {
		return dt;
	}


	public void setDt(Persona dt) {
		this.dt = dt;
	}


	public int getId() {
		return id;
	}


	public List<Jugador> getTitulares() {
		return titulares;
	}


	public List<Jugador> getSuplentes() {
		return suplentes;
	}
	
	
}
