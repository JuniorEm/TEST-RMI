package br.umc.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.umc.data.EntityManagerProducer;

public class GenericDAO<T, K extends Serializable> {
	private Class<T> type;
	
	public GenericDAO(final Class<T> type) {
		this.type = type;
	}
	
	private void begin(final EntityManager em) {
		em.getTransaction().begin();
	}
	
	private void commit(final EntityManager em) {
		em.getTransaction().commit();
	}
	
	private void close(final EntityManager em) {
		if (em.isOpen()) {
			em.close();
		}
	}
	
	public void add(final T t) {
		final EntityManager entityManager = getInstance();
		begin(entityManager);
		entityManager.persist(t);
		commit(entityManager);
		close(entityManager);
	}
	
	public void update(final T t) {
		final EntityManager entityManager = getInstance();
		begin(entityManager);
		entityManager.merge(t);
		commit(entityManager);
		close(entityManager);
	}
	
	public void remove(final T t) {
		final EntityManager entityManager = getInstance();
		begin(entityManager);
		entityManager.remove(t);
		commit(entityManager);
		close(entityManager);
	}
	
	@SuppressWarnings("unchecked")
	public T obtain(final K k) {
		final EntityManager entityManager = getInstance();
		final T predicate = (T) entityManager.createQuery("SELECT x from ".concat(type.getSimpleName()).concat(" x")
				.concat(" WHERE x.id = :id"))
				.setParameter("id", k)
				.getSingleResult();
		
		return predicate;
	}
	
	private EntityManager getInstance() {
		return new EntityManagerProducer().getEntityManager();
	}
}
