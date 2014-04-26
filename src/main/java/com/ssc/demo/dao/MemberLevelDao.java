package com.ssc.demo.dao;

import org.apache.ibatis.annotations.Param;

import com.ssc.demo.model.MemberLevel;

import framework.generic.dao.GenericDao;

public interface MemberLevelDao extends GenericDao<MemberLevel, Byte> {

	/**
	 * 根据主键查询一条记录
	 */
	MemberLevel findByPk(@Param("id") Byte id);

	/**
	 * 根据主键删除一条记录
	 */
	Integer deleteByPk(@Param("id") Byte id);
}
