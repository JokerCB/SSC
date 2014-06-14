package com.ssc.demo.service;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ssc.demo.dao.RechargeDao;
import com.ssc.demo.model.Recharge;
import com.ssc.demo.web.ui.PageRequest;

import framework.generic.paginator.domain.PageList;
import framework.generic.utils.date.DateUtil;

@Service("rechargeService")
public class RechargeServiceImpl implements RechargeService {

	private RechargeDao rechargeDao;

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
}
