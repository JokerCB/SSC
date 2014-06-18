package com.ssc.demo.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.ssc.demo.model.AdminBank;

import framework.generic.dao.GenericDao;
import framework.generic.paginator.domain.PageBounds;
import framework.generic.paginator.domain.PageList;

public interface AdminBankDao  extends GenericDao<AdminBank, Integer> {

	/**
	 * 根据主键查询一条记录
	 */
	AdminBank findByPk(@Param("id") Integer id);

	/**
	 * 根据主键删除一条记录
	 */
	Integer deleteByPk(@Param("id") Integer id);
	PageList<Map> findDataByPage(Object parameters, PageBounds pageBounds);
	
	Integer findUnique(@Param("id") Integer id,@Param("username") String userName,@Param("bankid") Integer bankId,@Param("account") String account);
	
	List<Map> findAdminBanks();
}
