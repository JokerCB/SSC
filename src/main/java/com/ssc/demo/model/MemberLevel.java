package com.ssc.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import framework.generic.annotation.Column;
import framework.generic.annotation.Table;
import framework.generic.model.PersistentModel;

/**
 * 用户等级设置
 */
@Table(name = "ssc_member_level")
public class MemberLevel implements PersistentModel {
	
	@Column(name = "id", pk = true, order = 0)
	private Byte id;
	@Column(name = "level")
	private Byte level;
	@Column(name = "levelName")
	private String levelname;
	@Column(name = "minScore")
	private Integer minscore;
	@Column(name = "maxToCashCount")
	private Byte maxtocashcount;
	
	public Byte getId() {
		return this.id;
	}
	
	public void setId(Byte id) {
		this.id = id;
	}
	
	public Byte getLevel() {
		return this.level;
	}
	
	public void setLevel(Byte level) {
		this.level = level;
	}
	
	public String getLevelname() {
		return this.levelname;
	}
	
	public void setLevelname(String levelname) {
		this.levelname = levelname;
	}
	
	public Integer getMinscore() {
		return this.minscore;
	}
	
	public void setMinscore(Integer minscore) {
		this.minscore = minscore;
	}
	
	public Byte getMaxtocashcount() {
		return this.maxtocashcount;
	}
	
	public void setMaxtocashcount(Byte maxtocashcount) {
		this.maxtocashcount = maxtocashcount;
	}
	
}
