package com.student.management;

import java.io.IOException;

import org.springframework.stereotype.Component;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class CORSFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		/*
		 * initializing method
		 */
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		String header = "Origin, Content-Type, Accept,authToken,userid,id,roleId,type,isActive,loginId, status,roleName,statusName,idsList,encryptId";
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE, PATCH");
		response.setHeader("Access-Control-Max-Age", "3600");
		response.setHeader("Access-Control-Allow-Headers", header);
		response.setHeader("Access-Control-Expose-Headers", header);
		response.setHeader("Access-Control-Allow-Headers", header);
		response.setHeader("Access-Control-Expose-Headers", header);

		filterChain.doFilter(servletRequest, servletResponse);
	}

	@Override
	public void destroy() {
		/*
		 * destroy method
		 */
	}
}
