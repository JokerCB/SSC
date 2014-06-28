package com.ssc.demo.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.ssc.demo.model.MemberCash;

import framework.generic.paginator.domain.PageBounds;
import framework.generic.paginator.domain.PageList;

public interface MemberCashDao{

	MemberCash load(@Param("id") String id);

	void save(MemberCash memberCash);
	
	void update(MemberCash memberCash);
	
	void delete(@Param("id") String id);
	
	/**
	 * 分页查询，必须是传递一个pagination
	 * 
	 * @param pagination
	 *            分页工具类
	 * @return pagination 分页工具类
	 */
	PageList<MemberCash> findByPage(Object parameters, PageBounds pageBounds);
	
	String selectMaxCode(@Param("startDate")String startDate,@Param("endDate")String endDate);
	
	/**
	 * 获取用户当天取款次数
	 * @param uid
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	int getCountToday(@Param("uid") String uid, @Param("startDate")String startDate,@Param("endDate")String endDate);
	
	
	PageList<Map> findCashByPage(Object parameters, PageBounds pageBounds);
}
