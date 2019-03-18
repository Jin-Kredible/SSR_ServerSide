package com.sinc.ssr.ctrl;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sinc.ssr.service.SavingsService;
import com.sinc.ssr.vo.SavingsVO;

@Controller
public class SavingsCtrl {

	@Resource(name="savingsService")
	SavingsService savingsService;
	
	/*
	 * 카트에 담긴 상품 개수에 따라 포인트로 전환
	 * 안드로이드에서 numPoint(이미 *10된 값) 받아와서 Service로 넘김
	 * */
	@RequestMapping(value="/goodsToSavings.do")
	@ResponseBody
	public void goodsToSavings(String numPoint, String userid) {
		System.out.println("Step Ctrl goodsToSavings");
		
		System.out.println("numPoint : "+numPoint+"userid : "+userid);
		
		SavingsVO savingsVO = new SavingsVO();

		savingsVO.setUser_id(2);

		savingsVO.setUser_id(4);

		savingsVO.setSa_am(Integer.parseInt(numPoint));
		savingsService.updateSavings(savingsVO);
	}
	
	/*
	 * 유저의 총 포인트 조회
	 * savingsMapper의 totalSavings 조회
	 * */
	@RequestMapping(value="/totalSavings.do")
	@ResponseBody
	public int totalSavings(SavingsVO savingsVO) {
		System.out.println("Step Ctrl totalSavings");
		
//		SavingsVO savingsVO = new SavingsVO();
//		savingsVO .setUser_id(2);
		int totalSavings = (int) savingsService.totalSavings(savingsVO);

		System.out.println("totalSavings : "+totalSavings);
		return totalSavings;
	}
	
}
