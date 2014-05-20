package com.ssc.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssc.demo.model.Order;
import com.ssc.demo.model.OrderDetail;

import framework.generic.paginator.domain.PageBounds;
import framework.generic.paginator.domain.PageList;

public interface OrderDao {
	
	/**
	 * 根据订单编号查询订单
	 * @param orderId
	 * @return
	 */
	Order load(@Param("orderId") String orderId);

	void saveOrder(Order order);
	
	void saveOrderDetail(OrderDetail detail);
	
	/**
	 * 根据期号查询订单主表数据
	 * @param lt_issue_start
	 * @return
	 */
	List<Order> findOrder(@Param("ltIssueStart") String ltIssueStart);
	
	
	/**
	 * 更新订单主表的状态
	 * @param order
	 */
	void updateOrder(Order order);
	
	/**
	 * 根据订单编号查询订单明细表
	 * @param orderId
	 * @return
	 */
	List<OrderDetail> findOrderDetail(@Param("orderId") String orderId);
	
	/**
	 * 更新订单明细表的开奖号码和是否中奖
	 * @param detail
	 */
	void updateOrderDetail(OrderDetail detail);
	
	
	
	String selectMaxCode(@Param("startDate")String startDate,@Param("endDate")String endDate);
	
	/**
	 * 分页查询，必须是传递一个pagination
	 * 
	 * @param pagination
	 *            分页工具类
	 * @return pagination 分页工具类
	 */
	PageList<OrderDetail> findDetailsByPage(Object parameters, PageBounds pageBounds);
}
