package com.ssc.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssc.demo.model.MemberBank;

import framework.generic.dao.GenericDao;

public interface MemberBankDao extends GenericDao<MemberBank, Integer> {

	/**
	 * 根据用户ID查询记录
	 * @param uid
	 */
	List<MemberBank> findByUid(@Param("uid") Integer uid);

	/**
	 * 根据主键删除一条记录
	 */
	Integer deleteByPk(@Param("id") Integer id);
}
