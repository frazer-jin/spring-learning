package com.relay2.test;

public class Main {

	public static void main(String[] args) {
//		String str = "abc";
//		
//		System.out.println(str.split(",").length);
//		
//		Data data = new Data(10);
//		
//		data.write('云');
//		str = data.read();
//		
//		System.out.println(str);
		
//		new Thread(new Reader(data)).start();
//		new Thread(new Reader(data)).start();
//		new Thread(new Reader(data)).start();
//		new Thread(new Reader(data)).start();
//		new Thread(new Reader(data)).start();
//		
//		new Thread(new Writer(data, "ABC")).start();
		
//		for(int i=0; i<100; i++){
//		    System.out.println(ThreadLocalRandom.current().nextInt(1025, 65566));
//		}
//		int t = 2;
//		do{
//		    System.out.println("do...");
//		}while(--t>0);
	    
	    String DEFAULT_PASSWORD_ALGORITHM = "{SHA}";
	    String passwdAlgorithm = DEFAULT_PASSWORD_ALGORITHM.replaceFirst("\\{", "\\\\{").replaceFirst("\\}", "\\\\}");
        String str = "{SHA}abc".replaceFirst(passwdAlgorithm, "");
        System.out.println(passwdAlgorithm + "==" + str);
	}
	
}
