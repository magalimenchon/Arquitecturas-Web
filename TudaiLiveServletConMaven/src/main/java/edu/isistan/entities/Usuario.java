package edu.isistan.entities;

public class Usuario {

	//FIELDS
	
	private int id;
	private String name;
	private String surname;
	
	
	//CONSTRUCTORS
	
	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Usuario(int id, String name, String surname) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
	}

	
	//GETTERS & SETTERS
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	
	//OVERRIDES
	
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", name=" + name + ", surname=" + surname + "]";
	}

	
}
