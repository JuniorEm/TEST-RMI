package br.umc.entity;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface PersonDAO extends Remote {
	
	void add(final Person person) throws RemoteException;
	
	void remove(final Person person) throws RemoteException;
	
	void update(final Person person) throws RemoteException;
	
	Person findById(final Long id) throws RemoteException;
	
	Person findByName(final String name) throws RemoteException;
}
