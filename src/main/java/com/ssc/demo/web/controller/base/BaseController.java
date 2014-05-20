package com.ssc.demo.web.controller.base;

import java.util.HashMap;
import java.util.Map;

import framework.generic.page.PageInfo;
import framework.generic.utils.string.StringUtil;

public class BaseController {
	
	public Map<String, Object> ajaxDone(PageInfo pageInfo, Map<String, Object> paramMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pageInfo", pageInfo);
		if (!StringUtil.isNullOrEmpty(paramMap)) {

			for (Map.Entry<String, Object> entity : paramMap.entrySet()) {
				map.put(entity.getKey(), entity.getValue());
			}
		}
		return map;
	}

	public Map<String, Object> ajaxDone(PageInfo pageInfo) {
		return ajaxDone(pageInfo, new HashMap());
	}

}
