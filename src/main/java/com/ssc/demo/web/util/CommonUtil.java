package com.ssc.demo.web.util;

import java.io.File;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.google.gson.Gson;
import com.ssc.demo.constant.CommonConstant;

import framework.generic.utils.string.StringUtil;

/**
 * 
 * 版权所有：2013-广州扬基信息科技有限公司
 * 项目名称：form   
 *
 * 类描述：
 * 类名称：com.pousheng.form.util.CommonUtil     
 * 创建人：xiongwei
 * 创建时间：2013-3-4 下午1:48:36   
 * 修改人：
 * 修改时间：2013-3-4 下午1:48:36   
 * 修改备注：   
 * @version
 */
public final class CommonUtil {

	public final static String FORMAT_1_1 = "yyyy-MM-dd HH:mm:ss";
	public final static String FORMAT_1_2 = "yyyy-MM-dd HH:mm";
	public final static String FORMAT_1_3 = "yyyy-MM-dd HH";
	public final static String FORMAT_1_4 = "yyyy-MM-dd";

	public final static String FORMAT_2_1 = "yyyyMMddHHmmssSSS";
	public final static String FORMAT_2_2 = "yyyyMMddHHmmss";
	public final static String FORMAT_2_3 = "yyyyMMddHHmm";
	public final static String FORMAT_2_4 = "yyyyMMdd";
	public final static String FORMAT_2_5 = "yyyyMM";
	public final static String FORMAT_2_6 = "yyMMdd";

	/**
	 * @Title: StringToDate
	 * @Description: 把字符串类型的时间转化成java.util.Date
	 * @param format 格式("yyyyMMddHHmm","yyyyMMdd","yyyyMM","yyyyMMdd")
	 * @param time 时间
	 * @return
	 * @throws ParseException
	 */
	public final static Date stringToDate(String time, String format) throws RuntimeException, ParseException {
		DateFormat dateFormat = new SimpleDateFormat(format);
		return dateFormat.parse(time);
	}

	/**
	 * @Title: getTime
	 * @Description: 取得当前系统时间
	 * @param format 格式 17位(yyyyMMddHHmmssSSS或yyyy-MM-dd HH:mm:ss:SSS) (14位:yyyyMMddHHmmss) (12位:yyyyMMddHHmm) (8位:yyyyMMdd)
	 * @return 
	 */
	public final static String getTime(String format) throws RuntimeException {
		SimpleDateFormat formatDate = new SimpleDateFormat(format);
		return formatDate.format(new Date());
	}

	/**
	 * 
	 * @Title: getTime
	 * @Description: 把java.util.Date转换成字符串类型时间
	 * @param date 
	 * @param format 格式
	 * @return
	 */
	public final static String getTime(Date date, String format) throws RuntimeException {
		SimpleDateFormat formatDate = new SimpleDateFormat(format);
		return formatDate.format(date);
	}

	/**
	 * 
	 * @Title: getTimestamp
	 * @Description: 获取时间
	 * @param format 格式
	 * @return
	 */
	public final static Timestamp getTimestamp(String format) throws ParseException {
		return Timestamp.valueOf(getTime(format));
	}

	/**
	 * 时间戳转换为字符串
	 * @param time
	 * @return
	 */
	public static String timestampToStr(Timestamp time, String format) throws ParseException {
		SimpleDateFormat formatDate = new SimpleDateFormat(format);
		return formatDate.format(new Date(time.getTime()));
	}

	/**
	 * 
	 * @Title: isDateEquals
	 * @Description: 时间比较是否相等
	 * @param dateFir 时间1
	 * @param dateSec 时间2
	 * @param format 时间格式("yyyy-MM-dd HH:mm","yyyy-MM-dd")
	 * @return 如果dateFir等于dateSec，则返回true；否则返回false
	 */
	public static boolean isDateEquals(String dateFir, String dateSec, String format) throws ParseException {
		DateFormat df = new SimpleDateFormat(format);
		if (df.parse(dateFir).equals(df.parse(dateSec))) {
			return true;
		}
		return false;
	}

	/**
	 * 
	 * @Title: isDateBefore
	 * @Description: 时间大小对比
	 * @param dateFir 时间1
	 * @param dateSec 时间2
	 * @param format 时间格式("yyyy-MM-dd HH:mm","yyyy-MM-dd")
	 * @return 如果dateFir小于dateSec，则返回true；否则返回false
	 * @throws ParseException 
	 */
	public static boolean isDateBefore(String dateFir, String dateSec, String format) throws ParseException {
		DateFormat df = new SimpleDateFormat(format);
		return df.parse(dateFir).before(df.parse(dateSec));
	}

	/**
	 * 
	 * @Title: isDateBeforeOrEquals
	 * @Description: 时间大小对比
	 * @param dateFir 时间1
	 * @param dateSec 时间2
	 * @param format 时间格式("yyyy-MM-dd HH:mm","yyyy-MM-dd")
	 * @return 如果dateFir小于或等于dateSec，则返回true；否则返回false
	 * @throws ParseException 
	 */
	public static boolean isDateBeforeOrEquals(String dateFir, String dateSec, String format) throws ParseException {
		DateFormat df = new SimpleDateFormat(format);
		if (df.parse(dateFir).equals(df.parse(dateSec))) {
			return true;
		}
		return df.parse(dateFir).before(df.parse(dateSec));
	}

	/**
	 * 
	 * @Title: isDateAfter
	 * @Description: 时间大小对比
	 * @param dateFir 时间1
	 * @param dateSec 时间2
	 * @param format 时间格式("yyyy-MM-dd HH:mm","yyyy-MM-dd")
	 * @return 如果dateFir大于dateSec，则返回true；否则返回false
	 * @throws ParseException 
	 */
	public static boolean isDateAfter(String dateFir, String dateSec, String format) throws ParseException {
		DateFormat df = new SimpleDateFormat(format);
		return df.parse(dateFir).after(df.parse(dateSec));
	}

	/**
	 * 
	 * @Title: isDateAfterOrEquals
	 * @Description: 时间大小对比
	 * @param dateFir 时间1
	 * @param dateSec 时间2
	 * @param format 时间格式("yyyy-MM-dd HH:mm","yyyy-MM-dd")
	 * @return 如果dateFir大于或等于dateSec，则返回true；否则返回false
	 * @throws ParseException 
	 */
	public static boolean isDateAfterOrEquals(String dateFir, String dateSec, String format) throws ParseException {
		DateFormat df = new SimpleDateFormat(format);
		if (df.parse(dateFir).equals(df.parse(dateSec))) {
			return true;
		}
		return df.parse(dateFir).after(df.parse(dateSec));
	}

	/**
	 * 
	 * @Title: getRandomCode
	 * @Description: 产生N位的随机码
	 * @param in 位数
	 * @return
	 */
	public static String getRandomCode(int in) throws RuntimeException {
		String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		Random random = new Random();
		StringBuffer sbf = new StringBuffer();
		for (int i = 0; i < in; i++) {
			int num = random.nextInt(str.length());
			sbf.append(str.charAt(num));
		}
		return sbf.toString();
	}

	/**
	 * 
	 * @Title: getOrdinaryFileDir
	 * @Description: 生成普通文件目录名
	 * @return - 目录名
	 */
	public final static String getOrdinaryFileDir() throws RuntimeException {
		String fileDir = PropertiesUtil.readString("upload.ordinary.dir") + "/" + getTime(FORMAT_2_5);
		return fileDir;
	}

	/**
	 * 
	 * @Title: getOrdinaryPdfFileDir
	 * @Description: 生成普通PDF文件目录名
	 * @return - 目录名
	 */
	public final static String getOrdinaryPdfFileDir() throws RuntimeException {
		String fileDir = PropertiesUtil.readString("upload.ordinary.pdf.dir") + "/" + getTime(FORMAT_2_5);
		return fileDir;
	}

	/**
	 * 
	 * @Title: getIdiographFileDir
	 * @Description: 生成签名文件目录名
	 * @return - 目录名
	 */
	public final static String getIdiographFileDir() throws RuntimeException {
		String fileDir = PropertiesUtil.readString("upload.idiograph.dir");
		return fileDir;
	}

	/**
	 * 
	 * @Title: isUploadAllowConversionPdfSuffix
	 * @Description: 判断上传后的文件可转换成PDF文件的后缀类型
	 * @param str 后缀类型字符
	 * @return true-可转换，false-不可转换
	 */
	public final static boolean isUploadAllowConversionPdfSuffix(String str) throws RuntimeException {
		boolean flag = false;
		if (!StringUtil.isNullOrEmpty(str)) {
			String st = PropertiesUtil.readString("upload.allow.conversion.pdf.suffix");
			if (!StringUtil.isNullOrEmpty(st)) {
				String[] sts = st.split("\\,");
				if (sts != null && sts.length > 0) {
					for (String s : sts) {
						if (!StringUtil.isNullOrEmpty(s) && s.trim().equalsIgnoreCase(str)) {
							flag = true;
							break;
						}
					}
				}
			}
		}
		return flag;
	}

	/**
	 * 
	 * @Title: isUploadAllowConversionPdfSuffix
	 * @Description: 判断上传后的文件可不转换成PDF文件的后缀类型
	 * @param str 后缀类型字符
	 * @return true-可转换，false-不可转换
	 */
	public final static boolean isUploadAllowNoConversionPdfSuffix(String str) throws RuntimeException {
		boolean flag = false;
		if (!StringUtil.isNullOrEmpty(str)) {
			String st = PropertiesUtil.readString("upload.allow.no.conversion.pdf.suffix");
			if (!StringUtil.isNullOrEmpty(st)) {
				String[] sts = st.split("\\,");
				if (sts != null && sts.length > 0) {
					for (String s : sts) {
						if (!StringUtil.isNullOrEmpty(s) && s.equalsIgnoreCase(str)) {
							flag = true;
							break;
						}
					}
				}
			}
		}
		return flag;
	}

	/**
	 * 
	 * @Title: getIdiographPath
	 * @Description: 判断并获取签名路径
	 * @param employeeCode
	 * @return
	 */
	public final static String getIdiographPath(String employeeCode) throws RuntimeException {
		String rePath = null;
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		String path = CommonUtil.getIdiographFileDir() + "/" + employeeCode;
		String path2 = path + ".jpg";
		File file = new File(request.getRealPath("/") + path2);
		if (file.isFile()) {
			rePath = path2;
		} else {
			path2 = path + ".JPG";
			file = new File(request.getRealPath("/") + path2);
			if (file.isFile()) {
				rePath = path2;
			}
		}
		return rePath;
	}

	/**
	 * 
	 * @Title: fileName
	 * @Description: 生成文件名
	 * @return - 25位的文件名
	 */
	public final static String createfileName() throws RuntimeException {
		String fileDir = getTime(FORMAT_2_1) + getRandom(1, 99999999);
		return fileDir;
	}

	/**
	 * @Title: getRandom
	 * @Description: 生成指定位数且指定范围的随机数(最终生成的随机数位数由upLimit参数的位数决定,最终生成的随机数的范围由upLimit和downLimit参数的值决定)
	 * @param downLimit：要生成的随机数的最小数
	 * @param upLimit：要生成的随机数的最大数
	 * @return 返回生成的随机数
	 */
	public final static String getRandom(int downLimit, int upLimit) throws RuntimeException {
		return String.format("%0" + Integer.toString(upLimit).length() + "d", 1 + new Random().nextInt(upLimit - downLimit));
	}

	/**
	 * 
	 * @Title: getGenerateId20
	 * @Description: 生成20位数主键
	 * @return
	 */
	public final static String getGenerateId20() throws RuntimeException {
		return getTime(CommonUtil.FORMAT_2_1) + getRandom(1, 999);
	}

	/**
	 * 
	 * @Title: getFormCode
	 * @Description: 获取截取后的单据编号或旧流程实例ID，实质为单据类型代码
	 * @param code 单据编号或旧流程实例ID
	 * @return 单据类型代码
	 */
	public final static String getFormCode(String code) throws RuntimeException {
		if (!StringUtil.isNullOrEmpty(code) && code.indexOf("-") != -1) {
			if (CommonUtil.isContainsChineseMany(code)) { // 如果包含中文，则是旧数据
				return code.substring(code.indexOf("-") + 1, code.indexOf("-", code.indexOf("-") + 1)); // 从第一个"-"开始截取
			} else {
				return code.substring(0, code.indexOf("-"));
			}
		}
		return "";
	}

	/**
	 * 
	 * @Title: getDoubleHalfUpValue
	 * @Description: 获取
	 * @param newScale 保留位数
	 * @param object 值
	 * @return
	 */
	public final static Double getDoubleHalfUpValue(int newScale, Object object) throws RuntimeException {
		if (object != null) {
			String str = String.valueOf(new BigDecimal(object.toString()).setScale(newScale, BigDecimal.ROUND_HALF_UP));
			return Double.valueOf(str);
		}
		return null;
	}

	/**
	 * 
	 * @Title: getJsonStr
	 * @Description: 对象转换成JSON格式字符串
	 * @param obj 对象
	 * @return 
	 */
	public final static String getJsonStr(Object obj) {
		if (obj != null) {
			return new Gson().toJson(obj);
		}
		return "";
	}

	public final static String getExportPDFFileDir() throws RuntimeException {
		String fileDir = PropertiesUtil.readString("exports.pdf.dir");
		return fileDir;
	}

	public final static String getWkhtmltopdf() throws RuntimeException {
		String executePath = PropertiesUtil.readString("exports.wkhtmltopdf");
		return executePath;
	}

	/**
	 * 
	 * @Title: getSystemInterceptorFilters
	 * @Description: 获取拦截器过滤条件
	 * @return
	 */
	public final static String[] getSystemInterceptorFilters() throws RuntimeException {
		String str = PropertiesUtil.readString("system.interceptor.filter");
		if (str != null && str.trim().length() > 0) {
			return str.split("\\,");
		}
		return null;
	}

	/**
	 * 
	 * @Title: getIsEnableManagerBoundary
	 * @Description: 获取是否启用管理线
	 * @return true-启用，false-不启用
	 */
	public final static boolean getIsEnableManagerBoundary() throws RuntimeException {
		return PropertiesUtil.readBoolean("is.enable.manager.boundary");
	}

	/**
	 * 
	 * @Title: getHandleOrgCode
	 * @Description: 根据是否启用管理线处理组织代码
	 * @param orgCode 处理后组织代码
	 * @return 如果启用管理线，则组织不变；反之，截取"-"前面组织代码
	 */
	public final static String getHandleOrgCode(String orgCode) throws RuntimeException {
		if (!getIsEnableManagerBoundary()) {
			if (orgCode.indexOf("-") != -1) {
				return orgCode.substring(0, orgCode.indexOf("-"));
			}
		}
		return orgCode;
	}

	/**
	 * 替换textarea内的换行符
	 * replaceBr
	 * @param str
	 * @param size
	 * @return
	 * @since 1.0
	 */
	public final static String replaceBr(String str, int size) throws RuntimeException {
		if (StringUtil.isNullOrEmpty(str)) {
			return str;
		}
		String string = "";
		int k = 0;
		int len = 0;
		String[] tmp = str.replaceAll("\\n", "<br/>").split("<br/>");// 把换行符替换成<br/>
																		// 然后分割
		for (int i = 0; i < tmp.length; i++) {
			len = tmp[i].length() / size;// 根据给定的长度换行
			for (int j = 0; j < len; j++) {
				string += tmp[i].substring(j * size, (j * size) + size) + "<br/>";
				k++;
			}
			if (tmp[i].length() % size != 0) {
				string += tmp[i].substring(k * size, tmp[i].length()) + "<br/>";
			}
			k = 0;
		}
		return string;
	}

	/**
	 * 
	 * @Title: IsOldDataPIdSuffix
	 * @Description: 是否为旧单据数据
	 * @param procInstanceId 旧单据实例ID（抽取时自定义）
	 * @return true-旧单据数据，false-新单据数据
	 */
	public static boolean IsOldDataPIdSuffix(String procInstanceId) throws RuntimeException {
		String str = getOldDataPIdSuffix();
		if (procInstanceId != null && procInstanceId.trim().length() > 0 && procInstanceId.indexOf(str) != -1) {
			return true;
		}
		return false;
	}

	/**
	 * 
	 * @Title: getOldDataPIdSuffix
	 * @Description: 获取资源文件中的旧实例ID的后缀
	 * @return
	 */
	public static String getOldDataPIdSuffix() throws RuntimeException {
		return PropertiesUtil.readString("old.data.proc.instance.id.suffix");
	}

	// GENERAL_PUNCTUATION 判断中文的“号
	// CJK_SYMBOLS_AND_PUNCTUATION 判断中文的。号
	// HALFWIDTH_AND_FULLWIDTH_FORMS 判断中文的，号
	private final static boolean isContainsChineseMany(char c) throws RuntimeException {
		Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
		if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A
				|| ub == Character.UnicodeBlock.GENERAL_PUNCTUATION || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) {
			return true;
		}
		return false;
	}

	/**
	 * 
	 * @Title: isContainsChineseMany
	 * @Description: 判断是否包括中文，以及（），？等等
	 * @param strName
	 * @return
	 */
	public final static boolean isContainsChineseMany(String strName) throws RuntimeException {
		char[] ch = strName.toCharArray();
		for (int i = 0; i < ch.length; i++) {
			char c = ch[i];
			if (isContainsChineseMany(c)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 
	 * @Title: getWipeoffStr
	 * @Description: 获取去掉中文，？，（）等字符后的串
	 * @param srcString
	 * @return
	 */
	public final static String getWipeoffStr(String srcString) throws RuntimeException {
		if (srcString != null && srcString.trim().length() > 0) {
			StringBuffer buffer = new StringBuffer();
			for (int i = 0; i < srcString.length(); i++) {
				char c = srcString.charAt(i);
				if (!isContainsChineseMany(c)) {
					buffer.append(c);
				}
			}
			return buffer.toString();
		}
		return null;
	}

	/**
	 * 根据指定字符截取字符串
	 * @Title: subStr
	 * @Description: TODO(根据指定字符截取字符串)
	 * @param str
	 * @param ch
	 * @return
	 */
	public final static String subStr(String str, String ch) throws RuntimeException {
		if (StringUtil.isNullOrEmpty(str)) {
			return str;
		}
		if (str.indexOf(ch) > 0) {
			str = str.substring(0, str.indexOf(ch));
		}
		return str;
	}

	/**
	 * 
	 * @Title: getAppCodeValue
	 * @Description: 获取本系统代码
	 * @return 
	 * @throws RuntimeException
	 */
	public final static String getAppCodeValue() throws RuntimeException {
		return PropertiesUtil.readString(CommonConstant.APP_CODE);
	}

	/**
	 * 
	 * @Title: getAppCertValue
	 * @Description: 获取本系统识别码
	 * @return
	 * @throws RuntimeException
	 */
	public final static String getAppCertValue() throws RuntimeException {
		return PropertiesUtil.readString(CommonConstant.APP_CERT);
	}

	/**
	 * 
	 * @Title: main
	 * @Description: 测试
	 * @param args
	 */
	public static void main(String[] args) {
		// // Timestamp ts = Timestamp.valueOf(getTime(FORMAT_1_1));
		// // System.out.println(ts);
		// System.out.println(getRandomCode(8));
		// //AssFixtureAffix af = new AssFixtureAffix();
		// //af.setAffixName("hai");
		// //String str = getJsonStr(af);
		// System.out.println(getHandleOrgCode("3333"));
		// long lg = 1375228800000L;
		// Date date = new java.util.Date(lg);
		// System.out.println(getTime(date,FORMAT_1_1));
	}

}
