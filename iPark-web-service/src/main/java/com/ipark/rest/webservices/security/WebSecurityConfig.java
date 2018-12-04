package com.ipark.rest.webservices.security;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;
	private final Log logger = LogFactory.getLog(WebSecurityConfig.class);
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		logger.debug("Using default configure(HttpSecurity). If subclassed this will potentially override subclass configure(HttpSecurity).");

		http.authorizeRequests().antMatchers("/console/**").permitAll()
		.and()
		.authorizeRequests().antMatchers("/signup/**","/login", "/change-password","/change-password/**").permitAll()
		.and()
			.authorizeRequests()
				.anyRequest().authenticated()
				.and()
				.httpBasic();
		http.csrf().disable();
	}
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	       auth.userDetailsService(userDetailsService);
	}
	
}
