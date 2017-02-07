package com.relay2.validation;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public interface Person {

	@NotNull(message="{name.invalid}")
	String getName();
	
	/*not working on setter method*/
	@Min(10)
	@Max(20)
	int getAge();
}
