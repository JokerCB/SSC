package com.ssc.demo.service;

import java.util.List;

import com.ssc.demo.model.Bank;
/**
 * 银行信息-Service接口类
 */
public interface BankService {
	
	List<Bank> findByIsMember();
}
