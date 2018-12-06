package com.ipark.rest.webservices.core;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IParkFilter implements Filter {

	private static Logger logger = LoggerFactory.getLogger(IParkFilter.class.getName());
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		res.setHeader("Access-Control-Allow-Origin", "*");
		res.setHeader("Access-Control-Allow-Method", "POST, GET, OPTION, DELETE, PUT");
		res.setHeader("Access-Control-Allow-Credentials", "true");
		res.setHeader("Access-Control-Max-Age", "3600");
		res.setHeader("Access-Control-Allow-Headers", "X-Requested-With, Content-Type, Authorization, Origin, Accept, Access-Control-Request-Method, Access-Control-Request-Headers, x-auth-token, InvalidHeader");
		res.setHeader("Access-Control-Expose-Headers", "x-auth-token");
		
		chain.doFilter(req, res);
		logger.info("Filter executed");
		if(res.getStatus() ==401) {
			res.setHeader("Access-Control-Expose-Header", "Invalid User");
		}

	}

}
