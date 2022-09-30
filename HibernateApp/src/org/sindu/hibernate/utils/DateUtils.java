package org.sindu.hibernate.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

	private static SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

	public static Date parse(String dateString) {
		Date date = null;
		try {
			date = (Date) format.parseObject(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	public static String format(Date date) {
		return format.format(date);
	}
}
