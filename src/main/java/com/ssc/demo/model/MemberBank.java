package com.ssc.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import framework.generic.annotation.Column;
import framework.generic.annotation.Table;
import framework.generic.model.PersistentModel;

/**
 * 用户银行帐户信息
 */
@Table(name = "ssc_member_bank")
public class MemberBank implements PersistentModel {
	
	@Column(name = "id", pk = true, order = 0)
	private Integer id;
	@Column(name = "uid")
	private Integer uid;
	/**
	 * 非普通用户信息
	 */
	@Column(name = "admin")
	private Boolean admin;
	@Column(name = "enable")
	private Boolean enable;
	@Column(name = "bankId")
	private Integer bankid;
	@Column(name = "username")
	private String username;
	@Column(name = "account")
	private String account;
	/**
	 * 充值演示图片
	 */
	@Column(name = "rechargeDemo")
	private String rechargedemo;
	@Column(name = "editEnable")
	private Boolean editenable;
	
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
	
	public Boolean getAdmin() {
		return this.admin;
	}
	
	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}
	
	public Boolean getEnable() {
		return this.enable;
	}
	
	public void setEnable(Boolean enable) {
		this.enable = enable;
	}
	
	public Integer getBankid() {
		return this.bankid;
	}
	
	public void setBankid(Integer bankid) {
		this.bankid = bankid;
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getAccount() {
		return this.account;
	}
	
	public void setAccount(String account) {
		this.account = account;
	}
	
	public String getRechargedemo() {
		return this.rechargedemo;
	}
	
	public void setRechargedemo(String rechargedemo) {
		this.rechargedemo = rechargedemo;
	}
	
	public Boolean getEditenable() {
		return this.editenable;
	}
	
	public void setEditenable(Boolean editenable) {
		this.editenable = editenable;
	}
	
}
