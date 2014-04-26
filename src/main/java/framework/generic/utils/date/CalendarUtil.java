package framework.generic.utils.date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

public class CalendarUtil
{
	private static String chineseWeek[] = new String[] { "日", "一", "二", "三", "四", "五", "六" };

	/**
	 * 把时间日期对象的时间转换为只包括时分秒字符串，例如"12:01:01"
	 * 
	 * @param date
	 *            java.util.Date日期对象
	 * @return 只包括时分秒字符串，例如"12:01:01"
	 */
	public static String getTime(Date date)
	{
		DateFormat f = new SimpleDateFormat("HH:mm:ss");
		String dateStr = f.format(date);
		return dateStr;

	}

	/**
	 * 取得系统当前时间，包括时分秒，但不包括毫秒(毫秒被设置为0)，例如"2006-02-01 12:01:01"
	 * 
	 * @return 当前时间，包括时分秒，但不包括毫秒
	 */
	public static Date getCurrentLongDate()
	{
		return getLongDate(new Date());
	}

	/**
	 * 取得当前日期，不包括时分秒(时分秒被设置为00:00:00)，也不包括毫秒(毫秒被设置为0)
	 * 
	 * @return
	 */
	public static Date getCurrentShortDate()
	{
		return getShortDate(new Date());
	}

	/**
	 * 格式化日期对象，不包括时分秒(时分秒被设置为00:00:00)，也不包括毫秒(毫秒被设置为0)
	 * 
	 * @return
	 */
	public static Date getShortDate(Date date)
	{
		String dateStr = shortDateFormat(date);
		return formatShortDate(dateStr);

	}

	/**
	 * 格式化日期对象，包括时分秒，但不包括毫秒(毫秒被设置为0)
	 * 
	 * @return
	 */
	public static Date getLongDate(Date date)
	{
		String dateStr = longDateFormat(date);
		return formatLongDate(dateStr);
	}

	/**
	 * 格式化java.util.Date日期对象为形如为"2006-01-01 12:12:12"格式的字符串
	 * 
	 * @param date
	 * @return
	 */
	public static String longDateFormat(Date date)
	{
		DateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateStr = f.format(date) + " " + chineseWeek[date.getDay()];
		return dateStr;
	}

	public static String longDHMFormat(Date date)
	{
		DateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateStr = f.format(date) + " " + chineseWeek[date.getDay()];
		return dateStr;
	}

	/**
	 * 格式化java.util.Date日期对象为形如为"20060101121212"格式的字符串
	 * 
	 * @param date
	 * @return
	 */
	public static String stringDateFormat(Date date)
	{
		DateFormat f = new SimpleDateFormat("yyyyMMddHHmmss");
		String dateStr = f.format(date) + " " + chineseWeek[date.getDay()];
		return dateStr;
	}

	/**
	 * 格式化java.util.Date日期对象为形如为"2006年01月01日 12时12分12秒"格式的字符串
	 * 
	 * @param date
	 * @return
	 */
	public static String chineseLongDateFormat(Date date)
	{
		DateFormat f = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
		String dateStr = f.format(date) + " " + chineseWeek[date.getDay()];
		return dateStr;
	}

	/**
	 * 格式化java.util.Date日期对象为形如为"2006-01-01"格式的字符串
	 * 
	 * @param date
	 * @return
	 */
	public static String shortDateFormat(Date date)
	{
		DateFormat f = new SimpleDateFormat("yyyy-MM-dd");
		String dateStr = f.format(date) + " " + chineseWeek[date.getDay()];
		return dateStr;
	}

	/**
	 * 格式化java.util.Date日期对象为形如为"2006年01月01日"格式的字符串
	 * 
	 * @param date
	 * @return
	 */

	public static String chineseShortDateFormat(Date date)
	{
		DateFormat f = new SimpleDateFormat("yyyy年MM月dd日");
		String dateStr = f.format(date) + " " + chineseWeek[date.getDay()];
		return dateStr;
	}

	/**
	 * 格式化日期形如"2006-01-01 12-12-12"格式的字符串为java.util.Date日期对象
	 * 
	 * @param date
	 *            日期格式为2006-12-02 12:00:00的字符串
	 * @return
	 */
	public static Date formatLongDate(String date) throws RuntimeException
	{
		DateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date dt = null;
		try
		{
			dt = f.parse(date);
		}
		catch (ParseException e)
		{
			throw new RuntimeException(e);
		}
		return dt;
	}

	public static Date formatLongDHM(String date) throws RuntimeException
	{
		DateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Date dt = null;
		try
		{
			dt = f.parse(date);
		}
		catch (ParseException e)
		{
			throw new RuntimeException(e);
		}
		return dt;
	}

	/**
	 * 格式化日期形如"20060101121212"格式的字符串为java.util.Date日期对象
	 * 
	 * @param date
	 *            日期格式为20061202120000的字符串
	 * @return
	 */
	public static Date formatStringDate(String date) throws RuntimeException
	{
		DateFormat f = new SimpleDateFormat("yyyyMMddHHmmss");
		Date dt = null;
		try
		{
			dt = f.parse(date);
		}
		catch (ParseException e)
		{
			throw new RuntimeException(e);
		}
		return dt;
	}

	/**
	 * 格式化日期形如"2006年01月01日 12时12分12秒"格式的字符串为java.util.Date日期对象
	 * 
	 * @param date
	 * @return
	 */
	public static Date formatChineseLongDate(String date)
	{
		DateFormat f = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
		Date dt = null;
		try
		{
			dt = f.parse(date);
		}
		catch (ParseException e)
		{
			throw new RuntimeException(e);
		}
		return dt;

	}

	/**
	 * 格式化日期形如"2006-01-01"格式的字符串为java.util.Date日期对象
	 * 
	 * @param date
	 *            日期格式为2006-12-02的字符串
	 * @return
	 */
	public static Date formatShortDate(String date) throws RuntimeException
	{
		DateFormat f = new SimpleDateFormat("yyyy-MM-dd");
		Date dt = null;
		try
		{
			dt = f.parse(date);
		}
		catch (ParseException e)
		{
			throw new RuntimeException(e);
		}
		return dt;
	}

	/**
	 * 格式化日期形如"2006年01月01日"格式的字符串为java.util.Date日期对象
	 * 
	 * @param date
	 * @return
	 */

	public static Date formatChineseShortDate(String date)
	{
		DateFormat f = new SimpleDateFormat("yyyy年MM月dd日");
		Date dt = null;
		try
		{
			dt = f.parse(date);
		}
		catch (ParseException e)
		{
			throw new RuntimeException(e);
		}
		return dt;

	}

	/**
	 * 格式化日期字符串为2006-01-01 12:00:00
	 * 
	 * @param date
	 *            日期字符串格式为2006-01-01 12:00:00.0
	 * @return
	 */
	public static String longDateFormat(String date)
	{
		return date != null && date.length() >= 21 ? date.substring(0, 21) : date;
	}

	/**
	 * 格式化日期字符串为2006-01-01
	 * 
	 * @param date
	 *            日期字符串格式为2006-01-01
	 * @return
	 */
	public static String shortDateFormat(String date)
	{
		return date != null && date.length() >= 10 ? date.substring(0, 10) : date;
	}

	// only for test
	public static void main(String[] args)
	{
		String dateString = "20060303120101";
	//	Date dt = formatStringDate(dateString);
//		Date dt = new Date();
//		System.out.println(dt.toLocaleString());
//		System.out.println(shortDateFormat(dt));
//		System.out.println(longDateFormat(dt));
//		System.out.println(formatShortDate(longDateFormat(dt)));
		
		Random rnd = new Random();
		int[] abs = new int[5];
		for(int i=0; i<2000; i++)
		{
			abs[i % 5] = rnd.nextInt(10);
			System.out.print(abs[i % 5] + " ");
			if (i % 5 == 4)
			{
				//if((abs[2]+abs[3]+abs[4]) == 17)
				System.out.print(","+(abs[0]+abs[1]+abs[2]) + ";" +(abs[2]+abs[3]+abs[4]));
                System.out.println();
			}
		}

		
		switch(1)

		{

		case 1:

		
		
		case 2:
			
		

		case 3: System.out.println("haha");

		break;

		default: System.out.println("hehe");
		break;

		}
		

	}
	
	/**
	 * 过滤字符串中重复数据
	 * @param str = "1,2,3,4,3,4,5,6,5,5,3";
	 * @return 1,2,3,4,5,6
	 */
	public static String removeSameString(String str)
	{
		Set mLinkedSet = new LinkedHashSet();
		String[] strArray = str.split(",");
		StringBuffer sb = new StringBuffer();

		for (int i = 0; i < strArray.length; i++)
		{
			if (!mLinkedSet.contains(strArray[i]))
			{
				mLinkedSet.add(strArray[i]);
				sb.append(strArray[i] + ",");
			}
		}
		return sb.toString().substring(0, sb.toString().length() - 1);
	}
	
	public static String getStringDateShort() {
		Date dateTime = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String strTime = format.format(dateTime);
		return strTime;
	}

}
