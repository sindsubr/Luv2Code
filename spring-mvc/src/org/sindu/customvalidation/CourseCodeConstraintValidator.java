package org.sindu.customvalidation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 
 * @author Sinduja A S
 * 
 *         The ConstraintValidator<CourseCode, String> -> CourseCode is
 *         annotation name String is field type
 *
 */
public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {

	String coursePrefix;

	public void initialize(CourseCode code) {
		coursePrefix = code.value();
	}

	public boolean isValid(String value, ConstraintValidatorContext context) {
		boolean result;
		if (value != null) {
			result = (value.startsWith(coursePrefix)) ? true : false;

		} else {
			result = true;
		}
		return result;
	}

}
