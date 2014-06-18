package com.ssc.demo.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ssc.demo.dao.CoinLogDao;
import com.ssc.demo.dao.MembersDao;
import com.ssc.demo.dao.RechargeDao;
import com.ssc.demo.model.CoinLog;
import com.ssc.demo.model.Members;
import com.ssc.demo.model.Recharge;
import com.ssc.demo.web.ui.PageRequest;

import framework.generic.paginator.domain.PageBounds;
import framework.generic.paginator.domain.PageList;
import framework.generic.utils.date.DateUtil;

@Service("rechargeService")
public class RechargeServiceImpl implements RechargeService {

	private RechargeDao rechargeDao;

	@Resource
	private CoinLogDao coinLogDao;
	
	@Resource
	private RechargeService rechargeService;
	@Resource
	private MembersDao membersDao;
	
	@Resource
	public void setRechargeDao(RechargeDao rechargeDao) {
		this.rechargeDao = rechargeDao;
	}

	@Override
	public Recharge load(String id) {		
		return rechargeDao.load(id);
	}

	@Override
	public void save(Recharge recharge) {
		rechargeDao.save(recharge);
		
	}

	@Override
	public void update(Recharge recharge) {
		rechargeDao.update(recharge);
		
	}

	@Override
	public void delete(String id) {
		rechargeDao.delete(id);
		
	}

	@Override
	public PageList<Recharge> findByPage(PageRequest pageRequest) {
		PageList<Recharge>  recharge = rechargeDao.findByPage(pageRequest.getParameter(), pageRequest.getPageBounds());
		return recharge;
	}
	
	public String buildRechargeNo(){
		String RechargeNo = null;
		Date now = new Date();
		String maxId = rechargeDao.selectMaxCode(DateUtil.formatDate(now)+" 00:00:00", DateUtil.formatDate(now)+" 23:59:59");
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
			RechargeNo = "CZ"+DateUtil.formatDate(now).replace("-", "")+"0001";
		}
		
		return RechargeNo;
	}

	@Override
	public PageList<Map> findRechargeLogByPage(PageRequest pageRequest) {
		PageList<Map> rechargeLogMap=rechargeDao.findRechargeLogByPage(pageRequest.getParameter(), pageRequest.getPageBounds());
		return rechargeLogMap;
	}

	@Override
	public void addCoinLog(String uId) {
		
		Recharge recharge = rechargeDao.load(uId);
		Members members = membersDao.load(recharge.getUid(), null, null);
		members.setMcoin(members.getMcoin().add(recharge.getCoin()));
		CoinLog coinLog = new CoinLog();
		coinLog.setUid(recharge.getUid());
		coinLog.setOrderId(recharge.getRechargeNo());
		coinLog.setType(1);
		coinLog.setPlayedId(0);
		coinLog.setCoin(recharge.getCoin());
		coinLog.setUserCoin(members.getMcoin());
		coinLog.setLiqType(102);
		coinLog.setCreateDate(new Date());
		coinLogDao.saveCoinLog(coinLog);
		membersDao.updateMembersCoin(recharge.getUid(), members.getMcoin());
		recharge.setState(1);
		rechargeDao.update(recharge);
	}

	@Override
	public String actionCoinLog(Integer id,String uid,String amount) {
	Members members=new Members();
		if (id==1)
		{
			members=	membersDao.load(Integer.parseInt(uid), null, null);
		}else if (id ==2)
		{
			members=membersDao.load(null, uid, null);
		}
		if (members!=null)
		{
			members.setMcoin(members.getMcoin().add(new BigDecimal(amount)));
			CoinLog coinLog = new CoinLog();
			Recharge recharge =new Recharge();
			coinLog.setUid(members.getUid());
			coinLog.setOrderId(rechargeService.buildRechargeNo());
			coinLog.setType(1);
			coinLog.setPlayedId(0);
			coinLog.setCoin(new BigDecimal(amount));
			coinLog.setUserCoin(members.getMcoin());
			coinLog.setLiqType(102);
			coinLog.setCreateDate(new Date());
			coinLogDao.saveCoinLog(coinLog);
			membersDao.updateMembersCoin(members.getUid(), members.getMcoin());
			recharge.setState(1);
			recharge.setAmount(new BigDecimal(amount));
			recharge.setCoin(members.getMcoin());
			recharge.setInfo("手动充值");
			recharge.setCreateDate(new Date());
			rechargeDao.save(recharge);
			return "该用户充值成功！";
		}else
		{
			return "该用户不存在！";
		}
	
		
	}
	
	
}
