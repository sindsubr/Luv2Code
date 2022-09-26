package org.sindu.springcore.main;

import org.sindu.springcore.bakery.Cake;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDependencyInjectionBakeryApp {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("xmlconfig.xml");
		Cake butterscotchCake = context.getBean("cake", Cake.class);
		butterscotchCake.getFlavor();
		butterscotchCake.bake();
		context.close();
	}

}
