package com.ssc.demo.service;

import java.math.BigDecimal;
import java.util.List;

import com.ssc.demo.model.City;
import com.ssc.demo.model.Members;
import com.ssc.demo.model.Province;
import com.ssc.demo.web.ui.PageRequest;

import framework.generic.paginator.domain.PageList;

public interface MembersService {
	
	/**
	 * 根据主键查询一条数据库记录
	 * @return 实体类
	 */
	public Members load(Integer uid);
	public Members load(String mname);
	public Members load(String mname,String mpassword);	
	
	
	public PageList<Members> findByPage(PageRequest pageRequest);
	
	/**
	 * 获取团队余额
	 * @param membersId
	 * @param money
	 * @return
	 */
	public BigDecimal getTotalMoney(String membersId,BigDecimal money);
	
	
	/**
	 * 创建一条数据库记录
	 * @param members
	 * @return 受影响的行数
	 */
	Integer addMembers(Members members);

	/**
	 * 修改一条数据库记录
	 * @param members
	 * @return 受影响的行数
	 */
	Integer modify(Members members);

	/**
	 * 根据主键删除一条数据库记录
	 * @return 受影响的行数
	 */
	Integer remove(Integer uid);
	
	/**
	 * 批量删除数据库记录
	 * @return 受影响的行数
	 */
	Integer removeAll(Integer... membersIds);
	
	/**
	 * 获取省份集合
	 */
	List<Province> getProvince();
	
	/**
	 * 获取城市
	 * @return
	 */
	List<City> getCity(String provinceId);
}
