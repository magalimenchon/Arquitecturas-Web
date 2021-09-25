package edu.isistan;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import edu.isistan.dao.Direccion;
import edu.isistan.dao.Persona;

public class Insert {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Example");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Direccion d = new Direccion("Tandil", "Sarmiento 772");
		em.persist(d);
		Persona j = new Persona(11, "Juan", 25, d);
		Persona a = new Persona(2, "Ana", 22, d);
		em.persist(j);
		em.persist(a);
		em.getTransaction().commit();
		em.close();
		emf.close();
	}

}
