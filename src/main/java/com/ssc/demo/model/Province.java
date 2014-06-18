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
	private String id;
	@Column(name = "FNAME")
	private String name;
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
	
	
	
}
