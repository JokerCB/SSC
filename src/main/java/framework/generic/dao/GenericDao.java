package framework.generic.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.UpdateProvider;
import org.springframework.util.LinkedCaseInsensitiveMap;

import framework.generic.model.PersistentModel;
import framework.generic.paginator.domain.PageBounds;
import framework.generic.paginator.domain.PageList;

/**
 * MyBatis的CRUD基接口类
 * <p>
 * 项目名称：framework-generic-mybatis
 * </p>
 * <p>
 * 版权：2013-广州扬基信息科技有限公司
 * </p>
 * 
 * @see framework.generic.dao.GenericDao
 * @version 1.0, 2013-8-14 上午10:13:57
 * @author quanyongan
 */
public interface GenericDao<T extends PersistentModel, PK extends Serializable> {

	/**
	 * /** 插入一个实体（在数据库INSERT一条记录）(不需要写SQL语句)
	 * 
	 * @param entity
	 *            实体对象
	 */
	@InsertProvider(type = CurdTemplate.class, method = "getInsertSql")
	abstract Integer insertEntity(T entity);

	/**
	 * /** 插入一个实体（在数据库INSERT一条记录）
	 * 
	 * @param entity
	 *            实体对象
	 */
	abstract Integer insert(T entity);

	/**
	 * 修改一个实体对象（MODIFY一条记录）(不需要写SQL语句)
	 * 
	 * @param entity
	 *            实体对象
	 * @return 修改的对象个数，正常情况=1
	 */
	@UpdateProvider(type = CurdTemplate.class, method = "getUpdateSql")
	abstract Integer updateEntity(T entity);

	/**
	 * /** 插入一个实体（在数据库INSERT一条记录）
	 * 
	 * @param entity
	 *            实体对象
	 */
	abstract Integer update(T entity);

	/**
	 * 根据传入的对象删除记录(不需要写SQL语句)
	 * 
	 * @param entity
	 *            实体对象
	 * @return 删除的对象个数，正常情况=1
	 */
	@DeleteProvider(type = CurdTemplate.class, method = "getDeleteSql")
	abstract Integer deleteEntity(T entity);

	/**
	 * 根据传入的对象删除记录
	 * 
	 * @param Object
	 *            所有对象
	 * @return 删除的对象个数，正常情况>=1
	 */
	abstract Integer delete(Object parameters);
	
	/**
	 * 根据传入的对象删除所有记录
	 * 
	 * @param Object
	 *            所有对象
	 * @return 删除的对象个数，正常情况>=1
	 */
	abstract Integer deleteAll(List<T> parameters);
	
	
	abstract Integer deleteAll(String[] ids);
	

	/**
	 * 查询整表总记录数
	 * 
	 * @return 整表总记录数
	 */
	abstract Integer count();

	/**
	 * 按主键取记录
	 * 
	 * @param primaryKey
	 *            主键值
	 * @return 记录实体对象，如果没有符合主键条件的记录，则返回null
	 */
	abstract T find(PK primaryKey);

	/**
	 * 取全部记录
	 * 
	 * @return 全部记录实体对象的List
	 */
	abstract List<T> findAll();

	/**
	 * 分页查询，必须是传递一个pagination
	 * 
	 * @param pagination
	 *            分页工具类
	 * @return pagination 分页工具类
	 */
	PageList<T> findByPage(Object parameters, PageBounds pageBounds);

	/**
	 * 查询一个HashMap的结果集列表数据
	 * 
	 * @param parameters
	 *            任意类型的 参数对象
	 * @return List<HashMap<String, Object>>
	 */
	List<HashMap<String, Object>> findView(Object parameters);

	/**
	 * 分页查询一个HashMap的结果集列表数据
	 * 
	 * @param parameters
	 *            任意类型的 参数对象
	 * @return List<HashMap<String, Object>>
	 */
	PageList<HashMap<String, Object>> findViewByPage(Object parameters, PageBounds pageBounds);
	
	/**
	 * 查询单个结果集LinkedCaseInsensitiveMap，不区分大小写的Map的key值
	 * 
	 * @param parameters
	 *            任意类型的 参数对象
	 * @return LinkedCaseInsensitiveMap 不区分大小写的Map的key值
	 */
	LinkedCaseInsensitiveMap<?> findEntityMap(Object parameters);

	/**
	 * 查询LinkedCaseInsensitiveMap类型的Collection结果集,不区分大小写的Map的key值
	 * 
	 * @param parameters
	 *            任意类型的 参数对象
	 * @return Collection<LinkedCaseInsensitiveMap<?>> 不区分大小写的Map的key值
	 */
	Collection<LinkedCaseInsensitiveMap<?>> findCollectionMap(Object parameters);

	/*-------------------------------------调用存储过程---------------------------------------*/

	/**
	 * 根据存储过程的名称，表名，字段，生成的序列长度，生成序列号
	 * 
	 * @param procedureName
	 *            存储过程的名称
	 * @param tableName
	 *            表名
	 * @param fieldName
	 *            字段
	 * @param len
	 *            产生的CODE或者ID长度
	 * @return 一个在指定存储过程名称，给出表名，字段和长度的ID或者CODE
	 */
	@Select("{CALL ${procedureName}(#{tableName,jdbcType=VARCHAR,mode=IN},#{fieldName,jdbcType=VARCHAR,mode=IN},#{len,jdbcType=INTEGER,mode=IN})}")
	abstract String executeMaxSeq(@Param("procedureName") String procedureName, @Param("tableName") String tableName, @Param("fieldName") String fieldName, @Param("len") int len);

	/**
	 * 检查是否有关联
	 * 
	 * @param deleteTableName
	 *            需要删除数据所在的表名
	 * @param fieldValue
	 *            删除的值
	 * @return String 如果失败成返回关联的标明，成功返回空字符串
	 */
	@Select("{CALL PROC_DELETE_CHECK(#{pTableName,jdbcType=VARCHAR,mode=IN},#{pFieldValue,jdbcType=VARCHAR,mode=IN})}")
	abstract String executeCheckDeletions(@Param("pTableName") String deleteTableName, @Param("pFieldValue") String fieldValue);
}
