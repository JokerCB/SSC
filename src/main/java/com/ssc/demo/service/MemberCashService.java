package com.ssc.demo.service;

import org.apache.ibatis.annotations.Param;

import com.ssc.demo.model.MemberCash;
import com.ssc.demo.model.Recharge;
import com.ssc.demo.web.ui.DataGrid;
import com.ssc.demo.web.ui.PageRequest;

import framework.generic.paginator.domain.PageList;


public interface MemberCashService {
	
	MemberCash load(@Param("id") String id);

	void save(MemberCash memberCash);
	
	void update(MemberCash memberCash);
	
	void delete(@Param("id") String id);
	
	/**
	 * 分页查询
	 */
	PageList<MemberCash> findByPage(PageRequest pageRequest);
	
	public String buildCashNo();
	
}
