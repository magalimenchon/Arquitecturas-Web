package edu.isistan.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import edu.isistan.db.Persona;
import edu.isistan.interfaces.PersonaDAO;

public class PersonaDAOImpl extends Conexion implements PersonaDAO {

	@Override
	public void registrar(Persona persona) throws SQLException {
		// Abro conexi�n a la BD
		this.conectar();
		// Define la sentencia
		String insert = "INSERT INTO persona (id, nombre, edad) VALUES (?, ?, ?)";
		// Prepara la sentencia de inserci�n
		PreparedStatement ps = this.conn.prepareStatement(insert);
		// Setea valores de los placeholders
		ps.setInt(1, persona.getId());
		ps.setString(2, persona.getNombre());
		ps.setInt(3, persona.getEdad());
		// Ejecutamos el insert
		ps.executeUpdate();
		// Cerramos la preparaci�n de la sentencia (No es necesario)
		ps.close();
		// Commitea la sentencia
		this.conn.commit();
		// Cerramos la conexi�n
		this.cerrar();

	}

	@Override
	public void update(Persona persona) throws SQLException {
		// Abro conexi�n a la BD
		this.conectar();
		// Define la sentencia de actualizaci�n de registro
		String update = "UPDATE persona WHERE id = ?";
		// Prepara la sentencia
		PreparedStatement ps = this.conn.prepareStatement(update);
		// Setea valores del placeholder
		ps.setInt(1, persona.getId());
		// Ejecutamos el update
		ps.executeUpdate();
		// Cerramos la preparaci�n de la sentencia (No es necesario)
		ps.close();
		// Commitea la sentencia
		this.conn.commit();
		// Cerramos la conexi�n a la BD
		this.cerrar();

	}

	@Override
	public void delete(Persona persona) throws SQLException {
		// Abro conexi�n a la BD
		this.conectar();
		// Define la sentencia de actualizaci�n de registro
		String delete = "DELETE FROM persona WHERE id = ?";
		// Prepara la sentencia
		PreparedStatement ps = this.conn.prepareStatement(delete);
		// Setea valores del placeholder
		ps.setInt(1, persona.getId());
		// Ejecutamos el delete
		ps.executeUpdate();
		// Cerramos la preparaci�n de la sentencia (No es necesario)
		ps.close();
		// Commitea la sentencia
		this.conn.commit();
		// Cerramos la conexi�n a la BD
		this.cerrar();

	}

	// HACER UN SELECT

	@Override
	public ResultSet read() throws SQLException {
		// Abro conexi�n a la BD
		this.conectar();
		// Define la sentencia de selecci�n
		String select = "SELECT * FROM persona";
		// Prepara la sentencia de selecci�n
		PreparedStatement ps = this.conn.prepareStatement(select);
		// Ejecuta la sentencia y almacena en una variable
		// el conjunto de resultados obtenidos
		ResultSet rs = ps.executeQuery();
		// Cerramos la conexi�n a la BD
		/*this.cerrar();*/
		// Retorno el resultado obtenido
		return rs;
	}

	@Override
	public void createTable() throws SQLException {
		// Abro conexi�n a la BD
		this.conectar();
		// Creo la tabla
		String table = "CREATE TABLE persona(" + "id INT," + "nombre VARCHAR(500)," + "edad INT," + "PRIMARY KEY(id))";
		// Prepara la sentencia de creaci�n y la ejecuta
		PreparedStatement ps = this.conn.prepareStatement(table);
		ps.execute();
		//this.conn.prepareStatement(table).execute();
		// Commitea la sentencia
		this.conn.commit();
		// Cerramos la conexi�n a la BD
		this.cerrar();

	}

}
