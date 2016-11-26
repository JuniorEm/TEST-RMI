package br.umc.service;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import javax.jws.WebService;
import javax.xml.ws.Endpoint;

import br.umc.remote.PersonDAOImpl;

@WebService(endpointInterface = "br.umc.service.PersonService")
public class PersonServer {
	public static void main(String[] args) {
	      Endpoint.publish("http://10.51.11.8:991/person", new PersonServiceImpl());
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
