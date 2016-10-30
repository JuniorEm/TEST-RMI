package br.umc.data;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerProducer {
	private EntityManagerFactory emf;
	private EntityManager em;
	
	public EntityManagerProducer() {
		emf = Persistence.createEntityManagerFactory("my-persistence");
	}
		
	public EntityManager getEntityManager() {
		em = emf.createEntityManager();
		return em;
	}
	
	public void closeEntityManager() {
		em.close();
	}
	
	public void closeEntityManagerFactory() {
		emf.close();
	}
}
