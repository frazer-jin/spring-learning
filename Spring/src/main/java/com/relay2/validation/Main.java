package com.relay2.validation;

import java.util.Date;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

public class Main {

	public static void main(String[] args) {
		
		Man person = new Man();
		//person.setName("abc");
		person.setBirth(new Date(System.currentTimeMillis()+1000000));
		
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		Set<ConstraintViolation<Man>> set = validator.validate(person);
		
		for(ConstraintViolation<Man> constraintViolation  : set){
			System.out.println(constraintViolation .getMessage());
		}
		
	}
	
}
