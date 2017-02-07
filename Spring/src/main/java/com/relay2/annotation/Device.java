package com.relay2.annotation;

import com.relay2.annotation.ObjectType.Types;

public class Device {

	@ObjectType
	private String name;
	
	@ObjectType(Types.REQUIRED)
	protected String label;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	@Override
	public String toString() {
		return "Device [name=" + name + ", label=" + label + "]";
	}
	
}
