package com.ssc.demo.servlet;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.ssc.demo.util.OnlineUser;


public class OnlineListener implements HttpSessionListener
{
	public void sessionCreated(HttpSessionEvent event)
	{
		System.out.println("sessionCreated");
	}

	public void sessionDestroyed(HttpSessionEvent event)
	{
		System.out.println("sessionDestroyed");
		HttpSession session = event.getSession();
		String corpid = (String)session.getAttribute("CORPID");
		String userid = (String)session.getAttribute("USERID");
		//OnlineUser.logout(corpid, userid, session.getId());

	}
}