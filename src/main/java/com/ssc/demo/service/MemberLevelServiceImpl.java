package com.ssc.demo.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ssc.demo.dao.MemberLevelDao;
import com.ssc.demo.model.MemberLevel;
import com.ssc.demo.web.ui.DataGrid;
import com.ssc.demo.web.ui.PageRequest;

import framework.generic.paginator.domain.PageList;

@Service("memberLevelService")
public class MemberLevelServiceImpl implements MemberLevelService {

	private MemberLevelDao memberLevelDao;
	
	@Resource
	public void setMemberLevelDao(MemberLevelDao memberLevelDao) {
		this.memberLevelDao = memberLevelDao;
	}
	
	/*
	 * (non-Javadoc)
	 * @see qya.demo.service.ssc.MemberLevelService#getDatagrid(qya.demo.web.ui.PageRequest)
	 */
	@Override
	public DataGrid getDatagrid(PageRequest pageRequest) {
		PageList<MemberLevel> memberLevels = memberLevelDao.findByPage(pageRequest.getParameter(), pageRequest.getPageBounds());
		return new DataGrid(memberLevels.getPaginator().getTotalCount(), memberLevels);
	}
	
	/*
	 * (non-Javadoc)
	 * @see qya.demo.service.ssc.MemberLevelService#create(qya.demo.model.ssc.MemberLevel)
	 */
	@Override
	public Integer create(MemberLevel memberLevel) {
		return memberLevelDao.insert(memberLevel);
	}
	
	/*
	 * (non-Javadoc)
	 * @see qya.demo.service.ssc.MemberLevelService#modify(qya.demo.model.ssc.MemberLevel)
	 */
	@Override
	public Integer modify(MemberLevel memberLevel) {
		return memberLevelDao.update(memberLevel);
	}
	
	/*
	 * (non-Javadoc)
	 * @see qya.demo.service.ssc.MemberLevelService#remove(Byte)
	 */
	@Override
	public Integer remove(Byte id) {
		return memberLevelDao.deleteByPk(id);
	}
	
	/*
	 * (non-Javadoc)
	 * @see qya.demo.service.ssc.MemberLevelService#removeAll(Byte[])
	 */
	@Override
	public Integer removeAll(Byte... memberLevelIds) {
		return memberLevelDao.delete(memberLevelIds);
	}

	/*
	 * (non-Javadoc)
	 * @see qya.demo.service.ssc.MemberLevelService#getByPk(Byte)
	 */
	@Override
	public MemberLevel getByPk(Byte id) {
		return memberLevelDao.findByPk(id);
	}
	
	/*
	 * (non-Javadoc)
	 * @see qya.demo.service.ssc.MemberLevelService#get(Byte)
	 */
	@Override
	public MemberLevel get(Byte id) {
		return memberLevelDao.find(id);
	}
}
