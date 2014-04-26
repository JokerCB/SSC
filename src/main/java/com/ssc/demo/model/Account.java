package com.ssc.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import framework.generic.annotation.Column;
import framework.generic.annotation.Table;
import framework.generic.model.PersistentModel;

@Table(name = "ssc_account")
public class Account implements PersistentModel {
	
	@Column(name = "uid", pk = true, order = 0)
	private Integer uid;
	/**
	 * 用户名
	 */
	@Column(name = "uname")
	private String uname;
	/**
	 * 用户别名
	 */
	@Column(name = "ualias")
	private String ualias;
	/**
	 * 用户登陆密码
	 */
	@Column(name = "upwd")
	private String upwd;
	/**
	 * 是否启用（1-启用，0-停用）
	 */
	@Column(name = "is_enable")
	private Boolean isEnable;
	/**
	 * 是否管理员（1-是，0-否）
	 */
	@Column(name = "is_admin")
	private Boolean isAdmin;
	/**
	 * 最后登录日期
	 */
	@Column(name = "last_login_date")
	private java.sql.Timestamp lastLoginDate;
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
	
	public Integer getUid() {
		return this.uid;
	}
	
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	
	public String getUname() {
		return this.uname;
	}
	
	public void setUname(String uname) {
		this.uname = uname;
	}
	
	public String getUalias() {
		return this.ualias;
	}
	
	public void setUalias(String ualias) {
		this.ualias = ualias;
	}
	
	public String getUpwd() {
		return this.upwd;
	}
	
	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}
	
	public Boolean getIsEnable() {
		return this.isEnable;
	}
	
	public void setIsEnable(Boolean isEnable) {
		this.isEnable = isEnable;
	}
	
	public Boolean getIsAdmin() {
		return this.isAdmin;
	}
	
	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	
	public java.sql.Timestamp getLastLoginDate() {
		return this.lastLoginDate;
	}
	
	public void setLastLoginDate(java.sql.Timestamp lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
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
