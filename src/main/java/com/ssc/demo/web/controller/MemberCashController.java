package com.ssc.demo.web.controller;


import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssc.demo.model.MemberCash;
import com.ssc.demo.model.Members;
import com.ssc.demo.service.MemberCashService;
import com.ssc.demo.service.MembersService;
import com.ssc.demo.web.controller.base.BaseController;
import com.ssc.demo.web.ui.PageRequest;

import framework.generic.page.PageInfo;
import framework.generic.paginator.domain.PageList;
import framework.generic.utils.string.StringUtil;

@Controller
@RequestMapping("memberCash/*")
public class MemberCashController extends BaseController{

	private MemberCashService memberCashService;

	private MembersService membersService;
	
	@Resource
	public void setMemberCashService(MemberCashService memberCashService) {
		this.memberCashService = memberCashService;
	}

	@Resource
	public void setMembersService(MembersService membersService) {
		this.membersService = membersService;
	}

	@RequestMapping(value = "save", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public String save(HttpSession session,HttpServletRequest request) {
		MemberCash memberCash = new MemberCash();			
		Members members = membersService.load(Integer.parseInt(session.getAttribute("uid").toString()));
		memberCash.setUid(members.getUid());
		memberCash.setState(0);
		memberCash.setAmount(new BigDecimal(request.getParameter("amount")));
		memberCash.setMembersBankId(Integer.parseInt(request.getParameter("membersBankId")));
		memberCash.setInfo(request.getParameter("info"));
		memberCash.setCashNo(memberCashService.buildCashNo());
		memberCash.setCreateDate(new Date());
		
		memberCashService.save(memberCash);

		return null;
	}
	@RequestMapping(value = "update", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public String update(HttpSession session,HttpServletRequest request) {
		MemberCash memberCash = memberCashService.load(request.getParameter("id"));
		memberCash.setState(Integer.parseInt(session.getAttribute("state").toString()));
		
		memberCashService.update(memberCash);
		return null;
	}

	@RequestMapping(value = "delete", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public String delete(HttpSession session,HttpServletRequest request) {
	
		memberCashService.delete(request.getParameter("id"));
		return null;
	}

	
	/*-------------------------------列表显示页面---------------------------------*/

	@RequestMapping(value = "findByPage", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public  Map<String, Object> findByPage(HttpSession session,PageRequest pageRequest, HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		pageRequest.setPageNo(Integer.parseInt(request.getParameter("pageIndex")));
	
		paramMap.put("uid", session.getAttribute("uid"));
			
		PageInfo pageInfo = new PageInfo();
		pageRequest.setParameter(paramMap);
		PageList<MemberCash> list = memberCashService.findByPage(pageRequest);
		pageInfo.setDataList(list);
		pageInfo.setPageSize(list.getPaginator().getLimit());
		pageInfo.setPageIndex(list.getPaginator().getPage());
		pageInfo.setPageCount(list.getPaginator().getTotalPages());
		return ajaxDone(pageInfo);
	}
	
	/*-------------------------------提现请求列表显示页面---------------------------------*/

	@RequestMapping(value = "findCashByPage", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public  Map<String, Object> findCashByPage(HttpSession session,PageRequest pageRequest, HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		pageRequest.setPageNo(Integer.parseInt(request.getParameter("pageIndex")));
	
		if (!StringUtil.isNullOrEmpty(request.getParameter("username"))) {
			paramMap.put("username", request.getParameter("username"));
		}
	
		if (!StringUtil.isNullOrEmpty(request.getParameter("state"))) {
			paramMap.put("state", request.getParameter("state"));
		}
		if (!StringUtil.isNullOrEmpty(request.getParameter("states"))) {
			paramMap.put("states", request.getParameter("states"));
		}
		if (!StringUtil.isNullOrEmpty(request.getParameter("fromTime"))) {
			paramMap.put("startDate", request.getParameter("fromTime"));
		}
		if (!StringUtil.isNullOrEmpty(request.getParameter("toTime"))) {
			paramMap.put("endDate", request.getParameter("toTime"));
		}
		
		
        PageInfo pageInfo = new PageInfo();
    	pageRequest.setParameter(paramMap);
		PageList<Map> list = memberCashService.findCashByPage(pageRequest);
		pageInfo.setDataList(list);
		pageInfo.setPageSize(list.getPaginator().getLimit());
		pageInfo.setPageIndex(list.getPaginator().getPage());
		pageInfo.setPageCount(list.getPaginator().getTotalPages());
		return ajaxDone(pageInfo);
	}
	
	@RequestMapping(value = "updateCash", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public  String updateCash(HttpSession session,PageRequest pageRequest, HttpServletRequest request, HttpServletResponse response) {
	     try
	     {
	    	 
	    	 memberCashService.updateCash(Integer.parseInt(request.getParameter("dataId")),Integer.parseInt(request.getParameter("state")),Integer.parseInt(request.getParameter("uid")));
	    	return "处理成功！";
	     }catch(Exception ex)
	     {
	    	 ex.printStackTrace();
	    	 return "处理失败！";
	     }
	
		
		
	}
}




