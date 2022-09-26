package org.sindu.springcore.main;

import org.sindu.springcore.bakery.Cake;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringPropertyValueSettingApp {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("xmlconfig.xml");
		Cake cake = context.getBean("cake", Cake.class);
		cake.getFlavor();
		cake.bake();
		context.close();
	}

}
