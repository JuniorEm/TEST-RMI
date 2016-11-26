package br.umc.service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import br.umc.entity.Person;

@WebService
public interface PersonService {
	
	@WebMethod String findAll();
}
