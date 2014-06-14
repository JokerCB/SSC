package com.ssc.demo.web.controller;


import java.util.HashMap;
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
import com.ssc.demo.service.CoinLogService;
import com.ssc.demo.web.controller.base.BaseController;
import com.ssc.demo.web.ui.PageRequest;

import framework.generic.page.PageInfo;
import framework.generic.paginator.domain.PageList;

@Controller
@RequestMapping("business/*")
public class BusinessController extends BaseController{
	
	private CoinLogService coinLogService;
	

	@Resource
	public void setCoinLogService(CoinLogService coinLogService) {
		this.coinLogService = coinLogService;
	}

	@RequestMapping(value = "cash", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView cash(Model model,HttpSession session,HttpServletRequest request) throws Exception {
		return new ModelAndView("../admin/business/cash");

	}
	
	@RequestMapping(value = "coinLog", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView coinLog(Model model,HttpSession session,HttpServletRequest request) throws Exception {
		return new ModelAndView("../admin/business/coin-log");

	}
	
	
}
