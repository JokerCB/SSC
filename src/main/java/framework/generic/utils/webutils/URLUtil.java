package framework.generic.utils.webutils;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import framework.generic.utils.string.StringUtil;
/**
 * 
 * 版权所有：2013-广州扬基信息科技有限公司
 * 项目名称：framework-generic-utils   
 *
 * 类描述：URL工具类
 * 类名称：framework.generic.utils.webutils.URLUtil     
 * 创建人：dennis.he(dennis.he@pousheng.com)
 * 创建时间：2013-11-7 上午10:43:34   
 * 修改人：
 * 修改时间：2013-11-7 上午10:43:34   
 * 修改备注：   
 * @version
 */
public class URLUtil {
	/**
	* 解析出url请求的路径，包括页面
	* @param strURL url地址
	* @return url路径
	*/
	public static String getNoParamURL(String URL) 
	{
		String result = null;
		if ( StringUtil.isNullOrEmpty(URL) )
		{
			return result;
		}
		String[] arrSplit = null;
		URL = URL.trim().toLowerCase();
		arrSplit = URL.split("[?]");
		if (URL.length() > 0) {
			if (arrSplit.length > 1) {
				if (arrSplit[0] != null) {
					result = arrSplit[0];
				}
			}
		}
		return result;
	}

	/**
	* 去掉url中的路径，留下请求参数部分
	* @param URL url地址
	* @return url请求参数部分
	*/
	public static String getQuery(String URL) 
	{
		String strAllParam = null;
		if ( StringUtil.isNullOrEmpty(URL) )
		{
			return strAllParam;
		}
		String[] arrSplit = null;
		URL = URL.trim().toLowerCase();
		arrSplit = URL.split("[?]");
		if (URL.length() > 1) {
			if (arrSplit.length > 1) {
				if (arrSplit[1] != null) {
					strAllParam = arrSplit[1];
				}
			}
		}
		return strAllParam;
	}

	/**
	* 解析出url参数中的键值对
	* 如 "index.jsp?Action=del&id=123"，解析出Action:del,id:123存入map中
	* @param URL url地址
	* @return url请求参数部分
	*/
	public static Map<String, Object> getParameterMap(String URL) 
	{
		Map<String, Object> result = Maps.newHashMap();
		if ( StringUtil.isNullOrEmpty(URL) )
		{
			return result;
		}
		Map<String, List<String>> reKeys = Maps.newHashMap();
		String[] arrSplit = null;
		String strUrlParam = getQuery(URL);
		if (strUrlParam == null) 
		{
			return result;
		}
		// 每个键值为一组
		arrSplit = strUrlParam.split("[&]");
		for (String strSplit : arrSplit) 
		{
			String[] arrSplitEqual = null;
			arrSplitEqual = strSplit.split("[=]");
			// 解析出键值
			if (arrSplitEqual.length > 1) 
			{
				if ( result.containsKey(arrSplitEqual[0]) )
				{
					if ( reKeys.containsKey(arrSplitEqual[0]) )
					{
						List<String> list = reKeys.get(arrSplitEqual[0]);
						list.add(arrSplitEqual[1]);
						reKeys.put(arrSplitEqual[0], list);
					}
					else
					{
						List<String> list = Lists.newArrayList();
						list.add((String)result.get(arrSplitEqual[0]));
						list.add(arrSplitEqual[1]);
						reKeys.put(arrSplitEqual[0], list);
					}
				}
				// 正确解析
				result.put(arrSplitEqual[0], arrSplitEqual[1]);
			} 
			else 
			{
				if (arrSplitEqual[0] != "") 
				{
					if ( result.containsKey(arrSplitEqual[0]) )
					{
						if ( reKeys.containsKey(arrSplitEqual[0]) )
						{
							List<String> list = reKeys.get(arrSplitEqual[0]);
							list.add("");
							reKeys.put(arrSplitEqual[0], list);
						}
						else
						{
							List<String> list = Lists.newArrayList();
							list.add((String)result.get(arrSplitEqual[0]));
							list.add("");
							reKeys.put(arrSplitEqual[0], list);
						}
					}
					// 只有参数没有值，不加入
					result.put(arrSplitEqual[0], "");
					
				}
			}
		}
		if ( reKeys.size() > 0 )
		{
			Iterator<Entry<String, List<String>>>  it = reKeys.entrySet().iterator();
			while ( it.hasNext() )
			{
				Entry<String, List<String>> en = it.next();
				String[] ary = new String[en.getValue().size()];
				en.getValue().toArray(ary);
				result.put(en.getKey(), ary);
			}
		}
		return result;
	}
}
