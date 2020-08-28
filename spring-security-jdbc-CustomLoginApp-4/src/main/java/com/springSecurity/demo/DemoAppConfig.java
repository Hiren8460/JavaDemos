package com.springSecurity.demo;


import java.beans.PropertyVetoException;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages ="com.springSecurity.demo")
@PropertySource("classpath:persistence-mysql.properties")
public class DemoAppConfig {

	
		private Logger log = Logger.getLogger(getClass().getName());
	
	
	@Autowired
	Environment evn;
	
	@Bean
	public ViewResolver viewResolver() {
		
		InternalResourceViewResolver Vr = new InternalResourceViewResolver();
		
		Vr.setPrefix("/WEB-INF/view/");
		Vr.setSuffix(".jsp");
		return Vr;
	}
	
	
	@Bean
	public DataSource securitydatasource() {
		
		
		ComboPooledDataSource cds = new ComboPooledDataSource();
		
		try {
			cds.setDriverClass(evn.getProperty("jdbc.driver"));
			cds.setJdbcUrl(evn.getProperty("jdbc.url"));
			cds.setUser(evn.getProperty("jdbc.user"));
			cds.setPassword(evn.getProperty("jdbc.password"));
			
			log.info("jdbc url"+evn.getProperty("jdbc.driver"));
			
			
			cds.setInitialPoolSize(Integer.parseInt(evn.getProperty("connection.pool.initialPoolSize")));
			cds.setMinPoolSize(Integer.parseInt(evn.getProperty("connection.pool.minPoolSize")));
			cds.setMaxPoolSize(Integer.parseInt(evn.getProperty("connection.pool.maxPoolSize")));
			cds.setMaxIdleTime(Integer.parseInt(evn.getProperty("connection.pool.maxIdleTime")));
			
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return cds;
	}
	
	
	
}
