package com.ssc.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssc.demo.model.Played;

public interface PlayedDao {

	Played load(@Param("id")int id);
	
	List<Played> findAll();
}
