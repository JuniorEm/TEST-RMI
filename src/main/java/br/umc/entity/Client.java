package br.umc.entity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.rmi.Naming;
import java.rmi.NotBoundException;

public class Client {
	public static void main(String[] args) throws IOException, NotBoundException {
		InputStream is = System.in;
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		
		
        PersonDAO dao = (PersonDAO) Naming.lookup("rmi://127.1.1.1/person");
        
        System.out.println("Inserção de dois caras: ");
        
        String name = br.readLine();
		final Person person = new Person();
		person.setName(name);
		
		String secondName = br.readLine();
		final Person second = new Person();
		second.setName(secondName);
		
		dao.add(person);
		dao.add(second);
		
		System.out.println("Consulte o cara pelo nome: ");
		String nameForSearch = br.readLine();
		final Person obtained = dao.findByName(nameForSearch);
		
		System.out.println(obtained);
	}
}
