package com.ssc.demo.service;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ssc.demo.dao.CoinLogDao;
import com.ssc.demo.web.ui.PageRequest;

import framework.generic.paginator.domain.PageBounds;
import framework.generic.paginator.domain.PageList;
@Service("coinLogService")
public class CoinLogServiceImpl implements CoinLogService {
	
	@Resource
	private CoinLogDao coinLogDao;


	@Override
	public PageList<Map> findCoinLogByPage(PageRequest pageRequest) {
		PageList<Map> coinLogMap=coinLogDao.findCoinLogByPage(pageRequest.getParameter(), pageRequest.getPageBounds());
		return coinLogMap;
	}
	
	@Override
	public PageList<Map> findReportByPage(PageRequest pageRequest) {
		PageList<Map> coinLogMap=coinLogDao.findReportByPage(pageRequest.getParameter(), pageRequest.getPageBounds());
		return coinLogMap;
	}

	@Override
	public Integer getTDYK(int uid) {
		
		return coinLogDao.getTDYK(uid);
	}


}
