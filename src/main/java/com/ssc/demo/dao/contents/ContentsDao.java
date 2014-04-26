package com.ssc.demo.dao.contents;

import org.apache.ibatis.annotations.Param;

import com.ssc.demo.model.contents.Contents;

import framework.generic.dao.GenericDao;

public interface ContentsDao extends GenericDao<Contents, String> {

	/**
	 * 根据主键查询一条记录
	 */
	Contents findByPk(@Param("contentsId") String contentsId);

	/**
	 * 根据主键删除一条记录
	 */
	Integer deleteByPk(@Param("contentsId") String contentsId);
}
