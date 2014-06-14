package com.ssc.demo.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.ssc.demo.model.Data;

import framework.generic.paginator.domain.PageBounds;
import framework.generic.paginator.domain.PageList;

public interface DataDao   {
	Data load(@Param("id") String dataId);

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
	
	PageList<Map> findDataByPage(Object parameters, PageBounds pageBounds);
}
