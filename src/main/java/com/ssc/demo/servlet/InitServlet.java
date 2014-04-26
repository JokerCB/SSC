package com.ssc.demo.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.ssc.demo.util.SvrCtx;

import framework.generic.memcached.MemCache;

public class InitServlet extends HttpServlet
{
	public void init() throws ServletException
	{
		SvrCtx.init(getServletContext());
		MemCache memCache = (MemCache) SvrCtx.getBean("memCache");
		memCache.getMc().flushAll();
		
	}

}