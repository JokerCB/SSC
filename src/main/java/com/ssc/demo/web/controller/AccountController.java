package com.ssc.demo.web.controller;


import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ssc.demo.model.Account;
import com.ssc.demo.service.AccountService;
import com.ssc.demo.web.controller.base.AbstractController;
import com.ssc.demo.web.ui.DataGrid;
import com.ssc.demo.web.ui.Json;
import com.ssc.demo.web.ui.PageRequest;

import framework.generic.utils.string.StringUtil;
import framework.generic.utils.webutils.ServletUtil;

@Controller
@RequestMapping("account/*")
public class AccountController extends AbstractController<Account, Integer> {

	private AccountService accountService;

	@Resource
	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}

	/*-------------------------------列表显示页面---------------------------------*/
	@Override
	public ModelAndView index(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("ssc/account_list");
	}

	@Override
	public DataGrid dataGrid(PageRequest pageRequest, HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> paramMap = ServletUtil.getParametersMapStartingWith(request, "filter_");
		pageRequest.setParameter(paramMap);
		DataGrid dataGrid = accountService.getDatagrid(pageRequest);
		return dataGrid;
	}

	/*--------------------------------添加操作-----------------------------------*/
	@Override
	public ModelAndView addFrom(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setAttribute("action", "account/insert");
		return new ModelAndView("ssc/account_edit");
	}

	@Override
	public Json insert(Account account, HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			int insertRecords = accountService.create(account);
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
	public ModelAndView editForm(Integer uid, HttpServletRequest request, HttpServletResponse response) throws Exception {
		Account account = accountService.get(uid);
		request.setAttribute("account", account);
		request.setAttribute("action", "account/update");
		return new ModelAndView("ssc/account_edit");
	}

	@Override
	public Json update(Account account, HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			int updatedRecords = accountService.modify(account);
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
	public Json deleteAll(Integer[] accountIds, HttpServletRequest request, HttpServletResponse response) {
		try {
			int deletedRecords = accountService.removeAll(accountIds);
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
	public ModelAndView view(Integer uid, HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setAttribute("account", accountService.get(uid));
		return new ModelAndView("ssc/account_edit");
	}
	
	/*--------------------------------验证操作-----------------------------------*/
	@Override
	public boolean validatePk(Integer uid, HttpServletRequest request, HttpServletResponse response) {
		Account account = accountService.get(uid);
		if (StringUtil.isNullOrEmpty(account)) {
			return true;
		}
		return false;
	}
}




