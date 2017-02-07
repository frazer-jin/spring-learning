package com.relay2.test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.springframework.util.Assert;

public class Data {
	
	private ReadWriteLock lock = new ReentrantReadWriteLock(true);
	Lock readLock = lock.readLock();
	Lock writeLock = lock.writeLock();

	private char[] buffer;

	public Data(int size) {
		initBuffer(size);
	}

	private void initBuffer(int size) {
		Assert.isTrue(size > 0);
		buffer = new char[size];
		for(int i=0; i<buffer.length; i++){
			buffer[i] = '*';
		}
	}
	
	public String read(){
		readLock.lock();
		try{
			StringBuilder sb = new StringBuilder();
			for(char c : buffer){
				sb.append(c);
			}
			sleep();
			return sb.toString();
		}finally{
			readLock.unlock();
		}
	}
	
	public void write(char c){
		writeLock.lock();
		try{
			for(int i=0, j=buffer.length; i<j; i++){
				buffer[i] = c;
				sleep();
			}
		}finally{
			writeLock.unlock();
		}
	}
	
	private void sleep(){
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
