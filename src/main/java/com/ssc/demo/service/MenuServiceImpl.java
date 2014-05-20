package com.ssc.demo.service;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.ssc.demo.dao.MenuDao;
import com.ssc.demo.model.Menu;

@Service("menuService")
public class MenuServiceImpl implements MenuService{

	@Resource
	private MenuDao menuDao;

	@Override
	public List<Menu> findByType(int type) {
		// TODO Auto-generated method stub
		return menuDao.findByType(type);
	}
	
	
}
