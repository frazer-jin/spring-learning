package com.relay2.resource;

import java.util.Properties;

import org.springframework.core.io.Resource;

public class MyResource {

	private Resource template1;
	
	private Properties properties;

	public Resource getTemplate() {
		return template1;
	}

	public void setTemplate(Resource template) {
		this.template1 = template;
	}
	
	public void init() throws Exception{
		if(this.template1.exists()){
			properties = new Properties();
			properties.load(this.template1.getInputStream());
		}
	}
	
	public void print(){
		System.out.println(this.properties);
	}

	@Override
	public String toString() {
		return "MyResource [template=" + template1 + "]";
	}
	
}
