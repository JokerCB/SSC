package com.ssc.demo.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ssc.demo.dao.MembersDao;
import com.ssc.demo.model.Members;
import com.ssc.demo.web.ui.DataGrid;
import com.ssc.demo.web.ui.PageRequest;

import framework.generic.paginator.domain.PageList;

@Service("membersService")
public class MembersServiceImpl implements MembersService {

	private MembersDao membersDao;
	
	@Resource
	public void setMembersDao(MembersDao membersDao) {
		this.membersDao = membersDao;
	}
	


	public Members load(Integer mid){
		return membersDao.load(mid,null,null);
	}
	public Members load(String mname){
		return membersDao.load(null,mname,null);
	}
	public Members load(String mname,String mpassword) {
		return membersDao.load(null,mname, mpassword);
	}
	
	/*
	 * (non-Javadoc)
	 * @see qya.demo.service.ssc.MembersService#getDatagrid(qya.demo.web.ui.PageRequest)
	 */
	@Override
	public DataGrid getDatagrid(PageRequest pageRequest) {
		PageList<Members> memberss = membersDao.findByPage(pageRequest.getParameter(), pageRequest.getPageBounds());
		return new DataGrid(memberss.getPaginator().getTotalCount(), memberss);
	}
	
	/*
	 * (non-Javadoc)
	 * @see qya.demo.service.ssc.MembersService#create(qya.demo.model.ssc.Members)
	 */
	@Override
	public Integer create(Members members) {
		return membersDao.insert(members);
	}
	
	/*
	 * (non-Javadoc)
	 * @see qya.demo.service.ssc.MembersService#modify(qya.demo.model.ssc.Members)
	 */
	@Override
	public Integer modify(Members members) {
		return membersDao.update(members);
	}
	
	/*
	 * (non-Javadoc)
	 * @see qya.demo.service.ssc.MembersService#remove(Integer)
	 */
	@Override
	public Integer remove(Integer mid) {
		return membersDao.deleteByPk(mid);
	}
	
	/*
	 * (non-Javadoc)
	 * @see qya.demo.service.ssc.MembersService#removeAll(Integer[])
	 */
	@Override
	public Integer removeAll(Integer... membersIds) {
		return membersDao.delete(membersIds);
	}
	
}
