package com.ssc.demo.service.common;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssc.demo.dao.common.CommonDao;
import com.ssc.demo.model.common.HighQuery;
import com.ssc.demo.web.ui.DataGrid;
import com.ssc.demo.web.ui.PageRequest;

import framework.generic.exception.ServiceException;
import framework.generic.paginator.domain.PageList;

@Service("commonService")
public class CommonServiceImpl implements CommonService {

	@Autowired
	private CommonDao commonDao;

	@Override
	public DataGrid getUserHighQueryDataGrid(PageRequest pageRequest) throws ServiceException {
		PageList<?> lst = commonDao.findByPage(pageRequest.getParameter(), pageRequest.getPageBounds());
		return new DataGrid(lst.getPaginator().getTotalCount(), lst);
	}

	@Override
	public void createHighQuery(List<HighQuery> highQuerys, String userId) throws ServiceException {
		int i = commonDao.insertHighQuerys(highQuerys, userId);
	}

	@Override
	public HighQuery createHighQuery(HighQuery highQuery, String userId) throws ServiceException {
		highQuery.setUserId(userId);
		commonDao.insertEntity(highQuery);
		return highQuery;
	}

	@Override
	public void removeHighQuery(HighQuery highQuery) throws ServiceException {
		commonDao.deleteEntity(highQuery);
	}

}
