package com.sinc.ssr.dao;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.sinc.ssr.vo.MallsVO;
import com.sinc.ssr.vo.SavingsVO;

@Repository("savingsDao")
public class SavingsDao {
	
	@Resource(name="sqlSession")
	private SqlSession session;
	
	public void updateSavings(Object obj) {
		System.out.println("Savings Dao updateSavings");
		int visitWalk_None = session.selectOne("com.sinc.ssr.mybatis.savings.checkVisitNone", obj);// 매장방문 여부 조회
		if (visitWalk_None != 0) {
			int visitWalk = session.selectOne("com.sinc.ssr.mybatis.savings.checkVisit",obj); //매장방문시, 걸은 걸음 조회
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

	public int changeMoney(Object obj) {
		System.out.println("Savings Dao totalSavings");
		
		int totalConverted = session.selectOne("com.sinc.ssr.mybatis.savings.selectTotalSavings", obj);
		System.out.println("total converted" + totalConverted + "user Id : " +obj.toString());;
		
		int totalSavings = session.selectOne("com.sinc.ssr.mybatis.savings.selectTotalSavings", obj);
		if (totalSavings != 0) { //총포인트가 0이 아닐때 쓱머니전환
			session.update("com.sinc.ssr.mybatis.savings.changingMoney", obj); //쓱머니로 전환(모든 포인트액 0으로 수정)
		}else {
			System.out.println("전환할 포인트가 없습니다.");
		}
		
		return totalConverted;
		
	}
}
