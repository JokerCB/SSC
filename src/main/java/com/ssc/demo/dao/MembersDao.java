package com.ssc.demo.dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.ssc.demo.model.Members;

import framework.generic.dao.GenericDao;
import framework.generic.paginator.domain.PageBounds;
import framework.generic.paginator.domain.PageList;

public interface MembersDao extends GenericDao<Members, Integer> {

	/**
	 * 根据主键查询一条记录
	 */

//	Members load(@Param("mid") Integer mid);
//	Members load(@Param("mname") String mname);
//	Members load(@Param("mname") String mname,@Param("mpassword") String mpassword);	
	Members load(@Param("uid") Integer uid, @Param("mname") String mname,@Param("mpassword") String mpassword);

	/**
	 * 根据主键删除一条记录
	 */
	Integer deleteByPk(@Param("uid") Integer uid);
	
	/**
	 * 分页查询，必须是传递一个pagination
	 * 
	 * @param pagination
	 *            分页工具类
	 * @return pagination 分页工具类
	 */
	PageList<Members> findByPage(Object parameters, PageBounds pageBounds);
	
	/**
	 * 更新用户金额
	 * @param uid
	 * @param coin
	 */
	void updateMembersCoin(@Param("uid") Integer uid,@Param("mcoin") BigDecimal mcoin);
	
	/**
	 * 查找直接下级
	 * @param membersId
	 * @return
	 */
	List<Members> findChilds(@Param("membersId") String membersId);
	/**
	 * 会员银行信息
	 * @param parameters
	 * @param pageBounds
	 * @return
	 */
	PageList<Map> findMembersBankInfo(Object parameters, PageBounds pageBounds);
}
