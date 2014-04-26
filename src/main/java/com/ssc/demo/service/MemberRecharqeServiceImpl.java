package com.ssc.demo.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;






import com.ssc.demo.dao.MemberRecharqeDao;
import com.ssc.demo.model.MemberRecharqe;
import com.ssc.demo.web.ui.DataGrid;
import com.ssc.demo.web.ui.PageRequest;

import framework.generic.paginator.domain.PageList;

@Service("memberRecharqeService")
public class MemberRecharqeServiceImpl implements MemberRecharqeService {

	private MemberRecharqeDao memberRecharqeDao;
	
	@Resource
	public void setMemberRecharqeDao(MemberRecharqeDao memberRecharqeDao) {
		this.memberRecharqeDao = memberRecharqeDao;
	}
	
	/*
	 * (non-Javadoc)
	 * @see qya.demo.service.ssc.MemberRecharqeService#getDatagrid(qya.demo.web.ui.PageRequest)
	 */
	@Override
	public DataGrid getDatagrid(PageRequest pageRequest) {
		PageList<MemberRecharqe> memberRecharqes = memberRecharqeDao.findByPage(pageRequest.getParameter(), pageRequest.getPageBounds());
		return new DataGrid(memberRecharqes.getPaginator().getTotalCount(), memberRecharqes);
	}
	
	/*
	 * (non-Javadoc)
	 * @see qya.demo.service.ssc.MemberRecharqeService#create(qya.demo.model.ssc.MemberRecharqe)
	 */
	@Override
	public Integer create(MemberRecharqe memberRecharqe) {
		return memberRecharqeDao.insert(memberRecharqe);
	}
	
	/*
	 * (non-Javadoc)
	 * @see qya.demo.service.ssc.MemberRecharqeService#modify(qya.demo.model.ssc.MemberRecharqe)
	 */
	@Override
	public Integer modify(MemberRecharqe memberRecharqe) {
		return memberRecharqeDao.update(memberRecharqe);
	}
	
	/*
	 * (non-Javadoc)
	 * @see qya.demo.service.ssc.MemberRecharqeService#remove(Integer)
	 */
	@Override
	public Integer remove(Integer id) {
		return memberRecharqeDao.deleteByPk(id);
	}
	
	/*
	 * (non-Javadoc)
	 * @see qya.demo.service.ssc.MemberRecharqeService#removeAll(Integer[])
	 */
	@Override
	public Integer removeAll(Integer... memberRecharqeIds) {
		return memberRecharqeDao.delete(memberRecharqeIds);
	}

	/*
	 * (non-Javadoc)
	 * @see qya.demo.service.ssc.MemberRecharqeService#getByPk(Integer)
	 */
	@Override
	public MemberRecharqe getByPk(Integer id) {
		return memberRecharqeDao.findByPk(id);
	}
	
	/*
	 * (non-Javadoc)
	 * @see qya.demo.service.ssc.MemberRecharqeService#get(Integer)
	 */
	@Override
	public MemberRecharqe get(Integer id) {
		return memberRecharqeDao.find(id);
	}
}
