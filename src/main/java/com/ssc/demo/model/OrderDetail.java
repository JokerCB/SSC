package com.ssc.demo.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

import framework.generic.annotation.Column;
import framework.generic.model.PersistentModel;

/**
 * 订单明细
 */
public class OrderDetail   implements PersistentModel{

	private static final long serialVersionUID = -9218985453073185112L;

	/**
	 * 订单编号
	 * Order.orderId
	 */
	@Column(name = "ORDERID")
	private String orderId;
	
	/**
	 * 序号
	 */
	@Column(name = "SEQ")
	private int seq;
	
	/**
	 * 投注模式(digital:复式, input:单式)
	 */
	@Column(name = "TYPE")
	private String type;
	
	/**
	 * 玩法id,关联
	 * Played.id
	 */
	@Column(name = "PLAYID")
	private int playId;
	
	
	/**
	 * 投注号码
	 */
	@Column(name = "ACTIONDATA")
	private String actionData;
	
	/**
	 * 投注注数
	 */
	@Column(name = "ACTIONNUM")
	private int actionNum;
	
	/**
	 * 模式(1:元,2:角,3:分)
	 */
	@Column(name = "MODE")
	private int mode;
	
	/**
	 * 倍数
	 */
	@Column(name = "BEISHU")
	private int beiShu;
	
	/**
	 * 金额
	 */
	@Column(name = "ACTIONMONEY")
	private BigDecimal actionMoney;
	
	/**
	 * 返奖模式 (1-1850 2-1962)
	 */
	@Column(name = "OMODEL")
	private int omodel;
	
	/**
	 * 开奖号码，没开奖的留空串
	 */
	@Column(name = "LOTTERYNO")
	private String lotteryNo;
	
	/**
	 * 中奖注数
	 */
	@Column(name = "ZJCOUNT")
	private int zjCount;
	
	/**
	 * 中奖金额
	 */
	@Column(name = "BONUS")
	private BigDecimal bonus;
	
	/**
	 * 创建时间
	 */
	@Column(name = "CREATEDATE")
	private Date createDate;
	
	
	/***************前端显示数据用**********************/
	/*****订单记录展示用******/
	
	private Map map;

//	/**
//	 * 期号
//	 */
//	private String issue;
//	/**
//	 * 玩法
//	 */
//	private String playedName;
//	
//	/**
//	 * 用户
//	 */
//	private String mName;
//	
//	/**
//	 * 用户
//	 */
//	private String zhuiHaoId;
//	
//	/**
//	 * 用户
//	 */
//	private boolean zhuiHao;
//	
//	/**
//	 * 用户
//	 */
//	private boolean isStop;
	
	

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getPlayId() {
		return playId;
	}

	public void setPlayId(int playId) {
		this.playId = playId;
	}

	public String getActionData() {
		return actionData;
	}

	public void setActionData(String actionData) {
		this.actionData = actionData;
	}

	public int getActionNum() {
		return actionNum;
	}

	public void setActionNum(int actionNum) {
		this.actionNum = actionNum;
	}

	public int getMode() {
		return mode;
	}

	public void setMode(int mode) {
		this.mode = mode;
	}

	public int getBeiShu() {
		return beiShu;
	}

	public void setBeiShu(int beiShu) {
		this.beiShu = beiShu;
	}

	public BigDecimal getActionMoney() {
		return actionMoney;
	}

	public void setActionMoney(BigDecimal actionMoney) {
		this.actionMoney = actionMoney;
	}

	public int getOmodel() {
		return omodel;
	}

	public void setOmodel(int omodel) {
		this.omodel = omodel;
	}

	public String getLotteryNo() {
		return lotteryNo;
	}

	public void setLotteryNo(String lotteryNo) {
		this.lotteryNo = lotteryNo;
	}

	public int getZjCount() {
		return zjCount;
	}

	public void setZjCount(int zjCount) {
		this.zjCount = zjCount;
	}

	public BigDecimal getBonus() {
		return bonus;
	}

	public void setBonus(BigDecimal bonus) {
		this.bonus = bonus;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Map getMap() {
		return map;
	}

	public void setMap(Map map) {
		this.map = map;
	}
	
	
/**
	public String getIssue() {
		return issue;
	}

	public void setIssue(String issue) {
		this.issue = issue;
	}

	public String getPlayedName() {
		return playedName;
	}

	public void setPlayedName(String playedName) {
		this.playedName = playedName;
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public String getZhuiHaoId() {
		return zhuiHaoId;
	}

	public void setZhuiHaoId(String zhuiHaoId) {
		this.zhuiHaoId = zhuiHaoId;
	}

	public boolean getZhuiHao() {
		return zhuiHao;
	}

	public void setZhuiHao(boolean zhuiHao) {
		this.zhuiHao = zhuiHao;
	}

	public boolean getIsStop() {
		return isStop;
	}

	public void setIsStop(boolean isStop) {
		this.isStop = isStop;
	}
	**/
	
}
