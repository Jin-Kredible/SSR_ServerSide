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
	public void goodsToSavings(String numPoint) {
		System.out.println("Step Ctrl goodsToSavings");
		
		SavingsVO savingsVO = new SavingsVO();
		savingsVO.setSa_am(Integer.parseInt(numPoint));
		
		/* 테스트용 */
		//savingsVO.setUser_id(1);

		System.out.println("numPoint:"+numPoint+"userid:"+savingsVO.getUser_id());
		
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
		
		/* 테스트용 */
//		SavingsVO savingsVO = new SavingsVO();
<<<<<<< HEAD
		//savingsVO .setUser_id(1);
=======
		savingsVO .setUser_id(2);
>>>>>>> branch 'master' of https://github.com/jinwkim90/SSR_ServerSide.git
		
	
		int totalSavings = (int) savingsService.totalSavings(savingsVO);
		System.out.println("totalSavings : "+totalSavings);
		
		return totalSavings;
	}
	
	/*
	 * 쓱머니 전환
	 * 유저의 포인트테이블의 SA_AM을 모두 0
	 * savingsMapper의 changeMoney로 수정
	 * */
	@RequestMapping(value="/changeMoney.do")
	@ResponseBody
	public void changingMoney(SavingsVO savingsVO) {
		System.out.println("Step Ctrl changingMoney");
		
		/* 테스트용 */
//		SavingsVO savingsVO = new SavingsVO();
		savingsVO .setUser_id(2);
		savingsService.changeMoney(savingsVO);
		System.out.println("전환되었습니다");
		
	}
}
