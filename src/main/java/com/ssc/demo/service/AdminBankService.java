package com.ssc.demo.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.ssc.demo.model.AdminBank;
import com.ssc.demo.model.Bank;
import com.ssc.demo.model.City;
import com.ssc.demo.model.Province;
import com.ssc.demo.web.ui.DataGrid;
import com.ssc.demo.web.ui.PageRequest;

import framework.generic.paginator.domain.PageList;

public interface AdminBankService {
	
	/**
	 * 获取DataGrid列表数据和总数
	 * @param pageRequest datagrid页面请求数据
	 * @return DataGrid
	 */
	DataGrid getDatagrid(PageRequest pageRequest);
	
	/**
	 * 创建一条数据库记录
	 * @param adminBank
	 * @return 受影响的行数
	 */
	Integer create(AdminBank adminBank);

	/**
	 * 修改一条数据库记录
	 * @param adminBank
	 * @return 受影响的行数
	 */
	Integer modify(AdminBank adminBank);

	/**
	 * 根据主键删除一条数据库记录
	 * @return 受影响的行数
	 */
	Integer remove(Integer id);
	
	/**
	 * 批量删除数据库记录
	 * @return 受影响的行数
	 */
	Integer removeAll(Integer... adminBankIds);
	
	/**
	 * 根据主键查询一条数据库记录
	 * @return 实体类
	 */
	AdminBank getByPk(Integer id);
	
	/**
	 * 查询一条数据库记录
	 * @return 实体类
	 */
	AdminBank get(Integer id);

	List<Bank> findList();
	
	List<Province> findProvinces();
	List<City> findCitys(String fprovinceid);
	public PageList<Map> findDataByPage(PageRequest pageRequest);	
	
	Integer deleteByPk( Integer id);
	
	Integer findUnique(Integer id,String userName, Integer bankId, String account);
	
}
