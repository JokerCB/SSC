package com.ssc.demo.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.ssc.demo.dao.CoinLogDao;
import com.ssc.demo.dao.MemberCashDao;
import com.ssc.demo.dao.MembersDao;
import com.ssc.demo.model.CoinLog;
import com.ssc.demo.model.MemberCash;
import com.ssc.demo.model.Members;
import com.ssc.demo.web.ui.PageRequest;

import framework.generic.paginator.domain.PageList;
import framework.generic.utils.date.DateUtil;

@Service("memberCashService")
public class MemberCashServiceImpl implements MemberCashService {

	private MemberCashDao memberCashDao;
	
	private MembersService membersService;
	
	private CoinLogDao coinLogDao;
	@Resource
	private MembersDao membersDao;
	@Resource
	public void setMemberCashDao(MemberCashDao memberCashDao) {
		this.memberCashDao = memberCashDao;
	}
	
	@Resource
	public void setMembersService(MembersService membersService) {
		this.membersService = membersService;
	}

	@Resource
	public void setCoinLogDao(CoinLogDao coinLogDao) {
		this.coinLogDao = coinLogDao;
	}


	@Override
	public MemberCash load(String id) {		
		return memberCashDao.load(id);
	}

	@Override
	public void save(MemberCash memberCash) {
		memberCashDao.save(memberCash);
		
	}

	@Override
	public void update(MemberCash memberCash) {
		memberCashDao.update(memberCash);
		
	}

	@Override
	public void delete(String id) {
		memberCashDao.delete(id);
		
	}

	@Override
	public PageList<MemberCash> findByPage(PageRequest pageRequest) {
		PageList<MemberCash>  recharge = memberCashDao.findByPage(pageRequest.getParameter(), pageRequest.getPageBounds());
		return recharge;
	}
	
	public String buildCashNo(){
		String RechargeNo = null;
		Date now = new Date();
		String maxId = memberCashDao.selectMaxCode(DateUtil.formatDate(now)+" 00:00:00", DateUtil.formatDate(now)+" 23:59:59");
		if(maxId != null){
			int index = Integer.parseInt(maxId.substring(10)) +1;
			if(index<10)
				RechargeNo = maxId.substring(0,10)+"000"+index;
			else if(index<100)
				RechargeNo = maxId.substring(0,10)+"00"+index;
			else if(index<1000)
				RechargeNo = maxId.substring(0,10)+"0"+index;
			else
				RechargeNo = maxId.substring(0,10)+index;
				
		}
		else{
			RechargeNo = "TX"+DateUtil.formatDate(now).replace("-", "")+"0001";
		}
		
		return RechargeNo;
	}
	
	@Override
	public int getCountToday(String uid) {
		Date now = new Date();
		return memberCashDao.getCountToday(uid, DateUtil.formatDate(now) + " 00:00:00", DateUtil.formatDate(now) + " 23:59:59");
	}

	@Override
	public void saveCash(Members member, MemberCash memberCash) {
		BigDecimal mCoin = member.getMcoin();
		member.setMcoin(member.getMcoin().subtract(memberCash.getAmount()));
		membersService.modify(member);
		memberCash.setCashNo(this.buildCashNo());
		memberCashDao.save(memberCash);
		CoinLog coinLog = new CoinLog();
		coinLog.setUid(memberCash.getUid());
		coinLog.setOrderId(memberCash.getCashNo());
		coinLog.setCoin(mCoin);
		coinLog.setUserCoin(member.getMcoin());
		coinLog.setLiqType(101);
		coinLog.setCreateDate(new Date());
		coinLogDao.saveCoinLog(coinLog);	
	}

	@Override
	public PageList<Map> findCashByPage(PageRequest pageRequest) {
		PageList<Map> cashMap=memberCashDao.findCashByPage(pageRequest.getParameter(), pageRequest.getPageBounds());
		return cashMap;
	}

	@Override
	public void updateCash(int id, int state,int uid) {
		if (state==2)//拒绝，更新ssc_coin_log
		{
			MemberCash memberCash =memberCashDao.load(id+"");
	        Members		members=	membersDao.load(uid, null, null);
			CoinLog coinLog = new CoinLog();
			coinLog.setUid(uid);
			coinLog.setOrderId(memberCash.getCashNo());
			coinLog.setType(1);
			coinLog.setPlayedId(0);
			coinLog.setCoin(memberCash.getAmount());
			coinLog.setUserCoin(memberCash.getAmount().add(members.getMcoin()));
			coinLog.setLiqType(3);
			coinLog.setCreateDate(new Date());
			coinLogDao.saveCoinLog(coinLog);	
			members.setMcoin(memberCash.getAmount().add(members.getMcoin()));
			membersDao.updateMembersCoin(uid, members.getMcoin());
		}
		MemberCash memberCash=new MemberCash();
		memberCash.setState(state);
		memberCash.setId(id);
		memberCashDao.update(memberCash);
	}

	
}
