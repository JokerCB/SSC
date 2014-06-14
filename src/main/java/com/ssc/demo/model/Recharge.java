package com.ssc.demo.model;

import java.math.BigDecimal;
import java.util.Date;

import framework.generic.annotation.Column;
import framework.generic.model.PersistentModel;

/**
 * 充值记录
 */
public class Recharge  implements PersistentModel{

	private static final long serialVersionUID = -9218985453073185112L;

	@Column(name = "ID", pk = true)
	private int id;
	
	/**
	 * 用户ID
	 * Members.uid
	 */
	@Column(name = "UID")
	private Integer uid;
	
	
	/**
	 * 充值编号
	 */
	@Column(name = "rechargeNo")
	private String rechargeNo;	
	
	/**
	 * 银行ID
	 * Bank.id
	 */
	@Column(name = "banklistId")
	private String banklistId;
	
	/**
	 * 充值金额
	 */
	@Column(name = "amount")
	private BigDecimal amount;
	
	
	/**
	 * 实际到账金额
	 */
	@Column(name = "rechargeAmount")
	private BigDecimal rechargeAmount;
	
	
	/**
	 * 充值前用户资金
	 */
	@Column(name = "coin")
	private BigDecimal coin;
	
	/**
	 * 充值订单状态：0申请，1成功到账，2失败
	 */
	@Column(name = "state")
	private int state;
	
	/**
	 * 备注
	 */
	@Column(name = "info")
	private String info;
	
	/**
	 * 
	 */
	@Column(name = "CREATE_DATE")
	private Date createDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getRechargeNo() {
		return rechargeNo;
	}

	public void setRechargeNo(String rechargeNo) {
		this.rechargeNo = rechargeNo;
	}

	public String getBanklistId() {
		return banklistId;
	}

	public void setBanklistId(String banklistId) {
		this.banklistId = banklistId;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public BigDecimal getRechargeAmount() {
		return rechargeAmount;
	}

	public void setRechargeAmount(BigDecimal rechargeAmount) {
		this.rechargeAmount = rechargeAmount;
	}

	public BigDecimal getCoin() {
		return coin;
	}

	public void setCoin(BigDecimal coin) {
		this.coin = coin;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}	
	
}
