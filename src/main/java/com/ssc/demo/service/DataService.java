package com.ssc.demo.service;

import java.util.Map;

import com.ssc.demo.model.Data;
import com.ssc.demo.web.ui.DataGrid;
import com.ssc.demo.web.ui.PageRequest;

import framework.generic.paginator.domain.PageList;

public interface DataService {
	
	
	
	/**
	 * 根据根据彩种和期号查询一条数据库记录
	 * @return 实体类
	 */
Data find(Integer type,String number);

public PageList<Map> findDataByPage(PageRequest pageRequest);	
}
