package com.ssc.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import framework.generic.annotation.Column;
import framework.generic.annotation.Table;
import framework.generic.model.PersistentModel;

@Table(name = "ssc_admin_bank")
public class AdminBank implements PersistentModel {
	
	@Column(name = "id", pk = true, order = 0)
	private Integer id;
	/**
	 * 关联ssc_bank_list表id,支付方式
	 */
	@Column(name = "bankId")
	private Integer bankid;
	/**
	 * 银行卡对应用户名
	 */
	@Column(name = "username")
	private String username;
	/**
	 * 开户行省份ID，关联ssc_bas_province表FID
	 */
	@Column(name = "provinceId")
	private String provinceid;
	/**
	 * 开户行城市ID，关联ssc_bas_city表FID;
	 */
	@Column(name = "cityId")
	private String cityid;
	/**
	 * 银行帐号
	 */
	@Column(name = "account")
	private String account;
	/**
	 * 开户行名称
	 */
	@Column(name = "bankCardName")
	private String bankcardname;
	
	
	public Integer getId() {
		return this.id;
	}
	
	public void setId(Integer id) {
		this.id = id;
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
	
	public String getProvinceid() {
		return this.provinceid;
	}
	
	public void setProvinceid(String provinceid) {
		this.provinceid = provinceid;
	}
	
	public String getCityid() {
		return this.cityid;
	}
	
	public void setCityid(String cityid) {
		this.cityid = cityid;
	}
	
	public String getAccount() {
		return this.account;
	}
	
	public void setAccount(String account) {
		this.account = account;
	}
	
	public String getBankcardname() {
		return this.bankcardname;
	}
	
	public void setBankcardname(String bankcardname) {
		this.bankcardname = bankcardname;
	}
	
	
	
}
