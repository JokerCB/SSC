package com.ssc.demo.web.controller;



import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ssc.demo.model.Menu;
import com.ssc.demo.service.MenuService;
import com.ssc.demo.web.controller.base.MessageController;

@Controller
@RequestMapping("index/*")
public class IndexController extends MessageController{
	
	@Resource
	MenuService menuService;
	
	@RequestMapping(value = "userMain", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView login(Model model,HttpServletRequest request) throws Exception {
		int type = Integer.parseInt(request.getParameter("type"));
		List<Menu> menus = menuService.findByType(type);
		model.addAttribute("menus",menus);
		return new ModelAndView("../index_files/accManager/userMain");
	}

}
