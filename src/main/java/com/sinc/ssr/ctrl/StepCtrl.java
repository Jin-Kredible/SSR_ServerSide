package com.sinc.ssr.ctrl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sinc.ssr.service.StepServcie;
import com.sinc.ssr.vo.MallsVO;
import com.sinc.ssr.vo.StepVO;

@Controller
public class StepCtrl {
	
	@Resource(name="stepService")
	StepServcie stepService;

	@RequestMapping("/step.do") 
	@ResponseBody
	public ArrayList androidTestWithRequestAndResponse(String steps, String userno) { 
		System.out.println("Step Ctrl execute");
		System.out.println("steps" + steps + "userid" + userno);
		List<Object> weekStep = new ArrayList<Object>();
		
		StepVO stepVO = new StepVO();
		
		stepVO.setWk_am(Integer.parseInt(steps));
		stepVO.setUser_id(4);
		
		weekStep = stepService.getSteps(stepVO);
		System.out.println("inside contoller" + weekStep.toString());
		System.out.println(weekStep.size());
		
		return (ArrayList)weekStep; 
	}
	
	/*
	 * 미션달성확인
	 * stepMapper의 todayStep(오늘 걸은 걸음수)를 통한 달성률 보여주기 / 기준:7000보
	 * */
	@RequestMapping(value="/todayGoal.do")
	@ResponseBody
	public double todayGoal() {
		System.out.println("Step Ctrl todayGoal");
		
		StepVO stepVO = new StepVO();
		stepVO.setUser_id(4);
		
		double goal = stepService.todayGoal(stepVO);
		System.out.println(goal);
		
		return goal;
	}
	
	/*
	 * 걸음수 가져와서 상품으로 변환
	 * stepMapper의 todayStep(오늘 걸은 걸음수) 통해 안드로이드의 상품 개수 반환
	 * */
	@RequestMapping(value="/walkToGoods.do")
	@ResponseBody
	public int walkToGoods() {
		System.out.println("Step Ctrl walkToGoods");
		
		StepVO stepVO = new StepVO();

		stepVO.setUser_id(2);

		stepVO.setUser_id(4);

		
		int goods = stepService.changingStep(stepVO);
		System.out.println(goods);
		
		return goods;
	}
	
	/*
	 * 안드로이드에서 매장방문 기록받아서 VISITS DB에 저장
	 * stepMapper의 visit(매장방문 걸음수, 비콘 찍은 시각) DB에 저장
	 * */
	@RequestMapping(value="/visit.do")
	@ResponseBody
	public void visit(MallsVO mallsVO) {
		System.out.println("Step Ctrl visit");
		
//		MallsVO mallsVO = new MallsVO();
//		mallsVO.setUser_id(4);
//		mallsVO.setMall_id(1038);
//		mallsVO.setVi_start("2019-03-18 11:20:31");
//		mallsVO.setVi_end("2019-03-18 12:20:31");
//		System.out.println(mallsVO);
		stepService.visit(mallsVO);
		
	}
}
