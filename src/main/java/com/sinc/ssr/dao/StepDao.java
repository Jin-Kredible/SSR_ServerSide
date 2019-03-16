package com.sinc.ssr.dao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.sinc.ssr.vo.StepVO;

@Repository("stepDao")
public class StepDao {
	
	@Resource(name="sqlSession")
	private SqlSession session;
	
	public List<Object> getTotalSteps(StepVO stepVO) {
		List<Object> week_steps = session.selectList("com.sinc.ssr.mybatis.step.retrvStep",stepVO);
		/*
		 * session.insert("com.sinc.ssr.mybatis.step.insertStep",stpVo);
		 */
		String walk_date = session.selectOne("com.sinc.ssr.mybatis.step.firstStep", stepVO);
		if(walk_date == null) {
			session.insert("com.sinc.ssr.mybatis.step.insertStep",stepVO);
		}else {
			session.update("com.sinc.ssr.mybatis.step.updateStep", stepVO);
		}
		System.out.println("UserINFO" + week_steps);
		return  week_steps;
	}

	public Object todayStep(Object obj) {
		System.out.println("Step Dao todayGoal");
		return session.selectOne("com.sinc.ssr.mybatis.step.todayStep", obj);
	}

	public Object changingStep(Object obj) {
		System.out.println("Step Dao changingStep");
		return session.selectOne("com.sinc.ssr.mybatis.step.changingStep", obj);
	}
	
}
