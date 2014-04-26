package com.ssc.demo.web.controller;


import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ssc.demo.model.MemberSession;
import com.ssc.demo.service.MemberSessionService;
import com.ssc.demo.web.controller.base.AbstractController;
import com.ssc.demo.web.ui.DataGrid;
import com.ssc.demo.web.ui.Json;
import com.ssc.demo.web.ui.PageRequest;

import framework.generic.utils.string.StringUtil;
import framework.generic.utils.webutils.ServletUtil;

@Controller
@RequestMapping("memberSession/*")
public class MemberSessionController extends AbstractController<MemberSession, Integer> {

	private MemberSessionService memberSessionService;

	@Resource
	public void setMemberSessionService(MemberSessionService memberSessionService) {
		this.memberSessionService = memberSessionService;
	}

	/*-------------------------------列表显示页面---------------------------------*/
	@Override
	public ModelAndView index(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("ssc/memberSession_list");
	}

	@Override
	public DataGrid dataGrid(PageRequest pageRequest, HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> paramMap = ServletUtil.getParametersMapStartingWith(request, "filter_");
		pageRequest.setParameter(paramMap);
		DataGrid dataGrid = memberSessionService.getDatagrid(pageRequest);
		return dataGrid;
	}

	/*--------------------------------添加操作-----------------------------------*/
	@Override
	public ModelAndView addFrom(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setAttribute("action", "memberSession/insert");
		return new ModelAndView("ssc/memberSession_edit");
	}

	@Override
	public Json insert(MemberSession memberSession, HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			int insertRecords = memberSessionService.create(memberSession);
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
		MemberSession memberSession = memberSessionService.get(id);
		request.setAttribute("memberSession", memberSession);
		request.setAttribute("action", "memberSession/update");
		return new ModelAndView("ssc/memberSession_edit");
	}

	@Override
	public Json update(MemberSession memberSession, HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			int updatedRecords = memberSessionService.modify(memberSession);
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
	public Json deleteAll(Integer[] memberSessionIds, HttpServletRequest request, HttpServletResponse response) {
		try {
			int deletedRecords = memberSessionService.removeAll(memberSessionIds);
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
		request.setAttribute("memberSession", memberSessionService.get(id));
		return new ModelAndView("ssc/memberSession_edit");
	}
	
	/*--------------------------------验证操作-----------------------------------*/
	@Override
	public boolean validatePk(Integer id, HttpServletRequest request, HttpServletResponse response) {
		MemberSession memberSession = memberSessionService.get(id);
		if (StringUtil.isNullOrEmpty(memberSession)) {
			return true;
		}
		return false;
	}
}




