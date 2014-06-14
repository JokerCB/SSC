package com.ssc.demo.util;

import java.text.ParseException;
import java.util.Date;

import framework.generic.utils.date.DateUtil;

public class IssTime {

	/**
	 * 获取开奖期号
	 * @return
	 */
	public static String getOldIss(){
		try {
			Date nowTime = new Date();
			Date startTime;
			String dateString = DateUtil.format(nowTime).substring(0,10);
			int hour = Integer.parseInt(DateUtil.format(nowTime).substring(11, 13).toString());
			long midMin = 1;
			if(hour >= 10 && hour < 22)
			{
				startTime = DateUtil.parse(dateString+" 10:00:00");
				midMin = (nowTime.getTime()-startTime.getTime()- 30*1000)/1000/60/10 +24;
			}
			else if(hour >= 2 && hour < 10){
				midMin = 23;
			}	
			else if(hour >= 22){
				startTime = DateUtil.parse(dateString+" 22:00:00");	
				midMin = (nowTime.getTime()-startTime.getTime()- 30*1000)/1000/60/5 +96;
			}
			else if(hour >= 0 && hour < 2){
				startTime = DateUtil.parse(dateString+" 00:00:00");	
				midMin = (nowTime.getTime()-startTime.getTime()- 30*1000)/1000/60/5;
			}
			if(midMin == 0)
			{
				nowTime = new Date(nowTime.getTime()- 24*60*60*1000);
				midMin = 120;
			}
			return DateUtil.format(nowTime).substring(0,10).replace("-", "")+"-" + (midMin<100?("0"+midMin):midMin);
		
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static String getIss(){
		return getIss(new Date());
	}
	
	/**
	 * 获取最新期号
	 * @return
	 */
	public static String getIss(Date nowTime){
		try {
			Date startTime;
			String dateString = DateUtil.format(nowTime).substring(0,10);
			int hour = Integer.parseInt(DateUtil.format(nowTime).substring(11, 13).toString());
			int min = Integer.parseInt(DateUtil.format(nowTime).substring(14, 16).toString());
			int sec = Integer.parseInt(DateUtil.format(nowTime).substring(17, 19).toString());
			long midMin = 1;
			if(hour >= 10 && hour < 22)
			{
				startTime = DateUtil.parse(dateString+" 10:00:00");
				midMin = (nowTime.getTime()-startTime.getTime()+ 55*1000)/1000/60/10 +25;
			}
			else if(hour >= 2 && hour < 10){
				midMin = 24;
			}			
			else if(hour >= 22){
				startTime = DateUtil.parse(dateString+" 22:00:00");	
				midMin = (nowTime.getTime()-startTime.getTime()+ 30*1000)/1000/60/5 +97;
			}			
			else if(hour >= 0 && hour < 2){
				startTime = DateUtil.parse(dateString+" 00:00:00");	
				midMin = (nowTime.getTime()-startTime.getTime()+ 30*1000)/1000/60/5 +1;
			}
			
			
			if(hour==1 & min==59 && sec>=30)
				midMin = 24;
			else if(hour == 9 & min==59 && sec>=5){
				midMin = 25;
			}	
			if(hour==23 & min==59 && sec>=30){
				midMin = 1;
				nowTime = new Date(nowTime.getTime()+ 24*60*60*1000);
			}
			
			String no = midMin+"";
			if(10<midMin && midMin<100){
				no = "0"+midMin;
			}
			else if(midMin<10){
				no = "00" + midMin;
			}
			return DateUtil.format(nowTime).substring(0,10).replace("-", "")+"-" + no;
		
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static String getEndTime(){
		return getEndTime(new Date());
	}
	
	/**
	 * 获取投注截止时间
	 * @return
	 */
	public static String getEndTime(Date nowTime){
		try{
		String nowStr = DateUtil.format(nowTime);
		int hour = Integer.parseInt(nowStr.substring(11, 13).toString());
		int min = Integer.parseInt(DateUtil.format(nowTime).substring(14, 16).toString());
		int sec = Integer.parseInt(DateUtil.format(nowTime).substring(17, 19).toString());
		//分钟个位数
		int ss = Integer.parseInt(DateUtil.format(nowTime).substring(15,16));
		String str = DateUtil.format(nowTime).substring(0,15)+"9:05";
		//凌晨2点到早上9:59:05点之间
		if(hour > 1 && hour<10){
			if(hour == 9 && sec>5)
			{
				long times = nowTime.getTime() + 10*60*1000;
				str = DateUtil.format(new Date(times));
				str = str.substring(0,17)+"05";
			}
			else{
				str = DateUtil.format(new Date());
				str = str.substring(0,11)+"09:59:05";
			}
		}
		else
		{
			//分钟尾数为9且秒钟大于5 分钟加10(10分钟一期的)
			if(ss == 9 && sec>5){
				long times = nowTime.getTime() + 10*60*1000;
				str = DateUtil.format(new Date(times));
				str = str.substring(0,17)+"05";
			}
			// 时间如 21:59:59 分钟加5
			if(hour == 21 && min == 59 && sec>5){
				long times = nowTime.getTime() + 5*60*1000;
				str = DateUtil.format(new Date(times));
				str = str.substring(0,17)+"30";
			}
			
			//22点到01:59:30
			if(hour >= 22 || hour<=1){
				
			    if((ss==9 || ss ==4) && sec>30){
					long times = nowTime.getTime() + 5*60*1000;
					str = DateUtil.format(new Date(times));
					str = str.substring(0,17)+"30";
				}
			    else if(ss<5){
					str = DateUtil.format(nowTime).substring(0,15)+"4:30";
					}
				else{
					str = DateUtil.format(nowTime).substring(0,15)+"9:30";
				}
			}			
		}
		
		if(hour==1 && min == 59 && sec>30){
			str = DateUtil.format(new Date());
			str = str.substring(0,11)+"09:59:05";
		}
		
		
		return str;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 投注剩余时间 返回 秒数
	 * @return
	 */
	public static long getLeaveTime(){
		try {
			Date nowTime = new Date();
			Date endTime = DateUtil.parse(getEndTime(nowTime));
			long minTime = (endTime.getTime() - nowTime.getTime())/1000;
			return minTime;
		} catch (ParseException e) {
			e.printStackTrace();
			return 0; 
		}
	}
	
	/**
	 * 获取服务器时间
	 * @return
	 */
	public static String getServetTime(){
		Date nowTime = new Date();
		String str = DateUtil.format(nowTime);
		return str;
	}
	
	public static String getAllIss(Date nowTime){
		// 获取当前期号转成int
		String nowStr = DateUtil.format(nowTime);
		String Iss = getIss(nowTime);
		int nowIss = Integer.parseInt(Iss.substring(Iss.indexOf("-")+1, Iss.length()));// 当前期号
		long endTimeStr=0;
		try {
			// 当前的截止时间 
			endTimeStr = DateUtil.parse(getEndTime(nowTime)).getTime();
			String today = "";
			String issue="",endtime="";
			String actIss = "001"; // 默认期数
			int nextIss = nowIss;
			// (24,95)之间的间隔十分钟
			for(int i = 0; i<(121-nowIss);i++){
				nextIss=nowIss+i;
				if(nextIss<10){
					actIss="00"+nextIss;
				} else if(nextIss<100) {
					actIss="0"+nextIss;
				} else {
					actIss=nextIss+"";
				}
				issue=Iss.substring(0, 9)+actIss;
				if(nextIss==24){
					endtime = nowStr.substring(0, 11) +"09:59:05";
					endTimeStr = DateUtil.parse(endtime).getTime();
				}else if(nextIss<=96 && nextIss > 24){
					if(i>0)endTimeStr += (10*60*1000);
					endtime = DateUtil.format(new Date(endTimeStr)); // 获取结束时间加10分钟
					endtime = endtime.substring(0, 17) + "05";
				} else {
					if(i>0)endTimeStr += (5*60*1000);
					endtime = DateUtil.format(new Date(endTimeStr)); // 获取结束时间加5分钟
					endtime = endtime.substring(0, 17) + "30";
					
				}
				today +="{issue:'"+issue+"',endtime:'"+endtime+"'}|";
			}
			
			return today.substring(0, today.length()-1);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return "";
}
	
	public static void main(String[] args) {
		//System.out.println(getAllIss(new Date()));
		
		try {
			System.out.println(getAllIss(DateUtil.parse("2014-04-25 00:00:00")));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
//		try {
//			System.out.println(getAllIss(DateUtil.parse("2014-04-24 00:00:00")));
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
		
	//	getTodayIss();
		
		/*Date nowTime = new Date();
		String str = DateUtil.format(nowTime).substring(0,15)+"9:05";
		
		System.out.println(str);*/
		//System.out.println(getTodayIss());
	//	getEndTime();
	}

}
