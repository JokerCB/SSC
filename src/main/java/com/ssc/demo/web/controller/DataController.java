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

import com.ssc.demo.dao.DataDao;
import com.ssc.demo.service.DataService;
import com.ssc.demo.service.OrderService;
import com.ssc.demo.web.controller.base.BaseController;
import com.ssc.demo.web.ui.PageRequest;

import framework.generic.page.PageInfo;
import framework.generic.paginator.domain.PageList;
import framework.generic.utils.string.StringUtil;

@Controller
@RequestMapping("data/*")
public class DataController extends BaseController{

	private DataService dataService;
	private OrderService orderService;
	
	public OrderService getOrderService() {
		return orderService;
	}
	@Resource
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
	public DataService getDataService() {
		return dataService;
	}
	@Resource
	public void setDataService(DataService dataService) {
		this.dataService = dataService;
	}
	

	@RequestMapping(value = "index", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView index(Model model,HttpSession session,HttpServletRequest request) throws Exception {
		return new ModelAndView("../admin/data/index");

	}
	
	/*-------------------------------列表显示页面---------------------------------*/

	@RequestMapping(value = "findByPage", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public  Map<String, Object> findByPage(HttpSession session,PageRequest pageRequest, HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		pageRequest.setPageNo(Integer.parseInt(request.getParameter("pageIndex")));
	
		if (!StringUtil.isNullOrEmpty(request.getParameter("actionNo"))) {
			paramMap.put("actionNo", request.getParameter("actionNo"));
		}
		if (!StringUtil.isNullOrEmpty(request.getParameter("date"))) {
			paramMap.put("date", request.getParameter("date"));
		}
								
		PageInfo pageInfo = new PageInfo();
		pageRequest.setParameter(paramMap);
		PageList<Map> list = dataService.findDataByPage(pageRequest);
		pageInfo.setDataList(list);
		pageInfo.setPageSize(list.getPaginator().getLimit());
		pageInfo.setPageIndex(list.getPaginator().getPage());
		pageInfo.setPageCount(list.getPaginator().getTotalPages());
		return ajaxDone(pageInfo);
		
	}
	/*手动计算开奖数据*/
	@RequestMapping(value = "calcBonus", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public  String calcBonus(HttpSession session,PageRequest pageRequest, HttpServletRequest request, HttpServletResponse response) {
	     try
	     {
	    		orderService.addBonus(request.getParameter("dataId"));
	    		return "手动开奖成功！";
	     }catch(Exception ex)
	     {
	    	 ex.printStackTrace();
	    	 return "手动开奖失败！";
	     }
	
		
		
	}

}
