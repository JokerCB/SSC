package com.ssc.demo.service;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ssc.demo.dao.AreaDao;
import com.ssc.demo.dao.MembersDao;
import com.ssc.demo.model.City;
import com.ssc.demo.model.Members;
import com.ssc.demo.model.Province;
import com.ssc.demo.web.ui.PageRequest;

import framework.generic.paginator.domain.PageList;

@Service("membersService")
public class MembersServiceImpl implements MembersService {

	private MembersDao membersDao;
	
	private AreaDao areaDao;
	
	@Resource
	public void setMembersDao(MembersDao membersDao) {
		this.membersDao = membersDao;
	}
	
	@Resource
	public void setAreaDao(AreaDao areaDao) {
		this.areaDao = areaDao;
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
	
	/**
	 * ��ȡ�Ŷ����
	 * @param membersId
	 * @param money
	 * @return
	 */
	public BigDecimal getTotalMoney(String membersId,BigDecimal money){
		this.updateTotalMoney(membersId, money);
		return money;
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

	@Override
	public List<Province> getProvince() {
		return areaDao.findProvinces();
	}

	@Override
	public List<City> getCity(String provinceId) {
		return areaDao.findCitys(provinceId);
	}
	
	private void updateTotalMoney(String membersId,BigDecimal money){
		List<Members> childs = membersDao.findChilds(membersId);
		for(int i=0; i<childs.size(); i++){
			Members child = childs.get(i);
			money = money.add(child.getMcoin());
			updateTotalMoney(child.getUid()+"",money);
		}
	}
	
}
