package com.ssc.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssc.demo.model.Bank;

/**
 * 银行信息-Dao层
 */
public interface BankDao{

	/**
	 * 根据主键查询一条记录
	 */
	Bank findByPk(@Param("id") int id);

	/**
	 * 根据主键删除一条记录
	 */
	Integer deleteByPk(@Param("id") Byte id);
	
	List<Bank> findList();

	List<Bank> findByIsMember();
}
