package com.sinc.ssr.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinc.ssr.dao.StepDao;
import com.sinc.ssr.vo.StepVO;

@Service("stepService")
public class StepServcie {
	
	@Resource(name="stepDao")
	private StepDao stepDao;
	
	public List<Object> getSteps(StepVO stpVo) {
		List<Object> week_step = stepDao.getTotalSteps(stpVo);
		return week_step;
	}

	public double todayGoal(Object obj) {
		System.out.println("Step Service todayGoal");
		int todayStep = (Integer) stepDao.todayStep(obj);
		double goal = Math.round((todayStep/7000.0)*1000)/10.0;
		if (goal >= 100) {
			// 목표 완료하면 "완료" 보여주기
			System.out.println("todayGoal is successed!");
		}
		return goal;
	}
	
	public int changingStep(Object obj) {
		System.out.println("Step Service todayStep");
		int changingStep = (Integer) stepDao.changingStep(obj);
		int goods = changingStep/1000;
		return goods;
	}
}