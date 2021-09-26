package edu.isistan.torneo.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Torneo {

	
	//FIELDS
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column
	private String nombre;
	@ManyToMany
	private List<Equipo> participantes;
	
	
	//CONSTRUCTORS
	
	public Torneo() {	}

	
	public Torneo(String nombre) {
		super();
		this.nombre = nombre;
		this.participantes = new ArrayList<>();
	}

	
	//METHODS
	
	//GETTERS & SETTERS
	
	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public int getId() {
		return id;
	}


	public List<Equipo> getParticipantes() {
		return participantes;
	}

	
	//OVERRIDES
	
	@Override
	public String toString() {
		return "Torneo [id=" + id + ", nombre=" + nombre + ", participantes=" + participantes + "]";
	}
}
