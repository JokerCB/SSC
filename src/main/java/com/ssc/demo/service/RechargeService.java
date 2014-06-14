package com.ssc.demo.service;

import org.apache.ibatis.annotations.Param;

import com.ssc.demo.model.Recharge;
import com.ssc.demo.web.ui.PageRequest;

import framework.generic.paginator.domain.PageList;


public interface RechargeService {
	
	Recharge load(@Param("id") String id);

	void save(Recharge recharge);
	
	void update(Recharge recharge);
	
	void delete(@Param("id") String id);
	
	/**
	 * 分页查询
	 */
	PageList<Recharge> findByPage(PageRequest pageRequest);
	
	public String buildRechargeNo();
	
}
