package com.ssc.demo.dao;

import org.apache.ibatis.annotations.Param;



import com.ssc.demo.model.Account;

import framework.generic.dao.GenericDao;

public interface AccountDao extends GenericDao<Account, Integer> {

	/**
	 * 根据主键查询一条记录
	 */
	Account findByPk(@Param("uid") Integer uid);

	/**
	 * 根据主键删除一条记录
	 */
	Integer deleteByPk(@Param("uid") Integer uid);
}
