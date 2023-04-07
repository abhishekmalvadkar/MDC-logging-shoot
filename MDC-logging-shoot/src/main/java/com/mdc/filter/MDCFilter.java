package com.mdc.filter;

import java.io.IOException;
import java.util.UUID;

import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class MDCFilter implements Filter {

	private static final String X_REQUEST_ID = "requestId";

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		try {
			// at request time
			String requestIdToken = UUID.randomUUID().toString().replaceAll("-", ""); // b7338229f2f04db8b9aea25b341f50d7
			MDC.put(X_REQUEST_ID, requestIdToken);
			chain.doFilter(request, response);
			// at response time
			HttpServletResponse httpServletResponse = (HttpServletResponse) response;
			httpServletResponse.setHeader(X_REQUEST_ID, requestIdToken);
		} finally {
			MDC.clear();
		}
	}

}
