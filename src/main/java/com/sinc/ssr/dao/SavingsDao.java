package com.sinc.ssr.dao;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.sinc.ssr.vo.SavingsVO;

@Repository("savingsDao")
public class SavingsDao {
	
	@Resource(name="sqlSession")
	private SqlSession session;
	
	public void updateSavings(Object obj) {
		System.out.println("Savings Dao updateSavings");
		int visitWalk_None = session.selectOne("com.sinc.ssr.mybatis.savings.checkVisitNone", obj);// 매장방문 여부 조회
		if (visitWalk_None != 0) {
			int visitWalk = session.selectOne("com.sinc.ssr.mabatis.saings.checkVisit",obj); //매장방문시, 걸은 걸음 조회
			session.update("com.sinc.ssr.mybatis.savings.changedSavings", obj); //전환포인트(전환걸음, WK_SA) 수정
			int savings = visitWalk/100 + ((SavingsVO) obj).getSa_am() ;
			((SavingsVO)obj).setSa_am(savings);
			session.update("com.sinc.ssr.mybatis.savings.updateSavings", obj); //매장걸음 + 기본포인트 적립
		}else {
			System.out.println("inside else");
			session.update("com.sinc.ssr.mybatis.savings.changedSavings", obj); //전환포인트(전환걸음, WK_SA) 수정
			session.update("com.sinc.ssr.mybatis.savings.updateSavings", obj); //기본포인트 적립
		}
	}

	public Object totalSavings(Object obj) {
		System.out.println("Savings Dao totalSavings");
		return session.selectOne("com.sinc.ssr.mybatis.savings.selectTotalSavings", obj);
	}
}
