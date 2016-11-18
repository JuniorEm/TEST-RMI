package br.umc.dao;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;

import br.umc.entity.Person;

public interface PersonDAO extends Remote, Serializable {
	
	void add(final Person person) throws RemoteException;
	
	void remove(final Person person) throws RemoteException;
	
	void update(final Person person) throws RemoteException;
	
	Person findById(final Long id) throws RemoteException;
}
