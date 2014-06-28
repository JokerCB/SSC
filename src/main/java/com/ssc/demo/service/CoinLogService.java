package com.ssc.demo.service;

import java.util.Map;

import com.ssc.demo.model.Members;
import com.ssc.demo.web.ui.PageRequest;

import framework.generic.paginator.domain.PageBounds;
import framework.generic.paginator.domain.PageList;

public interface CoinLogService {
	public PageList<Map> findCoinLogByPage(PageRequest pageRequest);
	
	/**
	 * 综合报表
	 * @param pageRequest
	 * @return
	 */
	PageList<Map> findReportByPage(PageRequest pageRequest);
	
	/**
	 * 获取团队余额
	 * @param uid
	 * @return
	 */
	Integer getTDYK( int uid);
}
