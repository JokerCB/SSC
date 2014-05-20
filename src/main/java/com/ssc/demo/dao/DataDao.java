package com.ssc.demo.dao;

import org.apache.ibatis.annotations.Param;

import com.ssc.demo.model.Data;

public interface DataDao   {

	/**
	 * 根据根据彩种和期号查询一条数据库记录
	 */
	

	Data find(@Param("type") int type,@Param("number") String number);
	
	/**
	 * 查询开奖数据
	 * @param type
	 * @return
	 */
	Data getLotteryData(@Param("type") int type);
	
	void updateData(Data data);
}
