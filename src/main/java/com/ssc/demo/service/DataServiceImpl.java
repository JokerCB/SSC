package com.ssc.demo.service;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ssc.demo.dao.DataDao;
import com.ssc.demo.model.Data;
import com.ssc.demo.web.ui.PageRequest;

import framework.generic.paginator.domain.PageList;




@Service("dataService")
public  class DataServiceImpl implements DataService {
	@Resource
	private DataDao dataDao;
	
	@Override
	public Data find(Integer type, String number) {
		
		return dataDao.find(type, number);
	}
	@Override
	public PageList<Map> findDataByPage(PageRequest pageRequest) {
		PageList<Map> dataMap=dataDao.findDataByPage(pageRequest.getParameter(), pageRequest.getPageBounds());
		return dataMap;
	}

	
	
}
