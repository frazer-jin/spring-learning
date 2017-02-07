package com.relay2.lock;

public class Main {

	public static void main(String[] args) throws Exception {
		
		final Producer p = new Producer();
		final Consumer c = new Consumer(p);
		
		// producer thread
		new Thread(p).start();
		Thread.sleep(6000);
		
		// consumer
		new Thread(c).start();
	}
	
}
