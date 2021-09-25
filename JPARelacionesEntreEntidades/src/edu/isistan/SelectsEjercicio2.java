package edu.isistan;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import edu.isistan.dao.Persona;
import edu.isistan.dao.Turno;

public class SelectsEjercicio2 {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Example");
		EntityManager em = emf.createEntityManager();
		//a) recuperar todas las personas asignadas a un turno.
		ejercicioA(em);
		//b) recuperar todas las personas asignadas a un turno, y marcar cuales de ellas son socios.
		ejercicioB(em);
		//c) recuperar todas las personas que viven en una ciudad predeterminada.
		ejercicioC(em);
		emf.close();
	}
	
	//a) recuperar todas las personas asignadas a un turno.
	public static void ejercicioA(EntityManager em) {
		em.getTransaction().begin();
		int idTurnoBuscado = 1;
		Turno turnoBuscado = em.find(Turno.class, idTurnoBuscado);
		@SuppressWarnings("unchecked")
		List<Persona> personas = em.createQuery("SELECT p FROM Persona p JOIN Turno WHERE t.id = ?1")
												.setParameter(1, turnoBuscado.getId()).getResultList();
		personas.forEach(p -> System.out.println(p));
		
		em.getTransaction().commit();
		em.close();
		//emf.close();
	}
	
	//b) recuperar todas las personas asignadas a un turno, y marcar cuales de ellas son socios.
	public static void ejercicioB(EntityManager em) {
		em.getTransaction().begin();
		
		int idTurnoBuscado = 1;
		Turno turnoBuscado = em.find(Turno.class, idTurnoBuscado);
		@SuppressWarnings("unchecked")
		List<Persona> personas = em.createQuery("SELECT p FROM Persona p JOIN Turno WHERE t.id = ?1"
												+ "	JOIN Socio s ON p.id = s.id")
												.setParameter(1, turnoBuscado.getId()).getResultList();
		personas.forEach(p -> System.out.println(p));
		
		em.getTransaction().commit();
		em.close();
		//emf.close();
	}
	
	//c) recuperar todas las personas que viven en una ciudad predeterminada.
	public static void ejercicioC(EntityManager em) {
		em.getTransaction().begin();
		
		String ciudad = "Tandil";
		Turno ciudadBuscada = em.find(Turno.class, ciudad);
		@SuppressWarnings("unchecked")
		List<Persona> personas = em.createQuery("SELECT p FROM Persona p JOIN Direccion d WHERE d.ciudad = ?1")
												.setParameter(1, ciudadBuscada).getResultList();
		personas.forEach(p -> System.out.println(p));
		
		em.getTransaction().commit();
		em.close();
		//emf.close();
	}

}
