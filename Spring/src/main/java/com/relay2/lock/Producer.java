package com.relay2.lock;

import java.util.ArrayList;
import java.util.List;

public class Producer implements Runnable{

	private List<String> list = new ArrayList<>(10);
	
	public String deliver(){
		if(list.size()==0){
			try {
				System.out.println("no product, wait");
				synchronized (this) {
					wait();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		String object = list.remove(list.size()-1);
		System.out.println("deliver product, rest: " + list.size());
		synchronized (this) {
			notify();
		}
		return object;
	}
	
	private void generate(){
		while(true){
			if(list.size() > 10){
				try {
					System.out.println("product full, wait");
					synchronized (this) {
						wait();
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			list.add(list.size()+"");
			System.out.println("generate product: " + list.size());
			synchronized (this) {
				notify();
			}
		}
	}

	@Override
	public void run() {
		this.generate();
	}
}
