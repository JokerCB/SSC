package com.ssc.demo.web.controller;

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

import com.ssc.demo.model.AdminBank;
import com.ssc.demo.model.Bank;
import com.ssc.demo.model.City;
import com.ssc.demo.model.Notice;
import com.ssc.demo.model.Province;
import com.ssc.demo.service.AdminBankService;
import com.ssc.demo.service.SystemService;
import com.ssc.demo.web.controller.base.BaseController;
import com.ssc.demo.web.ui.PageRequest;

import framework.generic.page.PageInfo;
import framework.generic.paginator.domain.PageList;
import framework.generic.utils.json.JsonUtil;

@Controller
@RequestMapping("system/*")
public class SystemController extends BaseController {
	@Resource
	private AdminBankService adminBankService;
	
	@Resource
	private SystemService systemService;

	@RequestMapping(value = "getBankList", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public Map<String,Object> getBankList()
	{
		List<Bank> list = adminBankService.findList();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		return map;
		
	}
	
	@RequestMapping(value = "getProvinceList", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public Map<String,Object> getProvinceList()
	{
		List<Province> list = adminBankService.findProvinces();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		return map;
		
	}
	
	@RequestMapping(value = "getCityList", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public Map<String,Object> getCityList(HttpSession session,PageRequest pageRequest, HttpServletRequest request, HttpServletResponse response) {
          List<City> list = adminBankService.findCitys(request.getParameter("provinceId"));
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		return map;
	}

	@RequestMapping(value = "editAdminBank", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public String editAdminBank(HttpSession session,PageRequest pageRequest, HttpServletRequest request, HttpServletResponse response) {
		AdminBank adminBank= adminBankService.getByPk(Integer.parseInt(request.getParameter("id")));
		return JsonUtil.objectToJson(adminBank);
	}
	
	@RequestMapping(value = "saveAdminBank", method = { RequestMethod.POST,
			RequestMethod.GET })
	@ResponseBody
	public String saveAdminBank(HttpSession session, PageRequest pageRequest,
			HttpServletRequest request, HttpServletResponse response) {
		int count=adminBankService.findUnique(null,request.getParameter("username"), Integer.parseInt(request.getParameter("bankId")), request.getParameter("account"));
		if (count>0)
		{
			return "不能重复提交记录！";
		}
        AdminBank adminBank = new AdminBank() ;
		adminBank.setAccount(request.getParameter("account"));
		adminBank.setBankcardname(request.getParameter("bankCardName"));
		adminBank.setBankid(Integer.parseInt(request.getParameter("bankId")));
		adminBank.setCityid(request.getParameter("cityId"));
		adminBank.setProvinceid(request.getParameter("provinceId"));
		adminBank.setUsername(request.getParameter("username"));
		try {
			adminBankService.create(adminBank);
			return "保存成功";
		} catch (Exception ex) {
			ex.printStackTrace();
			return "保存失败！";
		}

	}
	
	@RequestMapping(value = "updateAdminBank", method = { RequestMethod.POST,
			RequestMethod.GET })
	@ResponseBody
	public String updateAdminBank(HttpSession session, PageRequest pageRequest,
			HttpServletRequest request, HttpServletResponse response) {
		int count=adminBankService.findUnique(Integer.parseInt(request.getParameter("id")),request.getParameter("username"), Integer.parseInt(request.getParameter("bankId")), request.getParameter("account"));
		if (count>0)
		{
			return "不能重复提交记录！";
		}
        AdminBank adminBank = new AdminBank() ;
        adminBank.setId(Integer.parseInt(request.getParameter("id")));
		adminBank.setAccount(request.getParameter("account"));
		adminBank.setBankcardname(request.getParameter("bankCardName"));
		adminBank.setBankid(Integer.parseInt(request.getParameter("bankId")));
		adminBank.setCityid(request.getParameter("cityId"));
		adminBank.setProvinceid(request.getParameter("provinceId"));
		adminBank.setUsername(request.getParameter("username"));
		try {
			adminBankService.modify(adminBank);
			return "修改成功";
		} catch (Exception ex) {
			ex.printStackTrace();
			return "修改失败！";
		}

	}
		
	@RequestMapping(value = "deleteAdminBank", method = { RequestMethod.POST,
			RequestMethod.GET })
	@ResponseBody
	public String deleteAdminBank(HttpSession session, PageRequest pageRequest,
			HttpServletRequest request, HttpServletResponse response) {
        
		try {
			adminBankService.deleteByPk(Integer.parseInt(request.getParameter("id")));
			return "删除成功";
		} catch (Exception ex) {
			ex.printStackTrace();
			return "删除失败！";
		}

	}
	
	
	@RequestMapping(value = "findByPage", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public  Map<String, Object> findByPage(HttpSession session,PageRequest pageRequest, HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		pageRequest.setPageNo(Integer.parseInt(request.getParameter("pageIndex")));
									
		PageInfo pageInfo = new PageInfo();
		pageRequest.setParameter(paramMap);
		PageList<Map> list = adminBankService.findDataByPage(pageRequest);
		pageInfo.setDataList(list);
		pageInfo.setPageSize(list.getPaginator().getLimit());
		pageInfo.setPageIndex(list.getPaginator().getPage());
		pageInfo.setPageCount(list.getPaginator().getTotalPages());
		return ajaxDone(pageInfo);
		
	}
	

	/**
	 * 查询公告
	 * @param session
	 * @param pageRequest
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "findNoticesByPage", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public  Map<String, Object> findNoticesByPage(HttpSession session,PageRequest pageRequest, HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		pageRequest.setPageNo(Integer.parseInt(request.getParameter("pageIndex")));
		pageRequest.setOrder("DESC");	
		pageRequest.setOrderBy("createDate");
		PageInfo pageInfo = new PageInfo();
		pageRequest.setParameter(paramMap);
		PageList<Notice> list = systemService.findNoticesByPage(pageRequest);
		pageInfo.setDataList(list);
		pageInfo.setPageSize(list.getPaginator().getLimit());
		pageInfo.setPageIndex(list.getPaginator().getPage());
		pageInfo.setPageCount(list.getPaginator().getTotalPages());
		return ajaxDone(pageInfo);
		
	}
	/**
	 * 添加公告
	 * @param session
	 * @param pageRequest
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "addNotice", method = { RequestMethod.POST,RequestMethod.GET })
	@ResponseBody
	public String addNotice(HttpSession session, PageRequest pageRequest,
			HttpServletRequest request, HttpServletResponse response) {
		Notice notice = new Notice();
		notice.setContent(request.getParameter("content"));
		notice.setVisible(Integer.parseInt(request.getParameter("enable"))==1);
		notice.setCreateDate(new Date());
		systemService.saveNotice(notice);
		System.out.println(request.getParameter("content"));
		return null;

	}
	/**
	 * 更新公告
	 * @param session
	 * @param pageRequest
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "updateNotice", method = { RequestMethod.POST,RequestMethod.GET })
	@ResponseBody
	public String updateNotice(HttpSession session, PageRequest pageRequest,HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		Notice notice = systemService.loadNotice(id);
		String enable = request.getParameter("enable");
		System.out.println(enable +"=======================");
		notice.setVisible(Integer.parseInt(enable) == 1);
		notice.setCreateDate(new Date());
		systemService.updateNotice(notice);	
		return null;

	}
	/**
	 * 删除公告
	 * @param session
	 * @param pageRequest
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "deleteNotice", method = { RequestMethod.POST,RequestMethod.GET })
	@ResponseBody
	public String deleteNotice(HttpSession session, PageRequest pageRequest,HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		systemService.deleteNotice(Integer.parseInt(id));
		return null;

	}

}
