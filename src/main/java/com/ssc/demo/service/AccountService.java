package com.ssc.demo.service;

import com.ssc.demo.model.Account;
import com.ssc.demo.web.ui.DataGrid;
import com.ssc.demo.web.ui.PageRequest;


public interface AccountService {
	
	/**
	 * 获取DataGrid列表数据和总数
	 * @param pageRequest datagrid页面请求数据
	 * @return DataGrid
	 */
	DataGrid getDatagrid(PageRequest pageRequest);
	
	/**
	 * 创建一条数据库记录
	 * @param account
	 * @return 受影响的行数
	 */
	Integer create(Account account);

	/**
	 * 修改一条数据库记录
	 * @param account
	 * @return 受影响的行数
	 */
	Integer modify(Account account);

	/**
	 * 根据主键删除一条数据库记录
	 * @return 受影响的行数
	 */
	Integer remove(Integer uid);
	
	/**
	 * 批量删除数据库记录
	 * @return 受影响的行数
	 */
	Integer removeAll(Integer... accountIds);
	
	/**
	 * 根据主键查询一条数据库记录
	 * @return 实体类
	 */
	Account getByPk(Integer uid);
	
	/**
	 * 查询一条数据库记录
	 * @return 实体类
	 */
	Account get(Integer uid);
	
}
