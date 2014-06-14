package com.ssc.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssc.demo.model.City;
import com.ssc.demo.model.Province;

public interface AreaDao{
	
	Province loadProvinces(@Param("fid") String fid);
	
	City loadCity(@Param("fid") String fid);

	List<Province> findProvinces();
	
	List<City> findCitys(@Param("fprovinceid") String fprovinceid);

}
