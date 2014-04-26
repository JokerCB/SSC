package com.ssc.demo.dao.common;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssc.demo.model.common.HighQuery;

import framework.generic.dao.GenericDao;
import framework.generic.model.PersistentModel;


public interface CommonDao extends GenericDao<PersistentModel, Serializable> {

	int insertHighQuerys(@Param("highQuerys") List<HighQuery> highQuerys, @Param("userId") String userId);

}
