package com.ssc.demo.web.controller;


import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ssc.demo.model.Members;
import com.ssc.demo.service.MembersService;
import com.ssc.demo.web.controller.base.AbstractController;
import com.ssc.demo.web.ui.DataGrid;
import com.ssc.demo.web.ui.Json;
import com.ssc.demo.web.ui.PageRequest;

import framework.generic.utils.string.StringUtil;
import framework.generic.utils.webutils.ServletUtil;

@Controller
@RequestMapping("members/*")
public class MembersController extends AbstractController<Members, Integer> {

	private MembersService membersService;

	@Resource
	public void setMembersService(MembersService membersService) {
		this.membersService = membersService;
	}

	/*-------------------------------列表显示页面---------------------------------*/
	@Override
	public ModelAndView index(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("ssc/members_list");
	}

	@Override
	public DataGrid dataGrid(PageRequest pageRequest, HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> paramMap = ServletUtil.getParametersMapStartingWith(request, "filter_");
		pageRequest.setParameter(paramMap);
		DataGrid dataGrid = membersService.getDatagrid(pageRequest);
		return dataGrid;
	}

	/*--------------------------------添加操作-----------------------------------*/
	@Override
	public ModelAndView addFrom(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setAttribute("action", "members/insert");
		return new ModelAndView("ssc/members_edit");
	}

	@Override
	public Json insert(Members members, HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			int insertRecords = membersService.create(members);
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
	public ModelAndView editForm(Integer mid, HttpServletRequest request, HttpServletResponse response) throws Exception {
		Members members = membersService.load(mid);
		request.setAttribute("members", members);
		request.setAttribute("action", "members/update");
		return new ModelAndView("ssc/members_edit");
	}

	@Override
	public Json update(Members members, HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			int updatedRecords = membersService.modify(members);
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
	public Json deleteAll(Integer[] membersIds, HttpServletRequest request, HttpServletResponse response) {
		try {
			int deletedRecords = membersService.removeAll(membersIds);
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
	public ModelAndView view(Integer mid, HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setAttribute("members", membersService.load(mid));
		return new ModelAndView("ssc/members_edit");
	}
	
	/*--------------------------------验证操作-----------------------------------*/
	@Override
	public boolean validatePk(Integer mid, HttpServletRequest request, HttpServletResponse response) {
		Members members = membersService.load(mid);
		if (StringUtil.isNullOrEmpty(members)) {
			return true;
		}
		return false;
	}
}




