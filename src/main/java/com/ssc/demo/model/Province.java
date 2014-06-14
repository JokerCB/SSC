package com.ssc.demo.model;

import framework.generic.annotation.Column;
import framework.generic.annotation.Table;
import framework.generic.model.PersistentModel;

/**
 * 省份
 *
 */
@Table(name = "ssc_bas_province")
public class Province implements PersistentModel {
	
	@Column(name = "FID", pk = true, order = 0)
	private String fid;
	@Column(name = "FNAME")
	private String fname;
	
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
	
}
