package com.ssc.demo.model;


import framework.generic.annotation.Column;
import framework.generic.annotation.Table;
import framework.generic.model.PersistentModel;

/**
 * 城市
 */
@Table(name = "ssc_bas_city")
public class City implements PersistentModel {
	
	@Column(name = "FID", pk = true, order = 0)
	private String id;
	
	@Column(name = "FNAME")
	private String name;
	
	/**
	 * Province.fid
	 */
	@Column(name = "FPROVINCEID")
	private String fprovinceid;
	
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFprovinceid() {
		return this.fprovinceid;
	}
	
	public void setFprovinceid(String fprovinceid) {
		this.fprovinceid = fprovinceid;
	}
	
}
