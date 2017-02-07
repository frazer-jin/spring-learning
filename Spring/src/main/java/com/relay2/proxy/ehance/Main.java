package com.relay2.proxy.ehance;

import java.lang.reflect.InvocationTargetException;

import net.sf.cglib.proxy.Mixin;
import net.sf.cglib.proxy.Mixin.Generator;

public class Main {

	public static void main(String[] args) throws Exception {
		
		//Device d = new RelayDevice();
		
		//d.reboot();
		// static proxy
//		RelayDeviceProxy proxy = new RelayDeviceProxy();
//		proxy.reboot();
		
		// dynamic proxy
//		Device d = new RelayDevice();
//		DynamicProxy dynamicProxy = new DynamicProxy(d);
//		Device deviceProxy = (Device) Proxy.newProxyInstance(d.getClass().getClassLoader(), d.getClass().getInterfaces(), dynamicProxy);
//		deviceProxy.reboot();
		
		// dynamic enhance
//		Device d = new RelayDevice();
//		DynamicProxy dynamicProxy = new DynamicProxy(d);
//		Device deviceProxy = dynamicProxy.getProxy();
//		deviceProxy.reboot();
		
		// CGLib proxy
//		CGLibProxy proxy = new CGLibProxy();
//		Device deviceProxy = (Device) Enhancer.create(RelayDevice.class, proxy);
//		deviceProxy.reboot();
		
		// CGLib proxy enhance
		/*
		 * 对final方法不生效，但不会报错，对final类会报错
		 */
//		Car carProxy = CGLibProxy.getInstance().getProxy(Car.class);
//		carProxy.run();
		
		/*
		 * jdk 动态代理无法代理无实体类，必须代理接口类
		 */
//		Car car = new Car();
//		DynamicProxy dynamicProxy = new DynamicProxy(car);
//		Car carProxy = dynamicProxy.getProxy();
//		carProxy.run();
		
		
		testMixin();
	}
	
	public static void testMixin() throws Exception{
//		Mixin mixin = Mixin.create(new Object[]{new Car(), new RelayDevice()});
		
		Generator gen = new Generator();
		gen.setStyle(Mixin.STYLE_EVERYTHING);
		gen.setDelegates(new Object[]{new Car(), new RelayDevice()});
		Mixin mixin = gen.create();
		
		mixin.getClass().getMethod("run").invoke(mixin);
		
	}
	
}
