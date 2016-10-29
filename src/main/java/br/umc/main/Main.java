package br.umc.main;

import java.rmi.RemoteException;

import br.umc.entity.Person;
import br.umc.entity.PersonDAOImpl;

public class Main {
	public static void main(String[] args) throws RemoteException {
		PersonDAOImpl personDAO = new PersonDAOImpl();
		Person p = new Person();
		p.setName("ASA");
		personDAO.add(p);
		
	}
}
