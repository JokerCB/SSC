package com.ssc.demo.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;






import com.ssc.demo.dao.MemberBankDao;
import com.ssc.demo.model.MemberBank;
import com.ssc.demo.web.ui.DataGrid;
import com.ssc.demo.web.ui.PageRequest;

import framework.generic.paginator.domain.PageList;

@Service("memberBankService")
public class MemberBankServiceImpl implements MemberBankService {

	private MemberBankDao memberBankDao;
	
	@Resource
	public void setMemberBankDao(MemberBankDao memberBankDao) {
		this.memberBankDao = memberBankDao;
	}
	
	/*
	 * (non-Javadoc)
	 * @see qya.demo.service.ssc.MemberBankService#getDatagrid(qya.demo.web.ui.PageRequest)
	 */
	@Override
	public DataGrid getDatagrid(PageRequest pageRequest) {
		PageList<MemberBank> memberBanks = memberBankDao.findByPage(pageRequest.getParameter(), pageRequest.getPageBounds());
		return new DataGrid(memberBanks.getPaginator().getTotalCount(), memberBanks);
	}
	
	/*
	 * (non-Javadoc)
	 * @see qya.demo.service.ssc.MemberBankService#create(qya.demo.model.ssc.MemberBank)
	 */
	@Override
	public Integer create(MemberBank memberBank) {
		return memberBankDao.insert(memberBank);
	}
	
	/*
	 * (non-Javadoc)
	 * @see qya.demo.service.ssc.MemberBankService#modify(qya.demo.model.ssc.MemberBank)
	 */
	@Override
	public Integer modify(MemberBank memberBank) {
		return memberBankDao.update(memberBank);
	}
	
	/*
	 * (non-Javadoc)
	 * @see qya.demo.service.ssc.MemberBankService#remove(Integer)
	 */
	@Override
	public Integer remove(Integer id) {
		return memberBankDao.deleteByPk(id);
	}
	
	/*
	 * (non-Javadoc)
	 * @see qya.demo.service.ssc.MemberBankService#removeAll(Integer[])
	 */
	@Override
	public Integer removeAll(Integer... memberBankIds) {
		return memberBankDao.delete(memberBankIds);
	}

	/*
	 * (non-Javadoc)
	 * @see qya.demo.service.ssc.MemberBankService#getByPk(Integer)
	 */
	@Override
	public MemberBank getByPk(Integer id) {
		return memberBankDao.findByPk(id);
	}
	
	/*
	 * (non-Javadoc)
	 * @see qya.demo.service.ssc.MemberBankService#get(Integer)
	 */
	@Override
	public MemberBank get(Integer id) {
		return memberBankDao.find(id);
	}
}
