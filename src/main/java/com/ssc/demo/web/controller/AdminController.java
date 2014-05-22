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
	
		String mname = session.getAttribute("mname")!=null?session.getAttribute("mname").toString():null;
		if(mname!= null && mname.equals(memCache.getMc().get(mname))){
			Members members = (Members) memCache.getMc().get(session.getAttribute("uid")+"_object");
			if(members.isAdmin())
				return new ModelAndView("index");
		}
		return new ModelAndView("login");

	}
	
	@RequestMapping(value = "loging", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public String loging(Model model,HttpSession session,HttpServletRequest request) throws Exception {
		String json = "";
		String mname = request.getParameter("username");
		String mpassword = request.getParameter("password");
		mpassword = MD5.getPasswordMD5(mpassword);
		Members members = membersService.load(mname, mpassword);
		if(members == null || !members.isAdmin())
		{
			session.removeAttribute("uid");
			session.removeAttribute("mname");
			model.addAttribute("msg", "用户名和密码错误, 请重新登陆");
			json = "{'sError':0,'sMsg':'用户名和密码错误, 请重新登陆','aLinks':[{'url':'login'}]}";
		}
		else{
			
			session.setAttribute("uid", members.getUid());
			session.setAttribute("mname", members.getMname());
			
			memCache.getMc().set(members.getMname(), members.getMname());
			memCache.getMc().set(members.getUid()+"_object", members);
			json = "{'sError':0,'sMsg':'','aLinks':[{'url':'index'}]}";
		}
		return json;
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
