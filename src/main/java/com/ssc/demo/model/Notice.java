package com.ssc.demo.model;

import java.util.Date;

import framework.generic.annotation.Column;
import framework.generic.model.PersistentModel;

/**
 * 公告
 * @author
 *
 */
public class Notice implements PersistentModel{

	private static final long serialVersionUID = -9218985453073185112L;
	
	@Column(name = "ID", pk = true)
	private int id;
	
	/**
	 * 公告内容
	 */
	@Column(name = "content")
	private String content;
	
	/**
	 *是否显示
	 */
	@Column(name = "visible")
	private Boolean visible;
	
	
	/**
	 * 
	 */
	@Column(name = "CREATEDATE")
	private Date createDate;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}

	public Boolean getVisible() {
		return visible;
	}


	public void setVisible(Boolean visible) {
		this.visible = visible;
	}


	public Date getCreateDate() {
		return createDate;
	}


	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	
}
