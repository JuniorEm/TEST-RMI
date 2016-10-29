package br.umc.entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerProducer {
	
	public EntityManagerProducer() {}
	
	public EntityManager getEntityManager() {
		return Persistence.
				createEntityManagerFactory("my-persistence")
				.createEntityManager();
	}
}
