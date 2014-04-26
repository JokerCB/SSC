package com.ssc.demo.service;

import com.ssc.demo.model.MemberLevel;
import com.ssc.demo.web.ui.DataGrid;
import com.ssc.demo.web.ui.PageRequest;



public interface MemberLevelService {
	
	/**
	 * 获取DataGrid列表数据和总数
	 * @param pageRequest datagrid页面请求数据
	 * @return DataGrid
	 */
	DataGrid getDatagrid(PageRequest pageRequest);
	
	/**
	 * 创建一条数据库记录
	 * @param memberLevel
	 * @return 受影响的行数
	 */
	Integer create(MemberLevel memberLevel);

	/**
	 * 修改一条数据库记录
	 * @param memberLevel
	 * @return 受影响的行数
	 */
	Integer modify(MemberLevel memberLevel);

	/**
	 * 根据主键删除一条数据库记录
	 * @return 受影响的行数
	 */
	Integer remove(Byte id);
	
	/**
	 * 批量删除数据库记录
	 * @return 受影响的行数
	 */
	Integer removeAll(Byte... memberLevelIds);
	
	/**
	 * 根据主键查询一条数据库记录
	 * @return 实体类
	 */
	MemberLevel getByPk(Byte id);
	
	/**
	 * 查询一条数据库记录
	 * @return 实体类
	 */
	MemberLevel get(Byte id);
	
}
