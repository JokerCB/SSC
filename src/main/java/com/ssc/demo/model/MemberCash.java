package com.ssc.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import framework.generic.annotation.Column;
import framework.generic.annotation.Table;
import framework.generic.model.PersistentModel;

/**
 * 用户提现表
 */
@Table(name = "ssc_member_cash")
public class MemberCash implements PersistentModel {
	
	@Column(name = "id", pk = true, order = 0)
	private Integer id;
	/**
	 * 用户ID
	 */
	@Column(name = "uid")
	private Integer uid;
	/**
	 * 申请时间
	 */
	@Column(name = "actionTime")
	private Integer actiontime;
	/**
	 * 提现金额
	 */
	@Column(name = "amount")
	private Float amount;
	/**
	 * 银行ID
	 */
	@Column(name = "bankId")
	private Integer bankid;
	/**
	 * 银行帐号
	 */
	@Column(name = "account")
	private String account;
	/**
	 * 银行开户名
	 */
	@Column(name = "username")
	private String username;
	/**
	 * 提现状态：1用户申请，2已取消，3已支付，4提现失败，0确认到帐, 5后台删除
	 */
	@Column(name = "state")
	private Byte state;
	@Column(name = "isDelete")
	private Boolean isdelete;
	/**
	 * 备注字段
	 */
	@Column(name = "info")
	private String info;
	
	public Integer getId() {
		return this.id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getUid() {
		return this.uid;
	}
	
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	
	public Integer getActiontime() {
		return this.actiontime;
	}
	
	public void setActiontime(Integer actiontime) {
		this.actiontime = actiontime;
	}
	
	public Float getAmount() {
		return this.amount;
	}
	
	public void setAmount(Float amount) {
		this.amount = amount;
	}
	
	public Integer getBankid() {
		return this.bankid;
	}
	
	public void setBankid(Integer bankid) {
		this.bankid = bankid;
	}
	
	public String getAccount() {
		return this.account;
	}
	
	public void setAccount(String account) {
		this.account = account;
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public Byte getState() {
		return this.state;
	}
	
	public void setState(Byte state) {
		this.state = state;
	}
	
	public Boolean getIsdelete() {
		return this.isdelete;
	}
	
	public void setIsdelete(Boolean isdelete) {
		this.isdelete = isdelete;
	}
	
	public String getInfo() {
		return this.info;
	}
	
	public void setInfo(String info) {
		this.info = info;
	}
	
}
