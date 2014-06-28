package com.ssc.demo.service;

import com.ssc.demo.model.Notice;
import com.ssc.demo.web.ui.PageRequest;

import framework.generic.paginator.domain.PageList;

public interface SystemService {

	public Notice loadNotice(String id);
	
	public Integer saveNotice(Notice notice);
	
	public Integer updateNotice(Notice notice);
	
	public PageList<Notice> findNoticesByPage(PageRequest pageRequest);
	
	public Integer deleteNotice(int id);
}
