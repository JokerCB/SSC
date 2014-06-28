package com.ssc.demo.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import framework.generic.annotation.Column;
import framework.generic.model.PersistentModel;

/**
 * 订单
 */
public class Order  implements PersistentModel{

	private static final long serialVersionUID = -9218985453073185112L;

	@Column(name = "OID", pk = true)
	private int oid;
	
	/**
	 * 订单编号
	 */
	@Column(name = "ORDERID")
	private String orderId;
	
	/**
	 * 用户ID
	 * Members.uid
	 */
	@Column(name = "UID")
	private Integer uid;
	
	
	/**
	 * 彩种
	 * Type.type
	 */
	@Column(name = "TYPE")
	private int type;	
	
	/**
	 * 期号
	 */
	@Column(name = "LT_ISSUE_START")
	private String ltIssueStart;
	
	/**
	 * 总金额
	 */
	@Column(name = "LT_TOTAL_MONEY")
	private BigDecimal ltTotalMoney;
	
	
	/**
	 * 总投注注数
	 */
	@Column(name = "TOTALACTIONNUM")
	private int totalActionNum;
	
	
	/**
	 * 订单状态（0：未开奖；1：已开奖；2：已作废）
	 */
	@Column(name = "STATUS")
	private int status;
	
	/**
	 * 追号编号
	 */
	@Column(name = "zhuiHaoId")
	private String zhuiHaoId;
	/**
	 * 是否追号
	 */
	@Column(name = "zhuiHao")
	private boolean zhuiHao;
	/**
	 * 中奖后停止追号
	 */
	@Column(name = "isStop")
	private boolean isStop;
	
	
	
	/**
	 * 
	 */
	@Column(name = "CREATEDATE")
	private Date createDate;
	
	
	private List<OrderDetail> orderDetails;


	public int getOid() {
		return oid;
	}


	public void setOid(int oid) {
		this.oid = oid;
	}


	public String getOrderId() {
		return orderId;
	}


	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}


	public Integer getUid() {
		return uid;
	}


	public void setUid(Integer uid) {
		this.uid = uid;
	}


	public int getType() {
		return type;
	}


	public void setType(int type) {
		this.type = type;
	}


	public String getLtIssueStart() {
		return ltIssueStart;
	}


	public void setLtIssueStart(String ltIssueStart) {
		this.ltIssueStart = ltIssueStart;
	}


	public BigDecimal getLtTotalMoney() {
		return ltTotalMoney;
	}


	public void setLtTotalMoney(BigDecimal ltTotalMoney) {
		this.ltTotalMoney = ltTotalMoney;
	}


	public int getTotalActionNum() {
		return totalActionNum;
	}


	public void setTotalActionNum(int totalActionNum) {
		this.totalActionNum = totalActionNum;
	}


	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}	

	public String getZhuiHaoId() {
		return zhuiHaoId;
	}


	public void setZhuiHaoId(String zhuiHaoId) {
		this.zhuiHaoId = zhuiHaoId;
	}


	public boolean getZhuiHao() {
		return zhuiHao;
	}


	public void setZhuiHao(boolean zhuiHao) {
		this.zhuiHao = zhuiHao;
	}


	public boolean getIsStop() {
		return isStop;
	}


	public void setIsStop(boolean isStop) {
		this.isStop = isStop;
	}


	public Date getCreateDate() {
		return createDate;
	}


	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}


	public List<OrderDetail> getOrderDetails() {
		return orderDetails;
	}


	public void setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}
	
	
	
	
}
