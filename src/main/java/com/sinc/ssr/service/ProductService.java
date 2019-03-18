package com.sinc.ssr.service;

import static org.hamcrest.CoreMatchers.nullValue;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sinc.ssr.dao.ProductDao;
import com.sinc.ssr.vo.ProductVO;

@Service("productService")
public class ProductService {
	
	@Resource(name="productDao")
	private ProductDao productDao;
	
	
	public ArrayList<Object> getRecomProducts() {
		
		Random rand = new Random();
		/*
		 * int randomAge = (int)(Math.random()*((6-1)+1)+1)*10; 
		 * int randomGender = rand.nextInt(2);
		 */
		int currentTime = LocalDateTime.now().getHour();
		
		if(currentTime > 7 && currentTime <=10) {
			currentTime = 1;
		} else if (currentTime > 10 && currentTime <= 13) {
			currentTime = 2;
		} else if (currentTime > 13 && currentTime <= 17) {
			currentTime = 3;
		} else if (currentTime > 17 && currentTime <= 20) {
			currentTime = 4;
		} else {
			currentTime = 5;
		} 
		
		int randomTrend = (int)rand.nextInt(3);
		System.out.println("randomTrend" + randomTrend);
		
		ProductVO productVo = new ProductVO();
		productVo.setAge(20);
		productVo.setGender(1);
		
		/* productVo.setTime(currentTime); */
		//Testing 구문
		productVo.setTime(5);
		
		
		ArrayList<Object> productList = productDao.getProductsByUser(productVo, randomTrend);
		
		
		return productList;
	}	
	
}
