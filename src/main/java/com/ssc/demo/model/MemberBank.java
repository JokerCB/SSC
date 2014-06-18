package com.ssc.demo.model;

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
	/**
	 * 会员ID
	 */
	@Column(name = "uid")
	private Integer uid;
	
	@Column(name = "enable")
	private Boolean enable;
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
	/**
	 * 创建人
	 */
	@Column(name = "create_name")
	private String createName;
	/**
	 * 创建时间
	 */
	@Column(name = "create_date")
	private java.sql.Timestamp createDate;
	/**
	 * 修改人
	 */
	@Column(name = "modify_name")
	private String modifyName;
	/**
	 * 修改时间
	 */
	@Column(name = "modify_date")
	private java.sql.Timestamp modifyDate;
	
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
	
	public String getCreateName() {
		return this.createName;
	}
	
	public void setCreateName(String createName) {
		this.createName = createName;
	}
	
	public java.sql.Timestamp getCreateDate() {
		return this.createDate;
	}
	
	public void setCreateDate(java.sql.Timestamp createDate) {
		this.createDate = createDate;
	}
	
	public String getModifyName() {
		return this.modifyName;
	}
	
	public void setModifyName(String modifyName) {
		this.modifyName = modifyName;
	}
	
	public java.sql.Timestamp getModifyDate() {
		return this.modifyDate;
	}
	
	public void setModifyDate(java.sql.Timestamp modifyDate) {
		this.modifyDate = modifyDate;
	}
}
