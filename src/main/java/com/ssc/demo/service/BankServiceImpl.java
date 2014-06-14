package com.ssc.demo.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ssc.demo.dao.BankDao;
import com.ssc.demo.model.Bank;
/**
 * 银行信息-Service实现类
 */
@Service("BankListService")
public class BankServiceImpl implements BankService {

	@Resource
	private BankDao bankDao;
	
	
	@Override
	public List<Bank> findByIsMember() {
		return bankDao.findByIsMember();
	}
}
