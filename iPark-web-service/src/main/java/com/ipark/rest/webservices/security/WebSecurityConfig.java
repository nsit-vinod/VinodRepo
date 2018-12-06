package com.ipark.rest.webservices.security;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import com.ipark.rest.webservices.core.IParkFilter;

import org.springframework.session.ExpiringSession;
import org.springframework.session.MapSessionRepository;
import org.springframework.session.SessionRepository;
import org.springframework.session.web.http.HeaderHttpSessionStrategy;
import org.springframework.session.web.http.HttpSessionStrategy;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private SessionRegistry sessionRegistry;
	@Autowired
	private UserDetailsService userDetailsService;
	private final Log logger = LogFactory.getLog(WebSecurityConfig.class);
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		logger.debug("Using default configure(HttpSecurity). If subclassed this will potentially override subclass configure(HttpSecurity).");

		http.authorizeRequests().antMatchers("/console/**").permitAll()
		.and()
		.authorizeRequests().antMatchers("/user/signup/**","/login", "/change-password","/change-password/**").permitAll()
		.and()
		.authorizeRequests().antMatchers("/parking-area","/parking-area/**","/slots","/slots/**","/vehicle","/vehicle/**","/vehicle-category","/vehicle-category/**")
		.authenticated().and()
			.authorizeRequests()
				.anyRequest().authenticated()
				.and()
				.httpBasic();
		http.csrf().disable();
		
		http.sessionManagement().maximumSessions(100).sessionRegistry(sessionRegistry()).and().sessionFixation().none();
	
		http.logout().logoutUrl("/logout").invalidateHttpSession(true).deleteCookies("JSESSIONID")
		.logoutSuccessHandler(new LogoutSuccessHandler() {

			@Override
			public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response,
					Authentication auth) throws IOException, ServletException {
				if(null != auth && null != auth.getPrincipal() ) {
					Enumeration<String> sessionId = request.getHeaders("x-auth-token");
					sessionRegistry.removeSessionInformation(sessionId.nextElement());
					response.setStatus(200);
				}
				
			}
			
		});
	
	}
	@Bean
	SessionRepository<ExpiringSession> inmemorySessionRepository() {
		return new MapSessionRepository();
	}
	@Bean
	public HttpSessionStrategy httpSessionStrategy() {
		return new HeaderHttpSessionStrategy();
	}
	@Bean
	public SessionRegistry sessionRegistry() {
		// TODO Auto-generated method stub
		return new SessionRegistryImpl();
	}


	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
		
	}
	
	@Bean
	public AuthenticationManager customAuthenticationManager() throws Exception {
	  return authenticationManager();
	}
	
	@Bean
	public FilterRegistrationBean corsFilterRegistrationBean() {
		
		FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		registrationBean.setName("corsFilter");
		IParkFilter ipark = new IParkFilter();
		registrationBean.setFilter(ipark);
		registrationBean.setOrder(Ordered.HIGHEST_PRECEDENCE);
		return registrationBean;
		
		
	}
}
