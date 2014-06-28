package com.ssc.demo.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.ssc.demo.model.CoinLog;

import framework.generic.dao.GenericDao;
import framework.generic.paginator.domain.PageBounds;
import framework.generic.paginator.domain.PageList;

public interface CoinLogDao extends GenericDao<CoinLog, Integer> {

	void saveCoinLog(CoinLog coinLog);
	
	/**
	 * 分页查询，必须是传递一个pagination
	 * 
	 * @param pagination
	 *            分页工具类
	 * @return pagination 分页工具类
	 */
	PageList<Map> findCoinLogByPage(Object parameters, PageBounds pageBounds);
	
	/**
	 * 分页查询，必须是传递一个pagination
	 *综合统计报表
	 */
	PageList<Map> findReportByPage(Object parameters, PageBounds pageBounds);
	
	List<CoinLog> findByUid(@Param("uid") int uid);
	
	/**
	 * 团队盈亏
	 */

	Integer getTDYK(@Param("uid") int uid);
}
