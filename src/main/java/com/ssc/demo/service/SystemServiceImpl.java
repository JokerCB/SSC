package com.ssc.demo.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ssc.demo.dao.NoticeDao;
import com.ssc.demo.model.Notice;
import com.ssc.demo.web.ui.PageRequest;

import framework.generic.paginator.domain.PageList;

@Service("systemService")
public class SystemServiceImpl implements SystemService{
	
	@Resource
	private NoticeDao noticeDao;
	
	public Integer saveNotice(Notice notice){
		return noticeDao.insert(notice);
	}
	
	public Integer updateNotice(Notice notice){
		return noticeDao.update(notice);
	}
	
	public PageList<Notice> findNoticesByPage(PageRequest pageRequest) {
		PageList<Notice>  notice = noticeDao.findByPage(pageRequest.getParameter(), pageRequest.getPageBounds());
		return notice;
	}

	@Override
	public Notice loadNotice(String id) {
		// TODO Auto-generated method stub
		return noticeDao.load(Integer.parseInt(id));
	}

	@Override
	public Integer deleteNotice(int id) {
		// TODO Auto-generated method stub
		return noticeDao.deleteByPk(id);
	}
}
