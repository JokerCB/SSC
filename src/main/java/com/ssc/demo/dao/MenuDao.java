package com.ssc.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import com.ssc.demo.model.Menu;

public interface MenuDao   {

	List<Menu> findByType(@Param("type") int type);
}
