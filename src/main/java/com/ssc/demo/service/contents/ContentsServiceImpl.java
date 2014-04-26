package com.ssc.demo.service.contents;

import javax.annotation.Resource;

import com.ssc.demo.dao.contents.ContentsDao;
import com.ssc.demo.model.contents.Contents;
import com.ssc.demo.service.contents.ContentsService;
import org.springframework.stereotype.Service;

import com.ssc.demo.web.ui.DataGrid;
import com.ssc.demo.web.ui.PageRequest;

import framework.generic.paginator.domain.PageList;

@Service("contentsService")
public class ContentsServiceImpl implements ContentsService {

	private ContentsDao contentsDao;
	
	@Resource
	public void setContentsDao(ContentsDao contentsDao) {
		this.contentsDao = contentsDao;
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.pousheng.demo.service.contents.ContentsService#getDatagrid(com.pousheng.demo.web.ui.PageRequest)
	 */
	@Override
	public DataGrid getDatagrid(PageRequest pageRequest) {
		PageList<Contents> contentss = contentsDao.findByPage(pageRequest.getParameter(), pageRequest.getPageBounds());
		return new DataGrid(contentss.getPaginator().getTotalCount(), contentss);
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.pousheng.demo.service.contents.ContentsService#create(com.pousheng.demo.model.contents.Contents)
	 */
	@Override
	public Integer create(Contents contents) {
		return contentsDao.insert(contents);
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.pousheng.demo.service.contents.ContentsService#modify(com.pousheng.demo.model.contents.Contents)
	 */
	@Override
	public Integer modify(Contents contents) {
		return contentsDao.update(contents);
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.pousheng.demo.service.contents.ContentsService#remove(Integer)
	 */
	@Override
	public Integer remove(String contentsId) {
		return contentsDao.deleteByPk(contentsId);
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.pousheng.demo.service.contents.ContentsService#removeAll(Integer[])
	 */
	@Override
	public Integer removeAll(String... contentsIds) {
		return contentsDao.delete(contentsIds);
	}

	/*
	 * (non-Javadoc)
	 * @see com.pousheng.demo.service.contents.ContentsService#getByPk(Integer)
	 */
	@Override
	public Contents getByPk(String contentsId) {
		return contentsDao.findByPk(contentsId);
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.pousheng.demo.service.contents.ContentsService#get(Integer)
	 */
	@Override
	public Contents get(String contentsId) {
		return contentsDao.find(contentsId);
	}
}
