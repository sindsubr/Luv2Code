package org.sindu.springcore.main;

import org.sindu.springcore.bakery.Cake;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringBeanBakeryApp {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("xmlconfig.xml");
		Cake cake = context.getBean("butterscotchCake", Cake.class);
		cake.bake();
		context.close();
	}

}
