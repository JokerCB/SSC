package com.ssc.demo.util;

import javax.servlet.ServletContext;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class SvrCtx
{
	private static ApplicationContext appCtx = null;


	public static ApplicationContext getAppCtx()
	{
		return appCtx;
	}

	public static void setAppCtx(ApplicationContext appCtx)
	{
		SvrCtx.appCtx = appCtx;
	}

	public static Object getBean(String beanName)
	{
		return getAppCtx().getBean(beanName);
	}

	public static void init(ServletContext servletContext)
	{
		SvrCtx.setAppCtx(WebApplicationContextUtils.getWebApplicationContext(servletContext));		
	}
}