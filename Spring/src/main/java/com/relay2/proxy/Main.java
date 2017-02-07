package com.relay2.proxy;

public class Main {

	public static void main(String[] args) {
		
		Sharp circle = new Circle();
		
		CircleProxy circleProxy = new CircleProxy(circle);
		
		Sharp proxy = circleProxy.getSharpProxy();
		
		proxy.draw();
		
		System.out.println(proxy.size());
		
		System.out.println(proxy.getClass().getName());
	}
	
}
