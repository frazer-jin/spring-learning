package com.relay2.proxy.ehance;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CGLibProxy implements MethodInterceptor {
	
	static private CGLibProxy instance = new CGLibProxy();
	
	private CGLibProxy() {
	}
	
	public static CGLibProxy getInstance(){
		return instance;
	}
	
	@SuppressWarnings("unchecked")
	public <T> T getProxy(Class<T> type){
		return (T) Enhancer.create(type, this);
	}

	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		before();
		Object object = proxy.invokeSuper(obj, args);
		after();
		return object;
	}

	
	private void before(){
		System.out.println("log print before.");
	}
	
	private void after(){
		System.out.println("log print after.");
	}
}
