package com.sinc.ssr.dao;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository("savingsDao")
public class SavingsDao {
	
	@Resource(name="sqlSession")
	private SqlSession session;
	
	public Object updateSavings(Object obj) {
		System.out.println("Savings Dao updateSavings");
		return session.update("com.sinc.ssr.mybatis.savings.updateSavings", obj);
	}
}
