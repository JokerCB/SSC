package com.ssc.demo.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import framework.generic.annotation.Column;
import framework.generic.model.PersistentModel;

/**
 * 银行字典
 */
public class Bank  implements PersistentModel{

	private static final long serialVersionUID = -9218985453073185112L;

	@Column(name = "ID", pk = true)
	private int id;
	
	/**
	 * 银行名称
	 */
	@Column(name = "name")
	private String name;
	
	
	/**
	 * Logo
	 */
	@Column(name = "logo")
	private String logo;	
	
	/**
	 * 银行地址
	 */
	@Column(name = "home")
	private String home;
	
	/**
	 * 排序
	 */
	@Column(name = "sort")
	private int sort;
	
	
	/**
	 * 
	 */
	@Column(name = "isDelete")
	private Boolean isDelete;
	
	
	/**
	 *玩家是否可见
	 */
	@Column(name = "isMember")
	private Boolean isMember;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getLogo() {
		return logo;
	}


	public void setLogo(String logo) {
		this.logo = logo;
	}


	public String getHome() {
		return home;
	}


	public void setHome(String home) {
		this.home = home;
	}


	public int getSort() {
		return sort;
	}


	public void setSort(int sort) {
		this.sort = sort;
	}

	public boolean isDelete() {
		return isDelete;
	}

	public Boolean getIsDelete() {
		return isDelete;
	}


	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	public boolean isMember() {
		return isMember;
	}

	public Boolean getIsMember() {
		return isMember;
	}


	public void setIsMember(Boolean isMember) {
		this.isMember = isMember;
	}
	

	
	
}
