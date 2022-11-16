package org.aspect_tutorial.spring_aop;

import java.util.logging.Logger;

import org.aspect_tutorial.spring_aop.config.MyAppConfig;
import org.aspect_tutorial.spring_aop.service.MyAppService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Main App
 *
 */
public class App {

	private static Logger myLogger = Logger.getLogger(App.class.getName());

	public static void main(String[] args) {

		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
				MyAppConfig.class);
		MyAppService service = applicationContext.getBean("myAppService", MyAppService.class);
		service.setServiceId("s1");
		service.setServiceName("service1");

		myLogger.info("Service Id : " + service.getServiceId());
		myLogger.info("Service Name : " + service.getServiceName());
		service.myBusinessLogicWithNoArg();
		service.myBusinessLogicForAfter();
		
		System.out.println(service.myBusinessLogic(false));
		System.out.println(service.myBusinessLogic(true));
		
		applicationContext.close();
	}
}
