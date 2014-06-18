package com.ssc.demo.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ssc.demo.dao.AdminBankDao;
import com.ssc.demo.dao.AreaDao;
import com.ssc.demo.dao.BankDao;
import com.ssc.demo.model.AdminBank;
import com.ssc.demo.model.Bank;
import com.ssc.demo.model.City;
import com.ssc.demo.model.Province;
import com.ssc.demo.web.ui.DataGrid;
import com.ssc.demo.web.ui.PageRequest;

import framework.generic.paginator.domain.PageList;

@Service("adminBankService")
public class AdminBankServiceImpl implements AdminBankService {

	private AdminBankDao adminBankDao;
	
	@Resource
	private BankDao bankDao;
	
	@Resource
	private AreaDao areaDao;
	@Resource
	public void setAdminBankDao(AdminBankDao adminBankDao) {
		this.adminBankDao = adminBankDao;
	}
	
	/*
	 * (non-Javadoc)
	 * @see qya.demo.service.com.ssc.demo.AdminBankService#getDatagrid(qya.demo.web.ui.PageRequest)
	 */
	@Override
	public DataGrid getDatagrid(PageRequest pageRequest) {
		PageList<AdminBank> adminBanks = adminBankDao.findByPage(pageRequest.getParameter(), pageRequest.getPageBounds());
		return new DataGrid(adminBanks.getPaginator().getTotalCount(), adminBanks);
	}
	
	/*
	 * (non-Javadoc)
	 * @see qya.demo.service.com.ssc.demo.AdminBankService#create(qya.demo.model.com.ssc.demo.AdminBank)
	 */
	@Override
	public Integer create(AdminBank adminBank) {
		return adminBankDao.insert(adminBank);
	}
	
	/*
	 * (non-Javadoc)
	 * @see qya.demo.service.com.ssc.demo.AdminBankService#modify(qya.demo.model.com.ssc.demo.AdminBank)
	 */
	@Override
	public Integer modify(AdminBank adminBank) {
		return adminBankDao.update(adminBank);
	}
	
	/*
	 * (non-Javadoc)
	 * @see qya.demo.service.com.ssc.demo.AdminBankService#remove(Integer)
	 */
	@Override
	public Integer remove(Integer id) {
		return adminBankDao.deleteByPk(id);
	}
	
	/*
	 * (non-Javadoc)
	 * @see qya.demo.service.com.ssc.demo.AdminBankService#removeAll(Integer[])
	 */
	@Override
	public Integer removeAll(Integer... adminBankIds) {
		return adminBankDao.delete(adminBankIds);
	}

	/*
	 * (non-Javadoc)
	 * @see qya.demo.service.com.ssc.demo.AdminBankService#getByPk(Integer)
	 */
	@Override
	public AdminBank getByPk(Integer id) {
		return adminBankDao.findByPk(id);
	}
	
	/*
	 * (non-Javadoc)
	 * @see qya.demo.service.com.ssc.demo.AdminBankService#get(Integer)
	 */
	@Override
	public AdminBank get(Integer id) {
		return adminBankDao.find(id);
	}
	
	@Override
	public List<Bank> findList(){
		return bankDao.findList();
	}

	@Override
	public List<Province> findProvinces() {
		
		return areaDao.findProvinces();
	}

	@Override
	public List<City> findCitys(String fprovinceid) {
	
		return areaDao.findCitys(fprovinceid);
	}

	@Override
	public PageList<Map> findDataByPage(PageRequest pageRequest) {
		PageList<Map> dataMap=adminBankDao.findDataByPage(pageRequest.getParameter(), pageRequest.getPageBounds());
		return dataMap;
	}

	@Override
	public Integer deleteByPk(Integer id) {
		
		return adminBankDao.deleteByPk(id);
	}

	@Override
	public Integer findUnique(Integer id,String userName, Integer bankId, String account) {
		
		return adminBankDao.findUnique(id,userName, bankId, account);
	}

	public List<Map> findAdminBanks(){
		return adminBankDao.findAdminBanks();
	}
	
}
