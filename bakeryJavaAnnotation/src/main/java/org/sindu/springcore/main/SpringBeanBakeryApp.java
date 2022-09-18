package org.sindu.springcore.main;

import org.sindu.springcore.bakery.Cake;
import org.sindu.springcore.bakery.config.Config;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringBeanBakeryApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		Cake cake = context.getBean("butterscotchCake", Cake.class);
		cake.bake();
		context.close();
		
	}

}
