package com.ssc.demo.model.contents;

import java.util.List;

import framework.generic.annotation.Column;
import framework.generic.annotation.Table;
import framework.generic.model.PersistentModel;

@Table(name = "T_CONTENTS")
public class Contents implements PersistentModel {
	
	/**
	 * 内容ID
	 */
	@Column(name = "CONTENTS_ID", pk = true)
	private String contentsId;
	/**
	 * 标题
	 */
	@Column(name = "TITLE")
	private String title;
	/**
	 * 描述
	 */
	@Column(name = "DESCRIBES")
	private String describes;
	
	
	public String getContentsId() {
		return this.contentsId;
	}
	
	public void setContentsId(String contentsId) {
		this.contentsId = contentsId;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getDescribes() {
		return this.describes;
	}
	
	public void setDescribes(String describes) {
		this.describes = describes;
	}
	
}
