package org.sindu.customvalidation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class ImageFileCheckConstraintValidator implements ConstraintValidator<ImageFileCheck, CommonsMultipartFile> {

	String[] values;

	public void initialize(ImageFileCheck imageFileCheck) {
		values = imageFileCheck.values();
	}

	public boolean isValid(CommonsMultipartFile file, ConstraintValidatorContext context) {
		String fileName = file.getOriginalFilename();
		String[] splitString = fileName.split("\\.");
		System.out.println(splitString.length);
		System.out.println("test");
		if (splitString.length != 2) {
			return true;
		}
		for (String value : values) {
			if (splitString[1].equalsIgnoreCase(value)) {
				return true;
			}
		}
		return false;
	}

}
