package com.ssc.demo.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ssc.demo.dao.MembersDao;
import com.ssc.demo.model.Members;
import com.ssc.demo.model.OrderDetail;
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

	public Members load(Integer uid){
		return membersDao.load(uid,null,null);
	}
	public Members load(String mname){
		return membersDao.load(null,mname,null);
	}
	public Members load(String mname,String mpassword) {
		return membersDao.load(null,mname, mpassword);
	}
	
	public PageList<Members> findByPage(PageRequest pageRequest) {
		PageList<Members>  members = membersDao.findByPage(pageRequest.getParameter(), pageRequest.getPageBounds());
		return members;
	}
	

	@Override
	public Integer addMembers(Members members) {
		return membersDao.insert(members);
	}
	

	@Override
	public Integer modify(Members members) {
		return membersDao.update(members);
	}
	

	@Override
	public Integer remove(Integer uid) {
		return membersDao.deleteByPk(uid);
	}
	

	@Override
	public Integer removeAll(Integer... membersIds) {
		return membersDao.delete(membersIds);
	}
	
}
