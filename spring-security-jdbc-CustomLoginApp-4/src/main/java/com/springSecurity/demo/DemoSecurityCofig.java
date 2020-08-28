package com.springSecurity.demo;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class DemoSecurityCofig extends WebSecurityConfigurerAdapter {

	
	@Autowired
	private DataSource ds;
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
	
		
		
		auth.jdbcAuthentication().dataSource(ds);
		/*
		 * UserBuilder users = User.withDefaultPasswordEncoder();
		 * auth.inMemoryAuthentication().withUser(users.username("Hiren").password(
		 * "hello").roles("admin","employee"));
		 * auth.inMemoryAuthentication().withUser(users.username("meow").password(
		 * "hello12").roles("employee"));
		 * auth.inMemoryAuthentication().withUser(users.username("Roshani").password(
		 * "123").roles("maaal"));
		 */	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.authorizeRequests()
.antMatchers("/").hasAnyRole("EMPLOYEE","MANAGER")
.antMatchers("/leaders/**").hasAnyRole("MANAGER")
.antMatchers("/systems/**").hasAnyRole("ADMIN")
.and().formLogin().loginPage("/showLogin")
		.loginProcessingUrl("/authenticatedTheUser")
		.permitAll().and().logout().permitAll()
		.and().exceptionHandling().accessDeniedPage("/access-denied");
	}

	
	
	
}
