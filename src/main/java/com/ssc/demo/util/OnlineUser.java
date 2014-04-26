package com.ssc.demo.util;


import java.util.HashMap;
import java.util.Map;

import framework.generic.memcached.MemCache;

public class OnlineUser
{
	static MemCache memCache = (MemCache) SvrCtx.getBean("SvrCtx");
	

	public static void login(String incID, String userID, String SID)
	{
		String corpKey = "online" + incID;

		Map userMap = (Map)memCache.getMc().get(corpKey);
		if (userMap == null)
			userMap = new HashMap();

		String sIDKey = "SID" + userID;
		String prevSID = (String)memCache.getMc().get(sIDKey);
		if (prevSID != null && !prevSID.equals(SID))
		{
			userMap.put(userID, false);
			kickUser(incID, userID, prevSID);
		}
		else
			userMap.put(userID, true);
		memCache.getMc().set(corpKey, userMap);
		memCache.getMc().set(sIDKey, SID);

		memCache.getMc().set("userID", userID);
	}

	public static void logout(String corpid, String userid, String SID)
	{
		String corpKey = "online" + corpid;

		Map userMap = (Map)memCache.getMc().get(corpKey);
		if (userMap == null)
			userMap = new HashMap();

		Object stateObj = userMap.get(userid);
		if (stateObj == null)
			return;

		boolean state = (Boolean)stateObj;
		if (state)
		{
			userMap.remove(userid);

			String sIDKey = "SID" + userid;
			memCache.getMc().delete(sIDKey);
		}
		else
		{
			userMap.put(userid, true);
		}
		memCache.getMc().set(corpKey, userMap);
	}

	public static int getOnline(String corpid)
	{
		String corpKey = "online" + corpid;

		Map userMap = (Map)memCache.getMc().get(corpKey);
		if (userMap == null)
			return 0;
		return userMap.keySet().size();
	}

	public static boolean hasOnline(String corpid, String userid)
	{
		String corpKey = "online" + corpid;

		Map userMap = (Map)memCache.getMc().get(corpKey);
		if (userMap == null)
			userMap = new HashMap();

		return userMap.containsKey(userid);
	}

	public static void kickUser(String corpid, String userid, String SID)
	{
		String corpKey = "online" + corpid;

		Map userMap = (Map)memCache.getMc().get(corpKey);
		if (userMap == null)
			return;

		userMap.remove(userid);

		memCache.getMc().set(corpKey, userMap);

		kickUser(SID);
	}

	public static void kickUser(String SID)
	{
//		DataStruct dataStruct = new DataStruct("SYS");
//		dataStruct.protocol = Protocol.SYS_RE_LOGIN;
//		IntervalRPC.addMessage(SID, dataStruct);
	}
}