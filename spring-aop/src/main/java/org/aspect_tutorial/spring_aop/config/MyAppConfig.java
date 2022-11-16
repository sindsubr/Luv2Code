package org.aspect_tutorial.spring_aop.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "org.aspect_tutorial.spring_aop")
@EnableAspectJAutoProxy
public class MyAppConfig{

	
}
