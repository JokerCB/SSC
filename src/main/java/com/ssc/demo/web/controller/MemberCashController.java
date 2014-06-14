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
}




