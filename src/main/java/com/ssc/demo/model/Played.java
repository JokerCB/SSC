package com.ssc.demo.model;

import java.math.BigDecimal;

import framework.generic.annotation.Column;
import framework.generic.annotation.Table;
import framework.generic.model.PersistentModel;

@Table(name = "SSC_PLAYED")
public class Played  implements PersistentModel{

	private static final long serialVersionUID = -9218985453073185112L;

	@Column(name = "ID", pk = true)
	private int id;
	
	/**
	 * 彩种
	 * Type.type
	 */
	@Column(name = "TYPE")
	private int type;
	
	@Column(name = "NAME")
	private String name;
	
	/**
	 * 最高赔率
	 */
	@Column(name = "BONUS_PROP_MAX")
	private BigDecimal bonusPropMax;
	
	/**
	 * 最低赔率
	 */
	@Column(name = "BONUS_PROP_MIN")
	private BigDecimal bonusPropMin;
	
	
	@Column(name = "LT_NUM")
	private String ltNum;
	
	/**
	 * 每注选几个号码
	 */
	@Column(name = "SELECT_NUM")
	private int selectNum;
	
	/**
	 * 玩法组
	 * SscPlayedGroup.id
	 */
	@Column(name = "GROUP_ID")
	private int groupId;
	
	
	/**
	 * 玩法说明
	 */
	@Column(name = "INFO")
	private String info;
	
	
	/**
	 * 中奖举例
	 */
	@Column(name = "EXAMPLE")
	private String example;
	
	
	/**
	 * 中奖规则函数
	 */
	@Column(name = "RULE_FUN")
	private String ruleFun;
	

	@Column(name = "BET_COUNT_FUN")
	private String betCountFun;
	
	/**
	 * 最大中奖号码计算函数
	 */
	@Column(name = "ZJ_MAX")
	private String zj_max;
	
	/**
	 * 玩法页面模板
	 */
	@Column(name = "PLAYED_TPL")
	private String played_tpl;
	
	
	

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

	public BigDecimal getBonusPropMax() {
		return bonusPropMax;
	}

	public void setBonusPropMax(BigDecimal bonusPropMax) {
		this.bonusPropMax = bonusPropMax;
	}

	public BigDecimal getBonusPropMin() {
		return bonusPropMin;
	}

	public void setBonusPropMin(BigDecimal bonusPropMin) {
		this.bonusPropMin = bonusPropMin;
	}

	public String getLtNum() {
		return ltNum;
	}

	public void setLtNum(String ltNum) {
		this.ltNum = ltNum;
	}

	public int getSelectNum() {
		return selectNum;
	}

	public void setSelectNum(int selectNum) {
		this.selectNum = selectNum;
	}

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getExample() {
		return example;
	}

	public void setExample(String example) {
		this.example = example;
	}

	public String getRuleFun() {
		return ruleFun;
	}

	public void setRuleFun(String ruleFun) {
		this.ruleFun = ruleFun;
	}

	public String getBetCountFun() {
		return betCountFun;
	}

	public void setBetCountFun(String betCountFun) {
		this.betCountFun = betCountFun;
	}

	public String getZj_max() {
		return zj_max;
	}

	public void setZj_max(String zj_max) {
		this.zj_max = zj_max;
	}

	public String getPlayed_tpl() {
		return played_tpl;
	}

	public void setPlayed_tpl(String played_tpl) {
		this.played_tpl = played_tpl;
	}
	
	
}
