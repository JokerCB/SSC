package com.ssc.demo.test;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import com.ssc.demo.model.OrderDetail;

import framework.generic.utils.string.StringUtil;

public class Test {
	
	public static boolean calcActionNumberData(OrderDetail detail) {
		
		 boolean isZJ=false;
		 
	//	Played played = this.load(detail.getPlayId());
	//	Order order = orderDao.load(detail.getOrderId());
		//根据期号获取当期开奖数；
//		Data data=dataDao.find(played.getType(), order.getLtIssueStart());
		if (!StringUtil.isNullOrEmpty("dd"))
		{
			//开奖数据
			//String numberData=data.getData();
	
			String numberData="54645";
			int num,sum,zjCount,playId ;
			String actionData,actionDatas;
			num=0;
			sum=0;
			zjCount=0;//中奖注数
			isZJ=false;//是否中奖
			playId=detail.getPlayId(); //玩法
			actionData=detail.getActionData();//投注号码
			actionDatas=actionData;//原始的投注号码
			actionData=actionData.replace("|", "").replace("&", "");
			
			//根据不同玩法分处理
		/*	if (playId==5 || playId==6)
			{
				isZJ=isZJJudgement(actionDatas,numberData,detail.getType(),playId);
			}*/
			if(true)
				return isZJJudgement(actionDatas,numberData,detail.getType(),playId);
			
						
				if (playId == 2276)//  五星直选组合  0&1|2&3|4&5|6&7|8&9
				{
					actionDatas=actionDatas.replace("&", "");
					String gw=actionDatas.substring(actionDatas.lastIndexOf("|")+1, actionDatas.length());
					if (gw.indexOf(numberData.substring(4, 5))>=0)//个位
					{
						zjCount=5;
						actionDatas=actionDatas.substring(0,actionDatas.lastIndexOf("|"));
						gw=actionDatas.substring(actionDatas.lastIndexOf("|")+1, actionDatas.length());
						if (gw.indexOf(numberData.substring(3, 4))>=0)//十位
						{
							zjCount=4;
						}
						actionDatas=actionDatas.substring(0,actionDatas.lastIndexOf("|"));
						gw=actionDatas.substring(actionDatas.lastIndexOf("|")+1, actionDatas.length());
						if (gw.indexOf(numberData.substring(2, 3))>=0)//百位
						{
							zjCount=3;
						}
						actionDatas=actionDatas.substring(0,actionDatas.lastIndexOf("|"));
						gw=actionDatas.substring(actionDatas.lastIndexOf("|")+1, actionDatas.length());
						if (gw.indexOf(numberData.substring(1, 2))>=0)//千位
						{
							zjCount=2;
						}
						actionDatas=actionDatas.substring(0,actionDatas.lastIndexOf("|"));
						gw=actionDatas.substring(actionDatas.lastIndexOf("|")+1, actionDatas.length());
						if (gw.indexOf(numberData.substring(0, 1))>=0)//万位
						{
							zjCount=1;
						}
					}
				
					
					if (actionData.equals(numberData))
					{
						isZJ=true;
					}
				}
				else if (playId == 15)// 后三组选（混合组选）123&223&234&334
				{
					int s=0;
					String hm=null;
					Pattern pt = Pattern.compile("&",
							Pattern.CASE_INSENSITIVE);
					java.util.regex.Matcher mc = pt
							.matcher(actionDatas);
					mc.reset();
					while (mc.find()) {
						s++;
					}
					
				  for (int k=0;k<s;k++)
				  {
					  if (s==0)
					  {
						  hm=actionDatas;
					  }
					  else
					  {
						  hm=actionDatas.substring(0,actionDatas.indexOf("&"));								
					  }
						//判断是中组三还是组六
						if ((hm.substring(0, 1) == hm.substring(1, 2) && hm
								.substring(2, 3) != hm.substring(1, 2))
								|| (hm.substring(0, 1) != hm.substring(
										1, 2) && hm.substring(2, 3) == hm
										.substring(1, 2)))// 组三
						{
							pt = Pattern.compile(
									hm.substring(0, 1),
									Pattern.CASE_INSENSITIVE);
							mc = pt.matcher(numberData.substring(2,5));
							mc.reset();
							while (mc.find()) {
								num++;
							}
							int num2=0;
							 pt = Pattern.compile(
										hm.substring(2, 3),
										Pattern.CASE_INSENSITIVE);
							 mc = pt.matcher(numberData.substring(2,5));
								mc.reset();
								while (mc.find()) {
									num2++;
								}
								if (num==2 || num2==2)
								{
									isZJ = true;
								}
						}else //组六
						{
							 pt = Pattern.compile(
									hm.substring(0, 1),
									Pattern.CASE_INSENSITIVE);
							 mc = pt.matcher(numberData.substring(2,5));
							mc.reset();
							while (mc.find()) {
								num++;
							}
							int num2=0;
							pt = Pattern.compile(
									hm.substring(1, 2),
									Pattern.CASE_INSENSITIVE);
							 mc = pt.matcher(numberData.substring(2,5));
							mc.reset();
							while (mc.find()) {
								num2++;
							}
							int num3=0;
							pt = Pattern.compile(
									hm.substring(2, 3),
									Pattern.CASE_INSENSITIVE);
							 mc = pt.matcher(numberData.substring(2,5));
							mc.reset();
							while (mc.find()) {
								num3++;
							}
							
							if (num==1 && num2==1  && num3==1)
							{
								isZJ = true;
							}
						}
						
					  actionDatas=actionDatas.substring(actionDatas.indexOf("&")+1,actionDatas.length());			
				  }		
				}else if (playId == 99999)//前三组选(混合组选) 2&5&8
				{
					
				}else if (playId == 99999)//中三码组选（混合）
				{
					
				}
				}

		
		
		return isZJ;		
	}

	
//	@Override
	public static boolean isZJJudgement(String actionData,String numberData,String type, int playId) {
		int sum=0;
		int num=0;
		int num2=0;
		String[] datas,numberDataArray;
		
		
		if (playId == 5)// 后三码直选
		{
			if ("digital".equals(type)) // 复式 1&2&3|1&2&3|1&2&3
			{
			datas = actionData.split("\\|");
			if (datas[0].indexOf(actionData.substring(2, 3)) >= 0
					&& datas[1].indexOf(actionData.substring(3, 4)) >= 0
					&& datas[2].indexOf(actionData.substring(4, 5)) >= 0) {
				return true;
			}
			
			} else if ("input".equals(type)) // 单式 345&678
			{
				datas = actionData.split("&");
				for (int a=0; a<datas.length;a++)
				{
					if (datas[a]==numberData
							.substring(2, 5))
					{
						return true;
					}
				}
				
			}
		}else if (playId == 6)// 后三码直选(直选和值)
		{
			sum=Integer.parseInt(numberData.substring(2,3))+Integer.parseInt(numberData.substring(3,4))+Integer.parseInt(numberData.substring(4,5));
			datas = actionData.split("&");
			for (int a=0; a<datas.length;a++)
			{
				if (Integer.parseInt(datas[a])==sum)
				{
					return true;
				}
			}
			
		} else if (playId == 13)// 后三组选（组三）2&3&4&5&6
		{
			numberDataArray=numberDataF(numberData.substring(2, 5)).split(",");
			if (numberDataArray.length==2)
			{
				num=0;
				for(int a=0;a<numberDataArray.length;a++)
				{
					if (numberDataArray[a].length()==2 && actionData.indexOf(numberDataArray[a].substring(0, 1))>=0)//二重号
					{
						num++;
					}else if  (actionData.indexOf(numberDataArray[a])>=0)//单号
					{
						num++;
					}
					
				}
				if (num==2)
				{
					return true;
				}
			}
		
			
		}else if (playId == 14)// 后三组选（组六）1&2&3&4&5&6
		{
			numberDataArray=numberDataF(numberData.substring(2, 5)).split(",");
			if (numberDataArray.length==3)
			{
				num=0;
				for(int a=0;a<numberDataArray.length;a++)
				{
					if  (actionData.indexOf(numberDataArray[a])>=0)//单号
					{
						num++;
					}
					
				}
				if (num==3)
				{
					return true;
				}
			}
				
		}else if (playId == 24)//二码后二直选
		{
			if ("digital".equals(type)) // 复式 3&4&5|6&7&8
			{
				datas = actionData.split("\\|");
				if (datas[0].indexOf(numberData
						.substring(3, 4))>=0 && datas[1].indexOf(numberData
								.substring(4, 5))>=0 )
				{
					return true;
				}
					
			} else if ("input".equals(type)) // 单式 12&34&56
			{
				datas = actionData.split("&");
				for (int a=0;a<datas.length; a++)
				{
					if (datas[a]==numberData.substring(3, 5))
					{
						return true;
					}
				}
						
			}
		}else if (playId == 22)//二码前二直选
		{
			if ("digital".equals(type)) // 复式 1&2|3&4&5&6
			{
				datas = actionData.split("\\|");
				if (datas[0].indexOf(numberData.substring(0, 1)) >= 0
						&& datas[1].indexOf(numberData.substring(1, 2)) >= 0) {
					return true;
				}
			} else if ("input".equals(type)) // 单式 56&67&89
			{
				datas = actionData.split("&");
				for (int a = 0; a < datas.length; a++) {
					if (datas[a] == numberData.substring(0, 2)) {
						return true;
					}
				}
			}
		}else if (playId == 474)//二码后二直选和值 5&6&7&8&9
		{
			datas = actionData.split("&");
			sum=Integer.parseInt(numberData.substring(3,4))+Integer.parseInt(numberData.substring(4,5));
			for(int a=0; a<datas.length;a++)
			{
				if (Integer.parseInt(datas[a])==sum)
				{
					return true;
				}
			}
			
		}else if (playId == 472)//二码前二直选和值 13&14&15
		{
			datas = actionData.split("&");
			sum=Integer.parseInt(numberData.substring(0,1))+Integer.parseInt(numberData.substring(1,2));
			for(int a=0; a<datas.length;a++)
			{
				if (Integer.parseInt(datas[a])==sum)
				{
					return true;
				}
			}
		}else if (playId == 28)//二码后二组选
		{
			if ("digital".equals(type)) // 复式 0&1&2&3
			{
			 if (actionData.indexOf(numberData.substring(3, 4)) >= 0
						&& actionData.indexOf(numberData.substring(4, 5)) >= 0) {
					return true;
				}
			} else if ("input".equals(type)) // 单式 45&67&89
			{
				datas = actionData.split("&");
				for (int a = 0; a < datas.length; a++) {
					if (datas[a].indexOf(numberData.substring(3, 4))>=0 && datas[a].indexOf(numberData.substring(4, 5))>=0)
					{
						return true;
					}
				
				}
			}

		}else if (playId == 26)//二码前二组选
		{
			if ("digital".equals(type)) // 复式 1&2&3&4
			{
			  if (actionData.indexOf(numberData.substring(0, 1)) >= 0
						&& actionData.indexOf(numberData.substring(1, 2)) >= 0) {
					return true;
				}
			} else if ("input".equals(type)) // 单式 67&89
			{
				datas = actionData.split("&");
				for (int a = 0; a < datas.length; a++) {
					if (datas[a].indexOf(numberData.substring(0, 1))>=0 && datas[a].indexOf(numberData.substring(1, 2))>=0)
					{
						return true;
					}
				}
			}
		}else if (playId == 478)//二码后二组选和值  8&9&10&11
		{
			if (numberData.substring(3, 4)!=numberData.substring(4, 5))
			{
				datas = actionData.split("&");
				sum=Integer.parseInt(numberData.substring(3,4))+Integer.parseInt(numberData.substring(4,5));
				for (int a=0; a<datas.length; a++)
				{
					if (Integer.parseInt(datas[a])==sum)
					{
						return true;
					}
				}
				
			}
		}else if (playId == 476)//二码前二组选和值 14&15&16
		{
			if (numberData.substring(0, 1)!=numberData.substring(1, 2))
			{
				datas = actionData.split("&");
				sum=Integer.parseInt(numberData.substring(0,1))+Integer.parseInt(numberData.substring(1,2));
				for (int a=0; a<datas.length; a++)
				{
					if (Integer.parseInt(datas[a])==sum)
					{
						return true;
					}
				}
			}
		}else if (playId == 2265)// 四星直选
		{
			if ("digital".equals(type)) // 复式 0&9|1&8|2&7|3&6
			{
				datas = actionData.split("\\|");
				if (datas[0].indexOf(numberData.substring(1, 2)) >= 0
						&& datas[1].indexOf(numberData.substring(2, 3)) >= 0
						&& datas[2].indexOf(numberData.substring(3, 4)) >= 0
						&& datas[3].indexOf(numberData.substring(4, 5)) >= 0) {
					return true;
				}
				
			} else if ("input".equals(type)) // 单式 1234&5678
			{
				datas = actionData.split("&");
				for (int a = 0; a < datas.length; a++) {
					if (datas[a].equals(numberData.substring(1, 5))) {
						return true;
					}
				}
			
			}
		} else if (playId == 2269)// 四星组选(组选24) 0&1&2&3&4&5&6
		{
			numberDataArray = numberDataF(numberData.substring(1, 5)).split(",");
			if (numberDataArray.length == 4
					&& actionData.indexOf(numberData.substring(1, 2)) >= 0
					&& actionData.indexOf(numberData.substring(2, 3)) >= 0
					&& actionData.indexOf(numberData.substring(3, 4)) >= 0
					&& actionData.indexOf(numberData.substring(4, 5)) >= 0) {
				return true;
			}
             
		} else if (playId == 2270)// 四星组选(组选12) 3&4|4&5&6&7
		{
			numberDataArray = numberDataF(numberData.substring(1, 5)).split(",");
			datas = actionData.split("\\|");
			if (numberDataArray.length==3)
			{
				num=0;
				for(int a=0;a<numberDataArray.length;a++)
				{
					if (numberDataArray[a].length()==2 && datas[0].indexOf(numberDataArray[a].substring(0, 1))>=0)//二重号
					{
						num++;
					}else if  (datas[1].indexOf(numberDataArray[a])>=0)//单号
					{
						num++;
					}
					
				}
				if (num==3)
				{
					return true;
				}
			}
			
		} else if (playId == 2271)// 四星组选(组选6) 4&5&6&7
		{
			numberDataArray = numberDataF(numberData.substring(1, 5)).split(",");
			if (numberDataArray.length==2)
			{
				num=0;
				for(int a=0;a<numberDataArray.length;a++)
				{
					if (numberDataArray[a].length()==2 && actionData.indexOf(numberDataArray[a].substring(0, 1))>=0)//二重号
					{
						num++;
					}
					
				}
				if (num==2)
				{
					return true;
				}
			}
			
		} else if (playId == 2272)// 四星组选(组选4) 6&7&8|1&2&3&4
		{
			numberDataArray = numberDataF(numberData.substring(1, 5)).split(",");
			datas = actionData.split("\\|");
			if (numberDataArray.length==2)
			{
				num=0;
				for(int a=0;a<numberDataArray.length;a++)
				{
					if (numberDataArray[a].length()==3 && datas[0].indexOf(numberDataArray[a].substring(0, 1))>=0)//二重号
					{
						num++;
					}else if  (datas[1].indexOf(numberDataArray[a])>=0)//单号
					{
						num++;
					}
					
				}
				if (num==2)
				{
					return true;
				}
			}
		}else if (playId == 2274)// 五星直选
		{
			if ("digital".equals(type)) // 复式 0&1|2&3|4&5|6&7|8&9
			{
				datas = actionData.split("\\|");
				if (datas[0].indexOf(numberData.substring(0, 1))>=0
						&& datas[1].indexOf(numberData.substring(1, 2))>=0
						&& datas[2].indexOf(numberData.substring(2, 3))>=0
						&& datas[3].indexOf(numberData.substring(3, 4))>=0
						&& datas[4].indexOf(numberData.substring(4, 5))>=0)
				{
					return true;
				}
			
			} else if ("input".equals(type)) // 单式 12345&67890
			{
				datas = actionData.split("&");
				for(int a=0;a<datas.length;a++)
				{
					if (datas[a].equals(numberData))
					{
						return true;
					}
				}
			
			}
		}else if  (playId == 2278)//  五星组选（组选120） 0&1&2&3&4&5&6&7
		{
			numberDataArray=numberDataF(numberData).split(",");
			
			if (numberDataArray.length==5
				&&  actionData.indexOf(numberData.substring(0, 1))>=0
				&&	actionData.indexOf(numberData.substring(1, 2))>=0
				&&	actionData.indexOf(numberData.substring(2, 3))>=0	
				&&	actionData.indexOf(numberData.substring(3, 4))>=0
				&&	actionData.indexOf(numberData.substring(4, 5))>=0	)
			{
				return true;
			}
		
		}
		else if  (playId == 2279)//  五星组选（组选60）0&1|2&3&4&5&6
		{
			numberDataArray=numberDataF(numberData).split(",");
			datas = actionData.split("\\|");
			if (numberDataArray.length==4)
			{
				num=0;
				for(int a=0;a<numberDataArray.length;a++)
				{
					if (numberDataArray[a].length()==2 && datas[0].indexOf(numberDataArray[a].substring(0, 1))>=0)//二重号
					{
						num++;
					}else if  (datas[1].indexOf(numberDataArray[a])>=0)//单号
					{
						num++;
					}
					
				}
				if (num==4)
				{
					return true;
				}
			}
					 
		}	
		else if  (playId == 2280)//  五星组选（组选30）4&5&6|1&2&3
		{
			numberDataArray=numberDataF(numberData).split(",");
			datas = actionData.split("\\|");
			if (numberDataArray.length==3)
			{
				num=0;
				for(int a=0;a<numberDataArray.length;a++)
				{
					if (numberDataArray[a].length()==2 && datas[0].indexOf(numberDataArray[a].substring(0, 1))>=0)//二重号
					{
						num++;
					}else if  (datas[1].indexOf(numberDataArray[a])>=0)//单号
					{
						num++;
					}
					
				}
				if (num==3)
				{
					return true;
				}
			}
			
	     
				
		} else if (playId == 2281)// 五星组选（组选20）1&2&3|4&5&6&7&8&9
		{
			numberDataArray=numberDataF(numberData).split(",");
			datas = actionData.split("\\|");
			if (numberDataArray.length==3)
			{
				num=0;
				for(int a=0;a<numberDataArray.length;a++)
				{
					if (numberDataArray[a].length()==3 && datas[0].indexOf(numberDataArray[a].substring(0, 1))>=0)//三重号
					{
						num++;
					}else if  (datas[1].indexOf(numberDataArray[a])>=0)//单号
					{
						num++;
					}
					
				}
				if (num==3)
				{
					return true;
				}
			}

		} else if (playId == 2282)// 五星组选（组选10）1&2&3|5&6&7&8&9
		{
			numberDataArray=numberDataF(numberData).split(",");
			datas = actionData.split("\\|");
			if (numberDataArray.length==2)
			{
				num=0;
				for(int a=0;a<numberDataArray.length;a++)
				{
					if (numberDataArray[a].length()==3 && datas[0].indexOf(numberDataArray[a].substring(0, 1))>=0)//三重号
					{
						num++;
					}else if  (numberDataArray[a].length()==2  && datas[1].indexOf(numberDataArray[a].substring(0,1))>=0)//单号
					{
						num++;
					}
					
				}
				if (num==2)
				{
					return true;
				}
			}

		} else if (playId == 2283)// 五星组选（组选5）7&8&9|1&2&3&4&5&6
		{
			numberDataArray=numberDataF(numberData).split(",");
			datas = actionData.split("\\|");
			if (numberDataArray.length==2)
			{
				num=0;
				for(int a=0;a<numberDataArray.length;a++)
				{
					if (numberDataArray[a].length()==4 && datas[0].indexOf(numberDataArray[a].substring(0, 1))>=0)//三重号
					{
						num++;
					}else if  (datas[1].indexOf(numberDataArray[a])>=0)//单号
					{
						num++;
					}
					
				}
				if (num==2)
				{
					return true;
				}
			}
		} else if (playId == 16)// 后三组选（组选和值）4&7&8&9&10
		{
			sum = Integer.parseInt(numberData.substring(2, 3))
					+ Integer.parseInt(numberData.substring(3, 4))
					+ Integer.parseInt(numberData.substring(4, 5));
			datas = actionData.split("&");
			for (int a = 0; a < datas.length; a++) {
				if (Integer.parseInt(datas[a]) == sum) {
					return true;
				}
			}
		} else if (playId == 2)// 前三直选
		{
			if ("digital".equals(type)) // 复式 1&2&3|4&5&6|7&8&9
			{
				datas = actionData.split("\\|");
				if (datas[0].indexOf(numberData.substring(0, 1)) >= 0
						&& datas[1].indexOf(numberData.substring(1, 2)) >= 0
						&& datas[1].indexOf(numberData.substring(2, 3)) >= 0) {
					return true;
				}
			} else if ("input".equals(type)) // 单式 123&456&789
			{
				datas = actionData.split("&");
				if (datas[0].indexOf(numberData.substring(0, 1)) >= 0
						&& datas[1].indexOf(numberData.substring(1, 2)) >= 0
						&& datas[1].indexOf(numberData.substring(2, 3)) >= 0) {
					return true;
				}
			}
		} else if (playId == 3)// 前三直选(直选和值) 3&4&5&6&7
		{
			sum = Integer.parseInt(numberData.substring(0, 1))
					+ Integer.parseInt(numberData.substring(1, 2))
					+ Integer.parseInt(numberData.substring(2, 3));
			datas = actionData.split("&");
			for (int a = 0; a < datas.length; a++) {
				if (Integer.parseInt(datas[a]) == sum) {
					return true;
				}
			}

		} else if (playId == 8)// 前三组选(组三)4&5&6&7&8&9
		{
			numberDataArray=numberDataF(numberData.substring(0, 3)).split(",");
			if (numberDataArray.length==2)
			{
				num=0;
				for(int a=0;a<numberDataArray.length;a++)
				{
					if (numberDataArray[a].length()==2 && actionData.indexOf(numberDataArray[a].substring(0, 1))>=0)//二重号
					{
						num++;
					}else if  (actionData.indexOf(numberDataArray[a])>=0)//单号
					{
						num++;
					}
					
				}
				if (num==2)
				{
					return true;
				}
			}
			
		} else if (playId == 9)// 前三组选(组六)0&1&2&3&4&5&6&7&8&9
		{
			numberDataArray=numberDataF(numberData.substring(0, 3)).split(",");
			numberData = numberData.substring(0, 3);
			if (numberDataArray.length==3
					&& actionData.indexOf(numberData.substring(0, 1)) >= 0
					&& actionData.indexOf(numberData.substring(1, 2)) >= 0
					&& actionData.indexOf(numberData.substring(2, 3)) >= 0) {
				return true;
			}

		} else if (playId == 11)// 前三组选(组选和值') 3&4&5&6&7&8&9&10
		{
			sum = Integer.parseInt(numberData.substring(0, 1))
					+ Integer.parseInt(numberData.substring(1, 2))
					+ Integer.parseInt(numberData.substring(2, 3));
			datas = actionData.split("&");
			for (int a = 0; a < datas.length; a++) {
				if (Integer.parseInt(datas[a]) == sum) {
					return true;
				}
			}
		} else if (playId == 2291)// 中三码直选
		{
			if ("digital".equals(type)) // 复式 1&2|3&4|5&6
			{
				datas = actionData.split("\\|");
				if (datas[0].indexOf(numberData.substring(1, 2)) >= 0
						&& datas[1].indexOf(numberData.substring(2, 3)) >= 0
						&& datas[2].indexOf(numberData.substring(3, 4)) >= 0) {
					return true;
				}

			} else if ("input".equals(type)) // 单式 123&456&789
			{
				datas = actionData.split("&");
				if (datas[0].indexOf(numberData.substring(1, 2)) >= 0
						&& datas[1].indexOf(numberData.substring(2, 3)) >= 0
						&& datas[2].indexOf(numberData.substring(3, 4)) >= 0) {
					return true;
				}
			}
		} else if (playId == 2292)// 中三码直选（直选和值）2&3&4&5&6
		{
			sum = Integer.parseInt(numberData.substring(1, 2))
					+ Integer.parseInt(numberData.substring(2, 3))
					+ Integer.parseInt(numberData.substring(3, 4));
			datas = actionData.split("&");
			for (int a = 0; a < datas.length; a++) {
				if (Integer.parseInt(datas[a]) == sum) {
					return true;
				}
			}

		} else if (playId == 2293)// 中三码组选（组三） 4&5&6&7
		{
			numberDataArray=numberDataF(numberData.substring(1, 4)).split(",");
			if (numberDataArray.length==2)
			{
				num=0;
				for(int a=0;a<numberDataArray.length;a++)
				{
					if (numberDataArray[a].length()==2 && actionData.indexOf(numberDataArray[a].substring(0, 1))>=0)//二重号
					{
						num++;
					}else if  (actionData.indexOf(numberDataArray[a])>=0)//单号
					{
						num++;
					}
					
				}
				if (num==2)
				{
					return true;
				}
			}
			

		} else if (playId == 2294)// 中三码组选（组六）3&4&5&6&7
		{
			numberDataArray = numberDataF(numberData.substring(1, 4))
					.split(",");
			numberData = numberData.substring(1, 4);
			if (numberDataArray.length == 3
					&& actionData.indexOf(numberData.substring(0, 1)) >= 0
					&& actionData.indexOf(numberData.substring(1, 2)) >= 0
					&& actionData.indexOf(numberData.substring(2, 3)) >= 0) {
				return true;
			}

		} else if (playId == 2296)// 中三码组选（组选和值）5&6&7&8&9&10
		{
			sum = Integer.parseInt(numberData.substring(1, 2))
					+ Integer.parseInt(numberData.substring(2, 3))
					+ Integer.parseInt(numberData.substring(3, 4));
			datas = actionData.split("&");
			for (int a = 0; a < datas.length; a++) {
				if (Integer.parseInt(datas[a]) == sum) {
					return true;
				}
			}
		}else if (playId == 30)//定位胆 2&5|3|4&6|5&6|6
		{
		 datas = actionData.split("\\|");
		 if (datas[0].indexOf(numberData.substring(0, 1))>=0
				 || datas[1].indexOf(numberData.substring(1, 2))>=0
				 || datas[2].indexOf(numberData.substring(2, 3))>=0
				 || datas[3].indexOf(numberData.substring(3, 4))>=0
				 || datas[4].indexOf(numberData.substring(4, 5))>=0)
		 {
			 return true;
		 }
		} else if (playId == 18)// 不定胆（后三一码不定胆） 0&1&2&3&4&5&6&7&8&9
		{
			numberData = numberData.substring(2, 5);
			datas = actionData.split("&");
			for (int a = 0; a < datas.length; a++) {
				if (numberData.indexOf(datas[a]) >= 0) {
					return true;
				}
			}

		} else if (playId == 20)// 不定胆（后三二码不定胆）5&6&7&8&9
		{
			numberData = numberData.substring(2, 5);
			datas = actionData.split("&");
			for (int a = 0; a < datas.length; a++) {
				if (numberData.indexOf(datas[a]) >= 0) {
					num++;
				}
			}
			if (num >= 2) {
				return true;
			}

		}else if (playId == 512)//不定胆（前三一码不定胆）1&2&3&4&5
		{
			numberData=numberData
					.substring(0, 3);
			datas = actionData.split("&");
			for (int a = 0; a < datas.length; a++) {
				if (numberData.indexOf(datas[a]) >= 0) {
					return true;
				}
			}
				
		} else if (playId == 513)// 不定胆（前三二码不定胆）4&5&6&7
		{
			numberData = numberData.substring(0, 3);
			datas = actionData.split("&");
			for (int a = 0; a < datas.length; a++) {
				if (numberData.indexOf(datas[a]) >= 0) {
					num++;
				}
			}
			if (num >= 2) {
				return true;
			}

		} else if (playId == 2285)// 趣味（一帆风顺）0&1&2&3&4&5&6&7&8&9
		{
			datas = actionData.split("&");
			for (int a = 0; a < datas.length; a++) {
				if (numberData.indexOf(datas[a]) >= 0) {
					return true;
				}
			}
		} else if (playId == 2286)// 趣味（好事成双）0&1&2&3&4&5&6&7&8&9
		{
			datas = actionData.split("&");
			for (int a = 0; a < datas.length; a++) {
				num = 0;
				Pattern pt = Pattern
						.compile(datas[a], Pattern.CASE_INSENSITIVE);
				java.util.regex.Matcher mc = pt.matcher(numberData);
				mc.reset();
				while (mc.find()) {
					num++;
				}
				if (num >= 2) {
					return true;
				}
			}
		} else if (playId == 2287)// 趣味（三星报喜）0&1&2&3&4&5&6&7&8&9
		{
			datas = actionData.split("&");
			for (int a = 0; a < datas.length; a++) {
				num = 0;
				Pattern pt = Pattern
						.compile(datas[a], Pattern.CASE_INSENSITIVE);
				java.util.regex.Matcher mc = pt.matcher(numberData);
				mc.reset();
				while (mc.find()) {
					num++;
				}
				if (num >= 3) {
					return true;
				}
			}

		} else if (playId == 2288)// 趣味（四季发财）0&1&2&3&4&5&6&7&8&9
		{
			datas = actionData.split("&");
			for (int a = 0; a < datas.length; a++) {
				num = 0;
				Pattern pt = Pattern
						.compile(datas[a], Pattern.CASE_INSENSITIVE);
				java.util.regex.Matcher mc = pt.matcher(numberData);
				mc.reset();
				while (mc.find()) {
					num++;
				}
				if (num >= 4) {
					return true;
				}
			}
		} else if (playId == 38)// 大小单双（后二大小单双） 大&小&单&双|大&小&单&双
		{
			datas = actionData.split("\\|");
			String sw, gw;
			// 十位
			if (Integer.parseInt(numberData.substring(3, 4)) > 4) {
				sw = "大";
			} else {
				sw = "小";
			}
			if (Integer.parseInt(numberData.substring(3, 4)) % 2 != 0) {
				sw = sw + "单";
			} else {
				sw = sw + "双";
			}

			// 个位
			if (Integer.parseInt(numberData.substring(4, 5)) > 4) {
				gw = "大";
			} else {
				gw = "小";
			}
			if (Integer.parseInt(numberData.substring(4, 5)) % 2 != 0) {
				gw = gw + "单";
			} else {
				gw = gw + "双";
			}

			String[] swData = datas[0].split("&");
			String[] gwData = datas[1].split("&");
			for (int a = 0; a < swData.length; a++) {
				if (sw.indexOf(swData[a]) >= 0) {
					for (int b = 0; b < gwData.length; b++) {
						if (gw.indexOf(gwData[b]) >= 0) {
							return true;
						}
					}
				}
			}

		} else if (playId == 36)// 大小单双（前二大小单双） 大&小&单&双|大&小&单&双
		{
			datas = actionData.split("\\|");
			String ww, qw;
			// 万位
			if (Integer.parseInt(numberData.substring(0, 1)) > 4) {
				ww = "大";
			} else {
				ww = "小";
			}
			if (Integer.parseInt(numberData.substring(0, 1)) % 2 != 0) {
				ww = ww + "单";
			} else {
				ww = ww + "双";
			}

			// 千位
			if (Integer.parseInt(numberData.substring(1, 2)) > 4) {
				qw = "大";
			} else {
				qw = "小";
			}
			if (Integer.parseInt(numberData.substring(1, 2)) % 2 != 0) {
				qw = qw + "单";
			} else {
				qw = qw + "双";
			}

			String[] wwData = datas[0].split("&");
			String[] qwData = datas[1].split("&");
			for (int a = 0; a < wwData.length; a++) {
				if (ww.indexOf(wwData[a]) >= 0) {
					for (int b = 0; b < qwData.length; b++) {
						if (qw.indexOf(qwData[b]) >= 0) {
							return true;
						}
					}
				}
			}
		}

		return false;
		
	}
	public static String numberDataF(String data){
		boolean tag = true;
		String a = data;
		String nS = "";
		char[] as = a.toCharArray();
		for (int i = 0; i < as.length; i++) {
			char aa = as[i];
			int index = nS.indexOf(aa);
			if (index == -1)
				nS += "," + aa;
			else
				nS = nS.substring(0, index) + aa + nS.substring(index);
		}

		return nS.substring(1);
	}

	public static void main(String[] args) {

		OrderDetail orderDetail=new OrderDetail();
		orderDetail.setActionData("5&6&7&8&9");
		orderDetail.setPlayId(2287);
		orderDetail.setType("digital");
//		orderDetail.setType("input");
//		System.out.println(calcActionNumberData(orderDetail));	
//		String data = "12221";
		
//		System.out.println(test(data));
		int num =0;
		String numberData = "12345";
		String actionData = "0&1&2&3&4&5&6&7&8&9||0&1&2&3&4&5&6&7&8&9||";
		String []datas = actionData.split("\\|");
		 for(int i=0; i<datas.length;i++){
			 if (datas[i].indexOf(numberData.substring(i, i+1))>=0)
				{
					num++;
				}
		 }
		 System.out.println(num);
	}
	
	public static String test(String data){
		boolean tag = true;
		String a = data;
		String nS = "";
//		List[] ls = new ArrayList[5];
		char[] as = a.toCharArray();
		for(int i=0; i<as.length; i++){
			char aa = as[i];
			int index = nS.indexOf(aa);
			if(index == -1)
				nS += ","+aa;
			else
				nS = nS.substring(0, index)+aa+nS.substring(index);
		}

		return nS.substring(1);
	}


}
