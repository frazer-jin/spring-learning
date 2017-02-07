package com.relay2.hibernate.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.relay2.hibernate.entities.Account;
import com.relay2.hibernate.entities.Book;

@Repository
public class BookDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	public int findBookPriceByIsbn(String isbn){
		String queryString = "select b.price from Book b where b.isbn = ? ";
		Query query = getSession().createQuery(queryString).setString(0, isbn);
		return (int) query.uniqueResult();
	}

	public int insertAccount(Account account) {
		getSession().save(account);
		return account.getId();
	}
	
	public int insertBook(Book book) {
		getSession().save(book);
		return book.getId();
	}
	
	public void updateBook(String isbn) throws Exception {
		String hql = "select b.count from Book b where b.isbn = ?";
		int count = (int) getSession().createQuery(hql).setString(0, isbn).uniqueResult();
		if(count ==0){
			throw new RuntimeException("库存不足");
		}
		hql = "update Book b set b.count = b.count - ? where b.isbn = ?";
		getSession().createQuery(hql).setInteger(0, 1).setString(1, isbn).executeUpdate();
	}
	
	public void updateUserAccount(String username, int money) throws Exception{
		// validate balance
		String hql = "select a.balance from Account a where name = ?";
		int balance = ((Double) getSession().createQuery(hql).setString(0, username).uniqueResult()).intValue();
		if(balance < money){
			throw new RuntimeException("余额不足");
		}
		
		hql = "update Account a set a.balance = a.balance - ? where name = ?";
		getSession().createQuery(hql).setInteger(0, money).setString(1, username).executeUpdate();
	}
}
