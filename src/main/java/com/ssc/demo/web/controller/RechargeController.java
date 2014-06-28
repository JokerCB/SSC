package com.ssc.demo.web.controller;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssc.demo.dao.RechargeDao;
import com.ssc.demo.model.Bank;
import com.ssc.demo.model.CoinLog;
import com.ssc.demo.model.Members;
import com.ssc.demo.model.Recharge;
import com.ssc.demo.service.AdminBankService;
import com.ssc.demo.service.MembersService;
import com.ssc.demo.service.RechargeService;
import com.ssc.demo.web.controller.base.BaseController;
import com.ssc.demo.web.ui.PageRequest;

import framework.generic.page.PageInfo;
import framework.generic.paginator.domain.PageList;
import framework.generic.utils.string.StringUtil;

@Controller
@RequestMapping("recharge/*")
public class RechargeController extends BaseController {

	private RechargeService rechargeService;
	
	private MembersService membersService;
	
	private AdminBankService adminBankService;

	@Resource
	public void setRechargeService(RechargeService rechargeService) {
		this.rechargeService = rechargeService;
	}
	
	@Resource
	public void setMembersService(MembersService membersService) {
		this.membersService = membersService;
	}

	@Resource
	public void setAdminBankService(AdminBankService adminBankService) {
		this.adminBankService = adminBankService;
	}

	@RequestMapping(value = "save", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public String save(HttpSession session,HttpServletRequest request) {
		Recharge recharge = new Recharge();			
		Members members = membersService.load(Integer.parseInt(session.getAttribute("uid").toString()));
		recharge.setUid(members.getUid());
		recharge.setCoin(members.getMcoin());
		recharge.setState(0);
		recharge.setAmount(new BigDecimal(request.getParameter("amount")));
		recharge.setBanklistId(request.getParameter("banklistId"));
		recharge.setInfo(request.getParameter("info"));
		recharge.setRechargeNo(rechargeService.buildRechargeNo());
		recharge.setCreateDate(new Date());
		
		rechargeService.save(recharge);
		return recharge.getRechargeNo();
	}
	@RequestMapping(value = "update", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public String update(HttpSession session,HttpServletRequest request) {
		Recharge recharge = rechargeService.load(request.getParameter("id"));
		recharge.setState(Integer.parseInt(session.getAttribute("state").toString()));
		
		rechargeService.update(recharge);
		return null;
	}

	@RequestMapping(value = "delete", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public String delete(HttpSession session,HttpServletRequest request) {
	
		rechargeService.delete(request.getParameter("id"));
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
		PageList<Recharge> list = rechargeService.findByPage(pageRequest);
		pageInfo.setDataList(list);
		pageInfo.setPageSize(list.getPaginator().getLimit());
		pageInfo.setPageIndex(list.getPaginator().getPage());
		pageInfo.setPageCount(list.getPaginator().getTotalPages());
		return ajaxDone(pageInfo);
	}
	
	/*-------------------------------列表显示页面---------------------------------*/

	@RequestMapping(value = "findRechargeLogByPage", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public  Map<String, Object> findRechargeLogByPage(HttpSession session,PageRequest pageRequest, HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		pageRequest.setPageNo(Integer.parseInt(request.getParameter("pageIndex")));
	
		if (!StringUtil.isNullOrEmpty(request.getParameter("username"))) {
			paramMap.put("username", request.getParameter("username"));
		}
		if (!StringUtil.isNullOrEmpty(request.getParameter("rechargeId"))) {
			paramMap.put("rechargeNo", request.getParameter("rechargeId"));
		}
		if (!StringUtil.isNullOrEmpty(request.getParameter("state"))) {
			paramMap.put("state", request.getParameter("state"));
		}
		if (!StringUtil.isNullOrEmpty(request.getParameter("fromTime"))) {
			paramMap.put("startDate", request.getParameter("fromTime"));
		}
		if (!StringUtil.isNullOrEmpty(request.getParameter("toTime"))) {
			paramMap.put("endDate", request.getParameter("toTime"));
		}
						
		PageInfo pageInfo = new PageInfo();
		pageRequest.setParameter(paramMap);
		PageList<Map> list = rechargeService.findRechargeLogByPage(pageRequest);
		pageInfo.setDataList(list);
		pageInfo.setPageSize(list.getPaginator().getLimit());
		pageInfo.setPageIndex(list.getPaginator().getPage());
		pageInfo.setPageCount(list.getPaginator().getTotalPages());
		return ajaxDone(pageInfo);
		
	}
	
	
	@RequestMapping(value = "updateCoin", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public  String updateCoin(HttpSession session,PageRequest pageRequest, HttpServletRequest request, HttpServletResponse response) {
	     try
	     {
	    	 rechargeService.addCoinLog(request.getParameter("dataId"),Integer.parseInt(request.getParameter("state")));
	    	return "处理成功！";
	     }catch(Exception ex)
	     {
	    	 ex.printStackTrace();
	    	 return "处理失败！";
	     }
	
		
		
	}
	
	@RequestMapping(value = "rechargeAction", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public  String rechargeAction(HttpSession session,PageRequest pageRequest, HttpServletRequest request, HttpServletResponse response) {
       try
	     {
	    	return  rechargeService.actionCoinLog(Integer.parseInt(request.getParameter("userRid")),request.getParameter("uid"),request.getParameter("amount"));
	    	
	     }catch(Exception ex)
	     {
	    	 ex.printStackTrace();
	    	 return "充值失败！";
	     }
		
		
		
	}
	
	@RequestMapping(value = "findAdminBanks", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public Map<String,Object> findAdminBanks()
	{
		List<Map> list = adminBankService.findAdminBanks();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		return map;
		
	}
}
