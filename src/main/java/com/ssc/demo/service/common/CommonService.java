package com.ssc.demo.service.common;

import java.util.List;

import com.ssc.demo.model.common.HighQuery;
import com.ssc.demo.web.ui.DataGrid;
import com.ssc.demo.web.ui.PageRequest;

import framework.generic.exception.ServiceException;

public interface CommonService {

	DataGrid getUserHighQueryDataGrid(PageRequest pageRequest) throws ServiceException;

	void createHighQuery(List<HighQuery> highQuerys, String userId) throws ServiceException;

	HighQuery createHighQuery(HighQuery highQuery, String userId) throws ServiceException;

	void removeHighQuery(HighQuery highQuery) throws ServiceException;
}
