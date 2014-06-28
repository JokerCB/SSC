package com.ssc.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssc.demo.model.Notice;

import framework.generic.dao.GenericDao;
import framework.generic.paginator.domain.PageBounds;
import framework.generic.paginator.domain.PageList;

/**
 * 公告
 * @author 
 *
 */
public interface NoticeDao   extends GenericDao<Notice, Integer> {

	Notice load(@Param("id")int id);
	
	List<Notice> findAll();
	
	/**
	 * 分页查询，必须是传递一个pagination
	 * 
	 * @param pagination
	 *            分页工具类
	 * @return pagination 分页工具类
	 */
	PageList<Notice> findByPage(Object parameters, PageBounds pageBounds);
	
	/**
	 * 根据主键删除一条记录
	 */
	Integer deleteByPk(@Param("id") Integer id);
	
}
