package org.sindu.springcore.main;

import org.sindu.springcore.bakery.Cake;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringBeanScopeLifecycleApp {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("xmlconfig.xml");
		Cake butterscotchCake = context.getBean("butterscotchCake", Cake.class);
		Cake butterscotchCakeSingleTon = context.getBean("butterscotchCake", Cake.class);
		Cake cake = context.getBean("cake", Cake.class);
		Cake cakePrototype = context.getBean("cake", Cake.class);
		butterscotchCake.getFlavor();
		butterscotchCake.bake();

		System.out.println("\nScope Of Bean Checking for object cake...!!");
		System.out.println(cake);
		System.out.println(cakePrototype);
		System.out.print("The scope of cake bean is ");
		System.out.println((cake == cakePrototype) ? "singleton\n" : "prototype\n");
		System.out.println("\nScope Of Bean Checking for object butterscotchCake...!!");
		System.out.println(butterscotchCake);
		System.out.println(butterscotchCakeSingleTon);
		System.out.print("The scope of butterscotchCake bean is ");
		System.out.println((butterscotchCake == butterscotchCakeSingleTon) ? "singleton\n" : "prototype\n");
		context.close();
		cake.destroy();
		cakePrototype.destroy();
	}
}
