package com.relay2.proxy.ehance;

public class RelayDeviceProxy implements Device {
	
	private RelayDevice device;
	
	
	public RelayDeviceProxy() {
		this.device = new RelayDevice();
	}

	@Override
	public String reboot() {
		before();
		String reboot = device.reboot();
		after();
		return reboot;
	}

	private void before(){
		System.out.println("log print before.");
	}
	
	private void after(){
		System.out.println("log print after.");
	}
}
