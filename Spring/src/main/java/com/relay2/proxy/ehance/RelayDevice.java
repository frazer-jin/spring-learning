package com.relay2.proxy.ehance;

public class RelayDevice implements Device {

	@Override
	public String reboot() {
		//before();
		
		System.out.println("++++++reboot++++++");
		
		//after();
		return "reboot";
	}

	
	private void before(){
		System.out.println("log print before.");
	}
	
	private void after(){
		System.out.println("log print after.");
	}
}
