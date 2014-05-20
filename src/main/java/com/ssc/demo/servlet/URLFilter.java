package com.ssc.demo.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class URLFilter implements Filter
{
	public void init(FilterConfig arg0) throws ServletException
	{
	}

	public void destroy()
	{
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException
	{
		HttpServletRequest httpRequest = (HttpServletRequest)request;
		String requestURL = httpRequest.getRequestURL().toString();
		requestURL = requestURL.substring(0,requestURL.lastIndexOf("/"));
		requestURL = requestURL.substring(requestURL.lastIndexOf("/")+1);
		String pageName = requestURL;
		HttpSession session = httpRequest.getSession();

		if ("admin".equals(pageName))
		{
			HttpServletResponse httpResponse = (HttpServletResponse)response;
			httpResponse.sendRedirect("login");
			return;
		}
		if (httpRequest.getHeader("referer") == null)
		{
			HttpServletResponse httpResponse = (HttpServletResponse)response;
			httpResponse.sendRedirect("/test/login");
			return;
		}

		chain.doFilter(request, response);
	}
}