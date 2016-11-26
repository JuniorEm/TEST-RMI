package br.umc.remote;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import br.umc.dao.GenericDAO;
import br.umc.dao.PersonDAO;
import br.umc.entity.Person;

public class PersonDAOImpl implements PersonDAO, Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private GenericDAO<Person, Long> generic;
	
	public PersonDAOImpl() throws RemoteException {
		UnicastRemoteObject.exportObject(this, 1023);
		generic = new GenericDAO<>(Person.class);
	}
	
	public void add(final Person person) throws RemoteException {
		generic.add(person);
	}

	@Override
	public void remove(Person person) throws RemoteException {
		generic.remove(person);
	}

	@Override
	public void update(Person person) throws RemoteException {
		generic.update(person);	
	}

	@Override
	public Person findById(Long id) throws RemoteException {
		return generic.obtain(id);
	}
	
	@Override
	public List<Person> findAll() throws RemoteException {
		return generic.obtainAll();
	}
}
