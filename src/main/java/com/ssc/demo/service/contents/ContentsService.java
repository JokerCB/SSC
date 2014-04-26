package com.ssc.demo.service.contents;

import com.ssc.demo.model.contents.Contents;

import com.ssc.demo.web.ui.DataGrid;
import com.ssc.demo.web.ui.PageRequest;

public interface ContentsService {
	
	/**
	 * 获取DataGrid列表数据和总数
	 * @param pageRequest datagrid页面请求数据
	 * @return DataGrid
	 */
	DataGrid getDatagrid(PageRequest pageRequest);
	
	/**
	 * 创建一条数据库记录
	 * @param contents
	 * @return 受影响的行数
	 */
	Integer create(Contents contents);

	/**
	 * 修改一条数据库记录
	 * @param contents
	 * @return 受影响的行数
	 */
	Integer modify(Contents contents);

	/**
	 * 根据主键删除一条数据库记录
	 * @return 受影响的行数
	 */
	Integer remove(String contentsId);
	
	/**
	 * 批量删除数据库记录
	 * @return 受影响的行数
	 */
	Integer removeAll(String... contentsIds);
	
	/**
	 * 根据主键查询一条数据库记录
	 * @return 实体类
	 */
	Contents getByPk(String contentsId);
	
	/**
	 * 查询一条数据库记录
	 * @return 实体类
	 */
	Contents get(String contentsId);
	
}
