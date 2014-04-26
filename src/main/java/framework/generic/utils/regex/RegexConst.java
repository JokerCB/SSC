package framework.generic.utils.regex;


/**
 * 罗列常用的正则表达式，以常量的形式提供给外界使用
 * 
 * <p>项目名称：framework-generic</p>
 * <p>版权：2012-广州扬基信息科技有限公司</p>
 * @see framework.generic.RegexConst.RegexConst
 * @version 1.0, 2012-11-30 下午12:54:10
 * @author quanyongan
 */
public class RegexConst {
	
	/**
	 * 验证中文
	 */
	public static final String chinese_regexp = "^[\u4E00-\u9FA5]+$";
	/**
	 * 匹配空白字符
	 */
	public static final String blankSpace_regexp = "\\s+";
	/**
	 * 匹配QQ号
	 */
	public static final String qq_regexp = "[1-9][0-9]{4,}";
	/**
	 * 匹配ip地址
	 */
	public static final String ip_regexp = "\\d+\\.\\d+\\.\\d+\\.\\d+";
	/**
	 * 匹配文件路径
	 */
	public static final String filePath = "^(^\\.|^/|^[a-zA-Z])?:?/[^>^<^\\*^?^:^\\|^\"]+(/$)?";
	
	/**
	 * 匹配图象
	 * 
	 * 格式: /相对路径/文件名.后缀 (后缀为gif,dmp,png)
	 * 
	 * 匹配 : /forum/head_icon/admini2005111_ff.gif 或 admini2005111.dmp
	 * 
	 * 不匹配: c:/admins4512.gif
	 * 
	 */
	public static final String icon_regexp = "^(/{0,1}\\w){1,}\\.(gif|dmp|png|jpg)$|^\\w{1,}\\.(gif|dmp|png|jpg)$";

	/**
	 * 匹配email地址
	 * 
	 * 格式: x@XXX.XXX.XX
	 * 
	 * 匹配 : foo@bar.com 或 foobar@foobar.com.au
	 * 
	 * 不匹配: foo@bar 或 $$$@bar.com
	 * 
	 */
	public static final String email_regexp = "(?:\\w[-._\\w]*\\w@\\w[-._\\w]*\\w\\.\\w{2,3}$)";

	/**
	 * 匹配匹配并提取url
	 * 
	 * 格式: XXXX://XXX.XXX.XXX.XX/XXX.XXX?XXX=XXX
	 * 
	 * 匹配 : http://www.suncer.com 或news://www
	 * 
	 * 不匹配: c:\window
	 * 
	 */
	public static final String url_regexp = "(\\w+)://([^/:]+)(:\\d*)?([^#\\s]*)";

	/**
	 * 匹配并提取http
	 *
	 * 格式: http://XXX.XXX.XXX.XX/XXX.XXX?XXX=XXX 或 ftp://XXX.XXX.XXX 或 https://XXX
	 * 
	 * 匹配 : http://www.suncer.com:8080/index.html?login=true
	 *
	 * 不匹配: news://www
	 * 
	 */
	public static final String http_regexp = "(http|https|ftp)://([^/:]+)(:\\d*)?([^#\\s]*)";

	/**
	 * 匹配日期
	 * 
	 * 格式(首位不为0): XXXX-XX-XX 或 XXXX XX XX 或 XXXX-X-X
	 * 
	 * 范围:1900--2099
	 * 
	 * 匹配 : 2005-04-04
	 * 
	 * 不匹配: 01-01-01
	 * 
	 */
	public static final String date_regexp = "^((((1[6-9]|[2-9]\\d)\\d{2})-(0?[13578]|1[02])-(0?[1-9]|[12]\\d|3[01]))|(((1[6-9]|[2-9]\\d)\\d{2})-(0?[13456789]|1[012])-(0?[1-9]|[12]\\d|30))|(((1[6-9]|[2-9]\\d)\\d{2})-0?2-(0?[1-9]|1\\d|2[0-8]))|(((1[6-9]|[2-9]\\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))-0?2-29-))$";
	
	/**
	 * 验证固定电话号码
	 * <p><b>国家（地区） 代码 ：</b>标识电话号码的国家（地区）的标准国家（地区）代码。它包含从 0 到 9 的一位或多位数字，
	 *  数字之后是空格分隔的国家（地区）代码。</p>
	 * <p><b>区号（城市代码）：</b>这可能包含一个或多个从 0 到 9 的数字，地区或城市代码放在圆括号——
	 * 对不使用地区或城市代码的国家（地区），则省略该组件。</p>
	 * <p><b>电话号码：</b>这包含从 0 到 9 的一个或多个数字 </p>
	 */
	public static final String phone_regexp = "(\\+\\d+)?(\\d{3,4}\\-?)?\\d{7,8}$";

	/**
	 * 验证手机号码（支持国际格式，+86135xxxx...（中国内地），+00852137xxxx...（中国香港））
	 *<p>移动的号段：134(0-8)、135、136、137、138、139、147（预计用于TD上网卡）
	 *、150、151、152、157（TD专用）、158、159、187（未启用）、188（TD专用）</p>
	 *<p>联通的号段：130、131、132、155、156（世界风专用）、185（未启用）、186（3g）</p>
	 *<p>电信的号段：133、153、180（未启用）、189</p>
	 */
	public static final String mobile_phone_regexp = "(\\+\\d+)?1[3458]\\d{9}$";
	
	/**
	 * 匹配身份证
	 * 
	 * 格式为: XXXXXXXXXX(10位) 或 XXXXXXXXXXXXX(13位) 或 XXXXXXXXXXXXXXX(15位) 或
	 * XXXXXXXXXXXXXXXXXX(18位)
	 * 
	 * 匹配 : 0123456789123
	 * 
	 * 不匹配: 0123456
	 * 
	 */
	public static final String ID_card_regexp = "^\\d{10}|\\d{13}|\\d{15}|\\d{18}$";

	/**
	 * 匹配邮编代码
	 * 
	 * 格式为: XXXXXX(6位)
	 * 
	 * 匹配 : 012345
	 * 
	 * 不匹配: 0123456
	 * 
	 */
	public static final String postcode_regexp = "^[0-9]{6}$";

	/**
	 * 不包括特殊字符的匹配 (字符串中不包括符号 数学次方号^ 单引号' 双引号" 分号; 逗号, 帽号: 数学减号- 右尖括号> 左尖括号< 反斜杠\
	 * 即空格,制表符,回车符等 )
	 * 
	 * 格式为: x 或 一个一上的字符
	 * 
	 * 匹配 : 012345
	 * 
	 * 不匹配: 0123456
	 * 
	 */
	public static final String non_special_char_regexp = "^[^'\"\\;,:-<>\\s].+$";// 匹配邮编代码

	/**
	 * 匹配非负整数（正整数 + 0)
	 */
	public static final String non_negative_integers_regexp = "^\\d+$";

	/**
	 * 匹配不包括零的非负整数（正整数 > 0)
	 */
	public static final String non_zero_negative_integers_regexp = "^[1-9]+\\d*$";

	/**
	 * 匹配正整数
	 */
	public static final String positive_integer_regexp = "^[0-9]*[1-9][0-9]*$";

	/**
	 * 匹配非正整数（负整数 + 0）
	 */
	public static final String non_positive_integers_regexp = "^((-\\d+)|(0+))$";

	/**
	 * 匹配负整数
	 */
	public static final String negative_integers_regexp = "^-[0-9]*[1-9][0-9]*$";

	/**
	 * 匹配整数
	 */
	public static final String integer_regexp = "^-?\\d+$";

	/**
	 * 匹配非负浮点数（正浮点数 + 0）
	 */
	public static final String non_negative_rational_numbers_regexp = "^\\d+(\\.\\d+)?$";

	/**
	 * 匹配正浮点数
	 */
	public static final String positive_rational_numbers_regexp = "^(([0-9]+\\.[0-9]*[1-9][0-9]*)|([0-9]*[1-9][0-9]*\\.[0-9]+)|([0-9]*[1-9][0-9]*))$";

	/**
	 * 匹配非正浮点数（负浮点数 + 0）
	 */
	public static final String non_positive_rational_numbers_regexp = "^((-\\d+(\\.\\d+)?)|(0+(\\.0+)?))$";

	/**
	 * 匹配负浮点数
	 */
	public static final String negative_rational_numbers_regexp = "^(-(([0-9]+\\.[0-9]*[1-9][0-9]*)|([0-9]*[1-9][0-9]*\\.[0-9]+)|([0-9]*[1-9][0-9]*)))$";

	/**
	 * 匹配浮点数
	 */
	public static final String rational_numbers_regexp = "^(-?\\d+)(\\.\\d+)?$";

	/**
	 * 匹配由26个英文字母组成的字符串
	 */
	public static final String letter_regexp = "^[A-Za-z]+$";

	/**
	 * 匹配由26个英文字母的大写组成的字符串
	 */
	public static final String upward_letter_regexp = "^[A-Z]+$";

	/**
	 * 匹配由26个英文字母的小写组成的字符串
	 */
	public static final String lower_letter_regexp = "^[a-z]+$";

	/**
	 * 匹配由数字和26个英文字母组成的字符串
	 */
	public static final String letter_number_regexp = "^[A-Za-z0-9]+$";
}
