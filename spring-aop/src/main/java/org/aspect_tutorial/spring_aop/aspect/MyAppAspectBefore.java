package org.aspect_tutorial.spring_aop.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyAppAspectBefore {

	private Logger myLogger = Logger.getLogger(getClass().getName());

	@Before("execution(void my*())")
	public void myAppBeforeAdvice(JoinPoint joinPoint) {
		myLogger.info("<<-------@Before advice order 1 aspect invoked..!--------->>");
	}

	}