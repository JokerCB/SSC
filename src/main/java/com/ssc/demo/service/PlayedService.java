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
}
