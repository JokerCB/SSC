package com.ssc.demo.model.common;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import framework.generic.annotation.Column;
import framework.generic.annotation.Table;
import framework.generic.model.PersistentModel;

@Table(name = "COM_HIGHQUERY")
public class HighQuery implements PersistentModel {

	private static final long serialVersionUID = -3196951792651009962L;

	@Column(name = "HIGH_QUERY_ID", pk = true)
	private Integer highQueryId;
	@Column(name = "USER_ID")
	private String userId;
	@Column(name = "CONDITIONS")
	private String conditions;
	@Column(name = "CONDITION_ALIAS")
	private String conditionAlias;
	@Column(name = "CONDITION_SORT")
	private String conditionSort;
	@Column(name = "CONDITION_SORT_ALIAS")
	private String conditionSortAlias;
	@Column(name = "CREATE_TIME", updatable = false)
	private Date createTime;

	public Integer getHighQueryId() {
		return highQueryId;
	}

	public void setHighQueryId(Integer highQueryId) {
		this.highQueryId = highQueryId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getConditions() {
		return conditions;
	}

	public void setConditions(String conditions) {
		this.conditions = conditions;
	}

	public String getConditionAlias() {
		return conditionAlias;
	}

	public void setConditionAlias(String conditionAlias) {
		this.conditionAlias = conditionAlias;
	}

	public String getConditionSort() {
		return conditionSort;
	}

	public void setConditionSort(String conditionSort) {
		this.conditionSort = conditionSort;
	}

	public String getConditionSortAlias() {
		return conditionSortAlias;
	}

	public void setConditionSortAlias(String conditionSortAlias) {
		this.conditionSortAlias = conditionSortAlias;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}
