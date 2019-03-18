package com.sinc.ssr.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sinc.ssr.dao.SavingsDao;

@Service("savingsService")
public class SavingsService {
	
	@Resource(name="savingsDao")
	private SavingsDao savingsDao;
	
	public void updateSavings(Object obj) {
		System.out.println("Savings Service changingSavings");
		savingsDao.updateSavings(obj);
	}
}
	