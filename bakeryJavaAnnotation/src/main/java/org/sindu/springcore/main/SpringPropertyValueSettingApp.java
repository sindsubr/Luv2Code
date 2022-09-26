package org.sindu.springcore.main;

import org.sindu.springcore.bakery.Cake;
import org.sindu.springcore.bakery.config.Config;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringPropertyValueSettingApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		Cake cake = context.getBean("cake", Cake.class);
		cake.getFlavor();
		cake.bake();
		context.close();
	}

}
