package com.ssc.demo.web.controller;


import java.io.UnsupportedEncodingException;
import java.util.Date;

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
import com.ssc.demo.service.MembersService;
import com.ssc.demo.util.IssTime;

import framework.generic.memcached.MemCache;
import framework.generic.utils.date.DateUtil;
import framework.generic.utils.security.MD5;

@Controller
public class LoginController {

	@Resource
	MembersService membersService;
	
	@Resource 
	MemCache memCache;
	
	
	@RequestMapping(value = "login", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView login(Model model,HttpSession session,HttpServletRequest request) throws Exception {

		String mname = session.getAttribute("mname")!=null?session.getAttribute("mname").toString():null;
		if(mname!= null && mname.equals(memCache.getMc().get(mname)))
		{
			Date nowDate = new Date();
			Date tomorrow = DateUtil.parse(DateUtil.format((new Date(nowDate.getTime()+24*60*60*1000))).subSequence(0, 11)+"00:00:00");
			model.addAttribute("mname", mname);
			model.addAttribute("cur_issue","{issue:'"+IssTime.getIss()+"',endtime:'"+IssTime.getEndTime()+"'}");
			model.addAttribute("servertime",IssTime.getServetTime());
			model.addAttribute("Iss_today",IssTime.getAllIss(nowDate));
			model.addAttribute("Iss_tomorrow",IssTime.getAllIss(tomorrow));
			
			return new ModelAndView("/index");
		}
		else
			return new ModelAndView("/login");
	}
	
	@RequestMapping(value = "loging", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public String loging(Model model,HttpSession session,HttpServletRequest request) throws Exception {

		String json = "";
		String mname = request.getParameter("username");
		String mpassword = request.getParameter("password");
		mpassword = MD5.getPasswordMD5(mpassword);
		Members members = membersService.load(mname, mpassword);
		if(members == null)
		{
			session.removeAttribute("mid");
			session.removeAttribute("mname");
			json = "{'sError':0,'sMsg':'用户名和密码错误, 请重新登陆','aLinks':[{'url':'login'}]}";
		}
		else{
			
			session.setAttribute("mid", members.getMid());
			session.setAttribute("mname", members.getMname());
			
			memCache.getMc().set(members.getMname(), members.getMname());

			json = "{'sError':0,'sMsg':'您本次登陆的IP和上次不同 您上次登陆的时间是 2014-04-14 20:22:57','aLinks':[{'url':'login'}]}";
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
		if(session.getAttribute("mname") != null)
			memCache.getMc().set(session.getAttribute("mname").toString(), null);
		session.removeAttribute("mid");
		session.removeAttribute("mname");
		
		return new ModelAndView("/login");

	}


}
