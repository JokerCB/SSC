package com.ssc.demo.dao;

import org.apache.ibatis.annotations.Param;

import com.ssc.demo.model.Members;

import framework.generic.dao.GenericDao;

public interface MembersDao extends GenericDao<Members, Integer> {

	/**
	 * 根据主键查询一条记录
	 */

//	Members load(@Param("mid") Integer mid);
//	Members load(@Param("mname") String mname);
//	Members load(@Param("mname") String mname,@Param("mpassword") String mpassword);	
	Members load(@Param("mid") Integer mid, @Param("mname") String mname,@Param("mpassword") String mpassword);

	/**
	 * 根据主键删除一条记录
	 */
	Integer deleteByPk(@Param("mid") Integer mid);
}
