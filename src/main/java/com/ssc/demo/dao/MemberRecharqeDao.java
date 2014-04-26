package com.ssc.demo.dao;

import org.apache.ibatis.annotations.Param;

import com.ssc.demo.model.MemberRecharqe;

import framework.generic.dao.GenericDao;

public interface MemberRecharqeDao extends GenericDao<MemberRecharqe, Integer> {

	/**
	 * 根据主键查询一条记录
	 */
	MemberRecharqe findByPk(@Param("id") Integer id);

	/**
	 * 根据主键删除一条记录
	 */
	Integer deleteByPk(@Param("id") Integer id);
}
