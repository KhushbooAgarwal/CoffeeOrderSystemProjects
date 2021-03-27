package com.pack.coffee.config;

import org.springframework.context.annotation.Bean;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages = "com.pack")
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer{

	@Bean(name = "dataSource")
	public DataSource dataSource() {
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		driverManagerDataSource.setUsername("system");
		driverManagerDataSource.setPassword("wiley123");
		driverManagerDataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		return driverManagerDataSource;
	}
	

	 @Bean(name ="sessionFactoryBean")
	    public LocalSessionFactoryBean sessionFactory() {
	        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
	        sessionFactory.setDataSource(dataSource());
	        sessionFactory.setPackagesToScan(new String[] {
	                "com.pack.coffee.model.bean"
	            });
	        sessionFactory.setHibernateProperties(hibernateProperties());
	        return sessionFactory;
	    }

	 
	 private Properties hibernateProperties() {
	        Properties properties = new Properties();
	        properties.put("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
	        properties.put("hibernate.show_sql", "false");
	        properties.put("hibernate.hbm2ddl.auto", "update");
	        return properties;
	    }
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver resolver=new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
	/*
	 * Configure a handler to delegate unhandled requested by forwarding to the
	 * Servlet Containers "default" Servlet
	 */
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
}
