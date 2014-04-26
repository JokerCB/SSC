package com.ssc.demo.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;






import com.ssc.demo.dao.MemberCashDao;
import com.ssc.demo.model.MemberCash;
import com.ssc.demo.web.ui.DataGrid;
import com.ssc.demo.web.ui.PageRequest;

import framework.generic.paginator.domain.PageList;

@Service("memberCashService")
public class MemberCashServiceImpl implements MemberCashService {

	private MemberCashDao memberCashDao;
	
	@Resource
	public void setMemberCashDao(MemberCashDao memberCashDao) {
		this.memberCashDao = memberCashDao;
	}
	
	/*
	 * (non-Javadoc)
	 * @see qya.demo.service.ssc.MemberCashService#getDatagrid(qya.demo.web.ui.PageRequest)
	 */
	@Override
	public DataGrid getDatagrid(PageRequest pageRequest) {
		PageList<MemberCash> memberCashs = memberCashDao.findByPage(pageRequest.getParameter(), pageRequest.getPageBounds());
		return new DataGrid(memberCashs.getPaginator().getTotalCount(), memberCashs);
	}
	
	/*
	 * (non-Javadoc)
	 * @see qya.demo.service.ssc.MemberCashService#create(qya.demo.model.ssc.MemberCash)
	 */
	@Override
	public Integer create(MemberCash memberCash) {
		return memberCashDao.insert(memberCash);
	}
	
	/*
	 * (non-Javadoc)
	 * @see qya.demo.service.ssc.MemberCashService#modify(qya.demo.model.ssc.MemberCash)
	 */
	@Override
	public Integer modify(MemberCash memberCash) {
		return memberCashDao.update(memberCash);
	}
	
	/*
	 * (non-Javadoc)
	 * @see qya.demo.service.ssc.MemberCashService#remove(Integer)
	 */
	@Override
	public Integer remove(Integer id) {
		return memberCashDao.deleteByPk(id);
	}
	
	/*
	 * (non-Javadoc)
	 * @see qya.demo.service.ssc.MemberCashService#removeAll(Integer[])
	 */
	@Override
	public Integer removeAll(Integer... memberCashIds) {
		return memberCashDao.delete(memberCashIds);
	}

	/*
	 * (non-Javadoc)
	 * @see qya.demo.service.ssc.MemberCashService#getByPk(Integer)
	 */
	@Override
	public MemberCash getByPk(Integer id) {
		return memberCashDao.findByPk(id);
	}
	
	/*
	 * (non-Javadoc)
	 * @see qya.demo.service.ssc.MemberCashService#get(Integer)
	 */
	@Override
	public MemberCash get(Integer id) {
		return memberCashDao.find(id);
	}
}
