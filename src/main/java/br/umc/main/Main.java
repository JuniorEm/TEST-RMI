package br.umc.main;

import java.io.BufferedReader;
import java.io.IOException;

import br.umc.entity.Person;
import br.umc.io.factory.BufferedReaderFactory;
import br.umc.remote.PersonDAOImpl;

public class Main {
	public static void main(String[] args) throws IOException {
		final BufferedReader br = new BufferedReaderFactory().getBufferedReader();
		PersonDAOImpl dao = new PersonDAOImpl();
		
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
	}
}
