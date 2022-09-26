package org.sindu.springcore.bakery.config;

import org.sindu.springcore.bakery.Logger.MyLoggerConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("org.sindu.springcore.bakery")
@PropertySource("classpath:logger.properties")
public class Config {
	@Value("${rootLoggerLevel}")
	String rootLoggerLevel;
	@Value("${printedLoggerLevel}")
	String printedLoggerLevel;

	@Bean
	public MyLoggerConfig getMyLoggerConfig() {
		return new MyLoggerConfig(rootLoggerLevel, printedLoggerLevel);
	}
}
