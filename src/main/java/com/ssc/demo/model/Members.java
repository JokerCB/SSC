package com.ssc.demo.model;

import java.math.BigDecimal;

import framework.generic.annotation.Column;
import framework.generic.annotation.Table;
import framework.generic.model.PersistentModel;

@Table(name = "ssc_members")
public class Members implements PersistentModel {
	
	private static final long serialVersionUID = -9218985453073185112L;
	
	/**
	 * 用户ID
	 */
	@Column(name = "uid", pk = true, order = 0)
	private Integer uid;
	/**
	 * 会员真实姓名
	 */
	@Column(name = "m_name")
	private String mname;
	
	/**
	 * 会员密码
	 */
	@Column(name = "m_password")
	private String mpassword;
	
	/**
	 * 是否代理：0会员，1代理
	 */
	@Column(name = "m_type")
	private Boolean mtype;
	/**
	 * 会员人数配额
	 */
	@Column(name = "m_subCount")
	private Integer msubcount;
	/**
	 * 是否vip（1-是，0-否）
	 */
	@Column(name = "is_vip")
	private Boolean isVip;
	/**
	 * 会员上级ID
	 */
	@Column(name = "m_parentId")
	private Integer mparentid;
	/**
	 * 会员QQ
	 */
	@Column(name = "m_qq")
	private String mqq;
	/**
	 * 会员msn
	 */
	@Column(name = "m_msn")
	private String mmsn;
	/**
	 * 会员邮箱
	 */
	@Column(name = "m_email")
	private String memail;
	/**
	 * 会员性别：0男，1女
	 */
	@Column(name = "m_sex")
	private Boolean msex;
	/**
	 * 会员身份证ID
	 */
	@Column(name = "m_cardid")
	private String mcardid;
	/**
	 * 会员等级
	 */
	@Column(name = "m_grade")
	private int mgrade;
	/**
	 * 会员积分
	 */
	@Column(name = "m_score")
	private Integer mscore;
	/**
	 * 会员累计积分
	 */
	@Column(name = "m_scoreTotal")
	private Integer mscoretotal;
	/**
	 * 会员个人财产
	 */
	@Column(name = "m_coin")
	private BigDecimal mcoin;
	/**
	 * 会员冻结财产
	 */
	@Column(name = "m_fcoin")
	private BigDecimal mfcoin;
	/**
	 * 会员设置的返点数
	 */
	@Column(name = "m_fanDian")
	private BigDecimal mfandian;
	/**
	 * 会员不定位返点
	 */
	@Column(name = "m_fanDianBdw")
	private BigDecimal mfandianbdw;
	/**
	 * 会员交易密码，请区别于登录密码
	 */
	@Column(name = "m_safepwd")
	private String msafepwd;
	/**
	 * 会员密保邮箱，与邮箱分开
	 */
	@Column(name = "m_safeEmail")
	private String msafeemail;
	/**
	 * 会员省份
	 */
	@Column(name = "m_province")
	private String mprovince;
	/**
	 * 会员城市
	 */
	@Column(name = "m_city")
	private String mcity;
	/**
	 * 会员地址
	 */
	@Column(name = "m_address")
	private String maddress;
	/**
	 * 创建人
	 */
	@Column(name = "create_name")
	private String createName;
	/**
	 * 创建时间
	 */
	@Column(name = "create_date")
	private java.sql.Timestamp createDate;
	/**
	 * 修改人
	 */
	@Column(name = "modify_name")
	private String modifyName;
	/**
	 * 修改时间
	 */
	@Column(name = "modify_date")
	private java.sql.Timestamp modifyDate;
	
	public Integer getUid() {
		return this.uid;
	}
	
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	
	public String getMname() {
		return this.mname;
	}
	
	public void setMname(String mname) {
		this.mname = mname;
	}
	
	
	public String getMpassword() {
		return mpassword;
	}

	public void setMpassword(String mpassword) {
		this.mpassword = mpassword;
	}

	public Boolean getMtype() {
		return this.mtype;
	}
	
	public void setMtype(Boolean mtype) {
		this.mtype = mtype;
	}
	
	public Integer getMsubcount() {
		return this.msubcount;
	}
	
	public void setMsubcount(Integer msubcount) {
		this.msubcount = msubcount;
	}
	
	public Boolean getIsVip() {
		return this.isVip;
	}
	
	public void setIsVip(Boolean isVip) {
		this.isVip = isVip;
	}
	
	public Integer getMparentid() {
		return this.mparentid;
	}
	
	public void setMparentid(Integer mparentid) {
		this.mparentid = mparentid;
	}
	
	public String getMqq() {
		return this.mqq;
	}
	
	public void setMqq(String mqq) {
		this.mqq = mqq;
	}
	
	public String getMmsn() {
		return this.mmsn;
	}
	
	public void setMmsn(String mmsn) {
		this.mmsn = mmsn;
	}
	
	public String getMemail() {
		return this.memail;
	}
	
	public void setMemail(String memail) {
		this.memail = memail;
	}
	
	public Boolean getMsex() {
		return this.msex;
	}
	
	public void setMsex(Boolean msex) {
		this.msex = msex;
	}
	
	public String getMcardid() {
		return this.mcardid;
	}
	
	public void setMcardid(String mcardid) {
		this.mcardid = mcardid;
	}
	
	public int getMgrade() {
		return this.mgrade;
	}
	
	public void setMgrade(int mgrade) {
		this.mgrade = mgrade;
	}
	
	public Integer getMscore() {
		return this.mscore;
	}
	
	public void setMscore(Integer mscore) {
		this.mscore = mscore;
	}
	
	public Integer getMscoretotal() {
		return this.mscoretotal;
	}
	
	public void setMscoretotal(Integer mscoretotal) {
		this.mscoretotal = mscoretotal;
	}
	
	public BigDecimal getMcoin() {
		return this.mcoin;
	}
	
	public void setMcoin(BigDecimal mcoin) {
		this.mcoin = mcoin;
	}
	
	public BigDecimal getMfcoin() {
		return this.mfcoin;
	}
	
	public void setMfcoin(BigDecimal mfcoin) {
		this.mfcoin = mfcoin;
	}
	
	public BigDecimal getMfandian() {
		return this.mfandian;
	}
	
	public void setMfandian(BigDecimal mfandian) {
		this.mfandian = mfandian;
	}
	
	public BigDecimal getMfandianbdw() {
		return this.mfandianbdw;
	}
	
	public void setMfandianbdw(BigDecimal mfandianbdw) {
		this.mfandianbdw = mfandianbdw;
	}
	
	public String getMsafepwd() {
		return this.msafepwd;
	}
	
	public void setMsafepwd(String msafepwd) {
		this.msafepwd = msafepwd;
	}
	
	public String getMsafeemail() {
		return this.msafeemail;
	}
	
	public void setMsafeemail(String msafeemail) {
		this.msafeemail = msafeemail;
	}
	
	public String getMprovince() {
		return this.mprovince;
	}
	
	public void setMprovince(String mprovince) {
		this.mprovince = mprovince;
	}
	
	public String getMcity() {
		return this.mcity;
	}
	
	public void setMcity(String mcity) {
		this.mcity = mcity;
	}
	
	public String getMaddress() {
		return this.maddress;
	}
	
	public void setMaddress(String maddress) {
		this.maddress = maddress;
	}
	
	public String getCreateName() {
		return this.createName;
	}
	
	public void setCreateName(String createName) {
		this.createName = createName;
	}
	
	public java.sql.Timestamp getCreateDate() {
		return this.createDate;
	}
	
	public void setCreateDate(java.sql.Timestamp createDate) {
		this.createDate = createDate;
	}
	
	public String getModifyName() {
		return this.modifyName;
	}
	
	public void setModifyName(String modifyName) {
		this.modifyName = modifyName;
	}
	
	public java.sql.Timestamp getModifyDate() {
		return this.modifyDate;
	}
	
	public void setModifyDate(java.sql.Timestamp modifyDate) {
		this.modifyDate = modifyDate;
	}
	
}
