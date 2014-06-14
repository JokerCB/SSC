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
				|| "中三直选(复式/单式)".equals(played.getName())
				|| "后三码_混合组选".equals(played.getName())|| "前三码_混合组选".equals(played.getName())
				|| "中三码_混合组选".equals(played.getName())){
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
		
		else if("二码_后二直选(复式)".equals(played.getName()) || "二码_前二直选(复式)".equals(played.getName())){
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
	
	/**
	 * 判断是否中奖
	 */
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
			
			return isZJJudgement(actionDatas,numberData,detail.getType(),playId);
			}
		return isZJ;		
	}

	
	private static boolean isZJJudgement(String actionData,String numberData,String type, int playId) {
		int sum=0;
		int num=0;
		String[] datas,numberDataArray;
		
		
		if (playId == 5)// 后三码直选
		{
			if ("digital".equals(type)) // 复式 1&2&3|1&2&3|1&2&3
			{
			datas = actionData.split("\\|");
			if (datas[0].indexOf(numberData.substring(2, 3)) >= 0
					&& datas[1].indexOf(numberData.substring(3, 4)) >= 0
					&& datas[2].indexOf(numberData.substring(4, 5)) >= 0) {
				return true;
			}
			
			} else if ("input".equals(type)) // 单式 345&678
			{
				datas = actionData.split("&");
				for (int a=0; a<datas.length;a++)
				{
					if (datas[a].equals(numberData.substring(2, 5)))
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
				if (datas[0].indexOf(numberData.substring(3, 4))>=0 && datas[1].indexOf(numberData.substring(4, 5))>=0 )
				{
					return true;
				}
					
			} else if ("input".equals(type)) // 单式 12&34&56
			{
				datas = actionData.split("&");
				for (int a=0;a<datas.length; a++)
				{
					if (datas[a].equals(numberData.substring(3, 5)))
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
					if (datas[a].equals(numberData.substring(0, 2))) {
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
			numberDataArray=numberDataF(numberData.substring(3, 5)).split(",");
			if (numberDataArray.length!=1)
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
			}
			

		}else if (playId == 26)//二码前二组选
		{
			numberDataArray=numberDataF(numberData.substring(0, 2)).split(",");
			if (numberDataArray.length!=1)
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
			}
			
		}else if (playId == 478)//二码后二组选和值  8&9&10&11
		{
			numberDataArray=numberDataF(numberData.substring(3, 5)).split(",");
			if (numberDataArray.length!=1)
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
			}
		
		}else if (playId == 476)//二码前二组选和值 14&15&16
		{
			numberDataArray=numberDataF(numberData.substring(0, 2)).split(",");
			if (numberDataArray.length !=1 && numberData.substring(0, 1)!=numberData.substring(1, 2))
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
		}else if (playId == 2)// 前三直选
		{
			if ("digital".equals(type)) // 复式 1&2&3|4&5&6|7&8&9
			{
				datas = actionData.split("\\|");
				if (datas[0].indexOf(numberData.substring(0, 1)) >= 0
						&& datas[1].indexOf(numberData.substring(1, 2)) >= 0
						&& datas[2].indexOf(numberData.substring(2, 3)) >= 0) {
					return true;
				}
			} else if ("input".equals(type)) // 单式 123&456&789
			{
				datas = actionData.split("&");
				for (int a=0; a<datas.length;a++)
				{
					if (datas[a].equals(numberData.substring(0, 3)))
					{
						return true;
					}
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

		}else if (playId == 2291)// 中三码直选
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
				for (int a=0; a<datas.length;a++)
				{
					if (datas[a].equals(numberData.substring(1, 4)))
					{
						return true;
					}
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
	

/**
 * 判断中组三还是组六
 * @param actionData
 * @param numberData
 * @param type
 * @param playId
 * @return “00” 不中； “10”组三；“01”组六
 */
	public String isZSOrZL(OrderDetail orderDetail) {
		
		Played played = this.load(orderDetail.getPlayId());
		Order order = orderDao.load(orderDetail.getOrderId());
		//根据期号获取当期开奖数；
		Data data=dataDao.find(played.getType(), order.getLtIssueStart());
		int playId = played.getId();
		String numberData = data.getData();
		String actionData = orderDetail.getActionData();
		String[] datas = actionData.split("&");
		String[] numberDataArray = null;
		int sum=0;
		if (playId == 15 || playId == 16)// 后三组选（混合组选）112&123&234&334
		{
			numberDataArray = numberDataF(numberData.substring(2, 5))
					.split(",");
			sum = Integer.parseInt(numberData.substring(2, 3))
					+ Integer.parseInt(numberData.substring(3, 4))
					+ Integer.parseInt(numberData.substring(4, 5));
		} else if (playId == 10 || playId == 11)// 前三组选(混合组选)：123&233&345
		{
			numberDataArray = numberDataF(numberData.substring(0, 3))
					.split(",");
			sum = Integer.parseInt(numberData.substring(0, 1))
					+ Integer.parseInt(numberData.substring(1, 2))
					+ Integer.parseInt(numberData.substring(2, 3));
		} else if (playId == 2295 || playId == 2296)// 中三码组选（混合）：123&199&234&345&556
		{
			numberDataArray = numberDataF(numberData.substring(1, 4))
					.split(",");
			sum = Integer.parseInt(numberData.substring(1, 2))
					+ Integer.parseInt(numberData.substring(2, 3))
					+ Integer.parseInt(numberData.substring(3, 4));
		}

		if (numberDataArray.length == 2) // 组三
		{
			if (playId == 16 || playId == 11 || playId == 2296) {
			
				for (int a = 0; a < datas.length; a++) {
					if (Integer.parseInt(datas[a]) == sum) {
						return "10";
					}
				}

			} else
			{
				for (int a = 0; a < datas.length; a++) {
					if (datas[a].indexOf(numberDataArray[0].substring(0, 1)) >= 0
							&& datas[a].indexOf(numberDataArray[1].substring(0, 1)) >= 0) {
						return "10";
					}
				}
			}
			

		} else if (numberDataArray.length == 3) // 组六
		{
			if (playId == 16 || playId == 11 || playId == 2296) {
			for (int a = 0; a < datas.length; a++) {
					if (Integer.parseInt(datas[a]) == sum) {
						return "01";
					}
				}

			} else{
				for (int a = 0; a < datas.length; a++) {
					if (datas[a].indexOf(numberDataArray[0]) >= 0
							&& datas[a].indexOf(numberDataArray[1]) >= 0
							&& datas[a].indexOf(numberDataArray[2]) >= 0) {
						return "01";
					}
				}
			}
			
		}

		return "00";
	}
	/**
	 * 返回中奖的注数(适用定位胆和不定位胆)
	 * @param actionData
	 * @param numberData
	 * @param type
	 * @param playId
	 * @return
	 */
	public int isZJNum(OrderDetail orderDetail) {
		Played played = this.load(orderDetail.getPlayId());
		Order order = orderDao.load(orderDetail.getOrderId());
		//根据期号获取当期开奖数；
		Data data=dataDao.find(played.getType(), order.getLtIssueStart());
		int playId = played.getId();
		String numberData = data.getData();
		String actionData = orderDetail.getActionData();
		String[] datas;
		int num = 0;
		if (playId == 18)// 不定胆（后三一码不定胆） 0&1&2&3&4&5&6&7&8&9
		{
			numberData = numberData.substring(2, 5);
			datas = actionData.split("&");
			for (int a = 0; a < datas.length; a++) {
				if (numberData.indexOf(datas[a]) >= 0) {
					num++;
				}
			}

		} else if (playId == 20)// 不定胆（后三二码不定胆）5&6&7&8&9
		{
			numberData = numberData.substring(2, 5);
			String[] numberDataArray = numberDataF(numberData).split(",");
			if (numberDataArray.length == 2) {
				if (actionData.indexOf(numberDataArray[0].substring(0, 1)) >= 0
						&& actionData.indexOf(numberDataArray[1]
								.substring(0, 1)) >= 0) {
					num = 1;
				}
			} else if (numberDataArray.length == 3) {
				if (actionData.indexOf(numberDataArray[0]) >= 0
						&& actionData.indexOf(numberDataArray[1]) >= 0) {
					num++;
				}
				if (actionData.indexOf(numberDataArray[0]) >= 0
						&& actionData.indexOf(numberDataArray[2]) >= 0) {
					num++;
				}
				if (actionData.indexOf(numberDataArray[1]) >= 0
						&& actionData.indexOf(numberDataArray[2]) >= 0) {
					num++;
				}
			}

		} else if (playId == 512)// 不定胆（前三一码不定胆）1&2&3&4&5
		{
			numberData = numberData.substring(0, 3);
			datas = actionData.split("&");
			for (int a = 0; a < datas.length; a++) {
				if (numberData.indexOf(datas[a]) >= 0) {
					num++;
				}
			}

		} else if (playId == 513)// 不定胆（前三二码不定胆）4&5&6&7
		{
			numberData = numberData.substring(0, 3);
			String[] numberDataArray = numberDataF(numberData).split(",");
			if (numberDataArray.length == 2) {
				if (actionData.indexOf(numberDataArray[0].substring(0, 1)) >= 0
						&& actionData.indexOf(numberDataArray[1]
								.substring(0, 1)) >= 0) {
					num = 1;
				}
			} else if (numberDataArray.length == 3) {
				if (actionData.indexOf(numberDataArray[0]) >= 0
						&& actionData.indexOf(numberDataArray[1]) >= 0) {
					num++;
				}
				if (actionData.indexOf(numberDataArray[0]) >= 0
						&& actionData.indexOf(numberDataArray[2]) >= 0) {
					num++;
				}
				if (actionData.indexOf(numberDataArray[1]) >= 0
						&& actionData.indexOf(numberDataArray[2]) >= 0) {
					num++;
				}
			}
		}else if (playId == 30)//定位胆 2&5|3|4&6|5&6|6
		{
			 datas = actionData.split("\\|");
			 for(int i=0; i<datas.length;i++){
				 if (datas[i].indexOf(numberData.substring(i, i+1))>=0)
					{
						num++;
					}
			 }
						
			}
		return num;
	}
	/**
	 * 适用五星和四星的组合
	 * @param actionData
	 * @param numberData
	 * @param type
	 * @param playId
	 * @return
	 */
	
	public String isGroupZJJudgement(OrderDetail orderDetail){
		Played played = this.load(orderDetail.getPlayId());
		Order order = orderDao.load(orderDetail.getOrderId());
		//根据期号获取当期开奖数；
		Data data=dataDao.find(played.getType(), order.getLtIssueStart());
		int playId = played.getId();
		String numberData = data.getData();
		String actionData = orderDetail.getActionData();
		String zjArray="00000";
		String[] datas = new String[5];
		if (playId == 2276)//  五星直选组合  0&1|2&3|4&5|6&7|8&9
		{
			datas = actionData.split("\\|");
		}
		else if (playId == 2267)//  四星直选(组合)  5&6&7&8&9|0&1&2&3&4|0&1&2&3&4&5&6&7&8&9|0&1&2&3&4&5&6&7&8&9
		{
			datas[0] = "";
			String[] temp = actionData.split("\\|");
			for(int i=0; i<temp.length; i++)
				datas[i+1] = temp[i];
		}
		
		if (datas[0].indexOf(numberData.substring(0, 1))>=0 && datas[1].indexOf(numberData.substring(1, 2))>=0
		 && datas[2].indexOf(numberData.substring(2, 3))>=0	&& datas[3].indexOf(numberData.substring(3, 4))>=0
		 && datas[4].indexOf(numberData.substring(4, 5))>=0)
		{
			zjArray="11111";
		}
		else if (datas[1].indexOf(numberData.substring(1, 2))>=0 && datas[2].indexOf(numberData.substring(2, 3))>=0
			  && datas[3].indexOf(numberData.substring(3, 4))>=0 && datas[4].indexOf(numberData.substring(4, 5))>=0)
		{
			zjArray="01111";
		}
		else if (datas[2].indexOf(numberData.substring(2, 3))>=0 && datas[3].indexOf(numberData.substring(3, 4))>=0
				&& datas[4].indexOf(numberData.substring(4, 5))>=0)
		{
				zjArray="00111";
		}
		else if (datas[3].indexOf(numberData.substring(3, 4))>=0&& datas[4].indexOf(numberData.substring(4, 5))>=0)
		{
				zjArray="00011";
		}
		else if (datas[4].indexOf(numberData.substring(4, 5))>=0)
		{
				zjArray="00001";
		}		
		return zjArray;
	}
	
	private static String numberDataF(String data){
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
