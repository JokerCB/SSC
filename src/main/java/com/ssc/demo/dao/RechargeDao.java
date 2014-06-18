package com.ssc.demo.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.ssc.demo.model.Recharge;

import framework.generic.paginator.domain.PageBounds;
import framework.generic.paginator.domain.PageList;

public interface RechargeDao {
	

	Recharge load(@Param("id") String id);

	void save(Recharge recharge);
	
	void update(Recharge recharge);
	
	void delete(@Param("id") String id);
	
	/**
	 * 分页查询，必须是传递一个pagination
	 * 
	 * @param pagination
	 *            分页工具类
	 * @return pagination 分页工具类
	 */
	PageList<Recharge> findByPage(Object parameters, PageBounds pageBounds);
	
	String selectMaxCode(@Param("startDate")String startDate,@Param("endDate")String endDate);
	
	PageList<Map> findRechargeLogByPage(Object parameters, PageBounds pageBounds);
}
