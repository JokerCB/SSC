package com.ssc.demo.web.util;

import java.io.IOException;
import java.util.Properties;
import com.ssc.demo.constant.CommonConstant;
/**
 * 
 * 版权所有：2013-广州扬基信息科技有限公司
 * 项目名称：developer-demo   
 *
 * 类描述：操作FLEXPAPER设置属性文件
 * 类名称：com.pousheng.demo.web.util.FlexPaperUtil     
 * 创建人：dennis.he(dennis.he@pousheng.com)
 * 创建时间：2013-12-11 下午2:09:59   
 * 修改人：
 * 修改时间：2013-12-11 下午2:09:59   
 * 修改备注：   
 * @version
 */
public class FlexPaperUtil {
	/**
	 * Properties对象
	 */
	private static Properties properties = new Properties();

	/**
	 * 初始化
	 */
	static {
		try { 
			properties.load(FlexPaperUtil.class.getClassLoader().getResourceAsStream(CommonConstant.FLEXPAPER_FILENAME));
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(CommonConstant.FLEXPAPER_FILENAME + " file is not exist!");
		}
	}
	
	/**
	 * 
	 * @Title: readString
	 * @Description: 获取提未信息资源文件中字符型的数据
	 * @param key 键
	 * @return 值
	 */
	public final static String readString(String key) {
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
	public final static Integer readInteger(String key) {
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
	public final static boolean readBoolean(String key) {
		String st = readString(key);
		if (st != null && st.trim().length() > 0) {
			return Boolean.parseBoolean(st.trim());
		}
		return false;
	}
}