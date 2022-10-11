package org.springmvcweb.hibernate.customerorder.validator;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ImageTypeCheckConstraintValidator implements ConstraintValidator<ImageTypeCheck, byte[]> {

	String[] valueArray;

	public void initialize(ImageTypeCheck constraintAnnotation) {
		valueArray = constraintAnnotation.value();
	}

	public boolean isValid(byte[] file, ConstraintValidatorContext context) {

		if(file == null)
			return true;
		BufferedImage imageFileCheck = null;
		try {
			imageFileCheck = ImageIO.read(new ByteArrayInputStream(file));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (imageFileCheck != null) {
			return true;
		} else {
			return false;
		}
	}
}
