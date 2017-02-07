package com.relay2.test;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {

	ReentrantLock lock = new ReentrantLock();
	
	public void test() throws InterruptedException{
		lock.lock();
		System.out.println("begin test");
		Thread.sleep(5000);
		lock.unlock();
		System.out.println("end test");
	}
	
	public void test2() throws Exception {
		boolean b = lock.tryLock();
		System.out.println("test2 try lock: " + b);
		if(b){
			System.out.println("begin test2");
			Thread.sleep(2000);
			lock.unlock();
			System.out.println("end test2");
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		final ReentrantLockTest t = new ReentrantLockTest();
		
		new Thread(){
			public void run() {
				try {
					t.test2();
				} catch (Exception e) {
					e.printStackTrace();
				}
			};
		}.start();

		new Thread(){
			public void run() {
				try {
					t.test();
				} catch (Exception e) {
					e.printStackTrace();
				}
			};
		}.start();

	}
	
}
