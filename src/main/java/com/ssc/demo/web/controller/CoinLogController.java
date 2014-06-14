package com.ssc.demo.web.controller;

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
import com.ssc.demo.service.CoinLogService;
import com.ssc.demo.web.controller.base.BaseController;
import com.ssc.demo.web.ui.PageRequest;

import framework.generic.page.PageInfo;
import framework.generic.paginator.domain.PageList;
import framework.generic.utils.string.StringUtil;

@Controller
@RequestMapping("coinLog/*")
public class CoinLogController extends BaseController{
	private CoinLogService coinLogService;

	public CoinLogService getCoinLogService() {
		return coinLogService;
	}
	@Resource
	public void setCoinLogService(CoinLogService coinLogService) {
		this.coinLogService = coinLogService;
	}

	/*-------------------------------列表显示页面---------------------------------*/

	@RequestMapping(value = "findByPage", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public  Map<String, Object> findByPage(HttpSession session,PageRequest pageRequest, HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		pageRequest.setPageNo(Integer.parseInt(request.getParameter("pageIndex")));
	
		if (!StringUtil.isNullOrEmpty(request.getParameter("liqType"))) {
			paramMap.put("liqType", request.getParameter("liqType"));
		}
		if (!StringUtil.isNullOrEmpty(request.getParameter("startDate"))) {
			paramMap.put("startDate", request.getParameter("startDate"));
		}
		if (!StringUtil.isNullOrEmpty(request.getParameter("endDate"))) {
			paramMap.put("endDate", request.getParameter("endDate"));
		}
		if (!StringUtil.isNullOrEmpty(request.getParameter("memberName"))) {
			paramMap.put("memberName", request.getParameter("memberName"));
		}
						
		PageInfo pageInfo = new PageInfo();
		pageRequest.setParameter(paramMap);
		PageList<Map> list = coinLogService.findCoinLogByPage(pageRequest);
		pageInfo.setDataList(list);
		pageInfo.setPageSize(list.getPaginator().getLimit());
		pageInfo.setPageIndex(list.getPaginator().getPage());
		pageInfo.setPageCount(list.getPaginator().getTotalPages());
		return ajaxDone(pageInfo);
		
	}
}
