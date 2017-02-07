package com.relay2.annotation;

public class Route extends Device {

	private String radio;

	public String getRadio() {
		return radio;
	}

	public void setRadio(String radio) {
		this.radio = radio;
	}

	@Override
	public String toString() {
		return "Route [radio=" + radio + "]";
	}
}
