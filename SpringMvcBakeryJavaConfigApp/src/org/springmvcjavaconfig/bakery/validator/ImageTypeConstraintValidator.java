package org.springmvcjavaconfig.bakery.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class ImageTypeConstraintValidator implements ConstraintValidator<ImageType, CommonsMultipartFile> {

	String[] valueArray;

	public void initialize(ImageType constraintAnnotation) {
		valueArray = constraintAnnotation.value();
	}

	public boolean isValid(CommonsMultipartFile file, ConstraintValidatorContext context) {

		String fileName = file.getOriginalFilename();
		String[] splitString = fileName.split("\\.");

		if (splitString.length != 2) {	// Empty file
			return true;
		}
		for (String value : valueArray) 
			if (splitString[1].equalsIgnoreCase(value)) 
				return true;
				return false;
	}
}

