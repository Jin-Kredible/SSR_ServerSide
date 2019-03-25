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

	/*
	 * 앱 실행시 동작
	 * stepMapper의 todayStep(오늘 걸은 걸음수)를 통한 달성률 보여주기 / 기준:7000보
	 * user_id 통해 DB조회
	 * */
	@RequestMapping("/step.do") 
	@ResponseBody
	public ArrayList stepCounterExecute(StepVO stepVO) { 
		System.out.println("Step Ctrl execute");
		
		List<Object> weekStep = new ArrayList<Object>();
		System.out.println("get wkam : " + stepVO.getWk_am() + "user_id : " + stepVO.getUser_id());

		/* 테스트용*/
//		StepVO stepVO = new StepVO(); 
		//stepVO.setWk_am(stepVO.getWk_am());
		stepVO.setWk_am(50005);

		weekStep = stepService.getSteps(stepVO);
		System.out.println("inside contoller" + weekStep.toString());
		System.out.println(weekStep.size());
		
		return (ArrayList) weekStep; 
	}
	
	/*
	 * 미션달성확인
	 * stepMapper의 todayStep(오늘 걸은 걸음수)를 통한 달성률 보여주기 / 기준:7000보
	 * user_id 통해 DB조회
	 * */
	@RequestMapping(value="/todayGoal.do")
	@ResponseBody
	public double todayGoal(StepVO stepVO) {
		System.out.println("Step Ctrl todayGoal");
		
//		StepVO stepVO = new StepVO();
		//stepVO.setUser_id(1);
		
		System.out.println("stepvo : " + stepVO.toString());
		double goal = stepService.todayGoal(stepVO);
		System.out.println(goal);
		
		return goal;
	}
	
	/*
	 * 걸음수 가져와서 상품으로 변환
	 * stepMapper의 todayStep(오늘 걸은 걸음수) 통해 안드로이드의 상품 개수 반환
	 * user_id 통해 DB조회
	 * */
	@RequestMapping(value="/walkToGoods.do")
	@ResponseBody
	public Integer walkToGoods(StepVO stepVO) {
		System.out.println("Step Ctrl walkToGoods");
	
		/* 테스트용*/
//		StepVO stepVO = new StepVO();
		//stepVO.setUser_id(1);

		int goods = stepService.changingStep(stepVO);
		System.out.println(goods);
		
		return goods;
	}
	
	@RequestMapping(value="/visitmall.do")
	@ResponseBody
	public int visitmall(String input1, String input2) {
		System.out.println("Step Ctrl visit");
		
		/* 테스트용*/
//		MallsVO mallsVO = new MallsVO();
//		mallsVO.setUser_id(4);
//		mallsVO.setMall_id(1038);
//		mallsVO.setVi_start("2019-03-18 11:20:31");
//		mallsVO.setVi_end("2019-03-18 12:20:31");
//		System.out.println(mallsVO);
		
		return 1;
		
	}
	
	
	/*
	 * 안드로이드에서 매장방문 기록받아서 VISITS DB에 저장
	 * stepMapper의 visit(매장방문 걸음수, 비콘 찍은 시각) DB에 저장
	 * */
	@RequestMapping(value="/visit.do")
	@ResponseBody
	public void visit(MallsVO mallsVO) {
		System.out.println("Step Ctrl visit");
		System.out.println("malls_start time : " + mallsVO.getVi_end() + "malls_end time : " + mallsVO.getVi_start());
		
		/* 테스트용*/
//		MallsVO mallsVO = new MallsVO();
//		mallsVO.setUser_id(4);
//		mallsVO.setMall_id(1038);
//		mallsVO.setVi_start("2019-03-18 11:20:31");
//		mallsVO.setVi_end("2019-03-18 12:20:31");
//		System.out.println(mallsVO);
		stepService.visit(mallsVO);
		
	}
	
	
	
	
	/*
	 * 안드로이드에서 비콘찍으면 비콘정보 전달
	 * stepMapper의 selectBeaconInfo(매장ID, UUID, MAJOR, MINOR) 전달
	 * */
	@RequestMapping("/beaconInfo.do") 
	@ResponseBody
	public ArrayList<Object> beaconInfo(MallsVO mallsVO) { 
		System.out.println("Step Ctrl beaconInfo");
		System.out.println(mallsVO.toString());
		
		List<Object> beacon = new ArrayList<Object>();
		
		beacon = stepService.getBeaconInfo(mallsVO);
		System.out.println("비콘값 : " + beacon);
		return (ArrayList)beacon; 
	}
	
	
	
	
	
}
