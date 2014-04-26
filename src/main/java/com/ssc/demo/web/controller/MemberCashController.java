package com.ssc.demo.web.controller;


import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ssc.demo.model.MemberCash;
import com.ssc.demo.service.MemberCashService;
import com.ssc.demo.web.controller.base.AbstractController;
import com.ssc.demo.web.ui.DataGrid;
import com.ssc.demo.web.ui.Json;
import com.ssc.demo.web.ui.PageRequest;

import framework.generic.utils.string.StringUtil;
import framework.generic.utils.webutils.ServletUtil;

@Controller
@RequestMapping("memberCash/*")
public class MemberCashController extends AbstractController<MemberCash, Integer> {

	private MemberCashService memberCashService;

	@Resource
	public void setMemberCashService(MemberCashService memberCashService) {
		this.memberCashService = memberCashService;
	}

	/*-------------------------------列表显示页面---------------------------------*/
	@Override
	public ModelAndView index(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("ssc/memberCash_list");
	}

	@Override
	public DataGrid dataGrid(PageRequest pageRequest, HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> paramMap = ServletUtil.getParametersMapStartingWith(request, "filter_");
		pageRequest.setParameter(paramMap);
		DataGrid dataGrid = memberCashService.getDatagrid(pageRequest);
		return dataGrid;
	}

	/*--------------------------------添加操作-----------------------------------*/
	@Override
	public ModelAndView addFrom(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setAttribute("action", "memberCash/insert");
		return new ModelAndView("ssc/memberCash_edit");
	}

	@Override
	public Json insert(MemberCash memberCash, HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			int insertRecords = memberCashService.create(memberCash);
			if (insertRecords <= 0) {
				return error(getMessage("msg.error.add"));
			}
			return success(getMessage("msg.success.add"));
		} catch (Exception e) {
			e.printStackTrace();
			return error(getMessage("msg.error.add"));
		}
	}

	/*--------------------------------编辑操作-----------------------------------*/
	@Override
	public ModelAndView editForm(Integer id, HttpServletRequest request, HttpServletResponse response) throws Exception {
		MemberCash memberCash = memberCashService.get(id);
		request.setAttribute("memberCash", memberCash);
		request.setAttribute("action", "memberCash/update");
		return new ModelAndView("ssc/memberCash_edit");
	}

	@Override
	public Json update(MemberCash memberCash, HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			int updatedRecords = memberCashService.modify(memberCash);
			if (updatedRecords <= 0) {
				return error(getMessage("msg.error.add"));
			}
			return success(getMessage("msg.success.update"));
		} catch (Exception e) {
			e.printStackTrace();
			return error(getMessage("msg.error.update"));
		}
	}

	/*--------------------------------删除操作-----------------------------------*/
	@Override
	public Json deleteAll(Integer[] memberCashIds, HttpServletRequest request, HttpServletResponse response) {
		try {
			int deletedRecords = memberCashService.removeAll(memberCashIds);
			if (deletedRecords <= 0) {
				return error(getMessage("msg.error.delete"));
			} 
			return success(getMessage("msg.success.delete"));
		} catch (Exception e) {
			e.printStackTrace();
			return error(getMessage("msg.error.delete"));
		}
	}
	/*--------------------------------查看操作-----------------------------------*/
	@Override
	public ModelAndView view(Integer id, HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setAttribute("memberCash", memberCashService.get(id));
		return new ModelAndView("ssc/memberCash_edit");
	}
	
	/*--------------------------------验证操作-----------------------------------*/
	@Override
	public boolean validatePk(Integer id, HttpServletRequest request, HttpServletResponse response) {
		MemberCash memberCash = memberCashService.get(id);
		if (StringUtil.isNullOrEmpty(memberCash)) {
			return true;
		}
		return false;
	}
}




