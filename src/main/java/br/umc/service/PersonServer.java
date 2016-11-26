package br.umc.service;

import javax.jws.WebService;
import javax.xml.ws.Endpoint;

@WebService(endpointInterface = "br.umc.service.PersonService")
public class PersonServer {
	public static void main(String[] args) {
	      Endpoint.publish("http://10.51.11.8:991/person", new PersonServiceImpl());
	}
}
