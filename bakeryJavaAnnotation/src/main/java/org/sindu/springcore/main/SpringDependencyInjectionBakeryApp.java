package org.sindu.springcore.main;

import org.sindu.springcore.bakery.Cake;
import org.sindu.springcore.bakery.config.Config;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringDependencyInjectionBakeryApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		Cake butterscotchCake = context.getBean("butterscotchCake", Cake.class);
		butterscotchCake.getFlavor();
		butterscotchCake.bake();
		context.close();
	}

}
