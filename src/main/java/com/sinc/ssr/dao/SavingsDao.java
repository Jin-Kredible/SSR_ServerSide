package com.sinc.ssr.dao;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository("savingsDao")
public class SavingsDao {
	
	@Resource(name="sqlSession")
	private SqlSession session;
	
	public void updateSavings(Object obj) {
		System.out.println("Savings Dao updateSavings");
		
		session.update("com.sinc.ssr.mybatis.savings.updateSavings", obj); //포인트 적립
		session.update("com.sinc.ssr.mybatis.savings.changedSavings",obj); //전환포인트 - 전환걸음 수정
		System.out.println("update wk_Sa"); 
	}
}
