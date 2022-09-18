package org.sindu.springcore.main;

import org.sindu.springcore.bakery.Cake;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringBeanScopeLifecycleApp {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("xmlconfig.xml");
		Cake butterscotchCake = context.getBean("butterscotchCake", Cake.class);
		Cake butterscotchCakePrototype = context.getBean("butterscotchCake", Cake.class);
		butterscotchCake.getFlavor();
		butterscotchCake.bake();

		System.out.println("\nScope Of Bean Checking for object butterscotchCake...!!");
		System.out.println(butterscotchCake);
		System.out.println(butterscotchCakePrototype);
		System.out.print("The scope of butterscotchCake bean is ");
		System.out.println((butterscotchCake == butterscotchCakePrototype) ? "singleton\n" : "prototype\n");
		context.close();
		butterscotchCake.destroy();
		butterscotchCakePrototype.destroy();
	}
}
