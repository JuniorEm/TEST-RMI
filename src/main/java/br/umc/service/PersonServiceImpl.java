package br.umc.service;

import java.util.List;

import javax.jws.WebService;

import br.umc.dao.GenericDAO;
import br.umc.entity.Person;

@WebService(endpointInterface = "br.umc.service.PersonService")
public class PersonServiceImpl implements PersonService {
	
	private GenericDAO<Person, Long> generic = new GenericDAO(Person.class);
	
	@Override
	public String findAll() {
		final List<Person> obtainAll = generic.obtainAll();
		
		final StringBuilder builder = new StringBuilder();
		
		for (Person person : obtainAll) {
			builder.append("\n".concat(person.toString()));
		}
		
		return builder.toString();
	}

}
