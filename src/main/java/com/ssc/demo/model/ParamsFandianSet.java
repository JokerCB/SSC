package com.ssc.demo.model;

import java.math.BigDecimal;

import framework.generic.annotation.Column;
import framework.generic.annotation.Table;
import framework.generic.model.PersistentModel;

@Table(name = "SSC_PARAMS_FANDIAN_SET")
public class ParamsFandianSet  implements PersistentModel{

	private static final long serialVersionUID = -9218985453073185112L;

	@Column(name = "ID", pk = true)
	private int id;
	

	@Column(name = "USER_COUNT")
	private int userCount;
	
	@Column(name = "FAND_DIAN")
	private BigDecimal fanDian;
	
	@Column(name = "B_FAN_DIAN")
	private BigDecimal bFanDian;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserCount() {
		return userCount;
	}

	public void setUserCount(int userCount) {
		this.userCount = userCount;
	}

	public BigDecimal getFanDian() {
		return fanDian;
	}

	public void setFanDian(BigDecimal fanDian) {
		this.fanDian = fanDian;
	}

	public BigDecimal getbFanDian() {
		return bFanDian;
	}

	public void setbFanDian(BigDecimal bFanDian) {
		this.bFanDian = bFanDian;
	}

	
}
