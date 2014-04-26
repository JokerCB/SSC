package com.ssc.demo.model;

import framework.generic.annotation.Column;
import framework.generic.annotation.Table;
import framework.generic.model.PersistentModel;

@Table(name = "SSC_TYPE")
public class Type  implements PersistentModel{

	private static final long serialVersionUID = -9218985453073185112L;

	@Column(name = "ID", pk = true)
	private int id;
	
	@Column(name = "TYPE")
	private int type;
	
	@Column(name = "NAME")
	private String name;
	
	/*
	 * 彩票可选号码列表，用半角逗号分隔
	 */
	@Column(name = "CODE_LIST")
	private String codeList;
	
	@Column(name = "TITLE")
	private String title;
	
	@Column(name = "SHORT_NAME")
	private String shortName;
	
	@Column(name = "INFO")
	private String info;
	
	/**
	 * 请求当前期号时后置事件函数
	 */
	@Column(name = "ON_GET_NODE")
	private String onGetNoed;
	
	/**
	 * 开奖前停止下注时间
	 */
	@Column(name = "DATA_FOR_TIME")
	private int dataForTime;
	
	/**
	 * 默认显示哪个玩法组
	 */
	@Column(name = "DEFAULT_VIEW_GROUP")
	private int defaultViewGroup;

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public String getCodeList() {
		return codeList;
	}

	public void setCodeList(String codeList) {
		this.codeList = codeList;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getOnGetNoed() {
		return onGetNoed;
	}

	public void setOnGetNoed(String onGetNoed) {
		this.onGetNoed = onGetNoed;
	}

	public int getDataForTime() {
		return dataForTime;
	}

	public void setDataForTime(int dataForTime) {
		this.dataForTime = dataForTime;
	}

	public int getDefaultViewGroup() {
		return defaultViewGroup;
	}

	public void setDefaultViewGroup(int defaultViewGroup) {
		this.defaultViewGroup = defaultViewGroup;
	}
	
	
}
