package com.ssc.demo.web.util;

import java.io.IOException;
import java.util.Properties;

public class PropertiesUtil {
	private static Properties properties = new Properties();

	static {
		try { 
			properties.load(PropertiesUtil.class.getClassLoader().getResourceAsStream("app.properties"));
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("app.properties file is not exist!");
		}
	}
	
	/**
	 * 
	 * @Title: readString
	 * @Description: 获取提未信息资源文件中字符型的数据
	 * @param key 键
	 * @return 值
	 */
	public final static String readString(String key) throws RuntimeException {
		String st = (String) properties.get(key);
		if (st != null && st.trim().length() > 0) {
			return st.trim();
		}
		return "";
	}

	/**
	 * 
	 * @Title: readInteger
	 * @Description: 获取提未信息资源文件中整型的数据
	 * @param key 键
	 * @return 值
	 */
	public final static Integer readInteger(String key) throws RuntimeException {
		String st = (String) properties.get(key);
		if (st != null && st.trim().length() > 0) {
			return Integer.valueOf(st.trim());
		}
		return 0;
	}
	
	/**
	 * 
	 * @Title: readBoolean
	 * @Description: 获取提未信息资源文件中布尔类型的数据
	 * @param key 键
	 * @return 值
	 */
	public final static boolean readBoolean(String key) throws RuntimeException {
		String st = readString(key);
		if (st != null && st.trim().length() > 0) {
			return Boolean.parseBoolean(st.trim());
		}
		return false;
	}
	

}
