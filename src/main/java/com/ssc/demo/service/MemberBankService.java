package com.ssc.demo.service;

import com.ssc.demo.model.MemberBank;
import com.ssc.demo.web.ui.DataGrid;
import com.ssc.demo.web.ui.PageRequest;


public interface MemberBankService {
	
	/**
	 * 获取DataGrid列表数据和总数
	 * @param pageRequest datagrid页面请求数据
	 * @return DataGrid
	 */
	DataGrid getDatagrid(PageRequest pageRequest);
	
	/**
	 * 创建一条数据库记录
	 * @param memberBank
	 * @return 受影响的行数
	 */
	Integer create(MemberBank memberBank);

	/**
	 * 修改一条数据库记录
	 * @param memberBank
	 * @return 受影响的行数
	 */
	Integer modify(MemberBank memberBank);

	/**
	 * 根据主键删除一条数据库记录
	 * @return 受影响的行数
	 */
	Integer remove(Integer id);
	
	/**
	 * 批量删除数据库记录
	 * @return 受影响的行数
	 */
	Integer removeAll(Integer... memberBankIds);
	
	/**
	 * 根据主键查询一条数据库记录
	 * @return 实体类
	 */
	MemberBank getByPk(Integer id);
	
	/**
	 * 查询一条数据库记录
	 * @return 实体类
	 */
	MemberBank get(Integer id);
	
}
