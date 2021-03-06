package com.ssc.demo.service;

import com.ssc.demo.model.MemberSession;
import com.ssc.demo.web.ui.DataGrid;
import com.ssc.demo.web.ui.PageRequest;

public interface MemberSessionService {
	
	/**
	 * 获取DataGrid列表数据和总数
	 * @param pageRequest datagrid页面请求数据
	 * @return DataGrid
	 */
	DataGrid getDatagrid(PageRequest pageRequest);
	
	/**
	 * 创建一条数据库记录
	 * @param memberSession
	 * @return 受影响的行数
	 */
	Integer create(MemberSession memberSession);

	/**
	 * 修改一条数据库记录
	 * @param memberSession
	 * @return 受影响的行数
	 */
	Integer modify(MemberSession memberSession);

	/**
	 * 根据主键删除一条数据库记录
	 * @return 受影响的行数
	 */
	Integer remove(Integer id);
	
	/**
	 * 批量删除数据库记录
	 * @return 受影响的行数
	 */
	Integer removeAll(Integer... memberSessionIds);
	
	/**
	 * 根据主键查询一条数据库记录
	 * @return 实体类
	 */
	MemberSession getByPk(Integer id);
	
	/**
	 * 查询一条数据库记录
	 * @return 实体类
	 */
	MemberSession get(Integer id);
	
}
