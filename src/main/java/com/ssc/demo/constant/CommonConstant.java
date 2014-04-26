package com.ssc.demo.constant;


public class CommonConstant {

	/**
	 * app.code-本系统代码，app.cert-本识别码（由统一权限管理系统管理）
	 */
	
	public static final String APP_CODE = "app.code",APP_CERT = "app.cert";
	
	public static final String ERROR_50 = "error/500";
	
	/******************************flexPaper**************************************/
	/**
	 * flexPaper配置文件名称
	 */
	public static final String FLEXPAPER_FILENAME = "flexPaper.properties";
	/**
	 * flexPaper注册码
	 */
	public static final String FLEXPAPER_LICENSE_KEY = "licensekey";
	/**
	 * 第一转换格式（flash,html,html5）
	 */
	public static final String FLEXPAPER_RENDERINGORDER_PRIMARY = "renderingorder.primary";
	/**
	 * 第二转换格式（flash,html,html5）
	 */
	public static final String FLEXPAPER_RENDERINGORDER_SECONDARY = "renderingorder.secondary";
	/**
	 * 转为pdf命令
	 */
	public static final String FLEXPAPER_CMD_CONVERSION_SINGLEDOC = "cmd.conversion.singledoc";
	/**
	 * 转为json命令
	 */
	public static final String FLEXPAPER_CMD_CONVERSION_JSONFILE = "cmd.conversion.jsonfile";
	/******************************flexPaper end**************************************/
}
