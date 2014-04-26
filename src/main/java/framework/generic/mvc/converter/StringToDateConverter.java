package framework.generic.mvc.converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

public class StringToDateConverter implements Converter<String, Date> {
	// yyyy-mm-dd hh:mm
	private static final String date_h_m_regexp = "\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}";

	// yyyy-mm-dd hh:mm:ss
	private static final String date_h_m_s_regexp = "\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}";

	private String dateFormatPattern;

	public StringToDateConverter(String dateFormatPattern) {
		this.dateFormatPattern = dateFormatPattern;
	}

	@Override
	public Date convert(String source) {

		if (!StringUtils.hasLength(source)) {
			// ①如果source为空 返回null
			return null;
		}
		if (source != null && !"".equals(source)) {
			if (Pattern.matches(date_h_m_regexp, source)) {
				dateFormatPattern = "yyyy-MM-dd HH:mm";
			} else if (Pattern.matches(date_h_m_s_regexp, source)) {
				dateFormatPattern = "yyyy-MM-dd HH:mm:ss";
			}
		}
		DateFormat df = new SimpleDateFormat(dateFormatPattern);
		try {
			// ②转换成功
			return df.parse(source);
		} catch (ParseException e) {
			// ③转化失败
			throw new IllegalArgumentException(String.format("类型转换失败，需要格式%s，但格式是[%s]", dateFormatPattern, source));
		}
	}

}
