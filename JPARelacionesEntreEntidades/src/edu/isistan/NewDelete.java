package edu.isistan;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import edu.isistan.dao.Persona;

public class NewDelete {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Example");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Persona j = em.find(Persona.class, 11);
		System.out.println(j);
		
		//DELETE ALL
		em.createQuery("DELETE FROM Persona p").executeUpdate();
		
		//DELETE PERSON
		
		//FORMA 1
		em.createQuery("DELETE FROM Persona p WHERE p.id = ?1")
								.setParameter(1, j.getId())
								.executeUpdate();
		//#finForma1
		
		//FORMA 2
		Query query = em.createQuery(
			      "DELETE FROM Persona p WHERE p.id = :personita");
		int deletedCount = query.setParameter("personita", 100000).executeUpdate();
		//#finForma2
		
		//FORMA 3
		deletePerson(j, em);
		//#finForma3
		em.getTransaction().commit();
		em.close();
		emf.close();
	}
	
	public static void deletePerson(Persona p, EntityManager em) {
		if (em.contains(p)) {
		em.remove(p);
		} else {
		em.merge(p);
		}
	}

}
