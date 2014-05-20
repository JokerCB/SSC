package com.ssc.demo.web.controller;


import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ssc.demo.model.Members;
import com.ssc.demo.model.Played;
import com.ssc.demo.service.MembersService;
import com.ssc.demo.service.PlayedService;
import com.ssc.demo.util.IssTime;

import framework.generic.memcached.MemCache;
import framework.generic.utils.date.DateUtil;
import framework.generic.utils.json.JsonUtil;
import framework.generic.utils.security.MD5;

@Controller
@RequestMapping("admin/*")
public class AdminController {

	@Resource
	MembersService membersService;
	
	@Resource
	PlayedService playedService;
	
	@Resource 
	MemCache memCache;
	
	
	@RequestMapping(value = "login", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView login(Model model,HttpSession session,HttpServletRequest request) throws Exception {
	
		return new ModelAndView("index");

	}
	
	/**
	 * 退出登录
	 * 
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping(value = "/logout", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView logout(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws Exception {

		return new ModelAndView("login");

	}


}
