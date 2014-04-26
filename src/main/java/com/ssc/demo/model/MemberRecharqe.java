package com.ssc.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import framework.generic.annotation.Column;
import framework.generic.annotation.Table;
import framework.generic.model.PersistentModel;

/**
 * 充值表
 */
@Table(name = "ssc_member_recharge")
public class MemberRecharqe implements PersistentModel {
	
	@Column(name = "id", pk = true, order = 0)
	private Integer id;
	@Column(name = "uid")
	private Integer uid;
	@Column(name = "rechargeId")
	private Integer rechargeid;
	@Column(name = "username")
	private String username;
	/**
	 * 充值资金
	 */
	@Column(name = "amount")
	private Float amount;
	@Column(name = "rechargeAmount")
	private Float rechargeamount;
	/**
	 * 充值前用户资金
	 */
	@Column(name = "coin")
	private Float coin;
	/**
	 * 充值前用户冻结资金
	 */
	@Column(name = "fcoin")
	private Float fcoin;
	/**
	 * 操作用户ID
	 */
	@Column(name = "actionUid")
	private Integer actionuid;
	@Column(name = "BankId")
	private String bankid;
	@Column(name = "mBankId")
	private Byte mbankid;
	@Column(name = "actionIP")
	private Integer actionip;
	@Column(name = "actionTime")
	private Integer actiontime;
	/**
	 * 到帐时间
	 */
	@Column(name = "rechargeTime")
	private Integer rechargetime;
	/**
	 * 充值订单状态：0申请，1成功到账
	 */
	@Column(name = "state")
	private Boolean state;
	@Column(name = "isDelete")
	private Boolean isdelete;
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
	
	public Integer getRechargeid() {
		return this.rechargeid;
	}
	
	public void setRechargeid(Integer rechargeid) {
		this.rechargeid = rechargeid;
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public Float getAmount() {
		return this.amount;
	}
	
	public void setAmount(Float amount) {
		this.amount = amount;
	}
	
	public Float getRechargeamount() {
		return this.rechargeamount;
	}
	
	public void setRechargeamount(Float rechargeamount) {
		this.rechargeamount = rechargeamount;
	}
	
	public Float getCoin() {
		return this.coin;
	}
	
	public void setCoin(Float coin) {
		this.coin = coin;
	}
	
	public Float getFcoin() {
		return this.fcoin;
	}
	
	public void setFcoin(Float fcoin) {
		this.fcoin = fcoin;
	}
	
	public Integer getActionuid() {
		return this.actionuid;
	}
	
	public void setActionuid(Integer actionuid) {
		this.actionuid = actionuid;
	}
	
	public String getBankid() {
		return this.bankid;
	}
	
	public void setBankid(String bankid) {
		this.bankid = bankid;
	}
	
	public Byte getMbankid() {
		return this.mbankid;
	}
	
	public void setMbankid(Byte mbankid) {
		this.mbankid = mbankid;
	}
	
	public Integer getActionip() {
		return this.actionip;
	}
	
	public void setActionip(Integer actionip) {
		this.actionip = actionip;
	}
	
	public Integer getActiontime() {
		return this.actiontime;
	}
	
	public void setActiontime(Integer actiontime) {
		this.actiontime = actiontime;
	}
	
	public Integer getRechargetime() {
		return this.rechargetime;
	}
	
	public void setRechargetime(Integer rechargetime) {
		this.rechargetime = rechargetime;
	}
	
	public Boolean getState() {
		return this.state;
	}
	
	public void setState(Boolean state) {
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
