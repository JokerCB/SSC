package com.ssc.demo.service;

import java.util.List;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ssc.demo.dao.DataDao;
import com.ssc.demo.dao.OrderDao;
import com.ssc.demo.dao.PlayedDao;
import com.ssc.demo.model.Data;
import com.ssc.demo.model.Order;
import com.ssc.demo.model.OrderDetail;
import com.ssc.demo.model.Played;

import framework.generic.utils.string.StringUtil;


@Service("playedService")
public class PlayedServiceImpl implements PlayedService{

	@Resource
	private DataDao  dataDao;
	
	@Resource
	private OrderDao orderDao;
	
	@Resource
	private PlayedDao playedDao;

	@Override
	public Played load(int id) {
		
		return playedDao.load(id);
	}
	
	public List<Played> findAll(){
		return playedDao.findAll();
	}
	
	/**
	 * 通过投注号码计算出注数
	 * @return
	 */
	public int getActionNum(int playedId, String actionData, String type){
		Played played = this.load(playedId);
		int sum = 0;
		if("后三直选(复式/单式)".equals(played.getName()) || "前三直选(复式/单式)".equals(played.getName())
				|| "中三直选(复式/单式)".equals(played.getName())){
			if("digital".equals(type)){
				String[] datas = actionData.split("\\|");
				int a = datas[0].split("&").length;
				int b = datas[1].split("&").length;
				int c = datas[2].split("&").length;
				sum = a*b*c;
			}
			else
				sum = actionData.split("&").length;
		}
		else if("后三直选和值".equals(played.getName()) || "前三码_直选和值".equals(played.getName())
				|| "中三码_直选和值".equals(played.getName())){
			
			String[] datas = actionData.split("&");
			for(int i=0; i<datas.length; i++){
				int data = Integer.parseInt(datas[i]);
				for(int a=0; a<10; a++){
					for(int b=0; b<10; b++){
						for(int c=0; c<10; c++){
							if((a+b+c) == data)
								sum++;
						}
					}
				}
			}			
		}
		else if("后三码_组选和值".equals(played.getName()) || "前三码_组选和值".equals(played.getName())
				|| "中三码_组选和值".equals(played.getName())){
			String[] datas = actionData.split("&");
			for(int i=0; i<datas.length; i++){
				int data = Integer.parseInt(datas[i]);
				for(int a=0; a<10; a++){
					for(int b=0; b<10; b++){
						for(int c=0; c<10; c++){
							if(a<=b && b<=c && (a+b+c) == data)
							{
								if(!(a==b && b==c))
								sum++;
							}
						}
					}
				}
			}	
		}
		else if("后三码_组六".equals(played.getName()) || "前三码_组六".equals(played.getName())
				|| "中三码_组六".equals(played.getName())){
			String[] datas = actionData.split("&");
			for(int a=0; a<datas.length; a++){
				for(int b=0; b<datas.length; b++){
					for(int c=0; c<datas.length; c++){
						int aa = Integer.parseInt(datas[a]);
						int bb = Integer.parseInt(datas[b]);
						int cc = Integer.parseInt(datas[c]);
						if(aa<=bb && bb<=cc)
							if((aa!=bb && bb!=cc && aa!=cc))
							sum++;

					}
				}
			}
		}
		else if("后三组三".equals(played.getName()) || "前三码_组三".equals(played.getName())
				|| "中三码_组三".equals(played.getName())){
			String[] datas = actionData.split("&");
			sum = datas.length * (datas.length-1);
		}
		
		else if("二码_后二直选(复式))".equals(played.getName()) || "二码_前二直选(复式)".equals(played.getName())){
			if("digital".equals(type)){
				String[] datas = actionData.split("\\|");
				int a = datas[0].split("&").length;
				int b = datas[1].split("&").length;
				sum = a*b;
			}
			else
				sum = actionData.split("&").length;
		}
		else if("二码_后二直选和值".equals(played.getName()) || "二码_前二直选和值".equals(played.getName())){
			
			String[] datas = actionData.split("&");
			for(int i=0; i<datas.length; i++){
				int data = Integer.parseInt(datas[i]);
				for(int a=0; a<10; a++){
					for(int b=0; b<10; b++){
						if((a+b) == data)
							sum++;	
					}
				}
			}			
		}
		else if("二码_后二组选和值".equals(played.getName()) || "二码_前二组选和值".equals(played.getName())){
			String[] datas = actionData.split("&");
			for(int i=0; i<datas.length; i++){
				int data = Integer.parseInt(datas[i]);
				for(int a=0; a<10; a++){
					for(int b=0; b<10; b++){
						if(a!=b && (a+b) == data)
						{
							sum++;
						}
					}
				}
			}
		}
		else if("二码_后二组选(复式)".equals(played.getName()) || "二码_前二组选(复式)".equals(played.getName())){
			if("digital".equals(type)){
				int len = actionData.split("&").length;
				for(int i=2;i<=len; i++)
					sum += i-1;
			}
			else
				sum = actionData.split("&").length;
		}
		
		else if("四星_复式/单式".equals(played.getName())){
			if("digital".equals(type)){
				String[] datas = actionData.split("\\|");
				int a = datas[0].split("&").length;
				int b = datas[1].split("&").length;
				int c = datas[2].split("&").length;
				int d = datas[3].split("&").length;
				sum = a*b*c*d;
			}
			else
				sum = actionData.split("&").length;
		}
		else if("四星_组合".equals(played.getName())){
			String[] datas = actionData.split("\\|");
			int a = datas[0].split("&").length;
			int b = datas[1].split("&").length;
			int c = datas[2].split("&").length;
			int d = datas[3].split("&").length;
			sum = 4*a*b*c*d;
		}
		else if("四星_组选24".equals(played.getName())){
			int a[] = {1,5,15,35,70,126,210};
			sum = a[actionData.split("&").length -4];
		}
		else if("四星_组选12".equals(played.getName())){
			int a[] = {1,3,6,10,15,21,28,36};
			String[] datas = actionData.split("\\|");
			String[] d1 = datas[0].split("&");
			String[] d2 = datas[1].split("&");
			for(int i=0; i<d1.length; i++){
				int m = d2.length -2;
				for(int j=0; j<d2.length; j++){
					if(d2[j].equals(d1[i]))
						m--;
				}
				sum += a[m];
			}
		}
		else if("四星_组选6".equals(played.getName())){
			int a[]={1,3,6,10,15,21,28,36,45};
			sum = a[actionData.split("&").length - 2];
		}
		
		else if("五星(复式/单式)".equals(played.getName())){
			if("digital".equals(type)){
				String[] datas = actionData.split("\\|");
				int a = datas[0].split("&").length;
				int b = datas[1].split("&").length;
				int c = datas[2].split("&").length;
				int d = datas[3].split("&").length;
				int e = datas[4].split("&").length;
				sum = a*b*c*d*e;
			}
			else
				sum = actionData.split("&").length;
		}
		else if("五星_组合".equals(played.getName())){
			String[] datas = actionData.split("\\|");
			int a = datas[0].split("&").length;
			int b = datas[1].split("&").length;
			int c = datas[2].split("&").length;
			int d = datas[3].split("&").length;
			int e = datas[4].split("&").length;
			sum = 5*a*b*c*d*e;
		}
		else if("五星_组选120".equals(played.getName())){
			int a[] = {1,6,21,56,126,252};
			sum = a[actionData.split("&").length -5];
		}
		else if("五星_组选60".equals(played.getName())){
			int a[] = {1,4,10,20,35,56,84};
			String[] datas = actionData.split("\\|");
			String[] d1 = datas[0].split("&");
			String[] d2 = datas[1].split("&");
			for(int i=0; i<d1.length; i++){
				int m = d2.length -3;
				for(int j=0; j<d2.length; j++){
					if(d2[j].equals(d1[i]))
						m--;
				}
				sum += a[m];
			}
		}
		else if("五星_组选30".equals(played.getName())){
			int a[] = {1,3,6,10,15,21,28,36};
			String[] datas = actionData.split("\\|");
			String[] d2 = datas[0].split("&");//两个二重号
			String[] d1 = datas[1].split("&");//一个一单号
			for(int i=0; i<d1.length; i++){
				int m = d2.length -2;
				for(int j=0; j<d2.length; j++){
					if(d2[j].equals(d1[i]))
						m--;
				}
				sum += a[m];
			}
		}
		else if("五星_组选20".equals(played.getName())){
			int a[] = {1,3,6,10,15,21,28,36};
			String[] datas = actionData.split("\\|");
			String[] d1 = datas[0].split("&");//一个三重号
			String[] d2 = datas[1].split("&");//两个单号
			for(int i=0; i<d1.length; i++){
				int m = d2.length -2;
				for(int j=0; j<d2.length; j++){
					if(d2[j].equals(d1[i]))
						m--;
				}
				sum += a[m];
			}
		}
		else if("五星_组选10".equals(played.getName()) || "五星_组选5".equals(played.getName())
				|| "四星_组选4".equals(played.getName())){
			String[] datas = actionData.split("\\|");
			String[] d1 = datas[0].split("&");//一个三重号||一个四重号 ||一个三重号
			String[] d2 = datas[1].split("&");//一个二重号||一个单号     ||一个单号
			for(int i=0; i<d1.length; i++){
				int m = d2.length;
				for(int j=0; j<d2.length; j++){
					if(d2[j].equals(d1[i]))
						m--;
				}
				sum += m;
			}
		}
		else if("定位胆_定位胆".equals(played.getName())){
			String[] datas = actionData.split("\\|");
			for(int i=0; i<datas.length; i++){
				if("".equals(datas[i]))
					continue;
				sum += datas[i].split("&").length;
			}
		}
		else if("不定胆_后三一码不定胆".equals(played.getName()) || "不定胆_前三一码不定胆".equals(played.getName()) 
				|| "趣味_一帆风顺".equals(played.getName()) || "趣味_好事成双".equals(played.getName())
				|| "趣味_三星报喜".equals(played.getName()) || "趣味_四季发财".equals(played.getName())){
			sum = actionData.split("&").length;			
		}
		else if("不定胆_后三二码不定胆".equals(played.getName()) || "不定胆_前三二码不定胆".equals(played.getName())){
			int a[] = {1,3,6,10,15,21,28,36,45};
			sum = a[actionData.split("&").length-2];			
		}
		else if("[大小单双_前二] 双,双".equals(played.getName()) || "[大小单双_后二] 小,单".equals(played.getName())){
			String[] datas = actionData.split("\\|");
			sum = datas[0].split("&").length* datas[1].split("&").length;			
		}
		
		return sum;
	}
	
	@Override
	public boolean calcActionNumberData(OrderDetail detail) {
		
		 boolean isZJ=false;
		 
		Played played = this.load(detail.getPlayId());
		Order order = orderDao.load(detail.getOrderId());
		//根据期号获取当期开奖数；
		Data data=dataDao.find(played.getType(), order.getLtIssueStart());
		if (!StringUtil.isNullOrEmpty(data))
		{
			//开奖数据
			String numberData=data.getData();
	
				
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
						
				if (playId == 2274)// 五星直选
				{
					if ("digital".equals(detail.getType())) // 复式
					{
						if (actionData.equals(
								numberData)) {
							isZJ=true;
						}
					} else if ("input".equals(detail.getType())) // 单式
					{
						if (actionData.equals(numberData)) {
							isZJ=true;
						} 
					}
				}
				else if (playId == 2276)//  五星直选组合  0&1|2&3|4&5|6&7|8&9
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
				else if  (playId == 2278)//  五星组选（组选120）
				{
					if (numberData.indexOf(actionData.substring(0, 1))>=0 
							&& numberData.indexOf(actionData.substring(1, 2))>=0
							&& numberData.indexOf(actionData.substring(2, 3))>=0 
							&& numberData.indexOf(actionData.substring(3, 4))>=0
							&& numberData.indexOf(actionData.substring(4, 5))>=0)
					{
						isZJ=true;
					}
				}
				else if  (playId == 2279)//  五星组选（组选60）8|0&2&5
				{
					 Pattern pt = Pattern.compile(actionData.substring(0, 1), Pattern.CASE_INSENSITIVE);
					 java.util.regex.Matcher mc = pt.matcher(numberData);
					 mc.reset();
					while (mc.find()) {
				       num++;
				       }
					if (num==2 && numberData.indexOf(actionData.substring(1, 2))>=0
							&& numberData.indexOf(actionData.substring(2, 3))>=0
							&& numberData.indexOf(actionData.substring(3, 4))>=0) 
					{
						isZJ=true;
					}
				}	
				else if  (playId == 2280)//  五星组选（组选30）2&8|0
				{
					Pattern pt = Pattern.compile(actionData.substring(0, 1), Pattern.CASE_INSENSITIVE);
					 java.util.regex.Matcher mc = pt.matcher(numberData);
					 mc.reset();
					while (mc.find()) {
				       num++;
				       }
					if (num==2)
					{
						num=0;
						 pt = Pattern.compile(actionData.substring(1, 2), Pattern.CASE_INSENSITIVE);
						 mc = pt.matcher(numberData);
						 mc.reset();
						while (mc.find()) {
					       num++;
					       }
						if (num==2 && numberData.indexOf(actionData.substring(2, 3))>=0)
						{
							isZJ=true;
						}
					}
				}
				else if  (playId == 2281)//  五星组选（组选20）8|0&2
				{
					 Pattern pt = Pattern.compile(actionData.substring(0, 1), Pattern.CASE_INSENSITIVE);
					 java.util.regex.Matcher mc = pt.matcher(numberData);
					 mc.reset();
					while (mc.find()) {
				       num++;
				       }
					if (num==3 && numberData.indexOf(actionData.substring(1, 2))>=0
							&& numberData.indexOf(actionData.substring(2, 3))>=0)
					{
						isZJ=true;
					}
					
				}
				else if  (playId == 2282)//  五星组选（组选10）8|2
				{
					Pattern pt = Pattern.compile(
							actionData.substring(0, 1),
							Pattern.CASE_INSENSITIVE);
					java.util.regex.Matcher mc = pt.matcher(numberData);
					mc.reset();
					while (mc.find()) {
						num++;
					}
					if (num == 3) {
						num = 0;
						pt = Pattern.compile(
								actionData.substring(1, 2),
								Pattern.CASE_INSENSITIVE);
						mc = pt.matcher(numberData);
						mc.reset();
						while (mc.find()) {
							num++;
						}
						if (num == 2) {
							isZJ = true;
						}
					}
					
				}
				else if  (playId == 2283)//  五星组选（组选5）8|2
				{
				   Pattern pt = Pattern.compile(
							actionData.substring(0, 1),
							Pattern.CASE_INSENSITIVE);
					java.util.regex.Matcher mc = pt.matcher(numberData);
					mc.reset();
					while (mc.find()) {
						num++;
					}
					if (num == 4) {
						num = 0;
						pt = Pattern.compile(
								actionData.substring(1, 2),
								Pattern.CASE_INSENSITIVE);
						mc = pt.matcher(numberData);
						mc.reset();
						while (mc.find()) {
							num++;
						}
						if (num == 1) {
							isZJ = true;
						}
					}
				}else if (playId == 2265)// 四星直选
				{
					if ("digital".equals(detail.getType())) // 复式
					{
						if (actionData.equals(numberData
								.substring(1, 5))) {
							isZJ = true;
						}
					} else if ("input".equals(detail.getType())) // 单式
					{
						if (actionData.equals(numberData
								.substring(1, 5))) {
							isZJ = true;
						}
					}
				} else if (playId == 2267)// 四星组合 1&2&3|4|5|6&7
				{
					actionDatas=actionDatas.replace("&", "");
					String gw=actionDatas.substring(actionDatas.lastIndexOf("|")+1, actionDatas.length());
					if (gw.indexOf(numberData.substring(4, 5))>=0)//个位
					{
						zjCount=4;
						actionDatas=actionDatas.substring(0,actionDatas.lastIndexOf("|"));
						gw=actionDatas.substring(actionDatas.lastIndexOf("|")+1, actionDatas.length());
						if (gw.indexOf(numberData.substring(3, 4))>=0)//十位
						{
							zjCount=3;
						}
						actionDatas=actionDatas.substring(0,actionDatas.lastIndexOf("|"));
						gw=actionDatas.substring(actionDatas.lastIndexOf("|")+1, actionDatas.length());
						if (gw.indexOf(numberData.substring(2, 3))>=0)//百位
						{
							zjCount=2;
						}
						actionDatas=actionDatas.substring(0,actionDatas.lastIndexOf("|"));
						gw=actionDatas.substring(actionDatas.lastIndexOf("|")+1, actionDatas.length());
						if (gw.indexOf(numberData.substring(1, 2))>=0)//千位
						{
							zjCount=1;
						}
					}
					

				} else if (playId == 2269)// 四星组选(组选24) 0&5&6&8
				{
                      String numberDatat=numberData.substring(1, 5);
                      if (numberDatat.indexOf(actionData.substring(0, 1))>=0
                    		  && numberDatat.indexOf(actionData.substring(1, 2))>=0
                    		  && numberDatat.indexOf(actionData.substring(2, 3))>=0
                    		  && numberDatat.indexOf(actionData.substring(3, 4))>=0)
                      {
                    	  isZJ = true;
                      }
                      
				}else if (playId == 2270)// 四星组选(组选12) 8|0&6
				{
					Pattern pt = Pattern.compile(
							actionData.substring(0, 1),
							Pattern.CASE_INSENSITIVE);
					java.util.regex.Matcher mc = pt.matcher(numberData);
					mc.reset();
					while (mc.find()) {
						num++;
					}
					if (num==2 && numberData.indexOf(actionData.substring(1, 2))>=0
							&& numberData.indexOf(actionData.substring(2, 3))>=0)
					{
						 isZJ = true;
					}
				}else if (playId == 2271)// 四星组选(组选6) 6&8
				{
					Pattern pt = Pattern.compile(
							actionData.substring(0, 1),
							Pattern.CASE_INSENSITIVE);
					java.util.regex.Matcher mc = pt.matcher(numberData);
					mc.reset();
					while (mc.find()) {
						num++;
					}
					if (num==2)
					{
						num=0;
						 pt = Pattern.compile(
									actionData.substring(1, 2),
									Pattern.CASE_INSENSITIVE);
							 mc = pt.matcher(numberData);
							mc.reset();
							while (mc.find()) {
								num++;
							}
							if (num==2)
							{
								isZJ = true;
							}
						
					}
				}else if (playId == 2272)// 四星组选(组选4) 8|2
				{
					Pattern pt = Pattern.compile(
							actionData.substring(0, 1),
							Pattern.CASE_INSENSITIVE);
					java.util.regex.Matcher mc = pt.matcher(numberData);
					mc.reset();
					while (mc.find()) {
						num++;
					}
					if (num==3 && numberData.indexOf(actionData.substring(1, 2))>=0)
					{
						isZJ = true;
					}
				}else if (playId == 5)// 后三码直选
				{
					if ("digital".equals(detail.getType())) // 复式 1&2&3|1&2&3|1&2&3
					{
					String[] datas = actionDatas.split("\\|");
					if (datas[0].indexOf(numberData.substring(2, 3)) >= 0
							&& datas[1].indexOf(numberData.substring(3, 4)) >= 0
							&& datas[2].indexOf(numberData.substring(4, 5)) >= 0) {
						isZJ = true;
					}
					
					} else if ("input".equals(detail.getType())) // 单式 345&678
					{
						String[] datas = actionDatas.split("&");
						for (int a=0; a<datas.length;a++)
						{
							if (datas[a]==numberData
									.substring(2, 5))
							{
								isZJ = true;
							}
						}
						
					}
				}else if (playId == 6)// 后三码直选(直选和值)
				{
					sum=Integer.parseInt(numberData.substring(2,3))+Integer.parseInt(numberData.substring(3,4))+Integer.parseInt(numberData.substring(4,5));
					String[] datas = actionDatas.split("&");
					for (int a=0; a<datas.length;a++)
					{
						if (Integer.parseInt(datas[a])==sum)
						{
							isZJ = true;
						}
					}
					
				}else if (playId == 13)// 后三组选（组三）5&8
				{
					Pattern pt = Pattern.compile(
							actionData.substring(0, 1),
							Pattern.CASE_INSENSITIVE);
					java.util.regex.Matcher mc = pt.matcher(numberData.substring(2,5));
					mc.reset();
					while (mc.find()) {
						num++;
					}
					int num2=0;
					pt = Pattern.compile(
							actionData.substring(1, 2),
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
					
				}else if (playId == 14)// 后三组选（组六）2&5&8
				{
					Pattern pt = Pattern.compile(
							actionData.substring(0, 1),
							Pattern.CASE_INSENSITIVE);
					java.util.regex.Matcher mc = pt.matcher(numberData.substring(2,5));
					mc.reset();
					while (mc.find()) {
						num++;
					}
					int num2=0;
					pt = Pattern.compile(
							actionData.substring(1, 2),
							Pattern.CASE_INSENSITIVE);
					 mc = pt.matcher(numberData.substring(2,5));
					mc.reset();
					while (mc.find()) {
						num2++;
					}
					int num3=0;
					pt = Pattern.compile(
							actionData.substring(2, 3),
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
				}else if (playId == 15)// 后三组选（混合组选）123&223&234&334
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
				}else if (playId == 16)//后三组选（组选和值）3
				{
					sum=Integer.parseInt(numberData.substring(2,3))+Integer.parseInt(numberData.substring(3,4))+Integer.parseInt(numberData.substring(4,5));
					if (Integer.parseInt(actionData)==sum)
					{
						isZJ = true;
					}
				}else if (playId == 2)//前三直选
				{
					if ("digital".equals(detail.getType())) // 复式 3|4|5
					{
						if (actionData.equals(numberData
								.substring(0, 3))) {
							isZJ = true;
						}
					} else if ("input".equals(detail
							.getType())) // 单式 345
					{
						if (actionData.equals(numberData
								.substring(0, 3))) {
							isZJ = true;
						}
					}
				}else if (playId == 3)//前三直选(直选和值)
				{
					sum=Integer.parseInt(numberData.substring(0,1))+Integer.parseInt(numberData.substring(1,2))+Integer.parseInt(numberData.substring(2,3));
					if (Integer.parseInt(actionData)==sum)
					{
						isZJ = true;
					}
				}else if (playId == 8)//前三组选(组三)5&8
				{
					Pattern pt = Pattern.compile(
							actionData.substring(0, 1),
							Pattern.CASE_INSENSITIVE);
					java.util.regex.Matcher mc = pt.matcher(numberData.substring(0,3));
					mc.reset();
					while (mc.find()) {
						num++;
					}
					int num2=0;
					pt = Pattern.compile(
							actionData.substring(1, 2),
							Pattern.CASE_INSENSITIVE);
					 mc = pt.matcher(numberData.substring(0,3));
					mc.reset();
					while (mc.find()) {
						num2++;
					}
					if (num==2 || num2==2)
					{
						isZJ = true;
					}
				}else if (playId == 9)//前三组选(组六)2&5&8
				{
					Pattern pt = Pattern.compile(
							actionData.substring(0, 1),
							Pattern.CASE_INSENSITIVE);
					java.util.regex.Matcher mc = pt.matcher(numberData.substring(0,3));
					mc.reset();
					while (mc.find()) {
						num++;
					}
					int num2=0;
					pt = Pattern.compile(
							actionData.substring(1, 2),
							Pattern.CASE_INSENSITIVE);
					 mc = pt.matcher(numberData.substring(0,3));
					mc.reset();
					while (mc.find()) {
						num2++;
					}
					int num3=0;
					pt = Pattern.compile(
							actionData.substring(2, 3),
							Pattern.CASE_INSENSITIVE);
					 mc = pt.matcher(numberData.substring(0,3));
					mc.reset();
					while (mc.find()) {
						num3++;
					}
					
					if (num==1 && num2==1  && num3==1)
					{
						isZJ = true;
					}
				}else if (playId == 99999)//前三组选(混合组选) 2&5&8
				{
					
				}else if (playId == 11)//前三组选(组选和值') 
				{
					sum=Integer.parseInt(numberData.substring(0,1))+Integer.parseInt(numberData.substring(1,2))+Integer.parseInt(numberData.substring(2,3));
					if (Integer.parseInt(actionData)==sum)
					{
						isZJ = true;
					}
				}else if (playId == 2291)//中三码直选
				{
					if ("digital".equals(detail.getType())) // 复式 3|4|5
					{
						if (actionData.equals(numberData
								.substring(1, 4))) {
							isZJ = true;
						}
					} else if ("input".equals(detail
							.getType())) // 单式 345
					{
						if (actionData.equals(numberData
								.substring(1, 4))) {
							isZJ = true;
						}
					}
				}else if (playId == 2292)//中三码直选（直选和值）
				{
					sum=Integer.parseInt(numberData.substring(1,2))+Integer.parseInt(numberData.substring(2,3))+Integer.parseInt(numberData.substring(3,4));
					if (Integer.parseInt(actionData)==sum)
					{
						isZJ = true;
					}
				}else if (playId == 2293)//中三码组选（组三）
				{
					Pattern pt = Pattern.compile(
							actionData.substring(0, 1),
							Pattern.CASE_INSENSITIVE);
					java.util.regex.Matcher mc = pt.matcher(numberData
							.substring(1, 4));
					mc.reset();
					while (mc.find()) {
						num++;
					}
					int num2 = 0;
					pt = Pattern.compile(actionData.substring(1, 2),
							Pattern.CASE_INSENSITIVE);
					mc = pt.matcher(numberData.substring(1, 4));
					mc.reset();
					while (mc.find()) {
						num2++;
					}
					if (num == 2 || num2 == 2) {
						isZJ = true;
					}
				}else if (playId == 99999)//中三码组选（混合）
				{
					
				}else if (playId == 2294)//中三码组选（组六）
				{
					Pattern pt = Pattern.compile(
							actionData.substring(0, 1),
							Pattern.CASE_INSENSITIVE);
					java.util.regex.Matcher mc = pt.matcher(numberData
							.substring(1, 4));
					mc.reset();
					while (mc.find()) {
						num++;
					}
					int num2 = 0;
					pt = Pattern.compile(actionData.substring(1, 2),
							Pattern.CASE_INSENSITIVE);
					mc = pt.matcher(numberData.substring(1, 4));
					mc.reset();
					while (mc.find()) {
						num2++;
					}
					int num3 = 0;
					pt = Pattern.compile(actionData.substring(2, 3),
							Pattern.CASE_INSENSITIVE);
					mc = pt.matcher(numberData.substring(1, 4));
					mc.reset();
					while (mc.find()) {
						num3++;
					}

					if (num == 1 && num2 == 1 && num3 == 1) {
						isZJ = true;
					}
				}else if (playId == 2296)//中三码组选（组选和值）
				{
					sum=Integer.parseInt(numberData.substring(1,2))+Integer.parseInt(numberData.substring(2,3))+Integer.parseInt(numberData.substring(3,4));
					if (Integer.parseInt(actionData)==sum)
					{
						isZJ = true;
					}
				}else if (playId == 24)//二码后二直选
				{
					if ("digital".equals(detail.getType())) // 复式 3|4|5
					{
						if (actionData.equals(numberData
								.substring(3, 5))) {
							isZJ = true;
						}
					} else if ("input".equals(detail
							.getType())) // 单式 345
					{
						if (actionData.equals(numberData
								.substring(3, 5))) {
							isZJ = true;
						}
					}
				}else if (playId == 22)//二码前二直选
				{
					if ("digital".equals(detail.getType())) // 复式 3|4|5
					{
						if (actionData.equals(numberData
								.substring(0, 2))) {
							isZJ = true;
						}
					} else if ("input".equals(detail
							.getType())) // 单式 345
					{
						if (actionData.equals(numberData
								.substring(0, 2))) {
							isZJ = true;
						}
					}
				}else if (playId == 474)//二码后二直选和值
				{
					sum=Integer.parseInt(numberData.substring(3,4))+Integer.parseInt(numberData.substring(4,5));
					if (Integer.parseInt(actionData)==sum)
					{
						isZJ = true;
					}
				}else if (playId == 472)//二码前二直选和值
				{
					sum=Integer.parseInt(numberData.substring(0,1))+Integer.parseInt(numberData.substring(1,2));
					if (Integer.parseInt(actionData)==sum)
					{
						isZJ = true;
					}
				}else if (playId == 28)//二码后二组选
				{
					Pattern pt = Pattern.compile(
							actionData.substring(0, 1),
							Pattern.CASE_INSENSITIVE);
					java.util.regex.Matcher mc = pt.matcher(numberData
							.substring(3, 5));
					mc.reset();
					while (mc.find()) {
						num++;
					}
					if (num==1)
					{
						num=0;
						 pt = Pattern.compile(
								actionData.substring(1, 2),
								Pattern.CASE_INSENSITIVE);
						 mc = pt.matcher(numberData
								.substring(3, 5));
						mc.reset();
						while (mc.find()) {
							num++;
						}
						if (num==1)
						{
							isZJ = true;
						}
					}
		
				}else if (playId == 26)//二码前二组选
				{
					Pattern pt = Pattern.compile(
							actionData.substring(0, 1),
							Pattern.CASE_INSENSITIVE);
					java.util.regex.Matcher mc = pt.matcher(numberData
							.substring(0, 2));
					mc.reset();
					while (mc.find()) {
						num++;
					}
					if (num == 1) {
						num = 0;
						pt = Pattern.compile(
								actionData.substring(1, 2),
								Pattern.CASE_INSENSITIVE);
						mc = pt.matcher(numberData.substring(0, 2));
						mc.reset();
						while (mc.find()) {
							num++;
						}
						if (num == 1) {
							isZJ = true;
						}
					}
				}else if (playId == 478)//二码后二组选和值
				{
					if (numberData.substring(3, 4)!=numberData.substring(4, 5))
					{
						sum=Integer.parseInt(numberData.substring(3,4))+Integer.parseInt(numberData.substring(4,5));
						if (Integer.parseInt(actionData)==sum)
						{
							isZJ = true;
						}
					}
				}else if (playId == 476)//二码前二组选和值
				{
					if (numberData.substring(0, 1)!=numberData.substring(1, 2))
					{
						sum=Integer.parseInt(numberData.substring(0,1))+Integer.parseInt(numberData.substring(1,2));
						if (Integer.parseInt(actionData)==sum)
						{
							isZJ = true;
						}
					}
				}else if (playId == 18)//不定胆（后三一码不定胆）
				{
					Pattern pt = Pattern.compile(
							actionData.substring(0, 1),
							Pattern.CASE_INSENSITIVE);
					java.util.regex.Matcher mc = pt.matcher(numberData
							.substring(2, 5));
					mc.reset();
					while (mc.find()) {
						num++;
					}
					if (num >= 1) {
						isZJ = true;
					}
				}else if (playId == 20)//不定胆（后三二码不定胆）
				{
					Pattern pt = Pattern.compile(
							actionData.substring(0, 1),
							Pattern.CASE_INSENSITIVE);
					java.util.regex.Matcher mc = pt.matcher(numberData
							.substring(2, 5));
					mc.reset();
					while (mc.find()) {
						num++;
					}
					if (num >= 1) {
						num=0;
						 pt = Pattern.compile(
								actionData.substring(1, 2),
								Pattern.CASE_INSENSITIVE);
						 mc = pt.matcher(numberData
								.substring(2, 5));
						mc.reset();
						while (mc.find()) {
							num++;
						}
						if (num >= 1) 
						{
							isZJ = true;
						}
						
					}
				}else if (playId == 512)//不定胆（前三一码不定胆）
				{
					Pattern pt = Pattern.compile(
							actionData.substring(0, 1),
							Pattern.CASE_INSENSITIVE);
					java.util.regex.Matcher mc = pt.matcher(numberData
							.substring(0, 3));
					mc.reset();
					while (mc.find()) {
						num++;
					}
					if (num >= 1) {
						isZJ = true;
					}
				}else if (playId == 513)//不定胆（前三二码不定胆）
				{
					Pattern pt = Pattern.compile(
							actionData.substring(0, 1),
							Pattern.CASE_INSENSITIVE);
					java.util.regex.Matcher mc = pt.matcher(numberData
							.substring(0, 3));
					mc.reset();
					while (mc.find()) {
						num++;
					}
					if (num >= 1) {
						num=0;
						 pt = Pattern.compile(
								actionData.substring(1, 2),
								Pattern.CASE_INSENSITIVE);
						 mc = pt.matcher(numberData
								.substring(0, 3));
						mc.reset();
						while (mc.find()) {
							num++;
						}
						if (num >= 1) 
						{
							isZJ = true;
						}
						
					}
				}else if (playId == 2285)//趣味（一帆风顺）
				{
					Pattern pt = Pattern.compile(
							actionData.substring(0, 1),
							Pattern.CASE_INSENSITIVE);
					java.util.regex.Matcher mc = pt.matcher(numberData);
					mc.reset();
					while (mc.find()) {
						num++;
					}
					if (num >= 1) {
						isZJ = true;
					}
				}else if (playId == 2286)//趣味（好事成双）
				{
					Pattern pt = Pattern.compile(
							actionData.substring(0, 1),
							Pattern.CASE_INSENSITIVE);
					java.util.regex.Matcher mc = pt.matcher(numberData);
					mc.reset();
					while (mc.find()) {
						num++;
					}
					if (num >= 2) {
						isZJ = true;
					}
				}else if (playId == 2287)//趣味（三星报喜）
				{
					Pattern pt = Pattern.compile(
							actionData.substring(0, 1),
							Pattern.CASE_INSENSITIVE);
					java.util.regex.Matcher mc = pt.matcher(numberData);
					mc.reset();
					while (mc.find()) {
						num++;
					}
					if (num >= 3) {
						isZJ = true;
					}
				}else if (playId == 2288)//趣味（四季发财）
				{
					Pattern pt = Pattern.compile(
							actionData.substring(0, 1),
							Pattern.CASE_INSENSITIVE);
					java.util.regex.Matcher mc = pt.matcher(numberData);
					mc.reset();
					while (mc.find()) {
						num++;
					}
					if (num >= 4) {
						isZJ = true;
					}
				}else if (playId == 30)//定位胆1|2&3|5&6|7|8
				{
					String[] datas = actionDatas.split("\\|");
					num=0;
		            for (int m=0;m<datas.length;m++)
					{
													
						Pattern pt = Pattern.compile(
								numberData.substring(0+m, 1+m),
								Pattern.CASE_INSENSITIVE);
						java.util.regex.Matcher mc = pt.matcher(datas[m].replace("&", ""));
						mc.reset();
						while (mc.find()) {
							num++;
						}
					
					}
					if (num>0)
					{
						zjCount=num;
						isZJ = true;
					}
				}else if (playId == 38)//大小单双（后二大小单双） 大|小
				{
					boolean sw=false;
					boolean gw=false;
					//十位
					if ("大".equals(actionData.substring(0, 1)))
					{
						if (Integer
								.parseInt(numberData.substring(3, 4)) > 4) {
							sw = true;
						}
					}else if ("小".equals(actionData.substring(0, 1)))
					{
						if (Integer
								.parseInt(numberData.substring(3, 4)) <= 4) {
							sw = true;
						}
					}else if ("单".equals(actionData.substring(0, 1)))
					{
						if (Integer
								.parseInt(numberData.substring(3, 4))%24>0) {
							sw = true;
						}
					}else if ("双".equals(actionData.substring(0, 1)))
					{
						if (Integer
								.parseInt(numberData.substring(3, 4)) %2==0) {
							sw = true;
						}
					}
					
					//个位
					if ("大".equals(actionData.substring(1, 2)))
					{
						if (Integer
								.parseInt(numberData.substring(4, 5)) > 4) {
							gw = true;
						}
					}else if ("小".equals(actionData.substring(1, 2)))
					{
						if (Integer
								.parseInt(numberData.substring(4, 5)) <= 4) {
							gw = true;
						}
					}else if ("单".equals(actionData.substring(1, 2)))
					{
						if (Integer
								.parseInt(numberData.substring(4, 5))%24>0) {
							gw = true;
						}
					}else if ("双".equals(actionData.substring(1, 2)))
					{
						if (Integer
								.parseInt(numberData.substring(4, 5)) %2==0) {
							gw = true;
						}
					}
					
					if (gw && sw)
					{
						isZJ = true;
					}
										
					
				}else if (playId == 36)//大小单双（前二大小单双） 单|双
				{
					boolean ww=false;
					boolean qw=false;
					//万位
					if ("大".equals(actionData.substring(0, 1)))
					{
						if (Integer
								.parseInt(numberData.substring(0, 1)) > 4) {
							ww = true;
						}
					}else if ("小".equals(actionData.substring(0, 1)))
					{
						if (Integer
								.parseInt(numberData.substring(0, 1)) <= 4) {
							ww = true;
						}
					}else if ("单".equals(actionData.substring(0, 1)))
					{
						if (Integer
								.parseInt(numberData.substring(0, 1))%24>0) {
							ww = true;
						}
					}else if ("双".equals(actionData.substring(0, 1)))
					{
						if (Integer
								.parseInt(numberData.substring(0, 1)) %2==0) {
							ww = true;
						}
					}
					
					//千位
					if ("大".equals(actionData.substring(1, 2)))
					{
						if (Integer.parseInt(numberData.substring(1, 2)) > 4) {
							qw = true;
						}
					}else if ("小".equals(actionData.substring(1, 2)))
					{
						if (Integer.parseInt(numberData.substring(1, 2)) <= 4) {
							qw = true;
						}
					}else if ("单".equals(actionData.substring(1, 2)))
					{
						if (Integer.parseInt(numberData.substring(1, 2))%24>0) {
							qw = true;
						}
					}else if ("双".equals(actionData.substring(1, 2)))
					{
						if (Integer.parseInt(numberData.substring(1, 2)) %2==0) {
							qw = true;
						}
					}
					
					if (ww && qw)
					{
						isZJ = true;
					}
				}
				}

		
		
		return isZJ;		
	}

	
	public static void main(String[] args) {

		int sum = 0;

		String actionData = "1&2||3||5";
			

		boolean tag = true;
//		String[] datas = actionData.split("\\|");
		int[] datas = {3,3,3,3,2};
		String d2 = "";
		for(int i=1; i<datas.length; i++){
			if(datas[0] != datas[i])
				d2 += "," + datas[i];
		}
		String[] datas2 = (d2.substring(1)).split(",");
		if(datas2.length < 3)
			tag = false;
		else{
			if(datas2.length == 3 ){
				if(!datas2[0].equals(datas2[1]) && !datas2[0].equals(datas2[2]))
					tag = false;
				else if(datas2[0].equals(datas2[1]) && datas2[0].equals(datas2[2]))
					tag = false;
			}
			else{
				if(datas2[0].equals(datas2[1]) && datas2[0].equals(datas2[2]) && datas2[0].equals(datas2[3]))
					tag = false;
				else{
					String d3 = "";
					for(int i=1; i<datas2.length; i++){
						if(!datas2[0].equals(datas2[i]))
							d3 += "," + datas2[i];
					}
					String[] datas3 = (d3.substring(1)).split(",");
					if(datas3.length != 2)
						tag = false;
				}
			}
		}
		
		
		
		System.out.println(tag);
	}
	
	
}
