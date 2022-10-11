package org.springmvcweb.hibernate.customerorder.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

	private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-DD");

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
		return (date != null) ? format.format(date) : null;
	}
}