package com.sinc.ssr.dao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.sinc.ssr.vo.MallsVO;
import com.sinc.ssr.vo.ProductVO;
import com.sinc.ssr.vo.SavingsVO;
import com.sinc.ssr.vo.StepVO;

@Repository("stepDao")
public class StepDao {
	
	@Resource(name="sqlSession")
	private SqlSession session;
	
	public List<Object> getTotalSteps(StepVO stepVO) {
		List<Object> week_steps = session.selectList("com.sinc.ssr.mybatis.step.retrvStep", stepVO);
		
		String walk_date = session.selectOne("com.sinc.ssr.mybatis.step.firstStep", stepVO);
//		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>  walk date      "+walk_date);
		if(walk_date == null || walk_date == "") {
			/* 일자별 걸음 최초 행 추가*/
			session.insert("com.sinc.ssr.mybatis.step.insertStep", stepVO);
			/* 일자별 포인트 최초 행 추가*/
			SavingsVO savingsVO = new SavingsVO();
			savingsVO.setUser_id(stepVO.getUser_id());
			int i  = session.insert("com.sinc.ssr.mybatis.savings.insertSavings", savingsVO); 
			System.out.println("insert point" + i);
		}else {
			session.update("com.sinc.ssr.mybatis.step.updateStep", stepVO);
		}
		System.out.println("UserINFO" + week_steps);
		return  week_steps;
	}

	public Object todayStep(Object obj) {
		System.out.println("Step Dao todayGoal");
		System.out.println("todayStep dao: " + obj);
		/*
		  ProductVO productVo2 = new ProductVO(); 
		  for(int i =1; i < 93; i++) {
		  
		  String path = "/recomproducts/"; 
		  path = path + Integer.toString(i) +".jpg";
		  System.out.println("path" + path);
		  
		  productVo2.setItem_img_path(path); 
		  productVo2.setAge(i);
		
		  session.update("com.sinc.ssr.mybatis.product.updateRows",productVo2); 
		  }
		 */
		return session.selectOne("com.sinc.ssr.mybatis.step.todayStep", obj);
	}

	public Object changingStep(Object obj) {
		System.out.println("Step Dao changingStep");
		return session.selectOne("com.sinc.ssr.mybatis.step.changingStep", obj);
	}
	
	public void visit(Object obj) {
		System.out.println("Step Dao visit");
		session.insert("com.sinc.ssr.mybatis.step.visit", obj);
	}

	public List<Object> getBeaconInfo(MallsVO mallsVO) {
		List<Object> beaconInfo = session.selectList("com.sinc.ssr.mybatis.step.selectBeaconInfo", mallsVO);
		return beaconInfo;
	}
	
}
