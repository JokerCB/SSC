package com.ssc.demo.web.controller;


import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssc.demo.model.Data;
import com.ssc.demo.model.Members;
import com.ssc.demo.model.Played;
import com.ssc.demo.service.MembersService;
import com.ssc.demo.service.OrderService;
import com.ssc.demo.service.PlayedService;
import com.ssc.demo.util.IssTime;
import com.ssc.demo.web.controller.base.AbstractController;

import framework.generic.memcached.MemCache;
import framework.generic.utils.json.JsonUtil;

@Controller
@RequestMapping("test/*")
public class TestController extends AbstractController<Members, Integer> {
	
	@Resource
	private MemCache memCache;
	
	@Resource
	MembersService membersService;
	
	@Resource
	OrderService orderService;
	
	@Resource
	PlayedService playedService;
	
	@RequestMapping(value = "getData", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public String getData(HttpServletRequest request) {
		if(request.getParameter("empty") != null)
			return "empty";
		int lotteryid = Integer.parseInt(request.getParameter("lotteryid"));
		String flag = request.getParameter("flag");
		String currentissue = request.getParameter("currentissue");
		
		System.out.println(currentissue);
		System.out.println(flag);
		System.out.println(lotteryid);
		
		Data data = orderService.getLotteryData(lotteryid);
		//返奖
		if(data.getStatus() ==0){
			orderService.addBonus(data);
		}
		
		return "{'0':{'code':'"+data.getData()+"','issue':'"+data.getNumber()+"','statuscode':'2'},'iscurent':1}";
	}

	@RequestMapping(value = "getMoney", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public String getMoney(HttpSession session,HttpServletRequest request) {
		String mname = session.getAttribute("mname") != null ? session.getAttribute("mname").toString():null;
		if(mname != null)
		{
			Members member = membersService.load(mname);
			return member.getMcoin()+"";
		}
		else
			return "0";
	}

	@RequestMapping(value = "getLeaveTime", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public long getLeaveTime(HttpSession session,HttpServletRequest request) {
		return IssTime.getLeaveTime();
	}

	@RequestMapping(value = "findByType", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public String findByType(HttpSession session,HttpServletRequest request){
		int type = Integer.parseInt(request.getParameter("type"));
		List<Played> list = playedService.findByType(type);
		return JsonUtil.toJson(list);
	}
	
}




