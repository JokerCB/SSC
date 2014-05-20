package com.ssc.demo.service;

import com.ssc.demo.model.Data;
import com.ssc.demo.model.Order;
import com.ssc.demo.model.OrderDetail;
import com.ssc.demo.web.ui.PageRequest;

import framework.generic.paginator.domain.PageList;

public interface OrderService {
	
	public Order load(String orderId);

	public int addOrder(Order order);
	
	public String buildOrderId();
	
	public PageList<OrderDetail> findDetailsByPage(PageRequest pageRequest);
	
	public Data getLotteryData(int type);
	
	public void addBonus(Data data);
}
