package br.umc.remote;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import br.umc.dao.PersonDAO;
import br.umc.entity.Person;
import br.umc.io.factory.BufferedReaderFactory;

public class Client {
	public static void main(String... args) {
		try {
			PersonDAO dao = (PersonDAO) Naming.lookup("rmi://08LABS01:1023/person");
			final BufferedReader br = new BufferedReaderFactory().getBufferedReader();
			
	        System.out.println("Insira uma pessoa: ");
	        String name = br.readLine();
			final Person person = new Person();
			person.setName(name);
			
			System.out.println("Insira outra pessoa: ");
			String secondName = br.readLine();
			final Person second = new Person();
			second.setName(secondName);
			
			dao.add(person);
			dao.add(second);
									
			System.out.println("Consulte a pessoa pelo id: ");
			Long id = Long.valueOf(br.readLine());
			final Person otherPerson = dao.findById(id);
			
			System.out.println("Encontrado pelo id: ".concat(otherPerson.toString()));
		} catch (final MalformedURLException | RemoteException | NotBoundException e) {
			throw new RuntimeException(e);
		} catch(final IOException e) {
			throw new RuntimeException(e);
		}
	}
}