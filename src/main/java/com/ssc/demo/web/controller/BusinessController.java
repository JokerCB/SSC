package com.ssc.demo.web.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("business/*")
public class BusinessController {

	@RequestMapping(value = "cash", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView login(Model model,HttpSession session,HttpServletRequest request) throws Exception {
		return new ModelAndView("../admin/business/cash");

	}
	
}
