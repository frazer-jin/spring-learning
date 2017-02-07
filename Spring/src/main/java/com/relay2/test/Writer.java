package com.relay2.test;

public class Writer implements Runnable {
	
	private Data data;
	private String message;

	public Writer(Data data, String message) {
		this.data = data;
		this.message = message;
		
	}
	
	@Override
	public void run() {
		while(true)
		for(int i=0, j=message.length(); i < j; i++){
			char c = message.charAt(i);
			data.write(c);
		}
	}

}
