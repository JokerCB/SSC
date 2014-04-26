package framework.generic.utils.webutils;

import java.util.Enumeration;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.ServletRequest;

import org.springframework.util.Assert;

/**
 * 关于Servlet 请求对象的封装
 * <p>
 * 项目名称：framework-generic-utils
 * </p>
 * <p>
 * 版权：2013-广州扬基信息科技有限公司
 * </p>
 * 
 * @see framework.generic.utils.webutils.ServletUtil
 * @version 1.0, 2013-1-9 上午11:22:22
 * @author quanyongan
 */
public class ServletUtil {

	/**
	 * 将表单提交的所有数据转换成Map格式存储
	 * 
	 * @param request
	 * @return Map 表单的数据对象
	 */
	@SuppressWarnings("rawtypes")
	public static Map<String, Object> getParametersMap(ServletRequest request) {
		Assert.notNull(request, "Request must not be null");
		Enumeration paramNames = request.getParameterNames();
		Map<String, Object> params = new TreeMap<String, Object>();
		while (paramNames != null && paramNames.hasMoreElements()) {
			String paramName = (String) paramNames.nextElement();
			String[] values = request.getParameterValues(paramName);
			if (values == null || values.length == 0) {
				//
			} else if (values.length > 1) {
				params.put(paramName, values);
			} else {
				params.put(paramName, values[0] == null ? null : values[0].trim());
			}
		}
		return params;
	}
	/**
	 * 将表单提交的所有数据转换成Map格式存储
	 * 
	 * @param request
	 * @param prefix 前缀
	 * @return Map 表单的数据对象
	 */
	@SuppressWarnings("rawtypes")
	public static Map<String, Object> getParametersMapStartingWith(ServletRequest request,String prefix) {
		Assert.notNull(request, "Request must not be null");
		Enumeration paramNames = request.getParameterNames();
		Map<String, Object> params = new TreeMap<String, Object>();
		if (prefix == null) {
			prefix = "";
		}
		while (paramNames != null && paramNames.hasMoreElements()) {
			String paramName = (String) paramNames.nextElement();
			if ("".equals(prefix) || paramName.startsWith(prefix)) {
				String unprefixed = paramName.substring(prefix.length());
				String[] values = request.getParameterValues(paramName);
				if (values == null || values.length == 0) {
					// Do nothing, no values found at all.
				}
				else if (values.length > 1) {
					params.put(unprefixed, values);
				}
				else {
					params.put(unprefixed, values[0] == null ? null : values[0].trim());
				}
			}
		}
		return params;
	}

}
