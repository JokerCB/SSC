package com.ssc.demo.model;

import framework.generic.annotation.Column;
import framework.generic.annotation.Table;
import framework.generic.model.PersistentModel;

/**
 * 开奖数据
 */
@Table(name = "ssc_data")
public class Data implements PersistentModel {
	
	/**
	 * 主健ID
	 */
	@Column(name = "id", pk = true, order = 0)
	private Integer id;
	/**
	 * 时时彩种类，对应ssc_type.id
	 */
	@Column(name = "type")
	private int type;
	/**
	 * 期号(场次)
	 */
	@Column(name = "number")
	private String number;
	/**
	 * 开奖号码，半角逗号分开
	 */
	@Column(name = "data")
	private String data;
	/**
	 * 开奖时间
	 */
	@Column(name = "time")
	private String time;
	
	@Column(name = "status")
	private int status;

	/**
	 * 创建时间
	 */
	@Column(name = "createdate")
	private java.sql.Timestamp createdate;
	
	public Integer getId() {
		return this.id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public int getType() {
		return this.type;
	}
	
	public void setType(int type) {
		this.type = type;
	}
	
	public String getNumber() {
		return this.number;
	}
	
	public void setNumber(String number) {
		this.number = number;
	}
	
	public String getData() {
		return this.data;
	}
	
	public void setData(String data) {
		this.data = data;
	}
	
	public String getTime() {
		return this.time;
	}
	
	public void setTime(String time) {
		this.time = time;
	}
	
	public java.sql.Timestamp getCreatedate() {
		return this.createdate;
	}
	
	public void setCreatedate(java.sql.Timestamp createdate) {
		this.createdate = createdate;
	}
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
