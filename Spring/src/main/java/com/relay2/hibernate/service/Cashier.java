package com.relay2.hibernate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Cashier {

	@Autowired
	private BookService bookService;
	
	public void buy(String username, String isbn, int count) throws Exception{
		for(int i=0; i<count; i++){
			bookService.purche(username, isbn);
		}
	}
}
