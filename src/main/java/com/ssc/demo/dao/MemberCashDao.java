package com.ssc.demo.dao;

import org.apache.ibatis.annotations.Param;

import com.ssc.demo.model.MemberCash;

import framework.generic.dao.GenericDao;

public interface MemberCashDao extends GenericDao<MemberCash, Integer> {

	/**
	 * 根据主键查询一条记录
	 */
	MemberCash findByPk(@Param("id") Integer id);

	/**
	 * 根据主键删除一条记录
	 */
	Integer deleteByPk(@Param("id") Integer id);
}
