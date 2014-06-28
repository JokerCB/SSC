package com.ssc.demo.service;

import java.util.List;

import com.ssc.demo.model.Data;
import com.ssc.demo.model.Order;
import com.ssc.demo.model.OrderDetail;
import com.ssc.demo.web.ui.PageRequest;

import framework.generic.paginator.domain.PageList;

public interface OrderService {
	
	public Order load(String orderId);

	public int addOrder(Order order);
	
	public int addOrders(List<Order> orders);
	
	public int cancel(Order order);
	
	public int cancel(List<Order> orders);
	
	public String buildOrderId(String type);
	
	public PageList<OrderDetail> findDetailsByPage(PageRequest pageRequest);
	
	public Data getLotteryData(int type);
	
	public void addBonus(String dataId);
	
	public void addBonus(Data data);
	
	List<Order> findOrderByZhuiHaoId(String zhuiHaoId,int status);
}
