package com.sinc.ssr.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sinc.ssr.dao.SavingsDao;
import com.sinc.ssr.vo.SavingsVO;

@Service("savingsService")
public class SavingsService {
	
	@Resource(name="savingsDao")
	private SavingsDao savingsDao;
	
	public void updateSavings(Object obj) {
		System.out.println("Savings Service changingSavings");
		savingsDao.updateSavings(obj);
	}

	public Object totalSavings(Object obj) {
		System.out.println("Savings Service totalSavings");
		return savingsDao.totalSavings(obj);
	}
}
	