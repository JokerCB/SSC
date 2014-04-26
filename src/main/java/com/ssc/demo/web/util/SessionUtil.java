package com.ssc.demo.web.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.util.Assert;


public class SessionUtil {

	public static final String CURRENT_USER = "user";

	public static Object getSessionAttribute(HttpServletRequest request, String key) {
		Assert.notNull(request, "Request must not be null");
		HttpSession session = request.getSession(false);
		return (session != null ? session.getAttribute(key) : null);
	}

	public static void setSessionAttribute(HttpServletRequest request, String key, Object value) {
		Assert.notNull(request, "Request must not be null");
		if (value != null) {
			request.getSession().setAttribute(key, value);
		} else {
			HttpSession session = request.getSession(false);
			if (session != null) {
				session.removeAttribute(key);
			}
		}
	}

	public static void removeAttribute(HttpServletRequest request, String key) {
		request.getSession(true).removeAttribute(key);
	}


	public static void removeCurrentUser(HttpServletRequest request) {
		removeAttribute(request, CURRENT_USER);
	}
}
