package com.ssc.demo.model;

import java.math.BigDecimal;
import java.util.Date;

import framework.generic.annotation.Column;
import framework.generic.model.PersistentModel;

/**
 * 资金变动明细
 */
public class CoinLog  implements PersistentModel{

	private static final long serialVersionUID = -9218985453073185112L;

	@Column(name = "ID", pk = true)
	private int id;
	
	/**
	 * 订单编号
	 */
	@Column(name = "ORDERID")
	private String orderId;
	
	/**
	 * 用户ID
	 * Members.uid
	 */
	@Column(name = "UID")
	private Integer uid;
	
	
	/**
	 * 彩种
	 * Type.type
	 */
	@Column(name = "TYPE")
	private int type;	
	
	/**
	 * 玩法
	 */
	@Column(name = "PLAYEDID")
	private int playedId;
	
	/**
	 * 变动资金
	 */
	@Column(name = "COIN")
	private BigDecimal coin;
	
	
	/**
	 * 账户余额
	 */
	@Column(name = "USERCOIN")
	private BigDecimal userCoin;
	
	/**
	 * 资金变动类型(1充值，2返点，3提现失败从冻结资金返回，4撤单资金，5中奖派奖... ，101提现，102投注，103提现资金冻结，104开奖扣除冻结资金...)
	 */
	@Column(name = "LIQTYPE")
	private int liqType;

	@Column(name = "ACTIONIP")
	private String actionIP;
	
	/**
	 * 备注
	 */
	@Column(name = "INFO")
	private String info;
	
	/**
	 * 
	 */
	@Column(name = "CREATEDATE")
	private Date createDate;

	public String getOrderId() {
		return orderId;
	}


	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}


	public Integer getUid() {
		return uid;
	}


	public void setUid(Integer uid) {
		this.uid = uid;
	}


	public int getType() {
		return type;
	}


	public void setType(int type) {
		this.type = type;
	}

	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getPlayedId() {
		return playedId;
	}


	public void setPlayedId(int playedId) {
		this.playedId = playedId;
	}


	public BigDecimal getCoin() {
		return coin;
	}


	public void setCoin(BigDecimal coin) {
		this.coin = coin;
	}


	public BigDecimal getUserCoin() {
		return userCoin;
	}


	public void setUserCoin(BigDecimal userCoin) {
		this.userCoin = userCoin;
	}


	public int getLiqType() {
		return liqType;
	}


	public void setLiqType(int liqType) {
		this.liqType = liqType;
	}


	public String getActionIP() {
		return actionIP;
	}


	public void setActionIP(String actionIP) {
		this.actionIP = actionIP;
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
