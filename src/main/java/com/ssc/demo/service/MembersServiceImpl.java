package com.ssc.demo.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ssc.demo.dao.AreaDao;
import com.ssc.demo.dao.CoinLogDao;
import com.ssc.demo.dao.MembersDao;
import com.ssc.demo.dao.NoticeDao;
import com.ssc.demo.dao.OrderDao;
import com.ssc.demo.model.City;
import com.ssc.demo.model.CoinLog;
import com.ssc.demo.model.Members;
import com.ssc.demo.model.Notice;
import com.ssc.demo.model.Province;
import com.ssc.demo.web.ui.PageRequest;

import framework.generic.paginator.domain.PageList;

@Service("membersService")
public class MembersServiceImpl implements MembersService {

	private MembersDao membersDao;
	
	private AreaDao areaDao;
	
	private OrderDao orderDao;
	
	private CoinLogDao coinLogDao;
	
	private NoticeDao noticeDao;
	
	private static BigDecimal money;
	
	private static String childIds;
	
	@Resource
	public void setMembersDao(MembersDao membersDao) {
		this.membersDao = membersDao;
	}
	
	@Resource
	public void setAreaDao(AreaDao areaDao) {
		this.areaDao = areaDao;
	}

	@Resource
	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

	@Resource
	public void setCoinLogDao(CoinLogDao coinLogDao) {
		this.coinLogDao = coinLogDao;
	}

	@Resource
	public void setNoticeDao(NoticeDao noticeDao) {
		this.noticeDao = noticeDao;
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
	public Members load(Integer uid,String mname) {
		return membersDao.load(uid,mname, null);
	}
	
	public PageList<Members> findByPage(PageRequest pageRequest) {
		PageList<Members>  members = membersDao.findByPage(pageRequest.getParameter(), pageRequest.getPageBounds());
		return members;
	}
	
	/**
	 * 获取团队资金
	 * @param membersId
	 * @param money
	 * @return
	 */
	public BigDecimal getTotalMoney(String membersId,BigDecimal money){
		this.money = money;
		this.updateTotalMoney(membersId, this.money);
		return this.money;
	}
	/**
	 * 获取团队所有下线ID
	 * @param membersId
	 * @param childIds
	 * @return
	 */
	public String getAllChildIds(String membersId,String childIds){
		this.childIds = childIds;
		this.setChildsIds(membersId, this.childIds);
		return this.childIds;
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
		List<CoinLog> coins = coinLogDao.findByUid(uid);
		String[] ids = new String[coins.size()];
		for(int i=0; i<coins.size(); i++)
			ids[i] = coins.get(i).getId()+"";
		coinLogDao.deleteAll(ids);
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
			this.money = this.money.add(child.getMcoin());
			updateTotalMoney(child.getUid()+"",this.money);
		}
	}
	
	private void setChildsIds(String membersId,String childIds){
		List<Members> childs = membersDao.findChilds(membersId);
		for(int i=0; i<childs.size(); i++){
			Members child = childs.get(i);
			this.childIds = this.childIds + child.getUid();
			setChildsIds(child.getUid()+"",this.childIds);
		}
	}

	@Override
	public PageList<Map> findMembersBankInfo(PageRequest pageRequest) {
		PageList<Map> membersBankInfoMap=membersDao.findMembersBankInfo(pageRequest.getParameter(), pageRequest.getPageBounds());
		return membersBankInfoMap;
	}

	@Override
	public List<Notice> getNotice() {
		return noticeDao.findAll();
	}

	
}
