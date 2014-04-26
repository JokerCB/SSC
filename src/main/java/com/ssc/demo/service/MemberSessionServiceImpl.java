package com.ssc.demo.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ssc.demo.dao.MemberSessionDao;
import com.ssc.demo.model.MemberSession;
import com.ssc.demo.web.ui.DataGrid;
import com.ssc.demo.web.ui.PageRequest;

import framework.generic.paginator.domain.PageList;

@Service("memberSessionService")
public class MemberSessionServiceImpl implements MemberSessionService {

	private MemberSessionDao memberSessionDao;
	
	@Resource
	public void setMemberSessionDao(MemberSessionDao memberSessionDao) {
		this.memberSessionDao = memberSessionDao;
	}
	
	/*
	 * (non-Javadoc)
	 * @see qya.demo.service.ssc.MemberSessionService#getDatagrid(qya.demo.web.ui.PageRequest)
	 */
	@Override
	public DataGrid getDatagrid(PageRequest pageRequest) {
		PageList<MemberSession> memberSessions = memberSessionDao.findByPage(pageRequest.getParameter(), pageRequest.getPageBounds());
		return new DataGrid(memberSessions.getPaginator().getTotalCount(), memberSessions);
	}
	
	/*
	 * (non-Javadoc)
	 * @see qya.demo.service.ssc.MemberSessionService#create(qya.demo.model.ssc.MemberSession)
	 */
	@Override
	public Integer create(MemberSession memberSession) {
		return memberSessionDao.insert(memberSession);
	}
	
	/*
	 * (non-Javadoc)
	 * @see qya.demo.service.ssc.MemberSessionService#modify(qya.demo.model.ssc.MemberSession)
	 */
	@Override
	public Integer modify(MemberSession memberSession) {
		return memberSessionDao.update(memberSession);
	}
	
	/*
	 * (non-Javadoc)
	 * @see qya.demo.service.ssc.MemberSessionService#remove(Integer)
	 */
	@Override
	public Integer remove(Integer id) {
		return memberSessionDao.deleteByPk(id);
	}
	
	/*
	 * (non-Javadoc)
	 * @see qya.demo.service.ssc.MemberSessionService#removeAll(Integer[])
	 */
	@Override
	public Integer removeAll(Integer... memberSessionIds) {
		return memberSessionDao.delete(memberSessionIds);
	}

	/*
	 * (non-Javadoc)
	 * @see qya.demo.service.ssc.MemberSessionService#getByPk(Integer)
	 */
	@Override
	public MemberSession getByPk(Integer id) {
		return memberSessionDao.findByPk(id);
	}
	
	/*
	 * (non-Javadoc)
	 * @see qya.demo.service.ssc.MemberSessionService#get(Integer)
	 */
	@Override
	public MemberSession get(Integer id) {
		return memberSessionDao.find(id);
	}
}
