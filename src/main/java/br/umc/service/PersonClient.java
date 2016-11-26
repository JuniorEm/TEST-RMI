package br.umc.service;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import br.umc.entity.Person;

public class PersonClient {
	public static void main(String[] args) throws MalformedURLException {
		
		URL url = new URL("http://10.51.11.8:991/person?wsdl");
		QName qname = new QName("http://service.umc.br/","PersonServiceImplService");
		
		Service service = Service.create(url, qname);
		final PersonService port = service.getPort(PersonService.class);
		System.out.println(port.findAll());
	}
}
