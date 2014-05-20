package com.ssc.demo.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ssc.demo.dao.CoinLogDao;
import com.ssc.demo.dao.DataDao;
import com.ssc.demo.dao.MembersDao;
import com.ssc.demo.dao.OrderDao;
import com.ssc.demo.dao.PlayedDao;
import com.ssc.demo.model.CoinLog;
import com.ssc.demo.model.Data;
import com.ssc.demo.model.Members;
import com.ssc.demo.model.Order;
import com.ssc.demo.model.OrderDetail;
import com.ssc.demo.model.Played;
import com.ssc.demo.web.ui.PageRequest;

import framework.generic.paginator.domain.PageList;
import framework.generic.utils.date.DateUtil;

@Service("orderService")
public class OrderServiceImpl implements OrderService{

	@Resource
	private OrderDao orderDao;
	
	@Resource
	private DataDao dataDao;
	
	@Resource
	private PlayedService playedService;
	
	@Resource
	private PlayedDao playedDao;
	
	@Resource
	private MembersDao membersDao;
	
	@Resource
	private CoinLogDao coinLogDao;
	
	@Override
	public Order load(String orderId) {
		// TODO Auto-generated method stub
		return orderDao.load(orderId);
	}

	
	@Override
	public int addOrder(Order order) {
		order.setOrderId(this.buildOrderId());
		orderDao.saveOrder(order);		
		Members members = membersDao.load(order.getUid(),null,null);
		List<OrderDetail> detailList = order.getOrderDetails();
		for(int i=0; i<detailList.size(); i++){
			OrderDetail detail = detailList.get(i);
			detail.setOrderId(order.getOrderId());
			orderDao.saveOrderDetail(detail);
			
			CoinLog coinLog = new CoinLog();
			coinLog.setUid(order.getUid());
			coinLog.setOrderId(order.getOrderId());
			coinLog.setType(order.getType());
			coinLog.setPlayedId(detail.getPlayId());
			coinLog.setCoin(detail.getActionMoney().multiply(new BigDecimal("-1")));
			coinLog.setUserCoin(members.getMcoin().add(coinLog.getCoin()));
			coinLog.setLiqType(102);
			coinLog.setCreateDate(new Date());
			coinLogDao.saveCoinLog(coinLog);			
		}
		members.setMcoin(members.getMcoin().subtract(order.getLtTotalMoney()));
		membersDao.updateMembersCoin(order.getUid(), members.getMcoin().subtract(order.getLtTotalMoney()));
		
		//添加返点
		for(int i=0; i<detailList.size(); i++){
			OrderDetail detail = detailList.get(i);
			//需要返点
			if(detail.getOmodel() ==1){
				Members child = members; 
				int parentId = members.getMparentid();
				while(parentId != 0){
					Members parent = membersDao.load(parentId, null, null);
					BigDecimal pF = parent.getMfandian().subtract(child.getMfandian());
					//不定位返点
					if(detail.getPlayId() == 18 ||detail.getPlayId() == 20||detail.getPlayId() == 512||detail.getPlayId() == 513){
						pF = parent.getMfandianbdw().subtract(child.getMfandianbdw());
					}
					pF = detail.getActionMoney().multiply(pF).divide(new BigDecimal("100"));
					membersDao.updateMembersCoin(parentId, parent.getMcoin().add(pF));
					CoinLog pCoinLog = new CoinLog();
					pCoinLog.setUid(parentId);
					pCoinLog.setOrderId(order.getOrderId());
					pCoinLog.setType(order.getType());
					pCoinLog.setPlayedId(detail.getPlayId());
					pCoinLog.setCoin(pF);
					pCoinLog.setUserCoin(parent.getMcoin().add(pCoinLog.getCoin()));
					pCoinLog.setLiqType(2);
					pCoinLog.setCreateDate(new Date());
					coinLogDao.saveCoinLog(pCoinLog);										
					
					child = parent;
					parentId = parent.getMparentid();
				}
				BigDecimal fandian = members.getMfandian();
				//不定位返点
				if(detail.getPlayId() == 18 ||detail.getPlayId() == 20||detail.getPlayId() == 512||detail.getPlayId() == 513){
					fandian = members.getMfandianbdw();
				}
				fandian = detail.getActionMoney().multiply(fandian).divide(new BigDecimal("100"));
				membersDao.updateMembersCoin(members.getUid(), members.getMcoin().add(fandian));
				CoinLog mCoinLog = new CoinLog();
				mCoinLog.setUid(members.getUid());
				mCoinLog.setOrderId(order.getOrderId());
				mCoinLog.setType(order.getType());
				mCoinLog.setPlayedId(detail.getPlayId());
				mCoinLog.setCoin(fandian);
				mCoinLog.setUserCoin(members.getMcoin().add(mCoinLog.getCoin()));
				mCoinLog.setLiqType(2);
				mCoinLog.setCreateDate(new Date());
				coinLogDao.saveCoinLog(mCoinLog);				
			}
		}
		return 0;
	}
	
	public String buildOrderId(){
		String OrderId = null;
		Date now = new Date();
		String maxId = orderDao.selectMaxCode(DateUtil.formatDate(now)+" 00:00:00", DateUtil.formatDate(now)+" 23:59:59");
		if(maxId != null){
			int index = Integer.parseInt(maxId.substring(8)) +1;
			if(index<10)
				OrderId = maxId.substring(0,8)+"000"+index;
			else if(index<100)
				OrderId = maxId.substring(0,8)+"00"+index;
			else if(index<1000)
				OrderId = maxId.substring(0,8)+"0"+index;
			else
				OrderId = maxId.substring(0,8)+index;
				
		}
		else{
			OrderId = DateUtil.formatDate(now).replace("-", "")+"0001";
		}
		
		return OrderId;
	}
	
	public PageList<OrderDetail> findDetailsByPage(PageRequest pageRequest) {
		PageList<OrderDetail> OrderDetails = orderDao.findDetailsByPage(pageRequest.getParameter(), pageRequest.getPageBounds());
		return OrderDetails;
	}


	/**
	 * 获得开奖数据（并且完成返奖）
	 *
	 */
	@Override
	public Data getLotteryData(int type) {
		// TODO Auto-generated method stub
		Data data = dataDao.getLotteryData(type);
		
		return data;
	}
	
	public void addBonus(Data data){
		//开始返奖

		List<Order> orders = orderDao.findOrder(data.getNumber());
		for(int i=0; i<orders.size(); i++){
			BigDecimal zJJ = new BigDecimal("0");
			Order order= orders.get(i);
			Members members = membersDao.load(order.getUid(), null, null);
			List<OrderDetail> details = orderDao.findOrderDetail(order.getOrderId());
			for(int m=0; m<details.size();m++){
				BigDecimal JJ = new BigDecimal("0");
				BigDecimal model = new BigDecimal("1");//模式(1:元,2:角,3:分)
				OrderDetail detail = details.get(m);
				detail.setLotteryNo(data.getData());
				Played played = playedDao.load(detail.getPlayId());
				//判断是否中奖
				boolean isZJ = playedService.calcActionNumberData(detail);
				if(isZJ){
					if(detail.getMode() == 2)
						model = new BigDecimal("0.1");
					else if(detail.getMode() == 3)
						model = new BigDecimal("0.01");
					//带返点(包括不定位趣味等)
					if(detail.getOmodel() ==1 || played.getBonusPropMax().compareTo(played.getBonusPropMin()) == 0){
						JJ = played.getBonusPropMin().multiply(model).multiply(new BigDecimal(detail.getBeiShu()));
					}else{
						BigDecimal maxJJ = played.getBonusBase().multiply(members.getMfandian()).add(played.getBonusPropMin());
						JJ = maxJJ.multiply(model).multiply(new BigDecimal(detail.getBeiShu()));
					}
					
					detail.setBonus(JJ);

					members.setMcoin(members.getMcoin().add(JJ));
					
					CoinLog coinLog = new CoinLog();
					coinLog.setUid(order.getUid());
					coinLog.setOrderId(order.getOrderId());
					coinLog.setType(order.getType());
					coinLog.setPlayedId(detail.getPlayId());
					coinLog.setCoin(detail.getBonus());
					coinLog.setUserCoin(members.getMcoin());
					coinLog.setLiqType(5);
					coinLog.setCreateDate(new Date());
					coinLogDao.saveCoinLog(coinLog);
				}
				
				orderDao.updateOrderDetail(detail);				
			}
			orderDao.updateOrder(order);
			membersDao.updateMembersCoin(members.getUid(), members.getMcoin());
			dataDao.updateData(data);
		}
		
	}
	
}
