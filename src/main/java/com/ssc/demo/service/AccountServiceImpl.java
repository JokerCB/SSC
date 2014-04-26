package com.ssc.demo.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;






import com.ssc.demo.dao.AccountDao;
import com.ssc.demo.model.Account;
import com.ssc.demo.web.ui.DataGrid;
import com.ssc.demo.web.ui.PageRequest;

import framework.generic.paginator.domain.PageList;

@Service("accountService")
public class AccountServiceImpl implements AccountService {

	private AccountDao accountDao;
	
	@Resource
	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}
	
	/*
	 * (non-Javadoc)
	 * @see qya.demo.service.ssc.AccountService#getDatagrid(qya.demo.web.ui.PageRequest)
	 */
	@Override
	public DataGrid getDatagrid(PageRequest pageRequest) {
		PageList<Account> accounts = accountDao.findByPage(pageRequest.getParameter(), pageRequest.getPageBounds());
		return new DataGrid(accounts.getPaginator().getTotalCount(), accounts);
	}
	
	/*
	 * (non-Javadoc)
	 * @see qya.demo.service.ssc.AccountService#create(qya.demo.model.ssc.Account)
	 */
	@Override
	public Integer create(Account account) {
		return accountDao.insert(account);
	}
	
	/*
	 * (non-Javadoc)
	 * @see qya.demo.service.ssc.AccountService#modify(qya.demo.model.ssc.Account)
	 */
	@Override
	public Integer modify(Account account) {
		return accountDao.update(account);
	}
	
	/*
	 * (non-Javadoc)
	 * @see qya.demo.service.ssc.AccountService#remove(Integer)
	 */
	@Override
	public Integer remove(Integer uid) {
		return accountDao.deleteByPk(uid);
	}
	
	/*
	 * (non-Javadoc)
	 * @see qya.demo.service.ssc.AccountService#removeAll(Integer[])
	 */
	@Override
	public Integer removeAll(Integer... accountIds) {
		return accountDao.delete(accountIds);
	}

	/*
	 * (non-Javadoc)
	 * @see qya.demo.service.ssc.AccountService#getByPk(Integer)
	 */
	@Override
	public Account getByPk(Integer uid) {
		return accountDao.findByPk(uid);
	}
	
	/*
	 * (non-Javadoc)
	 * @see qya.demo.service.ssc.AccountService#get(Integer)
	 */
	@Override
	public Account get(Integer uid) {
		return accountDao.find(uid);
	}
}
