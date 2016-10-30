package br.umc.remote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import br.umc.dao.GenericDAO;
import br.umc.dao.PersonDAO;
import br.umc.entity.Person;

public class PersonDAOImpl implements PersonDAO {
	
	private GenericDAO<Person, Long> generic;
	
	public PersonDAOImpl() throws RemoteException {
		UnicastRemoteObject.exportObject(this, 1099);
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
}
