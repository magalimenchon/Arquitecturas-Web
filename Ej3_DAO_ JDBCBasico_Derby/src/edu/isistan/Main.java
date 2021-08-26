package edu.isistan;

import java.sql.SQLException;

import edu.isistan.dao.PersonaDAOImpl;
import edu.isistan.db.Persona;
import edu.isistan.interfaces.PersonaDAO;
import java.sql.ResultSet;

public class Main {

	public static void main(String[] args) {
		
		//CREACI�N INSTANCIA PERSONA
		Persona persona = new Persona(8, "Sasha", 31);
		
		//CREACI�N INSTANCIA L�GICA DE UNA PERSONA
		PersonaDAO dao = new PersonaDAOImpl();
		
		try {
			//CREACI�N de Tabla Persona
			//dao.createTable();
			
			//ALTA de Persona
			//dao.registrar(persona);
			
			//SELECT de Persona
			ResultSet rs = dao.read();
			//Recorre los resultados que retorn� la sentencia con un cursor
			while(rs.next()) {
				//Imprime cada resultado respetando que coincida:
				//Nro de columna con el tipo de ese atributo.
								//Persona.id-col1 //Persona.nombre-col2	//Persona.edad-col3
				System.out.println(rs.getInt(1)+", "+rs.getString(2)+", "+rs.getInt(3));
			}
			// Cerramos la conexi�n a la BD
			//this.cerrar();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
