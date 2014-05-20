package com.ssc.demo.dao;

import com.ssc.demo.model.CoinLog;
import framework.generic.paginator.domain.PageBounds;
import framework.generic.paginator.domain.PageList;

public interface CoinLogDao {

	void saveCoinLog(CoinLog coinLog);
	
	/**
	 * 分页查询，必须是传递一个pagination
	 * 
	 * @param pagination
	 *            分页工具类
	 * @return pagination 分页工具类
	 */
	PageList<CoinLog> findCoinLogByPage(Object parameters, PageBounds pageBounds);
}
