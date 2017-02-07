package com.relay2.test;

public class Reader implements Runnable {
	
	private Data data;
	
	public Reader(Data data) {
		this.data = data;
	}
	
	@Override
	public void run() {
		while(true){
			String string = data.read();
			System.out.println(Thread.currentThread().getName() + "--->" + string);
		}
	}

}
