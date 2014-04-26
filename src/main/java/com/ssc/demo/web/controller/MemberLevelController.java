package com.ssc.demo.web.controller;


import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;








import com.ssc.demo.model.MemberLevel;
import com.ssc.demo.service.MemberLevelService;
import com.ssc.demo.web.controller.base.AbstractController;
import com.ssc.demo.web.ui.DataGrid;
import com.ssc.demo.web.ui.Json;
import com.ssc.demo.web.ui.PageRequest;

import framework.generic.utils.string.StringUtil;
import framework.generic.utils.webutils.ServletUtil;

@Controller
@RequestMapping("memberLevel/*")
public class MemberLevelController extends AbstractController<MemberLevel, Byte> {

	private MemberLevelService memberLevelService;

	@Resource
	public void setMemberLevelService(MemberLevelService memberLevelService) {
		this.memberLevelService = memberLevelService;
	}

	/*-------------------------------列表显示页面---------------------------------*/
	@Override
	public ModelAndView index(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("ssc/memberLevel_list");
	}

	@Override
	public DataGrid dataGrid(PageRequest pageRequest, HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> paramMap = ServletUtil.getParametersMapStartingWith(request, "filter_");
		pageRequest.setParameter(paramMap);
		DataGrid dataGrid = memberLevelService.getDatagrid(pageRequest);
		return dataGrid;
	}

	/*--------------------------------添加操作-----------------------------------*/
	@Override
	public ModelAndView addFrom(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setAttribute("action", "memberLevel/insert");
		return new ModelAndView("ssc/memberLevel_edit");
	}

	@Override
	public Json insert(MemberLevel memberLevel, HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			int insertRecords = memberLevelService.create(memberLevel);
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
	public ModelAndView editForm(Byte id, HttpServletRequest request, HttpServletResponse response) throws Exception {
		MemberLevel memberLevel = memberLevelService.get(id);
		request.setAttribute("memberLevel", memberLevel);
		request.setAttribute("action", "memberLevel/update");
		return new ModelAndView("ssc/memberLevel_edit");
	}

	@Override
	public Json update(MemberLevel memberLevel, HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			int updatedRecords = memberLevelService.modify(memberLevel);
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
	public Json deleteAll(Byte[] memberLevelIds, HttpServletRequest request, HttpServletResponse response) {
		try {
			int deletedRecords = memberLevelService.removeAll(memberLevelIds);
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
	public ModelAndView view(Byte id, HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setAttribute("memberLevel", memberLevelService.get(id));
		return new ModelAndView("ssc/memberLevel_edit");
	}
	
	/*--------------------------------验证操作-----------------------------------*/
	@Override
	public boolean validatePk(Byte id, HttpServletRequest request, HttpServletResponse response) {
		MemberLevel memberLevel = memberLevelService.get(id);
		if (StringUtil.isNullOrEmpty(memberLevel)) {
			return true;
		}
		return false;
	}
}




