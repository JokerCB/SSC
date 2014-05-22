package com.ssc.demo.service;

import java.util.List;

import com.ssc.demo.model.OrderDetail;
import com.ssc.demo.model.Played;

public interface PlayedService {

	public Played load(int id);
	
	public List<Played> findAll();
	
	public int getActionNum(int playedId, String actionData, String type);
	
	
	/**
	 * 判断是否中奖
	 * @param detail
	 * @return
	 */
	public boolean calcActionNumberData(OrderDetail detail);
	
	/**
	 * 判断中组三还是组六
	 * @param actionData
	 * @param numberData
	 * @param type
	 * @param playId
	 * @return “00” 不中； “10”组三；“01”组六
	 */
	public String isZSOrZL(OrderDetail orderDetail);
	
	/**
	 * 返回中奖的注数(适用定位胆和不定位胆)
	 * @param actionData
	 * @param numberData
	 * @param type
	 * @param playId
	 * @return
	 */
	public int isZJNum(OrderDetail orderDetail);
	
	/**
	 * 适用五星和四星的组合
	 * @param actionData
	 * @param numberData
	 * @param type
	 * @param playId
	 * @return  
	 */
	public String isGroupZJJudgement(OrderDetail orderDetail);
}
