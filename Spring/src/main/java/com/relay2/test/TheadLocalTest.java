package com.relay2.test;

public class TheadLocalTest {

	public static void main(String[] args) {
		
		for(int i=0; i<3; i++){
			new Thread(new Request()).start();
		}
		
	}
}
class GenerateId{
	static ThreadLocal<Integer> local = new ThreadLocal<Integer>(){
		@Override
		protected Integer initialValue() {
			return null;
		}
	};
	
	public static int getId(){
		Integer integer = local.get();
		if(null == integer){
			integer = 0;
		}
		local.set(++integer);
		return --integer;
	}
}

class Request implements Runnable {
	int step;
	public void run() {
		while(step++ < 3){
		System.out.println(Thread.currentThread().getName()+"==>" + GenerateId.getId());
		}
	}
}
