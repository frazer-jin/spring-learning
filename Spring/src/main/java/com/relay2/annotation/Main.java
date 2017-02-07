package com.relay2.annotation;

import java.lang.reflect.Field;

import org.springframework.util.ReflectionUtils;

public class Main {

	public static void main(String[] args) throws Exception {
		
		//Device device = new Device();
		
		Route route = new Route();
		
		Field[] fields = route.getClass().getSuperclass().getDeclaredFields();
		
		for(Field field : fields){
			boolean yes = field.isAnnotationPresent(ObjectType.class);
			System.out.println("Field: " + field.getName() + " with annotation ObjectType? " + yes);
			field.setAccessible(true);
			if(yes && field.getAnnotation(ObjectType.class).value() == ObjectType.Types.REQUIRED && ReflectionUtils.getField(field, route)==null){
				System.err.println("Invalid setting for field: " + field.getName());
			}
		}
	}
	
}
