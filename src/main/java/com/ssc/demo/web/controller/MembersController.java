package com.ssc.demo.web.controller;


import java.math.BigDecimal;
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

import com.ssc.demo.model.Members;
import com.ssc.demo.service.MembersService;
import com.ssc.demo.web.controller.base.BaseController;
import com.ssc.demo.web.ui.PageRequest;

import framework.generic.memcached.MemCache;
import framework.generic.page.PageInfo;
import framework.generic.paginator.domain.PageList;
import framework.generic.utils.security.MD5;

@Controller
@RequestMapping("members/*")
public class MembersController extends BaseController{

	private MembersService membersService;
	
	@Resource 
	MemCache memCache;

	@Resource
	public void setMembersService(MembersService membersService) {
		this.membersService = membersService;
	}

	/*-------------------------------列表显示页面---------------------------------*/

	@RequestMapping(value = "findByPage", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public  Map<String, Object> findByPage(HttpSession session,PageRequest pageRequest, HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		pageRequest.setPageNo(Integer.parseInt(request.getParameter("pageIndex")));
		if(request.getParameter("mname") != null && request.getParameter("mname") != "")
			paramMap.put("mname", request.getParameter("mname"));
		else
			paramMap.put("mparentid", session.getAttribute("uid"));
			
		PageInfo pageInfo = new PageInfo();
		pageRequest.setParameter(paramMap);
		PageList<Members> list = membersService.findByPage(pageRequest);
		pageInfo.setDataList(list);
		pageInfo.setPageSize(list.getPaginator().getLimit());
		pageInfo.setPageIndex(list.getPaginator().getPage());
		pageInfo.setPageCount(list.getPaginator().getTotalPages());
		return ajaxDone(pageInfo);
		
//		request.setAttribute("pageInfo", ajaxDone(pageInfo));
//		return new ModelAndView("../index_files/accManager/userList");
	}
	
	@RequestMapping(value = "addUser", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public String addUser(HttpSession session,HttpServletRequest request) {
		
		Members members = new Members();
		String mname = request.getParameter("mname");
		BigDecimal mfandian = new BigDecimal(request.getParameter("mfandian"));
		BigDecimal mfandianbdw = new BigDecimal(request.getParameter("mfandianbdw"));
		int mparentid = Integer.parseInt(session.getAttribute("uid").toString());
		boolean mtype = "1".equals(request.getParameter("mtype"))?true:false;
		
		Members pM = (Members) memCache.getMc().get(mparentid+"_object");
		members.setMgrade(pM.getMgrade()+1);
		members.setMname(mname);
		members.setMfandian(mfandian);
		members.setMfandianbdw(mfandianbdw);
		members.setMparentid(mparentid);
		members.setMtype(mtype);
		members.setMpassword(MD5.getPasswordMD5("123456"));
		membersService.addMembers(members);
		return null;
	}
}




