package org.sindu.customvalidation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = ImageFileCheckConstraintValidator.class)
@Target({ ElementType.FIELD, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ImageFileCheck {
	String[] values() default {"jpg","png","jpeg"};

	String message() default "please select image file";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
