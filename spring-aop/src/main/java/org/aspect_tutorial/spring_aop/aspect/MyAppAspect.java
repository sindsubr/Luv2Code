package org.aspect_tutorial.spring_aop.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyAppAspect {

	private Logger myLogger = Logger.getLogger(getClass().getName());

	@Before("execution(void my*())")
	public void myAppBeforeAdvice(JoinPoint joinPoint) {
		myLogger.info("<<-------@Before advice aspect invoked..!--------->>");
		myLogger.warning("Method:" + joinPoint.getSignature().toShortString());
		Object[] args = joinPoint.getArgs();
		for (Object tmpArg : args) {
			myLogger.warning("Args:" + tmpArg.toString());
		}
	}

	@After("org.aspect_tutorial.spring_aop.aspect.MyAppPointcuts.myPointcutNotGetterSetter()")
	public void myAppAfterAdvice(JoinPoint joinPoint) {
		myLogger.info("<<-------@After advice aspect invoked..!--------->>");
		myLogger.warning("Method:" + joinPoint.getSignature().toShortString());
	}

	@AfterReturning(pointcut = "org.aspect_tutorial.spring_aop.aspect.MyAppPointcuts.myPointcutNotGetterSetter()", returning = "result")
	public void myAppAfterReturningAdvice(JoinPoint joinPoint, Object result) {
		myLogger.info("<<-------@After Returning advice aspect invoked..!--------->>");
		myLogger.warning("Method:" + joinPoint.getSignature().toShortString());
		System.out.println("result: " + result);
	}

	@AfterThrowing(pointcut = "org.aspect_tutorial.spring_aop.aspect.MyAppPointcuts.myPointcutNotGetterSetter()", throwing = "theExc")
	public void myAppAfterThrowingAdvice(JoinPoint joinPoint, Throwable theExc) {
		myLogger.info("<<-------@After Throwing advice aspect invoked..!--------->>");
		myLogger.warning("Method:" + joinPoint.getSignature().toShortString());
		myLogger.warning("Exception : "+theExc);
	}
	@Around("execution(* myBusinessLogic(*))")
	public Object myAppAroundAdvice(ProceedingJoinPoint proceedingJoinPoint) {
		myLogger.info("<<-------@Around advice aspect invoked..!--------->>");
		long begin = System.currentTimeMillis();
		Object result = null;
		try {
			result = proceedingJoinPoint.proceed();
		} catch (Throwable e) {
			myLogger.warning("Exception: "+e);
			result = "Better Luck next time";
			
		}
		long end = System.currentTimeMillis();
		System.out.println((end-begin)/1000);
		myLogger.info("<<-------@Around advice aspect ended..!--------->>");
		return result ;
		
		
		
	}
}
