package org.springmvcjavaconfig.bakery.validator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = ImageTypeConstraintValidator.class)
@Target({ElementType.FIELD,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ImageType {
	
	String[] value() default {"jpg","png"};
	
	String message() default "{please choose valid image file in JPG or PNG format}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
