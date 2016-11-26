package br.umc.remote;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class Server {
	public static void main(String... args) {
		try {
			LocateRegistry.createRegistry(1023);
			PersonDAOImpl remote = new PersonDAOImpl();
			Naming.rebind("rmi://10.51.11.8:1023/person", remote);
			System.err.println("Server RUNNING ");
		} catch (final RemoteException | MalformedURLException e) {
			throw new RuntimeException(e);
		}

	}
}
