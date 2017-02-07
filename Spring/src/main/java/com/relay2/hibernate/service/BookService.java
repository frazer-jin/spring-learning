package com.relay2.hibernate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.relay2.hibernate.dao.BookDao;
import com.relay2.hibernate.entities.Account;
import com.relay2.hibernate.entities.Book;

@Service
public class BookService {

	@Autowired
	private BookDao bookDao;
	
	public void purche(String username, String isbn) throws Exception {
		
		int price = bookDao.findBookPriceByIsbn(isbn);
		bookDao.updateBook(isbn);
		bookDao.updateUserAccount(username, price);
	}
	
	public void buy(String username, String isbn, int count) throws Exception{
		for(int i=0; i<count; i++){
			this.purche(username, isbn);
		}
	}
	
	public void createBook(Book book){
		bookDao.insertBook(book);
	}
	
	public void createAccount(Account account){
		bookDao.insertAccount(account);
	}
	
}
