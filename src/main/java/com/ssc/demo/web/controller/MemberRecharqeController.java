package com.ssc.demo.web.controller;


import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ssc.demo.model.MemberRecharqe;
import com.ssc.demo.service.MemberRecharqeService;
import com.ssc.demo.web.controller.base.AbstractController;
import com.ssc.demo.web.ui.DataGrid;
import com.ssc.demo.web.ui.Json;
import com.ssc.demo.web.ui.PageRequest;

import framework.generic.utils.string.StringUtil;
import framework.generic.utils.webutils.ServletUtil;

@Controller
@RequestMapping("memberRecharqe/*")
public class MemberRecharqeController extends AbstractController<MemberRecharqe, Integer> {

	private MemberRecharqeService memberRecharqeService;

	@Resource
	public void setMemberRecharqeService(MemberRecharqeService memberRecharqeService) {
		this.memberRecharqeService = memberRecharqeService;
	}

	/*-------------------------------列表显示页面---------------------------------*/
	@Override
	public ModelAndView index(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("ssc/memberRecharqe_list");
	}

	@Override
	public DataGrid dataGrid(PageRequest pageRequest, HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> paramMap = ServletUtil.getParametersMapStartingWith(request, "filter_");
		pageRequest.setParameter(paramMap);
		DataGrid dataGrid = memberRecharqeService.getDatagrid(pageRequest);
		return dataGrid;
	}

	/*--------------------------------添加操作-----------------------------------*/
	@Override
	public ModelAndView addFrom(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setAttribute("action", "memberRecharqe/insert");
		return new ModelAndView("ssc/memberRecharqe_edit");
	}

	@Override
	public Json insert(MemberRecharqe memberRecharqe, HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			int insertRecords = memberRecharqeService.create(memberRecharqe);
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
		MemberRecharqe memberRecharqe = memberRecharqeService.get(id);
		request.setAttribute("memberRecharqe", memberRecharqe);
		request.setAttribute("action", "memberRecharqe/update");
		return new ModelAndView("ssc/memberRecharqe_edit");
	}

	@Override
	public Json update(MemberRecharqe memberRecharqe, HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			int updatedRecords = memberRecharqeService.modify(memberRecharqe);
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
	public Json deleteAll(Integer[] memberRecharqeIds, HttpServletRequest request, HttpServletResponse response) {
		try {
			int deletedRecords = memberRecharqeService.removeAll(memberRecharqeIds);
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
		request.setAttribute("memberRecharqe", memberRecharqeService.get(id));
		return new ModelAndView("ssc/memberRecharqe_edit");
	}
	
	/*--------------------------------验证操作-----------------------------------*/
	@Override
	public boolean validatePk(Integer id, HttpServletRequest request, HttpServletResponse response) {
		MemberRecharqe memberRecharqe = memberRecharqeService.get(id);
		if (StringUtil.isNullOrEmpty(memberRecharqe)) {
			return true;
		}
		return false;
	}
}




