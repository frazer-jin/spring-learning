package com.relay2.oxm;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.springframework.oxm.Marshaller;
import org.springframework.oxm.Unmarshaller;
import org.springframework.oxm.XmlMappingException;

public class Service {
	
	private static final String userFile = "output/user.xml";
	
	private static final String usersFile = "output/users.xml";
	
	private Marshaller marshaller;
	
	private Unmarshaller unmarshaller;
	
	public void setMarshaller(Marshaller marshaller) {
		this.marshaller = marshaller;
	}
	
	public void setUnmarshaller(Unmarshaller unmarshaller) {
		this.unmarshaller = unmarshaller;
	}
	
	public void saveUser(User user) throws Exception{
		
		Result result = null;
		
		FileOutputStream fos = new FileOutputStream(userFile);
		
		result = new StreamResult(fos);
		
		marshaller.marshal(user, result);
	}
	
	public User loadUser() throws Exception{
		
		FileInputStream fis = new FileInputStream(userFile);
		
		User user= (User) unmarshaller.unmarshal(new StreamSource(fis));
		
		return user;
	}
	
	public void saveUsers(List<User> users) throws Exception{
		Result result = null;
		
		FileOutputStream fos = new FileOutputStream(usersFile);
		
		result = new StreamResult(fos);
		
		marshaller.marshal(users, result);
	}
	
	public List<User> loadUsers() throws Exception{
		
		FileInputStream fis = new FileInputStream(usersFile);
		
		List<User> users= (List<User>) unmarshaller.unmarshal(new StreamSource(fis));
		
		return users;
	}
	
}
