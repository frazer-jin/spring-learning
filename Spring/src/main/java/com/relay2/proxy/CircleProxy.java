package com.relay2.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class CircleProxy {

	private Sharp target;
	
	
	public CircleProxy(Sharp target) {
		super();
		this.target = target;
	}


	public Sharp getSharpProxy(){
		
		//class loader
		ClassLoader loader = target.getClass().getClassLoader();
		//class interfaces
		Class<?>[] interfaces = target.getClass().getInterfaces();
		
		InvocationHandler h = new InvocationHandler(){

			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				System.out.println("proxy logging...");
				return method.invoke(target, args);
			}
			
		};
		
		Sharp proxy = (Sharp) Proxy.newProxyInstance(loader, interfaces, h);
		
		return proxy;
	}
}
