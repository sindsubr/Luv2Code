package org.springmvcdb.crm.config;

import java.beans.PropertyVetoException;
import java.util.Properties;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@ComponentScan("org.springmvcdb.crm")
@EnableWebMvc
@EnableTransactionManagement
public class MyServletConfig implements WebMvcConfigurer {

	@Autowired
	private Environment env;
	
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

	// <mvc:resources mapping="/resources/**" location="/resources/"/>
	public void addResourceHandlers(final ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

	@Bean
	public ComboPooledDataSource myDataSource() {
		System.out.println("Environment:"+env);
		ComboPooledDataSource myDataSource = new ComboPooledDataSource();
		try {
			myDataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
		myDataSource.setJdbcUrl("jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false");
		myDataSource.setUser("springstudent");
		myDataSource.setPassword("Spring@Student");
		myDataSource.setMaxPoolSize(3);
		myDataSource.setMinPoolSize(20);
		myDataSource.setMaxIdleTime(30000);
		return myDataSource;

	}

	@Bean
	@Autowired
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(myDataSource());
		Properties properties = new Properties();
		properties.setProperty("hibernate.dialect.storage_engine", "InnoDB");
		properties.setProperty("hibernate.dialect", "org.springmvcdb.crm.utils.MySQL55Dialect");
		properties.setProperty("hibernate.show_sql", "true");
		sessionFactory.setHibernateProperties(properties);
		sessionFactory.setPackagesToScan("org.springmvcdb.crm.entity");
		return sessionFactory;
		
	}

	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory);
		return transactionManager;
	}

}
