package com.relay2.hibernate;

import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.relay2.hibernate.entities.Account;
import com.relay2.hibernate.entities.Book;
import com.relay2.hibernate.service.BookService;
import com.relay2.hibernate.service.Cashier;

public class Main {

	public static void main(String[] args) throws Exception {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("application-hibernate.xml");
		
		SessionFactory sf = (SessionFactory) ctx.getBean("sessionFactory");
		
		System.out.println(sf);
		
		BookService bookService = (BookService) ctx.getBean("bookService");
		
		Account account = new Account();
		account.setName("Tom");
		account.setBalance(100.0);
		
		Book book = new Book();
		book.setName("java");
		book.setIsbn("book1");
		book.setCount(10);
		book.setPrice(60);
		
		bookService.createAccount(account);
		bookService.createBook(book);
		
		Cashier cashier = (Cashier) ctx.getBean("cashier");
		
		//bookService.buy("Tom", "book1", 2);
		cashier.buy("Tom", "book1", 2);
	}
	
}
