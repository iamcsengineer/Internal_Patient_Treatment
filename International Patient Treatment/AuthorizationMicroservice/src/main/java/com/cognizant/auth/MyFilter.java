package com.cognizant.auth;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class MyFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	/**
	 * The doFilter method of the Filter is called by the container each time a 
	 * request/response pair is passed through the chain due to a client request 
	 * for a resource at the end of the chain.
	 * The FilterChain passed in to this method allows the Filter to pass on 
	 * the request and response to the next entity in the chain.
	 */
	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterchain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		if (request.getRequestURI().equals("/auth/swagger")) {
			response.sendRedirect("/swagger-ui.html");
		}
		filterchain.doFilter(servletRequest, servletResponse);
	}

	@Override
	public void destroy() {

	}
}
