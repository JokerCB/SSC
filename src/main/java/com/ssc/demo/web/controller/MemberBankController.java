package com.ssc.demo.web.controller;


import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ssc.demo.model.MemberBank;
import com.ssc.demo.service.MemberBankService;
import com.ssc.demo.web.controller.base.AbstractController;
import com.ssc.demo.web.ui.DataGrid;
import com.ssc.demo.web.ui.Json;
import com.ssc.demo.web.ui.PageRequest;

import framework.generic.utils.string.StringUtil;
import framework.generic.utils.webutils.ServletUtil;

@Controller
@RequestMapping("memberBank/*")
public class MemberBankController extends AbstractController<MemberBank, Integer> {

	private MemberBankService memberBankService;

	@Resource
	public void setMemberBankService(MemberBankService memberBankService) {
		this.memberBankService = memberBankService;
	}

	/*-------------------------------列表显示页面---------------------------------*/
	@Override
	public ModelAndView index(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("ssc/memberBank_list");
	}

	@Override
	public DataGrid dataGrid(PageRequest pageRequest, HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> paramMap = ServletUtil.getParametersMapStartingWith(request, "filter_");
		pageRequest.setParameter(paramMap);
		DataGrid dataGrid = memberBankService.getDatagrid(pageRequest);
		return dataGrid;
	}

	/*--------------------------------添加操作-----------------------------------*/
	@Override
	public ModelAndView addFrom(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setAttribute("action", "memberBank/insert");
		return new ModelAndView("ssc/memberBank_edit");
	}

	@Override
	public Json insert(MemberBank memberBank, HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			int insertRecords = memberBankService.create(memberBank);
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
		MemberBank memberBank = memberBankService.get(id);
		request.setAttribute("memberBank", memberBank);
		request.setAttribute("action", "memberBank/update");
		return new ModelAndView("ssc/memberBank_edit");
	}

	@Override
	public Json update(MemberBank memberBank, HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			int updatedRecords = memberBankService.modify(memberBank);
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
	public Json deleteAll(Integer[] memberBankIds, HttpServletRequest request, HttpServletResponse response) {
		try {
			int deletedRecords = memberBankService.removeAll(memberBankIds);
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
		request.setAttribute("memberBank", memberBankService.get(id));
		return new ModelAndView("ssc/memberBank_edit");
	}
	
	/*--------------------------------验证操作-----------------------------------*/
	@Override
	public boolean validatePk(Integer id, HttpServletRequest request, HttpServletResponse response) {
		MemberBank memberBank = memberBankService.get(id);
		if (StringUtil.isNullOrEmpty(memberBank)) {
			return true;
		}
		return false;
	}
}




