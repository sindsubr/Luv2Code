package org.springmvcweb.hibernate.customerorder.config;

import java.beans.PropertyVetoException;
import java.util.Properties;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@ComponentScan("org.springmvcweb.hibernate.customerorder")
@EnableWebMvc
@EnableTransactionManagement
@PropertySource(value= {"classpath:application.properties"})
public class MyServletConfig implements WebMvcConfigurer{
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
	
	@Bean(name = "flavors")
	public PropertiesFactoryBean propertyBean() {
		PropertiesFactoryBean bean = new PropertiesFactoryBean();
		bean.setLocation(new ClassPathResource("../flavors.properties"));
		return bean;
		
	}
	
	@Bean
	public ComboPooledDataSource myDataSource() {
		ComboPooledDataSource myDataSource = new ComboPooledDataSource();
		try {
			myDataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
		myDataSource.setJdbcUrl("jdbc:mysql://localhost:3306/CustomerCakeOrderTracker?usessl=false");
		myDataSource.setUser("CustomerCakeOrderTracker");
		myDataSource.setPassword("CustomerCakeOrderTracker");
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
		properties.setProperty("hibernate.dialect", "org.springmvcweb.hibernate.customerorder.util.MySQL55Dialect");
		properties.setProperty("hibernate.show_sql", "true");
		properties.setProperty("hibernate.hbm2ddl.auto", "update");
		sessionFactory.setHibernateProperties(properties);
		sessionFactory.setPackagesToScan("org.springmvcweb.hibernate.customerorder.entity");
		return sessionFactory;
		
	}

	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory);
		return transactionManager;
	}

	@Bean(name = "multipartResolver")
	public CommonsMultipartResolver multipartResolver() {
	    CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
	    multipartResolver.setMaxUploadSize(5000000);
	    return multipartResolver;
	}

}
