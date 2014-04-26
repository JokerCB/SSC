package com.ssc.demo.util;


import java.util.HashMap;
import java.util.Map;

public class UserContext
{
	private static ThreadLocal threadLocal = new ThreadLocal();

	public static Map getContext()
	{
		Map map = (Map)threadLocal.get();
		if (map == null)
		{
			map = new HashMap();
			threadLocal.set(map);
		}
		return map;
	}

	public static void removeContext()
	{
		threadLocal.remove();
	}

	public static String getSID()
	{
		return (String)getContext().get("SID");
	}


	public static String getUserId()
	{
		return (String)getContext().get("USERID");
	}

	public static void setUserId(String userID)
	{
		getContext().put("USERID", userID);
	}
	

	public static Object getState()
	{
		return getContext().get("STATE");
	}
}