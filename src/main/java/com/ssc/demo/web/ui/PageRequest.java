package com.ssc.demo.web.ui;

import java.util.List;

import framework.generic.paginator.domain.Order;
import framework.generic.paginator.domain.PageBounds;
import framework.generic.util.Parameters;

public class PageRequest extends Parameters {

	private static final long serialVersionUID = -3451629128571049965L;
	// -- 公共变量 --//
	public static final String ASC = "asc";
	public static final String DESC = "desc";

	// -- 分页参数 --//
	/** 当前页 */
	protected int pageNo = 0;

	/** 每页显示几条 */
	protected int pageSize = 10;

	/** 排序字段 */
	protected String orderBy = null;

	/** 排序类型 */
	protected String order = DESC;

	protected String sort = "";

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}


	public String getSortString() {
		return this.getOrderBy() + "." + this.getOrder();
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public void addDefaultOrder(String sort) {
		this.sort = sort;
	}

	public PageBounds getPageBounds() {
		List<Order> orders = Order.formString(getSortString());
		if (orders.isEmpty()) {
			List<Order> defaultOrders = Order.formString(this.sort);
			if (!defaultOrders.isEmpty()) {
				orders.addAll(defaultOrders);
			}
		}
		return new PageBounds(pageNo, pageSize, orders);
	}
}
