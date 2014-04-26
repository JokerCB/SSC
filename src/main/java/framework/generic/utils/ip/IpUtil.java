package framework.generic.utils.ip;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

/**
 *  IP工具类   
 * <p>项目名称：framework-generic-utils</p>
 * <p>版权：2012-广州扬基信息科技有限公司</p>
 * @see framework.generic.utils.ip.IpUtil
 * @version 1.0, 2012-12-11 下午12:57:21
 * @author quanyongan
 */

public class IpUtil extends HttpServlet {

	/**
	 * 取得本机IP地址  
	 *
	 * @return
	 * @since 1.0
	 */
	public static String getLocalIP() {
		InetAddress LocalIP = null;
		try {
			LocalIP = InetAddress.getLocalHost();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return LocalIP.getHostAddress();
	}

	/**
	 * 获取客户端真实IP
	 * @return
	 * @since 1.0
	 */
	public static String getClientRealIP(HttpServletRequest request) {
		String IP = request.getHeader("x-forwarded-for");
		if (null == IP || 0 == IP.length() || "unknown".equalsIgnoreCase(IP)) {
			IP = request.getHeader("Proxy-Client-IP");
		}
		if (null == IP || 0 == IP.length() || "unknown".equalsIgnoreCase(IP)) {
			IP = request.getHeader("WL-Proxy-Client-IP");
		}
		if (IP == null || IP.length() == 0 || "unknown".equalsIgnoreCase(IP)) {
			IP = request.getHeader("HTTP_CLIENT_IP");
		}
		if (IP == null || IP.length() == 0 || "unknown".equalsIgnoreCase(IP)) {
			IP = request.getHeader("HTTP_X_FORWARDED_FOR");
		}
		if (IP == null || IP.length() == 0 || "unknown".equalsIgnoreCase(IP)) {
			IP = request.getRemoteAddr();
		}
		// 对于通过多个代理的情况，第一个IP为客户端真实IP
		// 多个IP会按照','分割。。'***.***.***.***'.length() = 15
		if (null != IP && IP.length() > 15) {
			if (IP.indexOf(",") > 0) {
				IP = IP.substring(0, IP.indexOf(","));
			}
		}
		return IP;
	}

	/**
	 * 取得服务器网络地址  
	 *
	 * @param www
	 * @return
	 * @since 1.0
	 */
	public static String getServerIP(String www) {
		InetAddress ServerIP = null;
		try {
			ServerIP = InetAddress.getByName(www.trim());
			// 取得例如www.baidu.com的IP地址
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return ServerIP.getHostAddress();
	}

	/**
	 *  获取用户浏览器类型
	 *
	 * @param request
	 * @return
	 * @since 1.0
	 */
	public static String getUserBrowerType(HttpServletRequest request) {
		return request.getHeader("USER-AGENT");
	}
}