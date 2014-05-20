package com.ssc.demo.model;

import framework.generic.annotation.Column;
import framework.generic.annotation.Table;
import framework.generic.model.PersistentModel;

/**
 * 顶部菜单栏
 * @author 
 */
@Table(name = "SSC_MENU_LIST")
public class Menu  implements PersistentModel{

	private static final long serialVersionUID = -9218985453073185112L;

	@Column(name = "ID", pk = true)
	private String id;
	
	@Column(name = "TYPE")
	private int type;
	
	@Column(name = "NAME")
	private String name;
	

	@Column(name = "CODE")
	private String code;
	
	@Column(name = "URL")
	private String url;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
}
