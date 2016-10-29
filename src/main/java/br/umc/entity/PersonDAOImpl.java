package br.umc.entity;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import javax.persistence.EntityManager;

public class PersonDAOImpl implements PersonDAO {
	
	public PersonDAOImpl() throws RemoteException {
		UnicastRemoteObject.exportObject(this, 1099);
	}
	
	public void add(final Person person) throws RemoteException {
		EntityManager entityManager = new EntityManagerProducer().getEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(person);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	public void remove(final Person person) throws RemoteException {
		EntityManager entityManager = new EntityManagerProducer().getEntityManager();
		entityManager.getTransaction().begin();
		entityManager.refresh(person);
		entityManager.remove(person);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	public void update(final Person person) throws RemoteException {
		EntityManager entityManager = new EntityManagerProducer().getEntityManager();
		entityManager.getTransaction().begin();
		entityManager.merge(person);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	public Person findById(final Long id) throws RemoteException {
		EntityManager entityManager = new EntityManagerProducer().getEntityManager();
		entityManager.getTransaction().begin();
		final List<Person> result = entityManager.createQuery( "from Person", Person.class ).getResultList();
		
		for (Person selected : result) {
			if (id.equals(selected.getId())) {
				return selected;
			}
		}
		
		return null;
	}
	
	public Person findByName(final String name) throws RemoteException {
		EntityManager entityManager = new EntityManagerProducer().getEntityManager();
		entityManager.getTransaction().begin();
		final List<Person> result = entityManager.createQuery( "from Person", Person.class).getResultList();
		
		for (Person selected : result) {
			if (name.equals(selected.getName())) {
				return selected;
			}
		}
		return null;
	}
	

}
