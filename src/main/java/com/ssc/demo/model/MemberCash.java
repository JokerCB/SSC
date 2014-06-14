package com.ssc.demo.model;

import java.math.BigDecimal;
import java.util.Date;

import framework.generic.annotation.Column;
import framework.generic.annotation.Table;
import framework.generic.model.PersistentModel;

/**
 * 用户提现表
 */
@Table(name = "ssc_member_cash")
public class MemberCash implements PersistentModel {
	
	@Column(name = "id", pk = true, order = 0)
	private Integer id;
	/**
	 * 用户ID
	 */
	@Column(name = "uid")
	private Integer uid;
	
	/**
	 * 编号
	 */
	@Column(name = "cashNo")
	private String cashNo;

	/**
	 * 提现金额
	 */
	@Column(name = "amount")
	private BigDecimal amount;
	/**
	 * 银行ID
	 * MemberBank.id
	 */
	@Column(name = "membersBankId")
	private Integer membersBankId;
	
	/**
	 * 提现状态：1用户申请，2已取消，3已支付，4提现失败，0确认到帐, 5后台删除
	 */
	@Column(name = "state")
	private int state;
	
	@Column(name = "isDelete")
	private Boolean isDelete;
	/**
	 * 备注字段
	 */
	@Column(name = "info")
	private String info;
	
	/**
	 * 创建日期
	 */
	@Column(name = "createDate")
	private Date createDate;
	
	public Integer getId() {
		return this.id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getUid() {
		return this.uid;
	}
	
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	
	public String getCashNo() {
		return cashNo;
	}

	public void setCashNo(String cashNo) {
		this.cashNo = cashNo;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Integer getMembersBankId() {
		return membersBankId;
	}

	public void setMembersBankId(Integer membersBankId) {
		this.membersBankId = membersBankId;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public Boolean isDelete() {
		return isDelete;
	}

	public Boolean getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	
}
