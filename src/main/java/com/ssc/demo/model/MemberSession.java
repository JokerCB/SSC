package com.ssc.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import framework.generic.annotation.Column;
import framework.generic.annotation.Table;
import framework.generic.model.PersistentModel;

@Table(name = "ssc_member_session")
public class MemberSession implements PersistentModel {
	
	@Column(name = "id", pk = true, order = 0)
	private Integer id;
	@Column(name = "uid")
	private Integer uid;
	@Column(name = "username")
	private String username;
	@Column(name = "session_key")
	private String sessionKey;
	@Column(name = "loginTime")
	private Integer logintime;
	/**
	 * 最后访问时间
	 */
	@Column(name = "accessTime")
	private Integer accesstime;
	/**
	 * 是否在线，判断是否在线除判断这个值外，还应该判断最后访问时间
	 */
	@Column(name = "isOnLine")
	private Boolean isonline;
	@Column(name = "loginIP")
	private Integer loginip;
	/**
	 * 浏览器类型
	 */
	@Column(name = "browser")
	private String browser;
	/**
	 * 操作系统类型
	 */
	@Column(name = "os")
	private String os;
	/**
	 * 是否移动设备
	 */
	@Column(name = "isMobileDevices")
	private Boolean ismobiledevices;
	
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
	
	public String getUsername() {
		return this.username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getSessionKey() {
		return this.sessionKey;
	}
	
	public void setSessionKey(String sessionKey) {
		this.sessionKey = sessionKey;
	}
	
	public Integer getLogintime() {
		return this.logintime;
	}
	
	public void setLogintime(Integer logintime) {
		this.logintime = logintime;
	}
	
	public Integer getAccesstime() {
		return this.accesstime;
	}
	
	public void setAccesstime(Integer accesstime) {
		this.accesstime = accesstime;
	}
	
	public Boolean getIsonline() {
		return this.isonline;
	}
	
	public void setIsonline(Boolean isonline) {
		this.isonline = isonline;
	}
	
	public Integer getLoginip() {
		return this.loginip;
	}
	
	public void setLoginip(Integer loginip) {
		this.loginip = loginip;
	}
	
	public String getBrowser() {
		return this.browser;
	}
	
	public void setBrowser(String browser) {
		this.browser = browser;
	}
	
	public String getOs() {
		return this.os;
	}
	
	public void setOs(String os) {
		this.os = os;
	}
	
	public Boolean getIsmobiledevices() {
		return this.ismobiledevices;
	}
	
	public void setIsmobiledevices(Boolean ismobiledevices) {
		this.ismobiledevices = ismobiledevices;
	}
	
}
