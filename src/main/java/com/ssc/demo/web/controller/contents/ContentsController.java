package com.ssc.demo.web.controller.contents;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ssc.demo.model.contents.Contents;
import com.ssc.demo.service.contents.ContentsService;
import com.ssc.demo.web.controller.base.AbstractController;
import com.ssc.demo.web.ui.DataGrid;
import com.ssc.demo.web.ui.Json;
import com.ssc.demo.web.ui.PageRequest;
import com.ssc.demo.web.util.CommonUtil;

import framework.generic.utils.string.StringUtil;
import framework.generic.utils.webutils.ServletUtil;

/**
 * 内容
 */
@Controller
@RequestMapping("contents/*")
public class ContentsController extends AbstractController<Contents, String> {

	private ContentsService contentsService;


	@Resource
	public void setContentsService(ContentsService contentsService) {
		this.contentsService = contentsService;
	}


	/*-------------------------------列表显示页面---------------------------------*/
	@Override
	public ModelAndView index(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("contents/contents_list");
	}

	@Override
	public DataGrid dataGrid(PageRequest pageRequest, HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> paramMap = ServletUtil.getParametersMapStartingWith(request, "filter_");
		pageRequest.setParameter(paramMap);
		DataGrid dataGrid = contentsService.getDatagrid(pageRequest);
		return dataGrid;
	}

	/*--------------------------------添加操作-----------------------------------*/
	@Override
	public ModelAndView addFrom(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setAttribute("action", "contents/insert");
		return new ModelAndView("contents/contents_edit");
	}

	

	/*--------------------------------验证操作-----------------------------------*/
	@Override
	public boolean validatePk(String contentsId, HttpServletRequest request, HttpServletResponse response) {
		Contents contents = contentsService.get(contentsId);
		if (StringUtil.isNullOrEmpty(contents)) {
			return true;
		}
		return false;
	}
}
