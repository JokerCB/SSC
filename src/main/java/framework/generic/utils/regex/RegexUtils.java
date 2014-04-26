package framework.generic.utils.regex;

import java.util.regex.Pattern;

/**
 * 
 * 正则工具类
 * 提供验证邮箱、手机号、电话号码、身份证号码、数字等方法
 *
 * <p>项目名称：framework-generic-utils</p>
 * <p>版权：2012-广州扬基信息科技有限公司</p>
 * @see framework.generic.utils.regex.RegexUtils
 * @version 1.0, 2012-12-19 上午10:21:43
 * @author quanyongan
 */
public final class RegexUtils {

	/**
	 * 验证Email
	 * @param email email地址，格式：zhangsan@sina.com，zhangsan@xxx.com.cn，xxx代表邮件服务商
	 * @return 验证成功返回true，验证失败返回false
	 */
	public static boolean checkEmail(String email) {
		return Pattern.matches(RegexConst.email_regexp, email);
	}
	
	/**
	 * 验证身份证号码
	 * @param idCard 居民身份证号码15位或18位，最后一位可能是数字或字母
	 * @return 验证成功返回true，验证失败返回false
	 */
	public static boolean checkIdCard(String idCard) {
		return Pattern.matches(RegexConst.ID_card_regexp,idCard);
	}
	
	/**
	 * 验证手机号码（支持国际格式，+86135xxxx...（中国内地），+00852137xxxx...（中国香港））
	 * @param mobile 移动、联通、电信运营商的号码段
	 *<p>移动的号段：134(0-8)、135、136、137、138、139、147（预计用于TD上网卡）
	 *、150、151、152、157（TD专用）、158、159、187（未启用）、188（TD专用）</p>
	 *<p>联通的号段：130、131、132、155、156（世界风专用）、185（未启用）、186（3g）</p>
	 *<p>电信的号段：133、153、180（未启用）、189</p>
	 * @return 验证成功返回true，验证失败返回false
	 */
	public static boolean checkMobile(String mobile) {
		return Pattern.matches(RegexConst.mobile_phone_regexp,mobile);
	}
	
	/**
	 * 验证固定电话号码
	 * @param phone 电话号码，格式：国家（地区）电话代码 + 区号（城市代码） + 电话号码，如：+8602085588447
	 * <p><b>国家（地区） 代码 ：</b>标识电话号码的国家（地区）的标准国家（地区）代码。它包含从 0 到 9 的一位或多位数字，
	 *  数字之后是空格分隔的国家（地区）代码。</p>
	 * <p><b>区号（城市代码）：</b>这可能包含一个或多个从 0 到 9 的数字，地区或城市代码放在圆括号——
	 * 对不使用地区或城市代码的国家（地区），则省略该组件。</p>
	 * <p><b>电话号码：</b>这包含从 0 到 9 的一个或多个数字 </p>
	 * @return 验证成功返回true，验证失败返回false
	 */
	public static boolean checkPhone(String phone) {
		return Pattern.matches(RegexConst.phone_regexp, phone);
	}
	
	/**
	 * 验证整数（正整数和负整数）
	 * @param digit 一位或多位0-9之间的整数
	 * @return 验证成功返回true，验证失败返回false
	 */
	public static boolean checkDigit(String digit) {
		return Pattern.matches(RegexConst.integer_regexp,digit);
	}
	
	/**
	 * 验证整数和浮点数（正负整数和正负浮点数）
	 * @param decimals 一位或多位0-9之间的浮点数，如：1.23，233.30
	 * @return 验证成功返回true，验证失败返回false
	 */
	public static boolean checkDecimals(String decimals) {
		return Pattern.matches(RegexConst.rational_numbers_regexp,decimals);
	} 
	
	/**
	 * 验证空白字符
	 * @param blankSpace 空白字符，包括：空格、\t、\n、\r、\f、\x0B
	 * @return 验证成功返回true，验证失败返回false
	 */
	public static boolean checkBlankSpace(String blankSpace) {
		return Pattern.matches(RegexConst.blankSpace_regexp,blankSpace);
	}
	
	/**
	 * 验证中文
	 * @param chinese 中文字符
	 * @return 验证成功返回true，验证失败返回false
	 */
	public static boolean checkChinese(String chinese) {
		return Pattern.matches(RegexConst.chinese_regexp,chinese);
	}
	
	/**
	 * 验证生日日期（年月日）
	 * @param birthday 日期，格式：1992-09-03，或1992.09.03
	 * @return 验证成功返回true，验证失败返回false
	 */
	public static boolean checkBirthday(String birthday) {
		return Pattern.matches(RegexConst.date_regexp,birthday);
	}
	
	/**
	 * 验证URL地址
	 * @param url 格式：http://blog.csdn.net:80/xyang81/article/details/7705960? 或 http://www.csdn.net:80
	 * @return 验证成功返回true，验证失败返回false
	 */
	public static boolean checkURL(String url) {
		return Pattern.matches(RegexConst.http_regexp, url);
	}
	
	/**
	 * 匹配中国邮政编码
	 * @param postcode 邮政编码
	 * @return 验证成功返回true，验证失败返回false
	 */
	public static boolean checkPostcode(String postcode) {
		return Pattern.matches(RegexConst.postcode_regexp, postcode);
	}
	
	/**
	 * 匹配IP地址
	 * @param ipAddress IP标准地址
	 * @return 验证成功返回true，验证失败返回false
	 */
	public static boolean checkIpAddress(String ipAddress) {
		return Pattern.matches(RegexConst.ip_regexp, ipAddress);
	}
	
}