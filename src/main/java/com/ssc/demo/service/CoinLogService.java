package com.ssc.demo.service;

import java.util.Map;

import com.ssc.demo.model.Members;
import com.ssc.demo.web.ui.PageRequest;

import framework.generic.paginator.domain.PageList;

public interface CoinLogService {
	public PageList<Map> findCoinLogByPage(PageRequest pageRequest);

}
