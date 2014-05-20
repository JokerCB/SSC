package com.ssc.demo.web.controller;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssc.demo.model.Data;
import com.ssc.demo.model.Members;
import com.ssc.demo.service.MembersService;
import com.ssc.demo.service.OrderService;
import com.ssc.demo.util.IssTime;
import com.ssc.demo.web.controller.base.AbstractController;

import framework.generic.memcached.MemCache;

@Controller
@RequestMapping("test/*")
public class TestController extends AbstractController<Members, Integer> {
	
	@Resource
	private MemCache memCache;
	
	@Resource
	MembersService membersService;
	
	@Resource
	OrderService orderService;
	
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

	@RequestMapping(value = "getSscData", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public String getSscData(HttpSession session,HttpServletRequest request) {
		
		//{issue:'20140420-091',nowtime:'2014-04-20 20:59:06',saleend:'2014-04-20 21:09:05'}
		//{"cur_issue","{issue:'"+IssTime.getIss()+"',endtime:'"+IssTime.getEndTime()+"'}"};
		return "{issue:'"+IssTime.getIss()+"',nowtime:'"+IssTime.getServetTime()+"',saleend:'"+IssTime.getEndTime()+"'}";
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

	/*private MembersService membersService;

	@Resource
	public void setMembersService(MembersService membersService) {
		this.membersService = membersService;
	}

	-------------------------------列表显示页面---------------------------------
	@Override
	public ModelAndView index(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("ssc/members_list");
	}

	@Override
	public DataGrid dataGrid(PageRequest pageRequest, HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> paramMap = ServletUtil.getParametersMapStartingWith(request, "filter_");
		pageRequest.setParameter(paramMap);
		DataGrid dataGrid = membersService.getDatagrid(pageRequest);
		return dataGrid;
	}

	--------------------------------添加操作-----------------------------------
	@Override
	public ModelAndView addFrom(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setAttribute("action", "members/insert");
		return new ModelAndView("ssc/members_edit");
	}

	@Override
	public Json insert(Members members, HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			int insertRecords = membersService.create(members);
			if (insertRecords <= 0) {
				return error(getMessage("msg.error.add"));
			}
			return success(getMessage("msg.success.add"));
		} catch (Exception e) {
			e.printStackTrace();
			return error(getMessage("msg.error.add"));
		}
	}

	--------------------------------编辑操作-----------------------------------
	@Override
	public ModelAndView editForm(Integer mid, HttpServletRequest request, HttpServletResponse response) throws Exception {
		Members members = membersService.get(mid);
		request.setAttribute("members", members);
		request.setAttribute("action", "members/update");
		return new ModelAndView("ssc/members_edit");
	}

	@Override
	public Json update(Members members, HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			int updatedRecords = membersService.modify(members);
			if (updatedRecords <= 0) {
				return error(getMessage("msg.error.add"));
			}
			return success(getMessage("msg.success.update"));
		} catch (Exception e) {
			e.printStackTrace();
			return error(getMessage("msg.error.update"));
		}
	}

	--------------------------------删除操作-----------------------------------
	@Override
	public Json deleteAll(Integer[] membersIds, HttpServletRequest request, HttpServletResponse response) {
		try {
			int deletedRecords = membersService.removeAll(membersIds);
			if (deletedRecords <= 0) {
				return error(getMessage("msg.error.delete"));
			} 
			return success(getMessage("msg.success.delete"));
		} catch (Exception e) {
			e.printStackTrace();
			return error(getMessage("msg.error.delete"));
		}
	}
	--------------------------------查看操作-----------------------------------
	@Override
	public ModelAndView view(Integer mid, HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setAttribute("members", membersService.get(mid));
		return new ModelAndView("ssc/members_edit");
	}
	
	--------------------------------验证操作-----------------------------------
	@Override
	public boolean validatePk(Integer mid, HttpServletRequest request, HttpServletResponse response) {
		Members members = membersService.get(mid);
		if (StringUtil.isNullOrEmpty(members)) {
			return true;
		}
		return false;
	}*/
}




