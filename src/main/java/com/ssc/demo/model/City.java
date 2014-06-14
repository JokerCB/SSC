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
	private String fid;
	
	@Column(name = "FNAME")
	private String fname;
	
	/**
	 * Province.fid
	 */
	@Column(name = "FPROVINCEID")
	private String fprovinceid;
	
	public String getFid() {
		return this.fid;
	}
	
	public void setFid(String fid) {
		this.fid = fid;
	}
	
	public String getFname() {
		return this.fname;
	}
	
	public void setFname(String fname) {
		this.fname = fname;
	}
	
	public String getFprovinceid() {
		return this.fprovinceid;
	}
	
	public void setFprovinceid(String fprovinceid) {
		this.fprovinceid = fprovinceid;
	}
	
}
