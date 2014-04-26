package com.ssc.demo.web.controller.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssc.demo.constant.CommonConstant;
import com.ssc.demo.model.common.HighQuery;
import com.ssc.demo.service.common.CommonService;
import com.ssc.demo.web.controller.base.MessageController;
import com.ssc.demo.web.ui.CommonColumn;
import com.ssc.demo.web.ui.DataGrid;
import com.ssc.demo.web.ui.Json;
import com.ssc.demo.web.ui.PageRequest;
import com.ssc.demo.web.util.CommonUtil;
import com.ssc.demo.web.util.SessionUtil;

import framework.generic.exception.ServiceException;
import framework.generic.extension.log.ExceptionUtil;
import framework.generic.mvc.annotation.RequestJsonParam;
import framework.generic.utils.json.JsonUtil;
import framework.generic.utils.properties.PropertiesUtil;
import framework.generic.utils.webutils.ServletUtil;

@Controller
@RequestMapping("common/*")
public class CommonController extends MessageController {

	@Autowired
	private CommonService commonService;

	/*-------------------------------列表显示页面---------------------------------*/
	@RequestMapping(value = "selectIndex", method = { RequestMethod.GET, RequestMethod.POST })
	public String selectIndex(HttpServletRequest request, @RequestJsonParam("columnJson") List<CommonColumn> columns) {
		request.setAttribute("columns", columns);
		return "common/common_list";
	}

	/*-------------------------------Grid和Tree显示页面---------------------------------*/
	@RequestMapping(value = "selectGridTreeIndex", method = { RequestMethod.GET, RequestMethod.POST })
	public String selectGridTreeIndex(HttpServletRequest request, @RequestJsonParam("columnJson") List<CommonColumn> columns) {
		request.setAttribute("columns", columns);
		return "common/common_grid_tree";
	}

	@RequestMapping(value = "getI18N", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public Map<String, Object> getI18N(@RequestParam(value = "prefix", defaultValue = "") String prefix) {
		return PropertiesUtil.getPropMapStartingWith(prefix, "i18n/messages_" + getLocale() + ".properties");
	}

	@RequestMapping(value = "userIndex", method = { RequestMethod.GET, RequestMethod.POST })
	public String userIndex(HttpServletRequest request) {
		return "common/common_user_list";
	}

	@RequestMapping(value = "highQueryIndex", method = { RequestMethod.GET, RequestMethod.POST })
	public String highQueryIndex(HttpServletRequest request) {
		return "common/high_query";
	}

	@RequestMapping(value = "getUserHighQueryDataGrid", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public DataGrid getUserHighQueryDataGrid(PageRequest pageRequest, HttpServletRequest request) {
		Map<String, Object> paramMap = ServletUtil.getParametersMapStartingWith(request, "filter_");
		pageRequest.setParameter(paramMap);
		return commonService.getUserHighQueryDataGrid(pageRequest);
	}


	@RequestMapping(value = "deleteCondition", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public Json deleteCondition(HighQuery highQuery, HttpServletRequest request) {
		try {
			commonService.removeHighQuery(highQuery);
		} catch (ServiceException e) {
			e.printStackTrace();
			return new Json(getMessage("msg.error.delete"));
		}
		return new Json(getMessage("msg.success.delete"));
	}

}