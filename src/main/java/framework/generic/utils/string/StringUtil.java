package framework.generic.utils.string;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import framework.generic.utils.consts.LogConst;
import framework.generic.utils.regex.RegexConst;

/**
 * 字符串工具类
 * <p>
 * 项目名称：framework-generic-utils
 * </p>
 * <p>
 * 版权：2012-广州扬基信息科技有限公司
 * </p>
 * 
 * @see framework.generic.utils.string.StringUtil
 * @version 1.0, 2012-12-11 下午1:22:52
 * @author quanyongan
 */
public class StringUtil extends StringUtils {

	public static Logger exceptionUtil = LoggerFactory.getLogger(LogConst.EXCEPTION);

	/**
	 * 将字符串，指定日期格式，转换成日期
	 * 
	 * @param source
	 *            字符串
	 * @param pattern
	 *            格式
	 * @return Date
	 * @since 1.0
	 */
	public static Date strToDate(String source, String pattern) {
		Date date = null;
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		try {
			date = format.parse(source);
		} catch (ParseException e) {
			exceptionUtil.error("将字符串，指定日期格式，转换成日期时错误，输入的字符串为：" + source + ",指定的格式为：" + pattern);
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * 将日期，指定格式，转换成字符串
	 * 
	 * @param source
	 *            日期
	 * @param pattern
	 *            格式
	 * @return String
	 * @since 1.0
	 */
	public static String dateToStr(Date source, String pattern) {
		String result = null;
		try {
			SimpleDateFormat format = new SimpleDateFormat(pattern);
			result = format.format(source);
		} catch (Exception e) {
			exceptionUtil.error("将日期以指定格式转换成字符串时错误，输入的日期为：" + source + ",指定的格式为：" + pattern);
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * @Title: strToInt
	 * @Description: 将字符串转换为数字
	 * @param source
	 *            被转换的字符串
	 * @param init
	 *            初始值
	 * @return int 型值
	 */
	public static int strToInt(String source, int init) {
		int result = 0;
		try {
			result = Integer.parseInt(source);
		} catch (NumberFormatException e) {
			result = init;
		}
		return result;
	}

	/**
	 * @Description: 将字符串转换为布尔类型
	 * @param source
	 *				 被转换的字符串
	 * @param def
	 * 				转换不成功时返回的默认值
	 * @return
	 * 				boolean
	 */
	public static boolean strToBoolean(String source, boolean def) {
		
		if(isNullOrEmpty(source)) 
			return def;
		
		boolean result = def;
		try {
			result = Boolean.parseBoolean(source);
		} 
		catch (Exception e) {
		}
		return result;
	}
	
	/**
	 * @Description:根据预定义将字符串转换为布尔类型：
	 * 返回true对应的字符串为：1,y,yes,true
	 * 返回false对应的字符串为：0,n,not,false
	 * 不区分大小写
	 * @param source
	 * 被转换的字符串
	 * @param def
	 * 转换不成功时返回的默认值
	 * @param trueStr
	 * 传入的自定义为true的单个字符串
	 * @param falseStr
	 * 传入的自定义为false的单个字符串
	 * @return
	 */
	public static boolean strToBooleanByCustom(String source, boolean def,String trueStr,String falseStr) {
		
		if(isNullOrEmpty(source)) 
			return def;
		
		final String trueStrs="1,y,yes,true";
		final String falseStrs="0,n,not,false";
		
		if(trueStr!=null && source.equals(trueStr))
			return true;
		if(falseStr!=null && source.equals(falseStr))
			return false;
		
		if(source.toLowerCase().indexOf(trueStrs)>-1)
			return true;
		if(source.toLowerCase().indexOf(falseStrs)>-1)
			return false;
		
		return strToBoolean(source, def);
	}
	/**
	 * @Description:根据预定义将字符串转换为布尔类型：
	 * 返回true对应的字符串为：1,y,yes,true
	 * 返回false对应的字符串为：0,n,not,false
	 * 不区分大小写
	 * @param source
	 * 被转换的字符串
	 * @param def
	 * 转换不成功时返回的默认值
	 * @param trueStr
	 * 传入的自定义为true的单个字符串
	 * @return
	 */
	public static boolean strToBooleanByCustom(String source, boolean def,String trueStr) {
		return strToBooleanByCustom(source,def,trueStr,null);
	}
	/**
	 * @Description:根据预定义将字符串转换为布尔类型：
	 * 返回true对应的字符串为：1,y,yes,true
	 * 返回false对应的字符串为：0,n,not,false
	 * 不区分大小写
	 * @param source
	 * 被转换的字符串
	 * @param def
	 * 转换不成功时返回的默认值
	 * @return
	 */
	public static boolean strToBooleanByCustom(String source, boolean def) {
		return strToBooleanByCustom(source,def,null,null);
	}
	
	
	/**
	 * 将字符串转换为数字
	 * 
	 * @param source
	 *            被转换的字符串
	 * @return int 型值
	 */
	public static int strToInt(String source) {
		return strToInt(source, 0);
	}

	/**
	 * 判断是否是数字
	 * 
	 * @param str
	 *            判断的字符串
	 * @return boolean 是否是数字
	 */
	public static boolean isNumeric(String str) {
		try {
			Integer.parseInt(str);
			return true;
		} catch (Exception ex) {
			return false;
		}
	}
	
	/**
	 * 判断字符串中是否只包含同一字符
	 * @Title: isSameChar
	 * @param source 源字符
	 * @param sameChar 包含字符
	 * @return boolean(true:为同一字符，false:不为同一字符)
	 */
	public static boolean isSameChar(String source, String sameChar) {
		try {
			String _source = toStr(source);
			String _sameChar = toStr(sameChar);
			if ( _source.length() == 0 || _sameChar.length() == 0 )
			{
				return false;
			}
			if ( _source.length() % _sameChar.length() == 0 )
			{
				int num = _source.length() / _sameChar.length();
				String toSource = _sameChar;
				for ( int i = 1; i < num; i ++ )
				{
					toSource += _sameChar;
				}
				if ( _source.equals(toSource) )
					return true;
				else
					return false;
			}
			else
			{
				return false;
			}
		} catch (Exception ex) {
			return false;
		}
	}

	/**
	 * 功能 将英文字符串首字母转为大写
	 * 
	 * @param str
	 *            要转换的字符串
	 * @return String 型值
	 */
	public static String toUpCaseFirst(String str) {
		if (str == null || "".equals(str)) {
			return str;
		} else {
			boolean flag = StringUtil.verifyWord(str, RegexConst.letter_regexp);

			if (flag) {
				char[] temp = str.toCharArray();
				temp[0] = str.toUpperCase().toCharArray()[0];
				str = String.valueOf(temp);
			}
		}

		return str;
	}

	/**
	 * 功能 将英文字符串首字母转为小写
	 * 
	 * @param str
	 *            要转换的字符串
	 * @return String 型值
	 */
	public static String toLowCaseFirst(String str) {
		if (str == null || "".equals(str)) {
			return str;
		} else {
			boolean flag = StringUtil.verifyWord(str, RegexConst.letter_regexp);
			if (flag) {
				char[] temp = str.toCharArray();
				temp[0] = str.toLowerCase().toCharArray()[0];
				str = String.valueOf(temp);
			}
		}

		return str;
	}

	/**
	 * 批量将英文字符串首字母转为大写
	 * 
	 * @param str
	 *            要转换的字符串数组
	 * @return 字符数组
	 */
	public static String[] toUpCaseFirst(String[] str) {
		if (str == null || str.length == 0) {
			return str;
		} else {
			String[] result = new String[str.length];
			for (int i = 0; i < result.length; ++i) {
				result[i] = StringUtil.toUpCaseFirst(str[i]);
			}

			return result;
		}
	}

	/**
	 * 批量将英文字符串首字母转为小写
	 * 
	 * @param str
	 *            要转换的字符串数组
	 * @return 字符数组
	 */
	public static String[] toLowCaseFirst(String[] str) {
		if (str == null || str.length == 0) {
			return str;
		} else {
			String[] result = new String[str.length];
			for (int i = 0; i < result.length; ++i) {
				result[i] = StringUtil.toLowCaseFirst(str[i]);
			}

			return result;
		}
	}

	public static String hump2ohter(String param, String aother) {
		char other = aother.toCharArray()[0];
		Pattern p = Pattern.compile("[A-Z]");
		if (param == null || param.equals("")) {
			return "";
		}
		StringBuilder builder = new StringBuilder(param);
		Matcher mc = p.matcher(param);
		int i = 0;
		while (mc.find()) {
			builder.replace(mc.start() + i, mc.end() + i, other + mc.group().toLowerCase());
			i++;
		}

		if (other == builder.charAt(0)) {
			builder.deleteCharAt(0);
		}

		return builder.toString();
	}

	/**
	 * 功能 根据给定的regex正则表达式，验证给定的字符串input是否符合
	 * 
	 * @param input
	 *            需要被验证的字符串
	 * @param regex
	 *            正则表达式
	 * @return boolean 型值
	 */
	public static boolean verifyWord(String input, String regex) {
		if (input == null) {
			input = "";
		}

		if (regex == null) {
			regex = "";
		}

		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(input);
		boolean flag = m.matches();

		return flag;
	}

	/**
	 * 转换字符串中属于HTML语言中的特殊字符
	 * 
	 * @param source
	 *            为要转换的字符串
	 * @return String 型值
	 */
	public static String changeHTML(String source) {
		String s0 = source.replace("\t\n", "<br />"); // 转换字符串中的回车换行
		String s1 = s0.replace("&", "&amp;"); // 转换字符串中的"&"符号
		String s2 = s1.replace(" ", "&nbsp;"); // 转换字符串中的空格
		String s3 = s2.replace("<", "&lt;"); // 转换字符串中的"<"符号
		String s4 = s3.replace(">", "&gt;"); // 转换字符串中的">"符号

		return s4;
	}

	/**
	 * 将某些字符转为HTML标签。
	 * 
	 * @param source
	 *            源文件
	 * @return 格式化后的HTML
	 */
	public static String toHTML(String source) {
		String s1 = source.replace("&amp;", "&"); // 转换字符串中的"&"符号
		String s2 = s1.replace("&nbsp;", " "); // 转换字符串中的空格
		String s3 = s2.replace("&lt;", "<"); // 转换字符串中的"<"符号
		String s4 = s3.replace("&gt;", ">"); // 转换字符串中的">"符号
		String s5 = s4.replace("<br />", "\t\n"); // 转换字符串中的回车换行

		return s5;
	}

	/**
	 * 取得当前时间,给定格式
	 * 
	 * @return 给定格式的当前时间
	 */
	public static String getNowTime(String format) {
		if (format == null) {
			format = "yyyy-MM-dd HH:mm:ss";
		}

		String now = new java.text.SimpleDateFormat(format).format(java.util.Calendar.getInstance().getTime());
		return now;
	}

	/**
	 * 取得当前时间
	 * 
	 * @return 当前时间
	 */
	public static String getNowTime() {
		return getNowTime(null);
	}

	/**
	 * 转换字符编码
	 * 
	 * @param str
	 *            为要转换的字符串
	 * @param encoding
	 *            编码
	 * @return String 型值
	 */
	public static String toEncoding(String str, String encoding) {
		if (str == null) {
			str = "";
		}
		try {
			str = new String(str.getBytes("ISO-8859-1"), encoding);
		} catch (UnsupportedEncodingException e) {
			exceptionUtil.error("转换字符编码时错误，输入的字符串为：" + str + ",编码为：" + encoding + ",不支持转换编码错误");
			e.printStackTrace();
		}

		return str;
	}

	/**
	 * 使一个数组的所有元素被一个“分隔符”串联起来组成一条字符串
	 * 
	 * @param source
	 *            源文件名
	 * @param separator
	 *            分隔符
	 * @return String
	 */
	public static String cutArrayBySepara(String[] source, String separator) {
		if (source == null || source.length == 0 || separator == null) {
			return null;
		}
		StringBuffer result = new StringBuffer();
		for (int i = 0; i < source.length; ++i) {
			if (i == source.length - 1) {
				result.append(source[i]);
			} else {
				result.append(source[i]).append(separator);
			}
		}

		return result.toString();
	}

	/**
	 * 将字符串对象按给定的分隔符separator转象为字符型数组对象
	 * 
	 * @param str
	 *            待转换的符串对象
	 * @param separator
	 *            字符型分隔符
	 * @return 字符型数组
	 */
	public static String[] strToStrArray(String str, String separator) {
		return strToStrArrayManager(str, separator);
	}

	private static String[] strToStrArrayManager(String str, String separator) {

		StringTokenizer strTokens = new StringTokenizer(str, separator);
		String[] strArray = new String[strTokens.countTokens()];
		int i = 0;

		while (strTokens.hasMoreTokens()) {
			strArray[i] = strTokens.nextToken().trim();
			i++;
		}

		return strArray;
	}

	/**
	 * 将字符串对象按给定的分隔符separator转象为ArrayList对象
	 * 
	 * @param str
	 *            待转换的字符串对象
	 * @param separator
	 *            字符型分隔符
	 * @return ArrayList对象
	 */
	public static ArrayList<String> strToArrayList(String str, String separator) {
		return strToArrayListManager(str, separator);
	}

	private static ArrayList<String> strToArrayListManager(String str, String separator) {

		StringTokenizer strTokens = new StringTokenizer(str, separator);
		ArrayList<String> list = new ArrayList<String>();

		while (strTokens.hasMoreTokens()) {
			list.add(strTokens.nextToken().trim());
		}

		return list;
	}

	/**
	 * 将字符串对象按给定的分隔符separator转象为Set对象
	 * 
	 * @param str
	 *            待转换的字符串对象
	 * @param separator
	 *            字符型分隔符
	 * @return Set对象
	 */
	public static Set<String> strToSet(String str, String separator) {
		String[] values = strToStrArray(str, separator);
		Set<String> result = new LinkedHashSet<String>();
		for (int i = 0; i < values.length; i++) {
			result.add(values[i]);
		}
		return result;
	}

	/**
	 * 判断是否为空后null
	 * 
	 * @param obj
	 *            对象
	 * @return boolean
	 * @since 1.0
	 */
	public static boolean isNullOrEmpty(Object obj) {
		return obj == null || "".equals(obj.toString());
	}

	/**
	 * 将所有对象转换成字符串形式，null对象转换成"null"
	 * 
	 * @param obj
	 * @return
	 */
	public static String toString(Object obj) {
		if (obj == null)
			return "null";
		return obj.toString();
	}

	public static String join(Collection<?> s, String delimiter) {
		StringBuffer buffer = new StringBuffer();
		Iterator<?> iter = s.iterator();
		while (iter.hasNext()) {
			buffer.append(iter.next());
			if (iter.hasNext()) {
				buffer.append(delimiter);
			}
		}
		return buffer.toString();
	}

	/**
	 * 将文件名中的汉字转为UTF8编码的串,以便下载时能正确显示另存的文件名.
	 * 
	 * @param s
	 *            原文件名
	 * @return 重新编码后的文件名
	 */
	public static String toUtf8String(String s) {

		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c >= 0 && c <= 255) {
				sb.append(c);
			} else {
				byte[] b;
				try {
					b = Character.toString(c).getBytes("utf-8");
				} catch (Exception ex) {
					exceptionUtil.error("将文件名中的汉字转为UTF8编码的串时错误，输入的字符串为：" + s);
					b = new byte[0];
				}
				for (int j = 0; j < b.length; j++) {
					int k = b[j];
					if (k < 0)
						k += 256;
					sb.append("%" + Integer.toHexString(k).toUpperCase());
				}
			}
		}
		return sb.toString();
	}

	/**
	 * 将文件名中的汉字转为UTF8编码的串,以便下载时能正确显示另存的文件名.
	 * 
	 * @param s
	 *            原文件名
	 * @return 重新编码后的文件名
	 */
	public static String toUtf8String(HttpServletRequest request, String s) {
		String agent = request.getHeader("User-Agent");
		try {
			boolean isFireFox = (agent != null && agent.toLowerCase().indexOf("firefox") != -1);
			if (isFireFox) {
				s = new String(s.getBytes("UTF-8"), "ISO8859-1");
			} else {
				s = StringUtil.toUtf8String(s);
				if ((agent != null && agent.indexOf("MSIE") != -1)) {
					// see http://support.microsoft.com/default.aspx?kbid=816868
					if (s.length() > 150) {
						// 根据request的locale 得出可能的编码
						s = new String(s.getBytes("UTF-8"), "ISO8859-1");
					}
				}
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return s;
	}

	/**
	 * 将utf-8编码的汉字转为中文
	 * 
	 * @param str
	 * @return String
	 */
	public static String uriDecoding(String str) {
		String result = str;
		try {
			result = URLDecoder.decode(str, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			exceptionUtil.error("将utf-8编码的汉字转为中文时错误，输入的字符串为：" + str);
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 获取格式化后的异常字符串
	 * 
	 * @param e
	 *            异常
	 * @return String
	 * @since 1.0
	 */
	public static String getExceptionString(Exception e) {
		StringBuilder sb = new StringBuilder(e.toString());
		sb.append(getStack(e.getStackTrace()));
		Throwable t = e.getCause();
		if (t != null) {
			sb.append("\r\n <font color='red'> | cause by ").append(e.getCause());
			sb.append(getStack(e.getCause().getStackTrace()));
			sb.append("</font>");
		}
		return sb.toString();
	}

	public static String getStack(StackTraceElement[] stes) {
		StringBuilder sb = new StringBuilder();
		for (StackTraceElement ste : stes) {
			if (ste != null)
				sb.append("\n").append(ste.toString());
		}

		return sb.toString();
	}

	/**
	 * 轉成字串
	 * 
	 * @param sour
	 *            待轉資料
	 * @param init
	 *            預設值
	 * @return String 字串
	 */
	public static String toStr(Object sour, String init) {
		// 初始化
		String dest = null;
		try {
			if (sour instanceof String)
				dest = (String) sour;
			else
				dest = sour.toString();
			// 為空
			if (dest == null || "".equals(dest)) {
				dest = init;
			}
		}
		// 拋出例外
		catch (Exception e) {
			dest = init;
		}
		return dest;
	}

	/**
	 * 轉成字串
	 * 
	 * @param sour
	 *            待轉資料
	 * @return String 字串
	 */
	public static String toStr(Object sour) {
		return toStr(sour, "");
	}

	/**
	 * 取得物件裏的值
	 * 
	 * @param sour
	 *            儲存著所需內容的物件，可以是 Map, HttpServletRequest, HttpSession, ResultSet
	 *            類別
	 * @param name
	 *            對應的值的名稱，如果這個值為null，則認為 sour 本身是值
	 * @param init
	 *            預設值，如果沒有取得對應值時，則傳回此值
	 * @return String 物件裏的值的字串
	 */
	@SuppressWarnings({ "unchecked" })
	public static String getValue(Object sour, String name, String init) {
		// 回傳值
		String retValue = "";
		// 如果變數 sour 為空
		if (sour == null)
			return toStr(init, init);
		// 如果變數 name 為空，則認為 sour 本身是值
		if (name == null)
			return toStr(sour, init);

		// 根據 sour 的不同類型來取值
		try {
			// 如果 sour 是 Map 類別的物件
			if (sour instanceof Map) {
				Map<String, Object> map = (Map<String, Object>) sour;
				// 如果此映射包含指定鍵的映射關系
				if (map.containsKey(name))
					retValue = toStr(map.get(name), init);
				// 查詢資料庫時，鍵都會自動轉成小寫
				else if (map.containsKey(name.toLowerCase()))
					retValue = toStr(map.get(name.toLowerCase()), init);
				// 如果此映射不包含指定鍵的映射關系，則忽略大小寫來取值
				else {
					for (Iterator<Map.Entry<String, Object>> iter = map.entrySet().iterator(); iter.hasNext();) {
						Map.Entry<String, Object> entry = iter.next();
						// 如果鍵忽略大小寫時與 name 相同
						if (name.equalsIgnoreCase(toStr(entry.getKey()))) {
							retValue = toStr(entry.getValue(), init);
							break;
						}
					}
				}
			}
			// 如果 sour 是 HttpServletRequest 類別的物件
			else if (sour instanceof HttpServletRequest) {
				retValue = toStr(((HttpServletRequest) sour).getParameter(name), init);
				// 如果 getParameter 取不到物件裏對應的值
				if (retValue == null || "".equals(retValue))
					retValue = toStr(((HttpServletRequest) sour).getAttribute(name), init);
			}
			// 如果 sour 是 HttpSession 類別的物件
			else if (sour instanceof HttpSession)
				retValue = toStr(((HttpSession) sour).getAttribute(name), init);
			// 如果 sour 是 ResultSet 類別的物件
			else if (sour instanceof ResultSet)
				retValue = toStr(((ResultSet) sour).getString(name), init);
			// 如果 sour 不是上述類別的物件，則認為它自身是值。
			else
				retValue = toStr(sour, init);
		}
		// 取值時出現例外
		catch (Exception e) {
			retValue = init;
		}
		return toStr(retValue, init);
	}

	/**
	 * 取得物件裏的值的字串
	 * 
	 * @param sour
	 *            儲存著所需內容的物件，可以是 Map, HttpServletRequest, HttpSession, ResultSet
	 *            類別
	 * @param name
	 *            對應的值的名稱，如果這個值為null，則認為 sour 本身是值
	 * @return String 物件裏的值的字串。取不到值，或者值為 null 則傳回""
	 */
	public static String getValue(Object sour, String name) {
		return getValue(sour, name, "");
	}
	
	/**
	 * 取得 正则表达式中的符合字符
	 * @Title: getRegularExpressionString
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param source 源字符
	 * @param express 正则表达式
	 * @return String 正则表达式中的符合字符（不符合时传回null）
	 */
	public static String getRegularExpressionString(String source, String express)
	{
		Pattern pattern = Pattern.compile(express);
		Matcher matcher = pattern.matcher(source);
		if (matcher.matches()) {
			return matcher.group(1);
		}
		else
		{
			return null;
		}
	}
	
	
	/**
	 * 取得 两个括号中间的字符
	 * @Title: getRegularExpressionParenthesesString
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param source 源字符
	 * @return String 两个括号中间的字符（不符合时传回null）
	 */
	public static String getRegularExpressionParenthesesString(String source)
	{
		return getRegularExpressionString(source, ".*?\\((.*?)\\).*?");
	}
	
	/**
	 * 根据分割字符删除第一个字符串
	 * @Title: removeFirstToken
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param source 源字符串
	 * @param separator 分割字符(如逗号[,]、分号[;])
	 * @return Map<String, Object>资料集(remainder:为剩余的字符串，remove:为删除字符串)
	 */
	public static Map<String, Object> removeFirstToken(String source, char separator)
	{
		Map<String, Object> result = new HashMap<String, Object>();
		int index = source.indexOf(separator);
		if ( index > -1 )
		{
			result.put("remainder", source.substring(index + 1));
			result.put("remove", source.substring(0, index));
		}
		else
		{
			result.put("remainder", null);
			result.put("remove", source);
		}
		return result;
	}
	
	
	/**
	 * 根据分割字符删除最后一个字符串
	 * @Title: removeLastToken
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param source 源字符串
	 * @param separator 分割字符(如逗号[,]、分号[;])
	 * @return Map<String, Object>资料集(remainder:为剩余的字符串，remove:为删除字符串)
	 */
	public static Map<String, Object> removeLastToken(String source, char separator)
	{
		Map<String, Object> result = new HashMap<String, Object>();
		int index = source.lastIndexOf(separator);
		if ( index > -1 )
		{
			result.put("remainder", source.substring(0, index));
			result.put("remove", source.substring(index + 1));
		}
		else
		{
			result.put("remainder", null);
			result.put("remove", source);
		}
		return result;
	}
}
