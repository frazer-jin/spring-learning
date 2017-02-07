package com.relay2.test;

import org.springframework.util.DigestUtils;

public class Digest {

	public static void main(String[] args) {
		
		String string = DigestUtils.md5DigestAsHex(new String("Hello").getBytes());
		System.out.println(string);
		
	}
}
