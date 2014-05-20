package com.ssc.demo.model;

import java.math.BigDecimal;

import framework.generic.annotation.Column;
import framework.generic.annotation.Table;
import framework.generic.model.PersistentModel;

/**
 * 所有玩法
 * @author danny.zhang
 */
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
	
	
	@Column(name = "KEY")
	private String key;
	
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
	
	/**
	 * 计算奖金基数  例如:(max-min)/base = 5.6
	 */
	@Column(name = "BONUS_BASE")
	private BigDecimal bonusBase;
	
	
	@Column(name = "LT_NUM")
	private String ltNum;
	
	/**
	 * 每注选几个号码
	 */
	@Column(name = "SELECT_NUM")
	private int selectNum;	
	
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

	
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
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

	public BigDecimal getBonusBase() {
		return bonusBase;
	}

	public void setBonusBase(BigDecimal bonusBase) {
		this.bonusBase = bonusBase;
	}	
	
}
