package com.ssc.demo.service;

import java.util.List;

import com.ssc.demo.model.Menu;

public interface MenuService {

	public List<Menu> findByType(int type);
}
