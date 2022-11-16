package org.aspect_tutorial.spring_aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAppPointcuts {

	//declaration for predicate expressions(pointcuts)
	
	@Pointcut("execution(* org.aspect_tutorial.spring_aop.service.*.*(..))")
	public void myPointcut() {
		
	}
	@Pointcut("execution(* org.aspect_tutorial.spring_aop.service.*.get*(..))")
	public void myPointcutGetter() {
		
	}
	@Pointcut("execution(* org.aspect_tutorial.spring_aop.service.*.set*(..))")
	public void myPointcutSetter() {
		
	}
	
	//combine pointcuts
	
	@Pointcut("myPointcut() && !(myPointcutGetter() || myPointcutSetter())")
	public void myPointcutNotGetterSetter() {
		
	}
}
